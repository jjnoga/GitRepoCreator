import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.GitSubprocessClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                GitSubprocessClient gsc = new GitSubprocessClient(repoPath);
                GitHubApiClient api = new GitHubApiClient(user, pass);
                createGithubRepo(gsc, api, repoName, desc, vis);
            }
        } );
        mainPanel.add(button);

        // will show the window
        window.setContentPane(mainPanel);
        window.setVisible(true);
    }

    public static void createGithubRepo(GitSubprocessClient gsc, GitHubApiClient api, String repoName, String desc, String visibile) {
        
    }
}