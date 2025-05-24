# Test the API primes server locally

test_get() {
  echo
  echo "GET $1"
  GET_CMD="curl http://localhost:8080$1"
  echo $GET_CMD
  $GET_CMD
  echo
}

echo "Primes API server command line tests start"

test_get /api/v1/primes/count/100
test_get /api/v1/primes/list/25

echo
echo "Primes API server command line tests end"
