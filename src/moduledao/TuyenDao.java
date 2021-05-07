/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import connectSQL.LopKetNoi;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import module.Tuyen;
import module.TuyenDiQuaTram;
import java.sql.Time;
import module.KhoangCachTram;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TuyenDao {
    
    /**
     *
     * @param DS
     * @param dau
     * @return
     */
    public String chuyenArrayListStringSangString(ArrayList<String> DS, String dau) {
        String tam = "";
        for (String s : DS) {
            tam += s + dau;
        }
        return tam.substring(0, tam.length() - 1);
    }
    
    /**
     *
     * @param DS
     * @param dau
     * @return
     */
    public String chuyenArrayListIntSangString(ArrayList<Integer> DS, String dau) {
        String tam = "";
        for (Integer s : DS) {
            tam += Integer.toString(s) + dau;
        }
        return tam.substring(0, tam.length() - 1);
    }

    /**
     *
     * @param maTuyen
     * @return
     */
    public ArrayList<String> getDSTramDiQua(String maTuyen) {
        ArrayList<String> DS = new ArrayList<>();
        try {
            ResultSet rs = LopKetNoi.select("select tenTram from TuyenDiQuaTram where maTuyen=? order by thoiGianDen ASC", maTuyen);
            while (rs.next()) {
                DS.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get ds tram di qua that bai");
        }
        return DS;
    }
    
    public Time getKhoangCach(String tenTramNay,String tenTramKia) {
        Time tempKhoangThoiGian=null;
        try {
            ResultSet rs = LopKetNoi.select("select khoangCach from KhoangCachTram where TenTramNay=? and TenTramKia=?", tenTramNay,tenTramKia);
            while (rs.next()) {
                tempKhoangThoiGian=rs.getTime("khoangCach");
            }
        } catch (Exception e) {
            System.out.println("get ds thoi gian that bai");
        }
        return tempKhoangThoiGian;
    }
    
    /**
     *
     * @param rs
     * @param model
     */
    public void loadDSTuyenVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                String maTuyen = rs.getString(1);
                String tenTuyen = rs.getString(2);
                model.addRow(new Object[]{maTuyen, tenTuyen});
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("load ds tuyen vao bang that bai");
        }
    }
    
    public void themTuyenDiQuaTram(TuyenDiQuaTram tuyenQuaTram) {
        try {
            LopKetNoi.update("insert into tuyendiquatram values(?,?,GETDATE(),?)", tuyenQuaTram.getMaTuyen(),
                    tuyenQuaTram.getTenTram(),  tuyenQuaTram.getSTT());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param tuyen
     */
    
    
    /**
     *
     * @param tuyen
     */
    public void themKhoangCachVaoDB(KhoangCachTram khoangCach) {
        try {
            LopKetNoi.update("insert into KhoangCachTram values(?,?,?)", khoangCach.getTenTramNay(), khoangCach.getTenTramKia(),khoangCach.getKhoangThoiGian());
            //themTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
        }
    }
    public boolean themTuyenVaoDB(Tuyen tuyen) {
        try {
            LopKetNoi.update("insert into tuyen values(?,?)", tuyen.getMaTuyen(), tuyen.getTenTuyen());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @param tuyen
     */
    public void suaTuyenTrongDB(Tuyen tuyen) {
        try {
            LopKetNoi.update("update tuyen set TenTuyen = ? where MaTuyen = ?", tuyen.getTenTuyen(), tuyen.getMaTuyen());
        } catch (Exception e) {
            System.out.println("sua tuyen that bai");
        }
    }
    
    /**
     *
     * @param maTuyen
     * @return
     */
    public boolean xoaTuyenTrongDB(String maTuyen,LopKetNoi ketNoiCSDL) {
        try {
            ResultSet rs = ketNoiCSDL.select("select * from tuyendiquatram where  MaTuyen = ?", maTuyen);
            if (rs.next()) {
                return false;
            } else {
                ResultSet rs2 = ketNoiCSDL.select("select * from TauChayTuyen where  MaTuyen = ?", maTuyen);
                if (rs2.next()) {
                    return false;
                } else {
                    LopKetNoi.update("delete from Tuyen where MaTuyen = ?", maTuyen);
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Tuyến đã đi qua Trạm hoặc có Tàu đang chạy, không thể xoá!");
            return false;
        }
    }
    
    /**
     *
     * @param tuyen
     * @param jtb
     */
    public void themTuyenVaoBang(Tuyen tuyen, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.addRow(new Object[]{tuyen.getMaTuyen(), tuyen.getTenTuyen()});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }
    
//    public void suaTuyenTrongBang(Tuyen tuyen, int hang, JTable jtb) {
//        jtb.setValueAt(tuyen.getTenTuyen(), hang, 1);
//        jtb.setValueAt(tuyen.DSTramDiQuaSangChuoi(), hang, 2);
//        jtb.setValueAt(tuyen.DSKhoangCachSangChuoi(), hang, 3);
//    }
    
    /**
     *
     * @param hang
     * @param model
     */
    public void xoaTramKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }
    
    /**
     *
     * @param hang
     * @param jtb
     * @param maTuyen
     * @param tenTuyen
     * @param tramDiQua
     * @param khoangCach
     */
    public void getTuyenTuBang(int hang, JTable jtb, JTextField maTuyen, JTextField tenTuyen) {
        maTuyen.setText(jtb.getValueAt(hang, 0) + "");
        tenTuyen.setText(jtb.getValueAt(hang, 1) + "");
    }
}
