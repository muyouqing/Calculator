package com.calculator.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CalculateServiceImp implements ICalculatorService{

    @Override
    public Number calculate(Operation operation, Number num1, Number num2) {
        //corner case
        if(operation == null){
            throw new IllegalArgumentException("invalid Operation");
        }
        if(num1 == null || num2 == null){
            throw new IllegalArgumentException("invalid Number");
        }
        //convert to double
        Double number1 = num1.doubleValue();
        Double number2 = num2.doubleValue();
        switch (operation){
            case MOD : return (Number)(number1 % number2);
            case ADD : return (Number)(number1 + number2);
            case SUBTRACT: return (Number)(number1 - number2);
            case MULTIPLY: return (Number)(number1 * number2);
            case DIVIDE:
                if(Double.compare(number2,0.0) == 0) throw new IllegalArgumentException("divisor cannot be zero");
                return (Number)(number1 / number2);
            default: throw new UnsupportedOperationException("operation not support");
        }
    }

    @Override
    public Number calculateSequntial(Number initial, List<ChainElement> list) {
        //corner case
        if(initial == null || list == null || list.size() == 0){
            throw new IllegalArgumentException("invalid input");
        }
        Number res = initial;
        for(ChainElement e : list){
            if(e == null) throw new IllegalArgumentException("ChainElement cannot be null");
            res = calculate(e.getOp(),res,e.getNum());
        }
        return res;
    }
}
