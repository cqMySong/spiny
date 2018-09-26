#!/usr/bin/env bash
# Linux platform bash file
echo "author godcheese"
CURRENT_DIR=`pwd`
cd $CURRENT_DIR
cd ..
./mvnw spring-boot:run -DskipTests=true -Dmaven.javadoc.skip=true -Dspring-boot.run.profiles=dev
cd $CURRENT_DIR