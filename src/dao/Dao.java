package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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

    public HashMap<Integer, String> importQuestionTypes() {
        HashMap<Integer, String> typeNamesCollection = new HashMap<Integer, String>();
        PreparedStatement ps = null;
        String query = "SELECT * FROM types";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String typeName = rs.getString("type_name");
                Integer typeId = rs.getInt("id_type");
                typeNamesCollection.put(typeId, typeName);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return typeNamesCollection;
    }

    public void exportNewTypeToDb (String typeName) {
        PreparedStatement ps;
        String query = "INSERT INTO types(type_name) values (?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, typeName);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Type insertion failed");
        }
    }
}
