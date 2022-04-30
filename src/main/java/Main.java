public class Main {

    public static void main(String[] args) {

        SalaCinema sala1 = new SalaCinema("Sala 1", "Interstellar");
        SalaCinema sala2 = new SalaCinema("Sala 2", "Batman");
        Multisala.getInstance().aggiungiSala(sala1);
        Multisala.getInstance().aggiungiSala(sala2);
        Manager luigi = new Manager("Luigi", "Rossi");
        Manager andrea = new Manager("Andrea", "Rossi");
        luigi.setSalaCinema(sala1);
        andrea.setSalaCinema(sala2);


        luigi.salaCinema.inizializzaMenu();
        andrea.salaCinema.inizializzaMenu();

        sala1.mostraPrenotazioni();
        System.out.println();
        sala2.mostraPrenotazioni();
        System.out.println(Multisala.getInstance().getName());
        System.out.println("-------------------------");





    }
}
