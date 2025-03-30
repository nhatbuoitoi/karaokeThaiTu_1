/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.DichVuDanhMucDTO;
import dto.HD_CTTP_CTDV_PH_KH_TK_DTO;
import dto.HoaDon_CTTP_CTDV_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ThanhToanDAO {
    public List<HD_CTTP_CTDV_PH_KH_TK_DTO> readThanhToan(int maHoaDon) { 
    String sql =  "SELECT PHONG_HAT.TEN_PHONG_HAT, "
                + "KHACH_HANG.TEN_KHACH_HANG, "
                + "TAI_KHOAN.HO_TEN,"
                + " CTTP.THOI_GIAN_NHAN_PHONG,"
                + " CTTP.THOI_GIAN_TRA_PHONG,"
                + " CTTP.DON_GIA AS DON_GIA_TIEN_PHONG,"
                + " (SELECT COALESCE(SUM(CTDV.DON_GIA), 0) FROM CHI_TIET_DICH_VU CTDV "
                + "WHERE CTDV.MA_HOA_DON = HOA_DON.MA_HOA_DON) AS TONG_TIEN_DICH_VU "
                + "FROM HOA_DON JOIN CHI_TIET_TIEN_PHONG CTTP "
                + "ON HOA_DON.MA_HOA_DON = CTTP.MA_HOA_DON "
                + "JOIN PHONG_HAT ON PHONG_HAT.MA_PHONG_HAT = CTTP.MA_PHONG_HAT "
                + "JOIN TAI_KHOAN ON HOA_DON.MA_TAI_KHOAN = TAI_KHOAN.MA_TAI_KHOAN "
                + "JOIN KHACH_HANG ON KHACH_HANG.MA_KHACH_HANG = HOA_DON.MA_KHACH_HANG "
                + "WHERE HOA_DON.MA_HOA_DON = ?";
    
    List<HD_CTTP_CTDV_PH_KH_TK_DTO> list = new ArrayList<>();
    try (Connection con = KetNoiDB.getConnection(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, maHoaDon);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            String TEN_PHONG_HAT = rs.getString("TEN_PHONG_HAT");
            String TEN_KHACH_HANG = rs.getString("TEN_KHACH_HANG");
            String HO_TEN = rs.getString("HO_TEN");
            String THOI_GIAN_NHAN_PHONG = rs.getString("THOI_GIAN_NHAN_PHONG");
            String THOI_GIAN_TRA_PHONG = rs.getString("THOI_GIAN_TRA_PHONG");      
            double DON_GIA_TIEN_PHONG = rs.getDouble("DON_GIA_TIEN_PHONG");
            double TONG_TIEN_DICH_VU = rs.getDouble("TONG_TIEN_DICH_VU");
            
            HD_CTTP_CTDV_PH_KH_TK_DTO hd = new HD_CTTP_CTDV_PH_KH_TK_DTO(THOI_GIAN_NHAN_PHONG, THOI_GIAN_TRA_PHONG, DON_GIA_TIEN_PHONG, TONG_TIEN_DICH_VU, TEN_PHONG_HAT, TEN_KHACH_HANG, HO_TEN);
            list.add(hd);
        }
    } catch (SQLException e) { 
        e.printStackTrace();
    }
    return list;
}
    public void thanhToan(int ma){
        String sql = "UPDATE HOA_DON SET TRANG_THAI_THANH_TOAN = 1 WHERE MA_HOA_DON = ?";
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, ma); 
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    }
    
    public double layTongTien(int ma){
        double tong;
        String sql = "SELECT TONG_TIEN FROM HOA_DON WHERE MA_HOA_DON = ?";
        try (Connection con = KetNoiDB.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, ma);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            tong = rs.getDouble("TONG_TIEN");
            return tong;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        
    }   return 0;
    }
    
}
