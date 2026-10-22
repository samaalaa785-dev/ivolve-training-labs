# Lab 5: Trivy Image Scanning

## Steps

1. Build the Docker image.
2. Scan the image using Trivy.
3. Filter HIGH and CRITICAL vulnerabilities.
4. Update the base image from Debian to Alpine.
5. Rebuild the image as `ivolve-app:v3`.
6. Scan the updated image again.
7. Generate the HTML security report.

## Final Scan Results

- Base image: Alpine 3.24.3
- HIGH vulnerabilities: 0
- CRITICAL vulnerabilities: 0

## Report

See [Trivy HTML Report](trivy-report-v3.html)
