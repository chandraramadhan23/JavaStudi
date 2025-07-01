class Employee {
    String nama;
    String jabatan;
    double gaji;

    // Constructor
    public Employee(String nama, String jabatan, double gaji) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    // Method tampil data
    public void tampilData() {
        System.out.println("Nama    : " + nama);
        System.out.println("Jabatan : " + jabatan);
        System.out.println("Gaji    : Rp " + gaji);
    }
}

// Class Manager turunan Employee
class Manager extends Employee {
    public Manager(String nama, double gaji) {
        super(nama, "Manager", gaji);
    }

    // Override method tampilData
    @Override
    public void tampilData() {
        double bonus = gaji * 0.2;
        double total = gaji + bonus;

        System.out.println("Nama    : " + nama);
        System.out.println("Jabatan : Manager");
        System.out.println("Gaji    : Rp " + gaji);
        System.out.println("Bonus   : Rp " + bonus);
        System.out.println("Total   : Rp " + total);
        System.out.println("---------------------------");
    }
}

// Class Programmer turunan Employee
class Programmer extends Employee {
    public Programmer(String nama, double gaji) {
        super(nama, "Programmer", gaji);
    }

    // Override method tampilData
    @Override
    public void tampilData() {
        double bonus = gaji * 0.1;
        double total = gaji + bonus;

        System.out.println("Nama    : " + nama);
        System.out.println("Jabatan : Programmer");
        System.out.println("Gaji    : Rp " + gaji);
        System.out.println("Bonus   : Rp " + bonus);
        System.out.println("Total   : Rp " + total);
        System.out.println("---------------------------");
    }
}

public class InfoKaryawan {
    public static void main(String[] args) {
        // Buat objek karyawan
        Manager manajer1 = new Manager("Rivaldo", 8000000);
        Programmer programmer1 = new Programmer("Melina", 5000000);

        // Tampilkan data
        manajer1.tampilData();
        programmer1.tampilData();
    }
}