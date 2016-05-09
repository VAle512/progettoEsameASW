#! /bin/sh
echo "====================="
echo "starting apache tomcat"
echo "====================="
/bin/su -s /bin/bash -c '/usr/local/apache-tomcat-8.0.33/bin/startup.sh' vagrant
