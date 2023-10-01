package MakhlukHidup;

public class BryPhyta extends Tumbuhan {
    public BryPhyta() {
        this.jenisMakanan = "Daun";
        System.out.println("=>=>=>Ini adalah konstruktor kelas BryPhyta tanpa parameter");
    }

    public BryPhyta(String jenisMakanan) {
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas BryPhyta dengan satu parameter, yakni jenisMakanan:  "
                        + jenisMakanan);
        this.jenisMakanan = jenisMakanan;
    }

    public BryPhyta(String jenisMakanan, String bentukDaun) {
        super();
        System.out.println(
                "=>=>=>Ini adalah konstruktor kelas BryPhyta dengan parameter jenisMakanan, yakni " + jenisMakanan
                        + " dan bentukDaun, yakni " + bentukDaun);
        this.jenisMakanan = jenisMakanan;
    }
}
