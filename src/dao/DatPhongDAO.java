/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.HoaDonChiTietTienPhongDTO;
import entity.Phong_Hat;
import java.beans.Statement;
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
public class DatPhongDAO {
    
    public String readTenPhongHat(int maPhongHat){
        String sql = "SELECT TEN_LOAI_PHONG FROM PHONG_HAT JOIN LOAI_PHONG ON PHONG_HAT.MA_LOAI_PHONG = LOAI_PHONG.MA_LOAI_PHONG WHERE PHONG_HAT.MA_PHONG_HAT = ?";
        try (Connection con = KetNoiDB.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql);) {
            
            ps.setInt(1, maPhongHat);
            
            try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("TEN_LOAI_PHONG");
            }
        }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public double readGiaPhongHat(int maPhongHat){
        String sql = "SELECT GIA_TIEN FROM PHONG_HAT JOIN LOAI_PHONG ON PHONG_HAT.MA_LOAI_PHONG = LOAI_PHONG.MA_LOAI_PHONG WHERE PHONG_HAT.MA_PHONG_HAT = ?";
        try (Connection con = KetNoiDB.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql);) {
            
            ps.setDouble(1, maPhongHat);
            
            try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("GIA_TIEN");
            }
        }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean DatPhong(int maPhongHat, int maTaiKhoan, int maKhachHang) {
        String sqlCheckTrangThai = "SELECT TRANG_THAI FROM PHONG_HAT WHERE MA_PHONG_HAT = ?";
        
        String sqlHoaDon = "INSERT INTO HOA_DON (MA_KHACH_HANG, MA_TAI_KHOAN, TONG_TIEN, NGAY_TAO, TRANG_THAI_THANH_TOAN) " +
                           "VALUES (?, ?, NULL, GETDATE(), 0); SELECT SCOPE_IDENTITY();";
        
        String sqlChiTietTienPhong = "INSERT INTO CHI_TIET_TIEN_PHONG (MA_HOA_DON, MA_PHONG_HAT, THOI_GIAN_NHAN_PHONG, " +
                                     "THOI_GIAN_TRA_PHONG, DON_GIA, MIEU_TA, TRANG_THAI) " +
                                     "VALUES (?, ?, GETDATE(), NULL, NULL, 'Đang sử dụng', 1)";
        
        String sqlUpdatePhong = "UPDATE PHONG_HAT SET TRANG_THAI = 1 WHERE MA_PHONG_HAT = ?";
        
        try (Connection con = KetNoiDB.getConnection()) {

        try (PreparedStatement psCheck = con.prepareStatement(sqlCheckTrangThai)) {
            psCheck.setInt(1, maPhongHat);
            try (ResultSet rs = psCheck.executeQuery()) {
                if (rs.next()) {
                    int trangThai = rs.getInt(1); 
                    if (trangThai == 1) {
                        System.out.println("Phòng đang được sử dụng. Không thể đặt!");
                        return false;
                    }
                }   
            }
        }

        // Tạo hóa đơn và lấy mã hóa đơn
        try (PreparedStatement ps = con.prepareStatement(sqlHoaDon);
             PreparedStatement ps2 = con.prepareStatement(sqlChiTietTienPhong);
             PreparedStatement psUpdate = con.prepareStatement(sqlUpdatePhong)) {

            ps.setInt(1, maKhachHang);
            ps.setInt(2, maTaiKhoan);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int maHoaDon = rs.getInt(1);
                    System.out.println("New ma hoa don: " + maHoaDon);

                    // Thêm chi tiết tiền phòng
                    ps2.setInt(1, maHoaDon);
                    ps2.setInt(2, maPhongHat);
                    ps2.executeUpdate();

                    // Cập nhật trạng thái phòng thành "đang sử dụng"
                    psUpdate.setInt(1, maPhongHat);
                    psUpdate.executeUpdate();

                    return true;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }
}
