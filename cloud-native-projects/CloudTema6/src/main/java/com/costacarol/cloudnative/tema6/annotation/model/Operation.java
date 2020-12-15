package com.costacarol.cloudnative.tema6.annotation.model;

public class Operation {

    private double value1;
    private double value2;
    private double resultValue;
    private OperationType operationType;

    public Operation(double value1, double value2, double resultValue, OperationType operationType) {
        this.value1 = value1;
        this.value2 = value2;
        this.resultValue = resultValue;
        this.operationType = operationType;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public double getResultValue() {
        return resultValue;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public String toString() {
        return "Operation: " + getValue1() + " " + getOperationType().getOperationSymbol() + " " + getValue2() + " = " + getResultValue() + "\n";
    }
}
