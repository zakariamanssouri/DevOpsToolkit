
# DevOps Lab: Setting up Forward Proxy, Reverse Proxy, Load Balancer, Firewall, Caching Server, and Web Server


## Lab Requirements:

- Ubuntu 20.04 (or later)
- Vagrant and VirtualBox installed
- Basic knowledge of Linux and networking
---

## Vagrant Environment Setup

### Step 1: Install Vagrant and VirtualBox
Make sure Vagrant and VirtualBox are installed:
- Download and install Vagrant from [here](https://www.vagrantup.com/).
- Download and install VirtualBox from [here](https://www.virtualbox.org/).

### Step 2: Create the Vagrant Environment

1. **Create a new directory:**
   ```bash
   mkdir vagrant-lab
   cd vagrant-lab

2. **Create a new directory:**
   ```bash
    touch Vagrantfile
3. **Edit the Vagrantfile: Open the Vagrantfile using a text editor**
    ``` bash
    # -*- mode: ruby -*-
    # vi: set ft=ruby :

    Vagrant.configure("2") do |config|

        # Define the server VM
        config.vm.define "server" do |server|
            server.vm.box = "ubuntu/focal64" # Ubuntu 20.04
            server.vm.hostname = "server"
            server.vm.network "private_network", ip: "192.168.56.10"
            
            # Provisioning steps for the server
            server.vm.provision "shell", inline: <<-SHELL
            sudo apt update
            sudo apt install -y nginx squid varnish ufw
            SHELL
        end

        config.vm.define "server2" do |server2|
            server2.vm.box = "ubuntu/focal64" # Ubuntu 20.04
            server2.vm.hostname = "server2"
            server2.vm.network "private_network", ip: "192.168.56.11"
            
            # Provisioning steps for the server2
            server.vm.provision "shell", inline: <<-SHELL
            sudo apt update
            sudo apt install -y nginx squid varnish ufw
            SHELL
        end
        
        # Define the client VM
        config.vm.define "client" do |client|
            client.vm.box = "ubuntu/focal64" # Ubuntu 20.04
            client.vm.hostname = "client"
            client.vm.network "private_network", ip: "192.168.56.20"
        
            # Provisioning steps for the client (minimal setup)
            client.vm.provision "shell", inline: <<-SHELL
            sudo apt update
            sudo apt install -y curl
            SHELL
        end
        
        end
    ```

4. **Start the Vagrant Environment**

Run the following command to start and provision the VMs:

    ```bash
    vagrant up
    ```



This will start two VMs:

* Server: 192.168.56.10
* Client: 192.168.56.20 

## Lab Instructions

### **Configuring Forward Proxy (Squid) on the Server**

 1. **SSH into the server**
    
    ```bash
    vagrant ssh server
    ```

 2. **Install Squid (if not done via provisioning):**
    
    ```bash
    sudo apt install squid -y

 3. **Edit Squid configuration:**
    
    ```bash
    sudo nano /etc/squid/squid.conf
    ```
    Set http_port and allow only the client machine's IP:

    ```bash
    http_port 3128
    acl localnet src 192.168.56.20/32
    http_access allow localnet
    ```
 4. **Restart Squid::**
    ```bash
    sudo systemctl restart squid
    ```
 5. **Test the Proxy from the Client: SSH into the client VM:**
    ```bash
    vagrant ssh client
    ```
    Test the proxy by using the server as a forward proxy:
    ```bash
    curl -x 192.168.56.10:3128 http://google.com
    ```
### **Configuring Reverse Proxy with NGINX on the Server**

 1. edit configuration:
    ```bash
    sudo nano /etc/nginx/sites-available/default
    ```
    Set up NGINX to forward traffic to a backend service:

    ```bash
    server {
        listen 80;
        location / {
            proxy_pass http://127.0.0.1:8080;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }
    }
    ```
    please try to understand this configuration on your own (i'll not explain it here)
 2. Restart NGINX:
    ```bash
    sudo systemctl restart nginx
    ```
 3. Test Reverse Proxy from the Client:
    ```bash
    curl http://192.168.56.10
    ```

### **Configuring Load Balancer with NGINX on the Server**
1. Edit NGINX configuration:
   ```bash
   sudo nano /etc/nginx/nginx.conf
   ```
   Add the upstream configuration:
   ```bash
   upstream backend_servers {
    server 127.0.0.1:8080;
    server 127.0.0.1:8081;
    }
    server {
        listen 80;
        location / {
            proxy_pass http://backend_servers;
        }
    }
   ```
2. Restart NGINX (you know the command right ?)
3. Test Load Balancer from the Client
   
   use curl to do it
   ```bash
   curl http://192.168.56.10
   ```

   search for how to make curl more verbose ! and try to understand and analyze the response

### **Configuring Firewall (UFW) on the Server**
1. **Install UFW:**
   ```bash
   sudo apt install ufw -y
   ``` 
   
   you should check why we used `-y` as option ??

2. Having fun now:
   ```bash
   sudo ufw deny http
   ```

3. test the Firewall from client
   ```bash
   curl http://192.168.56.10
   ```

   what's happening ? you don't see anything ? well debug it and fix it now


### **Configuring Web Server with NGINX on the Server**

In this step i'll list only the Requirements, and you should search and do them on your own:

#### Requirements

when opening the ip of the webserver , we should see your name+ the machine name 

#### hints
you should edit the file that the nginx web server will load