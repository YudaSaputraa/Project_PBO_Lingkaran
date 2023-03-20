package bangun_ruang;

public class Keratan extends Bola {

    private double rAtas;
    private double t;

    public Keratan(double r, double rAtas, double t) {
        super(r);
        this.rAtas = rAtas;
        this.t = t;

    }

    public void setrAtas(double rAtas) {
        this.rAtas = rAtas;
    }

    public void setTinggi(double t) {
        this.t = t;
    }

    public double getrAtas(double rAtas) {
        return rAtas;
    }

    public double getTinggi() {
        return t;
    }

    public double hitungLuasKeratanBola() {
        return (Math.PI * Math.pow(getTinggi(), 2)) + 2 * Math.PI * getR(r) * getrAtas(rAtas);
    }

    public double hitungVolumeKeratanBola() {
        return 1.0 / 6.0 * Math.PI * getTinggi() * (3 * Math.pow(getR(r), 2)
                + 3 * Math.pow(getrAtas(rAtas), 2) + Math.pow(getTinggi(), 2));
    }
}
