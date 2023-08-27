package MakhlukHidup;

import java.util.ArrayList;

public class MakhlukHidup {
    private String nama;
    private String asal;
    private String namaFamily;
    private String bahasaLatin;
    private String subSpecies;
    protected String jenisMakanan;
    protected ArrayList<String> ciriCiri = new ArrayList<String>();

    // nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // asal
    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    // namaFamily
    public String getNamaFamily() {
        return namaFamily;
    }

    public void setNamaFamily(String namaFamily) {
        this.namaFamily = namaFamily;
    }

    // bahasaLatin
    public String getBahasaLatin() {
        return bahasaLatin;
    }

    public void setBahasaLatin(String bahasaLatin) {
        this.bahasaLatin = bahasaLatin;
    }

    // subSpecies
    public String getSubSpecies() {
        return subSpecies;
    }

    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }
}
