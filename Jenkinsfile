
pipeline {
    agent any
    tools{
        maven "Maven"
    }

    stages {

     
            stage('Build and Unit test') {
                steps {
                    script {
                        sh 'mvn clean package'
                    }
                }
                post {
                    always {
                        junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: false
                    }
                }
            }
//        stage('Deployment to AWS'){
  //          steps{
    //        withCredentials([usernamePassword(credentialsId: 'tomcatCredentials', passwordVariable: 'password', usernameVariable: 'username'),string(credentialsId: 'TOMCAT_URL', variable: 'tomcat_url')]){
                //    sh 'curl ${tomcat_url}/manager/text/undeploy?path=/BMI -u ${username}:${password}'
                  //  sh 'curl -v -u ${username}:${password} -T target/SpringBootHelloWorld-0.0.1-SNAPSHOT${BUILD_NUMBER}.war ${tomcat_url}/manager/text/deploy?path=/BMI'
                //}
            //}
        //}
}
}
