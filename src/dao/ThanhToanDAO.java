/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.DichVuDanhMucDTO;
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
    public List<HoaDon_CTTP_CTDV_DTO> readThanhToan() { 
    String sql = "SELECT HOA_DON.MA_HOA_DON, HOA_DON.MA_TAI_KHOAN, HOA_DON.MA_KHACH_HANG, "
               + "CTTP.MA_CHI_TIET_TIEN_PHONG, CTTP.THOI_GIAN_NHAN_PHONG, CTTP.THOI_GIAN_TRA_PHONG, CTTP.DON_GIA AS DON_GIA_TIEN_PHONG, "
               + "CTDV.MA_CHI_TIET_DICH_VU, COALESCE(SUM(CTDV.SO_LUONG * CTDV.DON_GIA), 0) AS TONG_TIEN_DICH_VU "
               + "FROM HOA_DON "
               + "JOIN CHI_TIET_TIEN_PHONG CTTP ON HOA_DON.MA_HOA_DON = CTTP.MA_HOA_DON "
               + "LEFT JOIN CHI_TIET_DICH_VU CTDV ON HOA_DON.MA_HOA_DON = CTDV.MA_HOA_DON "
               + "GROUP BY HOA_DON.MA_HOA_DON, HOA_DON.MA_TAI_KHOAN, HOA_DON.MA_KHACH_HANG, "
               + "CTTP.MA_CHI_TIET_TIEN_PHONG, CTTP.THOI_GIAN_NHAN_PHONG, CTTP.THOI_GIAN_TRA_PHONG, CTTP.DON_GIA, "
               + "CTDV.MA_CHI_TIET_DICH_VU";
    
    List<HoaDon_CTTP_CTDV_DTO> list = new ArrayList<>();
    try (Connection con = KetNoiDB.getConnection(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int MA_HOA_DON = rs.getInt("MA_HOA_DON");
            int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
            int MA_KHACH_HANG = rs.getInt("MA_KHACH_HANG");

            int MA_CHI_TIET_TIEN_PHONG = rs.getInt("MA_CHI_TIET_TIEN_PHONG");
            String THOI_GIAN_NHAN_PHONG = rs.getString("THOI_GIAN_NHAN_PHONG");
            String THOI_GIAN_TRA_PHONG = rs.getString("THOI_GIAN_TRA_PHONG");
            double DON_GIA_TIEN_PHONG = rs.getDouble("DON_GIA_TIEN_PHONG");

            int MA_CHI_TIET_DICH_VU = rs.getInt("MA_CHI_TIET_DICH_VU");
            double TONG_TIEN_DICH_VU = rs.getDouble("TONG_TIEN_DICH_VU");
            
            HoaDon_CTTP_CTDV_DTO hd = new HoaDon_CTTP_CTDV_DTO(
                MA_HOA_DON, MA_TAI_KHOAN, MA_KHACH_HANG, 
                MA_CHI_TIET_TIEN_PHONG, THOI_GIAN_NHAN_PHONG, THOI_GIAN_TRA_PHONG, DON_GIA_TIEN_PHONG, 
                MA_CHI_TIET_DICH_VU, TONG_TIEN_DICH_VU
            );
            list.add(hd);
        }
    } catch (SQLException e) { 
        e.printStackTrace();
    }
    return list;
}

    
    public double tinhTienDichVu(int maHoaDon) { 
    double tongTien = 0;
    String sql = "SELECT COALESCE(SUM(SO_LUONG * DON_GIA), 0) AS TongTien " +
                 "FROM CHI_TIET_DICH_VU " +
                 "WHERE MA_HOA_DON = ?";

    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, maHoaDon);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            tongTien = rs.getDouble("TongTien");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tongTien;
}
    
    
}
