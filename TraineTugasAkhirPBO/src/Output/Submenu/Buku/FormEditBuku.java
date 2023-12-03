/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Output.Submenu.Buku;

import Database.Books;
import Database.Categories;
import Database.Students;
import Database.Users;
import Output.MainFrame;
import Output.Submenu.Kategori;
import Output.Submenu.Mahasiswa.CariPenyumbangBuku;
import View.BookNew;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author milea
 */
public class FormEditBuku extends MainFrame {

    int userId;
    Students student;
    List<Categories> listSelectedCategory = new ArrayList<>();
    Books buku;
    protected File file;
    protected String path;
    protected ImageIcon imgIcon;

    /**
     * Creates new form FormBuku
     */
    public FormEditBuku() {
        TypedQuery<Books> getBukuById = entityManager.createNamedQuery("Books.findByBookId", Books.class);
        getBukuById.setParameter("bookId", 1);
        this.buku = getBukuById.getSingleResult();
        try {
            initComponents();

            inputJudul.setText(this.buku.getJudul());
            inputIsbn.setText(this.buku.getIsbn());
            inputJumlahHalaman.setText(String.valueOf(this.buku.getJumlahHalaman() == null ? "" : this.buku.getJumlahHalaman()));
            inputSubJudul.setText(this.buku.getSubJudul());
            inputPengarang.setText(this.buku.getPengarang());
            inputPenerbit.setText(this.buku.getPenerbit());
            inputTahunTerbit.setText(this.buku.getTahunTerbit());
            inputBanyaknya.setText(String.valueOf(this.buku.getBanyaknya()));
            labelPreview.setIcon(this.getImageFromDatabase(this.buku.getFotoSampul(), 150));
            inputStudentId.setText(this.buku.getStudentId() != null ? this.buku.getStudentId().getFullname() : "");

            String kategoriText = "";
            int i = 1;
            for (Categories kategori : this.buku.getCategoriesList()) {
                kategoriText += kategori.getNama();
                if (i != this.buku.getCategoriesList().size()) {
                    kategoriText += ", ";
                }
                i++;
                this.listSelectedCategory.add(kategori);
            }
            inputKategori.setText(kategoriText);

            this.student = this.buku.getStudentId();
            this.listSelectedCategory = this.buku.getCategoriesList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            this.dispose();
            this.peringatan("Buku tidak ditemukan!");
        }
    }

    public FormEditBuku(int userId, int bookId) {
        this.userId = userId;
        TypedQuery<Books> getBukuById = entityManager.createNamedQuery("Books.findByBookId", Books.class);
        getBukuById.setParameter("bookId", bookId);
        this.buku = getBukuById.getSingleResult();
        try {
            initComponents();

            inputJudul.setText(this.buku.getJudul());
            inputIsbn.setText(this.buku.getIsbn());
            inputJumlahHalaman.setText(String.valueOf(this.buku.getJumlahHalaman() == null ? "" : this.buku.getJumlahHalaman()));
            inputSubJudul.setText(this.buku.getSubJudul());
            inputPengarang.setText(this.buku.getPengarang());
            inputPenerbit.setText(this.buku.getPenerbit());
            inputTahunTerbit.setText(this.buku.getTahunTerbit());
            inputBanyaknya.setText(String.valueOf(this.buku.getBanyaknya()));
            labelPreview.setIcon(this.getImageFromDatabase(this.buku.getFotoSampul(), 150));
            inputStudentId.setText(this.buku.getStudentId() != null ? this.buku.getStudentId().getFullname() : "");

            String kategoriText = "";
            int i = 1;
            for (Categories kategori : this.buku.getCategoriesList()) {
                kategoriText += kategori.getNama();
                if (i != this.buku.getCategoriesList().size()) {
                    kategoriText += ", ";
                }
                i++;
                this.listSelectedCategory.add(kategori);
            }
            inputKategori.setText(kategoriText);

            this.student = this.buku.getStudentId();
            this.listSelectedCategory = this.buku.getCategoriesList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            this.dispose();
            this.peringatan("Buku tidak ditemukan!");
        }
    }

