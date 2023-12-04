package com.example.lv6z1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalkulatorTest {

    @Test
    public void testAddition() {
        Kalkulator calculator = new Kalkulator();
        calculator.addNumericButtonAction(calculator.createButton("2"));
        calculator.performOperation("+");
        calculator.addNumericButtonAction(calculator.createButton("3"));
        calculator.calculateResult();
        assertEquals("5.0", calculator.getInput().toString());
    }

    @Test
    public void testSubtraction() {
        Kalkulator calculator = new Kalkulator();
        calculator.addNumericButtonAction(calculator.createButton("5"));
        calculator.performOperation("-");
        calculator.addNumericButtonAction(calculator.createButton("2"));
        calculator.calculateResult();
        assertEquals("3.0", calculator.getInput().toString());
    }

    @Test
    public void testErrorHandling() {
        Kalkulator calculator = new Kalkulator();
        calculator.addNumericButtonAction(calculator.createButton("5"));
        calculator.performOperation("/");
        calculator.addNumericButtonAction(calculator.createButton("0"));
        calculator.calculateResult();
        assertEquals("Error", calculator.getInput().toString());
    }
}