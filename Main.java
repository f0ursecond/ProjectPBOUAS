
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
            System.out.println("Selamat Datang Di Permainan Pet Simulator");
            System.out.println("1. Bermain");
            System.out.println("0. Keluar");

            System.out.print("Pilih: ");
            int pilih = Input.nextInt();

            if ( pilih == 1) {
                System.out.println("Silahkan Pilih Hewan:");
                System.out.println("1.Kucing");
                System.out.println("2.Anjing");
                System.out.println("3.Burung:");
                int hewan = Input.nextInt();
                Input.nextLine();// hilang line 
                
                System.out.print("Silahkan Masukkan Nama:");
                String name = Input.nextLine();
            


                Pet myPet;

                switch(hewan){
                    case 1:
                        myPet = new Cat(name);
                        System.out.println("Selamat Datang " + name + " dan hewan kamu adalah kucing");
                        break;
                    case 2:
                        myPet = new Dog(name);
                        break;
                    case 3:
                        myPet = new Bird(name);
                        break;
                    default:
                        System.out.println("Inputan Salah");
                        continue;
                }
                myPet.showStatus();
                
                while (true) {
                System.out.println("\n=== Menu Aksi ===");
                System.out.println("1. Feed");
                System.out.println("2. Play");
                System.out.println("3. Sleep");
                System.out.println("4. Status");
                System.out.println("5. Time Pass");
                System.out.println("0. Kembali");

                System.out.print("Pilih aksi: ");
                int aksi = Input.nextInt();

                if (aksi == 1) {
                    System.out.println("\n=== Pilih Makanan ===");
                    System.out.println("1. Ikan (DryFood)");
                    System.out.println("2. Dimsum (DryFood)");
                    System.out.println("3. Air (WetFood)");
                    System.out.println("4. Esteh (WetFood)");
                    System.out.println("5. Obat1 (Treat)");

                    System.out.print("Pilih makanan: ");
                    int pilihMakanan = Input.nextInt();

                    Food makanan;

                    switch (pilihMakanan) {
                        case 1:
                            makanan = DryFood.Ikan();
                            break;
                        case 2:
                            makanan = DryFood.Dimsum();
                            break;
                        case 3:
                            makanan = WetFood.Air();
                            break;
                        case 4:
                            makanan = WetFood.Esteh();
                            break;
                        case 5:
                            makanan = Treat.Obat1();
                            break;
                        default:
                            System.out.println("Pilihan tidak valid");
                            continue;
                    }

                    myPet.feed(makanan);
                } 
                else if (aksi == 2) {
                    myPet.play();
                } 
                else if (aksi == 3) {
                    myPet.sleep();
                } 
                else if (aksi == 4) {
                    myPet.showStatus();
                } 
                else if (aksi == 5) {
                    myPet.timePasses();
                    System.out.println("Besok......");
                }
                else if (aksi == 0) {
                    System.out.println("Kembali ke menu utama...");
                    break;
                } 
                else {
                    System.out.println("Input salah");
                    continue;
                }

            }


            }
            else if (pilih == 0){
                System.out.print("Terima Kasih");
                break;
            }
            else{
                System.out.println("Input salah");
            }
        } 
        
    }
}
