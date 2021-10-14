@echo off
:top
echo version:
curl -s http://localhost/api/version
timeout /t 2 /nobreak > NUL
goto top