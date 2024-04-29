import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.GitSubprocessClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");
        //GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
        //GitHubApiClient api = new GitHubApiClient(null, null);

        JFrame window = new JFrame("GitRepoCreator");
        window.setSize(400, 500);
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);


        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35, 50, 80, 30);
        mainPanel.add(usernameLabel);
        JTextField username = new JTextField();
        username.setBounds(100, 50, 200, 30);
        mainPanel.add(username);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(36, 100, 80, 30);
        mainPanel.add(passwordLabel);
        JPasswordField password = new JPasswordField();
        password.setBounds(100, 100, 200, 30);
        mainPanel.add(password);


        JLabel reponameLabel = new JLabel("Repo Name:");
        reponameLabel.setBounds(25, 150, 80, 30);
        mainPanel.add(reponameLabel);
        JTextField reponame = new JTextField();
        reponame.setBounds(100, 150, 200, 30);
        mainPanel.add(reponame);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(25, 200, 80, 30);
        mainPanel.add(descriptionLabel);
        JTextField description = new JTextField();
        description.setBounds(100, 200, 200, 30);
        mainPanel.add(description);

        String visibility[] = {"Public", "Private"};
        JComboBox visible = new JComboBox(visibility);
        mainPanel.add(visible);
        
        JButton button = new JButton("Open File");
        button.setBounds(150, 300, 100, 30);
        mainPanel.add(button);

        // will show the window
        window.setContentPane(mainPanel);
        window.setVisible(true);
    }
}