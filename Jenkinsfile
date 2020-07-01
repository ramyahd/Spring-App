pipeline {
    agent any
    tools{
        maven "Maven"
    }

    stages {

      stage('clean and build')
            {
                steps
                 { 
                    sh 'mvn clean package'
                 }
            
         post {
                    always {
                        junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: false
                    }
                }
            }
       stage('Deployment to AWS'){
            steps{
    
 deploy adapters: [tomcat9(credentialsId: 'Tomcat', path: '', url: 'http://13.235.95.31:8090/')], contextPath: '/cur', war: '**/*.war'

            //withCredentials([usernamePassword(credentialsId: 'tomcatCredentials', passwordVariable: 'password', usernameVariable: 'username'),string(credentialsId: 'TOMCAT_URL', variable: 'tomcat_url')]){
              //      sh 'curl ${tomcat_url}/manager/text/undeploy?path=/BMI -u ${username}:${password}'
                //    sh 'curl -v -u ${username}:${password} -T target/SpringBootHelloWorld-0.0.1-SNAPSHOT${BUILD_NUMBER}.war ${tomcat_url}/manager/text/deploy?path=/BMI'
                //}
            }
        }
}
}
