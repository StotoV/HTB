# LoveTok

## Website
Query params:
/?format=r

## Query params
PHP includes var `$time` in index template.
`eval` with format query


## Gobuster
```
$ gobuster dir -k -w /opt/wordlists/common.txt -u http://178.128.173.79:31987
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://178.128.173.79:31987
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/common.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/09/29 11:21:08 Starting gobuster in directory enumeration mode
===============================================================
/assets               (Status: 301) [Size: 178] [--> http://178.128.173.79/assets/]
/static               (Status: 301) [Size: 178] [--> http://178.128.173.79/static/]
/views                (Status: 301) [Size: 178] [--> http://178.128.173.79/views/]

===============================================================
2022/09/29 11:21:12 Finished
===============================================================
```
