package model;

import java.util.Date;

public class Transaksi {

    private int idTransaksi;
    private int idNasabah;
    private int idSampah;
    private double berat;
    private double total;
    private Date tanggal;
    private String namaNasabah;
    private String namaSampah;
    private double harga;

    public Transaksi() {
    }

    public Transaksi(int idTransaksi, int idNasabah, int idSampah, double berat, double total, Date tanggal) {
        this.idTransaksi = idTransaksi;
        this.idNasabah = idNasabah;
        this.idSampah = idSampah;
        this.berat = berat;
        this.total = total;
        this.tanggal = tanggal;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }

    public int getIdSampah() {
        return idSampah;
    }

    public void setIdSampah(int idSampah) {
        this.idSampah = idSampah;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public String getNamaNasabah() {
    return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public String getNamaSampah() {
        return namaSampah;
    }

    public void setNamaSampah(String namaSampah) {
        this.namaSampah = namaSampah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}