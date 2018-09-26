#!/usr/bin/env bash
# Linux platform bash file
echo "author godcheese"
CURRENT_DIR=`pwd`
cd $CURRENT_DIR
cd ..
echo "Add file..."
git add .
echo -n "Submit remark...Please input anything(Initial commit):"
read REMARK
if [ ! -n "$REMARK" ];then
    REMARK="Initial commit"
fi
git commit -m "$REMARK"
echo "Submit code..."
git push origin master
echo "Submit complete,close..."
cd $CURRENT_DIR