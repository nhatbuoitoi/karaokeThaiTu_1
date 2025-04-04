/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import entity.Danh_Muc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Hong Kien
 */
public class DanhMucDAO {
   
     public List<Danh_Muc> readDanhMuc(){
        String sql = "SElECT * FROM DANH_MUC" ;
        List<Danh_Muc> DMlst = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                 int ma_danh_muc = rs.getInt("MA_DANH_MUC");
                 String ten_danh_muc = rs.getString("TEN_DANH_MUC");
                
                 
                Danh_Muc DM = new Danh_Muc(ma_danh_muc, ten_danh_muc);
                DMlst.add(DM);
            }
            return DMlst;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return DMlst    ;
        }
     }    public int createDanhMuc(Danh_Muc dm){ //3.add dữ liệu vào table và database
        String sql = "INSERT INTO DANH_MUC VALUES(?, ?)";
        try (Connection con = KetNoiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1, dm.getMA_DANH_MUC());
            ps.setString(2, dm.getTEN_DANH_MUC());
            
            int ketQua = ps.executeUpdate();
            return ketQua;
        } 
        catch (Exception e) {
            return 0;
        }
    }
      public int deleteDanhMuc(String maDanhMuc){ 
        String sql = "DELETE FROM DANH_MUC WHERE MA_DANH_MUC = (?)";
                try (Connection con = KetNoiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setString(1, maDanhMuc);

            int ketQua = ps.executeUpdate();
            return ketQua;
        } 
        catch (Exception e) {
            return 0;
        }
    }
     public int updateDanhMuc(Danh_Muc dm) {
    String sql = "UPDATE DANH_MUC SET TEN_DANH_MUC = ? WHERE MA_DANH_MUC = ?";
    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(2, dm.getMA_DANH_MUC());
        ps.setString(1, dm.getTEN_DANH_MUC());
        int ketQua = ps.executeUpdate(); 
        return ketQua;
    } catch (Exception e) {
        e.printStackTrace(); 
        return 0;
    }
} 
     public Danh_Muc timDanhMuc(int madm){
        String sql = "SELECT * FROM DANH_MUC WHERE MA_DANH_MUC = ?";
        Danh_Muc dm = null;
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, madm); 

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

    int ma_danh_muc = rs.getInt("MA_DANH_MUC");
    String ten_danh_muc = rs.getString("TEN_DANH_MUC");

    // Gán trực tiếp vào dv
    dm = new Danh_Muc(ma_danh_muc, ten_danh_muc);
}

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return dm;
    }
}
