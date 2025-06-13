package Lesson2_3.part_1;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Tess Lime", "02.03.2025", "Tess", "Россия", 250, true);
        productsArray[1] = new Product("Greenfield Green Melissa", "03.05.2025", "Greenfield", "Китай, Россия", 355, true);
        productsArray[2] = new Product("Akbar", "21.12.2024", "Akbar", "Шри-Ланка", 270, false);
        productsArray[3] = new Product("Bernley", "31.04.2025", "Bernley", "Шри-Ланка", 230, true);
        productsArray[4] = new Product("Pure Green Tea", "05.07.2024", "Riston", "Шри-Ланка", 310, false);
       for (Product product : productsArray) {
           product.displayInformation();
       }
    }
}
