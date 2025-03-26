 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import dto.PhongHatDTO;
import entity.Phong_Hat;
import entity.Loai_Phong;
import dto.PhongHatDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongHatDAO {
    public List<PhongHatDTO> readPhongHat(){
        String sql = "SELECT * FROM LOAI_PHONG JOIN PHONG_HAT ON LOAI_PHONG.MA_LOAI_PHONG = PHONG_HAT.MA_LOAI_PHONG";
        List<PhongHatDTO> phongHatDtoLst = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnection();
                PreparedStatement ps  = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            int MA_LOAI_PHONG = rs.getInt("MA_LOAI_PHONG");
            String TEN_LOAI_PHONG= rs.getString("TEN_LOAI_PHONG");
            int GIA_TIEN = rs.getInt("GIA_TIEN");
            int MA_PHONG_HAT = rs.getInt("MA_PHONG_HAT");
            String TEN_PHONG_HAT = rs.getString("TEN_PHONG_HAT");
            int SO_NGUOI = rs.getInt("SO_NGUOI");
            boolean TRANG_THAI = rs.getBoolean("TRANG_THAI");
            PhongHatDTO phongHatDTO = new PhongHatDTO(MA_LOAI_PHONG, TEN_LOAI_PHONG, GIA_TIEN, MA_PHONG_HAT, TEN_PHONG_HAT, SO_NGUOI, TRANG_THAI);
            phongHatDtoLst.add(phongHatDTO);
         }
            return  phongHatDtoLst;
            
        } catch (Exception e) {
            e.printStackTrace();
            return phongHatDtoLst;
        }
    }
    public PhongHatDTO timPhongHat(int maPhongHat){
        String sql = "SELECT * FROM PHONG_HAT " +
                 "JOIN LOAI_PHONG ON PHONG_HAT.MA_LOAI_PHONG = LOAI_PHONG.MA_LOAI_PHONG " +
                 "WHERE MA_PHONG_HAT = ?";;
        PhongHatDTO PhongHat = null;
        try (Connection con = KetNoiDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, maPhongHat); 

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int MA_LOAI_PHONG = rs.getInt("MA_LOAI_PHONG");
            String TEN_LOAI_PHONG= rs.getString("TEN_LOAI_PHONG");
            int GIA_TIEN = rs.getInt("GIA_TIEN");
            int MA_PHONG_HAT = rs.getInt("MA_PHONG_HAT");
            String TEN_PHONG_HAT = rs.getString("TEN_PHONG_HAT");
            int SO_NGUOI = rs.getInt("SO_NGUOI");
            boolean TRANG_THAI = rs.getBoolean("TRANG_THAI");

    // Gán trực tiếp vào dv
    PhongHat = new PhongHatDTO(MA_LOAI_PHONG, TEN_LOAI_PHONG, GIA_TIEN, MA_PHONG_HAT, TEN_PHONG_HAT, SO_NGUOI, TRANG_THAI);
}

    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return PhongHat;
    }

}

