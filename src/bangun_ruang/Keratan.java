package bangun_ruang;
public class Keratan extends Bola {

    private double jrkPusat;
    private double jrkTepi;

    public Keratan(double r, double jrkPusat, double jrkTepi) {
        super(r);
        this.jrkPusat = jrkPusat;
        this.jrkTepi = jrkTepi;
    }

    public void setJrkPusat(double jrkPusat) {
        this.jrkPusat = jrkPusat;
    }

    public void setJrkTepi(double jrkTepi) {
        this.jrkTepi = jrkTepi;
    }

    public double getJrkPusat(double jrkPusat) {
        return jrkPusat;
    }

    public double getJrkTepi(double jrkTepi) {
        return jrkTepi;
    }

    public double hitungLuasPermukaanKeratanBola() {
        return (Math.PI * Math.pow(getJrkTepi(jrkTepi), 2)) + 2 * Math.PI * getR(r) * getJrkPusat(jrkPusat);
    }

    public double hitungVolumeKeratanBola() {
        return (Math.PI * Math.pow(getJrkPusat(jrkPusat), 3)
                * (3 * Math.pow(getJrkTepi(jrkTepi), 2) + Math.pow(getJrkPusat(jrkPusat), 2)))
                / (6 * Math.pow(2 * getJrkPusat(jrkPusat), 3));
    }
}
