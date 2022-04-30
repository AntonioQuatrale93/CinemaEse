

import java.util.Scanner;

public class Utente {


    private String name;
    private String surname;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Utente() {
        System.out.println("NOME: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        while (sonoLettere(name) == false) {
            System.out.println("NOME: ");
            name = input.nextLine();
        }
        this.setName(name);
        System.out.println("COGNOME:");
          surname = input.nextLine();
        while (sonoLettere(surname) == false) {
            System.out.println("COGNOME: ");
            surname = input.nextLine();
        }
          this.setSurname(surname);
          System.out.println("--------------------------");
    }

    public boolean sonoLettere(String name) {
        char[] ch = name.toCharArray();
        for (char c : ch) {
            if(!Character.isLetter(c)) {
                System.out.println("Non hai inserito un nome o cognome valido");
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + name + '\'' +
                ", cognome='" + surname + '\'' +
                '}';
    }
}
