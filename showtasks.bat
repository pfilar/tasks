call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo Error with runcrud.bat - breaking work.
goto fail

:runbrowser
explorer "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Browser error.
goto fail

:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.