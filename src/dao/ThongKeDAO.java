/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.CTDV_DV_DM_DTO;
import dto.DichVuDanhMucDTO;
import entity.Hoa_Don;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ThongKeDAO {
        public List<Hoa_Don> loadHoaDon(Date ngayBatDau, Date ngayKetThuc){
            String sql = "SELECT * FROM HOA_DON WHERE NGAY_TAO BETWEEN ? AND ?";
            List<Hoa_Don> hoaDonList = new ArrayList<>();
            try (Connection con = KetNoiDB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);){
                
                ps.setDate(1, (java.sql.Date) ngayBatDau);
                ps.setDate(2, (java.sql.Date) ngayKetThuc);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                int MA_KHACH_HANG = rs.getInt("MA_KHACH_HANG");
                boolean TRANG_THAI_THANH_TOAN = rs.getBoolean("TRANG_THAI_THANH_TOAN");
                int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
                double TONG_TIEN = rs.getDouble("TONG_TIEN");
                java.util.Date NGAY_TAO = rs.getDate("NGAY_TAO");
                Hoa_Don hoaDon = new Hoa_Don(MA_HOA_DON, MA_KHACH_HANG, TRANG_THAI_THANH_TOAN, MA_TAI_KHOAN, TONG_TIEN, NGAY_TAO);
                hoaDonList.add(hoaDon);
            }   
            return hoaDonList;
        } catch (Exception e) {
            return hoaDonList;
        }
    }
        public double loadTong(Date ngayBatDau, Date ngayKetThuc){
            String sql = "SELECT SUM(TONG_TIEN) AS TONG FROM HOA_DON WHERE NGAY_TAO BETWEEN ? AND ?";
            try (Connection con = KetNoiDB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);){
                
                ps.setDate(1, (java.sql.Date) ngayBatDau);
                ps.setDate(2, (java.sql.Date) ngayKetThuc);
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                return rs.getDouble("TONG");
                
            }   
            return 0;
        } catch (SQLException e) {
            return 0;
        }
    }
        public List<CTDV_DV_DM_DTO> getTop5DichVuBanChay() {
    List<CTDV_DV_DM_DTO> dvdm = new ArrayList<>();
    String sql = "SELECT TOP 5 DV.MA_DICH_VU, DM.TEN_DANH_MUC, DV.TEN_DICH_VU, "
            + "DV.GIA, SUM(CTDV.SO_LUONG) AS TONG_SO_LUONG "
            + "FROM CHI_TIET_DICH_VU CTDV "
            + "JOIN DICH_VU DV ON CTDV.MA_DICH_VU = DV.MA_DICH_VU "
            + "JOIN DANH_MUC DM ON DV.MA_DANH_MUC = DM.MA_DANH_MUC "
            + "GROUP BY DV.MA_DICH_VU, DM.TEN_DANH_MUC, DV.TEN_DICH_VU, DV.GIA "
            + "ORDER BY TONG_SO_LUONG DESC";
    
    try (Connection conn = KetNoiDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
                int MA_DICH_VU = rs.getInt("MA_DICH_VU");
                String TEN_DANH_MUC = rs.getString("TEN_DANH_MUC");
                String TEN_DICH_VU = rs.getString("TEN_DICH_VU");
                double GIA = rs.getDouble("GIA");
                int TONG_SO_LUONG = rs.getInt("TONG_SO_LUONG");
                
                CTDV_DV_DM_DTO ctdv = new CTDV_DV_DM_DTO(MA_DICH_VU, TONG_SO_LUONG, TEN_DICH_VU, GIA, TEN_DANH_MUC);
                dvdm.add(ctdv);
        }
        return dvdm;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dvdm;
}
        public List<CTDV_DV_DM_DTO> getDichVuByMaDichVu(int maDichVu) {
    List<CTDV_DV_DM_DTO> dvdm = new ArrayList<>();
    String sql = "SELECT DV.MA_DICH_VU, DM.TEN_DANH_MUC, DV.TEN_DICH_VU, DV.GIA, "
               + "SUM(CTDV.SO_LUONG) AS TONG_SO_LUONG "
               + "FROM CHI_TIET_DICH_VU CTDV "
               + "JOIN DICH_VU DV ON CTDV.MA_DICH_VU = DV.MA_DICH_VU "
               + "JOIN DANH_MUC DM ON DV.MA_DANH_MUC = DM.MA_DANH_MUC "
               + "WHERE DV.MA_DICH_VU = ? "
               + "GROUP BY DV.MA_DICH_VU, DM.TEN_DANH_MUC, DV.TEN_DICH_VU, DV.GIA "
               + "ORDER BY TONG_SO_LUONG DESC";
    
    try (Connection conn = KetNoiDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, maDichVu);  
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int MA_DICH_VU = rs.getInt("MA_DICH_VU");
                String TEN_DANH_MUC = rs.getString("TEN_DANH_MUC");
                String TEN_DICH_VU = rs.getString("TEN_DICH_VU");
                double GIA = rs.getDouble("GIA");
                int TONG_SO_LUONG = rs.getInt("TONG_SO_LUONG");
                
                CTDV_DV_DM_DTO ctdv = new CTDV_DV_DM_DTO(MA_DICH_VU, TONG_SO_LUONG, TEN_DICH_VU, GIA, TEN_DANH_MUC);
                dvdm.add(ctdv);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dvdm;
}
    
        public String timTenDichVuDuaTrenMa(int maDichVu){
        String sql = "select TEN_DICH_VU from DICH_VU WHERE MA_DICH_VU = ?";
        try (Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);) {
            
            ps.setInt(1, maDichVu);
            
            try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("TEN_DICH_VU");
            }
        }    
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }

}
