public class Tembereng extends Bola {
    private double jrkBidang;
    private double tinggiTembereng;

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

    public double hitungTinggiTembereng() {
        tinggiTembereng = getR(r) - Math.sqrt(Math.pow(getR(r), 2) - Math.pow(getJrkBidang(jrkBidang), 2));
        return tinggiTembereng;
    }

    // Kurang hitungLuasTemberengBola

    public double hitungVolumeTemberengBola() {
        return (1.0 / 6.0) * Math.PI * Math.pow(hitungTinggiTembereng(), 2)
                * (3.0 * Math.pow(getR(r), 2) + Math.pow(hitungTinggiTembereng(), 2));
    }
}
