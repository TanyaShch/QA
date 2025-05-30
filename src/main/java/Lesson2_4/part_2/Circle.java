package Lesson2_4.part_2;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter

public class Circle extends Shape {
    private double radius;

    @Override
    public double countArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double countPerimetr() {
        return 2 * Math.PI * radius;
    }
}
