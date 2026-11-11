# Lab 26: Structured Configuration Management with Ansible Roles

## Objective

Organize Ansible automation using separate roles for Docker, Kubectl, and Jenkins, and execute them through a single Ansible Playbook.

## Environment

| Component | Details |
|---|---|
| Control Node | Control Plane |
| Managed Node | Node01 |
| Managed Node IP | 10.90.0.11 |
| Operating System | Ubuntu |
| Automation Tool | Ansible |
| Container Platform | Docker |

## Project Structure

```text
Lab26/
├── inventory
├── site.yml
└── roles/
    ├── docker/
    │   └── tasks/
    │       └── main.yml
    ├── kubectl/
    │   └── tasks/
    │       └── main.yml
    └── jenkins/
        └── tasks/
            └── main.yml
```

## Implementation Steps

### 1. Create Ansible Roles

Created three separate Ansible roles:

- **Docker Role:** Checks Docker installation and ensures the Docker service is enabled and running.
- **Kubectl Role:** Checks Kubectl installation and installs it if missing.
- **Jenkins Role:** Creates a persistent Docker volume and ensures the Jenkins container is running.

### 2. Configure Inventory

Configured the managed node in the inventory file:

```ini
[managed]
node01 ansible_host=10.90.0.11 ansible_user=root ansible_python_interpreter=/usr/bin/python3
```

### 3. Create the Main Playbook

Created `site.yml` to execute all three roles:

```yaml
---
- name: Configure managed node using Ansible roles
  hosts: managed
  become: yes

  roles:
    - docker
    - kubectl
    - jenkins
```

### 4. Execute the Playbook

Executed the playbook from the Control Node:

```bash
ansible-playbook -i inventory site.yml
```

### 5. Verify Configuration

Verified Ansible connectivity:

```bash
ansible managed -i inventory -m ping
```

Verified Docker and Kubectl:

```bash
ansible managed -i inventory -m shell -a "docker --version && kubectl version --client && systemctl is-active docker"
```

Verified Jenkins container:

```bash
ansible managed -i inventory -m shell -a "docker ps --filter name=jenkins"
```

Checked Playbook syntax:

```bash
ansible-playbook -i inventory site.yml --syntax-check
```

## Results

- Successfully created three separate Ansible roles.
- Successfully executed all roles using a single playbook.
- Docker was installed and its service was running.
- Kubectl was installed and verified.
- Jenkins was running inside a Docker container.
- Playbook execution completed with zero failed and unreachable tasks.
- Syntax validation completed successfully.



## Screenshots

Screenshots documenting the project structure, role execution, verification commands, and syntax check are available in the `screenshots/` directory.
