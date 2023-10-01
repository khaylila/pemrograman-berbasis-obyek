/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.tugas;

/**
 *
 * @author fauziah
 */
public class Ovovivipar extends Hewan {

    public Ovovivipar() {
        // ini private, makanya error
        // super(caraBerkembangbiak);
        // cara ngakalinnya pake getter
        super.setCaraBerkembangbiak("bertelur");
        // aku bikin constructor baru di line 21-23 di kelas hewan
    }

    public Ovovivipar(String jenisMakanan) {
        super.setJenisMakanan(jenisMakanan);

    }

    public Ovovivipar(String jenisMakanan, String habitat) {
        this.setJenisMakanan(jenisMakanan);
        this.setHabitat(habitat);
    }

}
