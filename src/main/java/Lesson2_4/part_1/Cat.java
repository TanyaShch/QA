package Lesson2_4.part_1;

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isHungry = true;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isHungry = false;
            System.out.println(name + " поел из миски и теперь сыт.");
        } else {
            System.out.println(name + " не смог поесть из миски. Недостаточно еды.");
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}