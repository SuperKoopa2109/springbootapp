pipeline {

    agent any

    stages {
        stage ('Unit Tests') {
	    steps {
                script {
                    try {
			echo '***Testing the application***'
                        sh './gradlew clean build test jacocoTestReport --no-daemon'
                    } finally {
                        junit 'build/test-results/test/*.xml'
                    }

                    stash includes: 'build/reports/**/*', name: 'reports'
                    stash includes: 'build/distributions/*', name: 'distributions'
                    stash includes: 'build/libs/*.jar', name: 'libs'
                }
            }
        }
        stage ('Publish Reports') {
            steps {
                script {
		    echo '***publishing reports***'
                    unstash name: 'reports'

                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'Unit Test Report', reportTitles: ''])
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/jacoco/test/html', reportFiles: 'index.html', reportName: 'Code Coverage Report', reportTitles: ''])
                }
            }
        }
        stage ('Archive Artifacts') {
            steps {
                script {
		    echo '***Archiving Artifacts***'
			
                    unstash name: 'distributions'
                    unstash name: 'libs'

                    archiveArtifacts artifacts: 'build/distributions/*', fingerprint: true
                    archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
                }
            }
        }
        stage ('Delivery'){
            steps{
                script{
			echo '***Application is being delivered to the machine***'
			sh './gradlew build docker'
                }
            }
        }
	    stage ('Deployment'){
		    steps{
			    script{
				    echo '***Application is being deployed on the machine***'
				    sh 'docker run -p 9001:9011 mbition/spring-boot-app'
			    }
		    }
	    }
    }
    post {
        always {
            echo 'Post'
        }
    }
}
