package pet;

import food.Food;

 public class Bird extends Pet {
    public Bird(String name){
        super(name, 50,50,70,50);        
    }
        @Override
        public void timePasses(){
            super.timePasses();
            energy = valAtt(energy - 5);
        }

        public void feed(Food food){
            super.feed(food);
            energy = valAtt(energy - 3);
        }

        public void sleep(){
            super.sleep();
            energy = valAtt(energy - 5);
        }

        public void play(){
            super.play();
            energy = valAtt(energy - 5);
        }
}
