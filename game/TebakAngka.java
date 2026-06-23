package game;

import java.util.Scanner;
import java.util.Random;
import inventory.Inventory;

public class TebakAngka {
    public static void mainkan(Inventory inv, Scanner input) {
        System.out.println("\n||===========================================||");
        System.out.println("||         MINIGAME: TEBAK ANGKA             ||");
        System.out.println("||===========================================||");
        System.out.println("Aku sedang memikirkan angka antara 1 sampai 5.");
        System.out.println("Hadiah: +50 Koin (Benar), +10 Koin (Salah)");
        
        int angkaRahasia = new Random().nextInt(5) + 1;
        System.out.print("Tebakanmu (1-5): ");
        int tebakan = input.nextInt();
        
        if (tebakan == angkaRahasia) {
            System.out.println("\nBINGO! Tebakanmu BENAR! +50 Koin.");
            inv.tambahKoin(50);
        } else {
            System.out.println("\nSalah! Angka yang benar adalah " + angkaRahasia);
            System.out.println("Kamu mendapatkan +10 Koin (Hadiah partisipasi).");
            inv.tambahKoin(10);
        }
    }
}