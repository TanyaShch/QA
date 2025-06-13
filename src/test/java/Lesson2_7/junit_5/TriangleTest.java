package Lesson2_7.junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    Triangle triangle = new Triangle();

    @Test
    void trianglePositiv() {
        double result = triangle.triangleArea(4, 10);
        Assertions.assertEquals(20, result);
    }

    @Test
    void triangleBaseZero() {
        double result = triangle.triangleArea(0, 10);
        Assertions.assertEquals(0, result);
    }

    @Test
    void triangleHeigthZero() {
        double result = triangle.triangleArea(4, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    void triangleBaseAndHeigthOne() {
        double result = triangle.triangleArea(1, 1);
        Assertions.assertEquals(0.5, result);
    }
}
