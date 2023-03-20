package main;

import bangun_ruang.*;
import java.util.Scanner;
import bangun_datar.*;

public class Geometri {
    public static Scanner menu = new Scanner(System.in);
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih, back;

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
                default:
                    System.out.println("Menu tidak ada, mohon input menu yang ada ada saja!");
            }

            System.out.println("\n");
            System.out.print(" Back to Menu ? (yes : 1 || no : 0)");
            back = input.nextInt();
            System.out.print("\033[H\033[2J");
        } while (back == 1);
    }

    static void menuLingkaran() {
        System.out.println("-- LINGKARAN --");
        System.out.print("Input Jari - Jari Lingkaran : ");
        double jariJari = input.nextDouble();
        Lingkaran lingkaran = new Lingkaran(jariJari);
        lingkaran.setR(jariJari);
        System.out.println("\nOUTPUT");
        System.out.println("Luas Lingkaran 1 : " + Math.PI * Math.pow(jariJari, 2));
        System.out.println("Luas Lingkaran 2 : " + lingkaran.hitungLuas(jariJari));
        System.out.println("Luas Lingkaran 3 : " + lingkaran.luasLingkaran);
        System.out.println("keliling Lingkaran : " + 2 * Math.PI * jariJari);
        System.out.println("keliling Lingkaran : " + lingkaran.hitungKeliling(jariJari));
        System.out.println("keliling Lingkaran : " + lingkaran.kelilingLingkaran);
    }

    static void menuTabung() {
        System.out.println("-- Tabung -- ");
        System.out.print("Input Jari - Jari Alas :  ");
        double jariAlasTabung = input.nextDouble();
        System.out.print("Input Tinggi:  ");
        double tinggi = input.nextDouble();

        Lingkaran tabung = new Tabung(jariAlasTabung);
        tabung.setR(jariAlasTabung);
        System.out.println("\nOUTPUT");
        System.out.println("Luas Tabung 1 : "
                + 2 * Math.PI * tabung.getR(jariAlasTabung) * (tabung.getR(jariAlasTabung) + tinggi));
        System.out.println("Luas Tabung 2 : " + tabung.hitungLuasTabung(jariAlasTabung));
        System.out.println("Luas Tabung 3 : " + tabung.luasTabung);
        System.out.println("Volume Tabung 1: " + Math.PI * Math.pow(tabung.getR(jariAlasTabung), 2) * tinggi);
        System.out.println("Volume Tabung 2: " + tabung.hitungVolumeTabung(jariAlasTabung));
        System.out.println("Volume Tabung 3: " + tabung.volumeTabung);
    }

    static void menuKerucut() {
        System.out.println("-- KERUCUT --");
        System.out.print("Input Jari - Jari Alas : ");
        double jariAlasKerucut = input.nextDouble();
        System.out.print("Input Tinggi : ");
        double tinggiKerucut = input.nextDouble();
        Lingkaran kerucut = new Kerucut(jariAlasKerucut, tinggiKerucut);
        kerucut.setR(jariAlasKerucut);
        System.out.println("\nOUTPUT");
        System.out.println("Luas Kerucut 1 : " + (kerucut.luasLingkaran
                + (Math.PI * kerucut.getR(jariAlasKerucut) * kerucut.hitungSisiMiring())));
        System.out.println("Luas Kerucut 2 : " + kerucut.hitungLuasKerucut());
        System.out.println("Luas Kerucut 3 : " + kerucut.luasKerucut);
        System.out.println("Volume Kerucut 1 : " + (1.0 / 3.0) * kerucut.luasLingkaran * tinggiKerucut);
        System.out.println("Volume Kerucut 2 : " + kerucut.hitungVolumeKerucut());
        System.out.println("Volume Kerucut 3 : " + kerucut.volumeKerucut);
        System.out.println("Dengan Sisi Miring Kerucut adalah " + kerucut.hitungSisiMiring());
    }

    static void menuKerucutTerpancung() {
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
    }

    static void menuBola() {
        System.out.println("-- BOLA --");
        System.out.print("Input Jari- Jari Bola : ");
        double jariBola = input.nextDouble();
        Lingkaran bola = new Bola(jariBola);
        bola.setR(jariBola);
        System.out.println("\nOUTOPUT");
        System.out.println("Luas Bola 1 : " + 4.0 * (Math.PI * (jariBola * jariBola)));
        System.out.println("Luas Bola 2 : " + bola.hitungLuasBola());
        System.out.println("Luas Bola 3 : " + bola.luasBola);
        System.out.println("Volume Bola 1 : " + (4.0 / 3.0) * (Math.PI * jariBola * jariBola * jariBola));
        System.out.println("Volume Bola 2 : " + bola.hitungVolumeBola());
        System.out.println("Volume Bola 3 : " + bola.volumeBola);
    }

    static void menuJuringBola() {
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
    }

    static void menuTemberengBola() {
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
    }

    static void menuKeratanBola() {
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
    }

}
