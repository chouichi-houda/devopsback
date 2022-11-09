pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{  
                 git branch: 'hamza', url: 'https://github.com/chouichi-houda/devopsback.git'
             }
        }  
       stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                 
            }
        }
        stage('MVN COMPILE') {
            steps {
                   sh 'mvn compile -e'
                 
            }
        }
         stage('Mvn Junit') {
            steps {
                echo 'MVN test'
               
            }
        }
        stage(' SONARQUBE') {
            steps {withSonarQubeEnv ( installationName: 'test'){
                sh 'mvn sonar:sonar '
            }  
            }
        }
    }
}
