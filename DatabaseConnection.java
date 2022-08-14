package tr.com.obss.jip22.demo3;

import java.sql.DriverManager;
import java.sql.*;


public class DatabaseConnection {
    public static String urlString = "com.mysql.cj.jdbc.Driver";
    public static String userName = "barissss";
    public static Connection connection = null;
    public DatabaseConnection() {

    }

    public static void connectDatabase() {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    urlString,
                    userName, "root");
            connection.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void addContact(String name, String gsmVal) throws SQLException {
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(
                "INSERT INTO Contact VALUES(name,gsmVal)");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
    }


    public void editContact(String name, String gsm) throws SQLException {
        Statement st;
        st = connection.createStatement();
        ResultSet resultSet;
        resultSet = st.executeQuery(
                "DELETE FROM Contact WHERE Name = name ");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        st.close();
    }
}
