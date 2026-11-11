def call() {
    sh '''
        docker run --rm \
          --user "$(id -u):$(id -g)" \
          --volumes-from jenkins11 \
          -e HOME=/tmp \
          -w "$WORKSPACE" \
          maven:3.9-eclipse-temurin-17 \
          mvn -f "$APP_DIR/pom.xml" clean package -DskipTests
    '''
}
