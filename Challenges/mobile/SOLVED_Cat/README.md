# Cat

## File
```
$ file cat.ab
$ cat.ab: Android Backup, version 5, Compressed, Not-Encrypted
```

## Extract backup
Java .ab to tar conversion program
https://github.com/nelenkov/android-backup-extractor/releases/tag/master-20220909063044-8fdfc5e

```
$ java -jar ./tools/abe.jar unpack cat.ab cat.tar
```
```
$ tar -xf cat.tar -C ./cat/
```

## Inspect data
See `/shares/0/Pictures/IMAG0004.jpg`

## Flag
HTB{ThisBackupIsUnprotected}
