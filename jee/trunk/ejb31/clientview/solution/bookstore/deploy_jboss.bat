echo off
echo Cleaning and installing module...........
echo ------------------------
call mvn clean install
echo Installing in JBOSS AS 7
echo -----------------------
cd ear
call mvn jboss-as:deploy
cd ..