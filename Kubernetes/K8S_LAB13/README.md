# Lab 13: Persistent Storage Setup for Application Logging
## Steps
1. Created the hostPath directory `/mnt/app-logs` on the worker node.
2. Created a Persistent Volume with `1Gi` capacity, `ReadWriteMany` access mode, and `Retain` reclaim policy.
3. Created a Persistent Volume Claim requesting `1Gi` with `ReadWriteMany` access mode.
4. Set `storageClassName` to an empty string to avoid using a StorageClass.
5. Verified that the PV and PVC were successfully bound using kubectl.
## Screenshots
Screenshots are available in the `screenshots` folder.
