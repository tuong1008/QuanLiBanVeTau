/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Ve implements Comparable<Ve> {

    @Override
    public int compareTo(Ve o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String maVe, tenTaiKhoan;
    private int choNgoi;
    private String thoiGianLenTau, thoiGianDen;
    private String khuHoi;
    private float gia;
    private String tenLoaiVe, maChuyen;

    public Ve() {
    }

    public Ve(String maVe, String tenTaiKhoan, int choNgoi, String thoiGianLenTau, String thoiGianDen, 
            String khuHoi, float gia, String tenLoaiVe, String maChuyen) {
        this.maVe = maVe;
        this.tenTaiKhoan = tenTaiKhoan;
        this.choNgoi = choNgoi;
        this.thoiGianLenTau = thoiGianLenTau;
        this.thoiGianDen = thoiGianDen;
        this.khuHoi = khuHoi;
        this.gia = gia;
        this.tenLoaiVe = tenLoaiVe;
        this.maChuyen = maChuyen;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public int getChoNgoi() {
        return choNgoi;
    }

    public void setChoNgoi(int choNgoi) {
        this.choNgoi = choNgoi;
    }

    public String getThoiGianLenTau() {
        return thoiGianLenTau;
    }

    public void setThoiGianLenTau(String thoiGianLenTau) {
        this.thoiGianLenTau = thoiGianLenTau;
    }

    public String getThoiGianDen() {
        return thoiGianDen;
    }

    public void setThoiGianDen(String thoiGianDen) {
        this.thoiGianDen = thoiGianDen;
    }

    public String getKhuHoi() {
        return khuHoi;
    }

    public void setKhuHoi(String khuHoi) {
        this.khuHoi = khuHoi;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
    }

    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }
    
}
