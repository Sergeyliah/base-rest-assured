package jdbc;

import utils.Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {
    private static String DATABASE_URL;
    private static String USER;
    private static String PASS;

    static {
        try {
            DATABASE_URL = Utility.fetchPropertyValue("database_url").toString();
            USER = Utility.fetchPropertyValue("database_username").toString();
            PASS = Utility.fetchPropertyValue("database_password").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet establishConnection(String sqlQuery) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        return connection.createStatement().executeQuery(sqlQuery);
    }

    public static int establishConnectionForDelete(String sqlQuery) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        return connection.createStatement().executeUpdate(sqlQuery);
    }

    public static void establishConnectionForDeleteVoid(String sqlQuery) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        connection.createStatement().executeUpdate(sqlQuery);


    }
    public static void establishConnectionForInsert(String sqlQuery) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        connection.createStatement().executeUpdate(sqlQuery);
    }

}
