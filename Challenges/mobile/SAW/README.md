# SAW

## jadx
```
$ jadx saw.apk
```

## Install 
```
$ adb install saw.apk
```

Won't run, though correct API & Android version are used

## Code analysis
MainActivity.java
```
30: Bundle extras = getIntent().getExtras();
```
Retrieves some kind of stored data? Determines whether to launch the app or not?

`f()` is executed on button click, button is added when stored data is loaded successfully.

`alert()` is executed on button click, button is added in `f()`.

`alert()` has option to enter text. `a()` is executed with `FILE_PATH_PREFIX` and entered text.

`a()` does not seem to have an implementation? Native funciton references a function written in another language it seems.

.so files are available in resources/lib, possible reference to these files?

## .SO files
libdefault.so
contains `a` function. Something with XOR operations takes place in this lib.

## Settings
Allow display over other apps via settings

## ADB
Start app via ADB
```
$ adb shell am start -n com.stego.saw/.MainActivity -a android.intent.action.MAIN -c android.intent.category.LAUNCHER --es open "sesame"
```
We can now enter some text that will be send to `a` in the default lib

## default.so

