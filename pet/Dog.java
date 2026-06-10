package pet;

import food.Food;
import rules.Rules;

public class Dog extends Pet {
    public Dog(String name){
            super(name,50,50,50,50);        
        }    
            @Override
            protected int valAtt(int value){
                if (value < 0) 
                    return 0;
                if (value > 100)
                    return 100;
                return value;
            }

            @Override
            public void feed(Food food){
                int energyAwal = energy;
            
                hunger = valAtt(hunger - food.getHungerReduction());
                energy = valAtt(energy + 10);
                happiness = valAtt(happiness + food.getHappinessBoost());

                if (hunger >= 90) health = valAtt(health - 5);
                if (hunger == 0) health = valAtt(health + 5);
                if (energy <= 15) hunger = valAtt(hunger + 5);

                int potongan = Rules.cepat(175 - energyAwal);
                energy = valAtt(energyAwal - potongan);
                hunger = valAtt(hunger + 5);    
            }

            @Override
            public void sleep(){
                int energyAwal = energy;
                
                hunger = valAtt(hunger + 10);
                energy = valAtt(energy + 10);
                happiness = valAtt(happiness + 10);

                if (hunger >= 90) health = valAtt(health - 5);
                if (energy <= 15) hunger = valAtt(hunger + 5);

                int potongan = Rules.cepat(175 - energyAwal);
                energy = valAtt(energyAwal - potongan);
            }

            @Override
            public void timePasses(){
                int energyAwal = energy;
                int hungerAwal = hunger;
                
                hunger = valAtt(hunger + 10);
                energy = valAtt(energy - 10);
                happiness = valAtt(happiness - 5);

                if (hunger >= 90) health = valAtt(health - 5);
                if (energy <= 15) hunger = valAtt(hunger + 5);

                int potongan = Rules.cepat(175 - energyAwal);
                int tambahan = Rules.cepat(175 - hungerAwal);
                energy = valAtt(energyAwal - potongan);
                hunger = valAtt(energyAwal + tambahan);
            }

            @Override
            public void play(){
                int energyAwal = energy;

                hunger = valAtt(hunger + 10);
                energy = valAtt(energy - 10);
                happiness = valAtt(happiness + 10);
                    
                if (hunger >= 90) health = valAtt(health - 5);
                if (energy <= 15) hunger = valAtt(hunger + 5);

                int potongan = Rules.lambat(175 - energyAwal);
            
                energy = valAtt(energyAwal - potongan);
                happiness = valAtt(happiness + 5);

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
