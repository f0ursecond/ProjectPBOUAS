package pet;
package food;



class Pet {

    private String name;
    private int hunger;
    private int happinness;
    private int energy;
    private int healt;

    public Pet(String name, int hunger, int happinness, int energy, int heal) {
        this.name = name;
        this.hunger = hunger;
        this.happinness = happinness;
        this.energy = energy;
        this.healt = healt;
    }

    public void feed(Food f) {
        
        if(this.hunger >= 100){
            hunger = 100;
        }

        if(this.hunger == 0 ){
            System.out.println("yah mati deh");
        }
        hunger = hunger - 50;
    }

    public void play() {

        
        if(this.happinness == 100){
            happinness = 100;
        }

        if(this.happinness == 0){
            System.out.println("hewan mu sudah megang tali tambang");
        }

        if(this.energy == 100){
            energy = 100;
        }

        if(this.energy == 0){
            System.out.println("hewanmu terkapar malas");
        }

        happinness = happinness + 50;
        energy = energy - 50;
    }

    public void sleep() {        
        hunger = hunger - 10;
        happinness = happinness + 50;
    }

    public void timePasses(){
        hunger += 10;
        happinness -= 5;
        energy -= 5;
    }

    public void healt(){
        
    }

    public void showStatus() {
        System.out.println("Nama : " + name);
        System.out.println("Hunger :" + hunger);
        System.out.println("Happiness :" + happinness);
        System.out.println("Energy : " + energy);
    }

    public static void main(String[] args) {

    }

}
