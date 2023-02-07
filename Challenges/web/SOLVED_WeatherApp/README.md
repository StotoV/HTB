# Weather app

## Gobuster
```
$ gobuster dir -k -w /opt/wordlists/common.txt -u http://167.99.202.193:32695
===============================================================
Gobuster v3.1.0
by OJ Reeves (@TheColonial) & Christian Mehlmauer (@firefart)
===============================================================
[+] Url:                     http://167.99.202.193:32695
[+] Method:                  GET
[+] Threads:                 10
[+] Wordlist:                /opt/wordlists/common.txt
[+] Negative Status codes:   404
[+] User Agent:              gobuster/3.1.0
[+] Timeout:                 10s
===============================================================
2022/09/28 10:24:37 Starting gobuster in directory enumeration mode
===============================================================
/Login                (Status: 200) [Size: 1657]
/login                (Status: 200) [Size: 1657]
/register             (Status: 200) [Size: 1663]
/static               (Status: 301) [Size: 179] [--> /static/]

===============================================================
2022/09/28 10:24:41 Finished
===============================================================
```

## Login page
On submit with empty credentials
```
ReferenceError: re is not defined
    at router.post (/app/routes/index.js:52:2)
    at Layer.handle [as handle_request] (/app/node_modules/express/lib/router/layer.js:95:5)
    at next (/app/node_modules/express/lib/router/route.js:137:13)
    at Route.dispatch (/app/node_modules/express/lib/router/route.js:112:3)
    at Layer.handle [as handle_request] (/app/node_modules/express/lib/router/layer.js:95:5)
    at /app/node_modules/express/lib/router/index.js:281:22
    at Function.process_params (/app/node_modules/express/lib/router/index.js:335:12)
    at next (/app/node_modules/express/lib/router/index.js:275:10)
    at Function.handle (/app/node_modules/express/lib/router/index.js:174:3)
    at router (/app/node_modules/express/lib/router/index.js:47:12)
```

On submit with wrong credentials
```
{message: You are not admin}
```

Re is used for regular expressions. Perhaps multiple checks? 

express is used as API

## Register page
On submit 401 unauthorized

## Main page
Retrieves IP via external API
Uses IP to post to `/api/weather` 
`/api/weather` presumably makes a call to given API URL in the parameters

### Mock weather API
Using requestrepo to serve as Mock endpoint
Request made from backend:
```
GET http://o35xd798.requestrepo.com/data/2.5/weather?q=Arnhem,NL&units=metric&appid=10a62430af617a949055a46fa6dec32f
```

## Template literals in critical HTTP request

