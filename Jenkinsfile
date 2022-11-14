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
                 sh 'mvn compile'   
             }
        }

         stage('Mvn Junit') {
            steps{
                 echo 'mvn test '
   
            }
        }
        
         stage(' SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'   
            }
        }
        
         stage('Nexus'){
            steps{
                sh 'mvn deploy -DskipStaging=true'
            }
        }
        
        
        stage('Build image') {
           	steps {
       		 sh "docker build -t soltaniamal/tpachat ."
       	        }
       	}    

        stage("login DockerHub") {
                steps{
                    sh 'echo dockerhub | docker login -u soltaniamal -p dockerhub'
                }
        }
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push soltaniamal/tpachat'
                }
        }
        
        stage("Docker-compose") {
                steps{
                    sh 'docker compose up -d'
                }
        }
    }
}
