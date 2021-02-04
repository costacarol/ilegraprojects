1. No terminal, digite o comando "sudo apt install docker.io" para instalar o Docker. 

3.  Para criar uma imagem, digite o comando, no diretório da sua aplicação: docker image build -t calculator8 .

4. Após, vamos rodar a nossa alpicação digitando o comando: docker run --network=host --name calculator8 -p 8082:8082 calculator8

5. Acesse a url http://localhost:8082/calculator/calculate/A/B/C, sendo: A refere-se ao primeiro número da operação; B o nome da operação, podendo ser sum, sub, div, mult ou pow; e C o segundo número da operação.

6. Após a operação ser realizada, ela será incluída no histórico e para visualizá-lo, basta acessar a url http://localhost:8082/history .

7. Para finalizar e realizar a exclusão do container criado, digite os comandos:

docker stop calculator

docker rm calculator