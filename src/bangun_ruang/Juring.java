package bangun_ruang;

public class Juring extends Bola {

    private double sudut;
    private double theta;

    public Juring(double r, double sudut) {
        super(r);
        this.sudut = sudut;
    }

    public void setSudut(double sudut) {
        this.sudut = sudut;
    }

    public double getSudut(double sudut) {
        return sudut;
    }

    public double getTheta() {
        theta = Math.toRadians(getSudut(sudut));
        return theta;
    }

    public double hitungVolumeJuring() {
        return (Math.PI * (Math.pow(getR(r), 3)) * getTheta());
    }

    public double hitungLuasJuring() {
        return (Math.pow(getR(r), 2) * getTheta()) / 2;
    }
}
