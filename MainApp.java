package gugugga;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner hai = new Scanner(System.in);

        // Input data 
        Pegawai pegawai = new Pegawai();
        pegawai.inputData(hai);

        System.out.println("\nDetail Pegawai:");
        pegawai.displayInfo();

        System.out.print("Tambahan bonus: ");
        double tambahanBonus = hai.nextDouble();
        System.out.println("============================");
        pegawai.tambahBonus(tambahanBonus);

        System.out.println("Bonus Ditambahkan:");
        pegawai.displayInfo();

        hai.close();
    }
}
