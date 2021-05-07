/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledao;

import connectSQL.LopKetNoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import module.Tram;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TramDao {

    public void loadDSTramVaoBang(ResultSet rs, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(TramDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void themTramVaoDB(Tram tram) {
        try {
            LopKetNoi.update("insert into Tram values(?,?)", tram.getTenTram(), tram.getDiaChi());
        } catch (Exception e) {
        }
    }

    public void suaTramTrongDB(Tram tram, LopKetNoi ketNoiCSDL) {
        try {
            ketNoiCSDL.update("update tram set diaChi = ?  where tenTram = ?", tram.getDiaChi(), tram.getTenTram());
        } catch (Exception e) {
        }
    }

    public boolean xoaTramTrongDB(String tenTram, LopKetNoi ketNoiCSDL) {
        try {
            ResultSet rs = ketNoiCSDL.select("select * from tuyendiquatram where  tenTram = ?", tenTram);
            if (rs.next()) {
                return false;
            } else {
                ResultSet rs2 = ketNoiCSDL.select("select * from KhoangCachTram where  tenTramNay = ? or tenTramKia=?", tenTram, tenTram);
                if (rs2.next()) {
                    return false;
                } else {
                    LopKetNoi.update("delete from tram where tenTram = ?", tenTram);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void themTramVaoBang(Tram tram, JTable jtb) {
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.addRow(new Object[]{tram.getTenTram(), tram.getDiaChi()});
        int hangCuoi = jtb.getRowCount();
        jtb.scrollRectToVisible(jtb.getCellRect(hangCuoi - 1, 0, true));
        jtb.clearSelection();
        jtb.setRowSelectionInterval(hangCuoi - 1, hangCuoi - 1);
    }

    public void suaTramTrongBang(Tram tram, int hang, JTable jtb) {
        jtb.setValueAt(tram.getTenTram(), hang, 0);
        jtb.setValueAt(tram.getDiaChi(), hang, 1);
    }

    public void xoaTramKhoiBang(int hang, DefaultTableModel model) {
        model.removeRow(hang);
    }

    
}
