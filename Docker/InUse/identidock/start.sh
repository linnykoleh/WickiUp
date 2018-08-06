#!/bin/bash
set -e
if [ "$ENV" = 'DEV' ]; then
 echo "Running Development Server" # Запуск сервера для разработки
 exec python "identidock.py"
else
 echo "Running Production Server" # Запуск сервера для эксплуатации
 exec python "identidock.py"
fi