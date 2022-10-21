pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{ sh 'git clone https://github.com/chouichi-houda/devopsback.git'
             }
        } 
        stage('Build'){
             steps{ sh 'mvn compile'
             }
        }     
    }
}
