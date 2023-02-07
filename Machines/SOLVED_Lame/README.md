# Lame
March 15, 2017

## Enumeration
### Nmap
FTP: vsftpd 2.3.4
SSH: OpenSSH 4.7p1
Samba: Samba 3.0.20-Debian

### FTP
Anonymous login
No files

### SMB
```bash
$ smbclient -L \\test.local -I 10.10.10.3 -N
Anonymous login successful

        Sharename       Type      Comment
        ---------       ----      -------
        print$          Disk      Printer Drivers
        tmp             Disk      oh noes!
        opt             Disk      
        IPC$            IPC       IPC Service (lame server (Samba 3.0.20-Debian))
        ADMIN$          IPC       IPC Service (lame server (Samba 3.0.20-Debian))
Reconnecting with SMB1 for workgroup listing.
Anonymous login successful

        Server               Comment
        ---------            -------

        Workgroup            Master
        ---------            -------
        WORKGROUP            LAME
```

## Foothold

## Pwn
CVE-2007-2447
See smb/exploit/CVE-2007-2447

root $ cat /root/root.txt
ef3fed2d3488aca92b23f562a9fa3bed

root $ cat /home/makis/user.txt
6dd5c26d9ba5b68865af63a356434e7a
