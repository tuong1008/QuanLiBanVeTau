/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import connectSQL.LopKetNoi;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import module.Tuyen;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    LopKetNoi ketNoiCSDL=new LopKetNoi();
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
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
    public ArrayList<String> getDSTramDiQua(String maTuyen,  java.sql.Timestamp tsThoiGianHieuChinh) {
        ArrayList<String> DS = new ArrayList<>();
        try {
            ResultSet rs = LopKetNoi.select("select tenTram from TuyenDiQuaTram where maTuyen=? and thoiGianHieuChinh=? order by STT ASC", maTuyen,tsThoiGianHieuChinh);
            while (rs.next()) {
                DS.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get ds tram di qua that bai");
        }
        return DS;
    }
    
    public KhoangCachTram getKhoangCachTram(String tenTramNay,String tenTramKia) {
        KhoangCachTram khoangCachTram=null;
        try {
            ResultSet rs = LopKetNoi.select("select * from KhoangCachTram where TenTramNay=? and TenTramKia=?", tenTramNay,tenTramKia);
            while (rs.next()) {
                khoangCachTram=new KhoangCachTram();
                khoangCachTram.setTenTramNay(tenTramNay);
                khoangCachTram.setTenTramKia(tenTramKia);
                khoangCachTram.setSoNgay(rs.getInt("SoNgay"));
                khoangCachTram.setKhoangThoiGian(rs.getTime("khoangCach"));
            }
        } catch (Exception e) {
            System.out.println("get ds thoi gian that bai");
        }
        return khoangCachTram;
    }
    
    /**
     *
     * @param rs
     * @param model
     */
    public String getDSTramDiQuaString(String maTuyen, java.sql.Timestamp tsThoiGianHieuChinh) {

        ArrayList<String> dsTram = getDSTramDiQua(maTuyen, tsThoiGianHieuChinh);
        String temp = "";
        for (String s : dsTram) {
            temp += s + "-";
        }
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }
    public void loadDSTuyenVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                String maTuyen = rs.getString("MaTuyen");
                String tenTuyen = rs.getString("TenTuyen");
                java.sql.Timestamp thoiGianHieuChinh = rs.getTimestamp("ThoiGianHieuChinh");
                ArrayList<String> dsTram = getDSTramDiQua(maTuyen, thoiGianHieuChinh);
                String temp = "";
                for(String s : dsTram){
                    temp += s + "-";
                }
                temp = temp.substring(0, temp.length()-1);
                model.addRow(new Object[]{maTuyen, tenTuyen, thoiGianHieuChinh, temp});
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("load ds tuyen vao bang that bai");
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
            LopKetNoi.update("insert into KhoangCachTram values(?,?,?,?)", khoangCach.getTenTramNay(), khoangCach.getTenTramKia(),khoangCach.getKhoangThoiGian(),khoangCach.getSoNgay());
            //themTuyenDiQuaTram(tuyen);
        } catch (Exception e) {
        }
    }
    public boolean themTuyenVaoDB(Tuyen tuyen, java.sql.Timestamp tsThoiGianHieuChinh) {
        try {
            LopKetNoi.update("insert into tuyen(MaTuyen,TenTuyen,ThoiGianHieuChinh) values(?,?,?)", tuyen.getMaTuyen(), tuyen.getTenTuyen(),tsThoiGianHieuChinh);
        } catch (Exception e) {
            System.out.println("Th??m tuy???n v??o DB th???t b???i!");
            return false;
        }
        return true;
    }
    
    /**
     *
     * @param tuyen
     */
    
    /**
     *
     * @param maTuyen
     * @return
     */
    public boolean xoaTuyenTrongDB(String maTuyen,LopKetNoi ketNoiCSDL, String thoiGianHieuChinhTuyen) {
        try {
            ResultSet rs = LopKetNoi.select("select ID_TCT from TauChayTuyen\n"
                    + "	where MaTuyen=? and ThoiGianHieuChinh=?", maTuyen, thoiGianHieuChinhTuyen);
            if (rs.next()) {//n???u xo?? t??u k ???????c v?? ???? ph??n tuy???n cho t??u
                return false;
            } else {
                ketNoiCSDL.update("delete from TuyenDiQuaTram\n"
                        + "where MaTuyen=? and ThoiGianHieuChinh=?", maTuyen, thoiGianHieuChinhTuyen);
                ketNoiCSDL.update("delete from Tuyen\n"
                        + "where MaTuyen=? and ThoiGianHieuChinh=?", maTuyen, thoiGianHieuChinhTuyen);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Tuy???n ???? ??i qua Tr???m ho???c c?? T??u ??ang ch???y, kh??ng th??? xo??!");
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
         String dsTramDiQuaString = getDSTramDiQuaString(tuyen.getMaTuyen(), tuyen.getThoiGianHieuChinh());  
        model.addRow(new Object[]{tuyen.getMaTuyen(), tuyen.getTenTuyen(),tuyen.getThoiGianHieuChinh(),dsTramDiQuaString});
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
