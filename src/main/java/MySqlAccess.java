
import java.sql.*;

public class MySqlAccess {



    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;





    public void connectToDB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datacinema", "root", "Petrucci93.");
    }

    public void putIntoDb(Utente utente, String nomeCinema) throws Exception {
        preparedStatement = connection.prepareStatement("insert into datacinema." + nomeCinema + " values (?,?,?,?)");
        preparedStatement.setString(1, utente.getName());
        preparedStatement.setString(2, utente.getSurname());
        preparedStatement.setInt(3, utente.getAge());
        preparedStatement.setString(4, utente.getId());
        preparedStatement.executeUpdate();
    }

    public void removeFromDb(Utente utente, String nomeCinema) throws SQLException {
        preparedStatement = connection.prepareStatement("delete from datacinema." + nomeCinema + " where name = ? and surname = ? and age = ?");
        preparedStatement.setString(1, utente.getName());
        preparedStatement.setString(2, utente.getSurname());
        preparedStatement.setInt(3, utente.getAge());
        preparedStatement.executeUpdate();

    }

    public int checkIfIsFree(String nomeCinema) throws SQLException {
        int freeSits = 10;
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT COUNT(*) AS recordCount FROM "+nomeCinema);
        resultSet.next();
        int count = resultSet.getInt("recordCount");
        resultSet.close();
        freeSits -= count;
        return freeSits;
    }

}





