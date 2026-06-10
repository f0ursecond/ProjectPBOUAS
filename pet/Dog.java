package pet;

import food.Food;
import rules.Rules;

public class Dog extends Pet {
    public Dog(String name){
            super(name,50,50,50,50);        
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
            int happinessAwal = getHappiness();
            
            setHunger(getHunger() + 10);
            setEnergy(getEnergy() - 5);
            
            int potongan = Rules.cepat(195 - happinessAwal);
            setHappiness(happinessAwal - potongan);
            checkConditions();
        }

        @Override
        public void play(){
            int happinessAwal = getHappiness();
            
            setHunger(getHunger() + 10);
            setEnergy(getEnergy() - 10);
            
            int potongan = Rules.cepat(175 - happinessAwal);
            setHappiness(happinessAwal - potongan);
            
            checkConditions();
            System.out.println("bermain fetch");
        }

        @Override
        public void makeSound(){
            System.out.println("Rawrrrrr");
        }

        @Override
        public String getSpecies() {
            return "Anjing";
        }
}
