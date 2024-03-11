# DevOps Class Assignment 1 - Technical Report

## Introduction

Welcome to the repository for the first class assignment of the DevOps course. This project is a demonstration of various DevOps practices and tools, including Git for version control, Spring Boot for backend development, and React for frontend development.
This is a technical report for de Class Assignment 1, of the DevOps class from the "Switch - Curso de Especialização em Desenvolvimento de Software" made by Mariana Pereira, student nº 1231845.
In this assignment, I have extended an existing Employee Management System from a GitHub repository. The original system allows for the creation of Employee records with various attributes such as name and job title. I have added additional fields, including years of experience and email. I have also incorporated unit testing to ensure the validity of the data and the correct functionality of the new fields.
This README file serves as a guide to the structure of the project, the steps taken during development, and the commands used. It is divided into several sections, each detailing a specific part of the assignment.

The project involves extending the functionality of an Employee Management System by adding new fields to the Employee entity and creating unit tests for these fields. The process involves creating issues on GitHub, creating new branches for each feature, adding the new fields to the Employee entity, creating unit tests, merging the changes into the master branch, committing the changes, pushing the commits to a remote repository, and creating and pushing tags. 
The new fields added include jobYears, jobTitle, and email. The email field also includes validation. The project demonstrates the use of Git for version control.

Please refer to the individual sections for a detailed explanation of each step. We hope this document helps you understand the processes and practices used in this assignment.

## Prerequisites and Installation

Before you can run this project, you will need to have the following software installed:

- Java 11 or later
- Maven
- Node.js and npm
- IntelliJ IDEA or any other IDE with support for Java and JavaScript

To install and run the project, follow these steps:

1. Clone the repository to your local machine using `git clone <repository-url>`.
2. Navigate to the project directory in your terminal.
3. Run `mvn clean install` to build the Java backend.
4. Navigate to the `src/main/frontend` directory.
5. Run `npm install` to install the necessary Node.js dependencies.
6. Run `npm start` to start the React application.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

When submitting your pull request, please make sure to write a clear and detailed description of the changes you've made.

## Contact Information

For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)

## Additional Resources

For more detailed information about this project, please visit the following links:

- [Project Wiki](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki)
- [Glossary](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary)
- [Project Images](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images)

We encourage you to explore these resources to gain a deeper understanding of the project.

## Part 1: Direct Work on Master Branch

### Objective

To implement the initial setup and a new feature directly on the master branch without using additional branches.

## 1. Tutorial
The first step in the assignment is to create a new Git repository and set it up for the project. This involves creating a new repository on GitHub, initializing a local repository and pushing the initial commit to the remote repository.

In this part of the project, we are setting up a new Git repository for the Employee Management System. Here's a detailed explanation of each step:  
1. The first step is to create a new repository on GitHub. This is done by navigating to GitHub, clicking on the "New" button, and following the prompts to create a new repository.  
2. Once the repository is created on GitHub, a new folder is created locally for the repository. This can be done using the file explorer on your computer or through the command line with the mkdir command.  
3. After creating the local folder, navigate into this folder using the command line and initialize a new Git repository with the git init command. This command creates a new Git repository in the current directory.  
4. To ensure that certain files and directories are not tracked by Git, a .gitignore file is created. This file specifies intentionally untracked files that Git should ignore. Files already tracked by Git are not affected. In this case, the .idea directory is added to the .gitignore file to ensure that it is ignored during version control.  
5. The next step is to link the local Git repository to the remote repository on GitHub. This is done using the git remote add origin <repository-url> command, where <repository-url> is the URL of the repository on GitHub.6After linking the local and remote repositories, the status of the Git repository can be checked using the git status command. This command displays the state of the working directory and the staging area. It lets you see which changes have been staged, which haven’t, and which files aren’t being tracked by Git.  
6. All the files in the local repository are then added to the Git staging area using the git add . command. This command adds all the files in the current directory to the staging area, preparing them for the next commit.  
7. The changes are then committed to the local Git repository using the git commit -m "[Initial] commit" command. This command creates a new commit with a message indicating what changes were made.  
8. Finally, the changes are pushed to the main branch of the remote repository on GitHub using the git push -u origin main command. This command pushes the commits on the main branch to the remote repository named origin.  

