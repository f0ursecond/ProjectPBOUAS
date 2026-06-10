package pet;

import food.Food;


public abstract class Pet { 

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
    

    public void showStatus() {
        System.out.println("Nama : " + name);
        System.out.println("Hunger: " + hunger + "/100 " + createBar(hunger));
        System.out.println("Happiness: " + happiness + "/100 " + createBar(happiness));
        System.out.println("Energy: " + energy + "/100 " + createBar(energy));
        System.out.println("Health: " + health + "/100 " + createBar(health));
        
        if (isDead()) {
            System.out.println("STATUS: [MATI] - Game Over untuk pet ini.");
        } else if (isHungryMax()) {
            System.out.println("STATUS: [KELAPARAN] - Harus segera diberi makan!");
        }
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean isHungryMax() {
        return hunger >= 100;
    }

    private String createBar(int value) {
        int filled = value / 10;
        int empty = 10 - filled;
        return "[" + "#".repeat(filled) + "-".repeat(empty) + "]";
    }
    
    public abstract void play();
    public abstract void makeSound();
    public abstract String getSpecies();
    protected abstract int valAtt(int value);
    public abstract void feed(Food food);
    public abstract void sleep();
    public abstract void timePasses();
    

}



