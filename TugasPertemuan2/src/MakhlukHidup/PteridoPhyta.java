package MakhlukHidup;

public class PteridoPhyta extends Tumbuhan {
    public PteridoPhyta() {
        this.jenisMakanan = "Daun";
        System.out.println("=>=>=>Ini adalah konstruktor kelas PteridoPhyta tanpa parameter");
    }

    public PteridoPhyta(String jenisMakanan) {
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas PteridoPhyta dengan satu parameter, yakni jenisMakanan:  "
                        + jenisMakanan);
        this.jenisMakanan = jenisMakanan;
    }

    public PteridoPhyta(String jenisMakanan, String bentukDaun) {
        super();
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas PteridoPhyta dengan parameter jenisMakanan, yakni " + jenisMakanan
                        + " dan bentukDaun, yakni " + bentukDaun);
        this.jenisMakanan = jenisMakanan;
    }
}
