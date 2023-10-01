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
public class MakhlukHidup {
    private String nama;
    private int umur;

  public MakhlukHidup () {
      System.out.println("ini adalah kelinci");
  }
  public MakhlukHidup(int umur) {
      System.out.println(umur);
  }
  
  public MakhlukHidup(String nama) {
      this.nama = "rabbit"; 
  } 
  
    public String getNama() {
        return nama;
    }

    /**
     * @return the umur
     */
    public int getUmur() {
        return umur;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @param umur the umur to set
     */
    public void setUmur(int umur) {
        this.umur = umur;
    }
            
}

       