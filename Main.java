import java.util.Scanner;

import food.Food;
import pet.Bird;
import pet.Cat;
import pet.Dog;
import pet.Pet;
import food.DryFood;
import food.WetFood;
import food.Treat;

public class Main {

    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n||===========================================||");
            System.out.println("||               PET SIMULATOR               ||");
            System.out.println("||===========================================||");
            System.out.println("||                                           ||");
            System.out.println("||  1. Bermain                               ||");
            System.out.println("||  0. Keluar                                ||");
            System.out.println("||                                           ||");
            System.out.println("||===========================================||");

            System.out.print("Pilih menu: ");
            int pilih = Input.nextInt();

            if (pilih == 1) {
                Pet myPet = null;

                while (true) {
                    System.out.println("\n||===========================================||");
                    System.out.println("||           PILIH HEWAN PELIHARAAN          ||");
                    System.out.println("||===========================================||");
                    System.out.println("||  1. Kucing                                ||");
                    System.out.println("||  2. Anjing                                ||");
                    System.out.println("||  3. Burung                                ||");
                    System.out.println("||===========================================||");
                    
                    System.out.print("Masukkan nomor hewan: ");
                    int hewan = Input.nextInt();
                    Input.nextLine(); // hilang line 
                    
                    if (hewan >= 1 && hewan <= 3) {
                        System.out.print("Silahkan masukkan nama: ");
                        String name = Input.nextLine();
                    
                        switch(hewan){
                            case 1:
                                myPet = new Cat(name);
                                System.out.println("\nSelamat datang, " + name + " (Kucing)");
                                break;
                            case 2:
                                myPet = new Dog(name);
                                System.out.println("\nSelamat datang, " + name + " (Anjing)");
                                break;
                            case 3:
                                myPet = new Bird(name);
                                System.out.println("\nSelamat datang, " + name + " (Burung)");
                                break;
                        }
                        break;
                    } else {
                        System.out.println("\nInputan salah. Silakan pilih 1, 2, atau 3.");
                    }
                }
                
                System.out.println("\n--- Statistik Awal ---");
                myPet.showStatus();
                
                while (true) {
                    System.out.println("\n||===========================================||");
                    System.out.println("||                 MENU AKSI                 ||");
                    System.out.println("||===========================================||");
                    System.out.println("||  1. Feed                                  ||");
                    System.out.println("||  2. Play                                  ||");
                    System.out.println("||  3. Sleep                                 ||");
                    System.out.println("||  4. Stat Pet                              ||");
                    System.out.println("||  5. Time Pass                             ||");
                    System.out.println("||  0. Kembali                               ||");
                    System.out.println("||===========================================||");

                    System.out.print("Pilih aksi: ");
                    int aksi = Input.nextInt();

                    if (aksi == 1) {
                        System.out.println("\n||===========================================||");
                        System.out.println("||               PILIH MAKANAN               ||");
                        System.out.println("||===========================================||");
                        System.out.println("||  1. Ikan   (DryFood)                      ||");
                        System.out.println("||  2. Dimsum (DryFood)                      ||");
                        System.out.println("||  3. Air    (WetFood)                      ||");
                        System.out.println("||  4. Esteh  (WetFood)                      ||");
                        System.out.println("||  5. Obat1  (Treat)                        ||");
                        System.out.println("||===========================================||");

                        System.out.print("Pilih makanan: ");
                        int pilihMakanan = Input.nextInt();

                        Food makanan;

                        switch (pilihMakanan) {
                            case 1:
                                makanan = DryFood.Ikan();
                                System.out.println("\nMemberi makan Ikan");
                                break;
                            case 2:
                                makanan = DryFood.Dimsum();
                                System.out.println("\nMemberi makan Dimsum");
                                break;
                            case 3:
                                makanan = WetFood.Air();
                                System.out.println("\nMemberi Minum Air");
                                break;
                            case 4:
                                makanan = WetFood.Esteh();
                                System.out.println("\nMemberi Minum Es Teh");
                                break;
                            case 5:
                                makanan = Treat.Obat1();
                                System.out.println("\nMemberi Obat");
                                break;
                            default:
                                System.out.println("\nPilihan tidak valid.");
                                continue;
                        }
                        myPet.feed(makanan);
                    } 
                    else if (aksi == 2) {
                        System.out.println("\nSedang bermain...");
                        myPet.play();
                    } 
                    else if (aksi == 3) {
                        System.out.println("\nWaktunya tidur...");
                        myPet.sleep();
                    } 
                    else if (aksi == 4) {
                        System.out.println("\n--- Statistik Saat Ini ---");
                        myPet.showStatus();
                    } 
                    else if (aksi == 5) {
                        myPet.timePasses();
                        System.out.println("\nHari berlalu...");
                        System.out.println("Besok......");
                    }
                    else if (aksi == 0) {
                        System.out.println("\nKembali ke menu utama...");
                        break;
                    } 
                    else {
                        System.out.println("\nInput salah.");
                        continue;
                    }
                }

            }
            else if (pilih == 0){
                System.out.println("\nTerima Kasih.");
                break;
            }
            else{
                System.out.println("\nInput salah.");
            }
        } 
        
        Input.close();
    }
}