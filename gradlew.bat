@echo off
setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.

set APP_BASE_NAME=%~n0
set APP_NAME=Gradle

set DEFAULT_JVM_OPTS=

set JAVA_EXE=java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%\bin\java.exe

if exist "%JAVA_EXE%" goto init

echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
goto fail

:init

set CLASSPATH=%DIRNAME%gradle\wrapper\gradle-wrapper.jar

"%JAVA_EXE%" %DEFAULT_JVM_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

exit /b %ERRORLEVEL%

:fail
echo.
echo Gradle Wrapper could not find a valid Java installation to use.
echo Please set the JAVA_HOME environment variable.
exit /b 1
