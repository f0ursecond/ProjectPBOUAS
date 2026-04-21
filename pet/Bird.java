package pet;

 public class Bird extends Pet {
    public Bird(String name){
        super(name, 100, 100, 100, 100);        
    }
        @Override
        public void timePasses(){
            super.timePasses();
            energy =+3;
            // energy -= 5;
            // System.out.println(name + " terbangg sangat aktif, energi terkuras cepat!! sisa: " + energy);
        }
        // public void feed(){
        //     hunger += 10;
        //     energy += 10;
        //     System.out.println(name + " makan biji, tingkat energy dan hunger sisa: " + hunger + energy);
        // }
}
