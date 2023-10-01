package MakhlukHidup;

public class Omnivora extends Hewan {
    public Omnivora() {
        this.jenisMakanan = "Omnivora";
        System.out.println("=>=>=>Ini adalah konstruktor kelas Omnivora tanpa parameter");
    }

    public Omnivora(String jenisMakanan) {
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas Omnivora dengan satu parameter, yakni jenisMakanan:  "
                        + jenisMakanan);
        this.jenisMakanan = jenisMakanan;
    }

    public Omnivora(String jenisMakanan, int jumlahKaki) {
        super();
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas Omnivora dengan parameter jenisMakanan, yakni " + jenisMakanan
                        + " dan jumlahKaki, yakni " + jumlahKaki);
        this.jenisMakanan = jenisMakanan;
        this.jumlahKaki = jumlahKaki;
    }

    public Omnivora(String namaHewan, String asal, int jumlahKaki) {
        System.out.println("=>=>=>Ini adalah hewan " + namaHewan + " yang berasal dari " + asal
                + " dan memiliki kaki berjumlah " + jumlahKaki);
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }
}
