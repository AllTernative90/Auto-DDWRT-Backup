Auto-DDWRT-Backup
=================

This program connects through http with your DD-WRT router using credentials you provide.
It will pull the config-backup of your router (nvrambak.bin) and save it locally on your harddisk.


How to use
----------------------------
1. download the sources
2. enter the URL, user credentials and settings in [ISettings.java] (https://github.com/AllTernative90/Auto-DDWRT-Backup/blob/master/Auto-DDWRT-Backup/src/classes/ISettings.java)
3. compile the program
4. run the program

The backup file will be pulled from your router and saved according to the path in ISettings.java.


Features to be added
----------------------------
I plan on adding these features:
-prompt to ask the user for password (for those who don't want to hardcode their passwords)
-check if file already exists
-handle file exists issues
-inform the user of a successful run or error


Dependencies
----------------------------
For encoding base64 I used the apache commons codec library, which I already included in the project.


Used resources
----------------------------
http://stackoverflow.com/questions/469695/decode-base64-data-in-java
http://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
