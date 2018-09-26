#!/usr/bin/env bash
# Linux platform bash file
echo "author godcheese"
CURRENT_DIR=`pwd`
cd $CURRENT_DIR
cd ..
./mvnw clean package -DskipTests=true -Dmaven.javadoc.skip=true -Dspring-boot.run.profiles=prod
cd $CURRENT_DIR
# read -s -n1 -p "Press any key to continue ... "