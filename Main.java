
import food.Food;
import pet.Pet;

public class Main {

    public static void main(String[] args) {

        Pet pet = new Pet("Kucing", 50, 80, 100, 100);

        Food food = new Food("Bone", 99, 5);

        // pet.play();
        // pet.sleep();
        //pet.showStatus();
        pet.feed(food);

        pet.showStatus();

    }
}
