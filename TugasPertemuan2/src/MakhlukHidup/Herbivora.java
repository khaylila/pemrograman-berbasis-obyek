package MakhlukHidup;

public class Herbivora extends Hewan {

    public Herbivora() {
        this.jenisMakanan = "Herbivora";
        System.out.println("=>=>=>Ini adalah konstruktor kelas Herbivora tanpa parameter");
    }

    public Herbivora(String jenisMakanan) {
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas Herbivora dengan satu parameter, yakni jenisMakanan: "
                        + jenisMakanan);
        this.jenisMakanan = jenisMakanan;
    }

    public Herbivora(String jenisMakanan, int jumlahKaki) {
        super();
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas Herbivora dengan parameter jenisMakanan, yakni " + jenisMakanan
                        + " dan jumlahKaki, yakni " + jumlahKaki);
        this.jenisMakanan = jenisMakanan;
        this.jumlahKaki = jumlahKaki;
    }

    public Herbivora(String namaHewan, String asal, int jumlahKaki) {
        System.out.println("=>=>=>Ini adalah hewan " + namaHewan + " yang berasal dari " + asal
                + " dan memiliki kaki berjumlah " + jumlahKaki);
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }
}
