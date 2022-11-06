pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{  sh 'rm -rf *'
                 sh 'git clone https://github.com/chouichi-houda/devopsback.git'
             }
        }  
        stage("Build") { sh 'rm -rf *'
             steps {
             sh 'mvn compile'
            }
        }
    }
}
