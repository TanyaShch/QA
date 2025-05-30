package Lesson2_4.part_2;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    @Override
    public double countArea() {
        double s = countPerimetr() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double countPerimetr() {
        return sideA + sideB + sideC;
    }
}
