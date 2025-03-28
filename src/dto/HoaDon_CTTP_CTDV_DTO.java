/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author admin
 */
public class HoaDon_CTTP_CTDV_DTO {
    int MA_HOA_DON;
    int MA_TAI_KHOAN;
    int MA_KHACH_HANG;
    
    int MA_CHI_TIET_TIEN_PHONG;
    int MA_PHONG_HAT;
    String THOI_GIAN_NHAN_PHONG;
    String THOI_GIAN_TRA_PHONG;
    double DON_GIA_TIEN_PHONG;
    
    int MA_CHI_TIET_DICH_VU;
    int MA_DICH_VU;
    int SO_LUONG;
    double DON_GIA_DICH_VU;

    public HoaDon_CTTP_CTDV_DTO() {
    }

    public HoaDon_CTTP_CTDV_DTO(int MA_HOA_DON, int MA_TAI_KHOAN, int MA_KHACH_HANG, int MA_CHI_TIET_TIEN_PHONG, String THOI_GIAN_NHAN_PHONG, String THOI_GIAN_TRA_PHONG, double DON_GIA_TIEN_PHONG, int MA_CHI_TIET_DICH_VU, double DON_GIA_DICH_VU) {
        this.MA_HOA_DON = MA_HOA_DON;
        this.MA_TAI_KHOAN = MA_TAI_KHOAN;
        this.MA_KHACH_HANG = MA_KHACH_HANG;
        this.MA_CHI_TIET_TIEN_PHONG = MA_CHI_TIET_TIEN_PHONG;
        this.THOI_GIAN_NHAN_PHONG = THOI_GIAN_NHAN_PHONG;
        this.THOI_GIAN_TRA_PHONG = THOI_GIAN_TRA_PHONG;
        this.DON_GIA_TIEN_PHONG = DON_GIA_TIEN_PHONG;
        this.MA_CHI_TIET_DICH_VU = MA_CHI_TIET_DICH_VU;
        this.DON_GIA_DICH_VU = DON_GIA_DICH_VU;
    }

    public int getMA_HOA_DON() {
        return MA_HOA_DON;
    }

    public void setMA_HOA_DON(int MA_HOA_DON) {
        this.MA_HOA_DON = MA_HOA_DON;
    }

    public int getMA_TAI_KHOAN() {
        return MA_TAI_KHOAN;
    }

    public void setMA_TAI_KHOAN(int MA_TAI_KHOAN) {
        this.MA_TAI_KHOAN = MA_TAI_KHOAN;
    }

    public int getMA_KHACH_HANG() {
        return MA_KHACH_HANG;
    }

    public void setMA_KHACH_HANG(int MA_KHACH_HANG) {
        this.MA_KHACH_HANG = MA_KHACH_HANG;
    }

    public int getMA_CHI_TIET_TIEN_PHONG() {
        return MA_CHI_TIET_TIEN_PHONG;
    }

    public void setMA_CHI_TIET_TIEN_PHONG(int MA_CHI_TIET_TIEN_PHONG) {
        this.MA_CHI_TIET_TIEN_PHONG = MA_CHI_TIET_TIEN_PHONG;
    }

    public int getMA_PHONG_HAT() {
        return MA_PHONG_HAT;
    }

    public void setMA_PHONG_HAT(int MA_PHONG_HAT) {
        this.MA_PHONG_HAT = MA_PHONG_HAT;
    }

    public String getTHOI_GIAN_NHAN_PHONG() {
        return THOI_GIAN_NHAN_PHONG;
    }

    public void setTHOI_GIAN_NHAN_PHONG(String THOI_GIAN_NHAN_PHONG) {
        this.THOI_GIAN_NHAN_PHONG = THOI_GIAN_NHAN_PHONG;
    }

    public String getTHOI_GIAN_TRA_PHONG() {
        return THOI_GIAN_TRA_PHONG;
    }

    public void setTHOI_GIAN_TRA_PHONG(String THOI_GIAN_TRA_PHONG) {
        this.THOI_GIAN_TRA_PHONG = THOI_GIAN_TRA_PHONG;
    }

    public double getDON_GIA_TIEN_PHONG() {
        return DON_GIA_TIEN_PHONG;
    }

    public void setDON_GIA_TIEN_PHONG(double DON_GIA_TIEN_PHONG) {
        this.DON_GIA_TIEN_PHONG = DON_GIA_TIEN_PHONG;
    }

    public int getMA_CHI_TIET_DICH_VU() {
        return MA_CHI_TIET_DICH_VU;
    }

    public void setMA_CHI_TIET_DICH_VU(int MA_CHI_TIET_DICH_VU) {
        this.MA_CHI_TIET_DICH_VU = MA_CHI_TIET_DICH_VU;
    }

    public int getMA_DICH_VU() {
        return MA_DICH_VU;
    }

    public void setMA_DICH_VU(int MA_DICH_VU) {
        this.MA_DICH_VU = MA_DICH_VU;
    }

    public int getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(int SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }

    public double getDON_GIA_DICH_VU() {
        return DON_GIA_DICH_VU;
    }

    public void setDON_GIA_DICH_VU(double DON_GIA_DICH_VU) {
        this.DON_GIA_DICH_VU = DON_GIA_DICH_VU;
    }
    
    
    
    
}
