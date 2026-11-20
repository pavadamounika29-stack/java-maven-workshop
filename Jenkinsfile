pipeline {
    agent { label 'maven' }

    environment {
        PATH = "/opt/apache-maven-3.9.4/bin:$PATH"
        SCANNER_HOME = tool 'sonar-scanner'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh '''
                        $SCANNER_HOME/bin/sonar-scanner \
                        -Dsonar.projectKey=pavadamounika29-stack_java-maven-workshop \
                        -Dsonar.organization=pavadamounika29-stack \
                        -Dsonar.sources=src/main \
                        -Dsonar.java.binaries=target/classes
                    '''
                }
            }
        }
    }
}
