/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TransaksiDAO;
import java.util.ArrayList;
import model.Transaksi;

/**
 *
 * @author siti2
 */
public class TransaksiController {
    
    private TransaksiDAO dao;

    public TransaksiController() {
        dao = new TransaksiDAO();
    }

    public void simpan(Transaksi transaksi) {
        dao.insert(transaksi);
    }

    public void ubah(Transaksi transaksi) {
        dao.update(transaksi);
    }

    public void hapus(int idTransaksi) {
        dao.delete(idTransaksi);
    }

    public ArrayList<Transaksi> getAll() {
        return dao.getAll();
    }
}
