import urllib.parse

payload = '&'
payload = payload.replace(' ', '$IFS')
encoded_payload = urllib.parse.quote(payload)
encoded_payload = encoded_payload.replace('%24', '$')
print(encoded_payload)
