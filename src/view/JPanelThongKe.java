/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connectSQL.LopKetNoi;
import java.sql.ResultSet;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JPanelThongKe extends javax.swing.JPanel {

    /**
     * Creates new form JPanelThongKe
     */
    private LopKetNoi ketNoiCSDL;
    public JPanelThongKe() {
        initComponents();
        ketNoiCSDL=new LopKetNoi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNgay = new javax.swing.JTextField();
        jtfNam = new javax.swing.JTextField();
        jtfThang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfSoTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnLoc = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("THỐNG KÊ");

        jtfNgay.setText("dd");

        jtfNam.setText("yyyy");

        jtfThang.setText("MM");

        jLabel2.setText("/");

        jLabel3.setText("/");

        jLabel4.setText("Nhập ngày tháng năm:");

        jLabel6.setText("Số tiền thu được:");

        jtfSoTien.setText("0");

        jLabel7.setText("đ");

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jtfNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfThang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfNam, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(81, 81, 81)
                        .addComponent(jtfSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnLoc)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnLoc))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        ResultSet rs;
        String ngay=jtfNgay.getText().toString();
        String thang=jtfThang.getText().toString();
        String nam=jtfNam.getText().toString();
        int tongTienChieuDi=0;
        int tongTienChieuVe=0;
        if (!ngay.equals("")&&!thang.equals("")&&!nam.equals(""))
        {
                    try {
                        rs=ketNoiCSDL.select("select SUM(Gia) from Ve where DAY(ThoiGianDen)=? and MONTH(ThoiGianDen)=? and YEAR(ThoiGianDen)=?",ngay, thang, nam);
                    if (rs.next())
                    {
                        tongTienChieuDi=rs.getInt(1);
                    }
                    rs=ketNoiCSDL.select("select SUM(Gia) from Ve_KhuHoi where DAY(ThoiGianDen_ChieuVe)=? and MONTH(ThoiGianDen_ChieuVe)=? and YEAR(ThoiGianDen_ChieuVe)=?",ngay, thang, nam);
                    if (rs.next())
                    {
                        tongTienChieuVe=rs.getInt(1);
                    }
                    jtfSoTien.setText(String.valueOf(tongTienChieuDi+tongTienChieuVe));
                    } catch (Exception e) {
                        System.out.println("lỗi lấy tiền theo ngay tháng năm");
                    }
        }
        else
        {
            if (ngay.equals("")&&!thang.equals("")&&!nam.equals(""))
            {
                try {
                        rs=ketNoiCSDL.select("select SUM(Gia) from Ve where MONTH(ThoiGianDen)=? and YEAR(ThoiGianDen)=?", thang, nam);
                    if (rs.next())
                    {
                        tongTienChieuDi=rs.getInt(1);
                    }
                    rs=ketNoiCSDL.select("select SUM(Gia) from Ve_KhuHoi where MONTH(ThoiGianDen_ChieuVe)=? and YEAR(ThoiGianDen_ChieuVe)=?", thang, nam);
                    if (rs.next())
                    {
                        tongTienChieuVe=rs.getInt(1);
                    }
                    jtfSoTien.setText(String.valueOf(tongTienChieuDi+tongTienChieuVe));
                    } catch (Exception e) {
                        System.out.println("lỗi lấy tiền theo tháng năm");
                    }
            }
            else
            {
                if (ngay.equals("")&&thang.equals("")&&!nam.equals(""))
                {
                    try {
                        rs=ketNoiCSDL.select("select SUM(Gia) from Ve where YEAR(ThoiGianDen)=?", nam);
                    if (rs.next())
                    {
                        tongTienChieuDi=rs.getInt(1);
                    }
                    rs=ketNoiCSDL.select("select SUM(Gia) from Ve_KhuHoi where YEAR(ThoiGianDen_ChieuVe)=?", nam);
                    if (rs.next())
                    {
                        tongTienChieuVe=rs.getInt(1);
                    }
                    jtfSoTien.setText(String.valueOf(tongTienChieuDi+tongTienChieuVe));
                    } catch (Exception e) {
                        System.out.println("lỗi lấy tiền theo tháng năm");
                    }
                }
            }
        }
        
    }//GEN-LAST:event_btnLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfNam;
    private javax.swing.JTextField jtfNgay;
    private javax.swing.JTextField jtfSoTien;
    private javax.swing.JTextField jtfThang;
    // End of variables declaration//GEN-END:variables
}
