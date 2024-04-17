# Class Assignment 2 Part 2

# Introduction :books:

Welcome to the second part of Class Assignment 2! This segment of the assignment is dedicated to the practical application of different build tools: *Gradle*, *Maven*, and *Ant* with *Ivy*. We will be focusing on transforming the basic version of the Tutorial application using these tools. This process will involve setting up a project structure, configuring build files, managing project dependencies, and understanding the use of tasks and plugins in each tool.  

# Objective :pushpin:
The primary goals of Part 2 of Class Assignment 2 are:
1. To establish a comprehensive understanding of different build tools *(Gradle, Maven, and Ant with Ivy)* by setting up a project structure for each.
2. To learn how to configure build files, specifically build.gradle for Gradle, pom.xml for Maven, and build.xml for Ant.
3. To manage project dependencies effectively using Gradle, Maven, and Ant with Ivy.
4. To define and understand the use of tasks and plugins in each build tool.

By accomplishing these objectives, you will gain hands-on experience with these build tools, which are crucial skills in contemporary software development practices.

# Contact Information :email:
For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)

I hope you enjoy working on this assignment and find it insightful in your journey to mastering Gradle and software development practices. Let's dive in and start exploring CA2 Part 2!

# Addicional Information :books:

Start Date: 4, April
End Date: 17, April

- [Git Repository](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845)
- [CA2 Part 2 Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA2-Part2-Home)  where you can find an introdution and a conclusion of this CA2.
- [Glossary CA2 Part 2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA2-PART2)
- [Project Images For CA2 Part2](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2)

# Project Structure :pushpin:
- [Initial Setup](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA2/Part2/README.md#initial-setup-wrench)
- [CA2 Part 2 - Build Tools with Gradle](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA2/Part2/README.md#ca2-part-2---build-tools-with-gradle-hammer_and_wrench)
- [CA2 Part 2 Maven - Alternative solution with Maven](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA2/Part2/README.md#ca2-part-2-maven---alternative-solution-with-maven-%EF%B8%8F)
- [CA2 Part 2 Ant - Alternative solution with Ant](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/blob/master/CA2/Part2/README.md#ca2-part-2-ant---alternative-solution-with-ant)
- [Conclusion](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/tree/master/CA2/Part2#conclusion-books)
  

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

2.1 Refer to the provided image for guidance.

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

12. Finally, if everything is working as expected merge the branch to the main branch using the following command ```git merge --no-ff tut-basic-gradle``` and add the tag ca2-part2
    
12.1 Refer to the provided image for guidance.

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-22)

### CA2 Part 2 Maven - Alternative solution with Maven 🛠️ 

This project is a simple Spring Boot application that uses Maven for dependency management. It incorporates React for the frontend and H2 as an in-memory database. 
Please remember to add the path of Maven to your system's environment variables. This is essential for the system to recognize Maven commands from any location in the command line. Here's how you can do it on a Windows system:
1. Right-click on *'Computer'* and choose *'Properties'*.
2. Click on *'Advanced system settings'*.
3. In the System Properties window that opens, click on *'Environment Variables'*.
4. In the Environment Variables window, scroll down in the *'System variables'* section to find the *'Path'* variable. Select it and click *'Edit'*.
5. In the Edit Environment Variable window, click *'New'* and then add the path to the bin directory of the *Maven* directory. For example, you might add *C:\apache-maven\bin*.
6. Click *'OK'* in all windows to close them.
7. Please replace *C:\apache-maven* with the actual path where you extracted the *Maven* zip file.

#### Prerequisites

- Java 8 or higher
- Maven
- Node.js and npm

#### Instructions

1. Create a new branch called tut-basic-maven using the following command:
   ```groovy
   git checkout -b tut-basic-maven
   ```

1.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-1)

2. Navigate to https://start.spring.io to initiate a new Spring Boot project with Maven. The project should include the following dependencies: Rest Repositories, Thymeleaf, JPA, and H2.  

2.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-2)

3. Unzip the downloaded project file into the "CA2/Part2_maven/" directory of your repository. This gives you a basic Spring application that can be built using Maven.  

4. You can view the available Maven tasks by running the command ```mvn -v ```.  

5. Remove the existing src directory. We aim to use the code from the basic tutorial instead.  

6. Copy the src directory (including all its subdirectories) from the basic tutorial folder to this new folder.  

Also, copy the *webpack.config.js* and *package.json* files.  

7. Delete the src/main/resources/static/built/ directory as it should be generated by the webpack tool from the JavaScript code. 8.1 Refer to the provided image for guidance.  


8. You can now test the application by running the command ```mvn spring-boot:run```. 

9. You'll notice that the webpage at http://localhost:8080 is blank. This is because the Maven build is missing the plugin required to handle the frontend code.

*IMPORTANT NOTE* 

Modify the imports in *Employee.java* from *javax* to *jakarta*. 

1.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-13) 

Insert "packageManager": ```"npm@9.6.7"``` into the package.json file. 

1.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-11)

