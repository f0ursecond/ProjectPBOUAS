package game;

import java.util.Scanner;
import inventory.Inventory;

public class GameCenter {
    public static void bukaMenu(Inventory inv, Scanner input) {
        System.out.println("\n||===========================================||");
        System.out.println("||               GAME CENTER                 ||");
        System.out.println("||===========================================||");
        System.out.println("||  1. Tebak Angka (Hadiah Besar)            ||");
        System.out.println("||  2. Batu Gunting Kertas (Hadiah Sedang)   ||");
        System.out.println("||  0. Kembali                               ||");
        System.out.println("||===========================================||");
        System.out.print("Pilih minigame: ");
        int pilih = input.nextInt();

        if (pilih == 1) {
            TebakAngka.mainkan(inv, input);
        } else if (pilih == 2) {
            BatuGuntingKertas.mainkan(inv, input);
        } else if (pilih == 0) {
            System.out.println("\nKembali ke menu aksi.");
        } else {
            System.out.println("\nPilihan tidak valid.");
        }
    }
}