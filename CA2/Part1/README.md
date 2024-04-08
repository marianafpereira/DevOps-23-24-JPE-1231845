# Class Assignment 2 Part 1
## Contact Information :email:

For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)

## Additional Resources :books:

For more detailed information about this project, please visit the following links:

- [CA2 Part 1 Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA2-Part2-Home) where you can find an introdution, the explanation of steps taken, the full review of mercurial VS git and a conclusion of this CA1.
- [Glossary CA2 Part 1](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA2-PART1)
- [Project Images For CA2 Part1](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1)

We encourage you to explore these resources to gain a deeper understanding of the project.

## Overview :pushpin:
The objective of this class exercise was to utilize our individual repositories and a basic Gradle application to introduce new functionalities. Despite the simplicity of the features, the aim is to comprehend the operation of a Gradle wrapper and modify the build.gradle file. 

## Contents :page_with_curl:
1. [Initial Setup](#Initial-Setup)
2. [Implementing Changes](#Implementing-Changes)
    - [Part 1: Incorporating the runServer task](#Part-1-Incorporating-the-runServer-task)
    - [Part 2: Incorporating the test class and unit test](#Part-2-Incorporating-the-test-class-and-unit-test)
    - [Part 3: Incorporating the backup task and createZip task](#Part-3-Incorporating-the-backup-task-and-createZip-task)
3. [Issues](#Issues)
   
### Initial Setup :wrench:
1. Clone the repository from Bitbucket using the command:
   
```bash
   git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git
```
[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-2)

2. Navigate into the cloned repository and remove the .git directory:
   
```bash
   cd path/to/gradle_basic_demo
   rm -rf .git
```

3. Copy the application into a new CA2/Part1 folder:
   
```bash
   cp -r . ../CA2/Part1
   cd ../CA2/Part1
```

- command cp copies the directories and files stated ('.', the current directory), the '-r' notation says it will be copied recursively (all its contents) and '../CA1' is the destination folder

4. Initialize the Git repository (if not already a Git repository, in that case this step can be ignored):
   
```bash
   git init
```

5. Add all the new files to the GitHub repository using the command:
   
```bash
   git add
```

6. Commit the changes with a message:
   
```bash
   git commit -m "Added files from gradle_basic_demo"
```

7. Tag the repository with the version v1.0.0 using the command:
   
```bash
git tag -a v1.0.0 -m "init tag version"
```

8. Push the changes and the new tag to the GitHub repository:
   
```bash
   git push origin --tags
```

*Note:* 
The gradlew command will be used to run Gradle tasks. This is the Gradle Wrapper, which allows you to run Gradle tasks without needing to have Gradle installed locally. If you do have Gradle installed locally, you can replace gradlew with gradle in the commands.


### Implementing Changes :hammer:
Based on the readMe available [readMe original](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-10) on the project follow the following steps:

#### Part 1: Incorporating the runServer task :heavy_check_mark:
The objective of this initial segment is to incorporate a new task within the build.gradle file for server initiation. The procedure to achieve this is as follows:

1.1 Initiate the build process in the root directory with: 

```bash
   ./gradlew build
```

[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-4)

1.2 Launch the server on the same port as the client will connect to (59001) using:

```bash
   java -cp build/libs/basic_demo-0.1.0.jar 
   basic_demo.ChatServerApp 59001
```

[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-6)

1.3 Kick off the client with the gradle task: 

```bash
./gradlew runClient
```

[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-7)

By default, a new chat window pops up. If the server is listening on a different port than the client, an error will be triggered.

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-8) and
[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-9).

It's time to create a new task to launch the server with Gradle. To do this, we first need to open the build.gradle file and then:
2.1 Establish a task using the 'task' keyword and assign it a name such as 'runServer'. This name will be utilized later in the terminal to launch the server.

2.2 Direct to the appropriate filepath in the mainClass attribute

2.3 Modify the args. As we mentioned earlier, the server only requires the port number as a command-line argument, so specify: args '59001'

```bash
task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a chat server that listens to connections on localhost:59001 "

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}
```

2.4 (optional) Update the description to reflect the task's function.

2.5 Task creation is now complete.

2.6 Update the Gradle project to incorporate this newly created task (this step is optional if you're executing commands from the command line interface).

2.7 Given that we're operating from the command line interface, our first step is to build the project using:

```bash
   ./gradlew build
```

2.8 Once the build process completes successfully, execute:

```bash
   ./gradlew runServer
   ./gradlew runClient 
```

In this specific sequence, and the application should function as it did before.

#### Part 2: Incorporating the test class and unit test :pencil:
1. The first step is to incorporate the junit4.12.0 dependency:
   
1.1 Navigate to the build.gradle file and within the dependencies {} block, insert the following line:

```bash
    testImplementation group: 'junit', name: 'junit', version: '4.12'
```

   This can be found at https://mvnrepository.com/artifact/junit/junit
   
1.2 Click the Gradle refresh button located at the top right corner. Gradle will then fetch the junit dependency from mavenCentral().

1.3 Proceed to create a unit test for the App class.

1.4 Execute the test to verify its correctness.

In this segment of the assignment, we will establish a new test class and incorporate a unit test. The procedure is as follows:  

2.1 Generate a new test directory and a new test class:

```bash
   mkdir -p src/test/java/basic_demo touch 
   src/test/java/basic_demo/ChatServerAppTest.java
```

The mkdir command forms a new directory, the '-p' option allows for the creation of multiple directories simultaneously, and the touch command generates a new file.

2.2 Configure the test class:

```bash
   package basic_demo;

   import org.junit.Test;
   import static org.junit.Assert.*;

   public class AppTest {
   }
```

2.3 Incorporate the unit test:

```bash
   @Test public void testAppHasAGreeting() {
           App classUnderTest = new App();
           assertNotNull("app should have a greeting", classUnderTest.getGreeting());
       }
```

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-13)

2.4 Include the dependencies in the build.gradle file:

```bash
   dependencies {
       // Use Apache Log4J for logging
       implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2'
       implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2'
       testImplementation 'junit:junit:4.12'
   }
```

2.5 Compile the project in the terminal (first navigate to the project folder):

```bash
   ./gradlew build
```

Note: You can also execute the task independently with the command:

```bash
   ./gradlew runServer
```

2.6 Push the modifications to the remote repository:

```bash
   git push
```

#### Part 3:  Incorporating the backup task and createZip task :pencil2:
*Backup task:*

The subsequent step involves incorporating an additional task in the build.gradle file to duplicate the contents of the "src" directory into a newly established directory named "backup".

1.1 Add the following task:
```bash
   task backup(type: Copy) {
       from 'src'
       into 'backup'
   }
```

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-12)

1.2 Refresh Gradle in the upper right corner of IntelliJ to locally apply the changes (this is optional if you're executing commands from the command line interface).

1.3 Execute:

```bash
   ./gradlew backup 
```

And observe the newly formed backup directory with the copied files.

*CreateZip task:*

The subsequent step involves adding a new task to the build.gradle file to archive the "src" directory's content.

2.1 Add the following task:

```bash
   task createZip(type: Zip) {
       from 'src'
       def timestamp = new Date().format('yyyyMMdd-HHmmss')
       archiveFileName = "snapshot.zip-${timestamp}"
       destinationDirectory = file('backup') // 'build' is the typical choice, but it's not tracked for GitHub push
   }
```

[example image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-12)

2.2 To distinguish between different snapshot versions, a timestamp variable is created and appended to the zip file's name. Typically, packaged results like .jar, .war, and other artifacts are placed in the build or target directory, and these directories are not pushed to the remote repository, in this case, GitHub. However, for this academic exercise and to demonstrate the concept, the backup directory, which is tracked and pushed to GitHub, is being used.

2.3. Refresh Gradle in the upper right corner of IntelliJ to locally apply the changes (this is optional if you're executing commands from the command line interface).

2.4. Execute:

```bash
   ./gradlew createZip 
```

And observe the newly created "source.zip" file.

3. Add a tag to mark the end of the first part of this assignment:
   
```bash
git tag ca2-part1
git push --tags
```

### Issues :pushpin:
During the development of this class assigment 
1. Go to the repository's main page:
   
  ![image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/assets/147651953/2d85bdc0-e829-48b5-b878-dd6d6595b228)
   
2. Click on the "Issues" tab:
   
   ![image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/assets/147651953/32639435-89ae-4c18-808d-159c3a9fff27)
   
3. Click on the "New issue" button:
   
   ![image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/assets/147651953/d2aae599-ec7e-49e3-a0a6-e50a0bd9a83d)
   
5. Fill in the issue title and description and click on the "Submit new issue" button:
   
   ![image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/assets/147651953/7d5089cb-239e-409b-b82b-d51e27ce8d7d)
   
6. The issue will be created and assigned a number and can be seen by anyone who has access to the repository:
   
  ![image](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/assets/147651953/38ad3de0-c193-4b50-91f9-dff1c6311d66)
   
7. The issue can be assigned to someone, labeled, and commented on. It can also be closed when the problem is solved by associating it with a commit:
    
```bash
git commit -a -m "Fixes #1"
```

