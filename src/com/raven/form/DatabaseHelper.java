package com.raven.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.raven.model.Drug;

public class DatabaseHelper {

    // JDBC URL to connect to your database
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Pharma4;user=sa;password=HydotTech";

    // Load the SQL Server JDBC driver when the class is loaded
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to load SQL Server JDBC driver", e);
        }
    }

    // Queue to handle drug deletion requests asynchronously
    private static final Queue<String> deletionQueue = new ConcurrentLinkedQueue<>();

    // Method to establish a connection to the database with SSL properties
    public static Connection connect() {
        Connection conn = null;
        try {
            Properties props = new Properties();
            props.setProperty("encrypt", "true"); // Enable SSL encryption
            props.setProperty("trustServerCertificate", "true"); // Trust SQL Server self-signed certificate

            conn = DriverManager.getConnection(URL, props);
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return conn;
    }

    // Method to insert a drug into the database
    public static void insertDrug(String code, String name, double price, int quantity, String supplier, String dateAdded) {
        String sql = "INSERT INTO Drugs(code, name, price, quantity, supplier, date_added) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, quantity);
            pstmt.setString(5, supplier);
            pstmt.setString(6, dateAdded);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }

    // Method to fetch all drugs from the database and return as a map of drug code to Drug object
    public static Map<String, Drug> getAllDrugs() {
        Map<String, Drug> drugs = new HashMap<>();

        String sql = "SELECT * FROM Drugs";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String supplier = rs.getString("supplier");
                String dateAdded = rs.getString("date_added");

                Drug drug = new Drug(code, name, price, quantity, supplier, dateAdded);
                drugs.put(code, drug);
            }
        } catch (SQLException e) {
            System.out.println("Fetch error: " + e.getMessage());
        }

        return drugs;
    }

    // Method to delete a drug from the database by its code
    public static void deleteDrug(String code) {
        String sql = "DELETE FROM Drugs WHERE code = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }

    

}
