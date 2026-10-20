Part 1: Build Inside Docker

Clone the Calculator Maven application.

Create a Dockerfile using Maven and Java 17.

Build the application inside Docker.

Build the image app1.

Check the image size.

Run container1 and test the application.

Remove the container and image.

Part 2: Build Locally

Build the application locally using Maven.

Create a Dockerfile using Java 17 JRE.

Copy the generated JAR into the image.

Build the image app2.

Check the image size.

Run container2 and test the application.

Remove the container and image.

Image Size Comparison:

app1: 814 MB

app2: 427 MB

The second image is smaller because it uses a Java runtime image without Maven build tools.
