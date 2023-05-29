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
                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(4000);
                    isiFile.writeUTF("Bola");
                    isiFile.writeDouble(jariBola);
                    isiFile.writeDouble(bola.luasBola);
                    isiFile.writeDouble(bola.volumeBola);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into bola (jar_jari, luas, volume) values ("
                            + jariBola + "," + bola.luasBola + ","
                            + bola.volumeBola + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();

                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
                con.close();
                jariBola++;
            }
            System.out.println("-- DATA BOLA SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
