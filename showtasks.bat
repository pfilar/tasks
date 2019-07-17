call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo There were errors, can not running script.
goto fail

:browser

start chrome "http://localhost:8080/crud/v1/task/getTasks"
timeout 30
if "%ERRORLEVEL%" == "0" goto end
echo.
echo There were errors, can not running browser.
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished