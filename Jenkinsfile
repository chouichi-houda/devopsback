pipeline {
    agent any
     environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerHub')
        
        }
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
        
        stage('SONARQUBE') {
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
        
        stage("Docker Image") {
                steps{
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/achatprojett .'
                }
        }
        
        stage("signIn DockerHub") {
                steps{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                }
        }
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/achatprojett'
                }
        }
        stage("Docker-compose") {
                steps{
                    sh 'docker-compose up -d'
                }
        }

    }
}

    
    
     
             
                 
             

    

