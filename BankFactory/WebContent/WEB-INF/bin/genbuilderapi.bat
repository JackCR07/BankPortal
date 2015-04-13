@echo off
:* Builder API wrapper class generator
:* First argument is builder definition ID, or a package ID 
:* e.g., com.bowstreet.builders.webapp.LinkBuilder
:* This is a reference implementation!  No support is implied.

SETLOCAL

if not "x%1%" == "x" goto has_args
echo .
echo usage: genbuilderapi builderID [builderID ...]
echo example: genbuilderapi com.bowstreet.builders.webapp.LinkBuilder
echo .
echo For the builderID, you can specify just a package and all builders 
echo within that package will have their API classes generated.
echo example: genbuilderapi com.bowstreet.samples
echo will generate API classes for all the sample builders.
echo .
echo Note: if the compilation step fails, add tools.jar to the CLASSPATH
echo .
goto done

:has_args

if not "x%JAVA_HOME%" == "x" goto has_java
echo .
echo This batch file requires the environment variable JAVA_HOME to be defined.
echo .
goto done

:has_java

if exist %JAVA_HOME%\lib\tools.jar goto has_tools

SET _tools=%CLASSPATH:*tools.jar=tools.jar%
SET _tools=%_tools:~0,9%
IF %_tools% EQU tools.jar goto has_tools

echo .
echo You must have a tools.jar either in your classpath or in %JAVA_HOME%\lib
echo .
goto done

:has_tools

:top

echo .
%JAVA_HOME%\bin\java -Xms32m -Xmx196m -classpath ".;..\lib\activation.jar;..\lib\commons-pool.jar;..\lib\bstres.jar;..\lib\bstres_nl1.jar;..\lib\jdom.jar;..\lib\log4j.jar;..\lib\factory.jar;..\clientlibs\builderui.jar;..\clientlibs\j2ee.jar;..\lib\wsdl4j.jar;..\classes;..\lib;%JAVA_HOME%\lib\tools.jar;%CLASSPATH%" -Dbowstreet.rootDirectory=.. com.bowstreet.builderutilities.BuilderAPIGenerator %1
echo .

shift
if not "x%1%" == "x" goto top
:done

ENDLOCAL 




























