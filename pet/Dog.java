package pet;

public class Dog extends Pet {
    public Dog(String name){
            super(name, 100, 100, 100, 100);        
        }    
            @Override
            public void timePasses(){
                super.timePasses();
                energy =+3;
                // happiness -= 10
                // System.out.println(name + " sangat bosan, tingkat bahagia menurun: " + happiness);
            }

            // @Override
            // public void play()
            //     super.play();
            //     happines += 5;
}
