package Lesson2_4.part_2;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Shape implements FigureCount {
    private String fullColor;
    private String borderColor;
}