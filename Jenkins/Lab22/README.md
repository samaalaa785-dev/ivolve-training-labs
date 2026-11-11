# Lab 22 – Jenkins Shared Libraries

## Objective
The objective of this lab is to create and use Jenkins Shared Libraries to organize and reuse pipeline code instead of writing all pipeline steps inside the Jenkinsfile.

## 1. Create a Shared Library Repository

Created a new GitHub repository:

`https://github.com/samaalaa785-dev/jenkins-shared-library`

Repository structure:

```text
jenkins-shared-library/
└── vars/
    ├── buildApp.groovy
    ├── buildAndPushImage.groovy
    └── deployToK8s.groovy
```

## 2. Configure the Shared Library in Jenkins

Configured the Global Pipeline Library in Jenkins:

- **Name:** shared-lib
- **Default Version:** main
- **Retrieval Method:** Modern SCM
- **SCM:** Git
- **Project Repository:** https://github.com/samaalaa785-dev/jenkins-shared-library.git

## 3. Create Shared Library Functions

Created three reusable Groovy functions inside the `vars` directory.

### buildApp.groovy
- Builds the Java application using Maven.
- Uses a Maven Docker image to run the build.
- Generates the application JAR file.

### buildAndPushImage.groovy
- Builds the Docker image.
- Tags the image with the Jenkins build number and latest.
- Scans the image using Trivy.
- Logs in to Docker Hub using Jenkins credentials.
- Pushes the image to Docker Hub.

### deployToK8s.groovy
- Updates the image tag in `deployment.yaml`.
- Uses Kubernetes credentials stored in Jenkins.
- Applies the deployment manifest to Kubernetes.
- Checks the deployment rollout status.

## 4. Create the Jenkins Pipeline

Created the Jenkinsfile inside:

`Jenkins/Lab22/Jenkinsfile`

Imported the Shared Library using:

```groovy
@Library('shared-lib') _
```

The pipeline contains the following stages:

1. **Checkout:** Checks out the source code from GitHub.
2. **Build Application:** Calls `buildApp()`.
3. **Build, Scan and Push Image:** Calls `buildAndPushImage()`.
4. **Deploy to Kubernetes:** Calls `deployToK8s()`.

Added Post Actions to display pipeline execution status:

- Always
- Success
- Failure

## 5. Configure Jenkins Credentials

Configured the required credentials in Jenkins:

| Credential ID | Purpose |
|---|---|
| dockerhub-creds | Docker Hub authentication |
| k8s-token | Kubernetes ServiceAccount token |

## 6. Configure Kubernetes Access

Created the `demoapp` namespace.

Created a ServiceAccount named:

`jenkins-deployer`

Configured the required Role and RoleBinding to allow Jenkins to deploy the application.

Verified the permissions using:

```bash
kubectl auth can-i create deployments \
  --as=system:serviceaccount:demoapp:jenkins-deployer \
  -n demoapp
```

Expected output:

```text
yes
```

## 7. Execute the Pipeline

Created and executed the Jenkins job:

`Lab22-Pipeline`

The pipeline successfully performed:

- Application build using Maven.
- Docker image build.
- Trivy vulnerability scanning.
- Docker Hub image push.
- Kubernetes deployment.
- Deployment rollout verification.

## 8. Final Result

**Pipeline Status: SUCCESS**

All pipeline stages completed successfully, and the application was deployed to the Kubernetes cluster.
Successfully implemented a Jenkins Shared Library to make pipeline code reusable and easier to maintain. The pipeline automated the application build, Docker image scanning and publishing, and Kubernetes deployment.
