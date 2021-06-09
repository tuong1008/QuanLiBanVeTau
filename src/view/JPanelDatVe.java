/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.datve.JPanelTimVeTau;
import java.awt.BorderLayout;
import module.TaiKhoan;



/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JPanelDatVe extends javax.swing.JPanel {

    /**
     * Creates new form JPanelDatVe
     */
    TaiKhoan taiKhoan;
    public JPanelDatVe(TaiKhoan taiKhoan) {
        initComponents();        
        this.taiKhoan=taiKhoan;
        if (this.taiKhoan.getMaLoaiTaiKhoan().equals("KH")) jpnThemLoaiVe.setVisible(false);
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnTimVeTau = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnTraCuuThongTin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpnThemLoaiVe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1010, 144));
        setPreferredSize(new java.awt.Dimension(1010, 457));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnTimVeTau.setBackground(new java.awt.Color(255, 255, 255));
        jpnTimVeTau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnTimVeTauMousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_location_searching_white_18dp.png"))); // NOI18N
        jLabel1.setText("Tìm chuyến tàu");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnTimVeTauLayout = new javax.swing.GroupLayout(jpnTimVeTau);
        jpnTimVeTau.setLayout(jpnTimVeTauLayout);
        jpnTimVeTauLayout.setHorizontalGroup(
            jpnTimVeTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTimVeTauLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnTimVeTauLayout.setVerticalGroup(
            jpnTimVeTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        add(jpnTimVeTau, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 29, 219, -1));

        jpnTraCuuThongTin.setBackground(new java.awt.Color(255, 255, 255));
        jpnTraCuuThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnTraCuuThongTinMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_image_search_white_18dp.png"))); // NOI18N
        jLabel2.setText("Tra cứu thông tin vé");

        javax.swing.GroupLayout jpnTraCuuThongTinLayout = new javax.swing.GroupLayout(jpnTraCuuThongTin);
        jpnTraCuuThongTin.setLayout(jpnTraCuuThongTinLayout);
        jpnTraCuuThongTinLayout.setHorizontalGroup(
            jpnTraCuuThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTraCuuThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnTraCuuThongTinLayout.setVerticalGroup(
            jpnTraCuuThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        add(jpnTraCuuThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 29, 207, -1));

        jpnThemLoaiVe.setBackground(new java.awt.Color(255, 255, 255));
        jpnThemLoaiVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnThemLoaiVeMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_note_add_white_18dp.png"))); // NOI18N
        jLabel3.setText("Thêm loại vé");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnThemLoaiVeLayout = new javax.swing.GroupLayout(jpnThemLoaiVe);
        jpnThemLoaiVe.setLayout(jpnThemLoaiVeLayout);
        jpnThemLoaiVeLayout.setHorizontalGroup(
            jpnThemLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThemLoaiVeLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnThemLoaiVeLayout.setVerticalGroup(
            jpnThemLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jpnThemLoaiVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 29, -1, 115));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new JPanelTimVeTau(taiKhoan));
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jpnTimVeTauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTimVeTauMousePressed
        // TODO add your handling code here:
         this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new JPanelTimVeTau(taiKhoan));
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jpnTimVeTauMousePressed

    private void jpnTraCuuThongTinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTraCuuThongTinMousePressed
        // TODO add your handling code here:
         this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new view.datve.JPanelDanhSachVe(taiKhoan));
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jpnTraCuuThongTinMousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new view.datve.JPanelThemLoaiVe(taiKhoan));
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jpnThemLoaiVeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThemLoaiVeMousePressed
        // TODO add your handling code here:
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new view.datve.JPanelThemLoaiVe(taiKhoan));
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jpnThemLoaiVeMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpnThemLoaiVe;
    private javax.swing.JPanel jpnTimVeTau;
    private javax.swing.JPanel jpnTraCuuThongTin;
    // End of variables declaration//GEN-END:variables
}
