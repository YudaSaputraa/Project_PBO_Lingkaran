package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;
import bangun_datar.*;

public class TabungThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread TABUNG dijalankan....");
        try {
            double jariAlasTabung = 1;
            double tinggi = 1;
            for (int i = 1; i <= 24; i++) {

                Lingkaran tabung = new Tabung(jariAlasTabung, tinggi);
                tabung.setR(jariAlasTabung);
                if (jariAlasTabung < 0 && tinggi < 0) {
                    throw new Exception("Jari-Jari dan tinggi tabung tidak boleh negatif");
                } else if (jariAlasTabung < 0) {
                    throw new Exception("Jari-Jari tabung tidak boleh negatif");
                } else if (tinggi < 0) {
                    throw new Exception("Tinggi tabung tidak boleh negatif");
                }

                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(1000);
                    isiFile.writeUTF("Tabung");
                    isiFile.writeDouble(jariAlasTabung);
                    isiFile.writeDouble(tinggi);
                    isiFile.writeDouble(tabung.luasTabung);
                    isiFile.writeDouble(tabung.volumeTabung);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into tabung (jari_jari, tinggi,luas_alas, volume) values (" + jariAlasTabung
                            + ","
                            + tinggi + "," + tabung.luasTabung + "," + tabung.volumeTabung + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
                con.close();
                jariAlasTabung++;
                tinggi++;
            }
            System.out.println("-- DATA TABUNG SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}