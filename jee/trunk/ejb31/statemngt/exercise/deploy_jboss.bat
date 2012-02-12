echo off
echo Cleaning and installing module...........
echo ------------------------
call mvn clean install -Dmaven.test.skip=true 
echo Installing in JBOSS AS 7
echo -----------------------
cd enterprise-application
call mvn jboss-as:deploy
cd ..