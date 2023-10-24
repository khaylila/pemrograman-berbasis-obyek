/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Database.DaftarBuku;
import java.awt.Cursor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author milea
 */
public class OutputBuku extends javax.swing.JFrame {
    private int id = 0;

    /**
     * Creates new form OutputBuku
     */
    public OutputBuku() {
        try {
            initComponents();
            tampil();
        } catch (Exception e) {
            Logger.getLogger(OutputBuku.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    private void resetField() {
        inputISBN.setText("");
        inputJudulBuku.setText("");
        inputTahunTerbit.setText("");
        inputPenerbit.setText("");
    }

    private void tampil() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("TugasPertemuan9PU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DaftarBuku> querySelectAll = entityManager.createNamedQuery("DaftarBuku.findAll", DaftarBuku.class);
        List<DaftarBuku> results = querySelectAll.getResultList();
        
        DefaultTableModel model = (DefaultTableModel) tabelDaftarBuku.getModel();
        model.setRowCount(0);
        for (DaftarBuku data : results) {
            Object[] baris = new Object[5];
            baris[0] = data.getIdBuku();
            baris[1] = data.getIsbn();
            baris[2] = data.getJudulBuku();
            baris[3] = data.getTahunTerbit();
            baris[4] = data.getPenerbit();
            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputISBN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputJudulBuku = new javax.swing.JTextField();
        inputPenerbit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputTahunTerbit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDaftarBuku = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel1.setText("Daftar Buku");

        inputISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputISBNActionPerformed(evt);
            }
        });

        jLabel2.setText("ISBN");

        jLabel3.setText("Judul Buku");

        inputPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPenerbitActionPerformed(evt);
            }
        });

        jLabel4.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        inputTahunTerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTahunTerbitActionPerformed(evt);
            }
        });

        tabelDaftarBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "ISBN", "Judul Buku", "Penerbit", "Tahun Terbit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDaftarBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDaftarBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDaftarBuku);
        if (tabelDaftarBuku.getColumnModel().getColumnCount() > 0) {
            tabelDaftarBuku.getColumnModel().getColumn(0).setResizable(false);
            tabelDaftarBuku.getColumnModel().getColumn(1).setResizable(false);
            tabelDaftarBuku.getColumnModel().getColumn(2).setResizable(false);
            tabelDaftarBuku.getColumnModel().getColumn(3).setResizable(false);
            tabelDaftarBuku.getColumnModel().getColumn(4).setResizable(false);
        }

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputISBN)
                            .addComponent(inputJudulBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputPenerbit)
                            .addComponent(inputTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsert)
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(inputPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnPrint))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputISBNActionPerformed

    private void inputPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPenerbitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (this.id > 0) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("TugasPertemuan9PU").createEntityManager();
            try {
                entityManager.getTransaction().begin();
                DaftarBuku daftarBuku = entityManager.find(DaftarBuku.class, this.id);
                entityManager.remove(daftarBuku);
                entityManager.getTransaction().commit();
                this.peringatan("Berhasil menghapus data!");
            } catch (Exception e) {
                this.peringatan("Gagal menghapus data. Pesan: " + e.getMessage());
            }
            entityManager.close();
        } else {
            this.peringatan("Pilih data terlebih dahulu!");
        }
        this.resetField();
        this.tampil();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("TugasPertemuan9PU").createEntityManager();
            entityManager.getTransaction().begin();
            TypedQuery<DaftarBuku> querySelectAll = entityManager.createNamedQuery("DaftarBuku.findAll", DaftarBuku.class);
            List<DaftarBuku> results = querySelectAll.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();

            String jrxmlFile = new String("src/report/daftarBukuJPA.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, new JRBeanCollectionDataSource(results));
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(OutputBuku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(OutputBuku.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String isbn = inputISBN.getText();
        String judulBuku = inputJudulBuku.getText();
        int tahunTerbit = Integer.parseInt(inputTahunTerbit.getText());
        String penerbit = inputPenerbit.getText();
        if (!isbn.isEmpty() && !judulBuku.isEmpty() && !penerbit.isEmpty() && tahunTerbit > 0) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("TugasPertemuan9PU").createEntityManager();
            try {
                entityManager.getTransaction().begin();
                DaftarBuku daftarBuku = new DaftarBuku();
                daftarBuku.setIsbn(isbn);
                daftarBuku.setJudulBuku(judulBuku);
                daftarBuku.setPenerbit(penerbit);
                daftarBuku.setTahunTerbit(Integer.toString(tahunTerbit));
                entityManager.persist(daftarBuku);
                entityManager.getTransaction().commit();
                this.peringatan("Berhasil menambahkan data!");
            } catch (Exception e) {
                this.peringatan("Tambah data gagal. Pesan: " + e.getMessage());
            }
            entityManager.close();
        } else {
            this.peringatan("Input Data Buku Gagal");
        }
        this.tampil();
        this.resetField();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (this.id != 0) {
            String isbn = inputISBN.getText();
            String judulBuku = inputJudulBuku.getText();
            int tahunTerbit = Integer.parseInt(inputTahunTerbit.getText());
            String penerbit = inputPenerbit.getText();
            if (!isbn.isEmpty() && !judulBuku.isEmpty() && !penerbit.isEmpty() && tahunTerbit > 0) {
                EntityManager entityManager = Persistence.createEntityManagerFactory("TugasPertemuan9PU").createEntityManager();
                try {
                    entityManager.getTransaction().begin();
                    DaftarBuku daftarBuku = entityManager.find(DaftarBuku.class, this.id);
                    daftarBuku.setIsbn(isbn);
                    daftarBuku.setJudulBuku(judulBuku);
                    daftarBuku.setPenerbit(penerbit);
                    daftarBuku.setTahunTerbit(Integer.toString(tahunTerbit));
                    entityManager.merge(daftarBuku);
                    entityManager.getTransaction().commit();
                    this.peringatan("Berhasil mengubah data!");
                } catch (Exception e) {
                    entityManager.getTransaction().rollback();
                    this.peringatan("Gagal mengubah data. Pesan peringantan: " + e.getMessage());
                }
                entityManager.close();
            } else {
                this.peringatan("Update Data Mahasiswa Gagal");
            }
            this.tampil();
            this.resetField();
        } else {
            this.peringatan("Pilih data terlebih dahulu!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tabelDaftarBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDaftarBukuMouseClicked
        // TODO add your handling code here:
        rootPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        inputISBN.setEditable(false);
        inputJudulBuku.setEditable(false);
        inputPenerbit.setEditable(false);
        inputTahunTerbit.setEditable(false);
        JTable target = (JTable) evt.getSource();
        int row = target.getSelectedRow();
        this.id = Integer.parseInt(target.getModel().getValueAt(row, 0).toString());

        EntityManager entityManager = Persistence.createEntityManagerFactory("TugasPertemuan9PU").createEntityManager();
        entityManager.getTransaction().begin();
        DaftarBuku daftarBuku = entityManager.find(DaftarBuku.class, this.id);
        entityManager.getTransaction().commit();
        entityManager.close();

        inputISBN.setText(daftarBuku.getIsbn());
        inputJudulBuku.setText(daftarBuku.getJudulBuku());
        inputPenerbit.setText(daftarBuku.getPenerbit());
        inputTahunTerbit.setText(daftarBuku.getTahunTerbit());

        inputISBN.setEditable(true);
        inputJudulBuku.setEditable(true);
        inputPenerbit.setEditable(true);
        inputTahunTerbit.setEditable(true);
        rootPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tabelDaftarBukuMouseClicked

    private void inputTahunTerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTahunTerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTahunTerbitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OutputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OutputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OutputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OutputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OutputBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField inputISBN;
    private javax.swing.JTextField inputJudulBuku;
    private javax.swing.JTextField inputPenerbit;
    private javax.swing.JTextField inputTahunTerbit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDaftarBuku;
    // End of variables declaration//GEN-END:variables
}
