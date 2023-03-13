package bangun_ruang;
public class Kerucut extends Lingkaran {
    protected double t;
    protected double s;

    public Kerucut(double r, double t) {
        super(r);
        this.t = t;
    }

    public double hitungSisiMiring() {
        s = Math.sqrt(Math.pow(getR(r), 2) + Math.pow(t, 2));
        return s;
    }

    public double hitungLuasKerucut() {
        return super.luasLingkaran + (Math.PI * getR(r) * hitungSisiMiring());
    }

    public double hitungVolumeKerucut() {
        return (1.0 / 3.0) * super.luasLingkaran * t;
    }
}
