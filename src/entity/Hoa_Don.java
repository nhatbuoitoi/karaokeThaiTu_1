/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Hoa_Don {
        int MA_HOA_DON;
	int MA_KHACH_HANG;
	boolean TRANG_THAI_THANH_TOAN;
	int MA_KHUYEN_MAI;
	int MA_TAI_KHOAN;
	double TONG_TIEN;
	String NGAY_TAO;

    public Hoa_Don() {
    }

    public Hoa_Don(int MA_HOA_DON, int MA_KHACH_HANG, boolean TRANG_THAI_THANH_TOAN, int MA_KHUYEN_MAI, int MA_TAI_KHOAN, double TONG_TIEN, String NGAY_TAO) {
        this.MA_HOA_DON = MA_HOA_DON;
        this.MA_KHACH_HANG = MA_KHACH_HANG;
        this.TRANG_THAI_THANH_TOAN = TRANG_THAI_THANH_TOAN;
        this.MA_KHUYEN_MAI = MA_KHUYEN_MAI;
        this.MA_TAI_KHOAN = MA_TAI_KHOAN;
        this.TONG_TIEN = TONG_TIEN;
        this.NGAY_TAO = NGAY_TAO;
    }

    public int getMA_HOA_DON() {
        return MA_HOA_DON;
    }

    public void setMA_HOA_DON(int MA_HOA_DON) {
        this.MA_HOA_DON = MA_HOA_DON;
    }

    public int getMA_KHACH_HANG() {
        return MA_KHACH_HANG;
    }

    public void setMA_KHACH_HANG(int MA_KHACH_HANG) {
        this.MA_KHACH_HANG = MA_KHACH_HANG;
    }

    public boolean isTRANG_THAI_THANH_TOAN() {
        return TRANG_THAI_THANH_TOAN;
    }

    public void setTRANG_THAI_THANH_TOAN(boolean TRANG_THAI_THANH_TOAN) {
        this.TRANG_THAI_THANH_TOAN = TRANG_THAI_THANH_TOAN;
    }

    public int getMA_KHUYEN_MAI() {
        return MA_KHUYEN_MAI;
    }

    public void setMA_KHUYEN_MAI(int MA_KHUYEN_MAI) {
        this.MA_KHUYEN_MAI = MA_KHUYEN_MAI;
    }

    public int getMA_TAI_KHOAN() {
        return MA_TAI_KHOAN;
    }

    public void setMA_TAI_KHOAN(int MA_TAI_KHOAN) {
        this.MA_TAI_KHOAN = MA_TAI_KHOAN;
    }

    public double getTONG_TIEN() {
        return TONG_TIEN;
    }

    public void setTONG_TIEN(double TONG_TIEN) {
        this.TONG_TIEN = TONG_TIEN;
    }

    public String getNGAY_TAO() {
        return NGAY_TAO;
    }

    public void setNGAY_TAO(String NGAY_TAO) {
        this.NGAY_TAO = NGAY_TAO;
    }

        
        
}
