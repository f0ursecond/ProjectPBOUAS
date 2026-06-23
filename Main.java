import java.util.Scanner;

import food.Food;
import food.DryFood;
import food.WetFood;
import food.Treat;
import pet.Bird;
import pet.Cat;
import pet.Dog;
import pet.Pet;
import time.Time;

import inventory.Inventory;
import shop.Toko;
import game.GameCenter;

public class Main {
    public static void main(String[] args){
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
                    Input.nextLine(); 
                    
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
                
                // Mulai Timer
                Time.startAutoTimePass(myPet, 80, 5);

                // Inisialisasi Inventory (Koin awal: 50)
                Inventory playerInventory = new Inventory(50);

                System.out.println("\n--- Statistik Awal ---");
                myPet.showStatus();
                
                while (true) {
                    System.out.println("\n||===========================================||");
                    System.out.println("||                 MENU AKSI                 ||");
                    System.out.println("||  Koin Anda: " + playerInventory.getKoin());
                    System.out.println("||===========================================||");
                    System.out.println("||  1. Feed (Beli Makanan)                   ||");
                    System.out.println("||  2. Play (Main dgn Pet)                   ||");
                    System.out.println("||  3. Sleep                                 ||");
                    System.out.println("||  4. Stat Pet                              ||");
                    System.out.println("||  5. Info Timer (Auto)                     ||");
                    System.out.println("||  6. Make Sound                            ||");
                    System.out.println("||  7. Game Center (Cari Koin)               ||");
                    System.out.println("||  8. Toko Mainan                           ||");
                    System.out.println("||  0. Kembali                               ||");
                    System.out.println("||===========================================||");

                    System.out.print("Pilih aksi: ");
                    int aksi = Input.nextInt();

                    if (myPet.isDead() && aksi != 0 && aksi != 4 && aksi != 5) {
                        System.out.println("\n[Peringatan] Pet kamu sudah mati. Kamu tidak bisa melakukan aksi ini.");
                        continue;
                    }

                    if (myPet.isHungryMax() && !myPet.isDead() && aksi != 1 && aksi != 4 && aksi != 5 && aksi != 0) {
                        System.out.println("\n[Peringatan] Pet sangat lapar! Kamu hanya bisa memberi makan (Feed).");
                        continue;
                    }

                    if (aksi == 1) {
                        System.out.println("\n||===========================================||");
                        System.out.println("||               PILIH MAKANAN               ||");
                        System.out.println("||===========================================||");
                        System.out.println("||  1. Ikan   (20 Koin)                      ||");
                        System.out.println("||  2. Snack  (15 Koin)                      ||");
                        System.out.println("||  3. Air    (5 Koin)                       ||");
                        System.out.println("||  4. Susu   (10 Koin)                      ||");
                        System.out.println("||  5. Obat1  (50 Koin)                      ||");
                        System.out.println("||===========================================||");
                        System.out.print("Pilih makanan: ");
                        int pilihMakanan = Input.nextInt();

                        Food makanan = null;
                        int harga = 0;

                        switch (pilihMakanan) {
                            case 1: makanan = DryFood.Ikan(); harga = 20; break;
                            case 2: makanan = DryFood.Snack(); harga = 15; break;
                            case 3: makanan = WetFood.Air(); harga = 5; break;
                            case 4: makanan = WetFood.Susu(); harga = 10; break;
                            case 5: makanan = Treat.Obat1(); harga = 50; break;
                            default: System.out.println("\nPilihan tidak valid."); continue;
                        }

                        if (playerInventory.kurangiKoin(harga)) {
                            System.out.println("\nBerhasil membeli " + makanan.getName() + " seharga " + harga + " Koin.");
                            myPet.feed(makanan);
                        } else {
                            System.out.println("\n[Gagal] Koin tidak cukup! Sisa Koin Anda: " + playerInventory.getKoin());
                        }

                    } 
                    else if (aksi == 2) {
                        System.out.println("\n||===========================================||");
                        System.out.println("||               PILIH MAINAN                ||");
                        System.out.println("||===========================================||");
                        System.out.println("||  1. Tangkap Bola      (Default)           ||");
                        System.out.println("||  2. Titik Laser       (Default)           ||");
                        System.out.println("||  3. Rintangan Udara   (Default)           ||");
                        
                        if (playerInventory.punyaMainan(4)) {
                            System.out.println("||  4. Puzzle Pintar     (Premium)           ||");
                        }
                        if (playerInventory.punyaMainan(5)) {
                            System.out.println("||  5. Mainan Musikal    (Premium)           ||");
                        }
                        System.out.println("||===========================================||");
                        System.out.print("Pilih game (1-5): ");
                        int pilihGame = Input.nextInt();
                        
                        // Cek apakah input valid dan mainan dimiliki
                        if ((pilihGame >= 1 && pilihGame <= 3) || playerInventory.punyaMainan(pilihGame)) {
                            System.out.println("\nSedang bermain...");
                            myPet.play(pilihGame);
                        } else {
                            System.out.println("\n[Peringatan] Pilihan tidak valid atau Anda belum membeli mainan ini di Toko.");
                        }
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
                        System.out.println("\nWaktu berjalan otomatis di background.");
                        System.out.println("Status pet akan terupdate setiap 5 Detik.");
                    }
                    else if (aksi == 6) {
                        System.out.println("\nMengeluarkan suara...");
                        myPet.makeSound();
                    }
                    else if (aksi == 7) {
                        GameCenter.bukaMenu(playerInventory, Input);
                    }
                    else if (aksi == 8) {
                        Toko.bukaToko(playerInventory, Input);
                    }
                    else if (aksi == 0) {
                        System.out.println("\nKembali ke menu utama...");
                        break;
                    } 
                    else {
                        System.out.println("\nInput salah.");
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