package Lesson2_6.part2;

public class Main {
    public static void main(String[] args) {

        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Самойлов", "+7-918-345-75-54");
        directory.add("Ковалев", "+7-988-456-75-24");
        directory.add("Гусакова", "+7-989-456-75-53");
        directory.add("Самойлов", "+7-928-535-56-45");
        directory.add("Ковалев", "+7-911-865-78-52");

        System.out.println("Самойлов" + directory.get("Самойлов"));
        System.out.println("Ковалев" + directory.get("Ковалев"));
        System.out.println("Гусакова" + directory.get("Гусакова"));
    }
}