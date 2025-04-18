 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.KetNoiDB;
import entity.Phong_Hat;
import entity.Loai_Phong;
import dto.PhongHatDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PhongHatDAO {
    public List<PhongHatDTO> readPhongHat(){
        String sql = "SELECT LOAI_PHONG.MA_LOAI_PHONG, PHONG_HAT.MA_PHONG_HAT, PHONG_HAT.TEN_PHONG_HAT, LOAI_PHONG.TEN_LOAI_PHONG, LOAI_PHONG.GIA_TIEN, PHONG_HAT.TRANG_THAI " +
                     "FROM PHONG_HAT " +
                     "INNER JOIN LOAI_PHONG ON PHONG_HAT.MA_LOAI_PHONG = LOAI_PHONG.MA_LOAI_PHONG " +
                     "ORDER BY LOAI_PHONG.GIA_TIEN DESC;";
        List<PhongHatDTO> phongHatDtoLst = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnection();
                PreparedStatement ps  = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            int MA_LOAI_PHONG = rs.getInt("MA_LOAI_PHONG");
            String TEN_LOAI_PHONG= rs.getString("TEN_LOAI_PHONG");
            double GIA_TIEN = rs.getDouble("GIA_TIEN");
            int MA_PHONG_HAT = rs.getInt("MA_PHONG_HAT");
            String TEN_PHONG_HAT = rs.getString("TEN_PHONG_HAT");
            boolean TRANG_THAI = rs.getBoolean("TRANG_THAI");
            PhongHatDTO phongHatDTO = new PhongHatDTO(MA_LOAI_PHONG, TEN_LOAI_PHONG, GIA_TIEN, MA_PHONG_HAT, TEN_PHONG_HAT, TRANG_THAI);
            phongHatDtoLst.add(phongHatDTO);
         }
            return  phongHatDtoLst;
            
        } catch (Exception e) {
            e.printStackTrace();
            return phongHatDtoLst;
        }
    }
    

}

