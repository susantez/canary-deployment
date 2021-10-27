@echo off
:top
curl -s http://localhost:8080/api/version
echo .
timeout /t 2 /nobreak > NUL
goto top