These steps demonstrate the initial setup of a Git repository, including creating a new repository on GitHub, initializing a local Git repository, linking the local and remote repositories, adding files to the Git staging area, committing changes, and pushing commits to a remote repository.

##### Steps:

1. Create a new repository on GitHub: see images for
   [Step 1](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-1)
   and
   [Step 2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-2)

2. Create a folder for the local repository;
3. On the command line in the local repository directory run the following command

```bash
git init
```

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-3)

4. You have to make all folders visible to make sure you have the .git folder like in the
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-4)

5. Make a new folder with the name CA1 with the following command

```bash
mkdir CA1
```

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-5)

6. To prevent the inclusion of unnecessary files in the repository, it's essential to create a .gitignore file. You can
   use the following command to create this file.
   Once the file is created, you can copy and paste the contents of the .gitignore file from the provided website into
   the file using the nano command.
   I suggest adding the .idea directory to the .gitignore file to ensure that it is ignored during version control.

```bash  
touch .gitignore
nano .gitignore
```

7. Now you have to add the repository you created on the github copying the link that is demonstrated in the
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-9)

8. In the command line paste the command line you copied from the github

```bash
    git remote add origin nameOfTheRepository
````

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-10)

9. Run the command git status to see if the new file appeared

```bash
    git status
````

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-11)

10. Run git add . to add the new file to the repository

```bash
    git add .
````

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-12)

11. Now make the commit and push.

```bash
  git commit -m "[Inicial] commit"
   git branch -M main
   git push -u origin main
```

## Procedures

To complete the tasks outlined in the assignment, follow these steps using the command line or Git Bash:

### Overview

The assignment comprises several essential tasks:

1. Copying Code: Transfer the Tutorial React.js and Spring Data REST Application code into a new folder named CA1.
2. Copy Necessary Files: Duplicate the Basic directory and the "pom.xml" file into the new CA1 folder.
3. Commit and Push: Commit the changes and push them to the repository.
4. Tag Initial Version: Tag the initial version as v1.1.0 and push the tag to the server.
5. Develop New Feature: Add a "jobYears" field to the Employee entity as a new feature.
6. Create Unit Tests: Develop unit tests for the new field and ensure validation for integer values only.
7. Debugging: Identify and rectify any issues in the server and client components of the solution.
8. Commit and Tag: Commit the new feature, push the changes, and tag the repository as v1.2.0.
9. End Part-One: Conclude the first part by tagging the repository with ca1-part1.
10. Branch Development: Create branches named after the features for developing new functionalities. For example,
    establish a branch named "email-field" to incorporate a new email field into the application.
11. Tag Repository: Tag the repository as v1.3.0.
12. Bug Fixing Branch: Create a branch called fix-invalid-email to address issues with invalid email entries. Ensure
    that the server only accepts Employees with valid email addresses.
13. Merge and Tag: Merge the bug fix branch into the master branch and tag the repository as v1.3.1.
14. Assignment Conclusion: Mark the repository with the tag ca1-part2 upon completing the assignment.

#### 1. Copying the Tutorial Application

The initial steps of the assignment involve setting up the project repository. This is done by cloning an existing
repository from GitHub into a new folder named CA1. Here's a detailed explanation of each step:

1. Copy the Repository Link: The first step is to copy the link of the repository you want to clone. In this case, the
   repository is the Spring Guides tutorial for a React.js and Spring Data REST application. The link to this repository
   is https://github.com/spring-guides/tut-react-and-spring-data-rest.
2. Clone the Repository: Once you have the link, navigate to the CA1 folder in your terminal. Here, you will clone the
   repository using the git clone command followed by the repository link. This command creates a copy of the repository
   on your local machine. The command should look like this: git
   clone https://github.com/spring-guides/tut-react-and-spring-data-rest.  
   After running this command, you should have a copy of the tutorial application in your CA1 folder. You can verify
   this by checking the contents of the CA1 folder. These steps set up the initial project structure and prepare it for
   further development. In the following steps of the assignment, you will modify this application to add new features
   and functionality.

##### Steps:

1. Copy this link from github:
   [spring-guides](https://github.com/spring-guides/tut-react-and-spring-data-rest)

2. In the CA1 folder open the terminal and run the following command to clone the repository

```bash
    git clone https://github.com/spring-guides/tut-react-and-spring-data-rest
