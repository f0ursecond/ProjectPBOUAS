package food;

public class Treat extends Food{
    public Treat(String name, int nutrition , int taste, int health){
        super(name, nutrition, taste, health);
    }

    public static Treat Obat1(){
        return new Treat("Obat1",0,0,10);
    }

    @Override
    public int getHungerReduction() {
        return getNutritionValue();
    }

    @Override
    public int getHappinessBoost() {
        return getTastiness();
    }

    @Override
    public int getHealthBoost() {
        return getHealth();
    }
}