# Photobomb

User: command injection in /printer file extension on POST
Root: No absolute path on `cd` and `find` commands. Create these and map to /bin/bash, prepend path and it will execute as root.

## Web enumeration
Ruby Sintra

### GET /
Something with a printer?

JS
```javascript
function init() {
  // Jameson: pre-populate creds for tech support as they keep forgetting them and emailing me
  if (document.cookie.match(/^(.*;)?\s*isPhotoBombTechSupport\s*=\s*[^;]+(.*)?$/)) {
    document.getElementsByClassName('creds')[0].setAttribute('href','http://pH0t0:b0Mb!@photobomb.htb/printer');
  }
}
window.onload = init;
```

Login on `/printer`

Username: pHoto
Password: b0Mb!

### GET /printer
Lots of `304` codes on images
Transfer encoding chunked

### POST /printer

### GET /ui_images
Sinatra doesn’t know this ditty.
Try this:

get '/ui_images' do
  "Hello World"
end

Gets 404 image from `:4567`


## Nmap

```
$ nmap -A 10.10.11.182                                                            
Starting Nmap 7.92 ( https://nmap.org ) at 2022-10-17 10:22 EDT
Nmap scan report for 10.10.11.182
Host is up (0.054s latency).
Not shown: 998 closed tcp ports (conn-refused)
PORT   STATE SERVICE VERSION
22/tcp open  ssh     OpenSSH 8.2p1 Ubuntu 4ubuntu0.5 (Ubuntu Linux; protocol 2.0)
| ssh-hostkey: 
|   3072 e2:24:73:bb:fb:df:5c:b5:20:b6:68:76:74:8a:b5:8d (RSA)
|   256 04:e3:ac:6e:18:4e:1b:7e:ff:ac:4f:e3:9d:d2:1b:ae (ECDSA)
|_  256 20:e0:5d:8c:ba:71:f0:8c:3a:18:19:f2:40:11:d2:9e (ED25519)
80/tcp open  http    nginx 1.18.0 (Ubuntu)
|_http-title: Did not follow redirect to http://photobomb.htb/
|_http-server-header: nginx/1.18.0 (Ubuntu)
Service Info: OS: Linux; CPE: cpe:/o:linux:linux_kernel

Service detection performed. Please report any incorrect results at https://nmap.org/submit/ .
Nmap done: 1 IP address (1 host up) scanned in 96.25 seconds
```

## Gobuster pages

## Gobuster subdomains
dirb/big.txt - No results
