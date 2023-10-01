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
public class Ovipar extends Hewan {

    private int mengeramiTelur;
    private String letakTelur;

    public Ovipar() {
        // this.setCaraBerkembangbiak(CaraBerkembangbiak);
        // ?? ini ngambil variabel dari manaa?
        // this.setCaraBerkembangbiak(caraBerkembangbiak);
        // ngakalinnya jadi gini
        this.setCaraBerkembangbiak(this.getCaraBerkembangbiak());
    }

    public Ovipar(String jenisMakanan) {
        // jenis makanan private, gabisa gini
        // this.jenisMakanan = "tumbuhan";
        // jadiii
        this.setJenisMakanan("tumbuhan");
        // atau bisa pake parameter
        this.setJenisMakanan(jenisMakanan);
    }

    public int getMengeramiTelur() {
        return mengeramiTelur;
    }

    public String getLetakTelur() {
        return letakTelur;
    }

    /**
     * @param mengeramiTelur the mengeramiTelur to set
     */
    public void setMengeramiTelur(int mengeramiTelur) {
        this.mengeramiTelur = mengeramiTelur;
    }

    /**
     * @param letakTelur the letakTelur to set
     */
    public void setLetakTelur(String letakTelur) {
        this.letakTelur = letakTelur;
    }

}
