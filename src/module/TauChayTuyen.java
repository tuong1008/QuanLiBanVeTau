/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Timestamp;

/**
 *
 * @author Tuong
 */
public class TauChayTuyen {
    private String maTau, maTuyen;
    private Timestamp thoiGianKhoiHanh, thoiGianDen, thoiGianDenTramDi, thoiGianHieuChinhTau, thoiGianHieuChinhTuyen;

    public Timestamp getThoiGianHieuChinhTau() {
        return thoiGianHieuChinhTau;
    }

    public Timestamp getThoiGianHieuChinhTuyen() {
        return thoiGianHieuChinhTuyen;
    }

    public void setThoiGianHieuChinhTau(Timestamp thoiGianHieuChinhTau) {
        this.thoiGianHieuChinhTau = thoiGianHieuChinhTau;
    }

    public void setThoiGianHieuChinhTuyen(Timestamp thoiGianHieuChinhTuyen) {
        this.thoiGianHieuChinhTuyen = thoiGianHieuChinhTuyen;
    }

    public String getMaTau() {
        return maTau;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public Timestamp getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public Timestamp getThoiGianDen() {
        return thoiGianDen;
    }

    public void setMaTau(String maTau) {
        this.maTau = maTau;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public void setThoiGianKhoiHanh(Timestamp thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
    }

    public void setThoiGianDen(Timestamp thoiGianDen) {
        this.thoiGianDen = thoiGianDen;
    }

    public Timestamp getThoiGianDenTramDi() {
        return thoiGianDenTramDi;
    }

    public void setThoiGianDenTramDi(Timestamp thoiGianDenTramDi) {
        this.thoiGianDenTramDi = thoiGianDenTramDi;
    }
    
}
