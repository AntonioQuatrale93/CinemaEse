import java.util.HashSet;

public class SalaCinema  {




    private final String nomeSala;
    private final HashSet<Utente> listaPrenotazioni;
    private int postiLiberi;
    private String film;
    private boolean statoMenu = false;

    public void setStatoMenu(boolean statoMenu) {
        this.statoMenu = statoMenu;
    }

    MySqlAccess mySqlAccess = new MySqlAccess();



    public int getPostiLiberi() {
        return postiLiberi;
    }


    public boolean getStatoMenu() {
        return statoMenu;
    }

    public HashSet<Utente> getListaPrenotazioni() {
        return listaPrenotazioni;
    }
    public String getNomeSala() {
        return nomeSala;
    }


    public String getFilm(){
        return film;
     }




    public SalaCinema(String nomeSala, String film ) throws Exception {
        this.nomeSala = nomeSala;
        this.film = film;
        listaPrenotazioni = new HashSet<>();
        mySqlAccess.connectToDB();
        this.postiLiberi = mySqlAccess.checkIfIsFree(this.getNomeSala());
    }
    public void mostraPrenotazioniSala() {
        System.out.println("Ecco la lista di prenotazione per la " + this.getNomeSala() + "|| Film: " + this.getFilm());
        if (!this.getListaPrenotazioni().isEmpty()) {
            this.getListaPrenotazioni().forEach(System.out::println);

        } else {
            System.out.println("Non c'è nessuna prenotazione");
        } System.out.println("----------------------------------");
    }


    @Override
    public String toString() {
        return nomeSala;
    }
}






