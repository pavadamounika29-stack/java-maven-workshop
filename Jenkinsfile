pipeline {
    agent { label 'maven' }

    environment {
        PATH = "/opt/apache-maven-3.9.4/bin:$PATH"
        REGISTRY   = "localhost:5000"
        IMAGE_NAME = "java-maven-app"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        // Keep your existing SonarQube stage here if you have one

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
