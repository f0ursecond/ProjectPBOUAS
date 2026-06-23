package food;

public class DryFood extends Food{
    public DryFood(String name, int nutrition , int taste, int health){
        super(name, nutrition, taste, health);
    }

    public static DryFood Ikan(){ return new DryFood("ikan",10,10,0); }
    public static DryFood Snack(){ return new DryFood("Snack",10,10,0); } 

    @Override public int getHungerReduction() { return getNutritionValue(); }
    @Override public int getHappinessBoost() { return getTastiness(); }
    @Override public int getHealthBoost() { return getHealth(); }
}