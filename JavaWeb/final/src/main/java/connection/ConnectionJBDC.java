package connection;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJBDC {
    private static String user = "haidz";
    private static String pass = "123456";
    public static Connection getConnection() {
        Connection conn = null;
        String DB_URL = "jdbc:sqlserver://DESKTOP-VDL0248\\KTEAM:1444;"
                + "databaseName=BankingSystem; "
                + "trustServerCertificate=true;encrypt=true";
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            conn = DriverManager.getConnection(DB_URL, user, pass);
            if (conn!= null){
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
