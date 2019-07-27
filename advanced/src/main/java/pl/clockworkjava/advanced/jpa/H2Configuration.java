package pl.clockworkjava.advanced.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Configuration {

    private static String H2Driver = "org.h2.Driver";
    private static String H2Addr = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static String User = "";
    private static String Password = "";


    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(H2Addr, User, Password);
    }
}