````

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-6)

#### 2. Runnig the Spring Boot Application

The initial steps of the assignment involve setting up the project repository. This is done by adding all the files in
the current directory to the Git staging area, moving the files from the tut-react-and-spring-data-rest folder to the
CA1 folder, removing the .git folder that is inside the CA1 folder, creating issues on GitHub for each task or feature
that needs to be implemented, moving to the CA1 folder, running the Spring Boot application, and accessing the
application by navigating to http://localhost:8080 in a web browser. Here's a detailed explanation of each step:

1. Add all files to the repository: Use the git add . command to add all files in the current directory to the Git
   staging area. This prepares the files for the next commit.
2. Move files: Remove the files from the tut-react-and-spring-data-rest folder and put them inside of the CA1 folder.
   This helps to organize the project structure.
3. Remove the .git folder: Remove the .git folder that is inside the CA1 folder. This is necessary to avoid nested Git
   repositories which can cause confusion and unexpected behavior.
4. Create issues on GitHub: For each task or feature that needs to be implemented, create an issue on GitHub. When you
   commit your changes, you can associate them with the corresponding issue.
5. Move to the CA1 folder: Use the cd CA1 command to navigate to the CA1 folder in your terminal.
6. Run the Spring Boot application: Use the .\mnnw spring-boot:run command to compile and run the Spring Boot
   application.
7. Access the application: Once the application is running, you can access it by navigating to http://localhost:8080 in
   your web browser. You should see the initial page of the application.

These steps set up the project repository and prepare it for further development. As you continue to work on the
project, you will create more issues, make more commits, and create more tags to track your progress.

##### Steps:

1. Now add all files to the folder of your repository with the git add . command

```bash
    git add .
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-7)

2. Now you may remove the files from tut-react-and-spring-data-rest folder and put them inside of the CA1 folder to look
   like the following
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-8)

3. Now remove the .git folder that is inside the folder CA1
4. Add the following issue for step 1
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-13)
   and [example image of issue opened](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-14)

5. Now we will execute the command to install spring, but before make sure you have the path of java and maven in your
   environment variables
   [ass this example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-23)

6. Move to the CA1 folder with the command cd CA1
7. Run the following command:

```bash
    .\mnnw spring-boot:run
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-27)

8. When the process terminate access the  [Localhost Link](http://localhost:8080)and make sure you see
   as [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-28)

#### 3. V1.0.0 of CA1

The initial steps of the assignment involve setting up the project repository. This is done by copying the 'basic'
directory and the 'pom.xml' file from the 'tut-react-and-spring-data-rest' directory to the 'CA1' directory,
initializing a new Git repository in the 'CA1' directory, adding all the files in the 'CA1' directory to the Git staging
area, committing the changes with a message that includes the issue number, and pushing the changes to the main branch
of the remote repository. Here's an explanation of the steps:

1. Copy the 'basic' directory and 'pom.xml' file: The first step is to copy the 'basic' directory and the 'pom.xml' file
   from the 'tut-react-and-spring-data-rest' directory to the 'CA1' directory. This can be done using the cp -r
   tut-react-and-spring-data-rest/basic CA1 and cp tut-react-and-spring-data-rest/pom.xml CA1 commands.
2. Navigate to the 'CA1' directory: Once the necessary files have been copied, navigate to the 'CA1' directory using the
   cd CA1 command.
3. Initialize a new Git repository: In the 'CA1' directory, initialize a new Git repository using the git init command.
4. Add all files to the Git staging area: After initializing the Git repository, add all the files in the 'CA1'
   directory to the Git staging area using the git add . command.
5. Commit the changes: The changes are then committed using the git commit -m "#x message" command. This command creates
   a new commit with a message that includes the issue number. The "#x" in the commit message is a placeholder for the
   issue number associated with the commit.
6. Push the changes: Finally, the changes are pushed to the main branch of the remote repository using the git push
   origin main command.

These steps set up the project repository and prepare it for further development. As you continue to work on the
project, you will create more issues, make more commits, and create more tags to track your progress.

NOTE:You can also copy and paste the 'basic' folder using your system's file explorer interface. This is an alternative
to using command line operations.
If you have committed a file or folder by mistake, you can remove it from the commit using Git commands. One such
command is git rm --cached <file_or_folder_path>. This command removes the file or folder from the staging area, but not
from your local file system.
After running the git rm --cached command, you can verify that the file or folder has been removed from the commit by
using the git status command. This command shows the current state of the staging area and working directory.
Once you have verified that the file or folder is no longer staged for commit, you can proceed to push your changes to
the remote repository with git push.

```bash
    cp -r tut-react-and-spring-data-rest/basic CA1
    cp tut-react-and-spring-data-rest/pom.xml CA1
    cd CA1
    git init
    git add .
    git commit -m "#x message"
    git push origin main
```

##### Steps:

1. Create the issue for the second step of the project as before and as the
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-15)

