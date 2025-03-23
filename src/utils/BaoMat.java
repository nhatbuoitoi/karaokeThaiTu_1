/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import db.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class BaoMat {
    public boolean DangNhap(String MATAIKHOAN,String MATKHAU){
         String sql = "SELECT * FROM TAI_KHOAN "
                + "WHERE MA_TAI_KHOAN =? AND MAT_KHAU = ?";
            try (Connection con = KetNoiDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, MATAIKHOAN);  
            ps.setString(2, MATKHAU);  
            ResultSet rs = ps.executeQuery();
            boolean result = rs.next();
            //lưu mã nhân viên và vai trò người đăng nhập
            if(result){
                GlobalState.MA_TAI_KHOAN = rs.getString("MA_TAI_KHOAN");
                GlobalState.VAI_TRO = rs.getBoolean("VAI_TRO");
            }
            return result;
        } catch (SQLException e) {
            return false;
        }
    }
}
