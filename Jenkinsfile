pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Clean') {
            steps {
                sh "ls"
                sh "cd Funeral-Home-Management/"
                sh "ls"
                sh "mvn clean"
            }
        }
        stage('Build') {
            steps {
                sh "mvn package"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                sh "echo TODO"
            }
        }

    }

}
