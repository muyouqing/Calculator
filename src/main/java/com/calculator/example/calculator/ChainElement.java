package com.calculator.example.calculator;

public class ChainElement {
    private Operation op;
    private Number num;

    public ChainElement(Operation op, Number num) {
        this.op = op;
        this.num = num;
    }

    public Operation getOp() {
        return op;
    }

    public Number getNum() {
        return num;
    }

}
