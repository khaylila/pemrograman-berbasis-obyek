package MakhlukHidup;

public class Herbivora extends Hewan {

    public Herbivora() {
       this.jenisMakanan = "Herbivora";
    }
    
    public Herbivora(String jenisMakanan){
        this.jenisMakanan = jenisMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }
}
