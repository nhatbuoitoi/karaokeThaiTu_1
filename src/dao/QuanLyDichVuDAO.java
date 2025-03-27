/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.HoaDonChiTietDichVuDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuanLyDichVuDAO {
    public List<HoaDonChiTietDichVuDTO> readChiTietDichVu(int maHoaDon) {
    String sql = "SELECT * FROM CHI_TIET_DICH_VU JOIN DICH_VU ON CHI_TIET_DICH_VU.MA_DICH_VU = DICH_VU.MA_DICH_VU WHERE MA_HOA_DON = ?";
    List<HoaDonChiTietDichVuDTO> ctdv = new ArrayList<>();
    try (Connection con = KetNoiDB.getConnection(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, maHoaDon);
        
        ResultSet rs = ps.executeQuery(); 
        
        while (rs.next()) {
            int MA_HOA_DON = rs.getInt("MA_HOA_DON");
            int MA_CHI_TIET_DICH_VU = rs.getInt("MA_CHI_TIET_DICH_VU");
            int MA_DICH_VU = rs.getInt("MA_DICH_VU");
            int SO_LUONG = rs.getInt("SO_LUONG"); 
            double DON_GIA = rs.getDouble("DON_GIA");
            String TEN_DICH_VU = rs.getString("TEN_DICH_VU");
            
            HoaDonChiTietDichVuDTO cttt = new HoaDonChiTietDichVuDTO(MA_HOA_DON, MA_CHI_TIET_DICH_VU, TEN_DICH_VU, MA_DICH_VU, SO_LUONG, DON_GIA);
            ctdv.add(cttt);
        }
        return ctdv;
    }
    catch (SQLException e) {
        e.printStackTrace();
        return ctdv;
    }
}
    
    public void capNhatDonGiaChiTietDichVu(int maHoaDon) {
    String sql = "UPDATE CHI_TIET_DICH_VU SET DON_GIA = "
               + "(SELECT DICH_VU.GIA * CHI_TIET_DICH_VU.SO_LUONG "
               + "FROM DICH_VU "
               + "WHERE DICH_VU.MA_DICH_VU = CHI_TIET_DICH_VU.MA_DICH_VU) "
               + "WHERE MA_HOA_DON = ?";

    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, maHoaDon);
        ps.executeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public double getTotalDonGiaDichVu(int maHoaDon) {
        String sql = "SELECT CHI_TIET_DICH_VU.DON_GIA AS TOTAL_DON_GIA "
               + "FROM CHI_TIET_DICH_VU "
               + "JOIN DICH_VU ON CHI_TIET_DICH_VU.MA_DICH_VU = DICH_VU.MA_DICH_VU "
               + "WHERE CHI_TIET_DICH_VU.MA_HOA_DON = ?";
    
        double totalDonGia = 0.0;
        try (Connection con = KetNoiDB.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
        
            if (rs.next()) {
                totalDonGia = rs.getDouble("TOTAL_DON_GIA");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
         return totalDonGia;
    }
    
    
    
}
