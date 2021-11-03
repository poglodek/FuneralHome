pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Clean') {
            steps {
                dir('Funeral-Home-Management/') {
                    sh "mvn clean"
                }                
            }
        }
        stage('Build') {
            steps {
                dir('Funeral-Home-Management/') {
                    sh "mvn package"
                }
            }
        }
        stage('Test') {
            steps {
                dir('Funeral-Home-Management/') {
                    sh "mvn test"
                }
            }
        }
        stage('Deploy') {
            steps {
                sh "echo TODO"
            }
        }

    }

}
