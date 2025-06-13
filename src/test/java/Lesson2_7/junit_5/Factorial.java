package Lesson2_7.junit_5;

public class Factorial {

    public long getFactorial(int n) {
        long factorial = 1;
        for (long i = 1; i <= n; i++) {
            factorial *= i;
        }
        return  factorial;
    }
}