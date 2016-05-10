#!/bin/bash

source "/home/vagrant/shared/scripts/common.sh"

# set up Apache Tomcat constants 
TOMEE_VERSION=1.7.1

TOMEE_ARCHIVE=apache-tomee-${TOMEE_VERSION}-jaxrs.zip

function installUnzip {
	echo "installing unzip"
	sudo apt-get install -y unzip
}


function installLocalApacheTomee {
	echo "======================="
	echo "installing apache-tomee"
	echo "======================="
	FILE=${VAGRANT_RESOURCES}/$TOMEE_ARCHIVE
	sudo unzip $FILE -d /usr/local/
	sudo chmod 777 -R /usr/local/apache-tomee-jaxrs-${TOMEE_VERSION}/
}

function installApacheTomee {
	if resourceExists $TOMEE_ARCHIVE; then
		installLocalApacheTomee
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/$TOMEE_ARCHIVE
	fi
}

function purgeUnzip {
	echo "purging unzip"
	sudo apt-get purge --auto-remove -y unzip
}


installUnzip
installApacheTomee
purgeUnzip
