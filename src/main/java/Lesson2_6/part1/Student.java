package Lesson2_6.part1;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    private String name;
    private int group;
    private int course;
    private ArrayList<Integer> grades;

    public double calculateAverageGrade() {
        double sum = 0.0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public static void removeStudents(List<Student> students) {
        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).calculateAverageGrade() < 3.0) {
                students.remove(i);
            }
        }
    }

    public void toNextCourse() {
        if (calculateAverageGrade() >= 3.0) {
            course++;
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        for (Student student: students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}