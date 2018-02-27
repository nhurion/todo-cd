#!groovy

node {
    stage('Clone Repository'){
        git 'https://github.com/nhurion/todo-cd.git'
    }

    stage('Build') {
        docker.image('maven:3.5-alpine') { c->
            sh 'mvn -B -V -U -e clean package'
        }
    }

    stage('Archive') {
        junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
    }

}