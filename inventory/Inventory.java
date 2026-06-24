package inventory;

public class Inventory {
    private int koin;
    private boolean punyaPuzzle; 
    private boolean punyaMusik;  

    public Inventory(int koinAwal) {
        this.koin = koinAwal;
        this.punyaPuzzle = false;
        this.punyaMusik = false;
    }

    public Inventory(int koin, boolean punyaPuzzle, boolean punyaMusik) {
        this.koin = koin;
        this.punyaPuzzle = punyaPuzzle;
        this.punyaMusik = punyaMusik;
    }

    public int getKoin() { return koin; }
    
    public void tambahKoin(int jumlah) { 
        this.koin += jumlah; 
    }
    
    public boolean kurangiKoin(int jumlah) {
        if (this.koin >= jumlah) {
            this.koin -= jumlah;
            return true;
        }
        return false;
    }

    public boolean punyaMainan(int gameChoice) {
        switch (gameChoice) {
            case 1: return true; 
            case 2: return true; 
            case 3: return true; 
            case 4: return punyaPuzzle;
            case 5: return punyaMusik;
            default: return false;
        }
    }

    public void beliMainan(int pilihanToko) {
        if (pilihanToko == 1) punyaPuzzle = true;
        if (pilihanToko == 2) punyaMusik = true;
    }

    public String getStatusToko(int pilihanToko) {
        if (pilihanToko == 1) return punyaPuzzle ? "[DIBELI]" : "";
        if (pilihanToko == 2) return punyaMusik ? "[DIBELI]" : "";
        return "";
    }
}