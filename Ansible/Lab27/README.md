# Lab 27: Securing Sensitive Data with Ansible Vault

## Overview
This lab demonstrates how to use Ansible Roles and Ansible Vault to automate MySQL installation and database configuration while securely managing sensitive information.

## Objectives
- Create a reusable Ansible Role for MySQL.
- Install MySQL Server on the managed node.
- Create a database named `ivolve`.
- Create a database user named `ivolveuser`.
- Grant all privileges on the `ivolve` database to `ivolveuser`.
- Encrypt the database password using Ansible Vault.
- Validate database access using the created user.

## Project Structure

```text
Lab27/
├── group_vars/
│   └── managed/
│       └── vault.yml
├── roles/
│   └── mysql/
│       └── tasks/
│           └── main.yml
├── screenshots/
├── inventory.example
├── site.yml
└── README.md
```

## Technologies Used
- Ansible
- Ansible Vault
- MySQL Server
- Ubuntu Linux
- Python PyMySQL
- YAML

## Implementation

### 1. Create MySQL Ansible Role

The MySQL role is responsible for:

- Installing MySQL Server and Python PyMySQL.
- Starting and enabling the MySQL service.
- Creating the `ivolve` database.
- Creating the `ivolveuser` account.
- Granting all privileges on `ivolve` to `ivolveuser`.

### 2. Secure Credentials with Ansible Vault

Ansible Vault is used to encrypt sensitive database credentials.

The encrypted variables are stored in:

`group_vars/managed/vault.yml`

The database password is referenced in the MySQL role using:

```yaml
password: "{{ mysql_password }}"
```

This prevents storing the database password as plain text in the Ansible tasks.

### 3. Configure the Playbook

The `site.yml` playbook targets the managed hosts and applies the MySQL role.

### 4. Execute the Playbook

Run the following command:

```bash
ansible-playbook -i inventory site.yml --ask-vault-pass
```

Enter the Ansible Vault password when prompted.

## Validation

Connect to the managed node:

```bash
ssh root@10.90.0.11
```

Log in to MySQL using the created user:

```bash
mysql -u ivolveuser -p
```

List available databases:

```sql
SHOW DATABASES;
```

Select the `ivolve` database:

```sql
USE ivolve;
```

Verify user privileges:

```sql
SHOW GRANTS FOR CURRENT_USER;
```

## Expected Results

- MySQL Server is installed and running.
- The `ivolve` database is created successfully.
- The `ivolveuser` account is created successfully.
- The user has all privileges on the `ivolve` database.
- Database credentials are encrypted using Ansible Vault.
- The created user can successfully connect to MySQL and access the database.

## Screenshots

The `screenshots/` directory contains evidence of:

- Ansible Vault encryption.
- MySQL role execution.
- Successful Ansible Playbook execution.
- MySQL service status.
- Successful database login.
- Database listing and access validation.
- User privilege verification.

## Conclusion

Successfully automated MySQL installation and database configuration using Ansible Roles, while protecting sensitive credentials with Ansible Vault. Database connectivity and user privileges were successfully validated on the managed node.
