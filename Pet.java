abstract class Pet {
    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private int health;
    private boolean isAlive;

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
        this.health = 100;
        this.isAlive = true;
    }


    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
    public int getEnergy() { return energy; }
    public int getHealth() { return health; }
    public boolean isAlive() { return isAlive; }


    public void setHunger(int hunger) {
        if (hunger < 0) this.hunger = 0;
        else if (hunger > 100) this.hunger = 100;
        else this.hunger = hunger;
    }

    public void setHappiness(int happiness) {
        if (happiness < 0) this.happiness = 0;
        else if (happiness > 100) this.happiness = 100;
        else this.happiness = happiness;
    }

    public void setEnergy(int energy) {
        if (energy < 0) this.energy = 0;
        else if (energy > 100) this.energy = 100;
        else this.energy = energy;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
            this.isAlive = false;
            System.out.println(name + " has died 💀");
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
    }


    public void feed(Food food) {
        if (!isAlive) return;

        System.out.println(name + " eats " + food.getName());

        setHunger(this.hunger - food.getHungerReduction());
        setHappiness(this.happiness + food.getHappinessBoost());
    }

    public void sleep() {
        if (!isAlive) return;

        System.out.println(name + " is sleeping...");
        setEnergy(this.energy + 30);
        setHunger(this.hunger + 10);
    }

    public void timePasses() {
        if (!isAlive) return;

        setHunger(this.hunger + 10);
        setHappiness(this.happiness - 5);
        setEnergy(this.energy - 5);

        if (hunger >= 100) {
            setHealth(this.health - 10);
        }
    }

    public void showStatus() {
        System.out.println("\n=== " + name + " (" + getSpecies() + ") ===");
        System.out.println("Hunger    : " + hunger);
        System.out.println("Happiness : " + happiness);
        System.out.println("Energy    : " + energy);
        System.out.println("Health    : " + health);
    }


    abstract void makeSound();
    abstract void play();
    abstract String getSpecies();
}
