package com.costacarol.cloudnative.tema1.annotation.command;

import org.springframework.stereotype.Component;

@Component
public interface Operations {

    double executeOperation(double value1, double value2);
}
