package pet;
import food.Food;

public abstract class Pet { 
    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;

    public Pet(String name, int hunger, int happiness, int energy, int health) {
        this.name = name;
        setHunger(hunger);
        setHappiness(happiness);
        setEnergy(energy);
        setHealth(health);
    }

    protected int valAtt(int value) {
        if (value < 0) return 0;
        if (value > 100) return 100;
        return value;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHunger() { return hunger; }
    public void setHunger(int hunger) { this.hunger = valAtt(hunger); }
    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { this.happiness = valAtt(happiness); }
    public int getEnergy() { return energy; }
    public void setEnergy(int energy) { this.energy = valAtt(energy); }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = valAtt(health); }

    protected void checkConditions() {
        if (getHunger() >= 90) setHealth(getHealth() - 5);
        if (getHunger() == 0) setHealth(getHealth() + 5);
        if (getEnergy() <= 15) setHunger(getHunger() + 5);
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

    public boolean isDead() { return health <= 0; }
    public boolean isHungryMax() { return hunger >= 100; }

    private String createBar(int value) {
        int filled = value / 10;
        int empty = 10 - filled;
        return "[" + "#".repeat(filled) + "-".repeat(empty) + "]";
    }
    
    public abstract void feed(Food food);
    public abstract void play(int gameChoice); 
    public abstract void makeSound();
    public abstract void sleep();
    public abstract void timePasses();
    public abstract String getSpecies();
}