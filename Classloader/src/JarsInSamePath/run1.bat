set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_60"
set CURRENT_ROOT=D:\Shared\class-loader-demo\ClassloaderDemo\src\JarsInSamePath

:: Setting V1 and V2 in classpath, now check the output
set CLASSPATH=.;%CURRENT_ROOT%\v1;%CURRENT_ROOT%\v2

%JAVA_HOME%\bin\java Test