2. Depending on your Java version (8, 11, or 17), add the corresponding line to the plugins section in pom.xml.

```groovy
    <plugin>
        <groupId>com.github.eirslett</groupId>
        <artifactId>frontend-maven-plugin</artifactId>
        <version>1.9.1</version>
        <configuration>
            <nodeVersion>v16.20.2</nodeVersion>
            <installDirectory>target</installDirectory>
        </configuration>
    </plugin>
```

3. Execute the command ```mvn clean install```. This will run tasks associated with the frontend and generate the frontend code. 
4. To run the application, use the command ```mvn spring-boot:run```  
5. The application can also be started with the command ```mvn spring-boot:run```  
6. Create a Maven task to copy the generated *jar* file to a *"dist"* folder at the root level of the project. This can be done by adding the following plugin to your *pom.xml* file:

```groovy
<plugin>
    <artifactId>maven-resources-plugin</artifactId>
    <version>3.2.0</version>
    <executions>
        <execution>
            <id>copy-jar</id>
            <phase>package</phase>
            <goals>
                <goal>copy-resources</goal>
            </goals>
            <configuration>
                <outputDirectory>${project.basedir}/dist</outputDirectory>
                <resources>
                    <resource>
                        <directory>${project.build.directory}</directory>
                        <includes>
                            <include>*.jar</include>
                        </includes>
                    </resource>
                </resources>
            </configuration>
        </execution>
    </executions>
</plugin>
```

7. Implement a Maven task to eliminate all files produced by webpack, typically found at *src/resources/main/static/built/.* This new task should be executed automatically by Maven before the task clean. This newly created task should be automatically executed by Maven prior to the clean task.

```groovy
<plugin>
    <artifactId>maven-clean-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <filesets>
            <fileset>
                <directory>src/main/resources/static/built</directory>
                <includes>
                    <include>**/*</include>
                </includes>
            </fileset>
        </filesets>
    </configuration>
</plugin>
```

8. Lastly, execute the command ```mvn clean``` 
9. Finally, if everything is working as expected merge the branch to the main branch using the following command ```git merge --no-ff tut-basic-maven``` and add the *tag ca2-part2*

#### Files Explanation
- *pom.xml:* This is the Project Object Model file that Maven uses. It contains information about the project and configuration details used by Maven to build the project. It includes the project dependencies, plugins, goals, build profiles, project version, and many other settings.  
- *settings.xml:* This file is used by Maven for configuration of environment specific settings. It includes settings such as the repository locations, proxy configurations, server credentials and properties that can be used in POM files. This file is typically located in the *.m2* directory in the user's home directory, but its location can be customized.  
- *.mvn:* This is a directory that can be located at the project's root directory. It contains the jvm.config and maven.config files which are used to configure JVM and Maven options respectively. The extensions.xml file can also be placed here to declare extensions that should be used by Maven.  
- *mvnw* and *mvnw.cmd:* These are the *"Maven Wrapper"* scripts for Unix-based systems *(mvnw)* and Windows *(mvnw.cmd)*. They are used to run the project with a specific version of Maven, even if it's not installed on the system. The version of Maven to be used is specified in the *.mvn/wrapper/maven-wrapper.properties file.*

### CA2 Part 2 Ant - Alternative solution with Ant 🛠️ 

