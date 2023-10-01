package Percobaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author fauziah
 */
public class Delete {

    public static void main(String[] args) {
        String delete = "DELETE FROM menu_makanan WHERE kode_makanan=?";

        try {
            // Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres",
                    "postgres");
            PreparedStatement pstmt = conn.prepareStatement(delete);
            System.out.print("Masukkan kode yang akan dihapus: ");
            Scanner in = new Scanner(System.in);
            int hapus = in.nextInt();
            // int hapus_kode_makanan = Integer.parseInt(hapus);
            System.out.println("hapus");
            pstmt.setInt(1, hapus);
            int k = pstmt.executeUpdate();
            if (k > 0) {
                System.out.println("Hapus kode_makanan " + hapus + " BERHASIL ");
            } else {
                System.out.println("Hapus kode_makanan" + hapus + "GAGAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}