2. You can see i already created the 5 issues i'll be needing and you can see all of the open ones where
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-17)

3. Now you can commit the changes with the following command:

```bash
    git commit -m "[Initial] #IssueNumber Initial commit"
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-18)

4. Now create the tag and push we will be needing with the command line

```bash
    git tag v1.1.0
    git push origin v1.1.0
````

[example image]((https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-19)

5. If you don't see the commit in the inicial page of the project, run the following command:

```bash
    git push --set-upstream origin master
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-20)

6. Now you can see the commit in the inicial page of the project
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-21)

7. Once you can see the commit on the initial page of the project, you can close the first issue you created. This
   indicates that the task associated with the issue has been completed.
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-22)

#### 4. # V1.2.0, V1.2.1 and ca1-part1

In this part of the project, we are extending the functionality of the Employee Management System by adding a new field
to the Employee entity and creating unit tests to ensure the correct functionality of this new field. Here's a detailed
explanation of each step:

1. Open the project in your preferred IDE, ensuring that Maven is loaded and all permissions are granted to the project.
   This is necessary for the successful compilation and execution of the project.
2. Add the new field to the Employee entity as specified in the GitHub issue. In this case, the email field is added.
   This field represents the email of an employee. This is done by modifying the Employee.java file in the
   src/main/java/com/greglturnquist/payroll directory.
3. Create unit tests for the new email field. This is done by adding new test methods to the EmployeeTest.java file in
   the src/test/java/com/greglturnquist/payroll directory. These tests ensure that the email field is functioning as
   expected.
4. Commit the changes to the local Git repository using the git commit -m "[Feature] #IssueNumber Added email field and
   unit tests" command. This command creates a new commit with a message indicating what changes were made. The
   #IssueNumber in the commit message links the commit to the corresponding GitHub issue.
5. Push the changes to the remote Git repository using the git push origin master command. This command pushes the
   commits to the master branch of the remote repository.
6. Create a new tag named v1.3.0 using the git tag v1.3.0 command. This command creates a new tag that marks the point
   in the repository's history where the email field was added.

These steps extend the functionality of the Employee Management System by adding a new field to the Employee entity and
creating unit tests for this new field. They also demonstrate the use of Git for version control, including committing
changes, pushing commits to a remote repository, and creating and pushing tags.

##### Steps:

1. Open the project and make sure you load maven and grand all permitions to the project
2. Then add the fields that are asked in the issue 2 in this case the jobYears and make unit tests for that code
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-29)

3. Now commit like the following:

```bash
    git commit -m "[Feature] #IssueNumber Added jobYears field and unit tests"
````

4. Now push the changes to the repository with the following command:

```bash
    git push origin master
````

5. Then create a new tag with the following command

```bash
    git tag v1.2.0
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-29)

6. Push the tag to the repository using the command line

```bash
    git push origin v1.2.0
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-30)

7. I added the field jobTitle and the unit tests for that field based on the powerpoint devops of the theoric lesson
8. Then commited, associeted with the issue and pushed the changes to the repository as the following:

```bash
    git commit -m "[Feature] #IssueNumber Added jobTitle field and unit tests"
    git push origin master
````

9. Then i created a new tag as before

```bash
    git tag v1.2.1
````

10. Then i pushed the tag to the repository

```bash
    git push origin v1.2.1
````

11. Then i created the tag ca1-part1 as before and pushed it to the repository

