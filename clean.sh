#!/bin/sh
find . -name *.class 2>>/dev/null
find . -name *.class > files.txt
echo .
echo .
echo Cleaning .class files
cat files.txt | xargs rm -rf
rm files.txt
find . -name *.class 2>>/dev/null
