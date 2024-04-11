# Class Assignment 2 Part 2 (CA2-Part2)

# Introduction
Welcome to Class Assignment 2 Part 2! In this part of the assignment, we will be focusing on converting the basic version of the Tutorial application from Gradle.

# Objective
The primary goals of Part 2 of Class Assignment 2 are:  
1. To establish a comprehensive understanding of Gradle build tools by setting up a Gradle project structure.
2. To learn how to configure Gradle build files, specifically build.gradle.
3. To manage project dependencies effectively using Gradle.
4. To define and understand the use of tasks and plugins in Gradle.

By accomplishing these objectives, you will gain hands-on experience with Gradle and build tools, which are crucial skills in contemporary software development practices.

# Contact Information
For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)

I hope you enjoy working on this assignment and find it insightful in your journey to mastering Gradle and software development practices. Let's dive in and start exploring CA2 Part 2!

# Addicional Information

Start Date: 4, April
End Date: 17, April

- [Git Repository](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845)
- [CA2 Part 2 Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA2-Part2-Home)  where you can find an introdution and a conclusion of this CA2.
- [Glossary CA2 Part 2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA2-PART2)
- [Project Images For CA2 Part2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2)


### Initial Setup :wrench:
This setup is the same as the CA2 Part 1 setup. If you didn't follow those steps, please follow now to setup th envirement.
1. Clone the repository from Bitbucket using the command:

```groovy
   git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git
```
[image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part1#step-2)

2. Navigate into the cloned repository and remove the .git directory:

```groovy
   cd path/to/gradle_basic_demo
   rm -rf .git
```

3. Copy the application into a new CA2/Part2 folder:

```groovy
   cp -r . ../CA2/Part2
   cd ../CA2/Part2
```

- command cp copies the directories and files stated ('.', the current directory), the '-r' notation says it will be copied recursively (all its contents) and '../CA1' is the destination folder

4. Initialize the Git repository (if not already a Git repository, in that case this step can be ignored):

```groovy
   git init
```

5. Add all the new files to the GitHub repository using the command:

```groovy
   git add
```

6. Commit the changes with a message:

```groovy
   git commit -m "Added files from gradle_basic_demo"
```

7. Tag the repository with the version you want in this example we use the v1.0.0 using the command:

```groovy
git tag -a v1.0.0 -m "init tag version"
```

8. Push the changes and the new tag to the GitHub repository:

```groovy
   git push origin --tags
```

*Note:*
The gradlew command will be used to run Gradle tasks. This is the Gradle Wrapper, which allows you to run Gradle tasks without needing to have Gradle installed locally. If you do have Gradle installed locally, you can replace gradlew with gradle in the commands.


### CA2 Part 2 - Build Tools with Gradle :hammer_and_wrench:

1. Create a new branch called tut-basic-gradle using the following command:

```groovy
git checkout -b tut-basic-gradle
```

1.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-1)

2. Navigate to https://start.spring.io to initiate a new Spring Boot project with Gradle. The project should include the following dependencies: Rest Repositories, Thymeleaf, JPA, and H2.

3. 2.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-2)

3. Unzip the downloaded project file into the "CA2/Part2/" directory of your repository. This gives you a basic Spring application that can be built using Gradle. 

4. You can view the available Gradle tasks by running the command ./gradlew tasks.

4.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-3)

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-4)

5. Remove the existing src directory. We aim to use the code from the basic tutorial instead.

6. Copy the src directory (including all its subdirectories) from the basic tutorial folder to this new folder.

7. Also, copy the webpack.config.js and package.json files.

7.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-24)

8. Delete the src/main/resources/static/built/ directory as it should be generated by the webpack tool from the JavaScript code.

8.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-6)

9. You can now test the application by running the command ```./gradlew bootRun``` or writting that command and pressing CTRL + Enter.

9.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-8)

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-9)

10. You'll notice that the webpage at http://localhost:8080 is blank. This is because the Gradle build is missing the plugin required to handle the frontend code.
   
10.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-10)

**IMPORTANT NOTE**

1. Modify the imports in Employee.java from *javax* to *jakarta*.

1.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-13)

2. Insert  ```"packageManager": "npm@9.6.7" ``` into the package.json file.

2.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-11)

3. Depending on your Java version (8, 11, or 17), add the corresponding line to the plugins section in build.gradle.

```groovy
id "org.siouan.frontend-jdk8" version "6.0.0"
id "org.siouan.frontend-jdk11" version "8.0.0"
id "org.siouan.frontend-jdk17" version "8.0.0"
```

3.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-12)

4. Also, add the following configuration to your build.gradle file to set up the previously mentioned plugin:

```groovy
frontend {
nodeVersion = "16.20.2"
assembleScript = "run build"
cleanScript = "run clean"
checkScript = "run check"
}
```

4.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-12)

5. Execute the command ```./gradlew build```. This will run tasks associated with the frontend and generate the frontend code.

5.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-14)

6. To run the application, use the command ```./gradlew bootRun```

7. The application can also be started with the command ```./gradlew bootRun```

8. Create a Gradle task to copy the generated jar file to a "dist" folder at the root level of the project.

```groovy
task copyJarToDist(type: Copy) {
	dependsOn build
	from('build/libs')
	into('dist')
	include('*.jar')
	doFirst {
		file('dist').mkdirs()
	}
}
```

8.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-16)

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-17)

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-18)

9. Implement a Gradle task to eliminate all files produced by webpack, typically found at src/resources/main/static/built/.* This new task should be executed automatically by gradle before the task clean.
10. This newly created task should be automatically executed by Gradle prior to the *clean* task.

```groovy
task cleanWebpack(type: Delete) {
    delete 'src/main/resources/static/built/'
}

clean.dependsOn cleanWebpack
```

10.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-19)


11. Lastly, execute the command ```./gradlew clean```

11.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-20)

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-21)

12. Finally, if everything is working as expected merge the branch to the main branch using the following command ```git merge --no-ff tut-basic-gradle```
    
12.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-22)
