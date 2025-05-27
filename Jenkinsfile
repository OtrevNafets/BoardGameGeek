pipeline{
    agent any

    stages {
        stage('Checkout'){
            checkout scm
        }
        stage('Build'){
            steps {
                echo 'Baue das Projekt'
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps{
                echo 'Führe test aus...'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

}