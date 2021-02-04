package com.costacarol.cloudnative.tema8.annotation.model;

public enum OperationType {
    DIVISION("/"),
    MULTIPLY("*"),
    POW("^"),
    SUB("-"),
    SUM("+");

    private String operationSymbol;

    OperationType(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }
}
