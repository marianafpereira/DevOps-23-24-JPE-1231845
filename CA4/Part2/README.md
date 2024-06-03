# CA4 Part 2 - Dockerized Spring Basic Tutorial Application
## Overview
In this assignment, we will be exploring the process of containerizing a Gradle-based Spring application and an H2 database using Docker. We will also delve into orchestrating these containers using Docker Compose. Furthermore, we will discuss an alternative approach to orchestration using Kubernetes, a powerful container orchestration platform. 

This guide will walk you through the necessary steps, from writing Dockerfiles, creating a Docker Compose file, building and running the containers, to publishing them on Docker Hub. We will also cover how to backup the database file using Docker volumes. 

Lastly, we will touch upon how to deploy the application and the database within a Kubernetes cluster, enhancing the scalability and availability of the application.

# Contact Information
For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)

# Additional Resources
For more detailed information about this project, please visit the following links:
- [Wiki Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA4-Part-2-Home);
- [Glossary](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA4-PART-2);
- [Project Images](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA4-Part2);

## Index
1. [Prerequisites](#prerequisites)
2. [Writing Dockerfiles](#writing-dockerfiles)
   - [Dockerfile.web](#dockerfileweb)
   - [Dockerfile.db](#dockerfiledb)
3. [Creating the run.sh Script](#creating-the-runsh-script)
4. [Writing docker-compose.yml](#writing-docker-composeyml)
5. [Building and Running the Containers](#building-and-running-the-containers)
6. [Publishing to Docker Hub](#publishing-to-docker-hub)
7. [Using Volumes to Backup Database](#using-volumes-to-backup-database)
8. [Tagging the Repository](#tagging-the-repository)
9. [Alternative Implementation Solution](#alternative-implementation-solution)
   - [Installing Kubernetes](#installing-kubernetes)
   - [Creating Kubernetes Deployment Files](#creating-kubernetes-deployment-files)
      - [Web Application Deployment File](#web-application-deployment-file)
      - [Web Application Service File](#web-application-service-file)
      - [Database Deployment File](#database-deployment-file)
      - [Database Service File](#database-service-file)
   - [Applying Deployment Files to Kubernetes Cluster](#applying-deployment-files-to-kubernetes-cluster)
   - [Checking Status of Deployments and Services](#checking-status-of-deployments-and-services)
10. [Conclusion](#conclusion)

## Prerequisites
- Docker: Install Docker
- Docker Compose: Install Docker Compose
- Docker Hub account: Sign up

## Step-by-Step Guide
### 1. Writing Dockerfiles
Dockerfiles are scripts that contain collections of commands for the Docker image. These commands automate the process of setting up and configuring the Docker environment.

- Dockerfile.web:

```bash 
# Dockerfile
FROM ubuntu:20.04

# Install required packages
# We're using the Ubuntu 20.04 image and installing OpenJDK 17 and dos2unix.
# OpenJDK 17 is the Java Development Kit, which we need to run our Java application.
# dos2unix is a tool to convert line endings in text files, which can be useful when moving files between different operating systems.
RUN apt-get update && \
    apt-get install -y openjdk-17-jre-headless dos2unix && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
# This is where our application code will live within the Docker container.
WORKDIR /app

# Copy the application code
# This copies our local application code into the Docker container.
COPY . /app

# Convert line endings and set executable permissions on gradlew
# This ensures that our Gradle Wrapper script (gradlew) has the correct line endings and can be executed.
RUN dos2unix gradlew && \
    chmod +x gradlew

# Expose the application port
# This makes the specified network port available to outside connections. Our application will be accessible on this port.
EXPOSE 8080

# Add a script to run the necessary commands
# This script will be run when the Docker container starts up.
COPY run.sh /app/run.sh
RUN chmod +x /app/run.sh

# Set the entry point to the script
# This tells Docker to execute our script when the container starts.
ENTRYPOINT ["/app/run.sh"]
```

- Dockerfile.db:
``` bash 
# Dockerfile
# We're using the Ubuntu 20.04 image as our base image.
FROM ubuntu:20.04

# We're updating the package lists for upgrades and new package installations.
# Then, we're installing OpenJDK 17, unzip, and wget.
# OpenJDK 17 is the Java Development Kit, which we need to run our Java application.
# Unzip and wget are utilities to handle archives and download files from the web.
# After installing, we're cleaning up the package lists to free up space.
RUN apt-get update && \
  apt-get install -y openjdk-17-jdk-headless unzip wget && \
  apt-get clean && \
  rm -rf /var/lib/apt/lists/*

# We're creating a directory to hold our application.
RUN mkdir -p /usr/src/app

# We're setting this as our working directory. This is where our application will live within the Docker container.
WORKDIR /usr/src/app/

# We're downloading the H2 Database jar file and saving it as /opt/h2.jar.
RUN wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar -O /opt/h2.jar

# We're exposing ports 8082 and 9092. These ports will be available to outside connections.
EXPOSE 8082
EXPOSE 9092

# We're starting the H2 Server. The -web and -tcp options start the web and TCP interfaces.
# The -webAllowOthers and -tcpAllowOthers options allow connections from other than localhost.
# The -ifNotExists option allows to create the database file if it doesn't exist.
CMD java -cp /opt/h2.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists
```

### 2. Creating the run.sh Script
   run.sh:
``` bash 
#!/bin/bash

# The Gradle Wrapper is a feature of Gradle that downloads and installs the correct version of Gradle for this project.
# It's a shell script that invokes a declared version of Gradle, downloading it beforehand if necessary.
# Here, we're using it to run the 'bootRun' task, which starts the Spring Boot application.
./gradlew bootRun

# This command starts the ChatServerApp.
# 'java -cp' sets the class path, which is where Java looks for user-defined classes.
# 'build/libs/basic_demo-0.1.0.jar' is the path to the jar file that contains the compiled ChatServerApp class.
# 'basic_demo.ChatServerApp' is the fully qualified name of the ChatServerApp class.
# '59003' is an argument passed to the ChatServerApp, likely specifying the port number the server should listen on.
java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp 59003
``` 

### 3. Writing docker-compose.yml:
``` bash
version: '3'
services:
  db:
    build:
      # The context is the directory containing the Dockerfile and any files you want to include in the image.
      # Here, it's set to the current directory.
      context: .
      # The Dockerfile to use. It must be within the context.
      dockerfile: Dockerfile.db
    ports:
      # The ports that this service should expose to the host machine.
      # The format is <host_port>:<container_port>.
      - "8082:8082"
      - "9092:9092"
    volumes:
      # The volumes that this service has access to.
      # The format is <volume_name>:<container_path>.
      # h2-data is a named volume, and /usr/src/data-backup is a path in the container.
      - h2-data:/usr/src/data-backup
      # This is a bind mount, which mounts a directory from the host machine into the container.
      # The host directory is the absolute path on the host machine.
      - "C:/Users/Mariana/OneDrive - Instituto Superior de Engenharia do Porto/Documents/GitHub/DevOps-23-24-JPE-1231845/CA4/Part2/db:/h2-backup/"
    networks:
      default:
        # The IP address that this service should have on the default network.
        ipv4_address: 192.168.33.11

  web:
    build:
      context: .
      dockerfile: Dockerfile.web
    ports:
      - "8080:8080"
    networks:
      default:
        ipv4_address: 192.168.33.10
    # This service depends on the db service.
    # Docker Compose will start the db service before this one.
    depends_on:
      - "db"

networks:
  default:
    ipam:
      driver: default
      config:
        # The subnet that the default network should use.
        - subnet: 192.168.33.0/24

volumes:
  # This declares a named volume that can be used by services.
  h2-data:
```

### 4. To build and run the containers, navigate to the project directory and execute:
``` bash 
docker-compose up --build
```

### 5. Publishing to Docker Hub:

5.1. Log in to Docker Hub

5.2. Tag and push the images to Docker Hub:
- For the web service:
``` bash 
docker tag <local_web_image> <your_dockerhub_username>/web:latest
docker push <your_dockerhub_username>/web:latest
```

- For the db service:
``` bash 
docker tag <local_db_image> <your_dockerhub_username>/db:latest
docker push <your_dockerhub_username>/db:latest
```

### 6. Using Volumes to Backup Database

6.1. To backup the database file:
- Identify the running db container ID:
  
``` bash 
docker ps
```

- Copy the database file from the container to the volume:
``` bash
docker exec <db_container_id> cp -r /data/mydatabase.db /usr/src/data-backup/
```

### 7. After completing the assignment, tag your repository:
``` bash 
git tag ca4-part2
git push origin ca4-part2
```

## Alternative Implementation Solution - Kubernetes

In the realm of container orchestration, Kubernetes stands out as a robust, open-source platform designed to automate the deployment, scaling, and management of containerized applications. As an alternative solution to our current Docker-based setup, Kubernetes offers a range of advantages that make it an attractive choice for managing complex applications.

Kubernetes operates based on a declarative model, meaning we define the desired state for our applications, and Kubernetes takes care of ensuring that the system matches this state. This approach simplifies many operational aspects, such as rolling updates and rollbacks, service discovery, and load balancing.

One of the key strengths of Kubernetes is its ability to manage multi-container applications across multiple machines, enhancing both scalability and availability. It can efficiently distribute and schedule containers across the cluster, handle failures, and scale applications based on demand.

In our context, deploying our application and database within a Kubernetes cluster would mean encapsulating them in separate pods. The application would then establish a connection to the database using the service name, promoting a better separation of concerns and improved management of the application and the database.

By choosing Kubernetes, we are opting for a platform that not only meets our current needs but also provides the flexibility and scalability to accommodate future growth and complexity. It's a strategic choice that aligns with best practices for container orchestration and paves the way for a more resilient and efficient application infrastructure.

Firstly, you need to install Kubernetes so use this command:
``` bash
curl.exe -LO "https://dl.k8s.io/release/v1.30.0/bin/windows/amd64/kubectl.exe"
```

After pushing the Docker images to Docker Hub, we would need to create Kubernetes deployment files for both the application and the database. The deployment files could look like this:  
### 1. Web application deployment file:
``` bash
apiVersion: apps/v1  # This specifies the version of the Kubernetes API you're using to create this object.
kind: Deployment  # This indicates that you're creating a Deployment, which is a Kubernetes object that represents a set of identical pods.
metadata:
  name: ca4-part2-web  # This sets the name of the Deployment to "ca4-part2-web".
spec:
  replicas: 1  # This specifies that the Deployment should ensure there is one replica of your pod running.
  selector:
    matchLabels:
      app: ca4-part2-web  # This is the label selector for the pods that this Deployment manages. It matches any pods with the label "app=ca4-part2-web".
  template:
    metadata:
      labels:
        app: ca4-part2-web  # This sets the labels for the pods that will be created by this Deployment. Here, it's setting the "app" label to "ca4-part2-web".
    spec:
      containers:
      - name: ca4-part2-web  # This sets the name of the container to "ca4-part2-web".
        image: marifpe/devops_23_24:CA4_Part2_web  # This specifies the Docker image to use for the container. It's using the "CA4_Part2_web" image from the "marifpe/devops_23_24" repository on Docker Hub.
        ports:
        - containerPort: 8080  # This exposes port 8080 in the container to allow network connections.
```
### 2. Web application service file:
``` bash
apiVersion: v1  # This specifies the version of the Kubernetes API you're using to create this object.
kind: Service  # This indicates that you're creating a Service, which is a Kubernetes object that abstracts the way to access a set of Pods.
metadata:
  name: ca4-part2-web  # This sets the name of the Service to "ca4-part2-web".
spec:
  type: NodePort  # This sets the type of the Service to NodePort, which means it's accessible on a static port on each Node.
  ports:
  - port: 8080  # This is the port that the Service will listen on.
    targetPort: 8080  # This is the port that the Service will forward incoming connections to.
    nodePort: 30080  # This is the port that the Service will be accessible on each Node.
  selector:
    app: ca4-part2-web  # This is the label selector for the Pods that this Service should route traffic to. It matches any Pods with the label "app=ca4-part2-web".
```
### 3. Database deployment file:
``` bash
apiVersion: apps/v1  # This specifies the version of the Kubernetes API you're using to create this object.
kind: Deployment  # This indicates that you're creating a Deployment, which is a Kubernetes object that represents a set of identical pods.
metadata:
  name: ca4-part2-db  # This sets the name of the Deployment to "ca4-part2-db".
spec:
  replicas: 1  # This specifies that the Deployment should ensure there is one replica of your pod running.
  selector:
    matchLabels:
      app: ca4-part2-db  # This is the label selector for the pods that this Deployment manages. It matches any pods with the label "app=ca4-part2-db".
  template:
    metadata:
      labels:
        app: ca4-part2-db  # This sets the labels for the pods that will be created by this Deployment. Here, it's setting the "app" label to "ca4-part2-db".
    spec:
      containers:
      - name: ca4-part2-db  # This sets the name of the container to "ca4-part2-db".
        image: marifpe/devops_23_24:CA4_Part2_db  # This specifies the Docker image to use for the container. It's using the "CA4_Part2_db" image from the "marifpe/devops_23_24" repository on Docker Hub.
        ports:
        - containerPort: 8082  # This exposes port 8082 in the container to allow network connections.
        - containerPort: 9092  # This exposes port 9092 in the container to allow network connections.
```
### 4. Database service file:
``` bash
apiVersion: v1  # This specifies the version of the Kubernetes API you're using to create this object.
kind: Service  # This indicates that you're creating a Service, which is a Kubernetes object that abstracts the way to access a set of Pods.
metadata:
  name: ca4-part2-db  # This sets the name of the Service to "ca4-part2-db".
spec:
  type: NodePort  # This sets the type of the Service to NodePort, which means it's accessible on a static port on each Node.
  ports:
  - name: db-port-8082  # This is the name of the port (for reference purposes within Kubernetes).
    port: 8082  # This is the port that the Service will listen on.
    targetPort: 8082  # This is the port that the Service will forward incoming connections to.
    nodePort: 30082  # This is the port that the Service will be accessible on each Node.
  - name: db-port-9092  # This is the name of the port (for reference purposes within Kubernetes).
    port: 9092  # This is the port that the Service will listen on.
    targetPort: 9092  # This is the port that the Service will forward incoming connections to.
    nodePort: 30092  # This is the port that the Service will be accessible on each Node.
  selector:
    app: ca4-part2-db  # This is the label selector for the Pods that this Service should route traffic to. It matches any Pods with the label "app=ca4-part2-db".
```

### 5. After creating the deployment files, you can apply them to the Kubernetes cluster using the following command:
``` bash
kubectl apply -f web-deployment.yaml
kubectl apply -f web-service.yaml
kubectl apply -f db-deployment.yaml
kubectl apply -f db-service.yaml
```

### 6. You can check the status of your deployments and services using the following commands:
``` bash
kubectl get deployments
kubectl get services
```

Kubernetes uses a declarative approach to manage the state of the cluster, which means we define the desired state of the cluster in a YAML file and Kubernetes ensures that the cluster maintains that state. This allows for better cluster management and improved scalability and availability of the application.  

It's common to use Docker and Kubernetes together. Docker is used to build the images, and Kubernetes is used to deploy and manage the containers. This allows for better separation of concerns and improved management of the application and the database

## Conclusion

Congratulations! You have successfully navigated through the process of setting up a Dockerized environment for running a Gradle-based Spring application and an H2 database. This guide has provided you with a comprehensive understanding of how to build Docker images, run them, publish them on Docker Hub, and backup the database file.

Moreover, you have been introduced to an alternative solution involving Kubernetes, a powerful container orchestration platform. This approach enhances the scalability and availability of the application, promoting a better separation of concerns and improved management of the application and the database. By creating Kubernetes deployment files for both the application and the database, you have learned how Kubernetes' declarative approach to cluster management, combined with Docker for building images, provides a robust and efficient solution for deploying and managing your application.

This knowledge will be invaluable as you continue to explore the world of containerization and orchestration, equipping you with the skills to handle real-world scenarios in a professional setting.