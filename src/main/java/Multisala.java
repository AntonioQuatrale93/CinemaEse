
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Multisala {

    private static Multisala cinema;
    private static final String name = "Cinema Paradiso";
    private static Map<Manager, SalaCinema> listaSaleManager;
    public static boolean statoMenu = false;




    public static Map<Manager, SalaCinema> getListaSaleManager() {
        return listaSaleManager;
    }


    public String getName(){
     return name;
    }



    private Multisala(){
        listaSaleManager = new LinkedHashMap<>();
    }



    public static Multisala getInstance(){
        if(cinema == null){
            cinema = new Multisala();
        }
        return cinema;
    }

    public static void associaManager(Manager manager, SalaCinema salaCinema){
        listaSaleManager.put(manager, salaCinema);
        manager.setSalaCinema(salaCinema);
    }





    public static void mostraSale() {
        System.out.println("--------------------------");

        System.out.println("Le sale aperte sono:");
        if (!listaSaleManager.isEmpty()) {
            listaSaleManager.forEach((manager, salaCinema) ->
                System.out.println(salaCinema + " | Film: " + salaCinema.getFilm()));

        } else {
            System.out.println("--------------------------");

            System.out.println("Non c'è nessuna sala aperta");
        }
        System.out.println("--------------------------");

    }





    public static void mostraTutteLePrenotazioni(){
        System.out.println("--------------------------");
        System.out.println("Ecco la lista delle prenotazioni per tutte le sale:");
        if (!listaSaleManager.isEmpty()) {
            listaSaleManager.forEach((manager, salaCinema) ->
             salaCinema.mostraPrenotazioniSala());
        }
        System.out.println("--------------------------");
    }







    public static void menuIniziale() {
        statoMenu = true;
        Multisala.getInstance().mostraSale();
        while (statoMenu) {
            System.out.println("Benvenuto/a, a quale sala vuole accedere?");
            System.out.println(" 1- Sala 1        2- Sala 2");
            System.out.println(" 3- Sala 3        4- Sala 4");
            System.out.println(" 0 per uscire");
            int risposta;
            Scanner input = new Scanner(System.in);
            risposta = input.nextInt();

            switch (risposta) {
                    case 1 -> {

                        Multisala.getInstance().getListaSaleManager().forEach((singleManager, singleSalaCinema) -> {
                            if (singleManager.getSalaCinema().getNomeSala().equals("sala1")) {
                                try {

                                    singleManager.inizializzaMenu();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        Multisala.getInstance().menuIniziale();
                    }
                    case 2 -> {
                        Multisala.getInstance().getListaSaleManager().forEach((singleManager, singleSalaCinema) -> {
                            if (singleManager.getSalaCinema().getNomeSala().equals("sala2")) {
                                try {
                                    singleManager.inizializzaMenu();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        Multisala.getInstance().menuIniziale();
                    }
                    case 3 -> {
                        Multisala.getInstance().getListaSaleManager().forEach((singleManager, singleSalaCinema) -> {
                            if (singleManager.getSalaCinema().getNomeSala().equals("sala3")) {
                                try {
                                    singleManager.inizializzaMenu();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        Multisala.getInstance().menuIniziale();
                    }
                    case 4 -> {
                        Multisala.getInstance().getListaSaleManager().forEach((singleManager, singleSalaCinema) -> {
                            if (singleManager.getSalaCinema().getNomeSala().equals("sala4")) {
                                try {
                                    singleManager.inizializzaMenu();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        Multisala.getInstance().menuIniziale();
                    }
                    case 0 -> statoMenu = false;
                    default -> System.out.println("inserisci un comando tra quelli elencati");
                }


            }
            Multisala.getInstance().mostraTutteLePrenotazioni();
        }



    @Override
    public String toString() {
        return " Cinema" + cinema.getName() + '\'' + Multisala.getInstance().listaSaleManager;
    }
}
