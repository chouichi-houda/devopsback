pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{  sh 'rm -rf *'
                 sh 'git clone https://github.com/chouichi-houda/devopsback.git'
             }
        }  
        stage('Compile'){
            steps {
                sh 'mvn compile -e'
            }
            
        }
    }
}
