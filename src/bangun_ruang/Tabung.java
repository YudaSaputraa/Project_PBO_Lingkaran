package bangun_ruang;
public class Tabung extends Lingkaran {
    private double t = 0;

    public Tabung(double r, double t) {
        super(r);
        this.t = t;

    }

    public double hitungLuasTabung() {
        return super.kelilingLingkaran * (getR(r) + t);
    }

    public double hitungVolumeTabung() {
        return super.luasLingkaran * t;
    }
}
