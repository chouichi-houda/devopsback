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
       		 sh "docker build -t hamzatouam/tpachat ."
       		}
       		}   
   stage("login DockerHub") {
                steps{
                    sh 'echo 11407904Ha | docker login -u hamzatouam -p 11407904Ha'
                }
        }
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push hamzatouam/tpachat'
                }
        }
	    

	 stage("Docker-compose") {
                steps{
                    sh 'docker compose up -d'
                }
        }
    }
}