```bash
    git tag ca1-part1
    git push origin ca1-part1
````

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-31)

12. Now i clossed the issue of the jobYears and jobTitle fields.

#### 5. # V1.3.0

In this part of the project, we are extending the functionality of the Employee Management System by adding a new field,
email, to the Employee entity and ensuring that the server only accepts Employees with valid email addresses. Here's a
detailed explanation of each step:

1. Create a new branch for the bug fix. This can be done either through the command line using the git checkout -b
   fix-invalid-email command or through the IDE. Creating a new branch for each feature or task helps keep the work
   organized and isolated from other tasks.
2. Once the new branch is created, modify the Employee entity to include validation for the email field. This involves
   modifying the Employee.java file in the src/main/java/com/greglturnquist/payroll directory and adding the necessary
   code for the new field.
3. After adding the email validation, create unit tests to ensure the correct functionality of this new field. These
   tests are added to the EmployeeTest.java file in the src/test/java/com/greglturnquist/payroll directory.
4. With the new field added and the unit tests created, the next step is to merge the changes from the fix-invalid-email
   branch into the master branch. This can be done either through the IDE or using the command line with the git
   checkout master and git merge fix-invalid-email commands.
5. After merging the changes, they are committed to the local Git repository using the git commit -m "[Fix] #IssueNumber
   Fixed invalid email entries" command. This command creates a new commit with a message indicating what changes were
   made. The #IssueNumber in the commit message links the commit to the corresponding GitHub issue.
6. The changes are then pushed to the remote Git repository using the git push origin master command. This command
   pushes the commits to the master branch of the remote repository.
7. A new tag named v1.3.1 is created using the git tag v1.3.1 command. This command creates a new tag that marks the
   point in the repository's history where the email validation was added.
8. The v1.3.1 tag is then pushed to the remote Git repository using the git push origin v1.3.1 command. This command
   pushes the v1.3.1 tag to the remote repository.
9. Finally, the GitHub issue created for the email validation is closed. This indicates that the task associated with
   the issue has been completed.

These steps extend the functionality of the Employee Management System by adding email validation to the Employee entity
and creating unit tests for this new field. They also demonstrate the use of Git for version control, including creating
branches, merging changes, committing changes, pushing commits to a remote repository, and creating and pushing tags.

##### Steps:

1. I created 2 issues to add the email field and the email-field branch to the project
2. To create a new branch there are 2 options: one using the command line with the following command

```bash
    git checkout -b email-field
````

or using the IDE as
the [example 1 image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-32)
and [example 2 image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-33)

3. Then i added the email field and the unit tests
4. Now i have to merge the branch with the master. For this there are two options. Merge the branch with the master
   using ide
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-34)

or using command lines with the following command:

```bash
    git checkout master
    git merge email-field
````

5. Then i commited the changes and pushed to the repository with the command line

```bash
    git commit -m "[Feature] #IssueNumber Added email field and unit tests"
    git push origin master
````

6. Then i created the tag v1.3.0 and pushed to the repository with the command line

