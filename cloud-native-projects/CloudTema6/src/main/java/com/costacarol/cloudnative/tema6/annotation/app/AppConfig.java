package com.costacarol.cloudnative.tema6.annotation.app;

import com.costacarol.cloudnative.tema6.annotation.command.Division;
import com.costacarol.cloudnative.tema6.annotation.command.Operations;
import com.costacarol.cloudnative.tema6.annotation.command.Sub;
import com.costacarol.cloudnative.tema6.annotation.command.Sum;
import com.costacarol.cloudnative.tema6.annotation.command.Pow;
import com.costacarol.cloudnative.tema6.annotation.command.Multiply;
import com.costacarol.cloudnative.tema6.annotation.service.CalculatorService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.costacarol.cloudnative.tema4.annotation")
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
