/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.tugas;

public class Hewan extends MakhlukHidup {
    private String jenisMakanan;
    private String habitat;
    private String caraBerkembangbiak;

    public Hewan(int i) {
        System.out.println(i);
    }

    public Hewan() {

    }

    public Hewan(String caraBerkembangBiak) {
        System.out.println(caraBerkembangBiak);
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    /**
     * @return the habitat
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * @return the caraBerkembangbiak
     */
    public String getCaraBerkembangbiak() {
        return caraBerkembangbiak;
    }

    /**
     * @param jenisMakanan the jenisMakanan to set
     */
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    /**
     * @param habitat the habitat to set
     */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    /**
     * @param caraBerkembangbiak the caraBerkembangbiak to set
     */
    public void setCaraBerkembangbiak(String caraBerkembangbiak) {
        this.caraBerkembangbiak = caraBerkembangbiak;
    }
}
