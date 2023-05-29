package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;

public class JuringThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread JURING BOLA dijalankan....");
        try {
            double jariJuring = 1;
            double sudut = 1;
            for (int i = 1; i <= 24; i++) {
                Juring juring = new Juring(jariJuring, sudut);
                juring.setR(jariJuring);
                juring.setSudut(sudut);
                if (jariJuring < 0 && sudut < 0) {
                    throw new Exception("Jari-Jari juring dan sudut tidak boleh negatif");
                } else if (jariJuring < 0) {
                    throw new Exception("Jari-Jari juring tidak boleh negatif");
                } else if (sudut < 0) {
                    throw new Exception("Sudut juring tidak boleh negatif");
                }

                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(5000);
                    isiFile.writeUTF("Juring Bola");
                    isiFile.writeDouble(juring.getTheta());
                    isiFile.writeDouble(juring.hitungLuasJuring());
                    isiFile.writeDouble(juring.hitungVolumeJuring());
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into juring (jari_jari, luas, volume, tetha) values ("
                            + jariJuring + "," + juring.hitungLuasJuring() + "," + juring.hitungVolumeJuring() + ","
                            + juring.getTheta() + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();

                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
                con.close();
                jariJuring++;
                sudut++;
            }
            System.out.println("-- DATA JURING BOLA SELESAI DIBUAT --");

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
