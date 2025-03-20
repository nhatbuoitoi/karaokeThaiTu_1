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
public class Khach_Hang {
        int MA_KHACH_HANG;
	String TEN_KHACH_HANG;
	String DIA_CHI;
	String SDT;
	Date NGAY_SINH;
        boolean GIOI_TINH;;

    public Khach_Hang() {
    }

    public Khach_Hang(int MA_KHACH_HANG, String TEN_KHACH_HANG, String DIA_CHI, String SDT, Date NGAY_SINH, boolean GIOI_TINH) {
        this.MA_KHACH_HANG = MA_KHACH_HANG;
        this.TEN_KHACH_HANG = TEN_KHACH_HANG;
        this.DIA_CHI = DIA_CHI;
        this.SDT = SDT;
        this.NGAY_SINH = NGAY_SINH;
        this.GIOI_TINH = GIOI_TINH;
    }

    public int getMA_KHACH_HANG() {
        return MA_KHACH_HANG;
    }

    public void setMA_KHACH_HANG(int MA_KHACH_HANG) {
        this.MA_KHACH_HANG = MA_KHACH_HANG;
    }

    public String getTEN_KHACH_HANG() {
        return TEN_KHACH_HANG;
    }

    public void setTEN_KHACH_HANG(String TEN_KHACH_HANG) {
        this.TEN_KHACH_HANG = TEN_KHACH_HANG;
    }

    public String getDIA_CHI() {
        return DIA_CHI;
    }

    public void setDIA_CHI(String DIA_CHI) {
        this.DIA_CHI = DIA_CHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNGAY_SINH() {
        return NGAY_SINH;
    }

    public void setNGAY_SINH(Date NGAY_SINH) {
        this.NGAY_SINH = NGAY_SINH;
    }

    public boolean isGIOI_TINH() {
        return GIOI_TINH;
    }

    public void setGIOI_TINH(boolean GIOI_TINH) {
        this.GIOI_TINH = GIOI_TINH;
    }
        
        

}
