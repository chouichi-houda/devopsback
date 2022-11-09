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
        
        stage('SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                 
            }
        }
        
        stage('Nexus'){
            steps{
                sh 'mvn package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.10:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0 '
            }
        }

    }
}

    
    
     
             
                 
             

    

