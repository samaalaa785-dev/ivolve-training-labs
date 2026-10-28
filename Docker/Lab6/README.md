# Lab 6: Docker Environment Variables and Resource Management

## Steps

1. Build the Docker image:
   ```bash
   docker build -t ivolve1 .
   ```

2. Run `container1` with environment variables and resource limits:
   ```bash
   docker run -d --name container1 -p 5000:5000 -e APP_NAME=iVolveApp1 -e APP_ENV=stg --cpus=1 --memory=256m ivolve1
   ```

3. Verify the application and environment variables:
   ```bash
   curl http://localhost:5000
   docker exec container1 printenv APP_NAME
   docker exec container1 printenv APP_ENV
   docker stats container1
   ```

4. Create `env.txt` with:
   ```text
   APP_NAME=iVolveApp2
   APP_ENV=prod
   ```

5. Run `container2` using the environment file:
   ```bash
   docker run -d --name container2 -p 5000:5000 --env-file env.txt ivolve1
   ```

6. Build the image with environment variables defined in `Dockerfile.dev`:
   ```bash
   docker build -f Dockerfile.dev -t ivolve3 .
   ```

7. Run the new image and verify the environment variables:
   ```bash
   docker run -d --name container2 -p 5000:5000 ivolve3
   docker exec container2 printenv APP_NAME
   docker exec container2 printenv APP_ENV
   ```

## Result

Successfully tested environment variables using `-e`, `--env-file`, and Dockerfile `ENV`, along with CPU and memory limits.
