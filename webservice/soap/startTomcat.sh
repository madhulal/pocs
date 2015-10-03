#!/bin/bash
echo "################################################"
echo "Starting Tomcat Server"
echo "################################################"

cd ${CATALINA_HOME}/bin
./startup.sh

echo "################################################"
echo "Tomcat Server started"
echo "################################################"

exit