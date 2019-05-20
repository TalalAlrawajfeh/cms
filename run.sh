#!/bin/bash

## start mysql docker
#docker pull mysql
#docker run --name cms-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
#
## wait for database server to wake up
#while true
#do
#    curl -sSf http://localhost:3306 > /dev/null 2>&1
#    RESULT=$?
#
#    if [[ ${RESULT} -eq 0 ]]
#    then
#        break
#    fi
#
#    sleep 1
#done

if [[ ! -d /opt/tomcat ]]
then
    sudo mkdir /opt/tomcat
    sudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat

    wget http://www-us.apache.org/dist/tomcat/tomcat-9/v9.0.20/bin/apache-tomcat-9.0.20.tar.gz -P /tmp
    sudo tar xf /tmp/apache-tomcat-9*.tar.gz -C /opt/tomcat
    sudo ln -s /opt/tomcat/apache-tomcat-9.0.20 /opt/tomcat/latest
    sudo chown -RH tomcat: /opt/tomcat/latest
    sudo sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'

    sudo cp ./tomcat.service /etc/systemd/system/tomcat.service
    sudo systemctl daemon-reload
    sudo systemctl start tosmcat
fi

sudo bash -c 'if [[ -d /opt/tomcat/latest/webapps/cms-0.0.1-SNAPSHOT ]]; then rm -rf /opt/tomcat/latest/webapps/cms-0.0.1-SNAPSHOT; fi'
sudo bash -c 'if [[ -d /opt/tomcat/latest/webapps/content-0.0.1-SNAPSHOT ]]; then rm -rf /opt/tomcat/latest/webapps/content-0.0.1-SNAPSHOT; fi'
sudo bash -c 'if [[ -f /opt/tomcat/latest/webapps/cms-0.0.1-SNAPSHOT.war ]]; then rm -rf /opt/tomcat/latest/webapps/cms-0.0.1-SNAPSHOT.war; fi'
sudo bash -c 'if [[ -f /opt/tomcat/latest/webapps/content-0.0.1-SNAPSHOT.war ]]; then rm -rf /opt/tomcat/latest/webapps/content-0.0.1-SNAPSHOT.war; fi'

sudo cp ./cms/target/cms-*.war /opt/tomcat/latest/webapps
sudo cp ./content/target/content-*.war /opt/tomcat/latest/webapps
sudo systemctl restart tomcat