pipeline {
    agent { label 'maven' }

    environment {
        PATH = "/opt/apache-maven-3.9.4/bin:$PATH"
        REGISTRY   = "172.31.35.69:5000"
        IMAGE_NAME = "java-maven-app"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER} ."
            }
        }

        stage('Docker Push') {
            steps {
                sh "docker push ${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER}"
            }
        }
    }
}
