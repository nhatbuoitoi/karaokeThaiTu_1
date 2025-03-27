/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


/**
 *
 * @author admin
 */
public class Chi_Tiet_Tien_Phong {
        int MA_CHI_TIET_TIEN_PHONG;
	int MA_HOA_DON;
	int MA_PHONG_HAT;
	String THOI_GIAN_NHAN_PHONG;
	String THOI_GIAN_TRA_PHONG;
	double DON_GIA;

    public Chi_Tiet_Tien_Phong() {
    }

    public Chi_Tiet_Tien_Phong(int MA_CHI_TIET_TIEN_PHONG, int MA_HOA_DON, int MA_PHONG_HAT, String THOI_GIAN_NHAN_PHONG, String THOI_GIAN_TRA_PHONG, double DON_GIA) {
        this.MA_CHI_TIET_TIEN_PHONG = MA_CHI_TIET_TIEN_PHONG;
        this.MA_HOA_DON = MA_HOA_DON;
        this.MA_PHONG_HAT = MA_PHONG_HAT;
        this.THOI_GIAN_NHAN_PHONG = THOI_GIAN_NHAN_PHONG;
        this.THOI_GIAN_TRA_PHONG = THOI_GIAN_TRA_PHONG;
        this.DON_GIA = DON_GIA;
    }

    public void setMA_CHI_TIET_TIEN_PHONG(int MA_CHI_TIET_TIEN_PHONG) {
        this.MA_CHI_TIET_TIEN_PHONG = MA_CHI_TIET_TIEN_PHONG;
    }

    public void setMA_HOA_DON(int MA_HOA_DON) {
        this.MA_HOA_DON = MA_HOA_DON;
    }

    public void setMA_PHONG_HAT(int MA_PHONG_HAT) {
        this.MA_PHONG_HAT = MA_PHONG_HAT;
    }

    public void setTHOI_GIAN_NHAN_PHONG(String THOI_GIAN_NHAN_PHONG) {
        this.THOI_GIAN_NHAN_PHONG = THOI_GIAN_NHAN_PHONG;
    }

    public void setTHOI_GIAN_TRA_PHONG(String THOI_GIAN_TRA_PHONG) {
        this.THOI_GIAN_TRA_PHONG = THOI_GIAN_TRA_PHONG;
    }

    public void setDON_GIA(double DON_GIA) {
        this.DON_GIA = DON_GIA;
    }

    public int getMA_CHI_TIET_TIEN_PHONG() {
        return MA_CHI_TIET_TIEN_PHONG;
    }

    public int getMA_HOA_DON() {
        return MA_HOA_DON;
    }

    public int getMA_PHONG_HAT() {
        return MA_PHONG_HAT;
    }

    public String getTHOI_GIAN_NHAN_PHONG() {
        return THOI_GIAN_NHAN_PHONG;
    }

    public String getTHOI_GIAN_TRA_PHONG() {
        return THOI_GIAN_TRA_PHONG;
    }

    public double getDON_GIA() {
        return DON_GIA;
    }

        
    
        

}
