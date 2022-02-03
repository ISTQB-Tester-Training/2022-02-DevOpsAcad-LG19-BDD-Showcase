pipeline {
    agent any

    stages {
        stage('Build') {
            steps {

                git 'https://github.com/ISTQB-Tester-Training/2021-11-DevOpsAcad-LG18-BDD-Showcase.git'

                sh "mvn compile"
            }
        }
        stage('Unit Test') {
            steps {

               sh "mvn test"
            }
        }
        stage('Code Analysis') {
            steps {

                sh "mvn sonar:sonar -Dsonar.host.url=http://ctp-tester-training.tk:30002/"
            }
        }
    }
}
