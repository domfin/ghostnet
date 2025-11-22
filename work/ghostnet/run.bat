@echo off
setlocal

rem === Grundeinstellungen (relativ zum Projektordner) ==================
set "PROJECT_DIR=%~dp0"
set "PAYARA_JAR=%PROJECT_DIR%tools\payara\payara-micro.jar"
set "ROOT_DIR=%PROJECT_DIR%payara_rt"
set "WAR=%PROJECT_DIR%target\ghostnet.war"

rem === Kurzcheck: Payara vorhanden? ===================================
if not exist "%PAYARA_JAR%" (
  echo Payara Micro fehlt: %PAYARA_JAR%
  echo Lege die payara-micro.jar nach tools\payara\
  exit /b 1
)

rem === Bauen (immer frisch, schnell & simpel) =========================
echo Bauen...
call mvn -q -f "%PROJECT_DIR%pom.xml" clean package -DskipTests
if not exist "%WAR%" (
  echo Build fehlgeschlagen: %WAR% nicht gefunden.
  exit /b 1
)

rem === Startinfo ======================================================
echo Starte Payara Micro...
echo Runtime: %ROOT_DIR%

mkdir "%ROOT_DIR%" >nul 2>&1

rem === Start Payara (minimal, ohne Schnickschnack) ====================
java -jar "%PAYARA_JAR%" ^
  --rootDir "%ROOT_DIR%" ^
  --noCluster ^
  --lite ^
  --deploy "%WAR%"

endlocal
