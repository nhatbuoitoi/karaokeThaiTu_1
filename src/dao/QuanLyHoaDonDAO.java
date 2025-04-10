/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.HD_CTTP_CTDV_PH_KH_TK_DTO;
import dto.HoaDonChiTietDichVuDTO;
import dto.HoaDonChiTietTienPhongDTO;
import entity.Hoa_Don;
import java.sql.*;
import java.util.*;


public class QuanLyHoaDonDAO {
    public List<Hoa_Don> loadHoaDon(){
        String sql = "SELECT * FROM HOA_DON";
        List<Hoa_Don> hoaDonList = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
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
    
    public List<HD_CTTP_CTDV_PH_KH_TK_DTO> readHoaDon(){
        String sql = "SELECT * "
                + "FROM HOA_DON JOIN KHACH_HANG ON HOA_DON.MA_KHACH_HANG = KHACH_HANG.MA_KHACH_HANG "
                + "JOIN TAI_KHOAN ON HOA_DON.MA_TAI_KHOAN = TAI_KHOAN.MA_TAI_KHOAN WHERE HOA_DON.TONG_TIEN IS NOT NULL";
        
        List<HD_CTTP_CTDV_PH_KH_TK_DTO> list = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                String TEN_KHACH_HANG = rs.getString("TEN_KHACH_HANG");
                boolean TRANG_THAI_THANH_TOAN = rs.getBoolean("TRANG_THAI_THANH_TOAN");
                String HO_TEN = rs.getString("HO_TEN");
                double TONG_TIEN = rs.getDouble("TONG_TIEN");
                java.util.Date NGAY_TAO = rs.getDate("NGAY_TAO");
                
                HD_CTTP_CTDV_PH_KH_TK_DTO hd = new HD_CTTP_CTDV_PH_KH_TK_DTO(MA_HOA_DON, TRANG_THAI_THANH_TOAN, TONG_TIEN, NGAY_TAO, TEN_KHACH_HANG, HO_TEN);
                list.add(hd);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }
    }
    
    public List<HD_CTTP_CTDV_PH_KH_TK_DTO> readHoaDon2(int maPhongHat){
        String sql = "SELECT hd.MA_HOA_DON, cttp.MA_PHONG_HAT, ph.TEN_PHONG_HAT, "
                + "tk.HO_TEN AS TEN_TAI_KHOAN, "
                + "kh.TEN_KHACH_HANG, "
                + "cttp.THOI_GIAN_NHAN_PHONG AS GIO_DAT, "
                + "cttp.TRANG_THAI FROM HOA_DON hd "
                + "JOIN CHI_TIET_TIEN_PHONG cttp ON hd.MA_HOA_DON = cttp.MA_HOA_DON "
                + "JOIN PHONG_HAT ph ON cttp.MA_PHONG_HAT = ph.MA_PHONG_HAT "
                + "JOIN TAI_KHOAN tk ON hd.MA_TAI_KHOAN = tk.MA_TAI_KHOAN "
                + "JOIN KHACH_HANG kh ON hd.MA_KHACH_HANG = kh.MA_KHACH_HANG "
                + "WHERE ph.MA_PHONG_HAT = ? "
                + "AND cttp.TRANG_THAI = 1;";
        
        List<HD_CTTP_CTDV_PH_KH_TK_DTO> list = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, maPhongHat);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                int MA_PHONG_HAT = rs.getInt("MA_PHONG_HAT");
                String TEN_PHONG_HAT = rs.getString("TEN_PHONG_HAT");
                String TEN_TAI_KHOAN = rs.getString("TEN_TAI_KHOAN");
                String TEN_KHACH_HANG = rs.getString("TEN_KHACH_HANG");
                String GIO_DAT = rs.getString("GIO_DAT");
                boolean TRANG_THAI = rs.getBoolean("TRANG_THAI");
                
