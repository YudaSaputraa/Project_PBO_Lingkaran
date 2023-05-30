package main;

import bangun_ruang.*;
import java.io.*;
import java.sql.*;
import bangun_datar.*;

public class BolaThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread BOLA dijalankan....");
        try {
            double jariBola = 1;

            for (int i = 1; i <= 24; i++) {
                Lingkaran bola = new Bola(jariBola);
                bola.setR(jariBola);
                if (jariBola < 0) {
                    throw new Exception("Jari bola tidak boleh negatif");
                }

                isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                Long fileLength = isiFile.length();
                isiFile.seek(fileLength);
                isiFile.writeUTF("Bola\n");
                isiFile.writeBytes("Jari Jari Bola : " + Double.toString(jariBola) + "\n");
                isiFile.writeBytes("Luas Bola : " + Double.toString(bola.luasBola) + "\n");
                isiFile.writeBytes("Volume Bola : " + Double.toString(bola.volumeBola) + "\n\n");
                isiFile.close();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into bola (jar_jari, luas, volume) values ("
                        + jariBola + "," + bola.luasBola + ","
                        + bola.volumeBola + ")";
                System.out.printf("#%d Luas Bola : %.2f\n", i, bola.luasBola);
                System.out.printf("#%d Volume Bola: %.2f\n\n", i, bola.volumeBola);
                Thread.sleep(2000);
                pst = con.prepareStatement(query);
                pst.execute();
                con.close();
                jariBola++;
            }
            System.out.println("-- DATA BOLA SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
