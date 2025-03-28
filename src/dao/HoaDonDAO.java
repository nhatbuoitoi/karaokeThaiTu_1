/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.HoaDonChiTietTienPhongDTO;
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
 * @author This PC
 */
public class HoaDonDAO {
    public List<HoaDonChiTietTienPhongDTO> readHoaDon(){
        String sql = "SELECT * FROM HOA_DON JOIN CHI_TIET_TIEN_PHONG ON HOA_DON.MA_HOA_DON = CHI_TIET_TIEN_PHONG.MA_HOA_DON JOIN PHONG_HAT ON CHI_TIET_TIEN_PHONG.MA_PHONG_HAT = PHONG_HAT.MA_PHONG_HAT WHERE PHONG_HAT.TRANG_THAI = 1";
        
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
}
