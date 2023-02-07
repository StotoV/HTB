# Don't overract

## Strings
```
$ strings app-release.apk | grep HTB 
$
```

## jadx
```
$ jadx app-release.apk
```

## Search for hack
```
DontOverreact/app-release/resources/assets/index.android.bundle|406 col 160| __d(function(g,r,i,a,m,e,d){Object.defineProperty(e,"__esModule",{value:!0}),e.myConfig=void 0;var t={importantData:"baNaNa".toLowerCase(),apiUrl:'https://www.hackthebox.eu/',debug:'SFRCezIzbTQxbl9jNDFtXzRuZF9kMG43XzB2MzIyMzRjN30='};e.myConfig=t},400,[]);
```

## Bse 64
```
$ echo 'SFRCezIzbTQxbl9jNDFtXzRuZF9kMG43XzB2MzIyMzRjN30=' | base64 -d
HTB{23m41n_c41m_4nd_d0n7_0v32234c7}%
```
