package com.calculator.example.calculator;

import java.util.List;

public interface ICalculatorService {
    public Number calculate(Operation operation, Number num1, Number num2);
    public Number calculateSequntial(Number intial, List<ChainElement> list);
}

