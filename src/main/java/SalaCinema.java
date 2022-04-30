import java.util.HashSet;
import java.util.Scanner;

public class SalaCinema {
    private final String nomeSala;
    private final HashSet<Utente> listaPrenotazioni;
    int postiLiberi = 10;



    private String film;
    boolean statoMenu = false;
    public String getFilm(){
        return film;
     }
    public void setFilm(String film) {
        this.film = film;   }



    public SalaCinema(String nomeSala, String film ){
        this.nomeSala = nomeSala;
        this.film = film;
        listaPrenotazioni = new HashSet<>();

    }
    public void prenota(Utente utente) {
        if (postiLiberi >= 1) {
            listaPrenotazioni.add(utente);
            postiLiberi--;
            System.out.println("Signor/a " + utente.getSurname() + " " + utente.getName() + " la sua prenotazione è andata a buon fine");
            System.out.println("--------------------------");

        }
        else{
            System.out.println("posti non disponibili");
            System.out.println("--------------------------");
        }

    }
    public void annullaPrenotazione (Utente utente){
        listaPrenotazioni.remove(utente);
        postiLiberi++;
    }



    public  void mostraPrenotazioni() {
        System.out.println("Ecco la lista di prenotazione per la " + this.nomeSala);
        if(!listaPrenotazioni.isEmpty())
            listaPrenotazioni.forEach(System.out::println);
    }


    public void inizializzaMenu() {
        statoMenu = true;
        System.out.println("Benvenuto nel menu della " + this.nomeSala);
        System.out.println("Inserire i propri dati");
        Utente utente = new Utente();
        try {
            while (statoMenu) {
                System.out.println("Benvenuto/a " + utente.getName() + " " + utente.getSurname() +  ", selezioni l'azione da compiere:");
                System.out.println("-1 per verificare i posti        -2 per prenotare");
                System.out.println("-3 per annullare prenotazione    -4 per uscire");
                System.out.println("-5 per vedere quale film verrà proiettato");
                System.out.println("-6 per prenotare un altro posto ");

                Scanner input = new Scanner(System.in);
                int selezione = Integer.parseInt(input.nextLine());
                switch (selezione) {
                    case 1:
                        System.out.println("Ci sono " + postiLiberi + " posti liberi");
                        System.out.println("--------------------------");
                        break;
                    case 2:
                        if (this.listaPrenotazioni.contains(utente)) {
                            System.out.println("Hai già prenotato");
                            System.out.println("--------------------------");
                        } else {
                            this.prenota(utente);
                        }
                        break;
                    case 3:
                        if (this.listaPrenotazioni.contains(utente)) {
                            this.annullaPrenotazione(utente);
                            System.out.println("Hai annullato la tua prenotazione");
                            System.out.println("--------------------------");
                        } else {
                            System.out.println("Non hai una prenotazione da annullare");
                            System.out.println("--------------------------");
                        }
                        break;
                    case 4:
                        if (this.listaPrenotazioni.contains(utente)) {
                            System.out.println("Arrivederci, grazie per aver prenotato");
                        }else{
                            System.out.println("Arrivederci");
                        }
                        System.out.println("EXIT MENU");
                      //  System.exit(0);
                        statoMenu = false;
                        break;
                    case 5 :
                        System.out.println("Il film in proiezione è: " +this.getFilm());
                        System.out.println("--------------------------");
                        break;
                    case 6 : inizializzaMenu();
                        break;
                    default:
                        System.out.println("Comando non valido");
                        System.out.println("--------------------------");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Comando non valido");
            System.out.println("--------------------------");

        }
    }



    @Override
    public String toString() {
        return super.toString();
    }
}






