import java.util.Scanner;

public class KasirSederhana {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nama Barang : ");
        String namaBarang = input.nextLine();

        System.out.print("Harga Barang : ");
        double hargaBarang = input.nextDouble();

        System.out.print("Jumlah Beli : ");
        int jumlahBeli = input.nextInt();

        double totalHarga = hargaBarang * jumlahBeli;

        double diskon = 0;

        if (totalHarga > 100000) {
            diskon = totalHarga * 0.1;
        }

        double totalBayar = totalHarga - diskon;

        System.out.println("\n===== Struk Pembelian =====");
        System.out.println("Nama Barang  : " + namaBarang);
        System.out.println("Harga Barang : Rp " + hargaBarang);
        System.out.println("Jumlah Beli  : " + jumlahBeli);
        System.out.println("Total Harga  : Rp " + totalHarga);
        System.out.println("Diskon       : Rp " + diskon);
        System.out.println("Total Bayar  : Rp " + totalBayar);
        System.out.println("===========================");

        input.close();
    }
}