# Lab 23: Implementing a GitOps Workflow with Jenkins and Argo CD

## Objective
Implement a GitOps workflow using Jenkins, GitHub, Docker Hub, Kubernetes, and Argo CD.

## Tools Used
- Jenkins
- Jenkins Shared Library
- Git and GitHub
- Docker and Docker Hub
- Trivy
- Kubernetes (Minikube)
- Argo CD

## Implementation

1. Installed Argo CD in the Kubernetes cluster.
2. Accessed the Argo CD UI and logged in.
3. Connected Argo CD to the GitHub repository.
4. Created an Argo CD Application named `ivovle`.
5. Configured the application to monitor:
   - Repository: `ivolve-training-labs`
   - Branch: `main`
   - Path: `Jenkins/Lab21/DemoApp`
6. Enabled automatic synchronization.
7. Configured the Jenkins pipeline to build the application.
8. Built and scanned the Docker image using Trivy.
9. Pushed the image to Docker Hub.
10. Updated `deployment.yaml` with the new image tag.
11. Committed and pushed the manifest update to GitHub.
12. Argo CD detected the Git change and synchronized the application.

## Pipeline Structure

- `Jenkinsfile`: Defines the Lab 23 pipeline stages.
- `vars/buildApp.groovy`: Builds the Java application.
- `vars/buildAndPushImage.groovy`: Builds, scans, and pushes the Docker image.
- `vars/deployToK8s.groovy`: Updates and pushes the Kubernetes deployment manifest.

## Verification

- Jenkins pipeline: SUCCESS
- GitHub manifest update: SUCCESS
- Argo CD application: Synced
- Argo CD health: Healthy
- Kubernetes deployment: 1/1 Available
- Kubernetes pod: Running

## Result

Successfully implemented a GitOps workflow where Jenkins publishes a new application image and updates the GitHub manifest, while Argo CD automatically detects and synchronizes the changes.
