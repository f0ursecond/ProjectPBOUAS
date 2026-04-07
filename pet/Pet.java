package pet;

import food.Food;

public class Pet {

    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;

    public Pet(String name, int hunger, int happiness, int energy, int health) {
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
        this.energy = energy;
        this.health = health;
    }

    public void feed(Food f) {

        System.out.println(name + " makan " + f.getName());

        hunger -= f.getNutritionValue();

        if (hunger >= 90) {
            health -= 5;
        }

        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void play() {
        happiness += 10;
        energy -= 10;
    }

    public void sleep() {
        energy += 20;
    }

    public void timePasses() {
        hunger += 10;
        happiness -= 5;
        energy -= 5;
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
