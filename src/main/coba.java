package main;

import java.io.IOException;
import java.io.RandomAccessFile;

public class coba {
    public static void main(String[] args) {
        String filePath = "data.txt";
        double dataToInsert = 3.15;

        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            long fileLength = file.length();

            file.seek(fileLength); // Pindah ke akhir file

            // Menulis data double ke file
            file.writeBytes(Double.toString(dataToInsert));
            file.writeBytes(System.lineSeparator());

            file.close();
            System.out.println("Data berhasil disisipkan ke dalam file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}