```bash
    git tag v1.3.0
    git push origin v1.3.0
````

[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-35)

7. Closed the issue of email-field and email-field branch.

#### 5. # V1.3.1 and ca1-part2

In this part of the project, we are enhancing the functionality of the Employee Management System by adding validation
to the email field in the Employee entity. Here's a detailed explanation of each step:

1. Create two issues on GitHub for adding the validation to the email field and for the fix-invalid-email branch. These
   issues will help track the progress of this feature and link the changes to this specific task.
2. Create a new branch to work on this feature. This can be done either through the command line using the git checkout
   -b fix-invalid-email command or through the IDE. Creating a new branch for each feature or task helps keep the work
   organized and isolated from other tasks.
3. Once the new branch is created, add the validation for the email field to the Employee entity. This involves
   modifying the Employee.java file in the src/main/java/com/greglturnquist/payroll directory and adding the necessary
   code for the new validation.
4. After adding the validation for the email field, create unit tests to ensure the correct functionality of this new
   validation. These tests are added to the EmployeeTest.java file in the src/test/java/com/greglturnquist/payroll
   directory.
5. With the new validation added and the unit tests created, the next step is to merge the changes from the
   fix-invalid-email branch into the master branch. This can be done either through the IDE or using the command line
   with the git checkout master and git merge fix-invalid-email commands.
6. After merging the changes, commit them to the local Git repository using the git commit -m "[Feature] #IssueNumber
   Added email field and unit tests" command. This command creates a new commit with a message indicating what changes
   were made. The #IssueNumber in the commit message links the commit to the corresponding GitHub issue.
7. Push the changes to the remote Git repository using the git push origin master command. This command pushes the
   commits to the master branch of the remote repository.
8. Create a new tag named v1.3.1 using the git tag v1.3.1 command. This command creates a new tag that marks the point
   in the repository's history where the validation for the email field was added.
9. Push the v1.3.1 tag to the remote Git repository using the git push origin v1.3.1 command. This command pushes the
   v1.3.1 tag to the remote repository.
10. Create a new tag named ca1-part2 using the git tag ca1-part2 command. This command creates a new tag that marks the
    end of the second part of the assignment.
11. Push the ca1-part2 tag to the remote Git repository using the git push origin ca1-part2 command. This command pushes
    the ca1-part2 tag to the remote repository.
12. Finally, close the GitHub issues created for the email field validation and the fix-invalid-email branch. This
    indicates that the tasks associated with these issues have been completed.

These steps extend the functionality of the Employee Management System by adding validation to the email field in the
Employee entity and creating unit tests for this new validation. They also demonstrate the use of Git for version
control, including creating branches, merging changes, committing changes, pushing commits to a remote repository, and
creating and pushing tags.

##### Steps:

1. I created 2 issues to add the validation to the email field and the fix-invalid-email branch to the project
2. To create a new branch there are 2 options: one using the command line with the following command

```bash
    git checkout -b fix-invalid-email
````

or using the IDE as
the [example 1 image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-32)
and [example 2 image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-33)

3. Then i added the validation to the email field and the unit tests
4. Now i have to merge the branch with the master. For this there are two options. Merge the branch with the master
   using ide
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-34)

   or using command lines with the following command:

```bash
    git checkout master
    git merge fix-invalid-email
````

5. Then i commited the changes and pushed to the repository with the command line

```bash
    git commit -m "[Feature] #IssueNumber Added email field and unit tests"
    git push origin master
````

6. Then i created the tag v1.3.1 and ca1-part2 and pushed to the repository with the command line

