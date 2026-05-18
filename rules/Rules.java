package rules;

//Rule digunakan untuk pengurangan value attribut dari pet
public class Rules {

    //Lambat 5%
    public static int lambat(int currentValue) {
        return (int) (currentValue * 0.05);
    }

    // //sedang 5% -- saat ini tidak digunakan
    // public static int sedang(int currentValue) {
    //     return (int) (currentValue * 0.05);
    // }

    //cepat 20% 
    public static int cepat(int currentValue) {
        return (int) (currentValue * 0.2);
    }    
}
