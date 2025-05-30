package Lesson2_4.part_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");

        dog1.run(150);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(100);
        cat1.run(250);
        cat1.swim(10);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        Bowl bowl = new Bowl(30);
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Том"));
        cats.add(new Cat("Гарфилд"));
        cats.add(new Cat("Чешир"));
        cats.add(new Cat("Леопольд"));

        System.out.println("В миске " + bowl.getFoodAmount() + " еды.");

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        System.out.println("Состояние котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isHungry() ? "голоден" : "сыт"));
        }

        bowl.addFood(20);
        for (Cat cat : cats) {
            if (cat.isHungry()) {
                cat.eat(bowl, 10);
            }
        }

        System.out.println("Финальное состояние котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isHungry() ? "голоден" : "сыт"));
        }
        System.out.println("В миске осталось " + bowl.getFoodAmount() + " еды.");
    }
}