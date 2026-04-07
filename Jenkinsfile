pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/debi201326/jenkins-demo.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Archive Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'reports',
                    reportFiles: 'extent-report.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        always {
            echo 'Build Finished'
        }
        success {
            echo 'Build Passed'
        }
        failure {
            echo 'Build Failed'
        }
    }
}
