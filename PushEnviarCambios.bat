@echo off
git add .
git commit -m "Commit %date% - %time%"
git branch -M main
git push -u origin main