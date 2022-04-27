

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utente {


    private String nome;
    private String cognome;


    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Utente(){
        System.out.println("Inserire i propri dati");
        System.out.println("NOME: ");
      try {
          Scanner input = new Scanner(System.in);
          nome = input.nextLine();
          System.out.println("COGNOME:");
          this.setNome(nome);
          cognome = input.nextLine();
          this.setCognome(cognome);
      }catch(InputMismatchException e){
          System.out.println("Sono ammessi solo nome e cognome");
      }
        System.out.println("Benvenuto/a signor/a " + this.nome + " " + this.cognome);
        System.out.println("--------------------------");
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
