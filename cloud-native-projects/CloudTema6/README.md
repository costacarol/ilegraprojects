1. No terminal, digite o comando  "./gradle clean build"  para gerar um arquivo war na pasta build/libs da sua IDE. 

2. Após, digite o comando "sudo apt install docker.io" para instalar o Docker. 

3.  Para criar uma imagem, digite o comando, no diretório da sua aplicação: docker image build -t calculator .

4. Após, vamos rodar a nossa alpicação digitando o comando: docker run --network=host --name calculator -p 8080:8080 calculator

5. Acesse a url http://localhost:8080/calculator/calculate?n1=A&n2=B&op=C , sendo: A refere-se ao primeiro número da equação, e B o segundo e C o nome da operação, podendo ser sum, sub, div, mult ou pow.

6. Após a operação ser realizada, ela será incluída no histórico e o mesmo será mostrado na tela, caso necessite dos valores calculados anteriomente.

7. Para finalizar e realizar a exclusão do conteiner criado, digite os comandos:

docker stop calculator

docker rm calculator