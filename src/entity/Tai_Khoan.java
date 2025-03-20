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
public class Tai_Khoan {
        int MA_TAI_KHOAN;
	String MAT_KHAU;
	String HO_TEN;
	Date NAM_SINH;
	String EMAIL;;
	String SDT;
	boolean VAI_TRO;

    public Tai_Khoan() {
    }

    public Tai_Khoan(int MA_TAI_KHOAN, String MAT_KHAU, String HO_TEN, Date NAM_SINH, String EMAIL, String SDT, boolean VAI_TRO) {
        this.MA_TAI_KHOAN = MA_TAI_KHOAN;
        this.MAT_KHAU = MAT_KHAU;
        this.HO_TEN = HO_TEN;
        this.NAM_SINH = NAM_SINH;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
        this.VAI_TRO = VAI_TRO;
    }

    public int getMA_TAI_KHOAN() {
        return MA_TAI_KHOAN;
    }

    public void setMA_TAI_KHOAN(int MA_TAI_KHOAN) {
        this.MA_TAI_KHOAN = MA_TAI_KHOAN;
    }

    public String getMAT_KHAU() {
        return MAT_KHAU;
    }

    public void setMAT_KHAU(String MAT_KHAU) {
        this.MAT_KHAU = MAT_KHAU;
    }

    public String getHO_TEN() {
        return HO_TEN;
    }

    public void setHO_TEN(String HO_TEN) {
        this.HO_TEN = HO_TEN;
    }

    public Date getNAM_SINH() {
        return NAM_SINH;
    }

    public void setNAM_SINH(Date NAM_SINH) {
        this.NAM_SINH = NAM_SINH;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isVAI_TRO() {
        return VAI_TRO;
    }

    public void setVAI_TRO(boolean VAI_TRO) {
        this.VAI_TRO = VAI_TRO;
    }
    
    
        
        
}
