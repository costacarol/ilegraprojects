#!/bin/bash

echo "github= $(curl -s http://localhost:8081/count/costacarol)"
echo "twitter= $(curl -s http://localhost:8082/count/carolin75885385)"
echo "integration= $(curl -s http://localhost:8080/api/twitter/carolin75885385/github/costacarol)"

#echo "Hystrix.stream: $(curl -s http://localhost:8080/metrics/hystrix.stream)"

