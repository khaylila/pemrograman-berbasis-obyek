/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Output.Submenu.Buku.FormBuku;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;
import Database.Books;
import Database.Categories;
import Output.Submenu.Buku.ViewBuku;
import Output.Submenu.Dashboard;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
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
public class BookNew extends javax.swing.JPanel {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("TraineTugasAkhirPBOPU").createEntityManager();
    protected int userId;
    protected String category = "all";
//    protected List<Categories> listKategori = new ArrayList<>();
    protected ArrayList<Integer> listBooksId = new ArrayList<>();
    protected Object obj;

    /**
     * Creates new form BookNew
     */
    public BookNew() {
        initComponents();
    }

    public BookNew(Object obj, int userId) {
        this.obj = obj;
        this.userId = userId;
        initComponents();
        TypedQuery<Categories> queryAllCategories = entityManager.createNamedQuery("Categories.findAll", Categories.class);
        orderByKategori.removeAllItems();
        orderByKategori.addItem("All");
        for (Categories kategori : queryAllCategories.getResultList()) {
//            this.listKategori.add(kategori);
            orderByKategori.addItem(kategori.getNama());
        }
        loadTabel();
    }

    private List<Books> getQueryResult() {
        String search = inputSearch.getText().trim();
        if (search.equalsIgnoreCase("search")) {
            search = "";
        }
        int filter = searchBy.getSelectedIndex();
        String query;
//        if (!search.equals("")) {
        if (category.equalsIgnoreCase("all")) {
            query = "Books.findByLikeIsbn";
            if (filter == 1) {
                query = "Books.findByLikeJudul";
            } else if (filter == 2) {
                query = "Books.findByLikePengarang";
            } else if (filter == 3) {
                query = "Books.findByLikePenerbit";
            } else if (filter == 4) {
                query = "Books.findBytahunTerbit";
            }
        } else {
            query = "Books.findByLikeIsbnWithKategori";
            if (filter == 1) {
                query = "Books.findByLikeJudulWithKategori";
            } else if (filter == 2) {
                query = "Books.findByLikePengarangWithKategori";
            } else if (filter == 3) {
                query = "Books.findByLikePenerbitWithKategori";
            } else if (filter == 4) {
                query = "Books.findByLikeTahunTerbitWithKategori";
            }
        }
//        } else {
//            query = "Books.findAllWithKategori";
//        }

        TypedQuery<Books> queryListBooks = null;
        queryListBooks = entityManager.createNamedQuery(query, Books.class);
//        if (!search.equals("")) {
        queryListBooks.setParameter("parameter", "%" + search + "%");
//        }

        if (!category.equalsIgnoreCase("all")) {
            queryListBooks.setParameter("kategori", this.category);
        }
        List<Books> listBooks = queryListBooks.getResultList();
        return listBooks;
    }

