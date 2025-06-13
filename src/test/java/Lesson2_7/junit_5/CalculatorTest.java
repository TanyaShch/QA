package Lesson2_7.junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    void plusTwoPositive() {
        int result = calculator.plus(1, 7);
        Assertions.assertEquals(8, result);
    }

    @Test
    void plusNegativeAndPositive() {
        int result = calculator.plus(-1, 7);
        Assertions.assertEquals(6, result);
    }

    @Test
    void plusTwoNegative() {
        int result = calculator.plus(-1, -7);
        Assertions.assertEquals(-8, result);
    }

    @Test
    void plusNullAndNumber() {
        int result = calculator.plus(0, 8);
        Assertions.assertEquals(8, result);
    }

    @Test
    void minusTwoPositive() {
        int result = calculator.minus(7, 2);
        Assertions.assertEquals(5, result);
    }

    @Test
    void minusNegativeAndPositive() {
        int result = calculator.minus(-1, 7);
        Assertions.assertEquals(-8, result);
    }

    @Test
    void minusTwoNegative() {
        int result = calculator.minus(-1, -7);
        Assertions.assertEquals(6, result);
    }

    @Test
    void minusNullAndNumber() {
        int result = calculator.minus(0, -8);
        Assertions.assertEquals(8, result);
    }

    @Test
    void multiplyTwoPositive() {
        int result = calculator.multiply(1, 7);
        Assertions.assertEquals(7, result);
    }

    @Test
    void multiplyNegativeAndPositive() {
        int result = calculator.multiply(-1, 7);
        Assertions.assertEquals(-7, result);
    }

    @Test
    void multiplyTwoNegative() {
        int result = calculator.multiply(-1, -7);
        Assertions.assertEquals(7, result);
    }

    @Test
    void multiplyNullAndNumber() {
        int result = calculator.multiply(0, 8);
        Assertions.assertEquals(0, result);
    }

    @Test
    void divideTwoPositive() {
        int result = calculator.divide(8, 2);
        Assertions.assertEquals(4, result);
    }

    @Test
    void divideNegativeAndPositive() {
        int result = calculator.divide(-9, 3);
        Assertions.assertEquals(-3, result);
    }

    @Test
    void divideTwoNegative() {
        int result = calculator.divide(-12, -4);
        Assertions.assertEquals(3, result);
    }

    @Test
    void divideNullAndNumber() {
        int result = calculator.divide(0, 8);
        Assertions.assertEquals(0, result);
    }

}