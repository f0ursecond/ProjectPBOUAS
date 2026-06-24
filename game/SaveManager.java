package game;

import java.io.*;
import pet.Pet;
import pet.Cat;
import pet.Dog;
import pet.Bird;
import inventory.Inventory;

public class SaveManager {
    
    public static void saveGame(String filepath, Pet pet, Inventory inventory, int currentTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(pet.getSpecies());
            writer.newLine();
            writer.write(pet.getName());
            writer.newLine();
            writer.write(String.valueOf(pet.getHunger()));
            writer.newLine();
            writer.write(String.valueOf(pet.getHappiness()));
            writer.newLine();
            writer.write(String.valueOf(pet.getEnergy()));
            writer.newLine();
            writer.write(String.valueOf(pet.getHealth()));
            writer.newLine();
            writer.write(String.valueOf(inventory.getKoin()));
            writer.newLine();
            writer.write(String.valueOf(inventory.punyaMainan(4))); // puzzle
            writer.newLine();
            writer.write(String.valueOf(inventory.punyaMainan(5))); // musik
            writer.newLine();
            writer.write(String.valueOf(currentTime));
            writer.newLine();
            System.out.println("\n[Sistem] Game berhasil disimpan ke " + filepath);
        } catch (IOException e) {
            System.out.println("\n[Gagal] Terjadi kesalahan saat menyimpan game: " + e.getMessage());
        }
    }

    public static GameState loadGame(String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String species = reader.readLine();
            String name = reader.readLine();
            int hunger = Integer.parseInt(reader.readLine());
            int happiness = Integer.parseInt(reader.readLine());
            int energy = Integer.parseInt(reader.readLine());
            int health = Integer.parseInt(reader.readLine());
            int koin = Integer.parseInt(reader.readLine());
            boolean punyaPuzzle = Boolean.parseBoolean(reader.readLine());
            boolean punyaMusik = Boolean.parseBoolean(reader.readLine());
            int currentTime = Integer.parseInt(reader.readLine());

            Pet pet = null;
            if (species.equalsIgnoreCase("Kucing")) {
                pet = new Cat(name);
            } else if (species.equalsIgnoreCase("Anjing")) {
                pet = new Dog(name);
            } else if (species.equalsIgnoreCase("Burung")) {
                pet = new Bird(name);
            } else {
                System.out.println("\n[Gagal] Spesies pet '" + species + "' tidak dikenal.");
                return null;
            }

            pet.setHunger(hunger);
            pet.setHappiness(happiness);
            pet.setEnergy(energy);
            pet.setHealth(health);

            Inventory inventory = new Inventory(koin, punyaPuzzle, punyaMusik);

            System.out.println("\n[Sistem] Game berhasil dimuat dari " + filepath);
            return new GameState(pet, inventory, currentTime);
        } catch (FileNotFoundException e) {
            System.out.println("\n[Sistem] File save tidak ditemukan.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("\n[Gagal] Terjadi kesalahan saat memuat game: " + e.getMessage());
        }
        return null;
    }
}
