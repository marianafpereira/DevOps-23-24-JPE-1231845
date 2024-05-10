# Class Assignment 3 (CA3) Part 2 🛠️

# Introduction and Objectives of Part 2
This section of Class Assignment 3 (CA3) delves into the application of virtualization using VirtualBox and Vagrant. The goal is to migrate and execute existing projects from previous assignments within a virtualized Ubuntu environment. This approach ensures a consistent development environment across different systems, isolating all functionalities and dependencies from the host systems.  
The report documents the process of setting up the virtual machine (VM), configuring necessary development tools, and running two specific projects: a Spring Boot tutorial and a Gradle demonstration.

# Contact Information
For any inquiries or further discussions related to this project, feel free to reach out:

- Email: 1231845@isep.ipp.pt
- GitHub: [marianafpereira](https://github.com/marianafpereira)
  
# Additional Resources
For more detailed information about this project, please visit the following links:
- [Wiki Home](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/CA3-Part-2-Home);
- [Glossary](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Glossary-CA3-PART-2);
- [Project Images](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/wiki/Project-Images-For-CA3-Part2);
- [Project Repository](https://github.com/marianafpereira/DevOps-23-24-JPE-1231845/tree/master/CA3)

# Vagrant Tutorial Guide
This guide provides a step-by-step tutorial on how to use Vagrant to migrate and execute existing projects within a virtualized Ubuntu environment. This approach ensures a consistent development environment across different systems, isolating all functionalities and dependencies from the host systems.  

## Prerequisites
Before you start, make sure you have the following installed on your system:  
- *Vagrant*
- *VirtualBox* or any other provider supported by Vagrant

1. Install Vagrant
   - Download and install Vagrant from the official website. Verify the installation by running the following command in your terminal:
```bash
    vagrant -v
```

2. Create a New Vagrant Project
- Create a new directory for your Vagrant project and navigate into it:
```bash
    mkdir my-vagrant-project
    cd my-vagrant-project
  ```

3. Initialize Vagrant Box
- Initialize the Vagrant box with the Ubuntu Focal 64-bit box:
- 
```bash
    vagrant init ubuntu/focal64
```

This will create a Vagrantfile in your project directory.

4. Configure Vagrantfile

Open the Vagrantfile in a text editor and replace its content with the configuration provided in your question. This configuration sets up two virtual machines (VMs): a database VM and a webserver VM, both running Ubuntu Focal 64-bit. 

This Vagrantfile is used to configure two virtual machines (VMs) for a development environment. Here's a breakdown of what each section does:  
- *config.vm.box = "ubuntu/focal64":* This line sets the base image for the VMs to Ubuntu 20.04 (Focal Fossa).  
- *config.ssh.insert_key = false:* This line disables automatic key insertion, meaning Vagrant won't replace the default insecure key pair on the first vagrant up.  
- *config.vm.provision "shell", inline: <<-SHELL ... SHELL:* This block is a shell provisioner that runs shell commands on the VMs during provisioning. The commands update the package lists, install necessary packages, and download the H2 database jar file.  
- *config.vm.define "db" do |db| ... end:* This block defines a VM named "db". It sets the VM's hostname to "db", configures a private network with a static IP, sets up port forwarding for the H2 console and server, and provisions the VM to run the H2 server.  
- *config.vm.define "web" do |web| ... end:* This block defines a VM named "web". It sets the VM's hostname to "web", configures a private network with a static IP, sets the VM's memory to 1024 MB, sets up port forwarding for Tomcat, and provisions the VM to install Tomcat, clone a Git repository, build a project with Gradle, and run the project.  

- [This Vagrantfile](CA3/Part2/Vagrantfile) is used to set up a development environment with two VMs: a database VM running an H2 server and a web server VM running a Spring Boot application. The VMs are isolated from each other and the host machine, ensuring a consistent development environment.

5. Start Vagrant Boxes
- Start the Vagrant boxes by running the following command:
```bash
    vagrant up
```

This command will download the Ubuntu Focal 64-bit box (if it's not already downloaded) and start the VMs based on the configuration in the Vagrantfile.

6. SSH into the VM
- You can SSH into the VMs using the following command:

```bash
    vagrant ssh
```

7. Clone Your Project
- Clone your existing project into the VM using Git or any other version control system.
```bash
    git clone https://github.com/marianafpereira/DevOps-23-24-JPE-1231845.git
```

8. Navigate to Your Project Directory
- Navigate to your project directory:
```bash
    cd DevOps-23-24-JPE-1231845/CA2/Part2/
```

9. Build and Run Your Project
- Give executing permissions to the Gradle Wrapper:
```bash
    chmod +x gradlew
```

- Build and clean your project using the Gradle Wrapper:
```bash
    ./gradlew clean build
```

- Run your project:
```bash
    ./gradlew bootRun
```

# Conclusion
You have now successfully set up a virtualized development environment using Vagrant and executed your project within this environment. This setup ensures a consistent development environment across different systems, isolating all functionalities and dependencies from the host systems.
