package main;

import java.io.*;
import java.sql.*;
import bangun_datar.*;

public class LingkaranThread implements Runnable {

    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geometri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    @Override
    public void run() {
        System.out.println("Thread LINGKARAN dijalnkan....");
        try {
            // System.out.print("Input Jari - Jari Lingkaran : ");
            double jariJari = 1;
            for (int i = 1; i <= 24; i++) {

                Lingkaran lingkaran = new Lingkaran(jariJari);
                lingkaran.setR(jariJari);
                if (jariJari < 0) {
                    throw new Exception("Jari-Jari tidak boleh negatif");
                }

                try {
                    isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                    isiFile.seek(0);
                    isiFile.writeUTF("Lingkaran");
                    isiFile.writeDouble(jariJari);
                    isiFile.writeDouble(lingkaran.luasLingkaran);
                    isiFile.writeDouble(lingkaran.kelilingLingkaran);

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection(url, username, pass);
                    String query = "Insert into lingkaran (jari_jari, luas, keliling) values (" + jariJari + ","
                            + lingkaran.luasLingkaran + "," + lingkaran.kelilingLingkaran + ")";
                    pst = con.prepareStatement(query);
                    pst.execute();
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
                con.close();
                jariJari++;
            }
            System.out.println("-- DATA LINGKARAN SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
