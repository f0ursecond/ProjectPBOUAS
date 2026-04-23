
import food.Food;
import pet.Pet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pet pet = new Pet("Kucing", 50, 50, 50, 50);
        Food food = new Food("Fish", 10, 5);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n========= Kondisi Hewan =========");
            pet.showStatus();
            System.out.println("\nPilih aksi:");
            System.out.println("1. Beri makan");
            System.out.println("2. Main");
            System.out.println("3. Tidur");
            System.out.println("4. Time Pass");
            System.out.println("0. Keluar");
            System.out.println("==================================");
            System.out.println("");
            System.out.print("Pilihan Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    pet.feed(food);
                    System.out.println("\nKamu memberi makan peliharaanmu.");
                    break;
                case 2:
                    pet.play();
                    System.out.println("\nKamu bermain dengan peliharaanmu.");
                    break;
                case 3:
                    pet.sleep();
                    System.out.println("\nKamu membiarkan peliharaanmu tidur.");
                    break;
                case 4:
                    pet.timePasses();
                    System.out.println("\nWaktu berlalu...");
                    break;
                case 0:
                    System.out.println("\nKeluar dari permainan. Sampai jumpa!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
