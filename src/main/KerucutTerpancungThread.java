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

                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(3000);
                    isiFile.writeUTF("Kerucut Terpancung");
                    isiFile.writeDouble(jariBesar);
                    isiFile.writeDouble(jariKecil);
                    isiFile.writeDouble(tinggiKTerpancung);
                    isiFile.writeDouble(kTerpancung.hitungSelimutKerucut());
                    isiFile.writeDouble(kTerpancung.hitungVolumeKerucut());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into terpancung (jari_besar, jari_kecil, tinggi, luas_selimut, volume) values ("
                            + jariBesar + "," + jariKecil + ","
                            + tinggiKTerpancung + "," + kTerpancung.hitungSelimutKerucut() + ","
                            + kTerpancung.hitungVolumeKerucut() + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
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
