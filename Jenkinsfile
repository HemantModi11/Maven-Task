pipeline {
    agent any

    tools {
        maven 'sonarmaven'
    }

    environment {
        SONARQUBE_SERVER = 'sonarqube'
        SONAR_TOKEN = credentials('mavenTask')
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat '''
                mvn clean install
                '''
            }
        }

        stage('Test') {
            steps {
                bat '''
                mvn test
                '''
            }
        }

        stage('SonarAnalysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    bat """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=Hemant-Maven \
                        -Dsonar.sources=src/main/java/com/example/automation \
                        -Dsonar.tests=src/test/java/com/example/automation \
                        -Dsonar.junit.reportPaths=target/surefire-reports \
                        -Dsonar.jacoco.reportPaths=target/site/jacoco/jacoco.xml \
                        -Dsonar.pmd.reportPaths=target/pmd-duplicates.xml \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline Successfully Executed"
        }
        failure {
            echo "Pipeline Failed"
        }
    }
}
