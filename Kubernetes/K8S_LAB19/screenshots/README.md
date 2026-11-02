# Lab 19: Securing Kubernetes with RBAC and Service Accounts

## Objective
Configure Kubernetes RBAC to allow a Service Account to create and update Deployments only within the `ivolve` namespace.
## Steps
1. Created the `jenkinssa` Service Account in the `ivolve` namespace.
2. Generated a Service Account token using `kubectl create token`.
3. Created a Role named `ivolveDeployRole`.
4. Granted `create` and `update` permissions on Deployments.
5. Created a RoleBinding named `ivolveDeployRoleBinding`.
6. Bound the Role to the `jenkinssa` Service Account.
7. Verified the permissions using `kubectl auth can-i`.

## Verification Results

| Permission | Expected Result |
|---|---|
| Create Deployments in `ivolve` | Yes |
| Update Deployments in `ivolve` | Yes |
| Delete Deployments in `ivolve` | No |
| Create Deployments in `default` | No |

## Screenshots
Screenshots are available in the `screenshots` folder.
