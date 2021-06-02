/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.datve;

import connectSQL.LopKetNoi;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuong
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    JTable bangThongKeVe;
    String maTau;
    String maToa;
    String thoiGianDi;
    String thoiGianDen;
    Object giaThatSu;
    DefaultTableModel model;
    SimpleDateFormat formatter;
    ArrayList<JToggleButton> listButton;
    ArrayList<Integer> DSGheDaDat;
    JRadioButton jRadio1Chieu;
    String chieuDi;
    LopKetNoi ketNoiCSDL;
    public NewJPanel(String maTau,String maToa,String thoiGianDi,String thoiGianDen,DefaultTableModel model, JRadioButton jRadio1Chieu,String chieuDi,ArrayList<Integer> DSGheDaDat,int donGia) {
        initComponents();
        formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.model=model;
        this.maTau=maTau;
        this.maToa=maToa;
        this.thoiGianDi=thoiGianDi;
        this.thoiGianDen=thoiGianDen;
        try {
            Date tempNgayDi=formatter.parse(thoiGianDi);
            Date tempNgayVe=formatter.parse(thoiGianDen);
            float dentaHour=(tempNgayVe.getTime()-tempNgayDi.getTime())/(float)3600000;
            NumberFormat myFormat = NumberFormat.getInstance();
            myFormat.setGroupingUsed(true);
            giaThatSu=myFormat.format(donGia*dentaHour);
        } catch (Exception e) {
        }
        this.jRadio1Chieu=jRadio1Chieu;
        this.DSGheDaDat=DSGheDaDat;
        this.chieuDi=chieuDi;
    }
    public void enableJToggleButton(JToggleButton jtb)
    {
        jtb.setEnabled(true);
        jtb.setSelected(false);
    }
    public void disableJToggleButton()
    {
        for (int i : DSGheDaDat)
        {
            listButton.get(i-1).setEnabled(false);
        }
    }
    public JToggleButton getJToggleButtonByText(String textOfButton)
    {
        int indexOfJToggleButton=Integer.valueOf(textOfButton)-1;
        return listButton.get(indexOfJToggleButton);
    }
    public void jToggleButtoniActionPerformed(JToggleButton i)
    {
        if (jRadio1Chieu.isSelected())
        {
            model.addRow(new Object[] {maTau,maToa,i.getText(),giaThatSu,thoiGianDi,thoiGianDen});
            i.setEnabled(false);
        }
        else
        {
            model.addRow(new Object[] {chieuDi,maTau,maToa,i.getText(),giaThatSu,thoiGianDi,thoiGianDen});
            i.setEnabled(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}