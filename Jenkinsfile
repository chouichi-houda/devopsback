pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{ sh 'git clone https://github.com/chouichi-houda/devopsback.git'
             }
        } 
        stage('Package'){
             steps{ sh 'mvn clean'
             }
        }     
    }
}
