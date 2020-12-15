package com.costacarol.cloudnative.tema6.annotation.command;

import org.springframework.stereotype.Component;

@Component
public class Sum implements Operations {


    @Override
    public double executeOperation(double value1, double value2) {
        return value1 + value2;
    }
}
