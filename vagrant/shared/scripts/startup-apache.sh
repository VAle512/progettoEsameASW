#! /bin/sh

#rm -rf /usr/local/apache-tomee-jaxrs-1.7.1/webapps/progettoEsameASW*
#cp ~vagrant/shared/resources/progettoEsameASW.war /usr/local/apache-tomee-jaxrs-1.7.1/webapps/

echo "====================="
echo "starting apache tomee"
echo "====================="
/bin/su -s /bin/bash -c '/usr/local/apache-tomee-jaxrs-1.7.1/bin/startup.sh' vagrant
