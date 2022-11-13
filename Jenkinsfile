pipeline {
    agent any
    stages{
        stage('Clone'){
             steps{ 
                 git branch: 'amal', url:'https://github.com/chouichi-houda/devopsback.git'
             }
        }

        stage('MVN CLEAN') {
             steps{
                 sh 'mvn clean'   
             }
        }

        stage('MVN COMPILE') {
            steps{
                 sh 'mvn compile -e'   
             }
        }

         stage('Mvn Junit') {
            steps{
                 echo 'MVN test'  
            }
        }
        
        stage(' SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'   
            }
        }
        
        stage('clean and package') {
            
            steps {
                sh 'mvn clean package'  
            }
     
            } 


       stage('Nexus'){
            steps{
                sh 'mvn deploy -DskipStaging=true'
            }
       }
    }
}
