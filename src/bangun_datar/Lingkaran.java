package bangun_datar;

public class Lingkaran implements BangunDatar {

    public double kelilingLingkaran;
    public double luasLingkaran;
    public double r;
    public double luasTabung, volumeTabung;
    public double luasKerucut, volumeKerucut, sisiMiring;
    public double luasBola, volumeBola;

    public Lingkaran(double r) {
        this.r = r;
        hitungKeliling(r);
        hitungLuas(r);
    }

    public double hitungKeliling(double r) {
        kelilingLingkaran = 2 * Math.PI * this.r;
        return kelilingLingkaran;
    }

    public double hitungKeliling() {
        kelilingLingkaran = 2 * Math.PI * this.r;
        return kelilingLingkaran;
    }

    public double hitungLuas(double r) {
        luasLingkaran = Math.PI * this.r * this.r;
        return luasLingkaran;
    }

    public double hitungLuas() {
        luasLingkaran = Math.PI * this.r * this.r;
        return luasLingkaran;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR(double r) {
        return r;
    }

  

    public double hitungLuasTabung(double jariAlasTabung) {
        return luasTabung;
    }

    public double hitungVolumeTabung(double jariAlasTabung) {
        return volumeTabung;
    }

    public double hitungLuasKerucut() {
        return luasKerucut;
    }

    public double hitungVolumeKerucut() {
        return volumeKerucut;
    }

    public double hitungSisiMiring() {
        return sisiMiring;
    }

    public double hitungLuasBola() {

        return luasBola;

    }

    public double hitungVolumeBola() {

        return volumeBola;
    }

}
