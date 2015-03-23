@ECHO OFF
cd %~dp1
IF EXIST %~n1.class (
DEL %~n1.class
)
javac -encoding UTF-8 %~nx1
IF EXIST %~n1.class (
java %~n1
)