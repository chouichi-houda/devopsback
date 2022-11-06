pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{  sh 'rm -rf *'
                 sh 'git clone https://github.com/chouichi-houda/devopsback.git'
             }
        }  
        stage("Build") {
             steps { sh 'rm -rf *'
             sh 'mvn --batch-mode compile'
            }
        }
    }
}
