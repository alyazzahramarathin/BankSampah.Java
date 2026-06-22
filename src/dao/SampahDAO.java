/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.table.DefaultTableModel;
import model.Sampah;

/**
 *
 * @author siti2
 */
public class SampahDAO {
         
   Connection conn = Koneksi.getConnection();

    public List<Sampah> getAllSampah() {
        List<Sampah> list = new ArrayList<>();

        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sampah");

            while (rs.next()) {

                Sampah s = new Sampah();

                s.setIdSampah(rs.getInt("id_sampah"));
                s.setNamaSampah(rs.getString("nama_sampah"));
                s.setHarga(rs.getDouble("harga"));

                list.add(s);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public boolean insert(Sampah s) {

        String sql = "INSERT INTO sampah(id_sampah,nama_sampah,harga) VALUES(?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, s.getIdSampah());
            ps.setString(2, s.getNamaSampah());
            ps.setDouble(3, s.getHarga());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {

                JOptionPane.showMessageDialog(null,
                        "ID Sampah sudah digunakan!");

            } else {

                JOptionPane.showMessageDialog(null,
                        e.getMessage());

            }

            return false;
        }

    }

    public boolean edit(Sampah s) {

        try {

            String sql = "UPDATE sampah SET nama_sampah=?, harga=? WHERE id_sampah=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.getNamaSampah());
            ps.setDouble(2, s.getHarga());
            ps.setInt(3, s.getIdSampah());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

            return false;
        }

    }

    public boolean delete(String id) {

        String sql = "DELETE FROM sampah WHERE id_sampah=?";

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

