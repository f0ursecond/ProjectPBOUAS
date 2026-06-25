package pet;
import food.Food;
import rules.Rules;

public class Bird extends Pet {
    public Bird(String name){
        super(name,50,50,50,50);        
    }

    @Override
    public void play(int gameChoice){
        int energyAwal = getEnergy();
        setHunger(getHunger() + 10);
        int bonusHappiness = 0;
        
        switch(gameChoice) {
            // Default 
            case 1: 
                System.out.println("Burung hanya bertengger santai di atas bola.");
                bonusHappiness = 5; break;
            case 2: 
                System.out.println("Burung memperhatikan titik laser dari atas kandang.");
                bonusHappiness = 10; break;
            case 3: // Favorit Burung
                System.out.println("Burung bermanuver indah melewati rintangan di udara! (Bonus Kebahagiaan Besar)");
                bonusHappiness = 25; break;
                
            // Mainan Baru
            case 4: 
                System.out.println("Burung mematuk-matuk balok puzzle dengan cerdas.");
                bonusHappiness = 20; break;
            case 5:
                System.out.println("Burung bernyanyi riang meniru suara dari mainan musikal!");
                bonusHappiness = 20; break;
        }
        setHappiness(getHappiness() + bonusHappiness);
        
        int potongan = Rules.cepat(175 - energyAwal);
        setEnergy(energyAwal - potongan);
        checkConditions();
    }

    @Override
    public void timePasses(){
        if (time.Time.getCurrentTime() % 10 == 0) {
            getUmur().tambahUmur();
        }
        int energyAwal = getEnergy();
        int hungerAwal = getHunger();
        setHappiness(getHappiness() - 5);
        int potongan = Rules.cepat(175 - energyAwal);
        int tambahan = Rules.cepat(175 - hungerAwal);
        setEnergy(energyAwal - potongan);
        setHunger(hungerAwal + tambahan);
        checkConditions();
    }

    @Override
    public void feed(Food food){
        int energyAwal = getEnergy();
        setHunger(getHunger() - food.getHungerReduction());
        setHappiness(getHappiness() + food.getHappinessBoost());
        int potongan = Rules.cepat(175 - energyAwal);
        setEnergy(energyAwal - potongan);
        setHunger(getHunger() + 5);
        setHealth(getHealth() + 6);
        checkConditions();
    }

    @Override
    public void sleep(){
        int energyAwal = getEnergy();
        setHunger(getHunger() + 10);
        setHappiness(getHappiness() + 10);
        int potongan = Rules.cepat(175 - energyAwal);
        setEnergy(energyAwal - potongan);
        checkConditions();
    }

    @Override public void makeSound(){ System.out.println("Cuitttt"); }
    @Override public String getSpecies() { return "Burung"; }
}