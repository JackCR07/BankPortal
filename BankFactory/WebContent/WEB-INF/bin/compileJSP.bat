REM Note: the ability to generate precompiled JSPs is deprecated and this feature
REM will be removed in a future release.

@ECHO OFF
SETLOCAL

title IBM Factory Compile JSP
shift

if "%JAVA_HOME%" == "" goto java_message

%JAVA_HOME%\bin\java -classpath ..\lib;..\lib\factory.jar;..\classes;..\lib\axis.jar;..\lib\NCSO.jar;..\lib\jakarta-poi.jar;..\lib\commons-logging.jar;..\lib\commons-pool.jar;..\lib\commons-discovery.jar;..\lib\commons-fileupload.jar;..\lib\jdom.jar;..\lib\bstres.jar;..\lib\bstres_nl1.jar;..\lib\log4j.jar;..\lib\packman.jar;..\clientLibs\j2ee.jar;%JAVA_HOME%\lib\tools.jar; -Dbowstreet.rootDirectory=.. -Druntime.runningOnServer=true com.bowstreet.util.compile.JSPCompile -excludelist exclude_models.txt %0 %1 %2 %3 %4 %5 %6 %7 %8 %9
goto end

:java_message
echo.
echo The JAVA_HOME environment variable must be set for this script to run.
echo.
goto end


:end
ENDLOCAL


















