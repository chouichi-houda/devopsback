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
        stage('MVN SONARQUBE') {
            steps {
               sh " mvn  -f Spring/pom.xml clean install sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://192.168.1.15:9000 -Dsonar.login=956b7ba2d53c386d91ef6e65ac3feef17a2faf05"
"
             }
        }
    }
}
