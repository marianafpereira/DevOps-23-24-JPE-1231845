# CA 4 Part 1: Dockerizing a Chat Server Application
## Overview
Welcome to the first part of our Continuous Assessment (CA) 4 project. In this section, we delve into the world of Docker, a powerful platform that simplifies the process of managing application processes in containers.

Our journey will revolve around a chat server application. We will create Docker images for this application and run it in containers, providing a practical, hands-on experience with Docker.

We will explore two distinct methodologies for building the Docker image:

1. Building the chat server inside the Dockerfile.
2. Building the chat server on the host computer and copying the JAR file into the Dockerfile.

In addition, we will tag these images and publish them to Docker Hub, a cloud-based registry service that allows you to link to code repositories, build your images and test them, store manually pushed images, and link to Docker Cloud for full-service deployment.

To test our setup, we will run the chat client on the host computer to connect to the chat server running in the container. This will provide a clear demonstration of the practical application of Docker in a real-world scenario.

This tutorial assumes that you have Docker installed on your machine, a Docker Hub account, basic knowledge of Docker commands, and Git installed on your machine. If you're new to Docker, don't worry! We'll guide you through each step of the process.

Let's get started on this exciting journey into the world of Docker!

## Contact Information
For any inquiries or further discussions related to this project, feel free to reach out:
- Email: 1231845@isep.ipp.pt
- GitHub: marianafpereira

# Additional Resources
For more detailed information about this project, please visit the following links:
- [Wiki Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA4-Part-1-Home);
- [Glossary](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA4-PART-1);
- [Project Images](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA4-Part1);

## Index:
1. Prerequisites
2. Steps
- Clone the Chat Application Repository
- Create Dockerfile for Building Inside Dockerfile
- Build the Docker Image (Version 1)
- Create Dockerfile for Building on Host
- Build the Chat Server on Host
- Build the Docker Image (Version 2)
- Run the Docker Container
-Publish the Docker Image to Docker Hub
-Clean Up Docker Resources
-Connect Chat Client to Server
3. Conclusion
4. Repository Tagging


## Prerequisites
- Docker installed on your machine
- A Docker Hub account
- Basic knowledge of Docker commands
- Git installed on your machine


## Steps
1. First, we need to clone the chat application repository from Bitbucket.
 ``` bash
   git clone https://bitbucket.org/pssmatos/gradle_basic_demo
   cd gradle_basic_demo
 ```

2. Create a file named Dockerfile in the root directory of the cloned repository with the following content:

 ``` bash
#Dockerfile
# Use the OpenJDK 17 slim image as the base. This image includes the Java Development Kit (JDK) version 17, which we need to run our Java application.
FROM openjdk:17-jdk-slim

# Set the working directory in the Docker image to /app. All subsequent commands (like COPY and RUN) will be executed in this directory.
WORKDIR /app

# Copy the current directory contents (on your host machine) into the /app directory in the Docker image.
COPY . /app

# Update the package list in the Docker image. This is necessary to install new packages onto the image.
RUN apt-get update

# Install the Java Runtime Environment (JRE) version 17. The JRE allows us to run our Java application.
RUN apt-get install -y openjdk-17-jre-headless

# Make the gradlew script executable. This script is used to start our Java application.
RUN chmod +x gradlew

# Expose port 8080 in the Docker image. This allows us to access our application on this port.
EXPOSE 8080

# Define the command to run our Java application. This command will be executed when a container is started from the Docker image.
CMD ["./gradlew", "runServer"]
 ```

3. Build the Docker Image (Version 1) with the tag chatserver:v1.
 ``` bash
   docker build -t chatserver:v1 .
 ```

4. Create Dockerfile for Building on Host
   
 ``` bash
#Dockerfile
# Use the OpenJDK 21 slim image as the base. This image includes the Java Development Kit (JDK) version 21, which we need to run our Java application.
FROM openjdk:21-jdk-slim

# Set the working directory in the Docker image to /app. All subsequent commands (like COPY and CMD) will be executed in this directory.
WORKDIR /app

# Copy the built JAR file from your host machine into the /app directory in the Docker image. The JAR file is the executable version of your application.
COPY /build/libs/basic_demo-0.1.0.jar /app

# Expose port 8080 in the Docker image. This allows us to access our application on this port from outside the Docker container.
EXPOSE 8080

# Define the command to run our Java application. This command will be executed when a container is started from the Docker image.
CMD ["java", "-jar", "basic_demo-0.1.0.jar"]
 ```

5. Before building the Docker image, we need to build the chat server on the host machine to generate the JAR file.

 ``` bash
./gradlew build
 ```

6. Build the Docker Image (Version 2) with the tag chatserver:v2 using the second Dockerfile.

 ``` bash
docker build -f Dockerfile.v2 -t chatserver:v2 .
 ```

7. Run the Docker Container for each version to ensure the chat server is running.

- For Version 1:
 ``` bash
  docker run -p 8080:8080 chatserver:v1
 ```

- For Version 2:
 ``` bash
  docker run -p 8080:8080 chatserver:v2
 ``` 

8. Tag and push the Docker images to Docker Hub. Replace yourusername with your Docker Hub username.

- For Version 1:
 ``` bash
  docker tag chatserver:v1 yourusername/chatserver:v1
  docker push yourusername/chatserver:v1
 ```

- For Version 2:
 ``` bash
  docker tag chatserver:v2 yourusername/chatserver:v2
  docker push yourusername/chatserver:v2
 ```

9. Clean Up Docker Resources

 ``` bash
docker system prune -a
docker system prune
 ```

10. Run the chat client on your host computer and connect to the chat server running in the container. Ensure the client is configured to connect to localhost on port 8080.

## Conclusion
 You've successfully navigated the process of Dockerizing a chat server application, employing two distinct methodologies. Not only have you built Docker images for your application, but you've also published them on Docker Hub, a significant milestone in your journey.

Now, you have the capability to run your chat server within a Docker container, providing a consistent and isolated environment for your application. Furthermore, you've demonstrated the ability to connect to this server using a chat client on your host machine, illustrating the practical application of your efforts.

This accomplishment underscores your growing proficiency in Docker, a crucial tool in modern software development. As you continue to explore and apply these concepts, you'll be well-equipped to tackle more complex scenarios, enhancing your skill set and expanding your understanding of containerization. Keep up the excellent work!

## Repository Tagging
Finally, tag your repository with ca4-part1 to mark the completion of this assignment.

 ``` bash
git tag ca4-part1
git push origin ca4-part1
 ```

Feel free to explore more Docker functionalities and enhance your chat application with additional features. Happy Dockerizing!
