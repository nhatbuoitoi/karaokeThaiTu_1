/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Dich_Vu {
        int MA_DICH_VU;;
	String TEN_DICH_VU;
	double GIA;
	String MIEU_TA;
	int MA_DANH_MUC;

    public Dich_Vu() {
    }

    public Dich_Vu(int MA_DICH_VU, String TEN_DICH_VU, double GIA, String MIEU_TA, int MA_DANH_MUC) {
        this.MA_DICH_VU = MA_DICH_VU;
        this.TEN_DICH_VU = TEN_DICH_VU;
        this.GIA = GIA;
        this.MIEU_TA = MIEU_TA;
        this.MA_DANH_MUC = MA_DANH_MUC;
    }

    public int getMA_DICH_VU() {
        return MA_DICH_VU;
    }

    public void setMA_DICH_VU(int MA_DICH_VU) {
        this.MA_DICH_VU = MA_DICH_VU;
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

    public String getMIEU_TA() {
        return MIEU_TA;
    }

    public void setMIEU_TA(String MIEU_TA) {
        this.MIEU_TA = MIEU_TA;
    }

    public int getMA_DANH_MUC() {
        return MA_DANH_MUC;
    }

    public void setMA_DANH_MUC(int MA_DANH_MUC) {
        this.MA_DANH_MUC = MA_DANH_MUC;
    }
        
        
}
