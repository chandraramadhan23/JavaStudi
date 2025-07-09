import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Jadwal {
    String namaJadwal;
    LocalDateTime waktu;

    public Jadwal(String namaJadwal, LocalDateTime waktu) {
        this.namaJadwal = namaJadwal;
        this.waktu = waktu;
    }

    public void tampilInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Jadwal: " + namaJadwal);
        System.out.println("Wakt: " + waktu.format(formatter));
        System.out.println("=========================");
    }
}