                HD_CTTP_CTDV_PH_KH_TK_DTO hd = new HD_CTTP_CTDV_PH_KH_TK_DTO(MA_HOA_DON, MA_PHONG_HAT, GIO_DAT, TRANG_THAI, TEN_PHONG_HAT, TEN_KHACH_HANG, TEN_TAI_KHOAN);               
                list.add(hd);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }
    }
    
    public double readGiaTienPhongHat(int maHoaDon){
        String sql = "SELECT (DATEDIFF(SECOND, cttp.THOI_GIAN_NHAN_PHONG, GETDATE()) / 3600.0) * lp.GIA_TIEN"
                + " AS DON_GIA_TIEN_PHONG FROM CHI_TIET_TIEN_PHONG cttp "
                + "JOIN PHONG_HAT ph ON cttp.MA_PHONG_HAT = ph.MA_PHONG_HAT "
                + "JOIN LOAI_PHONG lp ON ph.MA_LOAI_PHONG = lp.MA_LOAI_PHONG "
                + "WHERE cttp.MA_HOA_DON = ?";
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                return rs.getDouble("DON_GIA_TIEN_PHONG");
            }
            return 0;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public double readGiaTienDichVu(int maHoaDon){
        String sql = "SELECT SUM(DON_GIA) AS TONG " +
                     "FROM CHI_TIET_DICH_VU " +
                     "WHERE MA_HOA_DON = ?";
        double i = 0;
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                i = rs.getDouble("TONG");
            }
            return i;
        }catch(SQLException e){
            e.printStackTrace();
            return i;
        }
    }
    
    public List<HoaDonChiTietTienPhongDTO> readChiTietPhongHat(int maHoaDon){
        String sql = "select * from HOA_DON "
                + "JOIN CHI_TIET_TIEN_PHONG ON HOA_DON.MA_HOA_DON = CHI_TIET_TIEN_PHONG.MA_HOA_DON "
                + "WHERE HOA_DON.MA_HOA_DON = ?";
        List<HoaDonChiTietTienPhongDTO> list = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int MA_CHI_TIET_TIEN_PHONG = rs.getInt("MA_CHI_TIET_TIEN_PHONG");
                int MA_PHONG_HAT = rs.getInt("MA_PHONG_HAT");
                String THOI_GIAN_NHAN_PHONG = rs.getString("THOI_GIAN_NHAN_PHONG");
                String THOI_GIAN_TRA_PHONG = rs.getString("THOI_GIAN_TRA_PHONG");
                double DON_GIA = rs.getDouble("DON_GIA");
                
                HoaDonChiTietTienPhongDTO hd = new HoaDonChiTietTienPhongDTO(MA_CHI_TIET_TIEN_PHONG, MA_PHONG_HAT, THOI_GIAN_NHAN_PHONG, THOI_GIAN_TRA_PHONG, DON_GIA);
                list.add(hd);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }
    }
    
    public List<HoaDonChiTietDichVuDTO> readChiTietDichVu(int maHoaDon){
        String sql = "SELECT * FROM CHI_TIET_DICH_VU WHERE MA_HOA_DON = ?";
        List<HoaDonChiTietDichVuDTO> list = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int MA_CHI_TIET_DICH_VU = rs.getInt("MA_CHI_TIET_DICH_VU");
                int MA_DICH_VU = rs.getInt("MA_DICH_VU");
                int SO_LUONG = rs.getInt("SO_LUONG");
                double DON_GIA = rs.getDouble("DON_GIA");
                
                HoaDonChiTietDichVuDTO hd = new HoaDonChiTietDichVuDTO(MA_CHI_TIET_DICH_VU, MA_DICH_VU, SO_LUONG, DON_GIA);
                list.add(hd);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }
    }
    
    public double readTongTien(int maHoaDon){
        String sql = "SELECT TONG_TIEN from HOA_DON where MA_HOA_DON = ?";
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                return rs.getDouble("TONG_TIEN");
            }
            return 0;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
 


public HD_CTTP_CTDV_PH_KH_TK_DTO timHoaDon(int mahd){
                String sql = "SELECT  * FROM HOA_DON "
                + "JOIN KHACH_HANG ON HOA_DON.MA_KHACH_HANG = KHACH_HANG.MA_KHACH_HANG "
                + "JOIN TAI_KHOAN ON HOA_DON.MA_TAI_KHOAN = TAI_KHOAN.MA_TAI_KHOAN  "
                +"WHERE MA_HOA_DON =?";
        
        HD_CTTP_CTDV_PH_KH_TK_DTO hd = null;
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, mahd); 

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                String TEN_KHACH_HANG = rs.getString("TEN_KHACH_HANG");
                String HO_TEN = rs.getString("HO_TEN");
                double TONG_TIEN = rs.getDouble("TONG_TIEN");
                java.util.Date NGAY_TAO = rs.getDate("NGAY_TAO");
                boolean TRANG_THAI_THANH_TOAN = rs.getBoolean("TRANG_THAI_THANH_TOAN");
                hd = new HD_CTTP_CTDV_PH_KH_TK_DTO(MA_HOA_DON, TRANG_THAI_THANH_TOAN, TONG_TIEN, NGAY_TAO, TEN_KHACH_HANG, HO_TEN);
}

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return hd;
    }
}