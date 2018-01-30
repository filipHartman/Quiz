package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
    private Connection connection;

    public void connectToDatabase() {
        try {
                connection = DbConnection.getConnection());
        } catch (ClassNotFoundException| SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
