def call() {
    dir(env.APP_DIR) {
        sh '''
            sed -i \
              "s|image:.*|image: ${IMAGE_NAME}:${BUILD_NUMBER}|" \
              deployment.yaml

            echo "Updated deployment.yaml:"
            cat deployment.yaml

            git config user.name "Jenkins"
            git config user.email "jenkins@example.com"

            git add deployment.yaml

            if git diff --cached --quiet; then
                echo "No changes to commit."
            else
                git commit -m "Update DemoApp image to ${BUILD_NUMBER}"
            fi
        '''

        withCredentials([
            gitUsernamePassword(
                credentialsId: 'github-creds',
                gitToolName: 'Default'
            )
        ]) {
            sh '''
                git push origin HEAD:main
            '''
        }
    }
}

return this
