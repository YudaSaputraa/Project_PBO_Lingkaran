public class KerucutTerpancung extends Kerucut {
    private double rkecil;

    public KerucutTerpancung(double r, double t, double rkecil) {
        super(r, t);
        this.rkecil = rkecil;
    }

    @Override
    public double hitungSisiMiring() {
        s = Math.sqrt(Math.pow(r - this.rkecil, 2) + Math.pow(t, 2));
        return s;
    }

    public double hitungSelimutKerucut() {
        return Math.PI * (r + rkecil) * hitungSisiMiring();
    }

    @Override
    public double hitungVolumeKerucut() {
        return (1.0 / 3.0) * Math.PI * t * (r * rkecil + Math.pow(r, 2) + Math.pow(rkecil, 2));
    }
}
