package pet;
import rules.Rules;
import food.Food;

public class Cat extends Pet  {
    public Cat(String name){
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
                System.out.println("Kucing hanya menatap bola yang dilempar dengan pandangan malas...");
                bonusHappiness = 5; break;
            case 2: // Favorit Kucing
                System.out.println("Kucing melesat sangat cepat mengejar titik laser! (Bonus Kebahagiaan Besar)");
                bonusHappiness = 25; break;
            case 3: 
                System.out.println("Kucing mencoba memanjat rintangan tersebut.");
                bonusHappiness = 10; break;
                
            // Mainan Baru
            case 4: 
                System.out.println("Kucing memutar-mutar puzzle dengan cakar mungilnya.");
                bonusHappiness = 15; break;
            case 5: 
                System.out.println("Kucing mencoba menangkap nada dari mainan musikal.");
                bonusHappiness = 20; break;
        }
        setHappiness(getHappiness() + bonusHappiness);
        
        int potongan = Rules.lambat(180 - energyAwal);
        setEnergy(energyAwal - potongan);
        checkConditions();
    }

    @Override
    public void timePasses(){
        int energyAwal = getEnergy();
        setHunger(getHunger() + 10);
        setHappiness(getHappiness() - 5);
        int potongan = Rules.lambat(140 - energyAwal);
        setEnergy(energyAwal - potongan);
        checkConditions();
    }

    @Override
    public void sleep(){
        setHunger(getHunger() + 10);
        setEnergy(getEnergy() + 10);
        setHappiness(getHappiness() + 10);
        checkConditions();
    }

    @Override
    public void feed(Food food){
        setHunger(getHunger() - food.getHungerReduction());
        setEnergy(getEnergy() + 10);
        setHappiness(getHappiness() + food.getHappinessBoost());

        if(food.getName().equalsIgnoreCase("ikan")){
             setHappiness(getHappiness() + 10);
        }
        checkConditions();
    }

    @Override public void makeSound(){ System.out.println("Miawww"); }
    @Override public String getSpecies() { return "Kucing"; }
}