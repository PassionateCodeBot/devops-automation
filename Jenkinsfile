pipeline {
    agent any
    tools{
        maven 'maven_3_9_6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Java-Techie-jt/devops-automation']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t javatechie/devops-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{                  
                   bat 'docker login -u siddireddy -stdin < C:/manoj/dockerpassword.txt'
                    bat 'docker tag javatechine/devops-integration siddireddy/mymetechproj:secondpush'
                    bat 'docker push siddireddy/mymtechproj:secondpush'                   
                }
            }
        }
       
    }
}
