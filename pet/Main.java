package pet;
package food;

class Main {

    public static void main(String[] args) {

        Pet pet = new Pet("Kucing", 50, 110, 100, 100);

        Food food = new Food ("Bone",0,0);
        
        pet.feed(food);
        pet.play();
        pet.sleep();
        pet.showStatus();
        pet.healt();
    }
}
