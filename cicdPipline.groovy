pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Cloning the repository if you're using Git
                git url: 'https://github.com/belaletech/jekinsSampleProject.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                // Running Maven build and specifying TestNG suite file
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=src/test/java/chrome.xml'
            }
        }
    }
    post {
        always {
            // Archive test results or reports if needed
            junit 'target/surefire-reports/*.xml'
        }
    }
}
