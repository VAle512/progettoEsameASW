#!/bin/bash

source "/home/vagrant/shared/scripts/common.sh"

# set up Apache Tomcat constants 
TOMCAT_VERSION=8.0.33

TOMCAT_ARCHIVE=apache-tomcat-${TOMCAT_VERSION}.tar.gz

function installLocalApacheTomcat {
	echo "========================"
	echo "installing apache-tomcat"
	echo "========================"
	FILE=${VAGRANT_RESOURCES}/$TOMCAT_ARCHIVE
	sudo tar xvzf $FILE -C /usr/local/
	sudo chmod 777 -R /usr/local/apache-tomcat-${TOMCAT_VERSION}/
}

function installApacheTomcat {
	if resourceExists $TOMCAT_ARCHIVE; then
		installLocalApacheTomcat
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/$TOMCAT_ARCHIVE
	fi
}

installApacheTomcat
