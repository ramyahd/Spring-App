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
       stage('Deployment to AWS')
        {
            steps{
    
             //deploy adapters: [tomcat9(credentialsId: 'Tomcat', path: '', url: 'http://13.235.95.31:8090/')], contextPath: '/cur', war: '**/*.war'

            withCredentials([usernamePassword(credentialsId: 'Tomcat', passwordVariable: 'password', usernameVariable: 'username')])
                {
                    sh 'curl http://13.235.95.31:8090/manager/text/undeploy?path=/cur -u ${username}:${password}'
                    sh 'curl -v -u ${username}:${password} -T target/SpringbootAssignment-0.0.1-SNAPSHOT.war http://13.233.9.155:8090/manager/text/deploy?path=/cur'
                }
                   }
                                   }
                
}
}
