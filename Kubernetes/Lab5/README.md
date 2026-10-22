# Lab 5: Trivy Image Scanning
## Steps
1. Clone the application repository.
2. Build the Docker image using the Dockerfile.
3. Scan the image using Trivy to detect vulnerabilities.
4. Review the HIGH and CRITICAL vulnerabilities in the scan results.
5. Update the Express dependency and fix vulnerable Node.js packages.
6. Update npm to the latest available version.
7. Replace the Debian-based image with `node:24-alpine` to reduce OS vulnerabilities.
8. Rebuild the image as `ivolve-app:v3`.
9. Scan the updated image again using Trivy.
10. Generate JSON and HTML reports for the final scan.
## Final Results
- HIGH vulnerabilities: 0
- CRITICAL vulnerabilities: 0
## Report
[View the Trivy HTML Report](trivy-report-v3.html)
