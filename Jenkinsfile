pipeline {
    agent any

    tools {
        maven 'Maven3'  // Maven tool name in Jenkins
    }

    environment {
        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21'
        SONARQUBE_SERVER = 'SonarQubeServer'  // SonarQube server name in Jenkins config
        SONAR_TOKEN = 'sqa_ef9794b522c94ca9512140eaf876fed8634bbba6'
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        DOCKERHUB_REPO = 'alessap123/class_5_otp'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/alessaem/class_5_otp.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
           steps{
                withSonarQubeEnv('SonarQubeServer') {
                           script{
                                def scannerHome = tool 'SonarScanner'
                                bat """
                                \"${scannerHome}\\bin\\sonar-scanner.bat\"
                                -Dsonar.projectKey=class_5_otp ^
                                -Dsonar.sources=src ^
                                -Dsonar.projectName=Class-5_otp ^
                                -Dsonar.host.url=http://localhost:9000 ^
                                -Dsonar.login=${env.SONAR_TOKEN} ^
                                -Dsonar.java.binaries=target/classes
                                """
                }
            }
        }

         stage('Build Docker Image') {
                                    steps {
                                        bat 'docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
                                    }
                                }

                                stage('Push Docker Image to Docker Hub') {
                                    steps {
                                        withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                                            bat '''
                                                docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                                                docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%
                                            '''
                                        }
                                    }
                                }
    }
}