    public void setMahasiswaId(int studentId) {
        System.out.println("studentID " + studentId);
        TypedQuery<Students> getStudentById = entityManager.createNamedQuery("Students.findByStudentId", Students.class);
        getStudentById.setParameter("studentId", studentId);
        Students student = getStudentById.getSingleResult();
        this.student = student;
        inputStudentId.setText(student.getFullname());
    }

    public void setKategoriBuku(ArrayList<Integer> listSelectedCategory) {
        this.listSelectedCategory.clear();
        int i = 1;
        String kategoriText = "";
        for (Integer data : listSelectedCategory) {
            TypedQuery<Categories> categoriesById = entityManager.createNamedQuery("Categories.findByKategoriId", Categories.class);
            categoriesById.setParameter("kategoriId", data);
            Categories kategori = categoriesById.getSingleResult();
            kategoriText += kategori.getNama();
            if (i != listSelectedCategory.size()) {
                kategoriText += ", ";
            }
            i++;
            this.listSelectedCategory.add(kategori);
        }
        inputKategori.setText(kategoriText);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputPengarang = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        inputPenerbit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputTahunTerbit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputIsbn = new javax.swing.JTextField();
        labelPreview = new javax.swing.JLabel();
        inputJudul = new javax.swing.JTextField();
        inputSubJudul = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        inputStudentId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputKategori = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        inputBanyaknya = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        inputJumlahHalaman = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Buku");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Judul Buku");

        inputPengarang.setColumns(20);
        inputPengarang.setRows(5);
        inputPengarang.setPreferredSize(new java.awt.Dimension(200, 30));
        jScrollPane1.setViewportView(inputPengarang);

        jLabel4.setText("Sub Judul");

        jLabel5.setText("Pengarang");

        jLabel6.setText("Penerbit");

        jLabel7.setText("Tahun Terbit");

        jLabel8.setText("Gambar Sampul");

        labelPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/upload-150x150.png"))); // NOI18N
        labelPreview.setText("jLabel9");
        labelPreview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPreviewMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/logo-30x30.png"))); // NOI18N
        jLabel1.setText("Ubah Buku");

        jLabel2.setText("ISBN");

