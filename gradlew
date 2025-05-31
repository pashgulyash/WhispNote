#!/usr/bin/env sh
##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

APP_NAME="Gradle"
# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/bin/java" ] ; then
        JAVACMD="$JAVA_HOME/bin/java"
    else
        echo "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
        echo "Please set the JAVA_HOME environment variable to a valid JDK directory."
        exit 1
    fi
else
    JAVACMD=java
fi

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
case "`uname`" in
    CYGWIN*) cygwin=true ;;
    MINGW*) msys=true ;;
    Darwin*) darwin=true
             if [ -z "$JAVA_HOME" ] ; then
                 JAVA_HOME=$(/usr/libexec/java_home)
             fi
             ;;
esac

CLASSPATH="$0"

# Determine the path separator.
if $cygwin || $msys ; then
    PATH_SEPARATOR=";"
else
    PATH_SEPARATOR=":"
fi

# Add gradle-wrapper.jar to CLASSPATH
CLASSPATH="$CLASSPATH$PATH_SEPARATOR$(dirname "$0")/gradle/wrapper/gradle-wrapper.jar"

# Execute Gradle wrapper jar
exec "$JAVACMD" $DEFAULT_JVM_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
