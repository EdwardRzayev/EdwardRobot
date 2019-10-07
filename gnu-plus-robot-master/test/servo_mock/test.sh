printf "getting servo 0\n"
curl -d {\"servo_id\":\"0\"} -H "Content-Type: application/json" -X POST "http://localhost:9000/servo/get"

printf "\nsetting servo 0 angle 1337\n"
curl -d {\"servo_id\":\"0\"\,\"angle\":\"1337\"} -H "Content-Type: application/json" -X POST "http://localhost:9000/servo/set"

printf "\ngetting servo 0\n"
curl -d {\"servo_id\":\"0\"} -H "Content-Type: application/json" -X POST "http://localhost:9000/servo/get"

printf "\ngetting servo list\n"
curl -d {} -H "Content-Type: application/json" -X POST "http://localhost:9000/servo/list"

