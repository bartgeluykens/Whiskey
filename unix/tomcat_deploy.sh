#--------------------------------------------------------------------------------
# aliases
export WHISKEY_REPOS=~/git/whiskeyCollection 
alias c='cd ${WHISKEY_REPOS}'
alias s='cd ${WHISKEY_REPOS}'
alias mvnt='mvn install -Dmaven.test.skip=true'
alias css='gvim --servername CSS; sleep 0.5; find . -wholename "*/src/*/*.css" -exec gvim --servername CSS --remote-send ":sp {}<CR>" \;'

export CATALINA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5000" 



function byEnd ()
{
  nbrSelection=$(find . -wholename "*/src/*/*$1" | wc -l ) 
  if  [ $nbrSelection -ge 8 ]; then
      find . -wholename "*/src/*/*$1" -exec gvim --servername $1 --remote-tab {} \; -exec sleep 0.1 \;
  else
    if [ $nbrSelection -eq 0 ]; then
      echo Geen records gevonden
    else
      gvim --servername $1; 
      sleep 0.5; 
      find . -wholename "*/src/*/*$1" -exec gvim --servername $1 --remote-send ":sp {}<CR>" \;
    fi;
  fi;
}

function fast_deploy()
{
  cp -Rf ${WHISKEY_REPOS}/WebContent/WEB-INF/resources/javascripts/  ${TOMCAT_HOME}/webapps/vlok/WEB-INF/resources/
}


function start_hsqldb()
{
  java -cp ~/.m2/repository/org/hsqldb/hsqldb/2.2.8/hsqldb-2.2.8.jar org.hsqldb.Server -database.0 file:${WHISKEY_REPOS}/tmpdb/whiskey -dbname.0 xdb &
}


function stop_hsqldb()
{
  java  -cp /home/bart/.m2/repository/org/hsqldb/sqltool/2.2.8/sqltool-2.2.8.jar:/home/bart/.m2/repository/org/hsqldb/hsqldb/2.2.8/hsqldb-2.2.8.jar   org.hsqldb.cmdline.SqlTool --inlineRc url=jdbc:hsqldb:hsql://localhost/xdb,user=sa,password= --sql "shutdown;"
}


function start_hsql_viewer ()
{
   java -jar ~/.m2/repository/org/hsqldb/hsqldb/2.2.8/hsqldb-2.2.8.jar &
}


# kill hanging java process after standalone integration test (without killbrowser method)
alias kill_java='kill $(ps -ef | grep java |  grep portal-pub | awk '{ print $2 }')'

# restart the nging server after config change
alias nginx_restart='sudo kill -HUP `cat /var/run/nginx.pid`'

#--------------------------------------------------------------------------------
# java
#export JAVA_HOME=/usr/lib/jvm/java-6-sun
#export JAVA_HOME=/usr/lib/jvm/java-6-openjdk
export JAVA_HOME=/usr/lib/jvm/java-7-oracle
export PATH=${JAVA_HOME}/bin:${PATH}

#--------------------------------------------------------------------------------
# Maven develop (no compression)
function develop_mvn_install()
{
mvn -P\!compress -Dmaven.test.skip=true install
}

#--------------------------------------------------------------------------------
# local vfp path
#export PATH=$PATH:~/code/pb/bin


#--------------------------------------------------------------------------------
# tomcat

export TOMCAT_ROOT=~/soft/tomcat_essential
#export TOMCAT_HOME=$TOMCAT_ROOT/v6.0.32
export TOMCAT_HOME=$TOMCAT_ROOT
alias t='cd $TOMCAT_HOME'
alias d='mvn install -Dmaven.test.mvn install -Dmaven.test.skip=true -Dtomcatweb=${TOMCAT_HOME}/webapps'

# function get_tomcat {
#   TC_VERSION=6.0.32
#   NEW_DIR=$1
#   mkdir -p $TOMCAT_ROOT && cd $_
#   curl http://apache.cu.be/tomcat/tomcat-6/v$TC_VERSION/bin/\{apache-tomcat-$TC_VERSION.tar.gz\} -o"#1"
#   tar zxvf  apache-tomcat-$TC_VERSION.tar.gz 
#   mv apache-tomcat-$TC_VERSION $NEW_DIR
#   cd $NEW_DIR
#   find  ~/Dropbox/vfp/develop/tomcat-provided-jars -name \*.jar -exec cp {} lib \;
#   # use git repo of dropbox
#   git init
#   git remote add origin file://$HOME/Dropbox/vfp/repos/tomcat.git
#   git pull origin master
#   git fetch origin
# }
# 
# function selenium_start {
#   cd ~/soft/selenium
#   java -jar selenium-server-standalone-2.0rc2.jar
# }
# 
# function tomcat_home_hsqldb {
#    export TOMCAT_HOME=$TOMCAT_ROOT/hsqldb
# }
# 
# function tomcat_home_localdb {
#    export TOMCAT_HOME=$TOMCAT_ROOT/localdb
# }
# 
# function install_tomcat_hsqldb {
#    get_tomcat hsqldb
#    tomcat_home_hsqldb
#    git checkout -b hsqldb origin/hsqldb
# }
# 
# function install_tomcat_localdb {
#    get_tomcat localdb
#    tomcat_home_localdb
#    git checkout -b localdb origin/localdb
# }

function tomcat_clean {
  cd $TOMCAT_HOME
  rm -rf conf/Catalina
  rm -rf work;    mkdir work
  rm -rf logs;    mkdir logs
  rm -rf temp;    mkdir temp
  rm -rf webapps; mkdir webapps
  cd - >/dev/null
}

function tomcat_deploy {
  cp -R  ${WHISKEY_REPOS}/target/whiskeycollection.war $TOMCAT_HOME/webapps/
}

function tomcat_startup {
  #rm $TOMCAT_HOME/logs/*
  $TOMCAT_HOME/bin/startup.sh
}

function tomcat_shutdown {
  tomcat_processes=$(ps -ef | grep java | grep tomcat | wc -l)
  if [ "$tomcat_processes" -gt "0" ]; then
    echo -n "> waiting for tomcat to finish"
    $TOMCAT_HOME/bin/shutdown.sh
    while [ "$tomcat_processes" -gt "0" ]
    do
      sleep 1 
      tomcat_processes=$(ps -ef | grep java | grep tomcat | wc -l)
      echo -n "."
    done
    echo ""
  else
    echo "tomcat is not running"
  fi
}

function tomcat_all {
   tomcat_shutdown
   tomcat_clean
   tomcat_deploy
   tomcat_startup
}


