CMD="docker images"
echo "$CMD"
$CMD
CMD="docker ps -a"
echo "$CMD"
$CMD
CMD="docker rm $(docker ps -a -q --filter ancestor=amgprimesapi:latest)"
echo "$CMD"
$CMD
CMD="docker rmi amgprimesapi:latest"
echo "$CMD"
$CMD
CMD="docker images"
echo "$CMD"
$CMD
CMD="docker ps -a"
echo "$CMD"
$CMD
