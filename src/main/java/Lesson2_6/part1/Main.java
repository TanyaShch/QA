package Lesson2_6.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static Lesson2_6.part1.Student.printStudents;
import static Lesson2_6.part1.Student.removeStudents;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Каткова Елизавета", 2457, 1, new ArrayList<>(Arrays.asList(5, 2, 3, 5, 7, 8))));
        students.add(new Student("Иванов Петр", 2457, 1, new ArrayList<>(Arrays.asList(2, 3, 2, 2, 4, 2))));
        students.add(new Student("Попов Андрей", 4578, 2, new ArrayList<>(Arrays.asList(4, 5, 7, 4, 5, 8))));
        students.add(new Student("Володин Василий", 4578, 2, new ArrayList<>(Arrays.asList(3, 2, 4, 5, 1, 1))));
        students.add(new Student("Павлов Инокентий", 6478, 3, new ArrayList<>(Arrays.asList(5, 3, 8, 8, 4, 4))));

        printStudents(students, 2);

        removeStudents(students);
        printStudents(students, 2);

        for (Student student : students) {
            student.toNextCourse();
        }
        printStudents(students, 4);
    }
}