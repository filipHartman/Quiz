package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    private Connection connection;

    public void connectToDatabase() {
        try {
            connection = DbConnection.getConnection();
        } catch (ClassNotFoundException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public ArrayList<String> importQuestionTypes() {
        ArrayList<String> typeNamesCollection = new ArrayList<String>();
        PreparedStatement ps = null;
        String query = "SELECT * FROM types";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String typeName = rs.getString("type_name");
                typeNamesCollection.add(typeName);
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return typeNamesCollection;
    }
}
