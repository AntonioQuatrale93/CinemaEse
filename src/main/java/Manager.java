import java.util.Scanner;

public class Manager {
    private final String nome;
    private final String cognome;
    private SalaCinema salaCinema;
    MySqlAccess mySqlAccess = new MySqlAccess();



    public SalaCinema getSalaCinema() {
        return salaCinema;
    }

    public void setSalaCinema(SalaCinema salaCinema) {
        this.salaCinema = salaCinema;
    }

    public Manager(String nome, String cognome){
        this.cognome = cognome;
        this.nome = nome;

    }
    public void prenota(Utente utente) {
        if (this.salaCinema.getPostiLiberi() >= 1) {
            this.salaCinema.getListaPrenotazioni().add(utente);
            System.out.println("Signor/a " + utente.getSurname() + " " + utente.getName() + " la sua prenotazione è andata a buon fine");
            System.out.println("--------------------------");
        }else{
            System.out.println("posti non disponibili");
            System.out.println("--------------------------");
        }
    }

    public void annullaPrenotazione (Utente utente){
        this.salaCinema.getListaPrenotazioni().remove(utente);

    }


    public void inizializzaMenu() throws Exception {
        this.salaCinema.setStatoMenu(true);
        System.out.println("Benvenuto nel menu della " + this.salaCinema.getNomeSala());
        System.out.println("Inserire i propri dati");
        Utente utente = new Utente();

        try {
            while (this.salaCinema.getStatoMenu()) {

                System.out.println("Benvenuto/a,  seleziona l'azione da compiere:");
                System.out.println("-1 per verificare i posti        -2 per prenotare");
                System.out.println("-3 per annullare prenotazione    -4 per uscire");
                System.out.println("-5 per vedere quale film verrà proiettato");
                System.out.println("-6 per prenotare un altro posto ");

                Scanner input = new Scanner(System.in);
                int selezione = Integer.parseInt(input.nextLine());
                switch (selezione) {
                    case 1 -> {
                        System.out.println("Ci sono " + this.salaCinema.getPostiLiberi() + " posti liberi");
                        System.out.println("--------------------------");
                    }
                    case 2 -> {
                        mySqlAccess.connectToDB();
                        mySqlAccess.checkIfIsFree(this.salaCinema.getNomeSala());
                        mySqlAccess.putIntoDb(utente, salaCinema.getNomeSala());
                        if (this.salaCinema.getListaPrenotazioni().contains(utente)) {
                            System.out.println("Hai già prenotato");
                            System.out.println("--------------------------");
                        } else {
                            this.prenota(utente);
                        }
                    }
                    case 3 -> {
                        mySqlAccess = new MySqlAccess();
                        mySqlAccess.connectToDB();
                        if (this.salaCinema.getListaPrenotazioni().contains(utente)) {
                            this.annullaPrenotazione(utente);
                            mySqlAccess.removeFromDb(utente, this.salaCinema.getNomeSala());
                            System.out.println("Hai annullato la tua prenotazione");
                            System.out.println("--------------------------");
                        } else {
                            mySqlAccess.removeFromDb(utente, this.salaCinema.getNomeSala());
                            System.out.println("Non hai una prenotazione da annullare");
                            System.out.println("--------------------------");
                        }
                    }
                    case 4 -> {
                        if (this.salaCinema.getListaPrenotazioni().contains(utente)) {
                            System.out.println("Arrivederci, grazie per aver prenotato");
                        } else {
                            System.out.println("Arrivederci");
                        }
                        System.out.println("EXIT MENU");
                        this.salaCinema.setStatoMenu(false);
                    }
                    case 5 -> {
                        System.out.println("Il film in proiezione è: " + this.salaCinema.getFilm());
                        System.out.println("--------------------------");
                    }
                    case 6 -> inizializzaMenu();
                    default -> {
                        System.out.println("Comando non valido");
                        System.out.println("--------------------------");
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Comando non valido");
            System.out.println("--------------------------");

        }
    }
















    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
