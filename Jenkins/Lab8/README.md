# Lab 8: 
## Steps
1. Clone the iVolveApp repository.
2. Create a Docker Compose file for the Node.js app and MySQL database.
3. Configure the database environment variables.
4. Create the `ivolve-net` network for communication between services.
5. Add persistent volumes for application logs and database data.
6. Build and start the services:

   ```bash
   docker compose up -d --build
   ```

7. Check the running containers:

   ```bash
   docker compose ps
   ```

8. Test the application:

   ```bash
   curl http://localhost:3000/health
   curl http://localhost:3000/ready
   ```

9. Open `http://localhost:3000` in your browser.
10. Verify the application logs and database connection.
11. Build, tag, and push the application image to Docker Hub.

## Docker Hub

The application image is available on Docker Hub:

[**sama2alaa/ivolve-app**](https://hub.docker.com/r/sama2alaa/ivolve-app)

**Image Tag:** `lab8`

Pull the image using:

```bash
docker pull sama2alaa/ivolve-app:lab8
```

## Cleanup

Stop and remove the containers and network while keeping persistent volumes:

```bash
docker compose down
```
