def call() {

    dir(env.APP_DIR) {
        sh '''
            docker build \
              -t ${IMAGE_NAME}:${BUILD_NUMBER} .

            docker tag \
              ${IMAGE_NAME}:${BUILD_NUMBER} \
              ${IMAGE_NAME}:latest
        '''
    }

    sh '''
        docker run --rm \
          -v /var/run/docker.sock:/var/run/docker.sock \
          -v trivy-cache:/root/.cache/ \
          aquasec/trivy:0.76.0 \
          image \
          --timeout 15m \
          --exit-code 0 \
          --severity HIGH,CRITICAL \
          ${IMAGE_NAME}:${BUILD_NUMBER}
    '''

    withCredentials([
        usernamePassword(
            credentialsId: env.DOCKER_CREDENTIALS_ID,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASSWORD'
        )
    ]) {
        sh '''
            echo "$DOCKER_PASSWORD" | docker login \
              -u "$DOCKER_USER" \
              --password-stdin

            docker push ${IMAGE_NAME}:${BUILD_NUMBER}
            docker push ${IMAGE_NAME}:latest

            docker logout
        '''
    }
}
