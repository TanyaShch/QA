import java.util.Arrays;

public class Lesson2_2 {
    public static void main(String[] args) {
        //Задание 1
        System.out.println("Задание 1");
        printThreeWords();
        System.out.println();

        //Задание 2
        System.out.println("Задание 2");
        checkSumSing(9, -8);
        System.out.println();

        //Задание 3
        System.out.println("Задание 3");
        printColor(101);
        System.out.println();

        //Задание 4
        System.out.println("Задание 4");
        compareNumbers(78, 54);
        System.out.println();

        //Задание 5
        System.out.println("Задание 5");
        System.out.println(isSumInRange10To20(11, 6));
        System.out.println();

        //Задание 6
        System.out.println("Задание 6");
        printIsPositiveNumber(15);
        System.out.println();

        //Задание 7
        System.out.println("Задание 7");
        System.out.println(isNegative(-4));
        System.out.println();

        //Задание 8
        System.out.println("Задание 8");
        printStringMultiple("Я сделала уже 8 заданий!", 8);
        System.out.println();

        //Задание 9
        System.out.println("Задание 9");
        System.out.println(isLeapYear(2025));
        System.out.println();

        //Задание 10
        System.out.println("Задание 10");
        int[] array = new int[]{1, 0, 1, 1, 1, 0};
        invertBinaryArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

        //Задание 11
        System.out.println("Задание 11");
        int[] array2 = generateArray();
        System.out.println(Arrays.toString(array2));
        System.out.println();

        //Задание 12
        System.out.println("Задание 12");
        int[] array3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleNumbersUnderNum(array3);
        System.out.println(Arrays.toString(array3));
        System.out.println();

        //Задание 13
        System.out.println("Задание 13");
        int num = 7;
        int[][] matrix = createDiagonalMatrix(num);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //Задание 14
        System.out.println("Задание 14");
        int[] array4 = createdFilledArray(4, 6);
        System.out.println(Arrays.toString(array4));
        System.out.println();
    }
    //Задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //Задание 2
    public static void checkSumSing(int a, int b) {
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    //Задание 3
    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    //Задание 4
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    //Задание 5
    public static boolean isSumInRange10To20(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }
    //Задание 6
    public static void printIsPositiveNumber(int num) {
        if (num >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }
    //Задание 7
    public static boolean isNegative(int num) {
        return num < 0;
    }
    //Задание 8
    public static void printStringMultiple(String text, int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(text);
        }
    }
    //Задание 9
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0);
    }
    //Задание 10
    public static void invertBinaryArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }
    //Задание 11
    public static int[] generateArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }
    //Задание 12
    public static int[] doubleNumbersUnderNum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }
    //Задание 13
    public static int[][] createDiagonalMatrix(int num) {
        int[][] matrix = new int[num][num];
        for (int i = 0; i < num; i++) {
            matrix[i][i] = 1;
            matrix[i][num - 1 - i] = 1;
        }
        return matrix;
    }
    //Задание 14
    public static int[] createdFilledArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
