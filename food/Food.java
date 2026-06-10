package food;

public abstract class Food {

    private String name;
    private int nutritionValue;
    private int tastiness;
    private int health;

    public Food(String name, int nutritionValue, int tastiness, int health) {
        this.name = name;
        this.nutritionValue = nutritionValue;
        this.tastiness = tastiness;
    }

    public int getNutritionValue() {
        return nutritionValue;
    }

    public int getTastiness() {
        return tastiness;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public abstract int getHungerReduction();
    public abstract int getHappinessBoost();
    public abstract int getHealthBoost();
}








