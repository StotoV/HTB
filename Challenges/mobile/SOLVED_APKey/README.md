# APKey

## File
```
$ file APKey.apk
$ APKey.apk: Zip archive data, at least v2.0 to extract, compression method=deflate
```

## Jadx
```
$ jadx APKey.apk
```

## App password found
/APKey/sources/com/example/apkey/MainActivity.java:53
Username: admin
Hash: MD5
Password: a2a3d412e92d896134d9c9126d756f

Hashcat
```
$ hashcat -m 0 -a 3 passwd_hash.txt /opt/wordlists/rockyou.txt
```

## Install APK
```
$ adb install APKey.apk
```

## Missing zeros in hash
https://stackoverflow.com/questions/17236949/zeros-missing-from-md5-hash-in-java

## John
```
$ john --format=raw-md5 --wordlist=/opt/wordlists/rockyou.txt hashes.txt
```

No results

## Deobfuscate
g.a() -> 1UlBm2kHtZuVrSE6qY6HxWkwHyeaX92DabnRFlEGyLWod2bkwAxcoc85S94kFpV1

## Solution
Copy obfuscation lib to new project and print it; see `print_key` dir.

Key:
HTB{m0r3_0bfusc4t1on_w0uld_n0t_hurt}
