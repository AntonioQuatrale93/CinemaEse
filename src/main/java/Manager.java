public class Manager {
    String nome;
    String cognome;
    SalaCinema salaCinema;


    public Manager(String nome, String cognome){
        this.cognome = cognome;
        this.nome = nome;

    }


    public void setSalaCinema(SalaCinema salaCinema) {
        this.salaCinema = salaCinema;
    }
}
