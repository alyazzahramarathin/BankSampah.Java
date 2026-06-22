/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NasabahDAO;
import java.sql.PreparedStatement;
import java.util.List;
import model.Nasabah;

/**
 *
 * @author NEW ASUS
 */
public class NasabahController {
    private NasabahDAO dao;
    
    public NasabahController() {
        dao = new NasabahDAO();
    }
    
    public List<Nasabah> getAllNasabah() {
        return dao.getAllNasabah();
    }
    
   public boolean simpan(Nasabah nasabah){
    return dao.insert(nasabah);
}

public boolean edit(Nasabah nasabah){
    return dao.edit(nasabah);
}

    public boolean delete(String id){
    return dao.delete(id);
    }
}