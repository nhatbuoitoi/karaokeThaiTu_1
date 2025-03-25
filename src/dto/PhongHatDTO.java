/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author This PC
 */
public class PhongHatDTO {
        int MA_LOAI_PHONG;
	String TEN_LOAI_PHONG;
	int GIA_TIEN;;
        int MA_PHONG_HAT;
	String TEN_PHONG_HAT;
	int SO_NGUOI;
	boolean TRANG_THAI;

    public PhongHatDTO() {
    }

    public PhongHatDTO(int MA_LOAI_PHONG, String TEN_LOAI_PHONG, int GIA_TIEN, int MA_PHONG_HAT, String TEN_PHONG_HAT, int SO_NGUOI, boolean TRANG_THAI) {
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
        this.TEN_LOAI_PHONG = TEN_LOAI_PHONG;
        this.GIA_TIEN = GIA_TIEN;
        this.MA_PHONG_HAT = MA_PHONG_HAT;
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
        this.SO_NGUOI = SO_NGUOI;
        this.TRANG_THAI = TRANG_THAI;
    }

    public void setMA_LOAI_PHONG(int MA_LOAI_PHONG) {
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
    }

    public void setTEN_LOAI_PHONG(String TEN_LOAI_PHONG) {
        this.TEN_LOAI_PHONG = TEN_LOAI_PHONG;
    }

    public void setGIA_TIEN(int GIA_TIEN) {
        this.GIA_TIEN = GIA_TIEN;
    }

    public void setMA_PHONG_HAT(int MA_PHONG_HAT) {
        this.MA_PHONG_HAT = MA_PHONG_HAT;
    }

    public void setTEN_PHONG_HAT(String TEN_PHONG_HAT) {
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
    }

    public void setSO_NGUOI(int SO_NGUOI) {
        this.SO_NGUOI = SO_NGUOI;
    }

    public void setTRANG_THAI(boolean TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }

    public int getMA_LOAI_PHONG() {
        return MA_LOAI_PHONG;
    }

    public String getTEN_LOAI_PHONG() {
        return TEN_LOAI_PHONG;
    }

    public int getGIA_TIEN() {
        return GIA_TIEN;
    }

    public int getMA_PHONG_HAT() {
        return MA_PHONG_HAT;
    }

    public String getTEN_PHONG_HAT() {
        return TEN_PHONG_HAT;
    }

    public int getSO_NGUOI() {
        return SO_NGUOI;
    }

    public boolean isTRANG_THAI() {
        return TRANG_THAI;
    }
        
        
}
