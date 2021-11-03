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
                    sh "mvn package -DSPRING_DATASOURCE_URL=jdbc:mysql://mysql-FuneralHomeMnt:3306/FuneralHomeMnt"
                }
            }
        }
        stage('Test') {
            steps {
                dir('Funeral-Home-Management/') {
                    sh "mvn test -DSPRING_DATASOURCE_URL=jdbc:mysql://mysql-FuneralHomeMnt:3306/FuneralHomeMnt"
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
