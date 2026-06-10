package pet;
import rules.Rules;
import food.Food;

public class Cat extends Pet  {
    public Cat(String name){
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
            int energyAwal = energy;
        
            hunger = valAtt(hunger + 10);
            energy = valAtt(energy - 10);
            happiness = valAtt(happiness - 5);
            if (hunger >= 90) health = valAtt(health - 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            int potongan = Rules.lambat(140 - energyAwal);
            energy = valAtt(energyAwal - potongan);
        }

        @Override
        public void sleep(){
            hunger = valAtt(hunger + 10);
            energy = valAtt(energy + 10);
            happiness = valAtt(happiness + 10);
            if (hunger >= 90) health = valAtt(health - 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);
        }

        @Override
        public void play(){
            int energyAwal = energy;
            hunger = valAtt(hunger + 10);
            energy = valAtt(energy - 10);
            happiness = valAtt(happiness + 10);
            if (hunger >= 90) health = valAtt(health - 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            int potongan = Rules.lambat(180 - energyAwal);
            
            energy = valAtt(energyAwal - potongan);
            happiness = valAtt(happiness + 5);

            System.out.println("Kucing Bermain Bola Benang");
        }

        @Override
        public void feed(Food food){
            hunger = valAtt(hunger - food.getHungerReduction());
            energy = valAtt(energy + 10);
            happiness = valAtt(happiness + food.getHappinessBoost());

            if (hunger >= 90) health = valAtt(health - 5);
            if (hunger == 0) health = valAtt(health + 5);
            if (energy <= 15) hunger = valAtt(hunger + 5);

            if (food.getName().equalsIgnoreCase("ikan")) {
                happiness = valAtt(happiness + 10);
            }
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


