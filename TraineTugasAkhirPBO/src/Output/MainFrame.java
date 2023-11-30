/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Output;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author milea
 */
public class MainFrame extends javax.swing.JFrame {
    protected EntityManager entityManager;

    public MainFrame() {
        this.entityManager = Persistence.createEntityManagerFactory("TraineTugasAkhirPBOPU").createEntityManager();
    }
    
    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    public void beginTransaction(){
        this.entityManager.getTransaction().begin();
    }
    
    public void commitTransaction(){
        this.entityManager.getTransaction().commit();
    }
    
    public void rollbackTransaction(){
        this.entityManager.getTransaction().rollback();
    }
    
    public void persist(Object obj){
        this.entityManager.persist(obj);
    }
}
