pipeline {
    agent any 
   
    stages {
        stage('clone repo and clean') { 
            steps {
              bat "mvn clean -f Transport"
            }
        }
        stage('Test') { 
            steps {
                bat "mvn test -f Transport"
            }
        }
        stage('Deploy') { 
            steps {
                bat "mvn package -f Transport"
            }
        }
    }
}