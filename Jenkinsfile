pipeline {
	agent any

    tools {
		jdk 'java-21'
        maven 'maven-3.9.4'
    }

    stages {
		stage('Build Maven') {
			steps {
				checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/Umamahesh1998/devops-cicd']]
                )

                sh 'echo "Java version:"'
                sh 'java -version'

                sh 'echo "JAVA_HOME is set to: $JAVA_HOME"'
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
			steps{
				script{
					sh 'docker build -t mahesh698/devops-integration .'
                }
            }
        }
        stage('Push Image To Hub'){
			steps{
				script{
					withCredentials([string(credentialsId: 'dockerjenkinspwd', variable: 'dockerjenkinspwd')]) {
						sh 'docker login -u mahesh698 -p ${dockerjenkinspwd}'
                      }
                     sh 'docker push mahesh698/devops-integration'
                }
            }
        }
    }

}
