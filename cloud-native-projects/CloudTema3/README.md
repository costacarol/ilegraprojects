1. No terminal, digite o comando "./gradle clean build" para gerar um arquivo war na pasta build/libs da sua IDE. 

2. Acesse a página https://tomcat.apache.org/download-90.cgi e faça o download do TomCat.

3. Após a instalação, dê o start através do comando "bin/catalina.sh start" no diretório onde está localizado o tomcat. 

4. Copie o arquivo gerado no passo 1 e cole na pasta webapps do tomcat.

5. Acessar a url http://localhost:8080/Calculator/calculate?n1=A?n2=B&op=C , sendo: A refere-se ao primeiro número da equação, e B o segundo e C o nome da operação, podendo ser sum, sub, div, mult ou pow.

6. Para parar a execução do tomcat, digite o comando "bin/catalina.sh stop" no terminal.
