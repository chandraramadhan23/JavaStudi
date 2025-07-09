import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReminderJadwal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Jadwal> daftarJadwal = new ArrayList<>();
        int pilihan = -1;

        do {
            try {
                System.out.println("=== MENU REMINDER JADWAL ===");
                System.out.println("1. Tambah Jadwal");
                System.out.println("2. Lihat Jadwal");
                System.out.println("3. Cek Jadwal Lewat");
                System.out.println("0. Keluar");

                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Nama jadwal: ");
                        String namaJadwal = input.nextLine();

                        System.out.print("Waktu(dd-MM-yyyy HH:mm): ");
                        String waktuStr = input.nextLine();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                        LocalDateTime waktu = LocalDateTime.parse(waktuStr, formatter);

                        daftarJadwal.add(new Jadwal(namaJadwal, waktu));

                        System.out.println("Jadwal berhasil ditambah!\n");
                        break;

                    case 2:
                        if (daftarJadwal.isEmpty()) {
                            System.out.println("Belum ada jadwal!.\n");
                        } else {
                            for (Jadwal j : daftarJadwal) {
                                j.tampilInfo();
                            }
                        }
                        break;

                    case 3:
                        LocalDateTime sekarang = LocalDateTime.now();
                        boolean adaLewat = false;

                        for (Jadwal j : daftarJadwal) {
                            if (j.waktu.isBefore(sekarang)) {
                                j.tampilInfo();
                                adaLewat = true;
                            }
                        }

                        if (!adaLewat) {
                            System.out.println("Belum ada jadwal yang lewat!\n");
                        }
                        break;

                    case 0:
                        System.out.println("Program selesai.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid!");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Format waktu salah!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                input.nextLine();
            }
        } while (pilihan != 0);

        input.close();
    }
}
