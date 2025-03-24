/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.Dich_Vu;
import entity.Danh_Muc;
import dto.DichVuDanhMucDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import db.KetNoiDB;
import java.sql.*;
/**
 *
 * @author Tran Hong Kien
 */
public class DichVuDAO {
     public List<DichVuDanhMucDTO> readDichVu(){
        String sql = "SElECT * FROM DICH_VU\n" +
                     "JOIN DANH_MUC\n" +
                     "ON DICH_VU.MA_DANH_MUC = DANH_MUC.MA_DANH_MUC;";
        List<DichVuDanhMucDTO> DvDTOLst = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 int ma_dich_vu = rs.getInt("MA_DICH_VU");
                 String ten_dich_vu = rs.getString("TEN_DICH_VU");
                 double gia = rs.getDouble("GIA");
                 String mieu_ta = rs.getString("MIEU_TA");
                 int ma_danh_muc = rs.getInt("MA_DANH_MUC");
                 String ten_danh_muc = rs.getString("TEN_DANH_MUC");
                
                 
                DichVuDanhMucDTO DvDTO = new DichVuDanhMucDTO(ma_dich_vu, ten_dich_vu, gia, mieu_ta, ma_danh_muc, ten_danh_muc);
                DvDTOLst.add(DvDTO);
            }
            return DvDTOLst;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return DvDTOLst;
        }
    }
        public int createDichVU(Dich_Vu dv){ //3.add dữ liệu vào table và database
        String sql = "INSERT INTO DICH_VU VALUES(?, ?, ?, ?, ?)";
        try (Connection con = KetNoiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, dv.getMA_DICH_VU());
            ps.setString(2, dv.getTEN_DICH_VU());
            ps.setDouble(3, dv.getGIA());
            ps.setString(4, dv.getMIEU_TA());
            ps.setInt(5, dv.getMA_DANH_MUC());
           
            
            int ketQua = ps.executeUpdate();
            return ketQua;
        } 
        catch (Exception e) {
            return 0;
        }
    }
 public int deleteDichVu(String maDichVu){ //xóa dữ liệu
        String sql = "DELETE FROM DICH_VU WHERE MA_DICH_VU = (?)";
                try (Connection con = KetNoiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setString(1, maDichVu);

            int ketQua = ps.executeUpdate();
            return ketQua;
        } 
        catch (Exception e) {
            return 0;
        }
    }

public int updateDichVu(Dich_Vu dv) {
    String sql = "UPDATE DICH_VU SET TEN_DICH_VU = ?, GIA = ?, MIEU_TA = ?, MA_DANH_MUC = ? WHERE MA_DICH_VU = ?";
    try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, dv.getTEN_DICH_VU());
        ps.setDouble(2, dv.getGIA());
        ps.setString(3, dv.getMIEU_TA());
        ps.setInt(4, dv.getMA_DANH_MUC());
        ps.setInt(5, dv.getMA_DICH_VU());

        int ketQua = ps.executeUpdate(); 
        return ketQua;
    } catch (Exception e) {
        e.printStackTrace(); 
        return 0;
    }
}
public Dich_Vu timDichVu(int madv){
        String sql = "Select * from DICH_VU where MA_DICH_VU = ?";
        Dich_Vu dv = null;
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, madv); 

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int ma_dich_vu = rs.getInt("MA_DICH_VU");
                  String ten_dich_vu = rs.getString("TEN_DICH_VU");
                  double gia = rs.getDouble("GIA");
                  String mieu_ta = rs.getString("MIEU_TA");
                  int ma_danh_muc = rs.getInt("MA_DANH_MUC");
                  String ten_danh_muc = rs.getString("TEN_DANH_MUC");
              Dich_Vu Dv = new Dich_Vu(ma_dich_vu, ten_dich_vu, gia, mieu_ta, ma_danh_muc);
               
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return dv;
    }


}
