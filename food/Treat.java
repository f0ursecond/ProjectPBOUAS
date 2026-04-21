package food;

public class Treat extends Food{
    private Treat(String name, int nutrition , int taste){
        super(name, nutrition, taste);
    }

    public static Treat Obat1(){
        return new Treat("Obat1",10,10);
    }
}