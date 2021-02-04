package com.costacarol.cloudnative.tema8.annotation;

import com.costacarol.cloudnative.tema8.annotation.model.OperationType;
import com.costacarol.cloudnative.tema8.annotation.service.CalculatorService;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private final String healthCheckUri;
    private final HealthCheckEndpoint healthCheckEndpoint;
    private final CalculatorService calculatorService;

    public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint, CalculatorService calculatorService) {
        this.healthCheckUri = healthCheckUri;
        this.healthCheckEndpoint = healthCheckEndpoint;
        this.calculatorService = calculatorService;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        if (request.getUri().startsWith(healthCheckUri)) {
            return healthCheckEndpoint.handle(request, response);
        } else if (request.getUri().startsWith("/calculator/")) {
            int prefixLength = "/calculator/calculate/".length();
            String completeUri = request.getPath().substring(prefixLength);
            if (completeUri.isEmpty()) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush("Error: to make a new calculate, you must replace the letters A, B and C with the parameters as you wish: localhost:8080/calculator/calculate/A/B/C <br> Where:<br>A is a first number of operation;<br>B is the name of operation (sum/sub/div/mult/pow);<br> And C is a second number of operation.");
            } else {
                String[] params = completeUri.split("/");
                Double n1 = Double.parseDouble(params[0]);
                Double n2 = Double.parseDouble(params[2]);
                String operation = params[1];
                response.setStatus(HttpResponseStatus.OK);
                switch (operation) {
                    case "sum":
                        response.writeStringAndFlush("{\"" + n1 + " " + OperationType.SUM.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.SUM, n1, n2) + "\"}");
                        break;
                    case "sub":
                        response.writeStringAndFlush("{\"" + n1 + " " + OperationType.SUB.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.SUB, n1, n2) + "\"}");
                        break;
                    case "div":
                        response.writeStringAndFlush("{\"" + n1 + " " + OperationType.DIVISION.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.DIVISION, n1, n2) + "\"}");
                        break;
                    case "mult":
                        response.writeStringAndFlush("{\"" + n1 + " " + OperationType.MULTIPLY.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.MULTIPLY, n1, n2) + "\"}");
                        break;
                    case "pow":
                        response.writeStringAndFlush("{\"<h2>" + n1 + " " + OperationType.POW.getOperationSymbol() + " " + n2 + " = " + calculatorService.execute(OperationType.POW, n1, n2) + "\"}");
                        break;
                    default:
                        response.setStatus(HttpResponseStatus.BAD_REQUEST);
                        response.writeStringAndFlush("{\"Insert a valid option! (sum/sub/div/mult/pow) \"}");
                        break;
                }
            }
        } else if (request.getUri().startsWith("/history")) {
            response.setStatus(HttpResponseStatus.OK);
            return response.writeStringAndFlush("History: " + calculatorService.getOperationsHistory());
        } else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
            response.writeStringAndFlush("{\"Insert a valid option! <b> (sum/sub/div/mult/pow)\"}");
        }
        return response.close();
    }
}
