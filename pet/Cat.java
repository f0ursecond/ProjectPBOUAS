package pet;

import food.Food;

public class Cat extends Pet  {
    public Cat(String name){
        super(name,50,50,50,50);        
    }
        @Override
        public void timePasses(){
            super.timePasses();
            energy = valAtt(energy + 3);
        }

        @Override
        public void feed(Food food){
            super.feed(food);
            if(food.getName().equalsIgnoreCase("ikan")){
                happiness = valAtt(happiness + 10);
            }
        }
}


