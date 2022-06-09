import org.jetbrains.annotations.NotNull;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class MySqlAccess {



    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    String dataPath;


    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public void connectToDB() throws Exception {
        MySqlAccess mySqlAccess = new MySqlAccess();
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datacinema", "root", "Petrucci93.");
    }

    public void putIntoDb(Utente utente, String nomeCinema) throws Exception {
        preparedStatement = connection.prepareStatement("insert into datacinema." + nomeCinema + " values (?,?,?,?)");
        preparedStatement.setString(1, utente.getName());
        preparedStatement.setString(2, utente.getSurname());
        preparedStatement.setInt(3, utente.getEtà());
        preparedStatement.setString(4, utente.getId());
        preparedStatement.executeUpdate();
    }

    public void removeFromDb(@NotNull Utente utente, String nomeCinema) throws SQLException {
        preparedStatement = connection.prepareStatement("delete from datacinema." + nomeCinema + " where nome = ? and cognome = ? and età = ?");
        preparedStatement.setString(1, utente.getName());
        preparedStatement.setString(2, utente.getSurname());
        preparedStatement.setInt(3, utente.getEtà());
        preparedStatement.setString(4, utente.getId());
        preparedStatement.executeUpdate();

    }

    public int checkIfIsFree(String nomeCinema) throws SQLException {
        int freeSits = 10;
        statement = connection.createStatement();
        ResultSet r = statement.executeQuery("SELECT COUNT(*) AS recordCount FROM "+nomeCinema);
        r.next();
        int count = r.getInt("recordCount");
        r.close();
        freeSits -= count;
        return freeSits;
    }

}





