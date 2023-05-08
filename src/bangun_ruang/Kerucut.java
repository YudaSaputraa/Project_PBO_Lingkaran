package bangun_ruang;

import bangun_datar.*;

public class Kerucut extends Lingkaran {

    protected double sisiMiring;
    private double tinggi;

    public Kerucut(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
        hitungLuasKerucut();
        hitungVolumeKerucut();
    }

    public double hitungSisiMiring() {
        sisiMiring = Math.sqrt(Math.pow(getR(r), 2) + Math.pow(getTinggi(), 2));
        return sisiMiring;
    }

    public double hitungLuasKerucut() {
        luasKerucut = super.luasLingkaran + (Math.PI * getR(r) * hitungSisiMiring());
        return luasKerucut;
    }
    public double hitungLuasKerucut(double r) {
        luasKerucut = super.luasLingkaran + (Math.PI * getR(r) * hitungSisiMiring());
        return luasKerucut;
    }

    public double hitungVolumeKerucut() {
        volumeKerucut = (1.0 / 3.0) * super.luasLingkaran * getTinggi();
        return volumeKerucut;
    }
    public double hitungVolumeKerucut(double r) {
        volumeKerucut = (1.0 / 3.0) * super.luasLingkaran * getTinggi();
        return volumeKerucut;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }
}
