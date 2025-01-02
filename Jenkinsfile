pipeline {
    agent any

    tools {
        maven 'sonarmaven'  // Ensure 'sonarmaven' tool is configured in Jenkins
    }

    environment {
        SONAR_TOKEN = credentials('mavenTask')  // SonarQube token from Jenkins credentials
        JAVA_HOME = 'C:/Program Files/Java/jdk-17'
        PATH = "${JAVA_HOME}/bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Check out the code from the repository
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'  // Run Maven build
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {  // Use SonarQube environment configured in Jenkins
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=Hemant-Maven ^
                        -Dsonar.sources=src/main/java ^  // Sources should typically be from src/main/java
                        -Dsonar.tests=src/test/java ^  // Test sources should be from src/test/java
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
