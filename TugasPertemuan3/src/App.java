import buah.Buah;
import buah.Durian;
import buah.Mangga;

public class App {
    public static void main(String[] args) {
        Mangga mangga = new Mangga();
        System.out.println("Ini adalah buah " + mangga.getNama());
        System.out.println("Buah ini berjenis " + mangga.getJenis());
        mangga.beli();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Durian durian = new Durian();
        System.out.println("Ini adalah buah " + durian.getNama());
        System.out.println("Buah ini berjenis " + durian.getJenis());
        durian.beli("Ibu Titin");
        durian.deskripsiBentuk();
        durian.caraMemakan();
        durian.caraMenanam();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Buah b = new Buah();
        System.out.println("b adalah buah " + b.getNama());
        b.setJenis("Bali");
        System.out.println("b adalah jenis buah " + b.getJenis());
        b.beli(12);
    }
}
