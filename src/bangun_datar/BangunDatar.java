package bangun_datar;

public interface BangunDatar {
    public default double hitungKeliling(double jarijari) {
        System.out.println("Ini hitung keliling");
        return 0;
    };

    public default double hitungLuas(double jarijari) {
        System.out.println("Ini hitung Luas");
        return 0;
    }

    public void setR(double jariJari2);

}
