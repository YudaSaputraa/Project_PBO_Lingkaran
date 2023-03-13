package bangun_ruang;

public class Keratan extends Bola {

    private double rAtas;
    private double tinggi;

    public Keratan(double r, double rAtas, double tinggi) {
        super(r);
        this.rAtas = rAtas;
        this.tinggi = tinggi;
    }

    public void setrAtas(double rAtas) {
        this.rAtas = rAtas;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getrAtas(double rAtas) {
        return rAtas;
    }

    public double getTinggi(double tinggi) {
        return tinggi;
    }

    public double hitungLuasKeratanBola() {
        return (Math.PI * Math.pow(getTinggi(tinggi), 2)) + 2 * Math.PI * getR(r) * getrAtas(rAtas);
    }

    public double hitungVolumeKeratanBola() {
        return 1.0 / 6.0 * Math.PI * getTinggi(tinggi) * (3 * Math.pow(getR(r), 2)
                + 3 * Math.pow(getrAtas(rAtas), 2) + Math.pow(getTinggi(tinggi), 2));
    }
}
