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
public class Tuyen {
    private String maTuyen, tenTuyen;
    private Timestamp thoiGianHieuChinh;
    private String strThoiGianHieuChinh;


    public Tuyen() {
    }


    public Tuyen(String maTuyen, String tenTuyen) {

        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;


    }

    public Timestamp getThoiGianHieuChinh() {
        return thoiGianHieuChinh;
    }

    public void setThoiGianHieuChinh(Timestamp thoiGianHieuChinh) {
        this.thoiGianHieuChinh = thoiGianHieuChinh;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public String getStrThoiGianHieuChinh() {
        return strThoiGianHieuChinh;
    }

    public void setStrThoiGianHieuChinh(String strThoiGianHieuChinh) {
        this.strThoiGianHieuChinh = strThoiGianHieuChinh;
    }

    
    



    
}
