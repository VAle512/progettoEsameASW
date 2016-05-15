#!/bin/bash

source "/home/vagrant/shared/scripts/common.sh"

WAR_NAME=progettoEsameASW
WAR_FILE=${WAR_NAME}.war

function deployWar {
	echo "deoloying ${WAR_FILE}"
	if resourceExists ${WAR_FILE}; then
		deployLocalWar
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/$WAR_FILE
	fi
}

function startApache {
	echo "====================="
	echo "starting apache tomee"
	echo "====================="
	/bin/su -s /bin/bash -c '/usr/local/apache-tomee-jaxrs-1.7.1/bin/startup.sh' vagrant
}

function deployLocalWar {
	rm -rf /usr/local/apache-tomee-jaxrs-1.7.1/webapps/${WAR_NAME}*
	cp ~vagrant/shared/resources/${WAR_FILE} /usr/local/apache-tomee-jaxrs-1.7.1/webapps/
	echo "done"
}

deployWar
startApache
