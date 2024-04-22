pipeline {
    agent any
    tools{
        maven 'maven_3_9_6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/PassionateCodeBot/devops-automation']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t passionatecodebot/devops-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{                  
                   bat 'docker login -u siddireddy --password-stdin < C:/manoj/dockerpassword.txt'
                    bat 'docker tag passionatecodebot/devops-integration'                                     
                }
            }
        }
        stage('Deploy to K8s')
        {
            steps{
                script{
                    kubernetesDeploy(configs: 'deploymentservice.yaml', kubeconfigId: 'k8configpwd')
                }
            }
        }       
    }
}
