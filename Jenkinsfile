pipeline {
    agent any

    
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mamata2077/UnitTestingJava.git'

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }
        stage('Test') {
            steps {
               
                // To run Maven on a Windows agent, use
                bat "mvn test"
            }

            
        }
    }
}
