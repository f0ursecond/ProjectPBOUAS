package pet;

import food.Food;

public class Dog extends Pet {
    public Dog(String name){
            super(name, 50, 70, 50, 50);        
        }    
            @Override
            public void feed(Food food){
                super.feed(food);
                happiness = valAtt(happiness -10);    
            }

            @Override
            public void sleep(){
                super.sleep();
                happiness = valAtt(happiness - 10);
            }

            @Override
            public void timePasses(){
                super.timePasses();
                happiness = valAtt(happiness - 10);
            }

            @Override
            public void play(){
                super.play();
                happiness = valAtt(happiness + 10);
            }
}
