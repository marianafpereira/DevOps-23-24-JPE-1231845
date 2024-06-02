# CA 4 Part 1: Dockerizing a Chat Server Application
## Overview
In this tutorial, we will create Docker images for a chat server application and run it in containers. We will explore two different approaches to building the Docker image:

1. Building the chat server inside the Dockerfile
2. Building the chat server on the host computer and copying the JAR file into the Dockerfile

We will tag the images and publish them to Docker Hub, and run the chat client on the host computer to connect to the chat server running in the container.

## Contact Information
For any inquiries or further discussions related to this project, feel free to reach out:
- Email: 1231845@isep.ipp.pt
- GitHub: marianafpereira

## Additional Resources
For more detailed information about this project, please visit the following links:

- Wiki Home;
- Glossary;
- Project Images;

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
5. 
## Prerequisites
- Docker installed on your machine
- A Docker Hub account
- Basic knowledge of Docker commands
- Git installed on your machine


## Steps
1. Clone the Chat Application Repository
   First, we need to clone the chat application repository from Bitbucket.
   bash´´´´
   git clone https://bitbucket.org/pssmatos/gradle_basic_demo
   cd gradle_basic_demo
   ´´´´

2. Create Dockerfile for Building Inside Dockerfile
   Create a file named Dockerfile in the root directory of the cloned repository with the following content:

bash´´´´
dockerfile
# Use the OpenJDK 17 slim image as the base
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Update package list and install JRE
RUN apt-get update
RUN apt-get install -y openjdk-17-jre-headless

# Make the gradlew script executable
RUN chmod +x gradlew

# Expose port 8080
EXPOSE 8080

# Command to run the chat server
CMD ["./gradlew", "runServer"]
´´´´

3. Build the Docker Image (Version 1)
   Build the Docker image with the tag chatserver:v1.
   bash´´´´
   docker build -t chatserver:v1 .
   ´´´´

4. Create Dockerfile for Building on Host
   Create another file named Dockerfile.v2 in the root directory of the cloned repository with the following content:

bash´´´´
dockerfile
# Use the OpenJDK 21 slim image as the base
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY /build/libs/basic_demo-0.1.0.jar /app

# Expose port 8080
EXPOSE 8080

# Command to run the chat server
CMD ["java", "-jar", "basic_demo-0.1.0.jar"]
´´´´

5. Build the Chat Server on Host
   Before building the Docker image, we need to build the chat server on the host machine to generate the JAR file.

bash´´´´
./gradlew build
´´´´

6. Build the Docker Image (Version 2)
   Build the Docker image with the tag chatserver:v2 using the second Dockerfile.

bash´´´´
docker build -f Dockerfile.v2 -t chatserver:v2 .
´´´´

7. Run the Docker Container
   Run the Docker container for each version to ensure the chat server is running.

- For Version 1:
  bash´´´´
  docker run -p 8080:8080 chatserver:v1
  ´´´´

- For Version 2:
  bash´´´´
  docker run -p 8080:8080 chatserver:v2
  ´´´´

8. Publish the Docker Image to Docker Hub
   Tag and push the Docker images to Docker Hub. Replace yourusername with your Docker Hub username.

- For Version 1:
  bash´´´´
  docker tag chatserver:v1 yourusername/chatserver:v1
  docker push yourusername/chatserver:v1
  ´´´´

- For Version 2:
  bash´´´´
  docker tag chatserver:v2 yourusername/chatserver:v2
  docker push yourusername/chatserver:v2
  ´´´´

9. Clean Up Docker Resources
   To clean up unused Docker resources, run the following commands:

bash´´´´
docker system prune -a
docker system prune
´´´´

10. Connect Chat Client to Server
    Run the chat client on your host computer and connect to the chat server running in the container. Ensure the client is configured to connect to localhost on port 8080.

## Conclusion
You have successfully Dockerized the chat server application using two different approaches and published the images to Docker Hub. You can now run the chat server in a container and connect to it using the chat client on your host computer.

## Repository Tagging
Finally, tag your repository with ca4-part1 to mark the completion of this assignment.

bash´´´´
git tag ca4-part1
git push origin ca4-part1
´´´´

Feel free to explore more Docker functionalities and enhance your chat application with additional features. Happy Dockerizing!
