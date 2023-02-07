# Phonebook

## Credentials
Possible usernames:
Reese

## Endpoints
/search
/login

## Website
Login page of phonebook software
Version 9.8.2020

Bootstrap/css resides in encoded dir?
```
/964430b4cdd199af19b986eaf2193b21f32542d0/bootstrap/css/bootstrap.min.css
/964430b4cdd199af19b986eaf2193b21f32542d0/login.css
/964430b4cdd199af19b986eaf2193b21f32542d0/starter-template.css
```

Contains JQuery 3.5.1

## Custom script
```
const queryString = window.location.search;
if (queryString) {
  const urlParams = new URLSearchParams(queryString);
  const message = urlParams.get('message');
  if (message) {
    document.getElementById("message").innerHTML = message;
    document.getElementById("message").style.visibility = "visible";
    }
  }
```

?message= tag allowed. Possible XSS?

```
http://64.227.43.207:31071/login?message=%3Cscript%3Ealert(%27abc%27)%3C/script%3E
```

No result on alert

## SQL Injection
Username: *
Password: *

Use script to extract correct password

```
HTB{d1rectory_h4xx0r_is_k00l}
```

## Dir traversal
```
http://64.227.43.207:31071/964430b4cdd199af19b986eaf2193b21f32542d0/
```

## Gobuster
```
$ gobuster dir -k -w /opt/wordlists/common.txt -u http://64.227.43.207:31071
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://64.227.43.207:31071
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/common.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/09/27 20:54:13 Starting gobuster in directory enumeration mode
===============================================================
/login                (Status: 200) [Size: 2214]

===============================================================
2022/09/27 20:54:17 Finished
===============================================================
```

```
$ gobuster dir -k -w /opt/wordlists/big.txt -u http://64.227.43.207:31071
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://64.227.43.207:31071
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/big.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/09/27 20:54:33 Starting gobuster in directory enumeration mode
===============================================================
//                    (Status: 301) [Size: 36] [--> /]
/login                (Status: 200) [Size: 2214]

===============================================================
2022/09/27 20:54:40 Finished
===============================================================
```

```
$ gobuster dir -k -w /opt/wordlists/big.txt -u http://64.227.43.207:31071/964430b4cdd199af19b986eaf2193b21f32542d0/
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://64.227.43.207:31071/964430b4cdd199af19b986eaf2193b21f32542d0/
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/big.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/09/27 21:06:26 Starting gobuster in directory enumeration mode
===============================================================
//                    (Status: 200) [Size: 2586]

===============================================================
2022/09/27 21:06:33 Finished
===============================================================
```
