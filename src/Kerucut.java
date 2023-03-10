public class Kerucut extends Lingkaran {
    private double t;
    private double s;

    public Kerucut(float r, double t) {
        super(r);
        this.t = t;
        this.s = Math.sqrt(Math.pow(this.r, 2) + Math.pow(t, 2));
    }

    public double hitungLuasKerucut() {
        return super.menghitungLuasLingkaran(luasLingkaran) + (Math.PI * this.r * s);
    }

    public double hitungVolumeKerucut() {
        return 0.33 * super.menghitungLuasLingkaran(luasLingkaran) * t;
    }
}
