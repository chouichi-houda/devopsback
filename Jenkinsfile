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
                sh 'mvn -f path/to/pom.xml clean'
                 
            }
        }
        stage('MVN COMPILE') {
            steps {
                sh 'mvn -f path/to/pom.xml compile'
                 
            }
        }
    }
}
