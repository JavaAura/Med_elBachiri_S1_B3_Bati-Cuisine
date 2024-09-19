package utils.db;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static java.sql.Connection cn = null;

    private static final String url = System.getenv("DB_URL");
    private static final String usr = System.getenv("DB_USERNAME");
    private static final String pwd = System.getenv("DB_PASSWORD");

    private static Logger logger = LoggerFactory.getLogger(DbConnection.class);

    public static Connection connect() {

        if (cn == null){
            try {
                cn = DriverManager.getConnection(url, usr, pwd);
            } catch (SQLException e){
                logger.error("SQL ERROR : " + e);
            }
        }
        return cn;
    }
}