    public void loadTabel() {
        List<Books> listBooks = this.getQueryResult();

        listBooksId.clear();
        DefaultTableModel model = (DefaultTableModel) tabelBuku.getModel();
        model.setRowCount(0);
        int i = 1;
        for (Books data : listBooks) {
            Object[] baris = new Object[8];
            baris[0] = i++;
            listBooksId.add(data.getBookId());
            baris[1] = data.getIsbn();
            baris[2] = data.getJudul();
            baris[3] = data.getPengarang();
            baris[4] = data.getPenerbit();

//            begin kategori
            String strKategori = "";
            int j = 1;
            for (Categories kategoriBuku : data.getCategoriesList()) {
                strKategori += kategoriBuku.getNama();
                if (data.getCategoriesList().size() > j++) {
                    strKategori += ", ";
                }
            }
            baris[5] = strKategori;
//            endkategori
            baris[6] = data.getTahunTerbit();
            baris[7] = new SimpleDateFormat("dd/MM/yyyy").format(data.getCreatedAt());
            model.addRow(baris);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();
        searchBy = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        orderByKategori = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(255, 204, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/add-30x30.png"))); // NOI18N
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        inputSearch.setText("Search");
        inputSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputSearchFocusLost(evt);
            }
        });
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputSearchKeyPressed(evt);
            }
        });

        searchBy.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        searchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Judul", "Pengarang", "Penerbit", "Tahun Terbit", "Kategori" }));

        btnPrint.setBackground(new java.awt.Color(255, 204, 0));
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/document-30x30.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "ISBN", "Judul", "Pengarang", "Penerbit", "Kategori", "Thn Terbit", "Tgl Ditambahkan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBuku);

        orderByKategori.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        orderByKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        orderByKategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                orderByKategoriItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
                        .addComponent(orderByKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(orderByKategori)
                    .addComponent(searchBy))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        new FormBuku(this, userId).setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void inputSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.loadTabel();
        }
    }//GEN-LAST:event_inputSearchKeyPressed

    private void inputSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSearchFocusLost
        // TODO add your handling code here:
        if (inputSearch.getText().equals("")) {
            inputSearch.setText("Search");
        }
    }//GEN-LAST:event_inputSearchFocusLost

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
//        List<Books> listBooks = getQueryResult();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        List<HashMap<String, Object>> newResults = new ArrayList<>();
//        for (Borrows peminjam : resultQueryListBorrows) {
//            HashMap<String, Object> dataPeminjam = new HashMap<>();
//            dataPeminjam.put("judulBuku", peminjam.getBooksId().getJudul());
//            dataPeminjam.put("peminjam", peminjam.getStudentId().getFullname());
//            dataPeminjam.put("tanggalPinjam", simpleDateFormat.format(peminjam.getTanggalPinjam()));
//            dataPeminjam.put("rencanaKembali", simpleDateFormat.format(peminjam.getRencanaKembali()));
//            dataPeminjam.put("tanggalKembali", (peminjam.getTanggalKembali() != null ? simpleDateFormat.format(peminjam.getTanggalKembali()) : ""));
//            long timeStampNow = new Date().getTime() / 1000;
//            if (timeStampNow > (peminjam.getRencanaKembali().getTime() / 1000)) {
//                dataPeminjam.put("totalDenda", String.valueOf((timeStampNow - (peminjam.getRencanaKembali().getTime() / 1000)) / 86400 * peminjam.getDenda()));
//            }
//            newResults.add(dataPeminjam);
//        }
//
//        Map<String, Object> parameters = new HashMap<>();
//        String desc = "Berikut adalah laporan pada bulan " + filterMonth.getSelectedItem().toString() + " " + filterYear.getSelectedItem().toString() + (inputSearch.getText().equals("") ? " berdasarkan pencarian '" + inputSearch.getText() + "' pada " + searchBy.getSelectedItem() : "");
//        parameters.put("desc", desc);
////        parameters.put("querySearch", inputSearch.getText());
////        parameters.put("searchBy", searchBy.getSelectedItem());
////        parameters.put("month", filterMonth.getSelectedItem().toString());
////        parameters.put("year", Integer.parseInt(filterYear.getSelectedItem().toString()));
//
//        try {
//            String jrxmlFile = new String("src/Report/peminjaman.jrxml");
//            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
//            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JRBeanCollectionDataSource(newResults));
//            JasperViewer.viewReport(jp, false);
//        } catch (JRException ex) {
//            System.out.println(ex.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void orderByKategoriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_orderByKategoriItemStateChanged
        // TODO add your handling code here:
        evt.getSource();
        if (!this.category.equalsIgnoreCase(evt.getItem().toString())) {
            this.category = evt.getItem().toString();
            loadTabel();
        }
    }//GEN-LAST:event_orderByKategoriItemStateChanged

    private void inputSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSearchFocusGained
        // TODO add your handling code here:
        if (inputSearch.getText().equalsIgnoreCase("search")) {
            inputSearch.setText("");
        }
    }//GEN-LAST:event_inputSearchFocusGained

    private void tabelBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBukuMouseClicked
        // TODO add your handling code here:
        ((Dashboard) this.obj).dispose();
        JTable target = (JTable) evt.getSource();
        int row = target.getSelectedRow();
        System.out.println(target.getModel().getValueAt(row, 0).toString());
        int index = Integer.valueOf(target.getModel().getValueAt(row, 0).toString());
        new ViewBuku(userId, listBooksId.get((index - 1))).setVisible(true);
    }//GEN-LAST:event_tabelBukuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPrint;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> orderByKategori;
    private javax.swing.JComboBox<String> searchBy;
    private javax.swing.JTable tabelBuku;
    // End of variables declaration//GEN-END:variables
}
