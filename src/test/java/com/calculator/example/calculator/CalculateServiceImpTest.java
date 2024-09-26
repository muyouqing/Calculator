package com.calculator.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceImpTest {
    private CalculateServiceImp calculateServiceImp;
    @BeforeEach
     public void setUp(){
             calculateServiceImp = new CalculateServiceImp();
    }

    //basic test cases
@Test
public void testAddition() {
    assertEquals(8.0, calculateServiceImp.calculate(Operation.ADD, 5, 3),
            "Addition failed: expected 5 + 3 = 8");
}

    @Test
    public void testSubtraction() {
        assertEquals(2.0, calculateServiceImp.calculate(Operation.SUBTRACT, 5, 3),
                "Subtraction failed: expected 5 - 3 = 2");
    }

    @Test
    public void testMultiplication() {
        assertEquals(15.0, calculateServiceImp.calculate(Operation.MULTIPLY, 5, 3),
                "Multiplication failed: expected 5 * 3 = 15");
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculateServiceImp.calculate(Operation.DIVIDE, 6, 3),
                "Division failed: expected 6 / 3 = 2");
    }
    @Test
    public void testNewOperation(){
        assertEquals(1.0,calculateServiceImp.calculate(Operation.MOD,3,2),
                "Mod failed: expected 3 % 2 = 1");
    }
    //edge test cases
    @Test
    public void testNullOperation(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            calculateServiceImp.calculate(null,5,2);
        });
        assertEquals("invalid Operation",exception.getMessage(),
                "Null operation should throw IllegalArgumentException with 'invalid Operation'");
    }
    @Test
    public void testNullNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        calculateServiceImp.calculate(Operation.MULTIPLY, null, 3);
    });
        assertEquals("invalid Number", exception.getMessage(),
                "Null first input should throw IllegalArgumentException with 'invalid Number'");

        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateServiceImp.calculate(Operation.MULTIPLY, 3, null);
        });
        assertEquals("invalid Number", exception.getMessage(),
                "Null second input should throw IllegalArgumentException with 'invalid Number'");


    }
    @Test
    public void testDivideZero(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateServiceImp.calculate(Operation.DIVIDE, 3, 0);
        });
        assertEquals("divisor cannot be zero", exception.getMessage(),
                "Division by zero should throw IllegalArgumentException with 'divisor cannot be zero'");
    }
    @Test
    public void testUnsupportedOperation(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->{
            Operation.valueOf("SQUARE");
        });
        assertEquals("No enum constant com.calculator.example.calculator.Operation.SQUARE",exception.getMessage(),
                "Unsupported operation Should throw IllegalArgumentException with 'No enum constant com.calculator.example.calculator.Operation.SQUARE'");
    }
    // Chain Operations test cases
    @Test
    void calculateSequential() {
        List<ChainElement> list = new ArrayList<>();
        list.add(new ChainElement(Operation.ADD,4));
        list.add(new ChainElement(Operation.MULTIPLY,3));
        list.add(new ChainElement(Operation.DIVIDE,2));
        list.add(new ChainElement(Operation.SUBTRACT,1));
        //(2 + 4) * 3 / 2 - 1
        assertEquals(8.0,calculateServiceImp.calculateSequntial(2,list),
                "Chained operations failed: expected ((3 + 5) * 2) = 16");
    }
    @Test
    public void testChainedOperationsWithNullElement() {

        List<ChainElement> list = new ArrayList<>();
        list.add(new ChainElement(Operation.ADD, 5));
        list.add(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateServiceImp.calculateSequntial(3, list);
        });
        assertEquals("ChainElement cannot be null", exception.getMessage(),
                "Chained operation with null element should throw IllegalArgumentException with 'ChainElement cannot be null'");
    }

}