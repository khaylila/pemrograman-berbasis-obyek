package buah;

import appInt.Bentuk;
import appInt.Makan;
import appInt.Tanam;

public class Durian extends Buah implements Bentuk, Makan, Tanam {
    public Durian() {
        this.nama = "durian";
        this.setJenis();
    }

    public void setJenis() {
        super.setJenis("Musang King");
        System.out.println("Berhasil mengubah jenis buah!");
    }

    @Override
    public void deskripsiBentuk() {
        System.out.println("Deskripsi bentuk:");
        String[] bentuk = {
                "Berbentuk tidak teratur.",
                "Baunya menyengat.",
                "Memiliki duri.",
                "Ada yang besar dan ada yang kecil."
        };
        this.sout(bentuk);
    }

    @Override
    public void caraMemakan() {
        System.out.println("Cara memakan:");
        String[] caraMakan = {
                "Membeli durian.",
                "Membuka kulitnya dengan pisau.",
                "Lalu memakannya."
        };
        this.sout(caraMakan);
    }

    @Override
    public void caraMenanam() {
        System.out.println("Cara menanam:");
        String[] caraTanam = {
                "Menyiapkan bibit durian",
                "Menyiapkan lahan penanaman",
                "Bibit ditanam",
                "Bibit disiram setiap hari",
                "Diberi pupuk",
                "Membasmi hama",
                "Dipanen"
        };
        this.sout(caraTanam);
    }

    public void beli(String subjek) {
        System.out.println(subjek + " membeli durian");
    }
}
