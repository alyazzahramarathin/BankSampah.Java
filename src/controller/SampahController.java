/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SampahDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Sampah;

/**
 *
 * @author siti2
 */
public class SampahController {

    private SampahDAO dao;

    public SampahController() {
        dao = new SampahDAO();
    }

    public List<Sampah> getAllSampah() {
        return dao.getAllSampah();
    }

    public boolean simpan(Sampah sampah) {
        return dao.insert(sampah);
    }

    public boolean edit(Sampah sampah) {
        return dao.edit(sampah);
    }

    public boolean delete(String id) {
        return dao.delete(id);
    }
}