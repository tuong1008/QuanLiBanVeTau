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
public class TuyenDiQuaTram {

     private String maTuyen, tenTram;
    private int STT;
    private Timestamp thoiGianHieuChinh;  //thoiGianThemTram là thời điểm chỉnh sửa Trạm trong Tuyến

    public String getMaTuyen() {
        return maTuyen;
    }

    public String getTenTram() {
        return tenTram;
    }

    public int getSTT() {
        return STT;
    }

    public Timestamp getThoiGianHieuChinh() {
        return thoiGianHieuChinh;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public void setThoiGianHieuChinh(Timestamp thoiGianHieuChinh) {
        this.thoiGianHieuChinh = thoiGianHieuChinh;
    }

}
