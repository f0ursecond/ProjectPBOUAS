package umur;

public class Umur {
    private int totalUmur;

    public Umur(int umurAwal) {
        this.totalUmur = umurAwal;
    }

    public void tambahUmur() {
        this.totalUmur += 1;
    }

    public int getTotalUmur() {
        return totalUmur;
    }

    public String getFaseLife() {
        if (totalUmur < 10) return "Bayi";
        if (totalUmur < 25) return "Remaja";
        if (totalUmur < 50) return "Dewasa";
        return "Tua";
    }
}