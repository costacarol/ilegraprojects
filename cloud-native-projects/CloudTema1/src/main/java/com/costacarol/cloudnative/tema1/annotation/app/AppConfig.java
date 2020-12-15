package com.costacarol.cloudnative.tema1.annotation.app;

import com.costacarol.cloudnative.tema1.annotation.command.*;
import com.costacarol.cloudnative.tema1.annotation.service.CalculatorService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.costacarol.cloudnative.tema1.annotation")
public class AppConfig {

    @Bean
    public CalculatorService calculatorService(){
        return new CalculatorService();
    }

    @Bean (name = "SUB")
    @Scope("prototype")
    public Operations sub(){
        return new Sub();
    }

    @Bean (name = "SUM")
    @Scope("prototype")
    public Operations sum(){
        return new Sum();
    }

    @Bean (name = "DIVISION")
    @Scope("prototype")
    public Operations division(){
        return new Division();
    }

    @Bean (name = "MULTIPLY")
    @Scope("prototype")
    public Operations multiply(){
        return new Multiply();
    }

    @Bean (name = "POW")
    @Scope("prototype")
    public Operations pow(){
        return new Pow();
    }
}
