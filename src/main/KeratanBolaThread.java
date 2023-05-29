package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;

public class KeratanBolaThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread KERATAN BOLA dijalankan....");
        try {
            double jariAtas = 1;
            double jariBawah = 1;
            double tinggiKeratan = 1;
            for (int i = 1; i <= 24; i++) {
                Keratan keratan = new Keratan(jariBawah, jariAtas, tinggiKeratan);
                keratan.setR(jariBawah);
                keratan.setrAtas(jariAtas);
                keratan.setTinggi(tinggiKeratan);
                if (jariBawah < 0 && jariAtas < 0 && tinggiKeratan < 0) {
                    throw new Exception("Tinggi, Jari-Jari atas, dan jari-jari bawah keratan bola tidak boleh negatif");
                } else if (jariBawah < 0 && jariAtas < 0) {
                    throw new Exception("Jari-jari bawah dan atas keratan bola tidak boleh negatif");
                } else if (jariBawah < 0 && tinggiKeratan < 0) {
                    throw new Exception("Jari-jari bawah dan tinggi keratan bola tidak boleh negatif");
                } else if (jariAtas < 0 && tinggiKeratan < 0) {
                    throw new Exception("Jari-jari atas dan tinggi keratan bola tidak boleh negatif");
                } else if (jariBawah < 0) {
                    throw new Exception("Jari-jari bawah keratan bola tidak boleh negatif");
                } else if (jariAtas < 0) {
                    throw new Exception("Jari-jari atas keratan bola tidak boleh negatif");
                } else if (tinggiKeratan < 0) {
                    throw new Exception("Tinggi keratan bola tidak boleh negatif");
                }

                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(7000);
                    isiFile.writeUTF("Keratan Bola");
                    isiFile.writeDouble(keratan.hitungLuasKeratanBola());
                    isiFile.writeDouble(keratan.hitungVolumeKeratanBola());
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into keratan (jari_atas, jari_bawah, tinggi, volume, luas) values ("
                            + jariAtas + "," + jariBawah + "," + tinggiKeratan + ","
                            + keratan.hitungVolumeKeratanBola() + ","
                            + keratan.hitungLuasKeratanBola() + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();

                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
                con.close();
                jariAtas++;
                jariBawah++;
                tinggiKeratan++;
            }
            System.out.println("-- DATA KERATAN BOLA SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}