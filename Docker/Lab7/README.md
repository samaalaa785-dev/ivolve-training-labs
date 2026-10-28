# Lab 7: Multi-Network Microservices, Volumes, and Bind Mounts

## Steps

1. Clone the MicroserviceApp project.
2. Create Dockerfiles for the frontend, backend, and notification services.
3. Build the three Docker images.
4. Create two bridge networks:
   - frontend-backend: 172.28.0.0/24
   - backend-notification: 172.29.0.0/24
5. Create Docker volumes for backend and notification logs.
6. Create a host directory named `data` for backend messages.
7. Run the notification container on `backend-notification`.
8. Run the backend on both networks and mount the log volume and host data directory.
9. Run the frontend on `frontend-backend` and configure its backend URL.
10. Open `http://localhost:8085` and create a message.
11. Verify that the message is saved and the notification is recorded in the logs.

## Docker Images

- `lab7-frontend`
- `lab7-backend`
- `lab7-notification`

## Networks

- `frontend-backend`
- `backend-notification`

## Volumes and Bind Mount

- `backend-logs` → `/app/logs`
- `notification-logs` → `/app/logs`
- Host directory `data` → `/app/data` in the backend container

## Verification

The frontend can create and retrieve messages. The backend stores messages in `data/messages.json` and sends notification requests to the notification service.

Port `8085` is used on the host because port `8080` was already occupied. The frontend listens on port `3000` inside the container.
