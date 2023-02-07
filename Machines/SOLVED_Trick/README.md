Trick

# Enumeration
SSH: OpenSSH 7.9
SMTP: Postfix smtpd
DNS: ISC BIND 9.11.5-P4-5.1+deb10u7
HTTP: nginx 1.14.2

## DNS
http://preprod-payroll.trick.htb/login.php
http://root.trick.htb

## Web
Startbootstrap
Contact form (not activated)

### Preprod payroll
**Bad chars**: '\
    Output: Trying to get property 'num_rows' of non-object in /var/www/payroll/admin_class.php

> Probably MySQL

SQLi: admin'or'1'='1:admin'or'1'='1

Usernames:
Administrator
Enemigosss:SuperGucciRainbowCake
John C Smith

### Proprod marketing
See LFI

# LFI
```bash
$ ffuf -mc all -c -w /usr/share/seclists/Fuzzing/LFI/LFI-Jhaddix.txt -u http://preprod-marketing.trick.htb/index.php\?page\=FUZZ -fl 1 | tee logs/gobuster/marketinf/lfi
```
Users: michael

Found private key (/home/michael/.ssh/id_rsa)

$ cat /etc/fail2ban/jail.conf
...
port = 10000
banaction = iptables-multiport
banaction_allports = iptables-allports
...
[sshd]
port = ssh
