package Percobaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/perpustakaan";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    static final String QUERY = "INSERT INTO public.books(id, name, pengarang, jenis) VALUES (?, ?, ?, ?);";

    public static void main(String[] args) {
        // Open a connection
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "Dan");
            preparedStatement.setString(3, "Sheila");
            preparedStatement.setString(4, "Lagu");
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Berhasil ditambahkan");
            } else {
                System.out.println("Gagal ditambahkan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
