package bangun_ruang;
public class Bola extends Lingkaran {

    public Bola(double r) {
        super(r);
    }

    public double hitungLuasBola() {
        return 4 * super.luasLingkaran;

    }

    public double hitungVolumeBola() {
        return (4.0 / 3.0) * super.luasLingkaran * getR(r);
    }

}
