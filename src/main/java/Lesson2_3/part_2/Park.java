package Lesson2_3.part_2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Park {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Atractions {
        private String name;
        private int cost;
        private int time;
    }
}