This project is a straightforward Spring Boot application that utilizes Ant and Ivy for dependency management. It employs React for the frontend and H2 as an in-memory database.  
Please remember to add the path of Ant and Ivy to your system's environment variables. This is crucial for the system to recognize Ant and Ivy commands from any location in the command line. Here's how you can do it on a Windows system:  
1. Right-click on *'Computer'* and choose *'Properties'*.
2. Click on *'Advanced system settings'*.
3. In the System Properties window that opens, click on *'Environment Variables'*.
4. In the Environment Variables window, scroll down in the *'System variables'* section to find the *'Path'* variable. Select it and click *'Edit'*.
5. In the Edit Environment Variable window, click *'New'* and then add the path to the bin directory of the *Ant* and *Ivy* directories. For example, you might add *C:\apache-ant\bin* and *C:\apache-ivy\bin*.
6. Click *'OK'* in all windows to close them.
7. Please replace *C:\apache-ant* and *C:\apache-ivy* with the actual paths where you extracted the *Ant* and *Ivy* zip files.

#### Prerequisites

- Java 8 or higher
- Ant
- Ivy
- Node.js and npm

#### Instructions

1. Create a new branch called tut-basic-maven using the following command:
   ```bash
   git checkout -b tut-basic-maven
   ```

1.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-1)

2. Navigate to https://start.spring.io to initiate a new Spring Boot project with Ant. The project should include the following dependencies: Rest Repositories, Thymeleaf, JPA, and H2.  

2.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-2)

3. Unzip the downloaded project file into the "CA2/Part2_ant/" directory of your repository. This gives you a basic Spring application that can be built using Maven.

4. Remove the existing src directory. We aim to use the code from the basic tutorial instead.  

5. Copy the src directory (including all its subdirectories) from the basic tutorial folder to this new folder.  

Also, copy the *webpack.config.js* and *package.json* files.  

6. Delete the src/main/resources/static/built/ directory as it should be generated by the webpack tool from the JavaScript code. 8.1 Refer to the provided image for guidance.  


*IMPORTANT NOTE* 

Modify the imports in *Employee.java* from *javax* to *jakarta*. 

1.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-13) 

Insert "packageManager": ```"npm@9.6.7"``` into the package.json file. 

1.1 Refer to the provided image for guidance.  

