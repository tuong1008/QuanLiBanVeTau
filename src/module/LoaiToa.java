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
public class LoaiToa {
    private String maLoaiToa, tenLoaiToa;
    private int soChoNgoi,giaChoNgoi;    
    public LoaiToa() {
    }

    public LoaiToa(String maLoaiToa, String tenLoaiToa, int soChoNgoi, int giaChoNgoi ) {
        this.maLoaiToa = maLoaiToa;
        this.tenLoaiToa = tenLoaiToa;
        this.soChoNgoi=soChoNgoi;
        this.giaChoNgoi=giaChoNgoi;
        
    }

    public String getMaLoaiToa() {
        return maLoaiToa;
    }

    public void setMaLoaiToa(String maLoaiToa) {
        this.maLoaiToa = maLoaiToa;
    }

    public String getTenLoaiToa() {
        return tenLoaiToa;
    }

    public void setTenLoaiToa(String tenLoaiToa) {
        this.tenLoaiToa = tenLoaiToa;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public int getGiaChoNgoi() {
        return giaChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public void setGiaChoNgoi(int giaChoNgoi) {
        this.giaChoNgoi = giaChoNgoi;
    }

    
    
}
