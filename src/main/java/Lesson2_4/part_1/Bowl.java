package Lesson2_4.part_1;

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавили " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
}