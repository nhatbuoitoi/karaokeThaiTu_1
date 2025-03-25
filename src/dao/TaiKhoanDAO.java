/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import entity.Tai_Khoan;
import java.sql.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class TaiKhoanDAO {
    public List<Tai_Khoan> readTaiKhoan(){
        String sql = "SELECT * FROM TAI_KHOAN";
        List<Tai_Khoan> listTK = new ArrayList<>();
        try(Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            while(rs.next()){
                int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
                String MAT_KHAU = rs.getString("MAT_KHAU");
                String HO_TEN = rs.getString("HO_TEN");
                java.util.Date NAM_SINH = rs.getDate("NAM_SINH");
                String EMAIL = rs.getString("EMAIL");
                String SDT = rs.getString("SDT");
                boolean VAI_TRO = rs.getBoolean("VAI_TRO");
                Tai_Khoan tk = new Tai_Khoan(MA_TAI_KHOAN, MAT_KHAU, HO_TEN, NAM_SINH, EMAIL, SDT, VAI_TRO);
                listTK.add(tk);
            }
            return listTK;
        }catch(SQLException e){
            return listTK;
        }
        
    }
    
    public Tai_Khoan timTaiKhoan(int mataikhoan){
        String sql = "Select * from TAI_KHOAN where MA_TAI_KHOAN = ?";
        Tai_Khoan tk = null;
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, mataikhoan); 

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int MA_TAI_KHOAN = rs.getInt("MA_TAI_KHOAN");
            String MAT_KHAU = rs.getString("MAT_KHAU");
            String HO_TEN = rs.getString("HO_TEN");
            java.util.Date NAM_SINH = rs.getDate("NAM_SINH");
            String EMAIL = rs.getString("EMAIL");
            String SDT = rs.getString("SDT");
            boolean VAI_TRO = rs.getBoolean("VAI_TRO");
            tk = new Tai_Khoan(MA_TAI_KHOAN, MAT_KHAU, HO_TEN, NAM_SINH, EMAIL, SDT, VAI_TRO);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return tk;
    }
    
    public void themTaiKhoan(Tai_Khoan tk){
        String sql = "Insert into TAI_KHOAN values (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, tk.getMA_TAI_KHOAN()); 
        ps.setString(2, tk.getMAT_KHAU()); 
        ps.setString(3, tk.getHO_TEN()); 
        ps.setDate(4, (java.sql.Date) tk.getNAM_SINH());
        ps.setString(5, tk.getEMAIL()); 
        ps.setString(6, tk.getSDT()); 
        ps.setBoolean(7, tk.isVAI_TRO()); 
        
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
        
    }
    
    public void capNhatTaiKhoan(Tai_Khoan tk) {
    String sql = "UPDATE TAI_KHOAN SET MAT_KHAU = ?, HO_TEN = ?, NAM_SINH = ?, EMAIL = ?, SDT = ?, VAI_TRO = ? WHERE MA_TAI_KHOAN = ?";
    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, tk.getMAT_KHAU());
        ps.setString(2, tk.getHO_TEN());
        ps.setDate(3, (java.sql.Date) tk.getNAM_SINH()); 
        ps.setString(4, tk.getEMAIL());
        ps.setString(5, tk.getSDT());
        ps.setBoolean(6, tk.isVAI_TRO());
        ps.setInt(7, tk.getMA_TAI_KHOAN());

        ps.executeUpdate(); 

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}
  
}
