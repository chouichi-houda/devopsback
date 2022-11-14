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
                 echo 'mvn test -Dtest=CategorieProduitImplTest'
                 echo 'mvn test -Dtest=StockImplTest'
            }
        }
        
        stage(' SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'   
            }
        }
        
        
       stage(' Nexus') {
            steps {
                script {
					nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0.jar', type: 'jar']], credentialsId: 'NEXUS_CRED', groupId: 'com.esprit.examen', nexusUrl: '192.168.1.16:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-releases', version: '1.0'
				}
            }
           		
            }
       }
    }
}
