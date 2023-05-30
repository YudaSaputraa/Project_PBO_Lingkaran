package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;
import bangun_datar.*;

public class KerucutThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread KERUCUT dijalankan....");
        try {
            Thread.currentThread().setName("Kerucut Thread-");
            double jariAlasKerucut = 1;
            double tinggiKerucut = 1;

            for (int i = 1; i <= 10; i++) {
                Lingkaran kerucut = new Kerucut(jariAlasKerucut, tinggiKerucut);
                kerucut.setR(jariAlasKerucut);
                if (jariAlasKerucut < 0 && tinggiKerucut < 0) {
                    throw new Exception("Jari-Jari alas dan tinggi kerucut tidak boleh negatif");
                } else if (jariAlasKerucut < 0) {
                    throw new Exception("Jari-jari alas kerucut tidak boleh negatif");
                } else if (tinggiKerucut < 0) {
                    throw new Exception("Tinggi kerucut tidak boleh negatif");
                }
                isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                Long fileLength = isiFile.length();
                isiFile.seek(fileLength);
                isiFile.writeUTF("Kerucut\n");
                isiFile.writeBytes("Jari Alas Kerucut : " + Double.toString(jariAlasKerucut) + "\n");
                isiFile.writeBytes("Tinggi Kerucut : " + Double.toString(tinggiKerucut) + "\n");
                isiFile.writeBytes("Luas Kerucut : " + Double.toString(kerucut.luasKerucut) + "\n");
                isiFile.writeBytes("Volume Kerucut : " + Double.toString(kerucut.volumeKerucut) + "\n");
                isiFile.close();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into kerucut (jari_jari, tinggi, luas_kerucut, volume_kerucut) values ("
                        + jariAlasKerucut
                        + ","
                        + tinggiKerucut + "," + kerucut.luasKerucut + "," + kerucut.volumeKerucut + ")";
                // System.out.println(Thread.currentThread().getName() + "#" + i);
                System.out.printf(Thread.currentThread().getName() + "#" + i + "\n" + "Luas Kerucut : %.2f\n",
                        kerucut.luasKerucut);
                System.out.printf("Volume Kerucut : %.2f\n\n", kerucut.volumeKerucut);

                Thread.sleep(1000);
                pst = con.prepareStatement(query);
                pst.execute();

                con.close();
                jariAlasKerucut++;
                tinggiKerucut++;

            }
            System.out.println("-- DATA KERUCUT SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
