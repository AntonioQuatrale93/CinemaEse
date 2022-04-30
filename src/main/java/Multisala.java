import java.util.ArrayList;
import java.util.List;

public class Multisala {

    private static Multisala cinema;
    private static List<SalaCinema> salaCinema;



    private static final String name = "Cinema Paradiso";

    public String getName(){
     return name;
    }


    private Multisala(){
        salaCinema = new ArrayList<>();
    }



    public static Multisala getInstance(){
        if(cinema == null){
            cinema = new Multisala();
        }return cinema;
    }


    public static void aggiungiSala (SalaCinema salaCinema){
        Multisala.getInstance().salaCinema.add(salaCinema);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
