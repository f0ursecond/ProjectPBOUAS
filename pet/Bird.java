package pet;

import food.Food;
import rules.Rules;

public class Bird extends Pet {
    public Bird(String name){
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
        public void timePasses(){
            int happinessAwal = happiness;
        
            hunger = valAtt(hunger + 10);
            energy = valAtt(energy - 10);
            happiness = valAtt(happiness - 5);

            if (hunger >= 90) health = valAtt(health - 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            int potongan = Rules.cepat(195 - happinessAwal);
            happiness = valAtt(happinessAwal - potongan);
        }

        @Override
        public void feed(Food food){
            int happinessAwal = happiness;
        
            hunger = valAtt(hunger - food.getHungerReduction());
            energy = valAtt(energy + 10);
            happiness = valAtt(happiness + food.getHappinessBoost());

            if (hunger >= 90) health = valAtt(health - 5);
            if (hunger == 0) health = valAtt(health + 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            int potongan = Rules.cepat(175 - happinessAwal);
            happiness = valAtt(happinessAwal - potongan);
        }

        @Override
        public void sleep(){
            int happinessAwal = happiness;
            
            hunger = valAtt(hunger + 10);
            energy = valAtt(energy + 10);
            happiness = valAtt(happiness + 10);

            if (hunger >= 90) health = valAtt(health - 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            int potongan = Rules.cepat(175 - happinessAwal);
            happiness = valAtt(happinessAwal - potongan);
        }

        @Override
        public void play(){
            // int energyAwal = energy;
            
            // Menggantikan super.play()
            hunger = valAtt(hunger + 10);
            energy = valAtt(energy - 10);
            happiness = valAtt(happiness + 10);
            if (hunger >= 90) health = valAtt(health - 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            // int potongan = Rules.cepat(175 - energyAwal);
            // energy = valAtt(energyAwal - potongan);

            System.out.println("Terbang di kamar");
        }

        @Override
            public void makeSound(){
                System.out.println("Cuitttt");
            }

        @Override
        public String getSpecies() {    
            return "Burung";
        }
}
