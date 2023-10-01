package buah;

public class Buah {
    protected String nama = "jeruk";
    protected String jenis;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void beli() {
        System.out.println("Saya membeli buah");
    }

    public void beli(String subjek) {
        System.out.println(subjek + " membeli buah");
    }

    public void beli(int banyaknya) {
        System.out.println("saya membeli buah sebanyak " + banyaknya + "kg");
    }

    public void sout(String[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + ". " + data[i]);
        }
    }
}
