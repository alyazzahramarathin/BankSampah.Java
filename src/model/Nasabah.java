/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NEW ASUS
 */
public class Nasabah {
    private int idNasabah;
    private String nama;
    private String alamat;
    private String noHp;

    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHp() {
        return noHp;
    }
}
