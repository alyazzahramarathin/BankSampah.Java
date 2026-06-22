/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Nasabah;

/**
 *
 * @author NEW ASUS
 */
public class NasabahDAO {
    
    Connection conn = Koneksi.getConnection();
    
    public List<Nasabah> getAllNasabah(){
        List<Nasabah> list = new ArrayList<>();
        
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nasabah");
            
            while (rs.next()) {
                Nasabah n = new Nasabah();
                n.setIdNasabah(rs.getInt("id_nasabah"));
                n.setNama(rs.getString("nama"));
                n.setAlamat(rs.getString("alamat"));
                n.setNoHp(rs.getString("no_hp"));
                
                list.add(n);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public boolean insert(Nasabah n) {
            String sql = "INSERT INTO nasabah(id_nasabah,nama,alamat,no_hp) VALUES(?,?,?,?)";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, n.getIdNasabah());
        ps.setString(2, n.getNama());
        ps.setString(3, n.getAlamat());
        ps.setString(4, n.getNoHp());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        if (e.getErrorCode() == 1062) {

            JOptionPane.showMessageDialog(null,
                    "ID Nasabah sudah digunakan!");

        } else {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }

        return false;
    }

}
    public boolean edit(Nasabah n) {

    try {

        String sql = "UPDATE nasabah SET nama=?,alamat=?,no_hp=? WHERE id_nasabah=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, n.getNama());
        ps.setString(2, n.getAlamat());
        ps.setString(3, n.getNoHp());
        ps.setInt(4, n.getIdNasabah());

        ps.executeUpdate();

        return true;

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                e.getMessage());

        return false;
    }

}
    public boolean delete(String id) {

    String sql = "DELETE FROM nasabah WHERE id_nasabah=?";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, id);

        ps.executeUpdate();

        return true;

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null,
                e.getMessage());

        return false;
    }

    }
}