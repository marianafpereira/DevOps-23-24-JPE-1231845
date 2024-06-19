# Class Assigment 5

## Introduction

This technical report details the process and steps taken to complete Class Assignment 5 of the DevOps class from the "Switch - Curso de Especialização em Desenvolvimento de Software". The assignment was completed by Mariana F. Pereira, student nº 1231845.

The primary objective of this assignment was to gain practical experience with Jenkins by creating a simple pipeline for the "gradle basic demo" project, which should already be present in the student's individual repository. The pipeline was designed to automate several stages of the development process, including code checkout, assembly, testing, and archiving of artifacts.

The pipeline was configured with a relative path to the Jenkinsfile in the Script Path field, for instance, 'ca2/part1/gradle-basic-demo/Jenkinsfile'. The stages defined in the *Part 1* pipeline include:

1. Checkout: This stage checks out the code from the repository.
2. Assemble: This stage compiles and produces the archive files with the application, without executing the tests.
3. Test: This stage executes the Unit Tests and publishes the Test results in Jenkins.
4. Archive: This stage archives the generated files in Jenkins.

The second part of the assignment involved creating a new pipeline for the "springbootapp" project, which should also be present in the student's individual repository. The pipeline was designed to automate several stages of the development process. The *Part 2* stages were:

1. Checkout: This stage checks out the code from the repository.
2. Assemble: This stage compiles and produces the archive files with the application, without executing the tests.
3. Test: This stage executes the Unit Tests and publishes the Test results in Jenkins.
4. Javadoc: This stage generates the Javadoc of the project and publishes it in Jenkins.
5. Archive: This stage archives the generated files in Jenkins.
6. Publish Image: This stage generates a Docker image with Tomcat and the war file and publishes it in Docker Hub.

This report provides a detailed account of the steps taken to complete the assignment, including the commands used, the issues encountered, and the solutions implemented. The tutorial section provides a step-by-step guide to the assignment tasks.


## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Operating System**: Windows 10 or later.
- **Java**: You need to have Java installed on your machine. The version used for this project is Java 11. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Gradle**: This project uses Gradle for build automation. Make sure you have Gradle installed or use the Gradle Wrapper included in the project. The version used for this project is Gradle 8.6. You can download it from the [official Gradle website](https://gradle.org/releases/).
- **Docker**: Docker is used for creating and managing the Docker images for the project. Make sure you have Docker installed on your machine. You can download it from the [official Docker website](https://www.docker.com/products/docker-desktop).
- **Jenkins**: Jenkins is used for continuous integration and continuous delivery. Make sure you have Jenkins installed on your machine. The version used for this project is the latest available at the time of writing. You can download it from the [official Jenkins website](https://www.jenkins.io/download/).
- **GitHub Account**: You need a GitHub account to clone the repository and push changes. If you don't have one, you can create it on the [GitHub website](https://github.com/join).
- **Docker Hub Account**: You need a Docker Hub account to push Docker images. If you don't have one, you can create it on the [Docker Hub website](https://hub.docker.com/signup).

## Contact Information :email:
For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)

I hope you enjoy working on this assignment and find it insightful in your journey to mastering Gradle and software development practices. Let's dive in and start exploring CA2 Part 2!

## Addicional Information :books:

Start Date: 4, April
End Date: 17, April

- [Git Repository](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845)
- [CA5 Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA5-Home)  where you can find an introdution and a conclusion of this CA2.
- [Glossary CA5](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA5)
- [Project Images For CA5](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA5)

## Table of Contents

- [Class Assignment 5](#class-assignment-5)
    - [Introduction](#introduction)
    - [Configure Jenkins](#configure-jenkins)
    - [Common Configuration Steps](#common-configuration-steps)
    - [Plugins](#plugins)
    - [Credentials](#credentials)
    - [Part 1](#part-1)
    - [Part 2](#part-2)
    - [Troubleshooting](#troubleshooting)
    - [Updates and Maintenance](#updates-and-maintenance)
    - [Security Considerations](#security-considerations)
    - [Final Remarks](#final-remarks)

## Configure Jenkins
Install Jenkins for Windows from the official Jenkins website.

1. Open a terminal in the directory where the Jenkins war file is present and run the following command:

```bash
java -jar jenkins.war --httpPort=8095
```

*Notes* 
- *java -jar jenkins.war*: This part of the command runs the Jenkins war (Web Application Resource or Web application ARchive) file using Java. A war file is a packaged web application directory that can be used to distribute a collection of JavaServer Pages, Java Servlets, Java classes, XML files, tag libraries, static web pages (HTML and related files), and other resources that together constitute a web application.  
- *--httpPort=8095*: This part of the command specifies the HTTP port that Jenkins will listen on. In this case, it's set to 8095. Due to the 8080 being a port that is used frequently. This means that once Jenkins is running, you can access it in your web browser at http://localhost:8095.  

Even though you've already downloaded Jenkins for Windows, you would need to run this command in a terminal to start Jenkins.

2. Access Jenkins at http://localhost:8095.

3. Configure the account and password.

4. Install the suggested plugins.

## Common Configuration Steps

*Gradle Wrapper*: Ensure the gradlew file is updated. If the pipeline breaks with a "*chmod +x ./gradlew*" error, the following command must be run:

```bash
./gradlew wrapper --gradle-version 8.6
```

This step should be applied to both exercises. Additionally, I resolved issues by downloading Gradle Wrapper 8.7 to my computer and committing the changes to the repository.

## Plugins: Install necessary plugins including:

- Docker API Plugin
- Docker Commons Plugin
- Docker Plugin
- Docker Pipeline
- HTML Publisher Plugin
- Pipeline

To do this, go to "*Manage Jenkins*" -> "*Manage Plugins*" -> "*Available*" and search for the plugins. Select the plugins and click "*Install without restart*".

## Credentials
Add credentials for Docker Hub and Git in Jenkins. Go to "*Manage Jenkins*" -> "*Manage Credentials*" -> "*Jenkins*" -> "*Global credentials*" -> "*Add Credentials*". Add the Docker Hub and Git credentials here.

## Part 1

1. Create a Jenkinsfile in the CA5/Part1 folder with the following content:

```groovy
pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/marianafpereira/DevOps-23-24-JPE-1231845.git'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                git url: "${REPO_URL}", branch: 'master'
            }
        }

        stage('Assemble') {
            steps {
                dir('CA2/Part1') {
                    echo 'Assembling the application...'
                    bat 'gradlew.bat assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA2/Part1') {
                    echo 'Running unit tests...'
                    bat 'gradlew.bat test'
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Archive') {
            steps {
                dir('CA2/Part1') {
                    echo 'Archiving artifacts...'
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }
    }
}
```

2. Commit the Jenkinsfile to the repository.

3. Create a new item in Jenkins with the following steps:

- Click on "New Item"
- Enter the item name (e.g., CA5_Part1)
- Select "Pipeline" and click "OK"
- In the "Pipeline" section, select "*Pipeline script*"
- Add the script in the bottom section.
- Click "Save"

4. Run the pipeline by clicking on "Build Now".

5. Check the results of the pipeline (if successful, the build should be green).

## Part 2

1. Create a Jenkinsfile in the CA5/Part2 folder with the following content:

```groovy
pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = '1c973827-c161-4dad-add7-b5dff753d28a'
        DOCKER_IMAGE = 'marifpe/springbootapp'
        DOCKER_TAG = "${env.BUILD_ID}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                git credentialsId: 'cf77afb5-4750-4511-bb27-befba540430e', url: 'https://github.com/marianafpereira/DevOps-23-24-JPE-1231845.git'
            }
        }

        stage('Set Permissions') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Setting executable permissions on gradlew...'
                    bat 'gradlew.bat'
                }
            }
        }

        stage('Assemble') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Assembling the application...'
                    bat './gradlew.bat assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Running unit tests...'
                    bat './gradlew.bat test'
                }
            }
        }

        stage('Javadoc') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Generating Javadoc...'
                    bat './gradlew.bat javadoc'
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'build/docs/javadoc',
                        reportFiles: 'index.html',
                        reportName: 'Javadoc'
                    ])
                }
            }
        }

        stage('Archive') {
            steps {
                dir('CA2/Part2/') {
                    echo 'Archiving artifacts...'
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }

        stage('Create Dockerfile') {
            steps {
                dir('CA2/Part2/') {
                    script {
                        def dockerfileContent = """
                        FROM openjdk:11-jre-slim
                        WORKDIR /app
                        COPY build/libs/*.jar app.jar
                        EXPOSE 8080
                        ENTRYPOINT ["java", "-jar", "app.jar"]
                        """
                        writeFile file: 'Dockerfile', text: dockerfileContent
                    }
                }
            }
        }

        stage('Publish Image') {
            steps {
                script {
                    echo 'Building and publishing Docker image...'
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        dir('CA2/Part2/') {
                            def customImage = docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                            customImage.push()
                            customImage.push('latest')
                        }
                    }
                }
            }
        }
    }
}
```

2. Commit the Jenkinsfile to the repository.

3. Open Docker Desktop and login to Docker Hub.

4. Create a new item in Jenkins with the following steps:

- Click on "*New Item*"
- Enter the item name (e.g., CA5_Part2)
- Select "*Pipeline*" and click "OK"
- In the "*Pipeline*" section, select "*Pipeline script*"
- In the "Script Path" field, enter the path to the Jenkinsfile for Part 2
- Click "Save"
- Run the pipeline by clicking on "Build Now".

5. Check the results of the pipeline (if successful, the build should be green).

6. Check Docker Hub for the created image.

7. Check Docker Desktop for the running container.

8. Access the application at http://localhost:8095/basic-0.0.1-SNAPSHOT.

9. The images can be verified at Docker Hub at the following addresses: The image is now available at https://hub.docker.com/r/marifpe/springbootapp.

## Troubleshooting

This section provides solutions to some common issues you might encounter while setting up and using Jenkins.

1. **Issue**: Jenkins fails to start.
   **Solution**: Ensure that the specified HTTP port is not being used by another service. If it is, change the port number in the command `java -jar jenkins.war --httpPort=8095`.

2. **Issue**: Pipeline fails at the "Checkout" stage.
   **Solution**: Verify that the repository URL and branch name are correct. Also, ensure that Jenkins has the necessary permissions to access the repository.

3. **Issue**: Pipeline fails at the "Assemble" or "Test" stage.
   **Solution**: Check the build.gradle file for errors. Also, ensure that the correct version of Gradle is installed and that the Gradle Wrapper is properly configured.

## Updates and Maintenance

To keep Jenkins and its plugins updated, follow these steps:

1. Go to "*Manage Jenkins*" -> "*Manage Plugins*".
2. Click on the "*Updates*" tab to see available updates.
3. Select the plugins you want to update and click "*Download now and install after restart*".

## Security Considerations

When setting up Jenkins, consider the following security practices:

1. **Access Control**: Ensure that only authorized users have access to Jenkins. You can manage user permissions in "*Manage Jenkins*" -> "*Configure Global Security*".

2. **Secure Credentials**: Store sensitive information like API keys or passwords securely in Jenkins. Use the Credentials Plugin to manage credentials.

3. **Secure Configuration**: Keep Jenkins and all its plugins up to date to benefit from the latest security patches. Regularly review and follow the security recommendations provided by the Jenkins project.


## Final Remarks
In conclusion, this report detailed the process of setting up Jenkins pipelines for a project that uses various technologies including Java, Spring Boot, Gradle, Docker, and Jenkins. The pipelines were designed to automate several stages of the development process, including code checkout, assembly, testing, archiving of artifacts, and publishing Docker images to Docker Hub.

During the process, I encountered some issues which were resolved by downloading the appropriate versions of Gradle Wrapper and updating the Jenkins configurations. These steps ensured the successful execution of the Jenkins pipelines.

Overall, the successful setup of these Jenkins pipelines represents a significant step towards automating and streamlining the development process, thereby improving productivity and efficiency.






