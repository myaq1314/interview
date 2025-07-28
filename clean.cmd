@echo off

set ROOT_PATH=%cd%
echo "---------------root path:[[  %ROOT_PATH%  ]]---------------"

echo "--------------------------------------------------------------------"
cd %ROOT_PATH%/isa/
call mvn clean:clean
echo "--------------------------------------------------------------------"

echo "---------------return to the project root directory---------------"
cd %ROOT_PATH%
if exist logs (
  rmdir /s /q logs
) else (
  echo "The logs directory does not exist."
)

