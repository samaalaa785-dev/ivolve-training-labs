# Lab 20: Role-Based Authorization

## Objective
Configure role-based authorization in Jenkins by assigning different permissions to users.

## Steps

1. Create two users: `user1` and `user2`.
2. Install the Role-based Authorization Strategy plugin.
3. Enable Role-Based Strategy from Jenkins Security settings.
4. Create the following Global Roles:
   - `admin`: Overall/Administer
   - `read-only`: Overall/Read, Job/Read, View/Read
5. Assign roles to users:

| User | Role |
|---|---|
| samaalaa | admin |
| user1 | admin |
| user2 | read-only |

## Verification

- Logged in as `user1` and verified admin access.
- Logged in as `user2` and verified read-only access.

## Result

Successfully configured and tested Role-Based Authorization in Jenkins.# Lab 20: Role-Based Authorization
