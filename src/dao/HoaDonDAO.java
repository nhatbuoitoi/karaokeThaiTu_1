/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import entity.Hoa_Don;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author This PC
 */
public class HoaDonDAO {
    public List<Hoa_Don> readHoaDon(){
        String sql = "SELECT * FROM HOA_DON";
        List<Hoa_Don> listHoaDon = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            while(rs.next()){
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                int MA_KHACH_HANG= rs.getInt("MA_KHACH_HANG");
                boolean TRANG_THAI_THANH_TOAN = rs.getBoolean("TRANG_THAI_THANH_TOAN");
                int MA_KHUYEN_MAI = rs.getInt("MA_KHUYEN_MAI");
                int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
                double TONG_TIEN = rs.getDouble("TONG_TIEN");
                Date NGAY_TAO = rs.getDate("NGAY_TAO");
                Hoa_Don hoaDon = new Hoa_Don(MA_HOA_DON, MA_KHACH_HANG, TRANG_THAI_THANH_TOAN, MA_KHUYEN_MAI, MA_TAI_KHOAN, TONG_TIEN, NGAY_TAO);
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (Exception e) {
            return listHoaDon;
        }
    }
    
    public Hoa_Don timHoaDon(int maHoaDon){
        String sql = "SELECT * FROM HOA_DON WHERE MA_HOA_DON = ?";
        Hoa_Don hoaDon = null;
        try(Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int MA_HOA_DON = rs.getInt("MA_HOA_DON");
                int MA_KHACH_HANG= rs.getInt("MA_KHACH_HANG");
                boolean TRANG_THAI_THANH_TOAN = rs.getBoolean("TRANG_THAI_THANH_TOAN");
                int MA_KHUYEN_MAI = rs.getInt("MA_KHUYEN_MAI");
                int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
                double TONG_TIEN = rs.getDouble("TONG_TIEN");
                Date NGAY_TAO = rs.getDate("NGAY_TAO");
                hoaDon = new Hoa_Don(MA_HOA_DON, MA_KHACH_HANG, TRANG_THAI_THANH_TOAN, MA_KHUYEN_MAI, MA_TAI_KHOAN, TONG_TIEN, NGAY_TAO);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
    }
}
