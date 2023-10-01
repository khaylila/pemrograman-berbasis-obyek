package MakhlukHidup;

import java.util.ArrayList;

public class Hewan extends MakhlukHidup {
    public int jumlahKaki = 0;

    public Hewan() {
        super("gajah");
        System.out.println("=>=>Ini adalah konstruktor kelas Hewan tanpa parameter");
    }

    public Hewan(String nama) {
        super(nama);
        System.out.println("=>=>Ini adalah konstruktor kelas Hewan dengan parameter nama, yakni " + nama);
    }

    public Hewan(String nama, String asal) {
        super(nama, asal);
        System.out.println("=>=>Ini adalah konstruktor kelas Hewan dengan parameter nama, yakni " + nama
                + " dan parameter asal, yakni " + asal);
    }

    public ArrayList<String> getCiriCiri() {
        return ciriCiri;
    }

    public void addCiriCiri(String ciriCiri) {
        this.ciriCiri.add(ciriCiri);
    }
}
