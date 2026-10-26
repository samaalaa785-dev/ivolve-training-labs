# Lab 10: Node Isolation Using Taints and Labels in Kubernetes

## Steps

1. Applied a taint to worker node `node01` using `workload=ivolveApp:NoSchedule`.
2. Added the label `project=ivolve` to `node01`.
3. Verified the taint using `kubectl describe node node01`.
4. Verified the label using `kubectl get nodes --show-labels`.

## Screenshots

Screenshots are available in the `screenshots` folder.
