package pet;

class Pet {

    private String name;
    private int hunger;
    private int happinness;
    private int energy;

    public Pet(String name, int hunger, int happinness, int energy) {
        this.name = name;
        this.hunger = hunger;
        this.happinness = happinness;
        this.energy = energy;
    }

    public void hunger() {
        hunger = hunger - 50;
    }

    public void play() {
        happinness = happinness + 50;
        energy = energy - 50;
    }

    public void sleep() {
        hunger = hunger - 10;
        happinness = happinness + 50;
    }

    public void showStatus() {
        System.out.println("Nama : " + name);
        System.out.println("Hunger :" + hunger);
        System.out.println("Happiness :" + happinness);
        System.out.println("Energy : " + energy);
    }

    public static void main(String[] args) {

    }

}
