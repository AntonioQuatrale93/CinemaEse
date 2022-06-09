

import java.util.Scanner;
import java.util.UUID;

public class Utente {


    private String name;
    private String surname;
    private final String id;
    private final int age;
    public String getId() {
        return id;
    }



    public int getAge() {
        return age;
    }




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
        name.trim();
        while (!isLetters(name) || !isEmpty(name)) {
            System.out.println("NOME: ");
            name = input.nextLine();
        }
        this.setName(name);
        System.out.println("COGNOME:");
          surname = input.nextLine();

        while (!isLetters(surname) || !isEmpty(surname)) {
            System.out.println("COGNOME: ");
            surname = input.nextLine();
        }
          this.setSurname(surname);
        System.out.println("ETA: ");
         input = new Scanner(System.in);
        this.age = input.nextInt();
          System.out.println("--------------------------");
          this.id = UUID.randomUUID().toString();

    }

    public boolean isLetters(String name) {
        char[] ch = name.toCharArray();
        for (char c : ch) {
            if(!Character.isLetter(c)) {
                System.out.println("Non hai inserito un nome o cognome valido");
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(String name) {
        if (name.length() == 0) {
            System.out.println("Non hai inserito un nome o cognome valido");
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Utente prenotato: " + name + " " + surname;
    }
}


