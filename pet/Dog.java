package pet;

import food.Food;
import rules.Rules;

public class Dog extends Pet {
    public Dog(String name){
            super(name,50,50,50,50);        
        }    
            @Override
            public void feed(Food food){
                int happinessAwal = happiness;
                super.feed(food);
                int potongan = Rules.cepat(175 - happinessAwal);
                
                happiness = valAtt(happinessAwal - potongan);    
            }

            @Override
            public void sleep(){
                int happinessAwal = happiness;
                super.sleep();
                int potongan = Rules.cepat(175 - happinessAwal);
                
                happiness = valAtt(happinessAwal - potongan);
            }

            @Override
            public void timePasses(){
                int happinessAwal = happiness;
                super.timePasses();
                int potongan = Rules.cepat(195 - happinessAwal);
                //Perhuitungan happines beda karena anjing mudah kesepian (timepasses = tidak bermain dengan waktu lama)
                
                happiness = valAtt(happinessAwal - potongan);
            }

            @Override
            public void play(){
                int happinessAwal = happiness;
                super.play();
                int potongan = Rules.cepat(175 - happinessAwal);
                
                happiness = valAtt(happinessAwal + potongan);

                System.out.println("bermain fetch");
            }

            @Override
            public void makeSound(){
                System.out.println("Rawrrrrr");
            }
}
