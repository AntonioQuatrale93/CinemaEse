public class Main {

    public static void main(String[] args) {

        SalaCinema sala1 = new SalaCinema("Sala 1", "Interstellar");
        SalaCinema sala2 = new SalaCinema("Sala 2", "Batman");
        SalaCinema sala3 = new SalaCinema("Sala 3", "A Beautiful Mind");
        SalaCinema sala4 = new SalaCinema("Sala 4", "John Wick");
        Manager luigi = new Manager("Luigi", "Rossi");
        Manager andrea = new Manager("Andrea", "Verdi");
        Manager giorgio = new Manager("Giorgio", "Bianchi");
        Manager giovanni= new Manager("Giovanni", "Neri");
        Multisala.getInstance().associaManager(luigi, sala1);
        Multisala.getInstance().associaManager(andrea, sala2);
        Multisala.getInstance().associaManager(giorgio, sala3);
        Multisala.getInstance().associaManager(giovanni, sala4);




        Multisala.getInstance().menuIniziale();








    }
}
