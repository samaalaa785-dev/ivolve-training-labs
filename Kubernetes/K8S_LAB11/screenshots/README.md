# Lab 11: Namespace Management and Resource Quota Enforcement

## Steps

1. Created a namespace named `ivolve`.
2. Created a ResourceQuota named `ivolve-quota` in the `ivolve` namespace with a maximum of 3 Pods.
3. Created three Nginx Pods in the namespace.
4. Tried to create a fourth Pod and verified that Kubernetes rejected it because the quota limit was reached.
5. Verified the Pods and ResourceQuota using kubectl commands.

## Screenshots

Screenshots are available in the `screenshots` folder.
