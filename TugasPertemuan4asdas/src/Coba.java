import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coba {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/BDL_C_M2T_09020622033";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    static final String QUERY = "SELECT * FROM mata_kuliah";

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                // Display values
                System.out.print("kode mata kuliah: " + String.valueOf(rs.getObject(1)));
                System.out.print(", nama mata kuliah: " + String.valueOf(rs.getObject(2)));
                System.out.print(", sks: " + String.valueOf(rs.getObject(3)));
                System.out.print(", semester: " + String.valueOf(rs.getObject(4)));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}