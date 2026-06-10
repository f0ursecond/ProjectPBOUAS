package food;

public class Treat extends Food{
    public Treat(String name, int nutrition , int taste){
        super(name, nutrition, taste);
    }

    public static Treat Obat1(){
        return new Treat("Obat1",10,10);
    }

    @Override
    public int getHungerReduction() {
        return getNutritionValue() - 5;
    }

    @Override
    public int getHappinessBoost() {
        return getTastiness() + 10;
    }
}