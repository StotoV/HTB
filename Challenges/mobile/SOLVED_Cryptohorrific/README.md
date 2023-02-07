# Cryptohorrific

## challenge.plist
Convert to XML
```
$ plistutil -i challenge.plist -o challenge.plist.out -f xml
```

Flag encoded:
```
Tq+CWzQS0wYzs2rJ+GNrPLP6qekDbwze6fIeRRwBK2WXHOhba7WR2OGNUFKoAvyW7njTCMlQzlwIRdJvaP2iYQ==
```

Base64; gibberish output though
```
$ echo 'Tq+CWzQS0wYzs2rJ+GNrPLP6qekDbwze6fIeRRwBK2WXHOhba7WR2OGNUFKoAvyW7njTCMlQzlwIRdJvaP2iYQ==' | base64 -d
N[4�3j�ck<�o
            ��E+e�k�PR���E�ha%
```

## hachthebox file
```
$ file hachthebox
hackthebox: Mach-O 64-bit x86_64 executable, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|PIE>
```

```
$ strings hackthebox
...
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>application-identifier</key>
	<string>Unknown.ben.hackthebox</string>
	<key>keychain-access-groups</key>
	<array>
		<string>Unknown.ben.hackthebox</string>
	</array>
</dict>
</plist>
...
```
