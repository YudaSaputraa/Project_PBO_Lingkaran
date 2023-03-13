package bangun_ruang;

import bangun_datar.*;

public class Kerucut extends Lingkaran {
    protected double tinggi;
    protected double sisiMiring;

    public Kerucut(double r, double tinggi) {
        super(r);
        this.tinggi = tinggi;
    }

    public double hitungSisiMiring() {
        sisiMiring = Math.sqrt(Math.pow(getR(r), 2) + Math.pow(tinggi, 2));
        return sisiMiring;
    }

    public double hitungLuasKerucut() {
        return super.getHitungLuas() + (Math.PI * getR(r) * hitungSisiMiring());
    }

    public double hitungVolumeKerucut() {
        return (1.0 / 3.0) * super.getHitungLuas() * tinggi;
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
