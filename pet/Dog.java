package pet;
import food.Food;
import rules.Rules;

public class Dog extends Pet {
    public Dog(String name){
        super(name,50,50,50,50);        
    }    

    @Override
    public void play(int gameChoice){
        int happinessAwal = getHappiness();
        setHunger(getHunger() + 10);
        int nambahHappiness = 0;
        
        switch(gameChoice) {
            // Default
            case 1: // Favorit Anjing
                System.out.println("Anjing sangat bersemangat menangkap bola! (Bonus Kebahagiaan Besar)");
                nambahHappiness = 25; setEnergy(getEnergy() - 5); break;
            case 2: 
                System.out.println("Anjing kebingungan mengejar titik laser, berlari kesana-kemari.");
                nambahHappiness = 10; setEnergy(getEnergy() - 10); break;
            case 3: 
                System.out.println("Anjing melompat-lompat mencoba ikut rintangan di udara.");
                nambahHappiness = 5; setEnergy(getEnergy() - 15); break;
                
            // Mainan Baru
            case 4: 
                System.out.println("Anjing berhasil memecahkan puzzle dan mendapatkan snack di dalamnya!");
                nambahHappiness = 20; setEnergy(getEnergy() - 5); break;
            case 5: 
                System.out.println("Anjing melolong mengikuti irama mainan musikal.");
                nambahHappiness = 15; setEnergy(getEnergy() - 5); break;
        }
        
        int potongan = Rules.cepat(175 - happinessAwal);
        setHappiness((happinessAwal + nambahHappiness) - potongan);
        checkConditions();
    }

    @Override
    public void feed(Food food){
        int happinessAwal = getHappiness();
        setHunger(getHunger() - food.getHungerReduction());
        setEnergy(getEnergy() + 10);
        int potongan = Rules.cepat(175 - happinessAwal);
        setHappiness(happinessAwal - potongan);    
        checkConditions();
    }

    @Override
    public void sleep(){
        int happinessAwal = getHappiness();
        setHunger(getHunger() + 10);
        setEnergy(getEnergy() + 10);
        int potongan = Rules.cepat(175 - happinessAwal);
        setHappiness(happinessAwal - potongan);
        checkConditions();
    }

    @Override
    public void timePasses(){
        if (time.Time.getCurrentTime() % 10 == 0) {
            getUmur().tambahUmur();
        }
        int happinessAwal = getHappiness();
        setHunger(getHunger() + 10);
        setEnergy(getEnergy() - 5);
        int potongan = Rules.cepat(195 - happinessAwal);
        setHappiness(happinessAwal - potongan);
        checkConditions();
    }

    @Override public void makeSound(){ System.out.println("Rawrrrrr"); }
    @Override public String getSpecies() { return "Anjing"; }
}