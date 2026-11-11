# Lab 14: StatefulSet with Headless Service
## Steps
1. Created the `ivolve` namespace.
2. Added the `project=ivolve` label and the required workload taint to `node01`.
3. Created a ConfigMap and Secret for MySQL environment variables.
4. Created a Persistent Volume and Persistent Volume Claim for MySQL data.
5. Deployed MySQL using a StatefulSet with one replica.
6. Configured a Headless Service named `ivolvedbsvc`.
7. Verified the MySQL connection and database.
8. Verified DNS resolution for the StatefulSet Pod.
## Screenshots
Screenshots are available in the `screenshots` folder.
