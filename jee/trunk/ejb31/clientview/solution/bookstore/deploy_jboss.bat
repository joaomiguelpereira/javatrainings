echo off
echo Cleaning and installing modules...........
echo ------------------------
call mvn clean install
echo Installing in JBOSS AS 6
echo -----------------------
cd ear
call mvn jboss:hard-deploy
cd ..