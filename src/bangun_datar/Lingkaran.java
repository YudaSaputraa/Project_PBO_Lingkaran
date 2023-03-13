package bangun_datar;

public class Lingkaran implements BangunDatar {

    public double kelilingLingkaran;
    public double luasLingkaran;
    public double r;

    public Lingkaran(double r) {
        this.r = r;
        hitungKeliling(r);
        hitungLuas(r);
    }

    @Override
    public double hitungKeliling(double r) {
        kelilingLingkaran = 2 * Math.PI * this.r;
        return kelilingLingkaran;
    }

    public int hitungKeliling() {
        kelilingLingkaran = 2 * Math.PI * this.r;
        return (int) kelilingLingkaran;
    }

    @Override
    public double hitungLuas(double r) {
        luasLingkaran = Math.PI * this.r * this.r;
        return luasLingkaran;
    }

    public int hitungLuas(int r) {
        luasLingkaran = Math.PI * this.r * this.r;
        return (int) luasLingkaran;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR(double r) {
        return r;
    }
}
