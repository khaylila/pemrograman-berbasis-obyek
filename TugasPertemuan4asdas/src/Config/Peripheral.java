package Config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Peripheral {
    private Database db;
    public boolean loop = true;

    public Peripheral() {
        String[] config = { "books", "id" };
        this.db = new Database(config);
    }

    public void banner() {
        System.out.println("=================================================");
        System.out.println("=================================================");
        System.out.println("==========  Selamat datang di Bukarta  ==========");
        System.out.println("=================================================");
        System.out.println("=================================================");
    }

    public void daftarMenu() {
        System.out.println("=Menu=");
        System.out.println("1. Tambahkan daftar");
        System.out.println("2. Tampilkan daftar");
        System.out.println("3. Ubah data");
        System.out.println("4. Hapus data buku");
        System.out.println("5. Exit");
    }

    public void runMenu() {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int input = 0;
        while (input < 1 || input > 5) {
            if (count > 0) {
                System.out.println("Masukkan tidak sesuai, coba kembali!");
            }
            System.out.print("Pilih menu: ");
            input = Integer.parseInt(scan.next());
            count++;
        }
        if (input == 1) {
            this.tambahBuku();
        } else if (input == 2) {
            this.loop = true;
            this.daftarBuku();
        } else if (input == 3) {
            this.ubahBuku();
        } else if (input == 4) {
            this.hapusBuku();
        } else {
            this.loop = false;
        }
    }

    public void tambahBuku() {
        String[] buku = new String[3];
        System.out.println("===Tambah Buku===");
        System.out.println("ID buku\t\t\t: " + (this.db.getLastID() + 1));
        buku[0] = this.validateInput("Masukkan judul buku\t: ", false);
        buku[1] = this.validateInput("Masukkan pengarang buku\t: ", false);
        buku[2] = this.validateInput("Masukkan jenis buku\t: ", false);

        System.out.println(this.db.insert(buku)
                ? "=>Berhasil menambahkan data!"
                : "=>Gagal menambah data!");
    }

    public void ubahBuku() {
        System.out.println("===Ubah Buku===");
        String[] buku = new String[3];
        int id = Integer.parseInt(validateInput("Pilih id yang akan diubah: ", false));
        if (!this.db.checkData(id)) {
            System.out.println("=>Data tidak ditemukan!");
        } else {
            try {
                ResultSet result = this.db.findId(id);
                if (result.next()) {
                    System.out.println("Data yang akan diubah:");
                    System.out.println("id\t\t: " + result.getString("id"));
                    System.out.println("judul\t\t: " + result.getString("name"));
                    System.out.println("pengarang\t: " + result.getString("pengarang"));
                    System.out.println("jenis\t\t: " + result.getString("jenis"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("= >Biarkan kosong jika tidak ingin merubah data< =");
            buku[0] = this.validateInput("Masukkan judul baru\t: ", true);
            buku[1] = this.validateInput("Masukkan pengarang baru\t: ", true);
            buku[2] = this.validateInput("Masukkan jenis baru\t: ", true);

            System.out.println(this.db.update(buku, id)
                    ? "=>Berhasil mengubah data!"
                    : "=>Gagal mengubah data");
        }
    }

    public void daftarBuku() {
        System.out.println("===Daftar Buku===");
        try {
            System.out.println("ID" + "\t" + "Judul Buku" + "\t\t" + "Pengarang" + "\t"
                    + "Jenis buku");

            ResultSet result = this.db.getData("*");
            while (result.next()) {
                System.out.println(String.valueOf(result.getObject(1)) + "\t" +
                        String.valueOf(result.getObject(2)) + "\t" +
                        String.valueOf(result.getObject(3)) + "\t" +
                        String.valueOf(result.getObject(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusBuku() {
        int id = Integer.parseInt(this.validateInput("Masukkan id yang ingin duhapus: ", false));
        if (!this.db.checkData(id)) {
            System.out.println("=>Data tidak ditemukan!");
        } else {
            System.out.println(this.db.delete(id)
                    ? "=>Data berhasil dihapus!"
                    : "=>Data gagal dihapus!");
        }

    }

    private String validateInput(String note, boolean allowEmpty) {
        System.out.print(note);
        Scanner scan = new Scanner(System.in);
        String input = "";
        int count = 0;
        if (allowEmpty) {
            input = scan.nextLine();
        } else {
            while (input.equals("")) {
                input = scan.nextLine();
                if (count > 0) {
                    System.out.println("Masukkan tidak sesuai, coba kembali!");
                }
                count++;
            }
        }
        return input;
    }
}
