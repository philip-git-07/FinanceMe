pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/philip-git-07/FinanceMe.git'
            }
        }

        stage('Build and Docker Image') {
            steps {
                sh 'mvn clean install'
                sh 'docker build -t banking-java-app:latest .'
            }
        }

        stage('Stop and Remove Container') {
            steps {
                script {
                    def containerExists = sh(script: 'docker ps -a | grep banking-java-app', returnStatus: true)
                    if (containerExists == 0) {
                        sh 'docker stop banking-java-app'
                        sh 'docker rm -f banking-java-app'
                    }
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8888:8080 --name banking-java-app banking-java-app'
            }
        }

        stage('Run Maven Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Login, Commit, and Push') {
            steps {
                sh "docker login -u philip07 -p dckr_pat_IsZ3pyV7EQJ1nlXjbSeGDZEs_AM"
                sh 'docker commit banking-java-app philip07/banking-java-app:latest'
                sh 'docker push philip07/banking-java-app:latest'
            }
        }
    }
}
