package food;

public class Food {

    private String name;
    private int nutritionValue;
    private int tastiness;

    public Food(String name, int nutritionValue, int tastiness) {
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
}








