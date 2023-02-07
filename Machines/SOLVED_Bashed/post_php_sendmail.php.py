import requests

TARGET = 'http://bashed.htb/php/sendMail.php'

data = {
    'action': 'SendMessage',
    'name': 'abc',
    'email': 'wyd93329@nezid.com',
    'subject': 'test email',
    'message': 'test body'
}

data = {
    'action': 'UploadFile',
    'name': 'abc',
    'email': 'wyd93329@nezid.com',
    'subject': 'test email',
    'message': 'test body'
}
r = requests.post(TARGET, data=data)
print('Response:')
print('Code: ' + str(r.status_code))
print(r.headers)
print(r.text)
