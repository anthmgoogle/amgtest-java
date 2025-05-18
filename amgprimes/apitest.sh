# Test the API primes server locally
echo on
echo GET /api/v1/primes/count/100
echo curl http://localhost:8080/api/v1/primes/count/100
curl http://localhost:8080/api/v1/primes/count/100
echo
echo GET /api/v1/primes/list/25
echo curl http://localhost:8080/api/v1/primes/list/25
curl http://localhost:8080/api/v1/primes/list/25
echo
