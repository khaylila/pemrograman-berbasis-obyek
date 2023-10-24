/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author milea
 */
@Entity
@Table(name = "daftar_buku")
@NamedQueries({
    @NamedQuery(name = "DaftarBuku.findAll", query = "SELECT d FROM DaftarBuku d"),
    @NamedQuery(name = "DaftarBuku.findByIsbn", query = "SELECT d FROM DaftarBuku d WHERE d.isbn = :isbn"),
    @NamedQuery(name = "DaftarBuku.findByJudulBuku", query = "SELECT d FROM DaftarBuku d WHERE d.judulBuku = :judulBuku"),
    @NamedQuery(name = "DaftarBuku.findByTahunTerbit", query = "SELECT d FROM DaftarBuku d WHERE d.tahunTerbit = :tahunTerbit"),
    @NamedQuery(name = "DaftarBuku.findByPenerbit", query = "SELECT d FROM DaftarBuku d WHERE d.penerbit = :penerbit"),
    @NamedQuery(name = "DaftarBuku.findByIdBuku", query = "SELECT d FROM DaftarBuku d WHERE d.idBuku = :idBuku")})
public class DaftarBuku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "judul_buku")
    private String judulBuku;
    @Column(name = "tahun_terbit")
    private String tahunTerbit;
    @Column(name = "penerbit")
    private String penerbit;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_buku")
    private Integer idBuku;

    public DaftarBuku() {
    }

    public DaftarBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuku != null ? idBuku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaftarBuku)) {
            return false;
        }
        DaftarBuku other = (DaftarBuku) object;
        if ((this.idBuku == null && other.idBuku != null) || (this.idBuku != null && !this.idBuku.equals(other.idBuku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.DaftarBuku[ idBuku=" + idBuku + " ]";
    }
    
}
