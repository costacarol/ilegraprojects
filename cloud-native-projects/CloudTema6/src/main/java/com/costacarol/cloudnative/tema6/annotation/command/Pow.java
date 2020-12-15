package com.costacarol.cloudnative.tema6.annotation.command;

import org.springframework.stereotype.Component;

@Component
public class Pow implements Operations {

    @Override
    public double executeOperation(double value1, double value2) {
        return Math.round(Math.pow(value1, value2)*100)/100d;
    }
}
