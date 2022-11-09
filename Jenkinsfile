pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{  
                 git branch: 'houda', url: 'https://github.com/chouichi-houda/devopsback.git'
             }
        }  
       stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                 
            }
        }
        stage('MVN COMPILE') {
            steps {
                   sh 'mvn compile'
                 
            }
        }
       stage("Unit tests") {
           steps {
                   sh 'mvn test'
             }
             
        }

    }
}

    
    
     
             
                 
             

    

