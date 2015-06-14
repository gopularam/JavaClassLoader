set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_60"
set CURRENT_ROOT=D:\Shared\class-loader-demo\ClassloaderDemo\src\RMIdifferentversions

set CLASSPATH=

%JAVA_HOME%\bin\javac -d %CURRENT_ROOT%\common %CURRENT_ROOT%\common\common\*.java

set CLASSPATH=%CURRENT_ROOT%\common
%JAVA_HOME%\bin\javac -d %CURRENT_ROOT%\server %CURRENT_ROOT%\server\server\*.java

set CLASSPATH=%CURRENT_ROOT%\common;%CURRENT_ROOT%\server
%JAVA_HOME%\bin\rmic -d %CURRENT_ROOT%\common server.ServerImpl

%JAVA_HOME%\bin\javac -d %CURRENT_ROOT%\client1 %CURRENT_ROOT%\client1\client\*.java
%JAVA_HOME%\bin\javac -d %CURRENT_ROOT%\client2 %CURRENT_ROOT%\client2\client\*.java


