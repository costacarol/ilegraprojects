package com.costacarol.cloudnative.tema8.annotation.service;

import com.costacarol.cloudnative.tema8.annotation.AppConfig;
import com.costacarol.cloudnative.tema8.annotation.model.OperationType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorServiceTest {

    @Autowired
    CalculatorService calculatorService;

    @Test
    public void testExecuteSub() {
        Assert.assertEquals(-0.5, calculatorService.execute(OperationType.SUB, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteSubWithNegativeNumbers() {
          Assert.assertEquals(0.5, calculatorService.execute(OperationType.SUB, -2.0, -2.5), 0.0 );
    }

    @Test
    public void testExecuteSum() {
        Assert.assertEquals(4.5, calculatorService.execute(OperationType.SUM, 2.0, 2.5), 0.0);
    }

    @Test
    public void testExecuteSumWithNegativeNumbers() {
         Assert.assertEquals(-4.5, calculatorService.execute(OperationType.SUM, -2.0, -2.5), 0.0 );
    }

    @Test
    public void testExecuteMultiply() {
         Assert.assertEquals(5.0, calculatorService.execute(OperationType.MULTIPLY, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteDivision() {
        Assert.assertEquals(0.8, calculatorService.execute(OperationType.DIVISION, 2.0, 2.5), 0.0 );
    }

    @Test
    public void testExecuteDivisionWithNotInterResult() {
         Assert.assertEquals(0.83, calculatorService.execute(OperationType.DIVISION, 5.0, 6.0), 0.0);
    }

    @Test
    public void testGetResultOfRealizedOperation() {
        calculatorService.execute(OperationType.SUM, 2.0, 5.0);
        Assert.assertEquals(3.5, calculatorService.execute(OperationType.DIVISION, calculatorService.getResultOfRealizedOperation(0), 2.0), 0.1 );
    }

    @Test
    public void testExecutePow() {
         Assert.assertEquals(4, calculatorService.execute(OperationType.POW, 2.0, 2.0), 0.0 );
    }

    @Test
    public void testExecutePowWithNotInter() {
         Assert.assertEquals(5.7, calculatorService.execute(OperationType.POW, 2.0, 2.5), 0.1 );
    }


    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetResultOfRealizedOperationWithInvalidIndex() {
        calculatorService.execute(OperationType.SUM, 2.0, 5.0);
        calculatorService.execute(OperationType.DIVISION, calculatorService.getResultOfRealizedOperation(25), 1.0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteDivisionWithZero() {
         calculatorService.execute(OperationType.DIVISION, 2.0, 0.0);
    }
}