        btnSave.setBackground(new java.awt.Color(255, 204, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/save-30x30.png"))); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        inputStudentId.setEditable(false);
        inputStudentId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputStudentIdMouseClicked(evt);
            }
        });

        jLabel9.setText("Penyumbang");

        inputKategori.setEditable(false);
        inputKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputKategoriMouseClicked(evt);
            }
        });

        jLabel10.setText("Kategori");

        jLabel11.setText("Banyaknya");

        jLabel12.setText("Jml Halaman");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputKategori)
                                    .addComponent(inputBanyaknya)
                                    .addComponent(inputStudentId)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputJumlahHalaman)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                    .addComponent(inputSubJudul)
                                    .addComponent(inputJudul)
                                    .addComponent(inputIsbn)
                                    .addComponent(inputTahunTerbit)
                                    .addComponent(inputPenerbit))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel8)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReset)
                                    .addComponent(labelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputSubJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputJumlahHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(inputBanyaknya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelPreviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPreviewMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnxf = new FileNameExtensionFilter("PNG, JPG AND JPEG", "png", "jpg", "jpeg");
        fileChooser.addChoosableFileFilter(fnxf);
        int load = fileChooser.showOpenDialog(null);

        if (load == fileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();

            path = file.getAbsolutePath();
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            labelPreview.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_labelPreviewMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (this.student == null) {
            this.peringatan("Pilih mahasiswa terlebih dahulu!");
        } else if (this.listSelectedCategory == null) {
            this.peringatan("Pilih kategori terlebih dahulu!");
        } else {
            String isbn = inputIsbn.getText().trim();
            String judul = inputJudul.getText().trim();
            String subJudul = inputSubJudul.getText().trim();
            String pengarang = inputPengarang.getText().trim();
            String penerbit = inputPenerbit.getText().trim();
            String tahunTerbit = inputTahunTerbit.getText().trim();
            String jumlahHalaman = inputJumlahHalaman.getText().trim();
            int banyaknya = Integer.parseInt(inputBanyaknya.getText().trim());

            if (isbn.isEmpty() || judul.isEmpty() || subJudul.isEmpty() || pengarang.isEmpty() || penerbit.isEmpty() || tahunTerbit.isEmpty() || jumlahHalaman.isEmpty() || banyaknya <= 0) {
                this.peringatan("Data tidak boleh kosong!");
            } else {
                try {
                    Books selectedBook = this.buku;
                    selectedBook.setIsbn(isbn);
                    selectedBook.setJudul(judul);
                    selectedBook.setSubJudul(subJudul);
                    selectedBook.setPenerbit(penerbit);
                    selectedBook.setPengarang(pengarang);
                    selectedBook.setTahunTerbit(tahunTerbit);
                    selectedBook.setJumlahHalaman(Integer.valueOf(jumlahHalaman));
                    selectedBook.setBanyaknya(banyaknya);
                    if (file != null) {
                        InputStream is = new FileInputStream(file);
                        selectedBook.setFotoSampul(is.readAllBytes());
                    }

                    TypedQuery<Users> queryGetUsername = entityManager.createNamedQuery("Users.findByUserId", Users.class);
                    queryGetUsername.setParameter("userId", userId);
                    Users result = queryGetUsername.getSingleResult();
                    selectedBook.setUserId(result);
                    Date date = new Date();
                    selectedBook.setUpdatedAt(date);

                    selectedBook.setCategoriesList(listSelectedCategory);

                    selectedBook.setStudentId(student);

                    entityManager.getTransaction().begin();
                    entityManager.merge(selectedBook);
                    entityManager.getTransaction().commit();
                    this.peringatan("Berhasil menyimpan Buku");
                    this.dispose();
                } catch (FileNotFoundException e) {
                    this.peringatan("File tidak ditemukan!");
                    entityManager.getTransaction().rollback();
                } catch (IOException e) {
                    this.peringatan("Terjadi kesalahan!");
                    entityManager.getTransaction().rollback();
                }

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        file = null;
        try {
            InputStream inputStream = FormEditBuku.class.getResourceAsStream("/assets/img/upload-150x150.png");
            if (inputStream == null) {
                this.peringatan("File tidak ditemukan.");
            }
            byte[] imgData = inputStream.readAllBytes();

            ImageIcon ii = new ImageIcon(imgData);
            Image img = ii.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            labelPreview.setIcon(new ImageIcon(img));

        } catch (IOException e) {
            this.peringatan("File tidak ditemukan");
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void inputStudentIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputStudentIdMouseClicked
        // TODO add your handling code here:
        new CariPenyumbangBuku(this, userId).setVisible(true);
    }//GEN-LAST:event_inputStudentIdMouseClicked

    private void inputKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputKategoriMouseClicked
        // TODO add your handling code here:
        new Kategori(this, userId).setVisible(true);
    }//GEN-LAST:event_inputKategoriMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new ViewBuku(userId, this.buku.getBookId()).setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(FormEditBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEditBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEditBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEditBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEditBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField inputBanyaknya;
    private javax.swing.JTextField inputIsbn;
    private javax.swing.JTextField inputJudul;
    private javax.swing.JTextField inputJumlahHalaman;
    private javax.swing.JTextField inputKategori;
    private javax.swing.JTextField inputPenerbit;
    private javax.swing.JTextArea inputPengarang;
    private javax.swing.JTextField inputStudentId;
    private javax.swing.JTextField inputSubJudul;
    private javax.swing.JTextField inputTahunTerbit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPreview;
    // End of variables declaration//GEN-END:variables
}