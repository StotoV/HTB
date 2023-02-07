import jwt
import time

print(jwt.encode({"username": "christine.wool", "iat": str(time.time()).split('.')[0]}, "123beany123", algorithm="HS256"))
