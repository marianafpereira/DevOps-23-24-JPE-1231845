# Class Assignment 3 (CA3) Part 2 🛠️

# Introduction and Objectives of Part 2
This section of Class Assignment 3 (CA3) explores the application of virtualization using not only VirtualBox and Vagrant but also presents an alternative solution using Hyper-V. The objective remains the same: to migrate and execute existing projects from previous assignments within a virtualized Ubuntu environment.

This approach ensures a consistent development environment across different systems, isolating all functionalities and dependencies from the host systems. The use of Hyper-V, a virtualization technology developed by Microsoft, provides additional benefits such as improved performance, strong isolation between virtual machines, and compatibility with Windows systems.

The report documents the process of setting up the virtual machine (VM), configuring necessary development tools, and running two specific projects: a Spring Boot tutorial and a Gradle demonstration. It also details the steps to set up and configure the VMs using Hyper-V as the provider for Vagrant.

By offering an alternative solution using Hyper-V, this section provides a comprehensive guide to setting up a virtualized development environment, catering to different system requirements and preferences.

# Table of Contents
1. [Introduction and Objectives of Part 2](#introduction-and-objectives-of-part-2)
2. [Contact Information](#contact-information)
3. [Additional Resources](#additional-resources)
4. [Vagrant Tutorial Guide](#vagrant-tutorial-guide)
   - [Prerequisites](#prerequisites)
   - [Install Vagrant](#install-vagrant)
   - [Create a New Vagrant Project](#create-a-new-vagrant-project)
   - [Initialize Vagrant Box](#initialize-vagrant-box)
   - [Configure Vagrantfile](#configure-vagrantfile)
   - [Start Vagrant Boxes](#start-vagrant-boxes)
   - [SSH into the VM](#ssh-into-the-vm)
   - [Clone Your Project](#clone-your-project)
   - [Navigate to Your Project Directory](#navigate-to-your-project-directory)
   - [Build and Run Your Project](#build-and-run-your-project)
5. [Alternative Solution: Using Hyper-V with Vagrant](#alternative-solution-using-hyper-v-with-vagrant)
   - [Prerequisites](#prerequisites-1)
   - [Install Vagrant](#install-vagrant-1)
   - [Enable Hyper-V](#enable-hyper-v)
   - [Create a New Vagrant Project](#create-a-new-vagrant-project-1)
   - [Initialize Vagrant Box](#initialize-vagrant-box-1)
   - [Configure Vagrantfile](#configure-vagrantfile-1)
   - [Start Vagrant Boxes](#start-vagrant-boxes-1)
   - [SSH into the VM](#ssh-into-the-vm-1)
6. [Conclusion](#conclusion)

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
# Alternative Solution: Using Hyper-V with Vagrant
This guide provides an alternative solution to the previous setup using Hyper-V as the provider for Vagrant. Hyper-V is a virtualization technology from Microsoft available on Windows systems.

## Prerequisites
Before you start, make sure you have the following installed on your system:
- *Vagrant*
- *Hyper-V* (enabled on your Windows system)

1. Install Vagrant
   - Download and install Vagrant from the official website. Verify the installation by running the following command in your terminal:
```bash
    vagrant -v
```

2. Enable Hyper-V
- Enable Hyper-V on your Windows system by following these steps:
  - Open Control Panel.
  - Click on "Programs."
  - Click on "Turn Windows features on or off."
  - Check the box next to "Hyper-V."
  - Click "OK" and restart your computer.

3. Create a New Vagrant Project
- Create a new directory for your Vagrant project and navigate into it:
```bash
    mkdir Part2_alternativa
    cd Part2_alternativa
  ```

4. Initialize Vagrant Box
Initialize the Vagrant box with the Ubuntu 20.04 box compatible with Hyper-V:
```bash
    vagrant init hypervv/ubuntu2004
```

This will create a Vagrantfile in your project directory.

5. Configure Vagrantfile
Open the Vagrantfile in a text editor and replace its content with the configuration provided in your question. This configuration sets up two virtual machines (VMs): a database VM and a webserver VM, both running Ubuntu 20.04.
   This Vagrantfile is used to configure two virtual machines (VMs) for a development environment. Here's a breakdown of what each section does:
- *config.vm.box = ""hypervv/Ubuntu2004":* his line sets the base image for the VMs to Ubuntu 20.04, which is compatible with Hyper-V.
- *config.vm.provider "hyperv" do |hv| ... end:* This block sets the default provider configuration for the VMs. It specifies the number of CPUs, memory size, maximum dynamic memory, and enables linked clones to speed up VM creation.
- *config.vm.provision "shell", inline: <<-SHELL ... SHELL:* This block is a shell provisioner that runs shell commands on the VMs during provisioning. The commands update the package lists and install necessary packages.
- *config.vm.define "db" do |db| ... end:* This block defines a VM named "db". It sets the VM's hostname to "db", configures a private network with a static IP, and provisions the VM to download the H2 database jar file and run the H2 server.
- *config.vm.define "web" do |web| ... end:* This block defines a VM named "web". It sets the VM's hostname to "web", configures a private network with a static IP, and provisions the VM to install Tomcat, clone a Git repository, build a project with Gradle, and run the project.

- [This Vagrantfile](CA3/Part2_alternativa/Vagrantfile) is used to set up a development environment with two VMs: a database VM running an H2 server and a web server VM running a Spring Boot application. The VMs are isolated from each other and the host machine, ensuring a consistent development environment.

6. Start Vagrant Boxes
- Start the Vagrant boxes by running the following command:
```bash
    vagrant up
```

This command will download the Ubuntu 20.04 box (if it's not already downloaded) and start the VMs based on the configuration in the Vagrantfile.
- SSH into the VM

You can SSH into the VMs using the following command:
```bash
    vagrant ssh
```

# Conclusion
Hyper-V was used as an alternative solution for several reasons:

1. **Platform Compatibility**: Hyper-V is a virtualization technology developed by Microsoft and is natively available on Windows 10 Pro, Enterprise, and Education editions. This makes it a convenient choice for developers using these operating systems.

2. **Performance**: Hyper-V is a Type 1 hypervisor, which means it runs directly on the host's hardware. This can lead to better performance compared to Type 2 hypervisors, which run as software on an operating system.

3. **Isolation**: Hyper-V provides strong isolation between virtual machines. This is beneficial in a development environment as it ensures that processes running in one VM do not interfere with those running in another.

4. **Integration with Vagrant**: Vagrant supports Hyper-V as a provider. This means you can manage Hyper-V VMs using the same Vagrant commands as for other providers, providing a consistent workflow.

5. **Support for Advanced Features**: Hyper-V supports advanced virtualization features such as dynamic memory management and virtual hard disk formats. These features can help optimize the use of system resources.

Hyper-V was chosen as an alternative solution due to its compatibility with Windows, performance benefits, strong isolation, integration with Vagrant, and support for advanced features. This further enhances the benefits of using a virtualized development environment, as it allows for more efficient use of system resources, improved performance, and greater flexibility in managing and configuring your development environment.

So, as a conclution, setting up a virtualized development environment using Vagrant and Ubuntu/Hyper-V means that you have created a software-based representation of a physical computer system. This virtual machine (VM) can run an operating system and applications just like a physical computer.  

Vagrant is a tool for building and managing virtual machine environments. It provides a simple command-line client for managing these environments, and an interpreter for the text-based definitions of what each environment looks like, in the form of Vagrantfiles.  

The Vagrantfile you've used sets up two VMs: a database VM and a web server VM. Both VMs are running Ubuntu 20.04 and are isolated from each other and the host machine. This isolation ensures that the development environment is consistent across different systems, as it's not affected by the specific configuration of the host machine.  

The database VM runs an H2 server, a lightweight database that can be embedded in Java applications. The web server VM runs a Spring Boot application, a Java-based framework used to create stand-alone, production-grade Spring based applications.  

The provisioning scripts in the Vagrantfile install necessary packages, clone a Git repository, build a project with Gradle, and run the project. This means that once the VMs are up and running, your project is ready to go.  

In conclusion, by setting up a virtualized development environment using Vagrant and Ubuntu/Hyper-V, you've created a consistent, reproducible, and isolated environment in which to run your project. This can help to reduce the "it works on my machine" problem, where code works on one developer's machine but not on another's due to differences in their setup. It can also make it easier to share your work with others, as they can simply start up the same VM to run your code.