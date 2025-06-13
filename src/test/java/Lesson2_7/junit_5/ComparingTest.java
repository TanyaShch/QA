package Lesson2_7.junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparingTest {

    Comparing comparing = new Comparing();

    @Test
    void comparingFirstNumberGreater() {
        String result = comparing.comparingTwoNumbers(7, 4);
        Assertions.assertEquals("7 больше, чем 4", result);
    }

    @Test
    void comparingSecondNumberGreater() {
        String result = comparing.comparingTwoNumbers(5, 17);
        Assertions.assertEquals("17 больше, чем 5", result);
    }

    @Test
    void comparingNumbersEqual() {
        String result = comparing.comparingTwoNumbers(25, 25);
        Assertions.assertEquals("Числа равны", result);
    }

    @Test
    void comparingNegativeNumbers() {
        String result = comparing.comparingTwoNumbers(-2, -9);
        Assertions.assertEquals("-2 больше, чем -9", result);
    }

    @Test
    void comparingZeroAndNumber() {
        String result = comparing.comparingTwoNumbers(0, 17);
        Assertions.assertEquals("17 больше, чем 0", result);
    }

    @Test
    void comparingZeroAndNegativeNumber() {
        String result = comparing.comparingTwoNumbers(0, -17);
        Assertions.assertEquals("0 больше, чем -17", result);
    }
}