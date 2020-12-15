1. Para consultar os valores do pedágio, digite a url http://localhost:8080/temacloud5/toll/list-prices .

2. Para realizar um novo pagamento, digite: http://localhost:8080/temacloud5/toll/pay/{value}/{vehicle}/{axle}, sendo: {value} o valor recebido; {vehicle} o tipo do veículo; e {axle} a quantidade eixos (veículos normais, padrão é 1, e para caminhões, terá o adicional por eixo).

As opções de veículos são: 
beetle (se o veículo for um fusca); bike (se o veículo for uma bicicleta); bus (se o veículo for um ônibus); motorcycle (se o veículo for uma moto); e truck (se o veículo for um caminhão).
