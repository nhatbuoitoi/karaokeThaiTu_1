/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HD_CTTP_CTDV_PH_KH_TK_DTO {
        int MA_HOA_DON;
	int MA_KHACH_HANG;
	boolean TRANG_THAI_THANH_TOAN;
	int MA_TAI_KHOAN;
	double TONG_TIEN;
	Date NGAY_TAO;
        
        int MA_CHI_TIET_TIEN_PHONG;
	int MA_PHONG_HAT;
	String THOI_GIAN_NHAN_PHONG;
	String THOI_GIAN_TRA_PHONG;
	double DON_GIA_PHONG_HAT;
        boolean TRANG_THAI;
        
        int MA_CHI_TIET_DICH_VU;
	int MA_DICH_VU;
	int SO_LUONG;
	double DON_GIA_DICH_VU;
        
	String TEN_PHONG_HAT;
	int MA_LOAI_PHONG;
	boolean TRANG_THAI_PHONG;
        
	String TEN_KHACH_HANG;
	String DIA_CHI;
	String SDT_KHACH_HANG;
	Date NGAY_SINH;
        boolean GIOI_TINH;
        
	String MAT_KHAU;
	String HO_TEN;
	Date NAM_SINH;
	String EMAIL;
	String SDT_TAI_KHOAN;
	boolean VAI_TRO;

    public HD_CTTP_CTDV_PH_KH_TK_DTO(int MA_HOA_DON, boolean TRANG_THAI_THANH_TOAN, double TONG_TIEN, Date NGAY_TAO, String TEN_KHACH_HANG, String HO_TEN) {
        this.MA_HOA_DON = MA_HOA_DON;
        this.TRANG_THAI_THANH_TOAN = TRANG_THAI_THANH_TOAN;
        this.TONG_TIEN = TONG_TIEN;
        this.NGAY_TAO = NGAY_TAO;
        this.TEN_KHACH_HANG = TEN_KHACH_HANG;
        this.HO_TEN = HO_TEN;
    }

    public HD_CTTP_CTDV_PH_KH_TK_DTO(String THOI_GIAN_NHAN_PHONG, String THOI_GIAN_TRA_PHONG, double DON_GIA_PHONG_HAT, double DON_GIA_DICH_VU, String TEN_PHONG_HAT, String TEN_KHACH_HANG, String HO_TEN) {
        this.THOI_GIAN_NHAN_PHONG = THOI_GIAN_NHAN_PHONG;
        this.THOI_GIAN_TRA_PHONG = THOI_GIAN_TRA_PHONG;
        this.DON_GIA_PHONG_HAT = DON_GIA_PHONG_HAT;
        this.DON_GIA_DICH_VU = DON_GIA_DICH_VU;
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
        this.TEN_KHACH_HANG = TEN_KHACH_HANG;
        this.HO_TEN = HO_TEN;
    }
    
        
        
    public HD_CTTP_CTDV_PH_KH_TK_DTO(int MA_HOA_DON, int MA_PHONG_HAT, String THOI_GIAN_NHAN_PHONG, boolean TRANG_THAI, String TEN_PHONG_HAT, String TEN_KHACH_HANG, String HO_TEN) {
        this.MA_HOA_DON = MA_HOA_DON;
        this.MA_PHONG_HAT = MA_PHONG_HAT;
        this.THOI_GIAN_NHAN_PHONG = THOI_GIAN_NHAN_PHONG;
        this.TRANG_THAI = TRANG_THAI;
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
        this.TEN_KHACH_HANG = TEN_KHACH_HANG;
        this.HO_TEN = HO_TEN;
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

    public Date getNGAY_TAO() {
        return NGAY_TAO;
    }

    public void setNGAY_TAO(Date NGAY_TAO) {
        this.NGAY_TAO = NGAY_TAO;
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

    public double getDON_GIA_PHONG_HAT() {
        return DON_GIA_PHONG_HAT;
    }

    public void setDON_GIA_PHONG_HAT(double DON_GIA_PHONG_HAT) {
        this.DON_GIA_PHONG_HAT = DON_GIA_PHONG_HAT;
    }

    public boolean isTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(boolean TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
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

    public String getTEN_PHONG_HAT() {
        return TEN_PHONG_HAT;
    }

    public void setTEN_PHONG_HAT(String TEN_PHONG_HAT) {
        this.TEN_PHONG_HAT = TEN_PHONG_HAT;
    }


    public int getMA_LOAI_PHONG() {
        return MA_LOAI_PHONG;
    }

    public void setMA_LOAI_PHONG(int MA_LOAI_PHONG) {
        this.MA_LOAI_PHONG = MA_LOAI_PHONG;
    }

    public boolean isTRANG_THAI_PHONG() {
        return TRANG_THAI_PHONG;
    }

    public void setTRANG_THAI_PHONG(boolean TRANG_THAI_PHONG) {
        this.TRANG_THAI_PHONG = TRANG_THAI_PHONG;
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

    public String getSDT_KHACH_HANG() {
        return SDT_KHACH_HANG;
    }

    public void setSDT_KHACH_HANG(String SDT_KHACH_HANG) {
        this.SDT_KHACH_HANG = SDT_KHACH_HANG;
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

    public String getSDT_TAI_KHOAN() {
        return SDT_TAI_KHOAN;
    }

    public void setSDT_TAI_KHOAN(String SDT_TAI_KHOAN) {
        this.SDT_TAI_KHOAN = SDT_TAI_KHOAN;
    }

    public boolean isVAI_TRO() {
        return VAI_TRO;
    }

    public void setVAI_TRO(boolean VAI_TRO) {
        this.VAI_TRO = VAI_TRO;
    }
        
        
}
