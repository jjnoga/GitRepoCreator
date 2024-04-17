import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.GitSubprocessClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
        //GitHubApiClient api = new GitHubApiClient(null, null);

        JFrame window = new JFrame("GitRepoCreator");
        window.setSize(400, 500);
        window.setLayout(null);

        // will show the window
        window.setVisible(true);
    }
}