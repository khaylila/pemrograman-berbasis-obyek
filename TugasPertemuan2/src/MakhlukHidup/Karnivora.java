package MakhlukHidup;

public class Karnivora extends Hewan {
    public Karnivora() {
        this.jenisMakanan = "Karnivora";
        System.out.println("=>=>=>Ini adalah konstruktor kelas Karnivora tanpa parameter");
    }

    public Karnivora(String jenisMakanan) {
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas Karnivora dengan satu parameter, yakni jenisMakanan: "
                        + jenisMakanan);
        this.jenisMakanan = jenisMakanan;
    }

    public Karnivora(String jenisMakanan, int jumlahKaki) {
        super();
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas Karnivora dengan parameter jenisMakanan, yakni " + jenisMakanan
                        + " dan jumlahKaki, yakni " + jumlahKaki);
        this.jenisMakanan = jenisMakanan;
        this.jumlahKaki = jumlahKaki;
    }

    public Karnivora(String namaHewan, String asal, int jumlahKaki) {
        System.out.println("=>=>=>Ini adalah hewan " + namaHewan + " yang berasal dari " + asal
                + " dan memiliki kaki berjumlah " + jumlahKaki);
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }
}
