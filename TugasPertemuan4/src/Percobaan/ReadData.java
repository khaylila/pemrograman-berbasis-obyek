package Percobaan;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/perpustakaan";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    static final String QUERY = "SELECT * FROM books";

    public static void main(String[] args) {
        // Open a connection
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Display values
                System.out.print("id: " + String.valueOf(rs.getObject(1)));
                System.out.print(", name: " + String.valueOf(rs.getObject(2)));
                System.out.print(", pengarang: " + String.valueOf(rs.getObject(3)));
                System.out.print(", jenis: " + String.valueOf(rs.getObject(4)));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
