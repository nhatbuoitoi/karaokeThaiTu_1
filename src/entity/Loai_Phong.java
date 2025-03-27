/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Loai_Phong {
        int MA_LOAI_PHONG;
	String TEN_LOAI_PHONG;
	double GIA_TIEN;;

    public Loai_Phong(int MA_LOAI_PHONG, String TEN_LOAI_PHONG, double GIA_TIEN) {
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
        this.TEN_LOAI_PHONG = TEN_LOAI_PHONG;
        this.GIA_TIEN = GIA_TIEN;
    }

    public Loai_Phong() {
    }

    public int getMA_LOAI_PHONG() {
        return MA_LOAI_PHONG;
    }

    public void setMA_LOAI_PHONG(int MA_LOAI_PHONG) {
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
    }

    public String getTEN_LOAI_PHONG() {
        return TEN_LOAI_PHONG;
    }

    public void setTEN_LOAI_PHONG(String TEN_LOAI_PHONG) {
        this.TEN_LOAI_PHONG = TEN_LOAI_PHONG;
    }

    public double getGIA_TIEN() {
        return GIA_TIEN;
    }

    public void setGIA_TIEN(double GIA_TIEN) {
        this.GIA_TIEN = GIA_TIEN;
    }
            
}
