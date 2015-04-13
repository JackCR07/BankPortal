@ECHO OFF
SETLOCAL
if not ".%1%" == ".settitle" goto skip_title
title IBM Business Web Factory 3 Reset Obscured Property
shift
:skip_title

%JAVA_HOME%\bin\java -Xms4m -Xmx16m -classpath ..\lib\xml-apis.jar;..\lib\jdom.jar;..\lib\servlet.jar;..\lib\mail.jar;..\lib\activation.jar;..\lib\bstres.jar;..\lib\bstres_nl1.jar;..\lib\factory.jar;..\clientLibs\j2ee.jar;..\classes;..\lib -Dbowstreet.rootDirectory=.. com.bowstreet.util.ResetObscuredProperty %1 %2 %3 %4 %5 %6 %7 %8 %9

ENDLOCAL















