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
public class LoaiVe {
    private String tenLoaiVe;
    private float heSo;

    public LoaiVe() {
    }

    public LoaiVe(String tenLoaiVe, float heSo) {
        this.tenLoaiVe = tenLoaiVe;
        this.heSo = heSo;
    }


    public String getTenLoaiVe() {
        return tenLoaiVe;
    }

    public void setTenLoaiVe(String tenLoaiVe) {
        this.tenLoaiVe = tenLoaiVe;
    }

    public float getHeSo() {
        return heSo;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }
    
}
