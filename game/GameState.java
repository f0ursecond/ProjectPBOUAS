package game;

import pet.Pet;
import inventory.Inventory;

public class GameState {
    private Pet pet;
    private Inventory inventory;
    private int currentTime;

    public GameState(Pet pet, Inventory inventory, int currentTime) {
        this.pet = pet;
        this.inventory = inventory;
        this.currentTime = currentTime;
    }

    public Pet getPet() { return pet; }
    public Inventory getInventory() { return inventory; }
    public int getCurrentTime() { return currentTime; }
}
