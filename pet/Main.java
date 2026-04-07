package pet;

class Main {

    public static void main(String[] args) {

        Pet pet = new Pet("Kucing", 50, 110, 100);

        pet.hunger();
        pet.play();
        pet.sleep();
        pet.showStatus();
    }
}
