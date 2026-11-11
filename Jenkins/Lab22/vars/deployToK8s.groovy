def call() {

    dir(env.APP_DIR) {
        sh '''
            sed -i \
              "s|image:.*|image: ${IMAGE_NAME}:${BUILD_NUMBER}|" \
              deployment.yaml

            cat deployment.yaml
        '''

        withCredentials([
            string(
                credentialsId: env.K8S_CREDENTIALS_ID,
                variable: 'K8S_TOKEN'
            )
        ]) {
            sh '''
                kubectl \
                  --server=${K8S_API} \
                  --token="$K8S_TOKEN" \
                  --insecure-skip-tls-verify=true \
                  apply -f deployment.yaml \
                  -n ${NAMESPACE}

                kubectl \
                  --server=${K8S_API} \
                  --token="$K8S_TOKEN" \
                  --insecure-skip-tls-verify=true \
                  rollout status deployment/demoapp \
                  -n ${NAMESPACE} \
                  --timeout=180s
            '''
        }
    }
}
