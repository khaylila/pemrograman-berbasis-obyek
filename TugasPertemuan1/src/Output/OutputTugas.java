package Output;

import java.util.ArrayList;
import MakhlukHidup.Herbivora;

public class OutputTugas {
    public static void main(String[] args) {
        Herbivora gajah = new Herbivora("empal");
        gajah.setNama("Gajah Sumatra");
        gajah.setAsal("Pulau Sumatra, Indonesia");
        gajah.setBahasaLatin("Elephas maximus sumatranus");
        gajah.setSubSpecies("Gajah Asia");
        gajah.jumlahKaki = 4;
        gajah.addCiriCiri("Badannya besar");
        gajah.addCiriCiri("Hidungnya panjang");
        gajah.addCiriCiri("Telinganya lebar");

        // Sysout
        System.out.println(gajah.getNama()
                + " yang memiliki bahasa latin " + gajah.getBahasaLatin()
                + " adalah subspesies dari " + gajah.getSubSpecies()
                + " yang berasal dari " + gajah.getAsal()
                + " dan berjenis " + gajah.getJenisMakanan() + ".");
        System.out.println("Makanan " + gajah.getJenisMakanan());
        System.out.println(gajah.getNama()
                + " memiliki " + gajah.jumlahKaki + " kaki.");
        System.out.println(gajah.getNama()
                + " memiliki ciri-ciri: ");
        ArrayList<String> ciriCiri = gajah.getCiriCiri();
        for (int i = 0; i < ciriCiri.size(); i++) {
            System.out.println((i + 1) + ". " + ciriCiri.get(i));
        }
    }
}
