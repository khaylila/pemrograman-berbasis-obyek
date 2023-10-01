package MakhlukHidup;

public class SpermatoPhyta extends Tumbuhan {
    public SpermatoPhyta() {
        this.jenisMakanan = "Daun";
        System.out.println("=>=>=>Ini adalah konstruktor kelas SpermatoPhyta tanpa parameter");
    }

    public SpermatoPhyta(String jenisMakanan) {
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas SpermatoPhyta dengan satu parameter, yakni jenisMakanan:  "
                        + jenisMakanan);
        this.jenisMakanan = jenisMakanan;
    }

    public SpermatoPhyta(String jenisMakanan, String bentukDaun) {
        super();
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas SpermatoPhyta dengan parameter jenisMakanan, yakni " + jenisMakanan
                        + " dan bentukDaun, yakni " + bentukDaun);
        this.jenisMakanan = jenisMakanan;
    }
}
