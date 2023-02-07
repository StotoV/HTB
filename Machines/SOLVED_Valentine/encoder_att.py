import requests

TARGET = 'http://10.10.10.79'

data = { 'text': 'a'*200 }
r = requests.post(TARGET + '/encode/encode.php', data=data)
print(r.status_code)
print(r.text)
