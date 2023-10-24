/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fauziah
 */
public class Design extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    ArrayList<Makanan> dataMakanan;

    private int masukkanData(Connection conn, int kode_makanan, String nama_makanan, int harga) throws SQLException {
        PreparedStatement pst = conn
                .prepareStatement("INSERT INTO menu_makanan (kode_makanan, nama_makanan, harga) VALUES(?,?,?)");
        pst.setInt(1, kode_makanan);
        pst.setString(2, nama_makanan);
        pst.setInt(3, harga);
        return pst.executeUpdate();
    }

    private int deleteData(Connection conn, int kode_makanan) throws SQLException {
        PreparedStatement pst = conn
                .prepareStatement("DELETE FROM menu_makanan WHERE kode_makanan=?");
        pst.setInt(1, kode_makanan);
        return pst.executeUpdate();
    }

    private int updateData(Connection conn, int kode_makanan, String nama_makanan, int harga) throws SQLException {
        PreparedStatement pst = conn
                .prepareStatement("UPDATE menuMakanan SET namaMakanan=?, harga=? WHERE kode_makanan=? ");
        pst.setString(1, nama_makanan);
        pst.setInt(2, harga);
        pst.setInt(3, kode_makanan);
        return pst.executeUpdate();
    }

    private void tampil(Connection conn) {
        dataMakanan.clear();
        try {
            String sql = "select * from menu_makanan";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Makanan data = new Makanan();
                data.setKodeMakanan(rs.getInt(1));
                data.setMenuMakanan(String.valueOf(rs.getObject(2)));
                data.setHarga(rs.getInt(3));
                dataMakanan.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Makanan data : dataMakanan) {

                Object[] baris = new Object[3];
                baris[0] = data.getKodeMakanan();
                baris[1] = data.getMenuMakanan();
                baris[2] = data.getHarga();
                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form TampilanGUI
     */
    public Design() {
        try {
            dataMakanan = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres",
                    "postgres");
            tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel1.setText("Harga");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel2.setText("Menu makanan ");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jButton2.setText("masukkan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Selamat Datang");

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel4.setText("Kode");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "kode makanan", "nama makanan", "harga"
                }));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jButton4.setText("hapus menu ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jButton3.setText("ubah menu ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(226, 226, 226)
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton2)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton3)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jButton4)
                                                                .addGap(359, 359, 359))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                145,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        145,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        145,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(24, 24, 24)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                242,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                242,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                242,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(329, 329, 329)))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522,
                                                        Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634,
                                                        Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(67, 67, 67)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap()))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int kodeMakanan = Integer.parseInt(jTextField3.getText().trim());
        String namaMakanan = jTextField2.getText();
        int harga = Integer.parseInt(jTextField1.getText().trim());
        if (!namaMakanan.isEmpty()) {
            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan",
                        "postgres",
                        "postgres");

                int k = masukkanData(conn, kodeMakanan, namaMakanan, harga);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("Simpan Berhasil");
                } else {
                    this.peringatan("Simpan Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Input Data Gagal");
        }
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int kodeMakanan = Integer.parseInt(jTextField3.getText().trim());
        System.out.println(kodeMakanan);
        if (kodeMakanan > 0) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan",
                        "postgres",
                        "postgres");
                int k = deleteData(conn, kodeMakanan);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("Hapus berhasil");
                } else {
                    this.peringatan("hapus gagal");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("delete gagal");
        }
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
    }
    // GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int kodeMakanan = Integer.parseInt(jTextField3.getText().trim());
        String namaMakanan = jTextField2.getText();
        int harga = Integer.parseInt(jTextField1.getText().trim());
        if (!namaMakanan.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan",
                        "postgres",
                        "postgres");
                int k = updateData(conn, kodeMakanan, namaMakanan, harga);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("update sukses");
                } else {
                    this.peringatan("update gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("update menu gagal");

        } // GEN-LAST:event_jButton3ActionPerformed
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Design().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
