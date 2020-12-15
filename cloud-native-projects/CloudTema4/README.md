1. No terminal, digite o comando "./gradle clean build" para gerar um arquivo war na pasta build/libs da sua IDE. 

2. Acesse a página https://www.eclipse.org/jetty/download.html e faça o download da versão 9.4.33.v20201020.

3. Após a exportação do arquivo baixado, dê o start no terminal através do comando "java -jar start.jar" no diretório exportado do Jetty. 

4. Copie o arquivo gerado no passo 1 e cole na pasta webapps do Jetty.

5. Acesse a url http://localhost:8080/calculator/calculate?n1=A?n2=B&op=C , sendo: A refere-se ao primeiro número da equação, e B o segundo e C o nome da operação, podendo ser sum, sub, div, mult ou pow.

6. Após a operação ser realizada, ela será incluída no histórico e o mesmo será mostrado na tela, caso necessite dos valores calculados anteriomente.