/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Phong_Hat {
        int MA_PHONG_HAT;;
	String TEN_PHONG_HAT;;
	int SO_NGUOI;
	int MA_LOAI_PHONG;
	boolean TRANG_THAI;

    public Phong_Hat() {
    }

    public Phong_Hat(int MA_PHONG_HAT, String TEN_PHONG_HAT, int SO_NGUOI, int MA_LOAI_PHONG, boolean TRANG_THAI) {
        this.MA_PHONG_HAT = MA_PHONG_HAT;
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
        this.SO_NGUOI = SO_NGUOI;
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
        this.TRANG_THAI = TRANG_THAI;
    }

    public int getMA_PHONG_HAT() {
        return MA_PHONG_HAT;
    }

    public void setMA_PHONG_HAT(int MA_PHONG_HAT) {
        this.MA_PHONG_HAT = MA_PHONG_HAT;
    }

    public String getTEN_PHONG_HAT() {
        return TEN_PHONG_HAT;
    }

    public void setTEN_PHONG_HAT(String TEN_PHONG_HAT) {
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
    }

    public int getSO_NGUOI() {
        return SO_NGUOI;
    }

    public void setSO_NGUOI(int SO_NGUOI) {
        this.SO_NGUOI = SO_NGUOI;
    }

    public int getMA_LOAI_PHONG() {
        return MA_LOAI_PHONG;
    }

    public void setMA_LOAI_PHONG(int MA_LOAI_PHONG) {
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
    }

    public boolean isTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(boolean TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }
        
        
}
