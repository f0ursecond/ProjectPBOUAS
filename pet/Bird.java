package pet;

import food.Food;
import rules.Rules;

 public class Bird extends Pet {
    public Bird(String name){
        super(name, 50,50,70,50);        
    }
        @Override
        public void timePasses(){
            int energyAwal = energy;
            int hungerAwal = hunger;
            super.timePasses();
            int potongan = Rules.cepat(175 - energyAwal);
            int tambahan = Rules.cepat(175 - hungerAwal);
            energy = valAtt(energyAwal - potongan);
            hunger = valAtt(energyAwal + tambahan);
            //Burung Cepat lapar 
        }

        @Override
        public void feed(Food food){
            int energyAwal = energy;
            super.feed(food);
            int potongan = Rules.cepat(175 - energyAwal);
            energy = valAtt(energyAwal - potongan);
            hunger = valAtt(hunger + 5);
        }

        @Override
        public void sleep(){
            int energyAwal = energy;
            super.sleep();
            int potongan = Rules.cepat(175 - energyAwal);
            energy = valAtt(energyAwal - potongan);
        }

        @Override
        public void play(){
             int energyAwal = energy;
            super.play();
            int potongan = Rules.cepat(175 - energyAwal);
            energy = valAtt(energyAwal - potongan);

            System.out.println("Terbang di kamar");
        }

        @Override
            public void makeSound(){
                System.out.println("Get yo ass down");
            }
}
