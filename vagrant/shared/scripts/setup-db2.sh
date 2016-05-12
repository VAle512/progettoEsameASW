#!/bin/bash

source "/home/vagrant/shared/scripts/common.sh"

# set up DB2 Express-C constants 
DB2_FILE=db2exc_amd64.deb

function installGdebi {
	echo "installing gdebi"
	sudo apt-get install -yq gdebi
}

function installDB2 {
	if resourceExists $DB2_FILE; then
		installLocalDB2
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/$DB2_FILE
	fi
}

function installLocalDB2 {
	echo "============================"
	echo "installing IBM DB2 Express-C"
	echo "============================"
	sudo gdebi --n /home/vagrant/shared/resources/db2exc_amd64.deb 
}

function purgeGdebi {
	echo "purging gdebi"
	sudo apt-get purge --auto-remove -yq gdebi
}

function createDatabase {
	/bin/su -s /bin/bash -c '/home/vagrant/shared/scripts/create-database.sh' db2inst1
}

installGdebi
installDB2
purgeGdebi
createDatabase
