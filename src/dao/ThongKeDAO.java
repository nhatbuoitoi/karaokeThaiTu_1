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
        } catch (Exception e) {
            return 0;
        }
    }
}
