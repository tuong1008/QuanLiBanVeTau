/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.datve;

import connectSQL.LopKetNoi;
import controller.ChuyenManHinhView;
import javax.swing.table.DefaultTableModel;
import view.JPanelDatVe;
import java.sql.ResultSet;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import module.TaiKhoan;
import javax.swing.JFrame;

/**
 *
 * @author Tuong
 */

public class JPanelThemLoaiVe extends javax.swing.JPanel {

    LopKetNoi ketNoiCSDL;
    DefaultTableModel jtbLoaiVeModel;
    int hangDangChon;
    TaiKhoan taiKhoan;
    TableRowSorter<DefaultTableModel> trsLoaiVe;
    /**
     * Creates new form JPanelThemLoaiVe
     */
    public JPanelThemLoaiVe(TaiKhoan taiKhoan) {
        initComponents();
        this.taiKhoan=taiKhoan;
        ketNoiCSDL=new LopKetNoi();
        jtbLoaiVeModel=(DefaultTableModel) jtbLoaiVe.getModel();
        loadLoaiVeVaoBang(LopKetNoi.select("select * from LoaiVe"));
        trsLoaiVe =new TableRowSorter<>(jtbLoaiVeModel);
        trsLoaiVe.setComparator(0, new Comparator<String>
        () {
            @Override
            public int compare(String o1, String o2) {
                Collator collator = Collator.getInstance( new Locale("vi","VN"));
                return collator.compare(o1,o2);
            }
        });
        jtbLoaiVe.setRowSorter(trsLoaiVe);
    }
    private void loadLoaiVeVaoBang(ResultSet rs)
    {
        jtbLoaiVeModel.setRowCount(0);
        try {
            while (rs.next())
            {
                jtbLoaiVeModel.addRow(new Object[] {rs.getString(1), rs.getFloat(2)});
            }
        } catch (Exception e) {
            System.out.println("Load DS Loại vé vào bảng bị lỗi");
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

        jdlLoaiVe = new javax.swing.JDialog((JFrame) null,true);
        jPanel5 = new javax.swing.JPanel();
        jlbTenDialogLoaiVe = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnXacNhanLoaiVe = new javax.swing.JButton();
        jtfTenLoaiVe = new javax.swing.JTextField();
        jlbTenLoaiVe = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfHeSo = new javax.swing.JTextField();
        jlbHeSo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLoaiVe = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jdlLoaiVe.setMinimumSize(new java.awt.Dimension(555, 282));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jlbTenDialogLoaiVe.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jlbTenDialogLoaiVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTenDialogLoaiVe.setText("THÊM LOẠI VÉ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("TÊN LOẠI VÉ");

        btnXacNhanLoaiVe.setBackground(new java.awt.Color(255, 255, 255));
        btnXacNhanLoaiVe.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnXacNhanLoaiVe.setText("XÁC NHẬN");
        btnXacNhanLoaiVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanLoaiVeActionPerformed(evt);
            }
        });

        jtfTenLoaiVe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlbTenLoaiVe.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jlbTenLoaiVe.setForeground(new java.awt.Color(255, 0, 0));
        jlbTenLoaiVe.setText("a");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("HỆ SỐ");
        jLabel12.setToolTipText("Ví dụ muốn giảm 40% trên giá vé thì nhập 0.6");

