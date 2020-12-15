package com.costacarol.cloudnative.tema1.annotation.service;

import com.costacarol.cloudnative.tema1.annotation.app.AppConfig;
import com.costacarol.cloudnative.tema1.annotation.model.OperationType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorServiceTest {

    @Test
    public void testExecuteSub() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(-0.5, calculatorService.execute(OperationType.SUB, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteSubWithNegativeNumbers() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(0.5, calculatorService.execute(OperationType.SUB, -2.0, -2.5), 0.0 );
    }

    @Test
    public void testExecuteSum() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(4.5, calculatorService.execute(OperationType.SUM, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteSumWithNegativeNumbers() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(-4.5, calculatorService.execute(OperationType.SUM, -2.0, -2.5), 0.0 );
    }

    @Test
    public void testExecuteMultiply() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(5.0, calculatorService.execute(OperationType.MULTIPLY, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteDivision() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(0.8, calculatorService.execute(OperationType.DIVISION, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteDivisionWithNotInterResult() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(0.83, calculatorService.execute(OperationType.DIVISION, 5.0, 6.0), 0.0);
    }

    @Test
    public void testExecutePow() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(4, calculatorService.execute(OperationType.POW, 2.0, 2.0), 0.0 );
    }

    @Test
    public void testExecutePowWithNotInter() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        Assert.assertEquals(5.7, calculatorService.execute(OperationType.POW, 2.0, 2.5), 0.1 );
    }

    @Test
    public void getOperationsHistory() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        calculatorService.execute(OperationType.SUM, 2.0, 5.0);
        Assert.assertEquals(1, calculatorService.getOperationsHistory().size());
    }

    @Test
    public void getResultOfRealizedOperation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        calculatorService.execute(OperationType.SUM, 2.0, 5.0);
        Assert.assertEquals(3.5, calculatorService.execute(OperationType.DIVISION, calculatorService.getResultOfRealizedOperation(0), 2.0), 0.0 );
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getResultOfRealizedOperationWithInvalidIndex() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        calculatorService.execute(OperationType.SUM, 2.0, 5.0);
        calculatorService.execute(OperationType.DIVISION, calculatorService.getResultOfRealizedOperation(5), 2.0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteDivisionWithZero() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorService calculatorService = (CalculatorService) applicationContext.getBean("calculatorService");
        calculatorService.execute(OperationType.DIVISION, 2.0, 0.0);
    }
}