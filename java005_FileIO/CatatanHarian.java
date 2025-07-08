package java005_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CatatanHarian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        try {
            do {
                System.out.println("=== MENU CATATAN HARIAN ===");
                System.out.println("1. Tambah Catatan");
                System.out.println("2. Lihat Catatan");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine(); // buang enter

                switch (pilihan) {
                    case 1:
                        tambahCatatan(input);
                        break;
                    case 2:
                        tampilkanCatatan();
                        break;
                    case 0:
                        System.out.println("Program selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } while (pilihan != 0);

            input.close();
        } catch (InputMismatchException e) {
            System.out.println("Input bukan angka!");
        }
    }

    private static void tambahCatatan(Scanner input) {

        try {
            FileWriter writer = new FileWriter("catatan.txt", true);
            System.out.print("Tulis Catatan: ");
            String isiCatatan = input.nextLine();
            writer.write(isiCatatan + "\n");
            writer.close();
            System.out.println("Catatan berhasil ditambahkan.\n");
        } catch (IOException e) {
            System.out.println("Terjadi error saat menulis catatan");
        }

    }

    private static void tampilkanCatatan() {
        try {
            File file = new File("catatan.txt");
            if (!file.exists()) {
                System.out.println("Belum ada catatan");
                return;
            }

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String baris;

            System.out.println("=== ISI CATATAN ===");
            while ((baris = bufferedReader.readLine()) != null) {
                System.out.println(baris);
            }
            System.out.println("================================");
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Terjadi error saat membaca file");
        }
    }

}
