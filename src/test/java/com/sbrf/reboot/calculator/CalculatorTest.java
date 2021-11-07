package com.sbrf.reboot.calculator;

import com.sbrf.reboot.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(19, Calculator.getAddition(4, 15));
        assertEquals(-12, Calculator.getAddition(-20, 8));
        assertNotEquals(-12, Calculator.getAddition(-200, 8));
    }


    @Test
    void getSubtraction() {
        assertEquals(10, Calculator.getSubtraction(123, 113));
        assertEquals(-9, Calculator.getSubtraction(4, 13));
        assertNotEquals(-12, Calculator.getSubtraction(-200, 8));
    }

    @Test
    void getMultiplication() {
        assertEquals(10, Calculator.getMultiplication(2, 5));
        assertEquals(20, Calculator.getMultiplication(-2, -10));
        assertNotEquals(24, Calculator.getMultiplication(-3, 8));
    }

    @Test
    void getDivision() {
        assertEquals(3.75, Calculator.getDivision(7.5, 2));
        assertTrue(Double.isInfinite(Calculator.getDivision(3, 0)), "Divide by zero gives infinity as result");
        assertNotEquals(1, Calculator.getMultiplication(0, 5));
    }

    @Test // целочисленный результат деления a на b
    void getFloorDiv(){
        assertEquals(2, Calculator.getFloorDiv(7, 3));
        assertEquals(0, Calculator.getFloorDiv(1, 2));
        assertNotEquals(4.5, Calculator.getFloorDiv(9, 2));
    }

    @Test // квадрат числа
    void getSquare(){
        assertEquals(81, Calculator.getSquare(9));
        assertEquals(4, Calculator.getSquare(-2));
        assertNotEquals(-9, Calculator.getSquare(-3));
    }

    @Test // квадратный корень числа
    void getSqrt(){
        assertEquals(4, Calculator.getSqrt(16));
        assertEquals(81, Calculator.getSqrt(6561));
        assertNotEquals(-25, Calculator.getSqrt(-5));

    }
}
