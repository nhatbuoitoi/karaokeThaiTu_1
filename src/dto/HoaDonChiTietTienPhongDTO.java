/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author admin
 */
public class HoaDonChiTietTienPhongDTO {
    int maHoaDon;
    int maKhachHang;
    int maTaiKhoan;
    double tongTien;
    String gioDat;
    boolean trangThai;
    
    int maChiTietTienPhong;
    int maPhongHat;
    String THOI_GIAN_NHAN_PHONG;
    String THOI_GIAN_TRA_PHONG;
    double donGia;
    String mieuTa;
    boolean trangThaiPhong;

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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public boolean isTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(boolean trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public HoaDonChiTietTienPhongDTO() {
    }

    public HoaDonChiTietTienPhongDTO(int maHoaDon, int maKhachHang, int maTaiKhoan, double tongTien, String gioDat, boolean trangThai, int maChiTietTienPhong, int maPhongHat) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maTaiKhoan = maTaiKhoan;
        this.tongTien = tongTien;
        this.gioDat = gioDat;
        this.trangThai = trangThai;
        this.maChiTietTienPhong = maChiTietTienPhong;
        this.maPhongHat = maPhongHat;
    }
    
    public HoaDonChiTietTienPhongDTO(int maHoaDon, int maKhachHang, int maTaiKhoan, double tongTien, String gioDat, boolean trangThai, int maPhongHat) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maTaiKhoan = maTaiKhoan;
        this.tongTien = tongTien;
        this.gioDat = gioDat;
        this.trangThai = trangThai;
        this.maPhongHat = maPhongHat;
    }
    
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGioDat() {
        return gioDat;
    }

    public void setGioDat(String gioDat) {
        this.gioDat = gioDat;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaChiTietTienPhong() {
        return maChiTietTienPhong;
    }

    public void setMaChiTietTienPhong(int maChiTietTienPhong) {
        this.maChiTietTienPhong = maChiTietTienPhong;
    }

    public int getMaPhongHat() {
        return maPhongHat;
    }

    public void setMaPhongHat(int maPhongHat) {
        this.maPhongHat = maPhongHat;
    }
    
    
}
