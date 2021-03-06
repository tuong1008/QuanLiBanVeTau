/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.source.tree.Tree;
import connectSQL.LopKetNoi;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JPanel;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

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
        ketNoiCSDL = new LopKetNoi();
        napNgayThangNam();
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
        jLabel6 = new javax.swing.JLabel();
        jtfSoTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbLoaiThoiGian = new javax.swing.JComboBox<>();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLocThongKe = new javax.swing.JButton();
        dpNgay = new com.github.lgooddatepicker.components.DatePicker();
        jpnThongKe1 = new javax.swing.JPanel();
        jpnThongKe2 = new javax.swing.JPanel();
        jpnThongKe = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TH???NG K??");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setText("S??? ti???n thu ???????c:");

        jtfSoTien.setText("0");

        jLabel7.setText("??");

        jLabel5.setText("L???c th???ng k??:");

        cbbLoaiThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ng??y", "Th??ng", "N??m" }));
        cbbLoaiThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiThoiGianActionPerformed(evt);
            }
        });

        cbbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbbThang.setEnabled(false);

        cbbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        cbbNam.setEnabled(false);

        jLabel8.setText("Th??ng");

        jLabel9.setText("N??m");

        jLabel10.setText("Ng??y");

        btnLocThongKe.setText("L???C");
        btnLocThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnThongKe1Layout = new javax.swing.GroupLayout(jpnThongKe1);
        jpnThongKe1.setLayout(jpnThongKe1Layout);
        jpnThongKe1Layout.setHorizontalGroup(
            jpnThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnThongKe1Layout.setVerticalGroup(
            jpnThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnThongKe2Layout = new javax.swing.GroupLayout(jpnThongKe2);
        jpnThongKe2.setLayout(jpnThongKe2Layout);
        jpnThongKe2Layout.setHorizontalGroup(
            jpnThongKe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        jpnThongKe2Layout.setVerticalGroup(
            jpnThongKe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jpnThongKe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLocThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(31, 31, 31)
                                .addComponent(cbbLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dpNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(dpNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocThongKe)
                    .addComponent(jLabel6)
                    .addComponent(jtfSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnThongKe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jpnThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocThongKeActionPerformed
        // TODO add your handling code here:
        if (cbbLoaiThoiGian.getSelectedIndex() == 0) {
            thongKeTheoNgay();
        }else if(cbbLoaiThoiGian.getSelectedIndex() == 1){
            thongKeTheoThang();
        }else thongKeTheoNam();
    }//GEN-LAST:event_btnLocThongKeActionPerformed

    private void cbbLoaiThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiThoiGianActionPerformed
        // TODO add your handling code here:
        if (cbbLoaiThoiGian.getSelectedIndex() == 0) {// loc theo ngay
            dpNgay.setEnabled(true);
            cbbThang.setEnabled(false);
            cbbNam.setEnabled(false);
        } else if (cbbLoaiThoiGian.getSelectedIndex() == 1) {// loc theo thang
            dpNgay.setEnabled(false);
            cbbThang.setEnabled(true);
            cbbNam.setEnabled(true);
        } else {// loc theo nam
            dpNgay.setEnabled(false);
            cbbThang.setEnabled(false);
            cbbNam.setEnabled(true);
        }
    }//GEN-LAST:event_cbbLoaiThoiGianActionPerformed

    private void napNgayThangNam() {
        cbbThang.removeAllItems();
        cbbNam.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            cbbThang.addItem(i + "");
        }
        for (int i = 2015; i <= 2030; i++) {
            cbbNam.addItem(i + "");
        }
        int thang = LocalDate.now().getMonthValue();
        int nam = LocalDate.now().getYear();
        cbbThang.setSelectedItem(thang + "");
        cbbNam.setSelectedItem(nam + "");
        dpNgay.setDate(LocalDate.now());

    }

    private void thongKeVeNgay(JPanel jpn) {
        LocalDate ngay = dpNgay.getDate();
        ResultSet rsVe = LopKetNoi.select("select Gia from Ve where cast(thoiGianLenTau as Date)=? and KhuHoi='false'", ngay);
        ResultSet rsVeKhuHoi = LopKetNoi.select("select Ve.Gia,Ve_KhuHoi.Gia from Ve_KhuHoi\n"
                + "join Ve\n"
                + "on Ve.MaVe=Ve_KhuHoi.MaVe_ChieuDi and Ve.ThoiGianLenTau=Ve_KhuHoi.ThoiGianLenTau_ChieuDi\n"
                + "where cast(ThoiGianLenTau as Date)=?", ngay);
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        long tongDoanhThu1Chieu = 0;
        long tongDoanhThuKhuHoi = 0;
        try {
            while (rsVe.next())
            {
                tongDoanhThu1Chieu = tongDoanhThu1Chieu+rsVe.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }
        try {
            while (rsVeKhuHoi.next())
            {
                tongDoanhThuKhuHoi=tongDoanhThuKhuHoi+rsVeKhuHoi.getInt(1)+rsVeKhuHoi.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateSet.addValue(tongDoanhThu1Chieu, "V??", ngay);
        dateSet.addValue(tongDoanhThuKhuHoi, "V?? kh??? h???i", ngay);
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? v??, v?? kh??? h???i theo ng??y", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
        jtfSoTien.setText(tongDoanhThu1Chieu+tongDoanhThuKhuHoi+"");
    }

    private void thongKeLoaiDoiTuongNgay(JPanel jpn) {
        TreeMap<String,Long> treeLoaiVe=new TreeMap<String,Long>();
        LocalDate ngay = dpNgay.getDate();
        ResultSet loaiVe = LopKetNoi.select("select TenLoaiVe from LoaiVe where TenLoaiVe!=N'KH??? H???I'");
        try {
            while (loaiVe.next())
        {
            treeLoaiVe.put(loaiVe.getString(1), Long.valueOf("0"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rsVe = LopKetNoi.select("select LoaiVe.TenLoaiVe,table1.Gia, table1.GiaKhuHoi from LoaiVe \n"
                +"left join (select Ve.TenLoaiVe,Ve.Gia, Ve_KhuHoi.Gia as GiaKhuHoi  from Ve\n"
                + "left join Ve_KhuHoi\n"
                + "on Ve.MaVe=Ve_KhuHoi.MaVe_ChieuDi and Ve.ThoiGianLenTau=Ve_KhuHoi.ThoiGianLenTau_ChieuDi\n"
                + "where cast(thoiGianLenTau as date) = ?) as table1\n"
                + "on LoaiVe.TenLoaiVe=table1.TenLoaiVe\n"
                + "where LoaiVe.TenLoaiVe!=N'KH??? H???I'", ngay);
        try {
            while (rsVe.next())
            {
                treeLoaiVe.replace(rsVe.getString(1), treeLoaiVe.get(rsVe.getString(1))+Long.valueOf(rsVe.getInt(2))+Long.valueOf(rsVe.getInt(3)));
            }
        } catch (Exception e) {
        }
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        Set<String> keySet = treeLoaiVe.keySet();
        for (String key : keySet) {
            dateSet.addValue(treeLoaiVe.get(key), key, ngay);
        }
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? lo???i ?????i t?????ng theo ng??y", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
    }

    private void thongKeTuyenTheoNgay(JPanel jpn) {
        LocalDate ngay = dpNgay.getDate();
        TreeMap<String,Long> treeTuyen=new TreeMap<String,Long>();
        ResultSet rsTuyen=LopKetNoi.select("select distinct MaTuyen from Tuyen");
        try {
            while (rsTuyen.next())
            {
                treeTuyen.put(rsTuyen.getString(1), Long.valueOf(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rsVe = LopKetNoi.select("with temp(matuyen, gia) as (select matuyen, ve.gia from tauChayTuyen, chuyenDi, ve\n"
                + "where tauChayTuyen.ID_TCT = chuyenDi.ID_TCT \n"
                + "and chuyenDi.maChuyen = ve.maChuyen \n"
                + "and cast(thoigianlentau as date) = ?)\n"
                + "select table1.matuyen, temp.gia from (select distinct MaTuyen from Tuyen) as table1 full outer join temp on table1.matuyen = temp.matuyen", ngay);
        ResultSet rsVeKhuHoi = LopKetNoi.select("with temp(matuyen, gia) as (select matuyen, ve_khuhoi.gia from tauChayTuyen, chuyenDi, ve_KhuHoi\n"
                + "where tauChayTuyen.ID_TCT = chuyenDi.ID_TCT\n"
                + "and chuyenDi.maChuyen = ve_KhuHoi.maChuyen_chieuVe\n"
                + "and cast(thoigianlentau_chieuVe as date) = ?)\n"
                + "select table1.matuyen, temp.gia from (select distinct MaTuyen from Tuyen) as table1 full outer join temp on table1.matuyen = temp.matuyen", ngay);
        try {
            while (rsVe.next())
            {
                treeTuyen.replace(rsVe.getString(1), treeTuyen.get(rsVe.getString(1))+Long.valueOf(rsVe.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (rsVeKhuHoi.next())
            {
                treeTuyen.replace(rsVeKhuHoi.getString(1), treeTuyen.get(rsVeKhuHoi.getString(1))+Long.valueOf(rsVeKhuHoi.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        Set<String> keySet=treeTuyen.keySet();
        for (String key:keySet)
        {
            dateSet.addValue(treeTuyen.get(key), key, ngay);
        }
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? tuy???n theo ng??y", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();

    }

    private void thongKeTheoNgay() {
        
        thongKeVeNgay(jpnThongKe);
        thongKeLoaiDoiTuongNgay(jpnThongKe1);
        thongKeTuyenTheoNgay(jpnThongKe2);
    }

    private void thongKeVeThang(JPanel jpn) {
        int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
        int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
        ResultSet rsVe = LopKetNoi.select("select Gia from Ve where month(thoiGianLenTau)=? and year(thoiGianlentau)=? and KhuHoi='false'", thang, nam);
        ResultSet rsVeKhuHoi = LopKetNoi.select("select Ve.Gia,Ve_KhuHoi.Gia from Ve_KhuHoi\n"
                + "join Ve\n"
                + "on Ve.MaVe=Ve_KhuHoi.MaVe_ChieuDi and Ve.ThoiGianLenTau=Ve_KhuHoi.ThoiGianLenTau_ChieuDi\n"
                + "where month(thoiGianLenTau)=? and year(thoiGianlentau)=?", thang, nam);
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        String thoiGian = thang + "/" + nam;
        long tongDoanhThu1Chieu = 0;
        long tongDoanhThuKhuHoi = 0;
        try {
            while (rsVe.next())
            {
                tongDoanhThu1Chieu = tongDoanhThu1Chieu+rsVe.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }
        try {
            while (rsVeKhuHoi.next())
            {
                tongDoanhThuKhuHoi=tongDoanhThuKhuHoi+rsVeKhuHoi.getInt(1)+rsVeKhuHoi.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateSet.addValue(tongDoanhThu1Chieu, "V??", thoiGian);
        dateSet.addValue(tongDoanhThuKhuHoi, "V?? kh??? h???i", thoiGian);
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? v??, v?? kh??? h???i theo th??ng", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
        jtfSoTien.setText(tongDoanhThu1Chieu+tongDoanhThuKhuHoi + "");
    }

    private void thongKeLoaiDoiTuongThang(JPanel jpn) {
        int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
        int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
        String thoiGian = thang + "/" + nam;
        
        TreeMap<String,Long> treeLoaiVe=new TreeMap<String,Long>();
        ResultSet loaiVe = LopKetNoi.select("select TenLoaiVe from LoaiVe where TenLoaiVe!=N'KH??? H???I'");
        try {
            while (loaiVe.next())
        {
            treeLoaiVe.put(loaiVe.getString(1), Long.valueOf("0"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rsVe = LopKetNoi.select("select LoaiVe.TenLoaiVe,table1.Gia, table1.GiaKhuHoi from LoaiVe \n"
                +"left join (select Ve.TenLoaiVe,Ve.Gia, Ve_KhuHoi.Gia as GiaKhuHoi  from Ve\n"
                + "left join Ve_KhuHoi\n"
                + "on Ve.MaVe=Ve_KhuHoi.MaVe_ChieuDi and Ve.ThoiGianLenTau=Ve_KhuHoi.ThoiGianLenTau_ChieuDi\n"
                + "where month(thoiGianLenTau)=? and year(thoiGianlentau)=?) as table1\n"
                + "on LoaiVe.TenLoaiVe=table1.TenLoaiVe\n"
                + "where LoaiVe.TenLoaiVe!=N'KH??? H???I'", thang, nam);
        try {
            while (rsVe.next())
            {
                treeLoaiVe.replace(rsVe.getString(1), treeLoaiVe.get(rsVe.getString(1))+Long.valueOf(rsVe.getInt(2))+Long.valueOf(rsVe.getInt(3)));
            }
        } catch (Exception e) {
        }
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        Set<String> keySet = treeLoaiVe.keySet();
        for (String key : keySet) {
            dateSet.addValue(treeLoaiVe.get(key), key, thoiGian);
        }
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? lo???i ?????i t?????ng theo th??ng", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
    }

    private void thongKeTuyenTheoThang(JPanel jpn) {
        int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
        int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
        String thoiGian = thang + "/" + nam;
        TreeMap<String,Long> treeTuyen=new TreeMap<String,Long>();
        ResultSet rsTuyen=LopKetNoi.select("select distinct MaTuyen from Tuyen");
        try {
            while (rsTuyen.next())
            {
                treeTuyen.put(rsTuyen.getString(1), Long.valueOf(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rsVeKhuHoi = LopKetNoi.select("with temp(matuyen, gia) as (select matuyen, ve_khuhoi.gia from tauChayTuyen, chuyenDi, ve_KhuHoi\n"
                + "where tauChayTuyen.ID_TCT = chuyenDi.ID_TCT\n"
                + "and chuyenDi.maChuyen = ve_KhuHoi.maChuyen_chieuVe\n"
                + "and month(thoiGianLenTau_chieuVe)=? and year(thoiGianlentau_chieuVe)=?)\n"
                + "select table1.matuyen, temp.gia from (select distinct MaTuyen from Tuyen) as table1 full outer join temp on table1.matuyen = temp.matuyen", thang, nam);
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        ResultSet rsVe = LopKetNoi.select("with temp(matuyen, gia) as (select matuyen, ve.gia from tauChayTuyen, chuyenDi, ve\n"
                + "where tauChayTuyen.ID_TCT = chuyenDi.ID_TCT\n"
                + "and chuyenDi.maChuyen = ve.maChuyen\n"
                + "and month(thoiGianLenTau)=? and year(thoiGianlentau)=?)\n"
                + "select table1.matuyen, temp.gia from (select distinct MaTuyen from Tuyen) as table1 full outer join temp on table1.matuyen = temp.matuyen", thang, nam);
        try {
            while (rsVe.next())
            {
                treeTuyen.replace(rsVe.getString(1), treeTuyen.get(rsVe.getString(1))+Long.valueOf(rsVe.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (rsVeKhuHoi.next())
            {
                treeTuyen.replace(rsVeKhuHoi.getString(1), treeTuyen.get(rsVeKhuHoi.getString(1))+Long.valueOf(rsVeKhuHoi.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<String> keySet=treeTuyen.keySet();
        for (String key:keySet)
        {
            dateSet.addValue(treeTuyen.get(key), key, thoiGian);
        }
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? tuy???n theo th??ng", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();

    }

    private void thongKeTheoThang() {
        thongKeVeThang(jpnThongKe);
        thongKeLoaiDoiTuongThang(jpnThongKe1);
        thongKeTuyenTheoThang(jpnThongKe2);
    }
    
     private void thongKeVeNam(JPanel jpn) {
        int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
        ResultSet rsVe = LopKetNoi.select("select Gia from Ve where  year(thoiGianlentau)=? and KhuHoi='false'",  nam);
        ResultSet rsVeKhuHoi = LopKetNoi.select("select Ve.Gia,Ve_KhuHoi.Gia from Ve_KhuHoi\n"
                + "join Ve\n"
                + "on Ve.MaVe=Ve_KhuHoi.MaVe_ChieuDi and Ve.ThoiGianLenTau=Ve_KhuHoi.ThoiGianLenTau_ChieuDi\n"
                + "where year(thoiGianlentau)=?", nam);
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        String thoiGian = "N??m" + nam;
        long tongDoanhThu1Chieu = 0;
        long tongDoanhThuKhuHoi = 0;
        try {
            while (rsVe.next())
            {
                tongDoanhThu1Chieu = tongDoanhThu1Chieu+rsVe.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();            
        }
        try {
            while (rsVeKhuHoi.next())
            {
                tongDoanhThuKhuHoi=tongDoanhThuKhuHoi+rsVeKhuHoi.getInt(1)+rsVeKhuHoi.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateSet.addValue(tongDoanhThu1Chieu, "V??", thoiGian);
        dateSet.addValue(tongDoanhThuKhuHoi, "V?? kh??? h???i", thoiGian);
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? v??, v?? kh??? h???i theo n??m", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
        jtfSoTien.setText(tongDoanhThu1Chieu+tongDoanhThuKhuHoi+"");
    }

    private void thongKeLoaiDoiTuongNam(JPanel jpn) {
        int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
        String thoiGian =   "N??m" + nam;
        
        
        TreeMap<String,Long> treeLoaiVe=new TreeMap<String,Long>();
        ResultSet loaiVe = LopKetNoi.select("select TenLoaiVe from LoaiVe where TenLoaiVe!=N'KH??? H???I'");
        try {
            while (loaiVe.next())
        {
            treeLoaiVe.put(loaiVe.getString(1), Long.valueOf("0"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rsVe = LopKetNoi.select("select LoaiVe.TenLoaiVe,table1.Gia, table1.GiaKhuHoi from LoaiVe \n"
                +"left join (select Ve.TenLoaiVe,Ve.Gia, Ve_KhuHoi.Gia as GiaKhuHoi  from Ve\n"
                + "left join Ve_KhuHoi\n"
                + "on Ve.MaVe=Ve_KhuHoi.MaVe_ChieuDi and Ve.ThoiGianLenTau=Ve_KhuHoi.ThoiGianLenTau_ChieuDi\n"
                + "where year(thoiGianlentau)=?) as table1\n"
                + "on LoaiVe.TenLoaiVe=table1.TenLoaiVe\n"
                + "where LoaiVe.TenLoaiVe!=N'KH??? H???I'", nam);
        try {
            while (rsVe.next())
            {
                treeLoaiVe.replace(rsVe.getString(1), treeLoaiVe.get(rsVe.getString(1))+Long.valueOf(rsVe.getInt(2))+Long.valueOf(rsVe.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        Set<String> keySet = treeLoaiVe.keySet();
        for (String key : keySet) {
            dateSet.addValue(treeLoaiVe.get(key), key, thoiGian);
        }
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? lo???i ?????i t?????ng theo n??m", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
    }

    private void thongKeTuyenTheoNam(JPanel jpn) {
        int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
        String thoiGian = "N??m" + nam;
        TreeMap<String,Long> treeTuyen=new TreeMap<String,Long>();
        ResultSet rsTuyen=LopKetNoi.select("select distinct MaTuyen from Tuyen");
        try {
            while (rsTuyen.next())
            {
                treeTuyen.put(rsTuyen.getString(1), Long.valueOf(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rsVe = LopKetNoi.select("with temp(matuyen, gia) as (select matuyen, ve.gia from tauChayTuyen, chuyenDi, ve\n"
                + "where tauChayTuyen.ID_TCT = chuyenDi.ID_TCT\n"
                + "and chuyenDi.maChuyen = ve.maChuyen\n"
                + "and year(thoiGianlentau)=?)\n"
                + "select table1.matuyen, temp.gia from (select distinct MaTuyen from Tuyen) as table1 full outer join temp on table1.matuyen = temp.matuyen",nam);
        ResultSet rsVeKhuHoi = LopKetNoi.select("with temp(matuyen, gia) as (select matuyen, ve_khuhoi.gia from tauChayTuyen, chuyenDi, ve_KhuHoi\n"
                + "where tauChayTuyen.ID_TCT = chuyenDi.ID_TCT\n"
                + "and chuyenDi.maChuyen = ve_KhuHoi.maChuyen_chieuVe\n"
                + "and year(thoiGianlentau_chieuVe)=?)\n"
                + "select table1.matuyen, temp.gia from (select distinct MaTuyen from Tuyen) as table1 full outer join temp on table1.matuyen = temp.matuyen", nam);
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset();
        try {
            while (rsVe.next())
            {
                treeTuyen.replace(rsVe.getString(1), treeTuyen.get(rsVe.getString(1))+Long.valueOf(rsVe.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (rsVeKhuHoi.next())
            {
                treeTuyen.replace(rsVeKhuHoi.getString(1), treeTuyen.get(rsVeKhuHoi.getString(1))+Long.valueOf(rsVeKhuHoi.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<String> keySet=treeTuyen.keySet();
        for (String key:keySet)
        {
            dateSet.addValue(treeTuyen.get(key), key, thoiGian);
        }
        JFreeChart chart = ChartFactory.createBarChart("Th???ng k?? tuy???n theo n??m", "Th???i gian", "Doanh thu(vnd)", dateSet, PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();

    }

    private void thongKeTheoNam() {
        thongKeVeNam(jpnThongKe);
        thongKeLoaiDoiTuongNam(jpnThongKe1);
        thongKeTuyenTheoNam(jpnThongKe2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocThongKe;
    private javax.swing.JComboBox<String> cbbLoaiThoiGian;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbThang;
    private com.github.lgooddatepicker.components.DatePicker dpNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnThongKe1;
    private javax.swing.JPanel jpnThongKe2;
    private javax.swing.JTextField jtfSoTien;
    // End of variables declaration//GEN-END:variables
}
