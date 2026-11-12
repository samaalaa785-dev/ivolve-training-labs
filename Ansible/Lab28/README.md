# Lab 28: Automated Host Discovery with Ansible Dynamic Inventory

## Overview
This lab demonstrates how to automate AWS EC2 host discovery and management using Ansible Dynamic Inventory. Instead of maintaining a static inventory file, Ansible automatically discovers running EC2 instances based on their tags.

## Objectives
- Create an AWS EC2 instance using Floci.
- Tag the EC2 instance with `server: ivolve`.
- Configure Ansible Dynamic Inventory.
- Automatically discover running EC2 instances with the specified tag.
- List discovered hosts using the `ansible-inventory` command.
- Run an Ansible playbook on the discovered EC2 instance.
- Verify the instance configuration using Ansible facts.

## Environment
- OS: Ubuntu 24.04
- Automation Tool: Ansible
- Cloud Environment: Floci (AWS-compatible local environment)
- AWS Region: us-east-1
- EC2 Instance: Ubuntu 24.04
- SSH User: ubuntu
- Ansible Collection: amazon.aws

## Project Structure

```text
Lab28/
├── aws_ec2.yml
├── discover.yml
├── .gitignore
├── README.md
└── screenshots/
```

## 1. EC2 Instance Creation

An Ubuntu 24.04 EC2 instance was created using Floci.

The instance was configured with the following tag:

- Key: `server`
- Value: `ivolve`

The instance was verified to be in the running state.

## 2. Dynamic Inventory Configuration

The `aws_ec2.yml` file configures the Amazon EC2 dynamic inventory plugin.

Configuration includes:
- Plugin: `amazon.aws.aws_ec2`
- Region: `us-east-1`
- Floci endpoint: `http://localhost:4566`
- Instance state filter: `running`
- Tag filter: `server: ivolve`
- Hostname: Private IP address

This configuration allows Ansible to automatically discover matching EC2 instances.

## 3. List Discovered Hosts

The following commands were used to inspect the inventory:

```bash
ansible-inventory -i aws_ec2.yml --graph
```

```bash
ansible-inventory -i aws_ec2.yml --list
```

These commands display the hosts discovered by the dynamic inventory plugin.

## 4. SSH Connectivity

SSH key-based authentication was configured to access the Ubuntu EC2 instance.

The connection was verified successfully using the `ubuntu` user and the EC2 private key.

## 5. Ansible Connectivity Test

Ansible connectivity was tested using the ping module:

```bash
ansible -i inventory.ini webservers -m ping
```

Expected result:

```text
ivolve | SUCCESS
"ping": "pong"
```

## 6. Playbook Execution

The `discover.yml` playbook was created to gather system facts and display information about the target EC2 instance.

Run the playbook using:

```bash
ansible-playbook -i inventory.ini discover.yml
```

The playbook performs the following tasks:

1. Display the hostname.
2. Display the operating system and version.
3. Display the IP address.
4. Display the system architecture.

## 7. Verification Results

The playbook executed successfully on the target EC2 instance.

Verified information:

| Property | Result |
|---|---|
| Hostname | ae909613775f |
| Operating System | Ubuntu 24.04 |
| IP Address | 172.17.0.3 |
| Architecture | x86_64 |

Execution summary:

```text
ivolve : ok=5 changed=0 unreachable=0 failed=0
```

This confirms successful Ansible connectivity and fact gathering.

## 8. Security

Sensitive files are excluded from version control using `.gitignore`.

Excluded files include:
- `*.pem`
- `*.key`
- `*.tar.gz`
- `.env`
- `.aws/`

Private SSH keys and credentials must never be uploaded to GitHub.

## 9. Screenshots

The `screenshots/` directory contains evidence of the lab configuration and execution, including:
- EC2 instance creation and status.
- EC2 instance tags.
- Dynamic inventory configuration.
- Discovered EC2 hosts.
- SSH connectivity.
- Ansible ping test.
- Playbook execution.
- System facts and verification results.

## Conclusion

Successfully configured Ansible Dynamic Inventory to discover EC2 instances based on their state and tags in a Floci environment. Tested SSH connectivity, executed an Ansible playbook, and verified the target instance configuration using gathered facts.
