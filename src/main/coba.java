package main;

import java.util.Date;
import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan waktu masuk (HH:mm): ");
        String waktuMasukStr = scanner.nextLine();

        System.out.print("Masukkan waktu keluar (HH:mm): ");
        String waktuKeluarStr = scanner.nextLine();

        // Membuat objek Date untuk waktu masuk
        Date waktuMasuk = parseDate(waktuMasukStr);

        // Membuat objek Date untuk waktu keluar
        Date waktuKeluar = parseDate(waktuKeluarStr);

        // Menghitung selisih waktu dalam milidetik
        long selisihMillis = waktuKeluar.getTime() - waktuMasuk.getTime();

        // Menghitung durasi parkir dalam jam
        int durasiJam = (int) (selisihMillis / (1000 * 60 * 60));

        // Menghitung biaya parkir
        int biayaDasar = 5000; // Biaya parkir dasar per jam
        int totalBiaya = biayaDasar * durasiJam;

        System.out.println("Total biaya parkir: Rp. " + totalBiaya);
    }

    // Metode untuk mengubah string menjadi objek Date dengan format HH:mm
    private static Date parseDate(String waktuStr) {
        try {
            String[] waktuArr = waktuStr.split(":");
            int jam = Integer.parseInt(waktuArr[0]);
            int menit = Integer.parseInt(waktuArr[1]);

            Date waktu = new Date();
            waktu.setHours(jam);
            waktu.setMinutes(menit);

            return waktu;
        } catch (Exception e) {
            System.out.println("Format waktu tidak valid. Gunakan format HH:mm");
            System.exit(0);
        }

        return null;
    }
}
