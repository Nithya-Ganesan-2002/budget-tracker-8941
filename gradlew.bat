@echo off
REM Root-level Gradle wrapper shim delegating to the Android app's wrapper.
setlocal enabledelayedexpansion
set SCRIPT_DIR=%~dp0
set APP_DIR=%SCRIPT_DIR%budgetbuddy_android_app
set WRAPPER=%APP_DIR%\gradlew.bat
if exist "%WRAPPER%" (
  call "%WRAPPER%" -p "%APP_DIR%" %*
  exit /b %ERRORLEVEL%
) else (
  echo Gradle wrapper not found at "%WRAPPER%".
  exit /b 1
)
