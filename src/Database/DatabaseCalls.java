package Database;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DatabaseCalls {

    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    private String JDBC_DRIVER;
    private String DB_URL;
    //Database credentials
    private String USER;
    private String PASS;
    private Connection conn;
    private String query;

    public DatabaseCalls() {
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/slotmachinedb?zeroDateTimeBehavior=convertToNull";
        USER = "root";
        PASS = "root";
        conn = null;
        openConnection();
    }

    public void openConnection() {
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.print("Connecting to a selected database... ");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            //Handle errors for JDBC
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCalls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //FIXME Quern här måste ändras om fler användare ska kunna läggas till.
    public String getUserInfo(String info) {
        String userInfo = "";
        switch (info) {
            case "credit":
                query = "SELECT creditvalue FROM user";
                break;
            case "name":
                query = "SELECT firstname FROM user";
                break;
        }
        userInfo = useDatabase();
        return userInfo;
    }

    public String updateUserCredits(String userId) {
        //Använd userId för att få fram den användaren som är inloggad.
        query = "UPDATE table_name"
                + "SET column1 = value1, column2 = value2, ...\n"
                + "WHERE condition";
        return useDatabase();
    }

    private String useDatabase() {
        String results = "";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results = resultSet.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCalls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
