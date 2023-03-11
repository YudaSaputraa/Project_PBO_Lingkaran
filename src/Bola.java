public class Bola extends Lingkaran {

    public Bola(double r) {
        super(r);
    }

    public double hitungLuasBola() {
        return 4 * super.luasLingkaran;

    }

    public double hitungVolumeBola() {
        return 1.33 * super.luasLingkaran;
    }

}
