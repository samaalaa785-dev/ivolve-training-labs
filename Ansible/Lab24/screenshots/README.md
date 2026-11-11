# Lab 24: Initial Ansible Configuration and Ad-Hoc Execution

## Objective
The objective of this lab is to install and configure Ansible on the control node, establish SSH connectivity with the managed node, create an inventory file, and execute Ansible ad-hoc commands to install Docker.

## Lab Tasks

### 1. Install and Configure Ansible
- Installed Ansible on the control node.
- Verified the Ansible installation.

### 2. Generate SSH Key
- Generated a new SSH key pair on the control node.
- Used the SSH key for passwordless authentication.

### 3. Transfer Public Key
- Used `ssh-copy-id` to transfer the public key to the managed node.
- Verified SSH connectivity between the control node and managed node.

### 4. Create Ansible Inventory
- Created an inventory file containing the managed node.
- Configured the managed host to be accessible through Ansible.

### 5. Execute Ad-Hoc Commands
- Executed Ansible ad-hoc commands to verify connectivity.
- Installed Docker on the managed node using Ansible.
- Verified the Docker installation and version.

## Verification
The lab was successfully completed. Ansible connected to the managed node, and Docker was installed successfully.

Example verification output:

```bash
ansible managed -m command -a "docker --version"
```

**Expected Result:**
```text
node01 | CHANGED | rc=0 >>
Docker version 29.1.3
```

## Screenshots
The screenshots included in this directory demonstrate the installation, SSH configuration, inventory setup, Ansible execution, and Docker installation verification.
