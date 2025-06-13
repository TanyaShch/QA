package Lesson2_5;

public class Main {
    public static void main(String[] args) {
        String[][] array1 = {
                {"5", "7", "4", "5"},
                {"56", "1", "76", "76"},
                {"53", "7", "84", "21"},
                {"3", "4", "44", "27"}
        };
        String[][] array2 = {
                {"5", "7", "4"},
                {"56", "1", "76"},
                {"53", "84", "21"},
                {"3", "44", "27"}
        };
        String[][] array3 = {
                {"234", "545", "532", "104"},
                {"785", "210", "746", "576"},
                {"Java", "725", "844", "241"},
                {"356", "424", "444", "217"}
        };

        String[][][] allArrays = {array1, array2, array3};

        for (int i = 0; i < allArrays.length; i++) {
            try {
                System.out.println("Массив #" + (i+1));
                int sum = Array.sumArray(allArrays[i]);
                System.out.println("Сумма элементов: " + sum);
            } catch (MyArraySizeException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            System.out.println();
        }

        try {
            Array.generateArrayIndexOutOfBounds();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Результат выполнения: " + e.getMessage());
        }
    }
}
