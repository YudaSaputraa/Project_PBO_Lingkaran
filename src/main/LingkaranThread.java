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
    // double x = 1 / 0;

    @Override
    public void run() {
        System.out.println("Thread LINGKARAN dijalankan....");
        try {
            Thread.currentThread().setName("Lingkaran Thread-");
            // System.out.print("Input Jari - Jari Lingkaran : ");
            double jariJari = 1;
            int i;
            // System.out.println(x);
            for (i = 1; i <= 10; i++) {

                Lingkaran lingkaran = new Lingkaran(jariJari);
                lingkaran.setR(jariJari);
                if (jariJari < 0) {
                    throw new Exception("Jari-Jari tidak boleh negatif");
                }

                isiFile = new RandomAccessFile("lingkaran.txt", "rw");
                Long fileLength = isiFile.length();
                isiFile.seek(fileLength);
                isiFile.writeUTF("Lingkaran\n");
                isiFile.writeBytes("Jari Jari : " + Double.toString(jariJari) + "\n");
                isiFile.writeBytes("Luas Lingkaran : " + Double.toString(lingkaran.luasLingkaran) + "\n");
                isiFile.writeBytes("Keliling Lingkaran : " + Double.toString(lingkaran.kelilingLingkaran) + "\n\n");
                isiFile.close();

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into lingkaran (jari_jari, luas, keliling) values (" + jariJari + ","
                        + lingkaran.luasLingkaran + "," + lingkaran.kelilingLingkaran + ")";

                // System.out.println(Thread.currentThread().getName() + "#" + i);
                System.out.printf(Thread.currentThread().getName() + "#" + i + "\n" + "Luas Lingkaran : %.2f\n",
                        lingkaran.luasLingkaran);
                System.out.printf("Keliling Lingkaran : %.2f\n\n", lingkaran.kelilingLingkaran);
                Thread.sleep(1000);
                pst = con.prepareStatement(query);
                pst.execute();

                con.close();
                jariJari++;

            }
            System.out.println("-- DATA LINGKARAN SELESAI DIBUAT --");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
