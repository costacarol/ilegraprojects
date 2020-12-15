package com.costacarol.cloudnative.tema3.annotation.app;

import com.costacarol.cloudnative.tema3.annotation.model.OperationType;
import com.costacarol.cloudnative.tema3.annotation.service.CalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        calculatorService.execute(OperationType.SUM, 2.0, 2.5);
        calculatorService.execute(OperationType.SUB, 2.0, 2.5);
        calculatorService.execute(OperationType.MULTIPLY, 2.0, 2.5);
        calculatorService.execute(OperationType.DIVISION, 2.0, 2.5);
        calculatorService.execute(OperationType.POW, 2.0, 2.5);
        try {
            calculatorService.execute(OperationType.SUM, calculatorService.getResultOfRealizedOperation(1), 2.5);
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Invalid parameter: insert a existent index to search the result.");
        }

        System.out.println(calculatorService.getOperationsHistory());
        applicationContext.close();
    }
}
