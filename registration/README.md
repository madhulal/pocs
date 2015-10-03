# Registration

This is a spring mvc(version # 4.1.1) project

## System Requirements
1. Java 1.7.x
2. Maven 3.x
3. Tomcat/Jboss/Jetty/Weblogic(Optional)
4. Mongodb( Runs at localhost:27017. db name is test)

## Build and bring up the app in Jetty server
* Run mvn jetty:run from shell
* Access the application at http://localhost:8080/
* After use stop the server by pressing Ctrl+C from the shell

## Build the app in your favourite app server
*. mvn clean install
*. Deploy the war from/target/ to the application server of your choice.


Ref: http://www.javabeat.net/spring-data-mongodb-tutorial/

