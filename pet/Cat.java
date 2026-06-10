package pet;
import rules.Rules;
import food.Food;

public class Cat extends Pet  {
    public Cat(String name){
        super(name,50,50,50,50);        
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
    public void play(){
        int energyAwal = getEnergy();
        setHunger(getHunger() + 10);
        setHappiness(getHappiness() + 10);
        
       
        int potongan = Rules.lambat(180 - energyAwal);
        setEnergy(energyAwal - potongan);
        setHappiness(getHappiness() + 5);
        
        checkConditions();
        System.out.println("Kucing Bermain Bola Benang");
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

    @Override
    public void makeSound(){
        System.out.println("Miawww");
    }

    @Override
    public String getSpecies() {
        return "Kucing";
    }
}


