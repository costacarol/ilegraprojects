package com.costacarol.cloudnative.tema8.annotation;


import com.costacarol.cloudnative.tema8.annotation.service.CalculatorService;
import io.reactivex.netty.RxNetty;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HealthCheck healthCheck = (HealthCheck) applicationContext.getBean("healthCheck");
        RxNetty.createHttpServer(8080,
                new RxNettyHandler("/healthCheck",
                        new HealthCheckEndpoint(healthCheck),
                        (CalculatorService) applicationContext.getBean("calculatorService")))
                .startAndWait();
    }
}

