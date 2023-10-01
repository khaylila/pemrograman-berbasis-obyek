package buah;

public class Mangga extends Buah {
    public Mangga() {
        this.nama = "mangga";
        this.setJenis();
    }

    public void setJenis() {
        super.setJenis("Manalagi");
        System.out.println("Berhasil mengubah jenis buah!");
    }
}
