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
import java.sql.Time;
public class KhoangCachTram {
    private String tenTramNay;
    private String tenTramKia;
    private Time khoangThoiGian;
    private int soNgay;

    public String getTenTramNay() {
        return tenTramNay;
    }

    public String getTenTramKia() {
        return tenTramKia;
    }

    public Time getKhoangThoiGian() {
        return khoangThoiGian;
    }

    public void setTenTramNay(String tenTramNay) {
        this.tenTramNay = tenTramNay;
    }

    public void setTenTramKia(String tenTramKia) {
        this.tenTramKia = tenTramKia;
    }

    public void setKhoangThoiGian(Time khoangThoiGian) {
        this.khoangThoiGian = khoangThoiGian;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    

    
}
