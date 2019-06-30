pipeline {
    agent any 
     tools {
        maven 'Maven'
    }
      environment {

    PATH = "C:\\WINDOWS\\SYSTEM32"

}
    stages {
        stage('clone repo and clean') { 
            steps {
              bat "mvn clean"
            }
        }
        stage('Test') { 
            steps {
                bat "mvn test"
            }
        }
        stage('Deploy') { 
            steps {
                bat "mvn package"
            }
        }
    }
}