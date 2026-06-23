package game;

import java.util.Scanner;
import java.util.Random;
import inventory.Inventory;

public class BatuGuntingKertas {
    public static void mainkan(Inventory inv, Scanner input) {
        System.out.println("\n||===========================================||");
        System.out.println("||      MINIGAME: BATU GUNTING KERTAS        ||");
        System.out.println("||===========================================||");
        System.out.println("||  1. Batu                                  ||");
        System.out.println("||  2. Gunting                               ||");
        System.out.println("||  3. Kertas                                ||");
        System.out.println("||===========================================||");
        System.out.print("Pilihanmu (1-3): ");
        int pilihanUser = input.nextInt();

        if (pilihanUser < 1 || pilihanUser > 3) {
            System.out.println("\nPilihan tidak valid. Batal bermain.");
            return;
        }

        String[] namaPilihan = {"Batu", "Gunting", "Kertas"};
        int pilihanBot = new Random().nextInt(3) + 1;

        System.out.println("\nKamu memilih  : " + namaPilihan[pilihanUser - 1]);
        System.out.println("Lawan memilih : " + namaPilihan[pilihanBot - 1]);

        if (pilihanUser == pilihanBot) {
            System.out.println(">> Hasil: SERI! (+15 Koin)");
            inv.tambahKoin(15);
        } else if ((pilihanUser == 1 && pilihanBot == 2) || 
                   (pilihanUser == 2 && pilihanBot == 3) || 
                   (pilihanUser == 3 && pilihanBot == 1)) {
            System.out.println(">> Hasil: KAMU MENANG! (+40 Koin)");
            inv.tambahKoin(40);
        } else {
            System.out.println(">> Hasil: KAMU KALAH! (+5 Koin partisipasi)");
            inv.tambahKoin(5);
        }
    }
}