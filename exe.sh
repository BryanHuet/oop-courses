#!/bin/bash


if [ ! "build" ];
then
mkdir "build"
fi;

javac -d "build" filrouge/*.java;
java -cp "build" filrouge.Main;
