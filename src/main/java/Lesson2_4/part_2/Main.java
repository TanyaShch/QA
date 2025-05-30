package Lesson2_4.part_2;

public class Main {
    public static void main(String[] args) {
        Circle circle = Circle.builder()
                .radius(5.0)
                .fullColor("Синий")
                .borderColor("Красный")
                .build();
        Rectangle rectangle = Rectangle.builder()
                .width(10)
                .height(7)
                .fullColor("Белый")
                .borderColor("Желтый")
                .build();
        Triangle triangle = Triangle.builder()
                .sideA(7)
                .sideB(6)
                .sideC(5)
                .fullColor("Зеленый")
                .borderColor("Оранжевый")
                .build();

        printShapeInfo(circle, "Круг");
        printShapeInfo(rectangle, "Прямоугольник");
        printShapeInfo(triangle, "Треугольник");
    }

    // Метод для вывода информации о фигуре
    private static void printShapeInfo(Shape shape, String shapeName) {
        System.out.println("***** " + shapeName + " *****");
        System.out.println("Периметр: " + shape.countPerimetr());
        System.out.println("Площадь: " + shape.countArea());
        System.out.println("Цвет заливки: " + shape.getFullColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }
}
