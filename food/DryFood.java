package food;

public class DryFood extends Food{
    public DryFood(String name, int nutrition , int taste){
        super(name, nutrition, taste);
    }

    public static DryFood Ikan(){
        
        return new DryFood("ikan",10,10);
    }

    public static DryFood Dimsum(){
        return  new DryFood("Dimsum",10,10);
    }
}
