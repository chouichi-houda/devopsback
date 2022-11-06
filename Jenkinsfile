pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{  sh 'rm -rf *'
                 sh 'git clone https://github.com/chouichi-houda/devopsback.git'
             }
        }  
       stage('MVN CLEAN') {
            steps {
                sh 'mvn clean -e'
                 
            }
        }
        stage('MVN COMPILE') {
            steps {
                   sh 'mvn compile -e'
                 
            }
        }
    }
}
