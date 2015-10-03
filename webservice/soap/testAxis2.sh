#!/bin/bash
clear
echo "################################################"
echo "Starting Axis2 Testing"
echo "################################################"

pwd=$(pwd)
echo "Current directory ${pwd}"

echo "################################################"
echo "Building Business logic"
echo "################################################"
cd ${pwd}/business-logic
mvn clean install

echo "################################################"
echo "Building Axis Server"
echo "################################################"
cd ${pwd}/axis/server-war
mvn package

echo "################################################"
echo "Copying the war to tomcat"
echo "################################################"
cd ${pwd}/axis/server-war/target
cp *.war ${CATALINA_HOME}/webapps/

#stop tomcat
cd ${pwd}
./stopTomcat.sh


#start tomcat
cd ${pwd}
./startTomcat.sh


echo "################################################"
echo "Building client"
echo "################################################"
cd ${pwd}/axis/client
mvn test

exit