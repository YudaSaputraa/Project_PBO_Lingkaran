package main;

import bangun_ruang.*;

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import bangun_datar.*;

public class Geometri {
    public static Scanner menu = new Scanner(System.in);
    public static Scanner input = new Scanner(System.in);
    static RandomAccessFile isiFile = null;
    static Connection con;
    static PreparedStatement pst;
    PreparedStatement pst2;
    private final static String url = "jdbc:mysql://localhost:3306/geomteri?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String username = "root";
    private final static String pass = "";

    public static void main(String[] args) {

        // String dirFile = "D:\\File Java\\FilePlanet.txt";
        try {
            isiFile = new RandomAccessFile("lingkaran.txt", "rw");
            isiFile.seek(0);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            System.err.println("Terjadi IOException");
        }
        int pilih, back;
        try {
            do {

                System.out.println("\n--- PROGRAM BANGUN RUANG DAN BANGUN DATAR ---");
                System.out.println("MENU : ");
                System.out.println("1. Lingkaran");
                System.out.println("2. Tabung");
                System.out.println("3. Kerucut");
                System.out.println("4. Kerucut Terpancung");
                System.out.println("5. Bola");
                System.out.println("6. Juring Bola");
                System.out.println("7. Tembereng Bola");
                System.out.println("8. Keratan Bola");
                System.out.println("9. Threading");
                System.out.println("0. Exit");
                System.out.print("\nPilih Menu : ");
                pilih = menu.nextInt();

                switch (pilih) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        menuLingkaran();
                        break;
                    case 2:
                        menuTabung();
                        break;
                    case 3:
                        menuKerucut();
                        break;
                    case 4:
                        menuKerucutTerpancung();
                        break;
                    case 5:
                        menuBola();
                        break;
                    case 6:
                        menuJuringBola();
                        break;
                    case 7:
                        menuTemberengBola();
                        break;
                    case 8:
                        menuKeratanBola();
                        break;
                    case 9:
                        System.out.println("Menu Threading");
                    default:
                        System.out.println("Menu tidak ada, mohon input menu yang ada ada saja!");
                }
                System.out.println("\n");
                System.out.print(" Back to Menu ? (yes : 1 || no : 0)");
                back = input.nextInt();
                if (back != 0 || back != 1) {
                }
                System.out.print("\033[H\033[2J");
            } while (back == 1);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    static void menuLingkaran() {

        System.out.println("-- LINGKARAN --");
        try {
            System.out.print("Input Jari - Jari Lingkaran : ");
            double jariJari = input.nextDouble();
            Lingkaran lingkaran = new Lingkaran(jariJari);
            lingkaran.setR(jariJari);
            if (jariJari < 0) {
                throw new Exception("Jari-Jari tidak boleh negatif");
            }
            System.out.println("\nOUTPUT");
            System.out.println("Luas Lingkaran 1 : " + Math.PI * Math.pow(jariJari, 2));
            System.out.println("Luas Lingkaran 2 : " + lingkaran.hitungLuas(jariJari));
            System.out.println("Luas Lingkaran 3 : " + lingkaran.luasLingkaran);
            System.out.println("keliling Lingkaran : " + 2 * Math.PI * jariJari);
            System.out.println("keliling Lingkaran : " + lingkaran.hitungKeliling(jariJari));
            System.out.println("keliling Lingkaran : " + lingkaran.kelilingLingkaran);
            try {
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
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    static void menuTabung() {

        System.out.println("-- Tabung -- ");
        try {
            System.out.print("Input Jari - Jari Alas :  ");
            double jariAlasTabung = input.nextDouble();
            System.out.print("Input Tinggi:  ");
            double tinggi = input.nextDouble();

            Lingkaran tabung = new Tabung(jariAlasTabung, tinggi);
            tabung.setR(jariAlasTabung);
            if (jariAlasTabung < 0 && tinggi < 0) {
                throw new Exception("Jari-Jari dan tinggi tabung tidak boleh negatif");
            } else if (jariAlasTabung < 0) {
                throw new Exception("Jari-Jari tabung tidak boleh negatif");
            } else if (tinggi < 0) {
                throw new Exception("Tinggi tabung tidak boleh negatif");
            }
            System.out.println("\nOUTPUT");
            System.out.println("Luas Tabung 1 : "
                    + 2 * Math.PI * tabung.getR(jariAlasTabung) * (tabung.getR(jariAlasTabung) + tinggi));
            System.out.println("Luas Tabung 2 : " + tabung.hitungLuasTabung(jariAlasTabung));
            System.out.println("Luas Tabung 3 : " + tabung.luasTabung);
            System.out.println("Volume Tabung 1: " + Math.PI * Math.pow(tabung.getR(jariAlasTabung), 2) * tinggi);
            System.out.println("Volume Tabung 2: " + tabung.hitungVolumeTabung(jariAlasTabung));
            System.out.println("Volume Tabung 3: " + tabung.volumeTabung);

            try {
                isiFile.seek(125);
                isiFile.writeUTF("Tabung");
                isiFile.writeDouble(jariAlasTabung);
                isiFile.writeDouble(tinggi);
                isiFile.writeDouble(tabung.luasTabung);
                isiFile.writeDouble(tabung.volumeTabung);
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into tabung (jari_jari, tinggi,luas_alas, volume) values (" + jariAlasTabung
                        + ","
                        + tinggi + "," + tabung.luasTabung + "," + tabung.volumeTabung + ")";
                pst = con.prepareStatement(query);
                pst.execute();
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    static void menuKerucut() {
        System.out.println("-- KERUCUT --");
        try {
            System.out.print("Input Jari - Jari Alas : ");
            double jariAlasKerucut = input.nextDouble();
            System.out.print("Input Tinggi : ");
            double tinggiKerucut = input.nextDouble();
            Lingkaran kerucut = new Kerucut(jariAlasKerucut, tinggiKerucut);
            kerucut.setR(jariAlasKerucut);
            if (jariAlasKerucut < 0 && tinggiKerucut < 0) {
                throw new Exception("Jari-Jari alas dan tinggi kerucut tidak boleh negatif");
            } else if (jariAlasKerucut < 0) {
                throw new Exception("Jari-jari alas kerucut tidak boleh negatif");
            } else if (tinggiKerucut < 0) {
                throw new Exception("Tinggi kerucut tidak boleh negatif");
            }
            System.out.println("\nOUTPUT");
            System.out.println("Luas Kerucut 1 : " + (kerucut.luasLingkaran
                    + (Math.PI * kerucut.getR(jariAlasKerucut) * kerucut.hitungSisiMiring())));
            System.out.println("Luas Kerucut 2 : " + kerucut.hitungLuasKerucut(jariAlasKerucut));
            System.out.println("Luas Kerucut 3 : " + kerucut.luasKerucut);
            System.out.println("Volume Kerucut 1 : " + (1.0 / 3.0) * kerucut.luasLingkaran * tinggiKerucut);
            System.out.println("Volume Kerucut 2 : " + kerucut.hitungVolumeKerucut(jariAlasKerucut));
            System.out.println("Volume Kerucut 3 : " + kerucut.volumeKerucut);
            System.out.println("Dengan Sisi Miring Kerucut adalah " + kerucut.hitungSisiMiring());
            try {
                isiFile.seek(250);
                isiFile.writeUTF("Kerucut");
                isiFile.writeDouble(jariAlasKerucut);
                isiFile.writeDouble(tinggiKerucut);
                isiFile.writeDouble(kerucut.luasKerucut);
                isiFile.writeDouble(kerucut.volumeKerucut);
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into kerucut (jari_jari, tinggi, luas_kerucut, volume_kerucut) values ("
                        + jariAlasKerucut
                        + ","
                        + tinggiKerucut + "," + kerucut.luasKerucut + "," + kerucut.volumeKerucut + ")";
                pst = con.prepareStatement(query);
                pst.execute();

            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    static void menuKerucutTerpancung() {
        System.out.println("-- KERUCUT TERPANCUNG --");
        try {
            System.out.print("Input Jari - Jari Besar : ");
            double jariBesar = input.nextDouble();
            System.out.print("Input Jari - Jari Kecil : ");
            double jariKecil = input.nextDouble();
            System.out.print("Input Tinggi : ");
            double tinggiKTerpancung = input.nextDouble();
            KerucutTerpancung kTerpancung = new KerucutTerpancung(jariBesar, tinggiKTerpancung, jariKecil);
            kTerpancung.setR(jariBesar);
            kTerpancung.setTinggi(tinggiKTerpancung);
            kTerpancung.setRkecil(jariKecil);
            if (jariBesar < 0 && tinggiKTerpancung < 0 && jariKecil < 0) {
                throw new Exception(
                        "Tinggi, Jari-Jari besar, dan jari-jari kecil kerucut terpancung tidak boleh negatif");
            } else if (jariBesar < 0 && tinggiKTerpancung < 0) {
                throw new Exception("Jari-jari besar dan tinggi kerucut terpancung tidak boleh negatif");
            } else if (jariBesar < 0 && jariKecil < 0) {
                throw new Exception("Jari-jari besar dan kecil kerucut terpancung tidak boleh negatif");
            } else if (tinggiKTerpancung < 0 && jariKecil < 0) {
                throw new Exception("Tinggi dan Jari-jari kecil kerucut terpancung tidak boleh negatif");
            } else if (jariBesar < 0) {
                throw new Exception("Jari-jari besar kerucut terpancung tidak boleh negatif");
            } else if (jariKecil < 0) {
                throw new Exception("Jari-jari kecil kerucut terpancung tidak boleh negatif");
            } else if (tinggiKTerpancung < 0) {
                throw new Exception("Tinggi kerucut terpancung tidak boleh negatif");
            }
            System.out.println("\nOUTPUT");
            System.out.println("Selimut Kerucut Terpancung : " + kTerpancung.hitungSelimutKerucut());
            System.out.println("Volume kerucut Terpancung : " + kTerpancung.hitungVolumeKerucut());
            try {
                isiFile.seek(375);
                isiFile.writeUTF("Kerucut Terpancung");
                isiFile.writeDouble(jariBesar);
                isiFile.writeDouble(jariKecil);
                isiFile.writeDouble(tinggiKTerpancung);
                isiFile.writeDouble(kTerpancung.hitungSelimutKerucut());
                isiFile.writeDouble(kTerpancung.hitungVolumeKerucut());

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, username, pass);
                String query = "Insert into terpancung (jari_besar, jari_kecil, tinggi, luas_selimut, volume) values ("
                        + jariBesar + "," + jariKecil + ","
                        + tinggiKTerpancung + "," + kTerpancung.hitungSelimutKerucut() + ","
                        + kTerpancung.hitungVolumeKerucut() + ")";
                pst = con.prepareStatement(query);
                pst.execute();
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    static void menuBola() {
        System.out.println("-- BOLA --");
        try {
            System.out.print("Input Jari- Jari Bola : ");
            double jariBola = input.nextDouble();
            Lingkaran bola = new Bola(jariBola);
            bola.setR(jariBola);
            if (jariBola < 0) {
                throw new Exception("Jari bola tidak boleh negatif");
            }
            System.out.println("\nOUTOPUT");
            System.out.println("Luas Bola 1 : " + 4.0 * (Math.PI * (jariBola * jariBola)));
            System.out.println("Luas Bola 2 : " + bola.hitungLuasBola(jariBola));
            System.out.println("Luas Bola 3 : " + bola.luasBola);
            System.out.println("Volume Bola 1 : " + (4.0 / 3.0) * (Math.PI * jariBola * jariBola * jariBola));
            System.out.println("Volume Bola 2 : " + bola.hitungVolumeBola(jariBola));
            System.out.println("Volume Bola 3 : " + bola.volumeBola);
            try {
                isiFile.seek(500);
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
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    static void menuJuringBola() {
        System.out.println("-- JURING BOLA --");
        try {
            System.out.print("Input Jari - Jari Juring :  ");
            double jariJuring = input.nextDouble();
            System.out.print("Input Sudut Juring : ");
            double sudut = input.nextDouble();
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
            System.out.println("\nOUTPUT");
            System.out.println("Luas Juring Bola : " + juring.hitungLuasJuring());
            System.out.println("Volume Juring Bola : " + juring.hitungVolumeJuring());
            System.out.println("Dengan Theta dari juring adalah " + juring.getTheta());
            try {
                isiFile.seek(625);
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
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    static void menuTemberengBola() {
        System.out.println("-- TEMBERENG BOLA --");
        try {
            System.out.print("Input Jari - Jari Tembereng : ");
            double jariTembereng = input.nextDouble();
            System.out.print("Input Jarak Bidang : ");
            double jarakBidang = input.nextDouble();
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
            System.out.println("\nOUTPUT");
            System.out.println("Luas Tembereng : " + tembereng.hitungLuasTemberengBola());
            System.out.println("Volume Tembereng : " + tembereng.hitungVolumeTemberengBola());
            System.out.println("Dengan Theta dari Tembereng adalah " + tembereng.getTheta());
            try {
                isiFile.seek(750);
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
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    static void menuKeratanBola() {
        System.out.println("-- KERATAN BOLA --");
        try {
            System.out.print("Input Jari - Jari Atas : ");
            double jariAtas = input.nextDouble();
            System.out.print("Input Jari - Jari Bawah : ");
            double jariBawah = input.nextDouble();
            System.out.print("Input Tinggi Keratan : ");
            double tinggiKeratan = input.nextDouble();
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
            System.out.println("\nOUTPUT");
            System.out.println("Luas Keratan Bola : " + keratan.hitungLuasKeratanBola());
            System.out.println("Volume Keratan Bola : " + keratan.hitungVolumeKeratanBola());
            try {
                isiFile.seek(875);
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
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

}