```bash
    git tag v1.3.1
    git push origin v1.3.1
    git tag ca1-part2
    git push origin ca1-part2
````

[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-35)

7. Closed the issue of email-field and email-field branch.

#### Tests and implementions for this CA1

The `EmployeeTest.java` file, which contains the unit tests for the `Employee` entity, can be
found [here](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA1/basic/src/test/java/com/greglturnquist/payroll/EmployeeTest.java)

The `Employee.java` file, which represents the `Employee` entity, can be found at the
found [here](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA1/basic/src/main/java/com/greglturnquist/payroll/Employee.java)

The `Database.java` file, which handles the database operations, can be found at the
found [here](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA1/basic/src/main/java/com/greglturnquist/payroll/DatabaseLoader.java)

`CA1/basic/src/main/java/com/greglturnquist/payroll/DatabaseLoader.java`

## 2. Examination of an Alternative Version Control Solution: Mercurial SCM

Mercurial, like Git, is a free, distributed version control system, also known as a revision control system or Mercurial
source control. It's utilized by software development teams to manage and track changes across projects. Despite its
popularity declining since its release in 2005, it's still employed by major organizations such as Facebook and Mozilla.

Mercurial's main difference from Git lies in its branching structure. While Git allows for the creation, deletion, and
switching of branches at any time, making the branches lightweight, Mercurial has a more complex, permanent branching
structure. This can lead to a cluttered repository and requires extra care to avoid committing changes to the wrong
branch.

Another difference is how they handle the staging area. In Git, the staging area is separate from the working directory,
where changes are stored before they are committed to the repository. In Mercurial, the staging area is not separate
from the working directory, which can make managing changes more difficult and prone to errors.

Mercurial can be more user-friendly due to its simplicity, especially for beginners. However, Git's power and
flexibility make it the preferred choice for most developers.

To set up a repository in Mercurial, you would follow similar steps to Git, but with Mercurial's specific commands. For
example, to create a new branch in Mercurial, you would use hg branch <branchname>.
To switch to the new branch, you would use hg update <branchname>. To merge the new branch into the main branch, you
would use hg merge <branchname>.

Mercurial also has a set of useful commands similar to Git, such as hg clone to create a copy of an existing repository,
hg pull to pull changes from a remote repository, hg update to update the working directory to a specific revision, and
hg log to view the history of the repository.

In conclusion, both Git and Mercurial are powerful version control systems with their own strengths and weaknesses. The
choice between the two depends on the specific requirements of the project, the team's familiarity with the tools, and
the existing infrastructure and tooling.

The subsequent section offers an examination of Mercurial as an alternative version control solution to Git. It
emphasizes its features, contrasts with Git, and its potential application to the assignment objectives. However, it was
not utilized in the assignment.

### Contrast with Git

1. Simplicity: Mercurial is frequently commended for its simplicity and direct command set. Novice users might perceive
   Mercurial to be more accessible than Git, which possesses a steeper learning curve due to its more comprehensive set
   of features and commands.
2. Branching and Merging: Both Git and Mercurial support branching and merging, but Git's model permits more
   flexibility. Git branches are lightweight and can be effortlessly created, merged, and deleted, which encourages
   experimenting with new features. Mercurial employs a slightly different approach, where branches are permanent and
   clones are frequently used for feature development.
3. Performance: Git generally offers superior performance for large projects due to its efficient management of branches
   and its compressed data format. However, Mercurial provides adequate performance for most projects and can be simpler
   to use for basic operations.
4. Tooling and Integration: Git has a broader adoption, which means more tools and integrations are available, including
   popular platforms like GitHub, GitLab, and Bitbucket. Mercurial is supported by many tools as well, but the ecosystem
   is smaller.
5. Closing Issues: Issues can be closed in the same manner as Git, using the respective platform's interface or by
   including the issue number in the commit message.
6. The Mercurial commands are similar to Git, but the workflow and concepts differ slightly. Mercurial's simplicity and
   direct command set may be advantageous for some projects, particularly for teams with less experience in version
   control. However, Git's broader adoption and ecosystem make it the preferred choice for many projects, particularly
   those that require extensive tooling and integration.
7. The choice between Git and Mercurial depends on the specific requirements of the project, the team's familiarity with
   the tools, and the existing infrastructure and tooling. Both systems are capable of achieving the objectives outlined
   in this assignment, but the workflow and commands will differ.
8. Installation and Setup: Provide a brief guide on how to install and set up Mercurial on different operating systems.
   This can be helpful for beginners who are not familiar with the process.
9. Detailed Command Explanation: While you have provided some Mercurial commands, you could go into more detail about
   what each command does and when to use it. This can help users understand the workflow better.
10. Case Studies or Examples: Provide real-world examples or case studies of projects that use Mercurial. This can give
    readers a better understanding of how Mercurial is used in practice.
11. Comparison Table: A side-by-side comparison table of Git and Mercurial features can be a quick and easy reference
    for readers.
12. Troubleshooting Guide: Common errors or issues that users might encounter when using Mercurial and how to resolve
    them.
13. Community and Support: Information about the Mercurial community, how to get support, and where to find additional
    resources for learning Mercurial.

### Utilizing Mercurial for the Assignment Objectives

To accomplish the same objectives as presented in this assignment using Mercurial, first you will need to
install [Mercurial](https://www.mercurial-scm.org/downloads). And then follow a similar workflow with some differences
in commands and concepts:

1. Repository Initialization: To initialize a Mercurial repository, use hg init instead of git init.

  ```bash
    hg init
    echo "# repository-name" >> README.md
    hg add README.md
    hg commit -m "first commit"
   ```

2. Pushing Modifications: Mercurial uses hg push to send modifications to a remote repository, similar to git push.

  ```bash
    hg push
   ```

3. Tagging Versions: In Mercurial, tags are created with hg tag <tagname> and pushed with hg push --tags.
    ```bash
    hg tag v1.0.0
    hg push --tags
    ```
4. Branching for Features and Fixes: To create a new branch in Mercurial, use hg branch <branchname>. Feature
   development and bug fixes would follow a similar branching model to Git, with the merge process using hg merge and
   commit changes with hg commit.
    ```bash
    hg branch email-field
    hg commit -m "Added email field"
    hg merge
    hg commit -m "Merged email-field branch"
    ```
5. Finalizing with Tags: Mark the end of the assignment with hg tag ca1-part2 and push the tag as shown above.
    ```bash
    hg tag ca1-part2
    hg push --tags
    ```

### Essential Mercurial Commands

1. hg clone: Clones an existing repository.
    ```bash
    hg clone <repository-url>
    ```
2. hg pull: Retrieves changes from a remote repository to the local one.
    ```bash
    hg pull
    ```
3. hg update: Updates the working directory to a specific revision.
    ```bash
    hg update <revision>
    ```
4. hg branch: Creates a new branch in the repository.
    ```bash
    hg branch <branchname>
    ```
5. hg merge: Merges two branches in the repository.
    ```bash
    hg merge <branchname>
    ```
6. hg tag: Tags a specific revision in the repository.
    ```bash
    hg tag <tagname>
    ```
7. hg log: Displays the repository's history.
    ```bash
    hg log
    ```
8. hg status: Shows the status of the working directory.
    ```bash
    hg status
    ```
9. hg diff: Views the modifications made to the working directory.
    ```bash
    hg diff
    ```
10. hg revert: Reverts changes made to the working directory.
   ```bash
    hg revert <filename>
   ```
11. hg rollback: Undoes the last commit in the repository.

```bash
    hg rollback
   ```

12. hg help: Provides the help documentation for Mercurial.

```bash
    hg help
 ```

13. hg version: Shows the installed version of Mercurial.

 ```bash
       hg version
 ```

14. hg outgoing: Displays the changes that are ready to be pushed to a remote repository.

```bash
   hg outgoing
 ```

15. hg incoming: Shows the changes that can be pulled from a remote repository.

```bash
    hg incoming
