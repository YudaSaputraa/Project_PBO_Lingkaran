package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;

public class KerucutTerpancungThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread KERUCUT TERPANCUNG dijalankan....");
        try {
            double jariBesar = 1;
            double jariKecil = 1;

            double tinggiKTerpancung = 1;

            for (int i = 1; i <= 24; i++) {
                KerucutTerpancung kTerpancung = new KerucutTerpancung(jariBesar, tinggiKTerpancung, jariKecil);
                kTerpancung.setR(jariBesar);
                kTerpancung.setTinggi(tinggiKTerpancung);
                kTerpancung.setRkecil(jariKecil);
                if (jariBesar < 0 && tinggiKTerpancung < 0 && jariKecil < 0) {
                    throw new Exception(
                            "Tinggi, Jari-Jari besar, dan jari-jari kecil kerucut terpancung tidak boleh negatif");
                } else if (jariBesar < 0 && tinggiKTerpancung < 0) {
                    throw new Exception("Jari-jari besar dan tinggi kerucut terpancung tidak boleh negatif");
                } else if (jariBesar < 0 && jariKecil < 0) {
                    throw new Exception("Jari-jari besar dan kecil kerucut terpancung tidak boleh negatif");
                } else if (tinggiKTerpancung < 0 && jariKecil < 0) {
                    throw new Exception("Tinggi dan Jari-jari kecil kerucut terpancung tidak boleh negatif");
                } else if (jariBesar < 0) {
                    throw new Exception("Jari-jari besar kerucut terpancung tidak boleh negatif");
                } else if (jariKecil < 0) {
                    throw new Exception("Jari-jari kecil kerucut terpancung tidak boleh negatif");
                } else if (tinggiKTerpancung < 0) {
                    throw new Exception("Tinggi kerucut terpancung tidak boleh negatif");
                }
                isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                Long fileLength = isiFile.length();
                isiFile.seek(fileLength);
                isiFile.writeUTF("Kerucut Terpancung\n");
                isiFile.writeBytes("Jari jari Besar : " + Double.toString(jariBesar) + "\n");
                isiFile.writeBytes("Jari jari kecil : " + Double.toString(jariKecil) + "\n");
                isiFile.writeBytes("Tinggi Kerucut Terpancung : " + Double.toString(tinggiKTerpancung) + "\n");
                isiFile.writeBytes(
                        "Selimut Kerucut Terpancung : " + Double.toString(kTerpancung.hitungSelimutKerucut()) + "\n");
                isiFile.writeBytes(
                        "Volume Kerucut Terpancung : " + Double.toString(kTerpancung.hitungVolumeKerucut()) + "\n");
                isiFile.close();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into terpancung (jari_besar, jari_kecil, tinggi, luas_selimut, volume) values ("
                        + jariBesar + "," + jariKecil + ","
                        + tinggiKTerpancung + "," + kTerpancung.hitungSelimutKerucut() + ","
                        + kTerpancung.hitungVolumeKerucut() + ")";
                System.out.printf("#%d Selimut Kerucut Terpancung : %.2f\n", i, kTerpancung.hitungSelimutKerucut());
                System.out.printf("#%d Volume Kerucut Terpancung : %.2f\n\n", i, kTerpancung.hitungVolumeKerucut());
                Thread.sleep(2000);
                pst = con.prepareStatement(query);
                pst.execute();

                con.close();
                jariBesar++;

                jariKecil++;

                tinggiKTerpancung++;

            }
            System.out.println("-- DATA KERUCUT TERPANCUNG SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
