pipeline{
    agent any
    tools{
        jdk 'jdk17'
        nodejs 'node16'
    }
    environment {
        SCANNER_HOME=tool 'sonar-scanner'
    }
    stages {
        stage('clean workspace'){
            steps{
                cleanWs()
            }
        }
        stage('Checkout from Git'){
            steps{
                git branch: 'main', url: 'https://github.com/CavistaHackathon/TeamLovelace.git'
            }
        }
        stage("Sonarqube Analysis "){
            steps{
                withSonarQubeEnv('sonar-server') {
                    sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Cavista \
                    -Dsonar.projectKey=Cavista '''
                }
            }
        }
        stage("quality gate"){
           steps {
                script {
                    waitForQualityGate abortPipeline: false, credentialsId: 'Sonar-token' 
                }
            } 
        }
        stage('Install Dependencies') {
            steps {
                sh "npm install"
            }
        }
        stage('OWASP FS SCAN') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage('TRIVY FS SCAN') {
            steps {
                sh "trivy fs . > trivyfs.txt"
            }
        }
        stage("Docker Build & Push"){
            steps{
                script{
                    sh 'echo dckr_pat_wi6Z-TXV0jKnlZGPvr1On59WP-Q | /usr/bin/docker login -u kuldeeproy --password-stdin'    
                    sh "docker build -t cavista ."
                    sh "docker tag cavista kuldeeproy/cavista:latest "
                    sh "docker push kuldeeproy/cavista:latest "
                }
            }
        }
        stage("TRIVY"){
            steps{
                sh "trivy image kuldeeproy/cavista:latest > trivyimage.txt" 
            }
        }
        stage('Deploy to container'){
            steps{
                sh 'docker run -d --name cavista -p 3000:3000 kuldeeproy/cavista:latest'
            }
        }
    }
}
