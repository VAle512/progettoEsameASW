#!/bin/bash

source "/home/vagrant/shared/scripts/common.sh"

# set up Apache Tomcat constants 
TOMEE_VERSION=1.7.1

TOMEE_ARCHIVE=apache-tomee-${TOMEE_VERSION}-jaxrs.zip

function installUnzip {
	echo "installing unzip"
	sudo apt-get install -yq unzip
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
	sudo apt-get purge --auto-remove -yq unzip
}

function setupConfigFiles {
	echo "setup tomee conf/context.xml"
	if resourceExists config_context.xml; then
		cat ${VAGRANT_RESOURCES}/config_context.xml > /usr/local/apache-tomee-jaxrs-${TOMEE_VERSION}/conf/context.xml
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/config_context.xml
	fi

	echo "setup tomee conf/tomee.xml"
	if resourceExists config_tomee.xml; then
		cat ${VAGRANT_RESOURCES}/config_tomee.xml > /usr/local/apache-tomee-jaxrs-${TOMEE_VERSION}/conf/tomee.xml
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/config_tomee.xml
	fi
}


installUnzip
installApacheTomee
purgeUnzip
setupConfigFiles
