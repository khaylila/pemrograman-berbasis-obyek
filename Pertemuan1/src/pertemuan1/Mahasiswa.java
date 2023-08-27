/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan1;

/**
 *
 * @author milea
 */
public class Mahasiswa {
    int nim;
    String nama;
    int tahunMasuk;
    int tahunLahir;

    public int hitungUsia() {
        return (2023 - tahunLahir);
    }

    public int hitungJumlahSemester() {
        return (2023 - tahunMasuk * 2);
    }

    public static void main(String[] args) {

    }
}
