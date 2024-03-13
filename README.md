# DevOps Class Assignment 1 - Technical Report

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

- [Project Wiki](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki) where you can find an introdution, the explanation of steps taken, the full review of mercurial VS git and a conclusion of this CA1.
- [Glossary](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary)
- [Project Images](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images)

We encourage you to explore these resources to gain a deeper understanding of the project.

## Part 1: Direct Work on Master Branch

### Objective

To implement the initial setup and a new feature directly on the master branch without using additional branches.

## 1. Tutorial for v1.0.0
The first step in the assignment is to create a new Git repository and set it up for the project. This involves creating a new repository on GitHub, initializing a local repository and pushing the initial commit to the remote repository.

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

11. Create the tag for v1.0.0
    
```bash
    git tag v1.1.0
    git push origin v1.1.0
```
12. Now make the commit and push.

```bash
  git commit -m "[Inicial] commit"
   git branch -M main
   git push -u origin main
```

## 2. Tutorial for ca-part1

To complete the tasks outlined in the assignment, follow these steps using the command line or Git Bash:

#### 1. Copying the Tutorial Application

The initial steps of the assignment involve setting up the project repository. This is done by cloning an existing
repository from GitHub into a new folder named CA1. Here's a detailed explanation of each step:

##### Steps:

