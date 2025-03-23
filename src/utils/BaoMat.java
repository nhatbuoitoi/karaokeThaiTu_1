/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import db.KetNoiDB;
import java.sql.*;;


/**
 *
 * @author admin
 */
public class BaoMat {
    public boolean DangNhap(String mataikhoan,String matkhau){
         String sql = "SELECT * FROM TAI_KHOAN "
                + "WHERE MA_TAI_KHOAN = ? AND MAT_KHAU = ?";
            try (Connection con = KetNoiDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mataikhoan);  
            ps.setString(2, matkhau);
            
            ResultSet rs = ps.executeQuery();
            boolean result = rs.next();
            //lưu mã tài khoản và vai trò người đăng nhập
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
