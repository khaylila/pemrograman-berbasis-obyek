package MakhlukHidup;

import java.util.ArrayList;

public class MakhlukHidup {
    private String nama;
    private String asal;
    private String namaFamily;
    protected String jenisMakanan;
    protected ArrayList<String> ciriCiri = new ArrayList<String>();

    public MakhlukHidup() {
        System.out.println("=>Ini adalah konstruktor kelas MakhlukHidup tanpa parameter");
    }

    public MakhlukHidup(String nama) {
        System.out.println("=>Ini adalah konstruktor kelas MakhlukHidup dengan parameter nama, yakni " + nama);
        this.nama = nama;
    }

    public MakhlukHidup(String nama, String asal) {
        System.out.println(
                "=>Ini adalah konstruktor kelas MakhlukHidup dengan parameter nama, yakni " + nama
                        + " dan parameter asal, yakni " + asal);
        this.nama = nama;
        this.asal = asal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getNamaFamily() {
        return namaFamily;
    }

    public void setNamaFamily(String namaFamily) {
        this.namaFamily = namaFamily;
    }
}

// private String bahasaLatin;
// private String subSpecies;
// // bahasaLatin
// public String getBahasaLatin() {
// return bahasaLatin;
// }

// public void setBahasaLatin(String bahasaLatin) {
// this.bahasaLatin = bahasaLatin;
// }

// // subSpecies
// public String getSubSpecies() {
// return subSpecies;
// }

// public void setSubSpecies(String subSpecies) {
// this.subSpecies = subSpecies;
// }
