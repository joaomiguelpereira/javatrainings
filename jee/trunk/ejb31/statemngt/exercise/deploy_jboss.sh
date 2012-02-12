#!/bin/sh

echo "=====Installing..."
mvn clean install

echo "=====Deploying to JBoss AS 7..."
cd ear
mvn jboss-as:deploy



