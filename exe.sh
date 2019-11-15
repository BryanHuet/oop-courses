#!/usr/bin/env bash

if test -d "build"
then
    if ! test -f */Main.java 
    then echo "Enter name of the exectuable class without .java: ";read exeName;
    else exeName="Main";
    fi;
    for i in *;
    do
        if test -f $i/$exeName.java;
          then package=$i;
        fi;
    done;

javac -d "build" $package/*.java;
java -cp "build" $package.$exeName;

else echo "Creation d'un dossier build...";
echo " "
mkdir "build";
fi;