![image example](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA2-Part2#step-11)

2. Add the necessary Ant tasks to the build.xml file to handle the frontend build. This might involve running npm scripts or other commands

```xml
<target name="init-frontend">
    <exec executable="npm" dir="src/main/frontend">
        <arg value="install"/>
    </exec>
</target>

<target name="build-frontend" depends="init-frontend">
    <exec executable="npm" dir="src/main/frontend">
        <arg value="run"/>
        <arg value="build"/>
    </exec>
</target>

<target name="clean-frontend">
    <delete dir="src/main/frontend/dist"/>
</target>
```

3. Create an ivy.xml file for dependency management. ou can use the provided `ivy.xml` as a reference, but make sure to adjust the dependencies according to your project's needs. Here's a basic example:
```xml
<ivy-module version="2.0">
   <info organisation="com.greglturnquist" module="react-and-spring-data-rest-basic" revision="0.0.1-SNAPSHOT" status="integration" publication="20220226123233"/>
   <configurations>
      <conf name="default" visibility="public"/>
      <conf name="runtime" visibility="public"/>
      <conf name="test" visibility="public"/>
   </configurations>
   <dependencies>
      <dependency org="org.springframework.boot" name="spring-boot-starter-parent" rev="2.2.4.RELEASE" conf="default->default"/>
      <dependency org="org.springframework.boot" name="spring-boot-starter-thymeleaf" rev="2.2.4.RELEASE" conf="default->default"/>
      <dependency org="org.springframework.boot" name="spring-boot-starter-data-jpa" rev="2.2.4.RELEASE" conf="default->default"/>
      <dependency org="org.springframework.boot" name="spring-boot-starter-data-rest" rev="2.2.4.RELEASE" conf="default->default"/>
      <dependency org="org.springframework.boot" name="spring-boot-devtools" rev="2.2.4.RELEASE" conf="default->default"/>
      <dependency org="com.h2database" name="h2" rev="1.4.200" conf="runtime->default"/>
      <dependency org="org.springframework.boot" name="spring-boot-starter-test" rev="2.2.4.RELEASE" conf="test->default"/>
      <dependency org="jakarta.persistence" name="jakarta.persistence-api" rev="3.0.0"/>
      <dependency org="org.junit.jupiter" name="junit-jupiter-api" rev="5.7.0" conf="test->default"/>
      <dependency org="org.springframework" name="spring-context" rev="5.2.3.RELEASE" conf="default->default"/>
      <dependency org="org.springframework" name="spring-webmvc" rev="4.1.6.RELEASE" conf="default->default"/>
      <dependency org="ch.qos.logback" name="logback-classic" rev="1.2.3" conf="default->default"/>
   </dependencies>
</ivy-module>
```

4. Create an `ivysettings.xml` file to specify the repositories Ivy should use to resolve dependencies. Here's a basic example:

```xml
<ivysettings>
    <settings defaultResolver="central"/>
    <caches defaultCacheDir="${user.home}/.ivy2/cache"/>
    <resolvers>
        <ibiblio name="central" m2compatible="true" root="https://repo1.maven.org/maven2"/>
    </resolvers>
</ivysettings>
```

5. Run `ant resolve` to resolve and retrieve dependencies using Ivy.
6. Run `ant clean build` to build the project and generate the frontend code.
7. Start the application. This might involve running a Java command or an Ant task, depending on how your project is set up. In this project is `ant run`
8. Create an Ant task to copy the generated .jar file to a dist folder at the root level of the project.

```xml
<target name="copy-jar" depends="dist" description="copy the .jar file to a dist folder">
    <copy file="${dist}/Part2_ant.jar" todir="${basedir}/dist" overwrite="true"/>
</target>
```

9. Implement an Ant task to delete all files produced by webpack, typically found at src/main/resources/static/built/. This task should be executed automatically by Ant before the clean task.
```xml
   <target name="clean-webpack" description="delete webpack output">
    <delete dir="src/main/resources/static/built"/>
</target>
```

10. Run `ant clean` to clean the project.
11. Finally, if everything is working as expected merge the branch to the main branch using the following command ```git merge --no-ff tut-basic-maven``` and add the *tag ca2-part2*


#### Files Explanation
- *build.xml:* This is the build file that Ant uses. It contains targets, which are sets of tasks that Ant should execute. Each task is a piece of code that can be run. Targets can depend on other targets, and Ant ensures that the dependencies are run before the dependent target.
- *ivy.xml:* This file is used by Ivy for dependency management. It lists all the dependencies that your project needs, and Ivy will ensure that these dependencies are available for your project to use.  
- *ivysettings.xml:* This file is used by Ivy to understand where to find the dependencies that your project needs. It lists the repositories that Ivy should use to resolve dependencies.


### Conclusion :books:

Throughout this assignment, we explored three different build tools: Gradle, Maven, and Ant with Ivy. Each tool has its unique characteristics and advantages, and the choice between them often depends on the specific needs of a project.  
Gradle is a powerful and flexible build tool that uses a Groovy-based DSL for its configuration files. It offers a high degree of customization and is known for its performance, thanks to its incremental build feature. Gradle also seamlessly integrates with many IDEs and CI/CD tools, making it a popular choice for many developers.  
Maven, on the other hand, is a more traditional build tool that uses XML for its configuration files. It follows a convention-over-configuration approach, which can make it easier to use for simple projects. Maven also has a vast ecosystem of plugins and is widely adopted in the Java community.  
Ant with Ivy is another flexible and powerful build tool. Ant uses XML for its configuration files and allows for a high degree of customization. Ivy is a dependency manager that can be used in conjunction with Ant to handle project dependencies.  
In this assignment, i implemented the same project using all three build tools. This allowed me to compare their features and understand their differences. However, i've encountered some difficulties with the Ant/Ivy solution, specifically with integrating the frontend. This highlights the importance of choosing the right tool for the job, considering not only the tool's features but also its compatibility with the technologies used in the project.  
Reflecting on the importance of this assignment, it provided a valuable opportunity to gain hands-on experience with different build tools. This is a crucial skill in software development, as build tools play a vital role in automating the build and deployment process. By implementing the same project with different tools, i has able to understand their strengths and weaknesses, which will help me make informed decisions in future projects. Furthermore, the challenges i faced and overcame during this assignment have enriched my problem-solving skills and deepened our understanding of build automation.
