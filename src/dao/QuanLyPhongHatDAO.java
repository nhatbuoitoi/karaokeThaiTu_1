/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.HoaDonChiTietTienPhongDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class QuanLyPhongHatDAO {
    public List<HoaDonChiTietTienPhongDTO> readHoaDon(){
        String sql = "SELECT * FROM HOA_DON JOIN CHI_TIET_TIEN_PHONG ON HOA_DON.MA_HOA_DON = CHI_TIET_TIEN_PHONG.MA_HOA_DON";
        
        List<HoaDonChiTietTienPhongDTO> list = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            while(rs.next()){
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                int MA_KHACH_HANG = rs.getInt("MA_KHACH_HANG");
                boolean TRANG_THAI = rs.getBoolean("TRANG_THAI");
                int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
                double TONG_TIEN = rs.getDouble("TONG_TIEN");
                String GIO_DAT = rs.getString("THOI_GIAN_NHAN_PHONG");
                int MA_PHONG_HAT = rs.getInt("MA_PHONG_HAT");
                
                HoaDonChiTietTienPhongDTO hd = new HoaDonChiTietTienPhongDTO(MA_HOA_DON, MA_KHACH_HANG, MA_TAI_KHOAN, TONG_TIEN, GIO_DAT, MA_TAI_KHOAN, MA_PHONG_HAT, GIO_DAT, GIO_DAT, TONG_TIEN, TRANG_THAI);
                list.add(hd);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }
    }
    
    public boolean traPhong(int maPhongHat) {
        String sql = "UPDATE CHI_TIET_TIEN_PHONG " +
                 "SET THOI_GIAN_TRA_PHONG = GETDATE(), TRANG_THAI = 0 " +
                 "WHERE MA_PHONG_HAT = ? AND TRANG_THAI = 1; " +
                 "UPDATE PHONG_HAT SET TRANG_THAI = 0 WHERE MA_PHONG_HAT = ? ";
                

        try (Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, maPhongHat);
            ps.setInt(2, maPhongHat);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public void capNhatDonGiaChiTietTienPhong(int maHoaDon) {
        
        String sql = "UPDATE CHI_TIET_TIEN_PHONG "
                + "SET DON_GIA = ( SELECT DATEDIFF(SECOND, cttp.THOI_GIAN_NHAN_PHONG, cttp.THOI_GIAN_TRA_PHONG) / 3600.0 * lp.GIA_TIEN "
                + "FROM CHI_TIET_TIEN_PHONG cttp "
                + "JOIN PHONG_HAT ph ON cttp.MA_PHONG_HAT = ph.MA_PHONG_HAT "
                + "JOIN LOAI_PHONG lp ON ph.MA_LOAI_PHONG = lp.MA_LOAI_PHONG "
                + "WHERE cttp.MA_HOA_DON = CHI_TIET_TIEN_PHONG.MA_HOA_DON ) "
                + "WHERE MA_HOA_DON = ?";


        try (Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, maHoaDon);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public void traTien(int maHoaDon) { 

    String sqlTongTien = "SELECT SUM(ISNULL(ctdv.DON_GIA, 0))"
            + " + SUM(cttp.DON_GIA) AS TongTien "
            + "FROM  HOA_DON hd "
            + "JOIN  CHI_TIET_TIEN_PHONG cttp ON hd.MA_HOA_DON = cttp.MA_HOA_DON "
            + "LEFT JOIN CHI_TIET_DICH_VU ctdv ON hd.MA_HOA_DON = ctdv.MA_HOA_DON "
            + "JOIN PHONG_HAT ph ON cttp.MA_PHONG_HAT = ph.MA_PHONG_HAT WHERE hd.MA_HOA_DON = ?";
    
    String sqlCapNhat = "UPDATE HOA_DON SET TONG_TIEN = ? WHERE MA_HOA_DON = ?";
    
    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps1 = con.prepareStatement(sqlTongTien);
         PreparedStatement ps2 = con.prepareStatement(sqlCapNhat)) {

        ps1.setInt(1, maHoaDon);
        ResultSet rs = ps1.executeQuery();

        if (rs.next()) {
            double tongTien = rs.getDouble("TongTien");
            
            ps2.setDouble(1, tongTien);
            ps2.setInt(2, maHoaDon);
            int rowsUpdated = ps2.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Trả phòng thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn này.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy!");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi trả phòng!");
    }
}
    public int getMaHoaDonBangMaPhong(int maPhongHat) {
        String sql = "SELECT MA_HOA_DON FROM CHI_TIET_TIEN_PHONG WHERE MA_PHONG_HAT = ? AND TRANG_THAI = 0";
        int maHoaDon = 0;

        try (Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setInt(1, maPhongHat);
            ResultSet rs = ps.executeQuery();
        
            if (rs.next()) {
                maHoaDon = rs.getInt("MA_HOA_DON");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return maHoaDon;
    } 
}
    

