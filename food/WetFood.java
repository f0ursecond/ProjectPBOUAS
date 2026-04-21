package food;

public class WetFood extends Food{
    private WetFood(String name, int nutrition , int taste){
         super(name, nutrition, taste);
    }

    public static WetFood Air(){
        return new WetFood("Air",10,10);
    }

    public static WetFood Esteh(){
        return new WetFood("Esteh",10,10);
    }
}