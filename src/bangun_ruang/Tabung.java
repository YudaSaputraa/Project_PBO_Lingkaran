package bangun_ruang;

import bangun_datar.*;

public class Tabung extends Lingkaran {
    private double tinggi;

    public Tabung(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;

    }

    public double hitungLuasTabung() {
        return super.kelilingLingkaran * (getR(r) + tinggi);
    }

    public double hitungVolumeTabung() {
        return super.luasLingkaran * tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}
