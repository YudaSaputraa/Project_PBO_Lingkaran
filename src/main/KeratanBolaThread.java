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
            Thread.currentThread().setName("Keratan Bola Thread-");
            double jariAtas = 1;
            double jariBawah = 1;
            double tinggiKeratan = 1;

            for (int i = 1; i <= 10; i++) {
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

                isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                Long fileLength = isiFile.length();
                isiFile.seek(fileLength);
                isiFile.writeUTF("Keratan Bola\n");
                isiFile.writeBytes("Luas Keratan Bola : " + Double.toString(keratan.hitungLuasKeratanBola()) + "\n");
                isiFile.writeBytes(
                        "Volume Keratan Bola : " + Double.toString(keratan.hitungVolumeKeratanBola()) + "\n\n");
                isiFile.close();
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into keratan (jari_atas, jari_bawah, tinggi, volume, luas) values ("
                        + jariAtas + "," + jariBawah + "," + tinggiKeratan + ","
                        + keratan.hitungVolumeKeratanBola() + ","
                        + keratan.hitungLuasKeratanBola() + ")";

                // System.out.println(Thread.currentThread().getName() + "#" + i);
                System.out.printf(Thread.currentThread().getName() + "#" + i + "\n" + "Luas Keratan Bola : %.2f\n",
                        keratan.hitungLuasKeratanBola());
                System.out.printf("Volume Keratan Bola : %.2f\n\n", keratan.hitungVolumeKeratanBola());
                Thread.sleep(1000);
                pst = con.prepareStatement(query);
                pst.execute();
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
