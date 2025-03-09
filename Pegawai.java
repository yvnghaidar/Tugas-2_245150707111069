package gugugga;
import java.util.Scanner;
class Pegawai {
    private String Nama;
    private String Jabatan;
    private double gajiPokok;
    private double Tunjangan;
    private double Potongan;
    private double Bonus;

    // Default Constructor
    public Pegawai() {
        this("", "", 0, 0, 0, 0);
    }

    // Overloading Constructor
    public Pegawai(String Nama, String Jabatan, double gajiPokok, double Tunjangan, double Potongan, double Bonus) {
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        setGajiPokok(gajiPokok);
        setTunjangan(Tunjangan);
        setPotongan(Potongan);
        setBonus(Bonus);
    }

    public void inputData(Scanner hai) {
        System.out.print("Nama: ");
        this.Nama = hai.nextLine();
        System.out.print("Jabatan: ");
        this.Jabatan = hai.nextLine();

        this.gajiPokok = validasiInput(hai, "Gaji Pokok: ");
        this.Tunjangan = validasiInput(hai, "Tunjangan: ");
        this.Potongan = validasiInput(hai, "Potongan: ");
        this.Bonus = validasiInput(hai, "Bonus: ");
    }

    private double validasiInput(Scanner hai, String message) {
        double input;
        do {
            System.out.print(message);
            while (!hai.hasNextDouble()) {
                System.out.println("Harap masukkan angka yang valid.");
                hai.next(); 
            }
            input = hai.nextDouble();
            hai.nextLine();
            if (input < 0) {
                System.out.println("Input tidak boleh negatif. Coba lagi.");
            }
        } while (input < 0);
        return input;
    }
    

    // Getter dan Setter
    public String getNama() {
        return Nama;
    }
    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    public String getJabatan() {
        return Jabatan;
    }
    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }
    public double getGajiPokok() {
        return gajiPokok;
    }
    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = Math.max(gajiPokok, 0);
    }
    public double getTunjangan() {
        return Tunjangan;
    }
    public void setTunjangan(double Tunjangan) {
        this.Tunjangan = Math.max(Tunjangan, 0);
    }
    public double getPotongan() {
        return Potongan;
    }
    public void setPotongan(double Potongan) {
        this.Potongan = Math.max(Potongan, 0);
    }
    public double getBonus() {
        return Bonus;
    }
    public void setBonus(double Bonus) {
        this.Bonus = Math.max(Bonus, 0);
    }

    // Method total gaji
    public double hitungGajiTotal() {
        return gajiPokok + Tunjangan + Bonus - Potongan;
    }

    // Method menampilkan detail pegawai
    public void displayInfo() {
        System.out.printf(
            "Nama: %s\nJabatan: %s\nGaji Pokok: %.2f\nTunjangan: %.2f\nBonus: %.2f\nPotongan: %.2f\nTotal Gaji: %.2f\n============================\n", 
            Nama, Jabatan, gajiPokok, Tunjangan, Bonus, Potongan, hitungGajiTotal()
        );
    }

    // Method Menambahkan Bonus
    public void tambahBonus(double tambahanBonus) {
        setBonus(this.Bonus + tambahanBonus);
    }
}
