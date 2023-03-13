package bangun_ruang;

public class KerucutTerpancung extends Kerucut {

    private double rkecil;

    public double getRkecil() {
        return rkecil;
    }

    public void setRkecil(double rkecil) {
        this.rkecil = rkecil;
    }

    public KerucutTerpancung(double r, double t, double rkecil) {
        super(r, t);
        this.rkecil = rkecil;
    }

    @Override
    public double hitungSisiMiring() {
        sisiMiring = Math.sqrt(Math.pow(getR(r) - this.rkecil, 2) + Math.pow(tinggi, 2));
        return sisiMiring;
    }

    public double hitungSelimutKerucut() {
        return Math.PI * (getR(r) + rkecil) * hitungSisiMiring();
    }

    @Override
    public double hitungVolumeKerucut() {
        return (1.0 / 3.0) * Math.PI * tinggi * (getR(r) * rkecil + Math.pow(getR(r), 2) + Math.pow(rkecil, 2));
    }

}
