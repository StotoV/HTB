# SeeTheSharpFlag

## Decompile
```
$ jadx com.companyname.seethesharpflag-x86.apk
```

## Install app
```
$ adb install com.companyname.seethesharpflag-x86.apk
```

## SeeTheSharpFlag dll
com.companyname.seethesharpflag-x86/resources/assemblies/SeeTheSharpFlag.dll
```
$ file com.companyname.seethesharpflag-x86/resources/assemblies/SeeTheSharpFlag.dll
com.companyname.seethesharpflag-x86/resources/assemblies/SeeTheSharpFlag.dll: Sony PlayStation Audio
```

File compressed:
XALZ in strings

Decompress:
```
$ python xamarin-decompress.py ../com.companyname.seethesharpflag-x86/resources/assemblies/SeeTheSharpFlag.dll
```

## ILSpy


Copy relevant code to new .cs project and retrieve key
