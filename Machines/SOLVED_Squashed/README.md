# Squashed

## Enumeration
SSH: OpenSSH 8.2p1 Ubuntu 4ubuntu0.5
HTTP: Apache httpd 2.4.41
RPC: rpcbind 2-4

### NFS
Users: ross

Upload shell as user with id 2017 in /var/www/html

## Pwn
$ cat /home/alex/user.txt
b88677035c1e1e80d573eb0505e37743

Steal cookie from /home/ross/.Xauthority and paste in /home/alex/.Xauthority (via nfs share)

alex $ xwd -root -out screenshot.xwd -display :0
alex $ su root
Password: cah$mei7rai9A

root $ cat /root/root.txt
6c6fc1d308debd1e68d1460a0f157cda
