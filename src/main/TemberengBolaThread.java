package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;

public class TemberengBolaThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread TEMBERENG BOLA dijalankan....");
        try {
            double jariTembereng = 1;
            double jarakBidang = 1;
            for (int i = 1; i <= 24; i++) {
                Tembereng tembereng = new Tembereng(jariTembereng, jarakBidang);
                tembereng.setJrkBidang(jarakBidang);
                tembereng.setR(jariTembereng);
                if (jarakBidang < 0 && jariTembereng < 0) {
                    throw new Exception("Jari-Jari tembereng dan jarak bidang tidak boleh negatif");
                } else if (jariTembereng < 0) {
                    throw new Exception("Jari-Jari tembereng tidak boleh negatif");
                } else if (jarakBidang < 0) {
                    throw new Exception("jarak bidang tidak boleh negatif");
                }

                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(6000);
                    isiFile.writeUTF("Tembereng Bola");
                    isiFile.writeDouble(tembereng.getTheta());
                    isiFile.writeDouble(tembereng.hitungLuasTemberengBola());
                    isiFile.writeDouble(tembereng.hitungVolumeTemberengBola());
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into tembereng (jari_jari, jarak_bidang, luas, volume, tetha) values ("
                            + jariTembereng + "," + jarakBidang + "," + tembereng.hitungLuasTemberengBola() + ","
                            + tembereng.hitungVolumeTemberengBola() + ","
                            + tembereng.getTheta() + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();

                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
                con.close();
                jariTembereng++;
                jarakBidang++;
            }
            System.out.println("-- DATA TEMBERENG BOLA SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
