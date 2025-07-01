import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Buku {
    String judul, penulis;
    int tahun;

    public Buku(String judul, String penulis, int tahun) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    public void tampilInfo() {
        System.out.println("Judul    : " + judul);
        System.out.println("Penulis  : " + penulis);
        System.out.println("Tahun    : " + tahun);
        System.out.println("-----------------------");
    }
}

public class ManajemenBuku {
    public static void main(String[] args) {
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        HashMap<String, ArrayList<String>> dataPeminjam = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== Menu Perpustakaan ===");
            System.out.println("1. Tambah buku");
            System.out.println("2. Tampilkan semua buku");
            System.out.println("3. Cari buku");
            System.out.println("4. Hapus buku");
            System.out.println("5. Pinjam buku");
            System.out.println("6. Tampilkan data peminjam");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Judul buku: ");
                    String judul = input.nextLine();

                    System.out.print("Penulis: ");
                    String penulis = input.nextLine();

                    System.out.print("Tahun terbit: ");
                    int tahun = input.nextInt();

                    daftarBuku.add(new Buku(judul, penulis, tahun));
                    System.out.println("Buku berhasil ditambahkan!\n");

                    break;

                case 2:
                    if (daftarBuku.isEmpty()) {
                        System.out.println("Belum ada buku.\n");
                    } else {
                        for (Buku b : daftarBuku) {
                            b.tampilInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("cari judul: ");
                    String cariJudul = input.nextLine();
                    boolean ketemu = false;
                    for (Buku b : daftarBuku) {
                        if (b.judul.equalsIgnoreCase(cariJudul)) {
                            b.tampilInfo();
                            ketemu = true;
                        }
                    }
                    if (!ketemu) {
                        System.out.println("Buku tidak ditemukan!\n");
                    }
                    break;

                case 4:
                    System.out.print("Judul buku yang dihapus: ");
                    String hapusJudul = input.nextLine();
                    Buku bukuDihapus = null;
                    for (Buku b : daftarBuku) {
                        if (b.judul.equalsIgnoreCase(hapusJudul)) {
                            bukuDihapus = b;
                            break;
                        }
                    }
                    if (bukuDihapus != null) {
                        daftarBuku.remove(bukuDihapus);
                        System.out.println("Buku berhasil dihapus!\n");
                    } else {
                        System.out.println("Buku tidak ditemukan!\n");
                    }
                    break;

                case 5:
                    System.out.print("Nama peminjam: ");
                    String namaPeminjam = input.nextLine();
                    System.out.print("Judul buku yang dipinjam: ");
                    String judulBukuPinjam = input.nextLine();

                    boolean tersedia = false;
                    for (Buku b : daftarBuku) {
                        if (b.judul.equalsIgnoreCase(judulBukuPinjam)) {
                            tersedia = true;
                            break;
                        }
                    }
                    if (!tersedia) {
                        System.out.println("Judul buku tidak tersedia");
                        break;
                    }

                    if (!dataPeminjam.containsKey(namaPeminjam)) {
                        dataPeminjam.put(namaPeminjam, new ArrayList<>());
                    }

                    dataPeminjam.get(namaPeminjam).add(judulBukuPinjam);
                    System.out.println("Data peminjam tercatat.\n");
                    break;

                case 6:
                    if (dataPeminjam.isEmpty()) {
                        System.out.println("Belum ada data peminjam\n");
                    } else {
                        for (String nama : dataPeminjam.keySet()) {
                            System.out.println("Nama: " + nama);
                            System.out.println("Buku dipinjam: " + dataPeminjam.get(nama));
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        } while (pilihan != 0);

        input.close();
    }
}
