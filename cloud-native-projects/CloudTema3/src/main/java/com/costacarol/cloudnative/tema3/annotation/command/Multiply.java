package com.costacarol.cloudnative.tema3.annotation.command;

import org.springframework.stereotype.Component;

@Component
public class Multiply implements Operations {

    @Override
    public double executeOperation(double value1, double value2) {
        return value1 * value2;
    }
}
