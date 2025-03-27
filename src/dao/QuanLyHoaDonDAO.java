/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
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
}
