
#USO

Para rodar o programa, digite no terminal:
/bin/bash run-all.sh

Para verificar se estao todos "ok", voce pode realizar um teste de fumaça digitando no terminal:
./smoke-test-all-microservices.sh


Para obter o número de repositórios de um usuário no Github, basta acessar a URL:
http://localhost:8081/count/NOMEDOUSUAARIO


Para obter o número de tweets de um usuário do Twitter, basta acessar a URL:
http://localhost:8082/count/NOMEDOUSUAARIO

Para obter as duas informações concomitantemente:
http://localhost:8080/twitter/NOMEDOUSUAARIO/github/NOMEDOUSUAARIO

#Hystrix

Para visualizar o Hystrix Dashboard, basta acessar a URL:
http://localhost:{PORTA}/hystrix

E interir o endereço:
http://localhost:{PORTA}/hystrix.stream


