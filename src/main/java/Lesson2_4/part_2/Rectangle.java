package Lesson2_4.part_2;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Rectangle extends Shape {
    private double width;
    private double height;

    @Override
    public double countArea() {
        return 2 * (width + height);
    }

    @Override
    public double countPerimetr() {
        return width * height;
    }
}