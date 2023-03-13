package main;

import bangun_ruang.*;

import java.util.Scanner;

import bangun_datar.*;

public class Geometri {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int pilih, back;

        do {
            System.out.println("--- PROGAM BANGUN RUANG DAN BANGUN DATAR ---");
            System.out.println("MENU : ");
            System.out.println("1. Lingkaran");
            System.out.println("2. Tabung");
            System.out.println("3. Kerucut");
            System.out.println("4. Kerucut Terpancung");
            System.out.println("5. Bola");
            System.out.println("6. Juring Bola");
            System.out.println("7. Tembereng Bola");
            System.out.println("8. Keratan Bola");
            System.out.println("0. Exit");
            System.out.print("\nPilih Menu : ");
            pilih = menu.nextInt();

            switch (pilih) {

                case 1:
                    System.out.println("-- LINGKARAN --");
                    System.out.print("Input Jari - Jari Lingkaran : ");
                    double jariJari = input.nextDouble();
                    Lingkaran lingkaran = new Lingkaran(jariJari);
                    lingkaran.setR(jariJari);
                    System.out.println("\nOUTPUT");
                    System.out.println("Luas Lingkaran : " + lingkaran.hitungLuas((double) jariJari));
                    break;
                case 2:
                    System.out.println("-- Tabung -- ");
                    System.out.print("Input Jari - Jari Alas :  ");
                    double jariAlasTabung = input.nextDouble();
                    System.out.print("Input Tinggi:  ");
                    double tinggi = input.nextDouble();
                    Tabung tabung = new Tabung(jariAlasTabung, tinggi);
                    tabung.setR(jariAlasTabung);
                    tabung.setR(tinggi);
                    System.out.println("\nOUTPUT");
                    System.out.println("Luas Tabung : " + tabung.hitungLuasTabung());
                    System.out.println("Volume Tabung : " + tabung.hitungVolumeTabung());
                    break;
                case 3:
                    System.out.println("-- KERUCUT --");
                    System.out.print("Input Jari - Jari Alas : ");
                    double jariAlasKerucut = input.nextDouble();
                    System.out.print("Input Tinggi : ");
                    double tinggiKerucut = input.nextDouble();
                    Kerucut kerucut = new Kerucut(jariAlasKerucut, tinggiKerucut);
                    kerucut.setR(jariAlasKerucut);
                    kerucut.setTinggi(tinggiKerucut);
                    System.out.println("\nOUTPUT");
                    System.out.println("Luas Kerucut : " + kerucut.hitungLuasKerucut());
                    System.out.println("Volume Kerucut : " + kerucut.hitungVolumeKerucut());
                    System.out.println("Dengan Sisi Miring Tabung adalah " + kerucut.getSisiMiring());
                    break;
                case 4:
                    System.out.println("-- KERUCUT TERPANCUNG --");
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
                    System.out.println("\nOUTPUT");
                    System.out.println("Selimut Kerucut Terpancung : " + kTerpancung.hitungSelimutKerucut());
                    System.out.println("Volume kerucut Terpancung : " + kTerpancung.hitungVolumeKerucut());
                    break;
                case 5:
                    System.out.println("-- BOLA --");
                    System.out.print("Input Jari- Jari Bola : ");
                    double jariBola = input.nextDouble();
                    Bola bola = new Bola(jariBola);
                    bola.setR(jariBola);
                    System.out.println("\nOUTOPUT");
                    System.out.println("Luas Bola : " + bola.hitungLuasBola());
                    System.out.println("Volume Bola : " + bola.hitungVolumeBola());
                    break;
                case 6:
                    System.out.println("-- JURING BOLA --");
                    System.out.print("Input Jari - Jari Juring :  ");
                    double jariJuring = input.nextDouble();
                    System.out.print("Input Sudut Juring : ");
                    double sudut = input.nextDouble();
                    Juring juring = new Juring(jariJuring, sudut);
                    juring.setR(jariJuring);
                    juring.setSudut(sudut);
                    System.out.println("\nOUTPUT");
                    System.out.println("Luas Juring Bola : " + juring.hitungLuasJuring());
                    System.out.println("Volume Juring Bola : " + juring.hitungVolumeJuring());
                    System.out.println("Dengan Theta dari juring adalah " + juring.getTheta());
                    break;
                case 7:
                    System.out.println("-- TEMBERENG BOLA --");
                    System.out.print("Input Jari - Jari Tembereng : ");
                    double jariTembereng = input.nextDouble();
                    System.out.print("Input Jarak Bidang : ");
                    double jarakBidang = input.nextDouble();
                    Tembereng tembereng = new Tembereng(jariTembereng, jarakBidang);
                    tembereng.setJrkBidang(jarakBidang);
                    tembereng.setR(jariTembereng);
                    System.out.println("\nOUTPUT");
                    System.out.println("Luas Tembereng : " + tembereng.hitungLuasTemberengBola());
                    System.out.println("Volume Tembereng : " + tembereng.hitungVolumeTemberengBola());
                    System.out.println("Dengan Theta dari Tembereng adalah " + tembereng.getTheta());
                    break;
                case 8:
                    System.out.println("-- KERATAN BOLA --");
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
                    System.out.println("\nOUTPUT");
                    System.out.println("Luas Keratan Bola : " + keratan.hitungLuasKeratanBola());
                    System.out.println("Volume Keratan Bola : " + keratan.hitungVolumeKeratanBola());
                    break;
                default:
                    System.out.println("Menu tidak ada, mohon input menu yang ada ada saja!");
            }

            System.out.println("\n");
            System.out.print(" Back to Menu ? (yes : 1 || no : 0)");
            back = input.nextInt();
            System.out.print("\033[H\033[2J");
        } while (back == 1);
    }

}
