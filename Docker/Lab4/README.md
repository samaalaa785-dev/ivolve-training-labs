

## Steps
1. Clone the application repository.
2. Build the original image as `image1`.
3. Run `container1` and verify the application.
4. Stop and remove `container1`.
5. Create a multi-stage Dockerfile and run the app as a non-root user.
6. Build the optimized image as `image2`.
7. Compare the image sizes.
8. Run `container2` and verify the application.
9. Check that the application runs as `appuser`.
10. Stop and remove `container2`.
11. Save `image2` as `lab-image.tar`.
12. Remove `image2` from the local Docker host.
13. Load the image from `lab-image.tar`.
14. Verify that `image2` exists after loading.

## Results

- Original image (`image1`): 671 MB disk usage.
- Optimized image (`image2`): 331 MB disk usage.
- Image size reduction: approximately 51%.
- The optimized image runs as a non-root user.
- The image was exported and successfully loaded again.
