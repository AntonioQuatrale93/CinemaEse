import jdk.swing.interop.SwingInterOpUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws Exception {

        SalaCinema sala1 = new SalaCinema("sala1", "Interstellar");
        SalaCinema sala2 = new SalaCinema("sala2", "Batman");
        SalaCinema sala3 = new SalaCinema("sala3", "A Beautiful Mind");
        SalaCinema sala4 = new SalaCinema("sala4", "John Wick");
        Manager luigi = new Manager("Luigi", "Rossi");
        Manager andrea = new Manager("Andrea", "Verdi");
        Manager giorgio = new Manager("Giorgio", "Bianchi");
        Manager giovanni = new Manager("Giovanni", "Neri");
        Multisala.getInstance().associaManager(luigi, sala1);
        Multisala.getInstance().associaManager(andrea, sala2);
        Multisala.getInstance().associaManager(giorgio, sala3);
        Multisala.getInstance().associaManager(giovanni, sala4);


        MySqlAccess mySqlAccess = new MySqlAccess();
        mySqlAccess.connectToDB();
        Multisala.getInstance().menuIniziale();


    }
}
