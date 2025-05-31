# Test the API primes server deployed to Cloud Run

test_get() {
  echo
  echo "GET $1"
  GET_CMD="curl https://amgprimesapi-452448898061.us-west1.run.app$1"
  echo $GET_CMD
  $GET_CMD
  echo
}

echo "Primes API server command line tests start"

test_get /api/v1/primes/count/100
test_get /api/v1/primes/list/25

echo
echo "Primes API server command line tests end"
