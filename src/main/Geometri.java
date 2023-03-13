package main;

import bangun_ruang.Tabung;

public class Geometri {
    public static void main(String[] args) {

        Tabung tt = new Tabung(10, 10);
        System.out.println(tt.hitungLuasTabung());
        System.out.println(tt.hitungVolumeTabung());
    }
}
