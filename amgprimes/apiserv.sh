# Start the Primes API server locally
echo "Primes API server starting"
echo
SRV_CMD="java -jar amgprimesapi/target/amgprimesapi-1.0-SNAPSHOT.jar"
echo $SRV_CMD
$SRV_CMD
