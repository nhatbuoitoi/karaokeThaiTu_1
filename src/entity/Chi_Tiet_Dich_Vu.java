/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Chi_Tiet_Dich_Vu {
        int MA_CHI_TIET_DICH_VU;
	int MA_HOA_DON;
	int MA_DICH_VU;
	int SO_LUONG;
	double DON_GIA;

    public Chi_Tiet_Dich_Vu() {
    }

    public Chi_Tiet_Dich_Vu(int MA_CHI_TIET_DICH_VU, int MA_HOA_DON, int MA_DICH_VU, int SO_LUONG, double DON_GIA) {
        this.MA_CHI_TIET_DICH_VU = MA_CHI_TIET_DICH_VU;
        this.MA_HOA_DON = MA_HOA_DON;
        this.MA_DICH_VU = MA_DICH_VU;
        this.SO_LUONG = SO_LUONG;
        this.DON_GIA = DON_GIA;
    }

    public int getMA_CHI_TIET_DICH_VU() {
        return MA_CHI_TIET_DICH_VU;
    }

    public void setMA_CHI_TIET_DICH_VU(int MA_CHI_TIET_DICH_VU) {
        this.MA_CHI_TIET_DICH_VU = MA_CHI_TIET_DICH_VU;
    }

    public int getMA_HOA_DON() {
        return MA_HOA_DON;
    }

    public void setMA_HOA_DON(int MA_HOA_DON) {
        this.MA_HOA_DON = MA_HOA_DON;
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
 
}
