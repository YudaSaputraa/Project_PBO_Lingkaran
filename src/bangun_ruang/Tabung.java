package bangun_ruang;

import bangun_datar.*;

public class Tabung extends Lingkaran {

    private double tinggi;

    public Tabung(double r) {
        super(r);
        hitungLuasTabung(r);
        hitungVolumeTabung(r);

    }

    public double hitungLuasTabung() {
        luasTabung = super.kelilingLingkaran * (getR(r) + getTinggi());
        return luasTabung;
    }

    public double hitungLuasTabung(double r) {
        luasTabung = super.kelilingLingkaran * (getR(r) + getTinggi());
        return luasTabung;
    }

    public double hitungVolumeTabung() {

        volumeTabung = super.luasLingkaran * getTinggi();
        return volumeTabung;
    }

    public double hitungVolumeTabung(double r) {

        volumeTabung = super.luasLingkaran * getTinggi();
        return volumeTabung;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

}
