public class Bola extends Lingkaran {

    public Bola(float r) {
        super(r);
    }

    public double hitungLuasBola() {
        return 4 * super.menghitungLuasLingkaran(luasLingkaran);

    }

    public double hitungVolumeBola() {
        return 1.33 * menghitungLuasLingkaran(luasLingkaran);
    }

}