```


## Conclution

In the course of this project, I encountered a few challenges and learned several important concepts. One of the major difficulties I faced was related to the merging of branches.
In the process of merging branches, I did not use the git merge --no-ff command. This command prevents a fast-forward merge, which occurs when the current branch hasn't diverged from the target branch being merged in. Instead of creating a new commit to represent the merge, Git simply moves the current branch forward until it's at the same commit as the target branch. 
By using --no-ff, the history of the feature branch is preserved before it gets integrated into the main branch, making it easier to understand the flow of changes and to revert entire features if needed. However, in this project, I did not use this command, which may have affected the expected outcome. As always, every major step should be followed by the creation of a tag and pushing it to the origin.
Due to that error, the ramifications of the branches did not appear as expected. 

Despite these challenges, working on this project was a valuable experience. It provided a practical understanding of several key concepts in software development and DevOps. I learned about the importance of version control in managing and tracking changes to the codebase. Using Git, I was able to create branches for different features, commit changes, and merge these changes back into the main codebase.
This not only helped to keep the work organized but also made it easier to track the progress of each feature.  Furthermore, I learned about the importance of unit testing in ensuring the correct functionality of the code. By creating unit tests for each new field added to the Employee entity, I was able to verify that these fields were working as expected. This is a crucial aspect of software development as it helps to catch and fix bugs early in the development process, ensuring the reliability and quality of the code.  In addition, I gained experience in working with Spring Boot. 

Antoher conclution i have after developing this project is that both Git and Mercurial are powerful distributed version control systems that aid developers in tracking and managing changes to their codebase. Git, with its extensive set of features and commands, offers a high degree of flexibility and efficiency, particularly for large projects. It also boasts a broader adoption, leading to a larger ecosystem of tools and integrations. On the other hand, Mercurial is often praised for its simplicity and straightforward command set, making it potentially more accessible for beginners or teams seeking a more streamlined workflow. While Git's model allows for lightweight and easily manageable branches, Mercurial adopts a slightly different approach where branches are permanent and clones are often used for feature development. Ultimately, the choice between Git and Mercurial depends on the specific requirements of the project, the team's familiarity with the tools, and the existing infrastructure and tooling. Both systems are capable of achieving the objectives outlined in this assignment, but the workflow and commands will differ.

These frameworks are widely used in the industry and learning to work with them has been a valuable addition to my skill set.  Overall, this project was a great opportunity to apply and deepen my understanding of these concepts. It was a challenging but rewarding experience that has enhanced my skills as a developer.

