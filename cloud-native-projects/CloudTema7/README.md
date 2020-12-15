#DOCKER

1. Digite o comando "sudo apt install docker.io" para instalar o Docker. 

2. Construa as imagens nos diretórios e crie os containers: 

./gradlew bootBuildImage --imageName=integration
docker run --network=host --name integration -p 8080:8080 integration
./gradlew bootBuildImage --imageName=twitter
docker run --network=host --name twitter -p 8082:8082 twitter
./gradlew bootBuildImage --imageName=github
docker run --network=host --name github -p 8081:8081 github

#USO

Para obter o número de repositórios de um usuário no Github, basta acessar a URL:
http://localhost:8081/count/NOMEDOUSUAARIO


Para obter o número de tweets de um usuário do Twitter, basta acessar a URL:
http://localhost:8082/count/NOMEDOUSUAARIO

Para obter as duas informações concomitantemente:
http://localhost:8080/twitter/NOMEDOUSUAARIO/github/NOMEDOUSUAARIO

#FINALIZAÇÃO

Para finalizar e realizar a exclusão do container criado, digite os comandos:

docker stop integration
docker stop twitter
docker stop github
docker rm integration
docker rm twitter
docker rm github

