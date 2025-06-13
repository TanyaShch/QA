package Lesson2_7.junit_5;

public class Comparing {

    public String comparingTwoNumbers(int num1, int num2) {
        if (num1 > num2) {
            return (num1 + " больше, чем " + num2);
        } else if (num2 > num1) {
            return (num2 + " больше, чем " + num1);
        } else {
            return ("Числа равны");
        }
    }
}