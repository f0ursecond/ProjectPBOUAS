package food;

public class WetFood extends Food{
    public WetFood(String name, int nutrition, int taste, int health){
        super(name, nutrition, taste, health);
    }

    public static WetFood Air(){ return new WetFood("Air",10,10,0); }
    public static WetFood Susu(){ return new WetFood("Susu",10,10,0); } // Method ini yang error karena hilang

    @Override public int getHungerReduction() { return getNutritionValue(); }
    @Override public int getHappinessBoost() { return getTastiness(); }
    @Override public int getHealthBoost() { return getHealth(); }
}