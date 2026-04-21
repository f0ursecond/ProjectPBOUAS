package pet;

import food.Food;


public class Pet {

    protected String name;
    protected int hunger;
    protected int happiness;
    protected int energy;
    protected int health;

    public Pet(String name, int hunger, int happiness, int energy, int health) {
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
        this.energy = energy;
        this.health = health;
    }

    protected int valAtt(int value){
        if (value < 0) 
            return 0;
        if (value > 100)
            return 100;
        return value;
    }

    public void feed(Food f) {

        hunger = valAtt(hunger - f.getNutritionValue());
        energy = valAtt(energy + 5);

        if (hunger >= 90) {
            health = valAtt(health - 5);
        }
    }

    public void play() {
        happiness = valAtt(happiness + 10);
        energy = valAtt(energy - 10);
    }

    public void sleep() {
        energy = valAtt(energy + 20);
    }

    public void timePasses() {
        hunger = valAtt(hunger + 10);
        happiness = valAtt(happiness - 5);
        energy = valAtt(energy - 5);
    }

    public void showStatus() {
        System.out.println("Nama : " + name);
        System.out.println("Hunger: " + hunger + "/100 " + createBar(hunger));
        System.out.println("Happiness: " + happiness + "/100 " + createBar(happiness));
        System.out.println("Energy: " + energy + "/100 " + createBar(energy));
        System.out.println("Health: " + health + "/100 " + createBar(health));
    }

    private String createBar(int value) {
        int filled = value / 10;
        int empty = 10 - filled;
        return "[" + "#".repeat(filled) + "-".repeat(empty) + "]";
    }

}



