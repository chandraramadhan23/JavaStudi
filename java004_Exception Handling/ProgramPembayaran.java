import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramPembayaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double hargaBarang = 0;
        double jumlahBayar = 0;

        try {
            // Input harga barang
            System.out.print("Masukkan harga barang: ");
            hargaBarang = input.nextDouble();

            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0!");
            }

            if (hargaBarang > 100000) {
                throw new IllegalArgumentException("Harga lebih dari Rp. 100.000");
            }

            // Input jumlah barang
            System.out.print("Masukkan jumlah bayar: ");
            jumlahBayar = input.nextDouble();

            if (jumlahBayar < hargaBarang) {
                throw new Exception("Jumlah bayar kurang dari harga barang!");
            }

            double kembalian = jumlahBayar - hargaBarang;
            System.out.println("Kembalian: Rp. " + kembalian);
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaksi selesai.");
            input.close();
        }
    }
}