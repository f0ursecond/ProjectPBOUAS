package pet;
import rules.Rules;
import food.Food;

public class Cat extends Pet  {
    public Cat(String name){
        super(name,50,50,50,50);        
    }
        @Override
        public void timePasses(){
            int energyAwal = energy;
            super.timePasses();
            int potongan = Rules.lambat(140 - energyAwal);
            //Perhitugan kucing berbeda karena Waktu tidur yang lama
            energy = valAtt(energyAwal - potongan);
        }

        @Override
        public void sleep(){
            // int energyAwal = energy;
            super.sleep();
            // int potongan = Rules.lambat(180 - energyAwal);
        
            // energy = valAtt(energyAwal - potongan);
        }

        @Override
        public void play(){
            int energyAwal = energy;
            super.play();
            int potongan = Rules.lambat(180 - energyAwal);
            
            energy = valAtt(energyAwal - potongan);
            happiness = valAtt(happiness + 5);


            System.out.println("Kucing Bermain Bola Benang");
        }

        @Override
        public void feed(Food food){
            super.feed(food);
            if(food.getName().equalsIgnoreCase("ikan")){
                happiness = valAtt(happiness + 10);
            }
        }

        @Override
        public void makeSound(){
            System.out.println("Miawww");
        }
}


