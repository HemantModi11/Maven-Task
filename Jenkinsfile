pipeline {
    agent any

    tools {
        maven 'sonarmaven' // Ensure this matches the Maven tool configuration in Jenkins
    }

    environment {
        SONAR_TOKEN = credentials('Sonarqube-token') // Use the correct credentials ID for SonarQube token
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17' // Set the Java home path
        PATH = "${JAVA_HOME}\\bin;${env.PATH}" // Add Java to PATH
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm // Check out the code from the repository
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package' // Run Maven to clean and package the project
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Ensure this matches the SonarQube configuration in Jenkins
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=maven-pro ^
                        -Dsonar.sources=src/main/java ^
                        -Dsonar.tests=src/test/java ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.' // Message on success
        }
        failure {
            echo 'Pipeline failed.' // Message on failure
        }
    }
}