1. Copy this link from github:
   [spring-guides](https://github.com/spring-guides/tut-react-and-spring-data-rest)

2. In the CA1 folder open the terminal and run the following command to clone the repository

```bash
    git clone https://github.com/spring-guides/tut-react-and-spring-data-rest
````

[Example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-6)

#### 2. Running the Spring Boot Application

The initial steps of the assignment involve setting up the project repository. This is done by adding all the files in
the current directory to the Git staging area, moving the files from the tut-react-and-spring-data-rest folder to the
CA1 folder, removing the .git folder that is inside the CA1 folder, creating issues on GitHub for each task or feature
that needs to be implemented, moving to the CA1 folder, running the Spring Boot application, and accessing the
application by navigating to http://localhost:8080 in a web browser. 

The following steps set up the project repository and prepare it for further development. As you continue to work on the
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

#### 3. Tutorial for V1.1.0

The initial steps of the assignment involve setting up the project repository. This is done by copying the 'basic'
directory and the 'pom.xml' file from the 'tut-react-and-spring-data-rest' directory to the 'CA1' directory,
initializing a new Git repository in the 'CA1' directory, adding all the files in the 'CA1' directory to the Git staging
area, committing the changes with a message that includes the issue number, and pushing the changes to the main branch
of the remote repository. 

The followinng steps set up the project repository and prepare it for further development. As you continue to work on the
project, you will create more issues, make more commits, and create more tags to track your progress.
Please visit the [wiki page of v1.1.0](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki#3-v110-of-ca1)for more information about all the following steps.

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

#### 4. Tutorial for V1.2.0, V1.2.1 and ca1-part1

In this part of the project, we are extending the functionality of the Employee Management System by adding a new field
to the Employee entity and creating unit tests to ensure the correct functionality of this new field. 

The following steps extend the functionality of the Employee Management System by adding a new field to the Employee entity and
creating unit tests for this new field. They also demonstrate the use of Git for version control, including committing
changes, pushing commits to a remote repository, and creating and pushing tags.
Please visit the [wiki page of v1.2.0, v1.2.1 and ca-part1](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki#4--v120-v121-and-ca1-part1) for more information about all the following steps.

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

## Part 2:  Work with Branches

### Objective

To implement new features and fixes on separate branches, then merge these branches into the master branch. 
This approach allows for isolated development of each feature or fix, reducing the risk of conflicts and making it easier to track changes.

#### 1. Tutorial for V1.3.0

In this part of the project, we are extending the functionality of the Employee Management System by adding a new field,
email, to the Employee entity and ensuring that the server only accepts Employees with valid email addresses. 

The following steps extend the functionality of the Employee Management System by adding email validation to the Employee entity
and creating unit tests for this new field. They also demonstrate the use of Git for version control, including creating
branches, merging changes, committing changes, pushing commits to a remote repository, and creating and pushing tags. 
Please visit the [wiki page of v1.3.0](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki#5--v130) for more information about all the following steps.

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

#### 2. Tutorial for V1.3.1 and ca1-part2

In this part of the project, we are enhancing the functionality of the Employee Management System by adding validation
to the email field in the Employee entity.

The following steps extend the functionality of the Employee Management System by adding validation to the email field in the
Employee entity and creating unit tests for this new validation. They also demonstrate the use of Git for version
control, including creating branches, merging changes, committing changes, pushing commits to a remote repository, and
creating and pushing tags. 
Please visit the [wiki page of v1.3.1 and ca-part2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki#5--v131-and-ca1-part2) for more information about all the following steps.

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

## Part 3 - Examination of an Alternative Version Control Solution: Mercurial SCM

Mercurial is a free, distributed version control system used by software development teams to manage and track changes across projects. Despite a decline in popularity since its 2005 release, it's still used by major organizations like Facebook and Mozilla. 

Mercurial's branching structure differs from Git's. While Git allows for the creation, deletion, and switching of branches at any time, Mercurial has a more complex, permanent branching structure. This can lead to a cluttered repository and requires extra care to avoid committing changes to the wrong branch.  

Another difference lies in the handling of the staging area. In Git, the staging area is separate from the working directory, where changes are stored before they are committed to the repository. In Mercurial, the staging area is not separate from the working directory, which can make managing changes more difficult and prone to errors. 

Mercurial can be more user-friendly due to its simplicity, especially for beginners. However, Git's power and flexibility make it the preferred choice for most developers. Setting up a repository in Mercurial involves similar steps to Git, but with Mercurial's specific commands. Mercurial also has a set of useful commands similar to Git, such as hg clone, hg pull, hg update, and hg log.  

In conclusion, both Git and Mercurial are powerful version control systems with their own strengths and weaknesses. The choice between the two depends on the specific requirements of the project, the team's familiarity with the tools, and the existing infrastructure and tooling.

For a deeper examination of this alternative version control visit [wiki page](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki#2-examination-of-an-alternative-version-control-solution-mercurial-scm).

### 1. Contrast with Git

Mercurial is a version control system known for its simplicity and direct command set, making it accessible for beginners. However, its branching and merging model is less flexible than Git's, as branches in Mercurial are permanent and clones are often used for feature development.  

In terms of performance, Git generally outperforms Mercurial for large projects due to its efficient branch management and compressed data format. However, Mercurial's performance is adequate for most projects and can be simpler for basic operations.  

Git has a broader adoption, leading to more available tools and integrations. Mercurial, while supported by many tools, has a smaller ecosystem. Both systems allow for closing issues in a similar manner, typically through the platform's interface or by including the issue number in the commit message.  

The choice between Git and Mercurial depends on the project requirements, team's familiarity with the tools, and existing infrastructure. Both systems can achieve the objectives outlined in this assignment, but the workflow and commands will differ.  Additional resources for Mercurial could include installation and setup guides, detailed command explanations, real-world examples or case studies, a comparison table with Git, a troubleshooting guide, and information about the Mercurial community and support.

### 2. Utilizing Mercurial for the Assignment Objectives

To accomplish the same objectives as presented in this assignment using Mercurial, first you will need to
install [Mercurial](https://www.mercurial-scm.org/downloads). And then follow a similar workflow with some differences
in commands and concepts. First instal mercurial and python  [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-37).

1. Repository Initialization: To initialize a Mercurial repository, use hg init instead of git init.

  ```bash
    hg init
    echo "# repository-name" >> README.md
    hg add README.md
    echo " " > .hignore
    hg commit -m "first commit"
   ```
 [example image1](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-38),  [example image 2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-39),  [example image 3](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-40),  [example image 4](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-41), [example image 5](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-42) and [example image 6](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-43).
 
2. Make sure that you have on your environment variables the path of the mercurial like [this](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-45)
   
3. Add your user information using this command line

 ```bash
 hg config --edit
 ```
[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-47) and  [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-48)

4. Pushing Modifications: Mercurial uses hg push to send modifications to a remote repository, similar to git push.

  ```bash
    hg push
   ```

5. Tagging Versions: In Mercurial, tags are created with hg tag <tagname> and pushed with hg push --tags.
    ```bash
    hg tag v1.0.0
    hg push --tags
    ```
6.  Branching for Features and Fixes: To create a new branch in Mercurial, use hg branch <branchname>. Feature
   development and bug fixes would follow a similar branching model to Git, with the merge process using hg merge and
   commit changes with hg commit.
    ```bash
    hg branch email-field
    hg commit -m "Added email field"
    hg merge
    hg commit -m "Merged email-field branch"
    ```
   [example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images#step-46)

7. Finalizing with Tags: Mark the end of the assignment with hg tag ca1-part2 and push the tag as shown above.
   
   ```bash
    hg tag ca1-part2
    hg push --tags
    ```


### 3. Essential Mercurial Commands

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
16. hg heads: Lists the heads in the repository.

```bash
    hg heads
```
17. hg bookmarks: Manages the repository's bookmarks.

```bash
    hg bookmarks
```
18. hg bisect: Helps identify the changeset that introduced a bug.

```bash
    hg bisect
```
19. hg graft: Copies changes from one branch to another.

```bash
    hg graft
```
20. hg strip: Removes changesets from the repository.

```bash
    hg strip
```
21. hg update: Updates the working directory to a specific revision.

```bash
    hg update
```
