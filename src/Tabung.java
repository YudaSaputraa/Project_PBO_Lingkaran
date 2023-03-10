public class Tabung extends Lingkaran {
    private double t = 0;

    public Tabung(float r, double t) {
        super(r);
        this.t = t;

    }

    public double hitungLuasTabung() {
        return super.menghitungKelilingLingkaran(kelilingLingkaran) * (this.r + t);
    }

    public double hitungVolumeTabung() {
        return super.menghitungLuasLingkaran(luasLingkaran) * t;
    }
}
