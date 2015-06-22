set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_60"
set CURRENT_ROOT=D:\Shared\gopularam-github\developer\Classloader\src\JarsInSamePath

set CLASSPATH=

%JAVA_HOME%\bin\javac -d %CURRENT_ROOT%\v1 %CURRENT_ROOT%\v1\version\Version.java
%JAVA_HOME%\bin\javac -d %CURRENT_ROOT%\v2 %CURRENT_ROOT%\v2\version\Version.java

set CLASSPATH=.;%CURRENT_ROOT%\v2;%CURRENT_ROOT%\v1
%JAVA_HOME%\bin\javac -d . Test.java

cd v1
%JAVA_HOME%\bin\jar -cvf myextension.jar version\
cd ..
