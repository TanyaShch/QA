package Lesson2_7.junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    void factorialNumber() {
        long result = factorial.getFactorial(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    void factorialZero() {
        long result = factorial.getFactorial(0);
        Assertions.assertEquals(1, result);
    }

    @Test
    void factorialOne() {
        long result = factorial.getFactorial(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void factorialLargeNumber() {
        long result = factorial.getFactorial(10);
        Assertions.assertEquals(3628800, result);
    }
}
