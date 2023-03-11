public class Juring extends Bola {

    private double sudut;

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

    /*
     * public double hitungLuasJuring() {
     * return (getSudut(sudut) / 360.0) * super.hitungLuasBola();
     * }
     * 
     * public double hitungVolumeJuring() {
     * return (getSudut(sudut) / 360.0) * super.hitungVolumeBola();
     * }
     */
}
