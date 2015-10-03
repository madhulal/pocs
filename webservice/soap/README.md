#Soap Web Services Sample

## Axis 2 with xmlbeans

Requirements
1. JAVA 1.7
2. Tomcat 7
3. CATALINA_HOME is set

### One Click Run

* If you run mvn install from the base directory, it will fail as the client is expecting the service to be running at
    http://localhost:8000/axis2/services/MozantaTemperatureService?wsdl

* A work around is to run ./testAxis2.sh
  [It builds the server, deploy the war to tomcat set at CATALINA_HOME, shutdown tomcat, start it again. builds the client. Runs the test cases of axis2_client]
* Access the wsdl at http://localhost:8000/axis2/services/MozantaTemperatureService?wsdl
* After the user stop the tomcat server using ./stopTomcat.sh
TODO create a bat file

### The Hard way

####Business Logic
1. Go to business-logic
2. Run mvn clean install from shell

####Server(Old way) - Optional

1.  Here we are writing a simple java class to convert temperature between celsius and fahrenheit
2.  Go to axis/axis2-server/pom.xml
3.  Change the 'app.server.aar.deploy.dir property' to your tomcat/jboss deploy folder
4.  Open command prompt. Run 'mvn package'.
5.  Tomcat has to be restarted. Once its up, Goto http://localhost:8080/axis2/services/listServices and make sure that our service listed MozantaTemperatureConverterService
6.  Also verify that http://localhost:8080/axis2/services/MozantaTemperatureService?wsdl is loaded.

Reference : http://www.itcuties.com/j2ee/axis2-java2wsdl-approach/

####Server-War

This will help us deploy the war instead of AAR file.

#### Build and bring up the app in Jetty server
* Run mvn jetty:run from shell
* Access the service using the url http://localhost:8000/axis2/services/MozantaTemperatureService?wsdl(port # is changed in axis2.xml)
* After use, stop the server by pressing Ctrl+C from the shell

#### Build the app in your favourite app server
1.  Go to axis/axis2-server-war in command prompt.
2.  mvn clean install.
3.  Go to target folder and copy the war file to the application server.
4.  Access the service using the url http://localhost:8000/axis2/services/MozantaTemperatureService?wsdl(port # is changed in axis2.xml)
TODO : Copy the war to tomcat webapps folder

Reference: http://maksim.sorokin.dk/it/2011/01/13/axis2-maven-servlets-tomcat/

#### Client
1.  Here we are trying to consume the service http://localhost:8000/axis2/services/MozantaTemperatureService
2.  A Client class is already written using the xmlbeans assuming that the client classes for axis are generated.
3.  Eclipse/intellij will show error until you run mvn compile.
4.  Please make sure app server is up with the above service in the given url. Goto axis2_client. Run 'mvn test'.
5.  The TemperatureClientTest contains all the test cases and all should pass.