/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Khuyen_Mai {
        int MA_KHUYEN_MAI;
	String TEN_KHUYEN_MAI;
	boolean TRANG_THAI;
	Date NGAY_BAT_DAU;
	Date NGAY_HET_HAN;
	int SO_LUOT_DUNG;
	String MIEU_TA;

    public Khuyen_Mai() {
    }

    public Khuyen_Mai(int MA_KHUYEN_MAI, String TEN_KHUYEN_MAI, boolean TRANG_THAI, Date NGAY_BAT_DAU, Date NGAY_HET_HAN, int SO_LUOT_DUNG, String MIEU_TA) {
        this.MA_KHUYEN_MAI = MA_KHUYEN_MAI;
        this.TEN_KHUYEN_MAI = TEN_KHUYEN_MAI;
        this.TRANG_THAI = TRANG_THAI;
        this.NGAY_BAT_DAU = NGAY_BAT_DAU;
        this.NGAY_HET_HAN = NGAY_HET_HAN;
        this.SO_LUOT_DUNG = SO_LUOT_DUNG;
        this.MIEU_TA = MIEU_TA;
    }

    public int getMA_KHUYEN_MAI() {
        return MA_KHUYEN_MAI;
    }

    public void setMA_KHUYEN_MAI(int MA_KHUYEN_MAI) {
        this.MA_KHUYEN_MAI = MA_KHUYEN_MAI;
    }

    public String getTEN_KHUYEN_MAI() {
        return TEN_KHUYEN_MAI;
    }

    public void setTEN_KHUYEN_MAI(String TEN_KHUYEN_MAI) {
        this.TEN_KHUYEN_MAI = TEN_KHUYEN_MAI;
    }

    public boolean isTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(boolean TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }

    public Date getNGAY_BAT_DAU() {
        return NGAY_BAT_DAU;
    }

    public void setNGAY_BAT_DAU(Date NGAY_BAT_DAU) {
        this.NGAY_BAT_DAU = NGAY_BAT_DAU;
    }

    public Date getNGAY_HET_HAN() {
        return NGAY_HET_HAN;
    }

    public void setNGAY_HET_HAN(Date NGAY_HET_HAN) {
        this.NGAY_HET_HAN = NGAY_HET_HAN;
    }

    public int getSO_LUOT_DUNG() {
        return SO_LUOT_DUNG;
    }

    public void setSO_LUOT_DUNG(int SO_LUOT_DUNG) {
        this.SO_LUOT_DUNG = SO_LUOT_DUNG;
    }

    public String getMIEU_TA() {
        return MIEU_TA;
    }

    public void setMIEU_TA(String MIEU_TA) {
        this.MIEU_TA = MIEU_TA;
    }
        
        
        
}
