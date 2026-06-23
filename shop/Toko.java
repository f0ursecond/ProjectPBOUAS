package shop;

import java.util.Scanner;
import inventory.Inventory;

public class Toko {
    public static void bukaToko(Inventory inv, Scanner input) {
        System.out.println("\n||===========================================||");
        System.out.println("||               TOKO MAINAN                 ||");
        System.out.println("|| Koin Anda: " + inv.getKoin() + "                           ||");
        System.out.println("||===========================================||");
        System.out.println("||  1. Puzzle Pintar     (150 Koin) " + inv.getStatusToko(1));
        System.out.println("||  2. Mainan Musikal    (150 Koin) " + inv.getStatusToko(2));
        System.out.println("||  0. Batal                         ");
        System.out.println("||===========================================||");
        System.out.print("Beli mainan nomor: ");
        int beli = input.nextInt();
        
        if (beli == 1) {
            if (inv.punyaMainan(4)) {
                System.out.println("\n[Info] Anda sudah memiliki Puzzle Pintar.");
            } else if (inv.getKoin() >= 150) {
                inv.kurangiKoin(150);
                inv.beliMainan(1);
                System.out.println("\n[Sukses] Berhasil membeli Puzzle Pintar!");
            } else {
                System.out.println("\n[Gagal] Koin tidak cukup!");
            }
        } else if (beli == 2) {
            if (inv.punyaMainan(5)) {
                System.out.println("\n[Info] Anda sudah memiliki Mainan Musikal.");
            } else if (inv.getKoin() >= 150) {
                inv.kurangiKoin(150);
                inv.beliMainan(2);
                System.out.println("\n[Sukses] Berhasil membeli Mainan Musikal!");
            } else {
                System.out.println("\n[Gagal] Koin tidak cukup!");
            }
        } else if (beli == 0) {
            System.out.println("\nMembatalkan pembelian...");
        } else {
            System.out.println("\nPilihan tidak valid.");
        }
    }
}