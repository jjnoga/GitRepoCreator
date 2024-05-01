# GitRepoCreator
Developed by Joseph Noga, Jeremy Wiening, and Paul Zegarek.
## Description
Welcome to the website for the GitRepoCreator! This Java application autonomously establishes a Git repository in a given project filepath and creates a repository for the project on GitHub thereafter. This program returns the link to the newly-created repository once all of the text fields have been filled out appropriately. This goal is accomplished through various steps, the first of which being the implementation of a JFrame UI system that allows the user to click on and type in different text boxes and buttons. Next, a Git Subprocessing Client and API tool allow for the execution of Git commands throughout the code rather than needing to manually type them out in the terminal.
## Setup Instructions
1. Download the source code from [this](https://github.com/jjnoga/GitRepoCreator) GitHub link!
2. Ensure that your Java version is at least 17. Install from [this website](https://www.oracle.com/java/technologies/downloads/#jdk17-windows).
3. Download the required GitSubprocessClient and GitHubApiClient libraries as .jar files from the websites in [this](https://github.com/CSC109/GitSubprocessClient) and [this](https://github.com/CSC109/GitHubApiClient) repository respectively.
4. Integrate these new libraries within your IDE.
    - If you are using Visual Studio Code (which you most likely are if you're seeing this website), open the IDE, drop down the header that says "Java Projects" towards the bottom of the Explorer tab.
    - Drop down the "Referenced Libraries" tab within Java Projects, and copy/paste the .jar files inside. You should now have the required libraries to run the program!
## Usage Instructions
1. Enter your GitHub username.
2. Enter your GitHub personalized token (password). More info [here](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens)!
3. Copy/paste the file path of the project you are turning into a Git repo.
4. Enter the name that you want your new repo to have.
5. Give a short description of the newly made repo (what it does or what it will do).
6. Decide if you would like the repo to be public or private on GitHub.
7. Click the button and wait for the URL for your new repo to pop up!