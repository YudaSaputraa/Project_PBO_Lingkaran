package bangun_ruang;

public class Tembereng extends Bola {
    private double jrkBidang;
    private double tinggiTembereng;
    private double theta;

    public Tembereng(double r, double jrkBidang) {
        super(r);
        this.jrkBidang = jrkBidang;
    }

    public void setJrkBidang(double jrkBidang) {
        this.jrkBidang = jrkBidang;
    }

    public double getJrkBidang(double jrkBidang) {
        return jrkBidang;
    }

    public double getTheta() {
        theta = 2 * Math.acos(1 - hitungTinggiTembereng() / getR(r));
        return theta;
    }

    public double hitungTinggiTembereng() {
        tinggiTembereng = getR(r) - Math.sqrt(Math.pow(getR(r), 2) - Math.pow(getJrkBidang(jrkBidang), 2));
        return tinggiTembereng;
    }

    public double hitungLuasTemberengBola() {
        return (Math.pow(getR(r), 2) / 2) * (getTheta() - Math.sin(getTheta()));
    }

    public double hitungVolumeTemberengBola() {
        return (1.0 / 3.0) * Math.PI * hitungTinggiTembereng() * hitungTinggiTembereng()
                * (3 * getR(r) - hitungTinggiTembereng());
    }
}
