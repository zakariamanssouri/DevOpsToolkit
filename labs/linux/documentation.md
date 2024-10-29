# Linux Command Lab for DevOps Engineers 
This lab will help DevOps beginners get hands-on experience with essential Linux commands commonly used in DevOps tasks such as managing files, monitoring system performance, network diagnostics, and automating tasks.

## Lab Objective:
The objective is to familiarize with essential Linux commands that a DevOps engineer uses in everyday operations. The lab covers:
- File and Directory Management
- Permissions and Ownership
- Process Management
- System Monitoring
- Networking Commands
- Package Management
- Automation and Scheduling

## Lab Setup:
You can use a virtual machine with a Linux distribution (e.g., Ubuntu, CentOS) or a cloud instance like AWS EC2.

### Step 1: File and Directory Management

**Commands:**
- `ls` - List directory contents
- `cd` - Change directories
- `pwd` - Print working directory
- `cp` - Copy files
- `mv` - Move/rename files
- `rm` - Remove files/directories
- `touch` - Create an empty file
- `mkdir` - Create a directory
- `find` - Search for files
- `cat`, `less`, `more` - View file contents
  
**Tasks:**

1. Create a directory called devops_lab.
2. Navigate into devops_lab and create a file called hello.txt.
3. Write “Hello, DevOps” into hello.txt using echo.
4. Copy hello.txt to a file named greeting.txt.
5. Create a directory called logs and move greeting.txt into it.
6. Use find to locate greeting.txt within the current directory.

### Step 2: File Permissions and Ownership

**Commands:**

- `chmod` - Change file permissions
- `chown` - Change file ownership
- `ls -l` - View file permissions and ownership
  
**Tasks:**

1. View the permissions of hello.txt using ls -l.
Change the permissions of hello.txt to make it readable and writable only by the owner.
2. Create a user (if possible in your environment) and change the ownership of hello.txt to the new user.
3. Set hello.txt to be executable by the owner only.

### Step 3: Process Management

**Commands:**

- `ps` - View running processes
- `top/htop` - Monitor system processes
- `kill` - Terminate processes
- `systemctl` - Manage system services
- `service` - Start, stop, restart, or check the status of a service
  
**Tasks:**

- Use ps to list the currently running processes.
- Use top or htop to monitor real-time system performance.
- Start a long-running process like ping google.com.
- In another terminal, find the ping process and kill it using kill.
- Check the status of the SSH service using systemctl status ssh (for Ubuntu) or service sshd status (for CentOS).
  
### Step 4: System Monitoring

**Commands:**
- `df` - View disk space usage
- `du` - Check disk usage of files and directories
- `free` - Check memory usage
- `uptime` - Check system uptime
- `uname -a` - View system information
- `iostat` - Monitor system I/O
- `vmstat` - Monitor memory, processes, and I/O

**Tasks:**
- Use df -h to view disk usage in human-readable format.
- Check the size of the logs directory using du -sh.
- View the amount of free and used memory with free -h.
- Use uptime to see how long the system has been running and the load average.
- Use uname -a to display detailed information about the operating system and kernel version.

### Step 5: Networking Commands

**Commands:**
- `ifconfig` or ip a - View network interfaces
- `ping` - Test connectivity to a network host
- `netstat` or ss - View network connections
- `curl` - Transfer data from/to a server
- `dig` - DNS lookup tool
- `traceroute` - Trace network path to a host

**Tasks:**
- Check the IP address of your machine using ifconfig or ip a.
- Use ping google.com to check if you have internet connectivity.
- Use netstat -tuln to view open ports and active connections.
- Retrieve the content of https://google.com using curl.
- Use dig to get the IP address of google.com.
- Use traceroute to check the network path to google.com.