        jtfHeSo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlbHeSo.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jlbHeSo.setForeground(new java.awt.Color(255, 0, 0));
        jlbHeSo.setText("a");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTenDialogLoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfTenLoaiVe)
                    .addComponent(jtfHeSo)
                    .addComponent(jlbTenLoaiVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbHeSo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(btnXacNhanLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jlbTenDialogLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jtfTenLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTenLoaiVe)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbHeSo)
                .addGap(44, 44, 44)
                .addComponent(btnXacNhanLoaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdlLoaiVeLayout = new javax.swing.GroupLayout(jdlLoaiVe.getContentPane());
        jdlLoaiVe.getContentPane().setLayout(jdlLoaiVeLayout);
        jdlLoaiVeLayout.setHorizontalGroup(
            jdlLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdlLoaiVeLayout.setVerticalGroup(
            jdlLoaiVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlLoaiVeLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOẠI VÉ");

        jtbLoaiVe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtbLoaiVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÊN LOẠI VÉ", " HỆ SỐ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbLoaiVe.setGridColor(new java.awt.Color(255, 255, 255));
        jtbLoaiVe.setRowHeight(25);
        jtbLoaiVe.setSelectionBackground(new java.awt.Color(51, 204, 255));
        jtbLoaiVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbLoaiVeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbLoaiVeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbLoaiVe);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Chức năng");

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tìm kiếm:");

        jtfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_arrow_back_black_24dp_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(350, 350, 350)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(59, 59, 59)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(224, 224, 224)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbLoaiVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbLoaiVeMouseClicked
        // TODO add your handling code here:
        hangDangChon = jtbLoaiVe.getSelectedRow();
    }//GEN-LAST:event_jtbLoaiVeMouseClicked
    private void hienThiDialogLoaiVe(String loai) {
        
        if (loai.equals("THÊM"))
        {
            jtfTenLoaiVe.setEditable(true);
            jlbTenLoaiVe.setText("");
            jtfHeSo.setEditable(true);
            jlbHeSo.setText("");
        }
        else
        {
            if (loai.equals("SỬA")) {
            jtfTenLoaiVe.setEditable(false);
            jtfTenLoaiVe.setText(jtbLoaiVe.getValueAt(hangDangChon, 0).toString());
            jlbTenLoaiVe.setText("");
            jtfHeSo.setEditable(true);
            jtfHeSo.setText(jtbLoaiVe.getValueAt(hangDangChon, 1).toString());
            jlbHeSo.setText("");
        }
        }
        jlbTenDialogLoaiVe.setText(loai);
        jdlLoaiVe.setLocationRelativeTo(this);
        jdlLoaiVe.setVisible(true);
    }
    private void jtbLoaiVeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbLoaiVeMousePressed
        // TODO add your handling code here:
        hangDangChon = jtbLoaiVe.getSelectedRow();
    }//GEN-LAST:event_jtbLoaiVeMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        hienThiDialogLoaiVe("THÊM");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        hangDangChon=jtbLoaiVe.getSelectedRow();
        if (hangDangChon < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng! Vui lòng chọn 1 dòng trong bảng");
        } else {
            try {
                ResultSet rs= ketNoiCSDL.select("select * from Ve where TenLoaiVe=?", jtbLoaiVe.getValueAt(hangDangChon, 0));
                if (rs.next())
                {
                    JOptionPane.showMessageDialog(this, "Không thể sửa vì có Vé đang thuộc Loại vé này");
                }
                else
                {
                    hienThiDialogLoaiVe("SỬA");
                }
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private boolean xoaLoaiVeTrongDB(String tenLoaiVe)
    {
        return ketNoiCSDL.update("delete from LoaiVe where TenLoaiVe=?", tenLoaiVe);
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (hangDangChon < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng! Vui lòng chọn 1 hàng trong bảng");

        } else {
            int input = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                String tenLoaiVe = jtbLoaiVe.getValueAt(hangDangChon, 0).toString();
                boolean kt = xoaLoaiVeTrongDB(tenLoaiVe);
                if (kt) {
                    jtbLoaiVeModel.removeRow(hangDangChon);
                    hangDangChon = -1;
                    jtbLoaiVe.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa vì có Vé đang thuộc Loại vé này");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jtfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyReleased
        // TODO add your handling code here:
                trsLoaiVe.setRowFilter(RowFilter.regexFilter(jtfTimKiem.getText().toUpperCase().trim()));
    }//GEN-LAST:event_jtfTimKiemKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ChuyenManHinhView(this, new JPanelDatVe(taiKhoan)).change();
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean themLoaiVe()
    {
        String tenLoaiVe=jtfTenLoaiVe.getText().toUpperCase();
        if (tenLoaiVe.length()==0)
        {
            jlbTenLoaiVe.setText("Không được để trống!");
        }
        else
        {
            try {
            float heSo=Float.valueOf(jtfHeSo.getText());
            return ketNoiCSDL.update("insert into LoaiVe values(?,?)",tenLoaiVe,heSo);
            } catch (Exception e) {
                jlbHeSo.setText("Hãy nhập số và không được để trống!");
            }

        }
        return false;
    }
    private boolean suaLoaiVe()
    {
        return ketNoiCSDL.update("update LoaiVe set HeSo = ? where TenLoaiVe=? ",jtfHeSo.getText(),jtfTenLoaiVe.getText());
    }
    private void btnXacNhanLoaiVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanLoaiVeActionPerformed
        // TODO add your handling code here:
        String loai = jlbTenDialogLoaiVe.getText();
        if (loai.equals("THÊM")) {
            if (themLoaiVe()) {
                JOptionPane.showMessageDialog(jdlLoaiVe, "Thêm thành công");
                jtbLoaiVeModel.addRow(new Object[] {jtfTenLoaiVe.getText().toUpperCase().trim(),jtfHeSo.getText()});
                jtfTenLoaiVe.setText("");
                jlbTenLoaiVe.setText(" ");
                jtfHeSo.setText("");
                jlbHeSo.setText(" ");
                jdlLoaiVe.dispose();
                hangDangChon = jtbLoaiVe.getRowCount() - 1;
                jtbLoaiVe.setRowSelectionInterval(hangDangChon, hangDangChon);
                jdlLoaiVe.dispose();
            } else {
                JOptionPane.showMessageDialog(jdlLoaiVe, "Thêm thất bại");
            }
        } else if (loai.equals("SỬA")) {
            if (suaLoaiVe()) {
                JOptionPane.showMessageDialog(jdlLoaiVe, "Sửa thành công");
                jtbLoaiVe.setValueAt(jtfHeSo.getText(), hangDangChon, 1);
                jdlLoaiVe.dispose();
            } else {
                JOptionPane.showMessageDialog(jdlLoaiVe, "Sửa thất bại");
            }

        }
    }//GEN-LAST:event_btnXacNhanLoaiVeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhanLoaiVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JDialog jdlLoaiVe;
    private javax.swing.JLabel jlbHeSo;
    private javax.swing.JLabel jlbTenDialogLoaiVe;
    private javax.swing.JLabel jlbTenLoaiVe;
    private javax.swing.JTable jtbLoaiVe;
    private javax.swing.JTextField jtfHeSo;
    private javax.swing.JTextField jtfTenLoaiVe;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
