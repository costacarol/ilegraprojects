package com.costacarol.cloudnative.tema4.annotation.command;

public class Division implements Operations {

    @Override
    public double executeOperation(double value1, double value2) {
        return Math.round((value1 / value2)*100)/100d;
    }

}
