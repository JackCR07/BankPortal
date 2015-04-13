@ECHO OFF
SETLOCAL

if not ".%1%" == ".settitle" goto skip_title
title IBM Factory Obscured Property Value
shift
:skip_title

%JAVA_HOME%\bin\java -Xms4m -Xmx16m -classpath ..\lib\factory.jar;..\lib\bstres.jar;..\lib\bstres_nl1.jar;..\clientLibs\j2ee.jar;..\classes;..\lib -Dbowstreet.rootDirectory=.. com.bowstreet.util.ObscureProperty %1

ENDLOCAL















