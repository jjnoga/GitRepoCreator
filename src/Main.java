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

        JTextField username = new JTextField();
        mainPanel.add(username);
        JPasswordField password = new JPasswordField();
        mainPanel.add(password);
        JTextField reponame = new JTextField();
        mainPanel.add(reponame);
        JTextField description = new JTextField();
        mainPanel.add(description);
        String visibility[] = {"Public", "Private"};
        JComboBox visible = new JComboBox(visibility);
        mainPanel.add(visible);
        JButton button = new JButton("Open File");
        mainPanel.add(button);

        // will show the window
        window.setContentPane(mainPanel);
        window.setVisible(true);
    }
}