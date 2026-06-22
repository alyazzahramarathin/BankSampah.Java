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
import model.Transaksi;

/**
 *
 * @author siti2
 */
public class TransaksiDAO {

    Connection conn = Koneksi.getConnection();

    // Tambah transaksi
    public void insert(Transaksi t) {
        String sql = "INSERT INTO transaksi(id_nasabah,id_sampah,berat,total,tanggal) VALUES (?,?,?,?,?)";;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getIdNasabah());
            ps.setInt(2, t.getIdSampah());
            ps.setDouble(3, t.getBerat());
            ps.setDouble(4, t.getTotal());
            ps.setDate(5, new java.sql.Date(t.getTanggal().getTime()));

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Insert Transaksi Gagal : " + e.getMessage());
        }
    }

    // Update transaksi
    public void update(Transaksi t) {
        String sql = "UPDATE transaksi SET id_nasabah=?, id_sampah=?, berat=?, total=?, tanggal=? WHERE id_transaksi=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, t.getIdNasabah());
            ps.setInt(2, t.getIdSampah());
            ps.setDouble(3, t.getBerat());
            ps.setDouble(4, t.getTotal());
            ps.setDate(5, new java.sql.Date(t.getTanggal().getTime()));
            ps.setInt(6, t.getIdTransaksi());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update Transaksi Gagal : " + e.getMessage());
        }
    }

    // Hapus transaksi
    public void delete(int id) {

        String sql = "DELETE FROM transaksi WHERE id_transaksi=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete Transaksi Gagal : " + e.getMessage());
        }
    }

    // Tampilkan semua transaksi
    public ArrayList<Transaksi> getAll() {

        ArrayList<Transaksi> list = new ArrayList<>();

        String sql = "SELECT t.id_transaksi, t.tanggal, n.nama AS nama_nasabah, " +
                     "s.nama_sampah, s.harga, t.berat, t.total " +
                     "FROM transaksi t " +
                     "JOIN nasabah n ON t.id_nasabah = n.id_nasabah " +
                     "JOIN sampah s ON t.id_sampah = s.id_sampah";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Transaksi t = new Transaksi();

                t.setIdTransaksi(rs.getInt("id_transaksi"));
                t.setTanggal(rs.getDate("tanggal"));
                t.setNamaNasabah(rs.getString("nama_nasabah"));
                t.setNamaSampah(rs.getString("nama_sampah"));
                t.setHarga(rs.getDouble("harga"));
                t.setBerat(rs.getDouble("berat"));
                t.setTotal(rs.getDouble("total"));

                list.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Tampil Transaksi Gagal : " + e.getMessage());
        }

        return list;
    }
    
    public ResultSet laporan(){
    try{

        String sql =
        "SELECT t.id_transaksi,t.tanggal,"
        + "n.nama AS nama_nasabah,"
        + "s.nama_sampah,"
        + "t.berat,"
        + "s.harga,"
        + "t.total "
        + "FROM transaksi t "
        + "JOIN nasabah n ON t.id_nasabah=n.id_nasabah "
        + "JOIN sampah s ON t.id_sampah=s.id_sampah";

        java.sql.Statement st = conn.createStatement();
        return st.executeQuery(sql);
    }catch(Exception e){
         System.out.println(e.getMessage());
        return null;
    }
    }
 }
