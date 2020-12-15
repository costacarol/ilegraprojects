package com.costacarol.cloudnative.tema5.app;

import com.costacarol.cloudnative.tema5.controller.TollController;
import com.costacarol.cloudnative.tema5.service.TollService;
import com.costacarol.cloudnative.tema5.vehicles.*;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf(){
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer(){
        final JAXRSServerFactoryBean factoryBean = RuntimeDelegate.getInstance().createEndpoint(tollController(),JAXRSServerFactoryBean.class);
        factoryBean.setServiceBeans(Arrays.asList(tollController()));
        factoryBean.setProviders(Arrays.asList(jsonProvider()));
        return factoryBean.create();
    }

    @Bean
    public TollService tollService() {
        return new TollService();
    }

    @Bean
    public JacksonJsonProvider jsonProvider(){
        return new JacksonJsonProvider();
    }

    @Bean
    public TollController tollController(){
        return new TollController();
    }

    @Bean (name = "bus")
    public Bus bus(){
        return new Bus();
    }

    @Bean (name = "motorcycle")
    public Motorcycle motorcycle(){
        return new Motorcycle();
    }

    @Bean (name = "bike")
    public Bike bike(){
        return new Bike();
    }

    @Bean (name = "truck")
    public Truck truck(){
        return new Truck();
    }

    @Bean (name = "beetle")
    public Beetle beetle(){
        return new Beetle();
    }
}
