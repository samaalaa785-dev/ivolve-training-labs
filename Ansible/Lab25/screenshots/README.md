# Lab 25: Automated Web Server Configuration Using Ansible Playbooks

## Objective
Automate the configuration of a managed node using Ansible Playbooks by installing and verifying:

- Docker
- Kubectl
- Jenkins

## Environment

| Component | Details |
|---|---|
| Control Node | Control Plane |
| Managed Node | Node01 |
| Managed Node IP | 10.90.0.11 |
| Operating System | Ubuntu |
| Automation Tool | Ansible |

## Implementation Steps

### 1. Configure Ansible Inventory

Configured the managed node in the Ansible inventory file:

```ini
[managed]
node01 ansible_host=10.90.0.11 ansible_user=root ansible_python_interpreter=/usr/bin/python3
```

### 2. Verify Connectivity

Tested the connection between the Control Node and Managed Node:

```bash
ansible managed -m ping -e 'ansible_python_interpreter=/usr/bin/python3'
```

Expected result:

```text
node01 | SUCCESS
"ping": "pong"
```

### 3. Install Docker and Kubectl

Created and executed an Ansible Playbook to install Docker and Kubectl on the managed node.

```bash
ansible-playbook /root/lab25-core.yml
```

### 4. Deploy Jenkins

Due to connectivity issues with the official Jenkins APT repository, Jenkins was deployed using its official Docker image:

```bash
docker pull jenkins/jenkins:lts-jdk21
```

Created a persistent Docker volume and started Jenkins:

```bash
docker volume create jenkins_home

docker run -d \
  --name jenkins \
  --restart unless-stopped \
  -p 8086:8080 \
  -p 50001:50000 \
  -v jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts-jdk21
```

### 5. Verification

Verified Docker and Kubectl:

```bash
docker --version
kubectl version --client
systemctl is-active docker
```

Verified Jenkins container:

```bash
docker ps --filter name=jenkins
```

Verified Jenkins HTTP response:

```bash
curl -I http://10.90.0.11:8086/login
```

Expected HTTP response:

```text
HTTP/1.1 200 OK
```

## Results

- Ansible successfully connected to the managed node.
- Docker was installed and its service was active.
- Kubectl was installed successfully.
- Jenkins was deployed and running inside a Docker container.
- Jenkins responded successfully on port `8086`.

## Screenshots

Screenshots documenting the Ansible connectivity, Playbook execution, Docker and Kubectl verification, Jenkins container, and HTTP response are available in the `screenshots/` directory.

