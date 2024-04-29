import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.*;
import git.tools.client.GitSubprocessClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {

        JFrame window = new JFrame("GitRepoCreator");
        window.setSize(400, 500);
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(25, 50, 80, 30);
        mainPanel.add(usernameLabel);
        JTextField username = new JTextField();
        username.setBounds(100, 50, 200, 30);
        mainPanel.add(username);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(25, 100, 80, 30);
        mainPanel.add(passwordLabel);
        JPasswordField password = new JPasswordField();
        password.setBounds(100, 100, 200, 30);
        mainPanel.add(password);

        JLabel filepathLabel = new JLabel("Project Path:");
        filepathLabel.setBounds(25, 150, 80, 30);
        mainPanel.add(filepathLabel);
        JTextField filepath = new JTextField();
        filepath.setBounds(100, 150, 200, 30);
        mainPanel.add(filepath);

        JLabel reponameLabel = new JLabel("Repo Name:");
        reponameLabel.setBounds(25, 200, 80, 30);
        mainPanel.add(reponameLabel);
        JTextField reponame = new JTextField();
        reponame.setBounds(100, 200, 200, 30);
        mainPanel.add(reponame);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(25, 250, 80, 30);
        mainPanel.add(descriptionLabel);
        JTextField description = new JTextField();
        description.setBounds(100, 250, 200, 30);
        mainPanel.add(description);

        String visibility[] = {"Public", "Private"};
        JComboBox visible = new JComboBox(visibility);
        visible.setBounds(150, 300, 100, 30);
        mainPanel.add(visible);

        JLabel url = new JLabel("URL: N/A");
        url.setBounds(25, 400, 300, 30);
        mainPanel.add(url);
        
        JButton button = new JButton("Open File");
        button.setBounds(150, 350, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String pass = new String(password.getPassword());
                String repoPath = filepath.getText();
                String repoName = reponame.getText();
                String desc = description.getText();
                String vis = (String) visible.getSelectedItem();
                boolean theVis;
                if (vis.equals("Private")) theVis = true;
                else theVis = false;
                GitSubprocessClient gsc = new GitSubprocessClient(repoPath);
                GitHubApiClient api = new GitHubApiClient(user, pass);
                String newurl = createGithubRepo(gsc, api, user, repoName, desc, theVis);
                url.setText("URL: " + newurl);
            }
        } );
        mainPanel.add(button);


        // will show the window
        window.setContentPane(mainPanel);
        window.setVisible(true);
    }

    public static String createGithubRepo(GitSubprocessClient gsc, GitHubApiClient api, String user, String repoName, String desc, Boolean visible) {
        String gitinit = gsc.gitInit(); //turn project into git project
        System.out.println(gitinit);

        // Create the directory for the repository
        File repoDir = new File(gitinit.substring(gitinit.indexOf("C:")));
        if (!repoDir.exists()) {
            repoDir.mkdirs();
        }

        // Create and write .gitignore file
        File gitignore = new File(repoDir, ".gitignore");
        try (FileWriter fw = new FileWriter(gitignore)) {
            String gitignoreContent = "# Compiled class file\n*.class\n\n# Log file\n*.log\n\n# BlueJ files\n*.ctxt\n\n# Mobile Tools for Java (J2ME)\n.mtj.tmp/\n\n# Package Files #\n*.jar\n*.war\n*.nar\n*.ear\n*.zip\n*.tar.gz\n*.rar\n\n# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml\nhs_err_pid*\nreplay_pid*";
            fw.write(gitignoreContent);
            System.out.println(".gitignore created at: " + gitignore.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating .gitignore: " + e.getMessage());
        }

        // Create and write README.md file
        File readme = new File(repoDir, "README.md");
        try (FileWriter fw = new FileWriter(readme)) {
            String readmeContent = "# " + repoName;
            fw.write(readmeContent);
            System.out.println("README.md created at: " + readme.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating README.md: " + e.getMessage());
        }

        //String addGitIgnore = gsc.gitAddFile(gitinit.substring(gitinit.indexOf("C:")) + ".gitignore");
        //String addReadMe = gsc.gitAddFile(gitinit.substring(gitinit.indexOf("C:")) + "README.md");
        //System.out.println(addGitIgnore);
        //System.out.println(addReadMe);
        String addAll = gsc.gitAddAll();
        //System.out.println(addAll);
        String commit = gsc.gitCommit("Initial commit");

        RequestParams requestParams = new RequestParams();
        requestParams.addParam("name" , repoName);
        requestParams.addParam("description" , desc);
        requestParams.addParam("private" , visible);
        CreateRepoResponse createRepo = api.createRepo(requestParams);

        String webURL = "https://github.com/" + user + "/" + repoName;
        String gitRemoteOrigin = gsc.gitRemoteAdd("origin", webURL + ".git");
        System.out.println(gitRemoteOrigin);
        String push = gsc.gitPush("master");
        System.out.println(push);
        return webURL;
    }
}