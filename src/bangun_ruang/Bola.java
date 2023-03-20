package bangun_ruang;

import bangun_datar.*;

public class Bola extends Lingkaran {

    public Bola(double r) {
        super(r);
        hitungLuasBola();
        hitungVolumeBola();
    }

    public double hitungLuasBola() {
        luasBola = 4.0 * super.luasLingkaran;
        return luasBola;

    }

    public double hitungVolumeBola() {
        volumeBola = (4.0 / 3.0) * super.luasLingkaran * getR(r);
        return volumeBola;
    }

}
