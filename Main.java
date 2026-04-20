
import food.Food;
import pet.Pet;

public class Main {

    public static void main(String[] args) {

        Pet pet = new Pet("Kucing", 50, 50, 50, 50);

        Food food = new Food("Bone", 10, 5);

        pet.showStatus();
        pet.feed(food);
        pet.showStatus();
        pet.play();
        pet.showStatus();
        pet.sleep();
        pet.showStatus();
        pet.timePasses();
        pet.showStatus();
        pet.play();
        pet.showStatus();
        pet.sleep();
        pet.showStatus();
    
        


    }
}
