package pet;

public class Cat extends Pet {
    public Cat(String name){
        super(name, 100, 100, 100, 100);        
    }
        @Override
        public void timePasses(){
            super.timePasses();
            energy =+3;
            // System.out.println(name + "Kucing bosan energy berkurang sedikit" + energy);
        }

        
        
        // public void makanIkan(){
        //     energy += 20;
        //     hunger += 10;
        //     System.out.println(name + " ikan diberikan, energi bertambah =" + energy);
        // }
}


