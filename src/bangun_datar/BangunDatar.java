package bangun_datar;

public interface BangunDatar {

    public default double hitungKeliling(double jarijari) {
        System.out.print("Ini hitung keliling");
        return 0;
    };

    public default double hitungLuas(double jarijari) {
        System.out.print("Ini hitung Luas");
        return 0;
    }

    public default int hitungKeliling(int jarijari) {
        System.out.println("Hitung Keliling");
        return 0;
    }

    public default int hitungLuas(int jarijari) {
        System.out.println("Hitung Luas");
        return 0;
    }

    public void setR(double jariJari);

}
