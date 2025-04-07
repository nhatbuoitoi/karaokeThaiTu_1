/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author admin
 */
public class CTDV_DV_DM_DTO {
    int MA_CHI_TIET_DICH_VU;
    int MA_DICH_VU;
    int SO_LUONG;
    double DON_GIA;

    String TEN_DICH_VU;
    double GIA;
    
    int MA_DANH_MUC;
    String TEN_DANH_MUC;

    public CTDV_DV_DM_DTO() {
    }

    public CTDV_DV_DM_DTO(int MA_DICH_VU, int SO_LUONG, String TEN_DICH_VU, double GIA, String TEN_DANH_MUC) {
        this.MA_DICH_VU = MA_DICH_VU;
        this.SO_LUONG = SO_LUONG;
        this.TEN_DICH_VU = TEN_DICH_VU;
        this.GIA = GIA;
        this.TEN_DANH_MUC = TEN_DANH_MUC;
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

    public double getDON_GIA() {
        return DON_GIA;
    }

    public void setDON_GIA(double DON_GIA) {
        this.DON_GIA = DON_GIA;
    }

    public String getTEN_DICH_VU() {
        return TEN_DICH_VU;
    }

    public void setTEN_DICH_VU(String TEN_DICH_VU) {
        this.TEN_DICH_VU = TEN_DICH_VU;
    }

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public int getMA_DANH_MUC() {
        return MA_DANH_MUC;
    }

    public void setMA_DANH_MUC(int MA_DANH_MUC) {
        this.MA_DANH_MUC = MA_DANH_MUC;
    }

    public String getTEN_DANH_MUC() {
        return TEN_DANH_MUC;
    }

    public void setTEN_DANH_MUC(String TEN_DANH_MUC) {
        this.TEN_DANH_MUC = TEN_DANH_MUC;
    }
    
    
}
