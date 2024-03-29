pipeline
{
    agent any 
    stages
    {
      stage("cont_download" )
      {
          steps
          {
              git branch: 'main', url: ' your-git-hub-url '
          }
      }
      stage("cont_build" )
      {
          steps
          {
              sh 'mvn package'
          }
      }
      stage("cont_deploytest" )
      {
          steps
          {
             sh 'scp /var/lib/jenkins/workspace/sample/target/devops.war ubuntu@Private-ip-Test:/var/lib/tomcat9/webapps/testapp.war' 
              
          }
      }
      stage("cont_test" )
      {
          steps
          {
             sh 'echo "testing passed"' 
              
          }
      }
      stage("coont_deploy_prod" )
      {
          steps
          {
             sh 'scp /var/lib/jenkins/workspace/sample/target/devops.war ubuntu@Private-ip-Prod:/var/lib/tomcat9/webapps/appnew.war' 
              
          }
      }
     
    }
}
