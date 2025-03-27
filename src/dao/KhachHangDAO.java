/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import entity.Khach_Hang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class KhachHangDAO {
    public static boolean insertKhachHang(Khach_Hang kh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public List<Khach_Hang> readKhachHang(){
        String sql = "SELECT * FROM KHACH_HANG";
        List<Khach_Hang> ListKH = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            while(rs.next()){
                int ma_khach_hang = rs.getInt("MA_KHACH_HANG");
                String ten_khach_hang = rs.getString("TEN_KHACH_HANG");
                String dia_chi = rs.getString("DIA_CHI");
                String sdt = rs.getString("SDT");
                java.util.Date ngay_sinh = rs.getDate("NGAY_SINH");
                boolean gioi_tinh = rs.getBoolean("GIOI_TINH");
                Khach_Hang kh = new Khach_Hang(ma_khach_hang, ten_khach_hang, dia_chi, sdt, ngay_sinh, gioi_tinh);
                ListKH.add(kh);
                 }
            return ListKH;
        }catch(SQLException e){
            return ListKH;
        }
        
    }
    public Khach_Hang timKhachHang(int makhachhang){
        String sql = "Select * from KHACH_HANG where MA_KHACH_HANG = ?";
        Khach_Hang kh = null;
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, makhachhang); 

        ResultSet rs = ps.executeQuery();
         if (rs.next()) {
                int ma_khach_hang = rs.getInt("MA_KHACH_HANG");
                String ten_khach_hang = rs.getString("TEN_KHACH_HANG");
                String dia_chi = rs.getString("DIA_CHI");
                String sdt = rs.getString("SDT");
                java.util.Date ngay_sinh = rs.getDate("NGAY_SINH");
                boolean gioi_tinh = rs.getBoolean("GIOI_TINH");
            kh = new Khach_Hang(ma_khach_hang, ten_khach_hang, dia_chi, sdt, ngay_sinh, gioi_tinh);
        }
         } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return kh;
    }
      public boolean themKhachHang(Khach_Hang kh) {
    String sql = "INSERT INTO KHACH_HANG VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, kh.getMA_KHACH_HANG());
        ps.setString(2, kh.getTEN_KHACH_HANG());
        ps.setString(3, kh.getDIA_CHI());
        ps.setString(4, kh.getSDT());
        ps.setDate(5, new java.sql.Date(kh.getNGAY_SINH().getTime()));
        ps.setBoolean(6, kh.isGIOI_TINH());

        return ps.executeUpdate() > 0; // Trả về true nếu thêm thành công

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Trả về false nếu có lỗi
}

     public boolean updateKhachHang(Khach_Hang kh) {
    String sql = "UPDATE KHACH_HANG SET TEN_KHACH_HANG = ?, NGAY_SINH = ?, GIOI_TINH = ?, SDT = ?, DIA_CHI = ? WHERE MA_KHACH_HANG = ?";
    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, kh.getTEN_KHACH_HANG());
        ps.setDate(2, (Date) kh.getNGAY_SINH());
        ps.setBoolean(3, kh.isGIOI_TINH());
        ps.setString(4, kh.getSDT());
        ps.setString(5, kh.getDIA_CHI());
        ps.setInt(6, kh.getMA_KHACH_HANG()); // WHERE MA_KHACH_HANG = ?

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

      public int deleteKhachHang(int makhachhang){ 
        String sql = "DELETE FROM KHACH_HANG WHERE MA_KHACH_HANG = (?)";
                try (Connection con = KetNoiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            
           ps.setInt(1, makhachhang);
           
            int ketQua = ps.executeUpdate();
            return ketQua;
        } 
        catch (Exception e) {
            return 0;
        }
    }
}
