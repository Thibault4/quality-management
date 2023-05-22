node { 

    stage('Checkout') {
        git branch: "develop", url: "https://github.com/Thibault4/quality-management.git", credentialsId: "Thibault4"
    }

    stage('Build') {
        sh 'docker build -t my-scanner-new -f Dockerfile.sonar .'
    }

    stage('Scan') {
        docker.image('my-scanner-new').inside('-v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""') {
        sh "/usr/local/bin/sonar-scanner"
        }
    }
    stage('SCM') {
        checkout scm
    }
    stage('SonarQube Analysis') {
        def mvn = tool 'Default Maven';
        withSonarQubeEnv() {
          sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Thibault4_quality-management_AYhDXVPpPJFetB85z_Xk -Dsonar.projectName='quality-management'"
        }
    }
}