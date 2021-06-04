/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module;

import java.sql.Timestamp;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Toa {
    private String maToa, tenToa;
    private int soChoNgoi, giaChoNgoi;
    private String maLoaiToa;
    private Timestamp thoiGianHieuChinhTau;
    public Toa() {
    }

    public Toa(String maToa, String tenToa, int soChoNgoi,int giaChoNgoi, String maLoaiToa, Timestamp thoiGianHieuChinhTau) {
        this.maToa = maToa;
        this.tenToa = tenToa;
        this.soChoNgoi = soChoNgoi;
        this.giaChoNgoi=giaChoNgoi;
        this.maLoaiToa = maLoaiToa;
        this.thoiGianHieuChinhTau=thoiGianHieuChinhTau;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    public String getTenToa() {
        return tenToa;
    }

    public void setTenToa(String tenToa) {
        this.tenToa = tenToa;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getMaLoaiToa() {
        return maLoaiToa;
    }

    public void setMaLoaiToa(String maLoaiToa) {
        this.maLoaiToa = maLoaiToa;
    }

    public Timestamp getThoiGianHieuChinhTau() {
        return thoiGianHieuChinhTau;
    }

    public void setThoiGianHieuChinhTau(Timestamp thoiGianHieuChinhTau) {
        this.thoiGianHieuChinhTau = thoiGianHieuChinhTau;
    }

    public int getGiaChoNgoi() {
        return giaChoNgoi;
    }

    public void setGiaChoNgoi(int giaChoNgoi) {
        this.giaChoNgoi = giaChoNgoi;
    }
    
    
}
