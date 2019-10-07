import socketserver
from http.server import HTTPServer, BaseHTTPRequestHandler
from time import time
import json


class Servo:
    def __init__(self, angle=60, maxAngle=120, sid=0):
        self.angle = angle
        self.id = sid
        self.maxAngle = maxAngle

    def setAngle(self, angle):
        if int(angle) <= self.maxAngle:
            self.angle = angle
        else:
            self.angle = self.maxAngle
        return self.angle

    def getAngle(self):
        return self.angle

    def json(self):
        return self.__dict__

class ServoDB:
    def __init__(self, servos=[]):
        self.data = list(servos)

    def __getitem__(self, n):
        return self.data[n]


class ServoServer(BaseHTTPRequestHandler):
    def __init__(self, db, request, client_address, server):
        self.servos = db
        self.response_post = {
                    "/servo/set":     self.set_angle,
                    "/servo/get":     self.get_servo,
                    "/servo/list":    self.get_list
                }
        BaseHTTPRequestHandler.__init__(self, request, client_address, server)

    def set_angle(self, servo_id, angle):
        servo = self.servos[int(servo_id)]
        new_angle = servo.setAngle(angle)
        return {'angle': new_angle}

    def get_servo(self, servo_id):
        return {'servo': self.servos[int(servo_id)].json()}

    def get_list(self):
        response = dict()
        data = self.servos.data
        response['servos'] = [s.json() for s in self.servos.data]
        return response

    def _set_headers(self, code=200):
        self.send_response(code)
        self.send_header("Content-type", "application/json")
        self.end_headers()

    def do_GET(self):
        self._set_headers()

    def do_HEAD(self):
        self._set_headers()

    def do_POST(self):
        length = int(self.headers["Content-Length"])
        try:
            content = self.read_json(length)
        except json.JSONDecodeError as e:
            self.respond_error(400, str(e))
            return

        print(f"request: \"{self.path}\"")
        print(f"content:\n{content}\n")
        handle = self.response_post.get(self.path, None)
        if handle is None:
            self.respond_error(405, "Method not allowed")
            return
        try:
            self._set_headers(201)
            self.write_json(handle(**content))
        except Exception as e:
            self.respond_error(405, str(e))
            return

    def write_text(self, text):
        self.wfile.write(text.encode("utf-8"))

    def write_json(self, rjson):
        self.wfile.write(json.dumps(rjson).encode("utf-8"))

    def read_json(self, length):
        return json.loads(self.rfile.read(length).decode("utf-8"))

    def respond_error(self, code, msg):
        self._set_headers(code)
        self.write_json({"error": {
                            "status": code,
                            "message": msg
                            }
                        })


from functools import partial

def run(server_class, handler_class, addr, port):
    server_address = (addr, port)
    httpd = server_class(server_address, handler_class)
    print(f"Started httpd listening on {addr}:{port}")
    httpd.serve_forever()

if __name__ == "__main__":
    db = ServoDB([Servo(10*x, 120, x) for x in range(0, 10)])
    try:
        run(HTTPServer, partial(ServoServer, db), "0.0.0.0", 9000)
    except KeyboardInterrupt:
        print("\nInterrupted\n")

