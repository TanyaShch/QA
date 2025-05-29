package Lesson2_3.part_1;

class Product {
    private String name;
    private String dateProduction;
    private String producer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;
    public Product(String name, String dateProduction, String producer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.dateProduction = dateProduction;
        this.producer = producer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }
    public void displayInformation() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + dateProduction);
        System.out.println("Производитель: " + producer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " РУБ");
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Доступен"));
        System.out.println("**************************************");
    }
}
