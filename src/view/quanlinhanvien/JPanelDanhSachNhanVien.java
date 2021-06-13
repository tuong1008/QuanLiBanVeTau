/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.quanlinhanvien;

import connectSQL.LopKetNoi;
import controller.ChuyenManHinhView;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import module.CheckInPut;
import view.JPanelQuanLiNhanVien;

/**
 *
 * @author admin
 */
public class JPanelDanhSachNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form JPanelDanhSachNhanVien
     */
    private int demMatKhau = 0;
    private int hangDangChon = -1;
    private DefaultTableModel tbmNhanVien;
    private TableRowSorter<DefaultTableModel> trsNhanVien;

    public JPanelDanhSachNhanVien() {
        initComponents();
        tbmNhanVien = (DefaultTableModel) jtbNhanVien.getModel();
        tatCacTruong();
        napDanhSachNhanVien();
        trsNhanVien = new TableRowSorter<>(tbmNhanVien);
        trsNhanVien.setComparator(0, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Collator collator = Collator.getInstance(new Locale("vi", "VN"));
                return collator.compare(o1, o2);
            }
        });
        trsNhanVien.setComparator(1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Collator collator = Collator.getInstance(new Locale("vi", "VN"));
                return collator.compare(o1, o2);
            }
        });
        jtbNhanVien.setRowSorter(trsNhanVien);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNhanVien = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jtfCMND = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfTaiKhoan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jpassword = new javax.swing.JPasswordField();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH TUYẾN NHÂN VIÊN");

        jtbNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CMND", "HỌ TÊN", "SDT", "EMAIL", "TÀI KHOẢN", "MẬT KHẨU"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbNhanVien.setGridColor(new java.awt.Color(255, 255, 255));
        jtbNhanVien.setRowHeight(25);
        jtbNhanVien.setSelectionBackground(new java.awt.Color(51, 204, 255));
        jtbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNhanVien);

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

        jLabel2.setText("CMND:");

        jtfCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCMNDKeyReleased(evt);
            }
        });

        jLabel3.setText("HỌ TÊN:");

        jLabel4.setText("SDT:");

        jLabel6.setText("EMAIL:");

        jLabel7.setText("TÀI KHOẢN:");

        jtfTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTaiKhoanKeyReleased(evt);
            }
        });

        jLabel9.setText("MẬT KHẨU:");

        jpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.setEnabled(false);
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setText("HỦY");
        btnHuy.setEnabled(false);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(514, 514, 514)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfHoTen)
                            .addComponent(jtfCMND, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(179, 179, 179)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSDT)
                                    .addComponent(jtfEmail)
                                    .addComponent(jpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnXoa)
                                .addGap(106, 106, 106)
                                .addComponent(btnXacNhan)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(72, 72, 72)
                        .addComponent(btnThem)
                        .addGap(31, 31, 31)
                        .addComponent(btnSua)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jButton1))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(jLabel5)
                    .addComponent(btnHuy)
                    .addComponent(btnXacNhan))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_visibility_black_24dp.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(835, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(85, 85, 85))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel10)
                .addContainerGap(476, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tatCacTruong() {
        jtfCMND.setEditable(false);
        jtfHoTen.setEditable(false);
        jtfSDT.setEditable(false);
        jtfEmail.setEditable(false);
        jtfTaiKhoan.setEditable(false);
        jpassword.setEditable(false);
        btnXacNhan.setEnabled(false);
        btnHuy.setEnabled(false);
    }

    private void batCacTruong() {
        jtfCMND.setEditable(true);
        jtfHoTen.setEditable(true);
        jtfSDT.setEditable(true);
        jtfEmail.setEditable(true);
        jtfTaiKhoan.setEditable(true);
        jpassword.setEditable(true);
        btnXacNhan.setEnabled(true);
        btnHuy.setEnabled(true);
    }

    private void setRongCacTruong() {
        jtfCMND.setText("");
        jtfHoTen.setText("");
        jtfSDT.setText("");
        jtfEmail.setText("");
        jtfTaiKhoan.setText("");
        jpassword.setText("");
    }

    private void napDanhSachNhanVien() {
        ResultSet rs = LopKetNoi.select("select * from NguoiDung full outer join taikhoan on nguoidung.cmnd = taikhoan.cmnd where taikhoan.maloaitaikhoan=N'NV'");
        try {
            while (rs.next()) {
                String cmnd = rs.getString("cmnd");
                String hoTen = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                String tk = rs.getString("tentaikhoan");
                String mk = rs.getString("matkhau");
                tbmNhanVien.addRow(new Object[]{cmnd, hoTen, sdt, email, tk, mk});
            }
        } catch (Exception e) {
            System.out.println("nap ds nhan vien that bai");
        }

    }
    private void jtbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNhanVienMouseClicked
        // TODO add your handling code here:
        hangDangChon = jtbNhanVien.getSelectedRow();
        String cmnd = jtbNhanVien.getValueAt(hangDangChon, 0) + "";
        String hoTen = jtbNhanVien.getValueAt(hangDangChon, 1) + "";
        String sdt = jtbNhanVien.getValueAt(hangDangChon, 2) + "";
        String email = jtbNhanVien.getValueAt(hangDangChon, 3) + "";
        String tk = jtbNhanVien.getValueAt(hangDangChon, 4) + "";
        String mk = jtbNhanVien.getValueAt(hangDangChon, 5) + "";

        jtfCMND.setText(cmnd);
        jtfHoTen.setText(hoTen);
        jtfSDT.setText(sdt);
        jtfEmail.setText(email);
        jtfTaiKhoan.setText(tk);
        jpassword.setText(mk);
    }//GEN-LAST:event_jtbNhanVienMouseClicked

    private boolean kiemTraTruongRong() {
        String cmnd = jtfCMND.getText().trim();
        String hoTen = jtfHoTen.getText().trim();
        String sdt = jtfSDT.getText().trim();
        String email = jtfEmail.getText().trim();
        String tk = jtfTaiKhoan.getText().trim();
        String mk = jpassword.getText().trim();
        if (cmnd.equals("")) {
            JOptionPane.showMessageDialog(this, "CMND không được để trống");
            jtfCMND.requestFocus();
            return false;
        }
        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
            jtfHoTen.requestFocus();
            return false;
        }
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "SDT không được để trống");
            jtfSDT.requestFocus();
            return false;
        }
        if (tk.equals("")) {
            JOptionPane.showMessageDialog(this, "Tài khoản không được để trống");
            jtfTaiKhoan.requestFocus();
            return false;
        }
        return true;
    }

    private boolean kiemTraThongTinNhap() {
        // kiem tra rong
        if (kiemTraTruongRong()) {
            String cmnd = jtfCMND.getText().trim();
            String hoTen = jtfHoTen.getText().trim();
            String sdt = jtfSDT.getText().trim();
            String email = jtfEmail.getText().trim();
            String tk = jtfTaiKhoan.getText().trim();
            String mk = jpassword.getText().trim();
            if (mk.equals("")) {
                JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
                jpassword.requestFocus();
                return false;
            }

            // kiem tra cmnd trùng
            if (CheckInPut.checkCMND(cmnd)) {
                ResultSet rs = LopKetNoi.select("select * from nguoidung where cmnd=?", cmnd);
                try {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "CMND bị trùng");
                        jtfCMND.requestFocus();
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("kiem tra cmnd lỗi");
                }
            } else {
                JOptionPane.showMessageDialog(this, "CMND gồm 9 hoặc 12 số");
                jtfCMND.requestFocus();
                return false;
            }
            if (!CheckInPut.checkSDT(sdt)) {
                JOptionPane.showMessageDialog(this, "SDT không hợp lệ(Phải gồm 10 chữ số bắt đầu là 0)");
                jtfSDT.requestFocus();
                return false;
            }
            // kiem tra tai khoan
            if (!CheckInPut.checkTenTaiKhoan(tk)) {
                JOptionPane.showMessageDialog(this, "Tài khoản phải từ 5 kí tự trở lên");
                jtfTaiKhoan.requestFocus();
                return false;
            } else {
                ResultSet rs = LopKetNoi.select("select * from taikhoan where tentaikhoan = ?", tk);
                try {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Tài khoản bị trùng");
                        jtfTaiKhoan.requestFocus();
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("kiem tra tai khoan trung loi");
                }
            }
            // kiểm tra mk
            if (!CheckInPut.checkCacLoaiMa(mk)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 1 kí tự trở lên");
                jpassword.requestFocus();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        batCacTruong();
        setRongCacTruong();

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (hangDangChon == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hàng trong bảng");
            return;
        }
        btnSua.setEnabled(false);
        batCacTruong();
        jtfCMND.setEditable(false);
        jtfTaiKhoan.setEditable(false);

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (hangDangChon == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hàng trong bảng");
            return;
        }

        String cmnd = jtfCMND.getText().trim();
        String tk = jtfTaiKhoan.getText().trim();
        LopKetNoi.update("delete from taikhoan where tentaikhoan = ?", tk);
        LopKetNoi.update("delete from nguoidung where cmnd = ?", cmnd);
        tbmNhanVien.removeRow(hangDangChon);
        jtbNhanVien.clearSelection();
        setRongCacTruong();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        hangDangChon = -1;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jtfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyReleased
        // TODO add your handling code here:
        trsNhanVien.setRowFilter(RowFilter.regexFilter(jtfTimKiem.getText().toUpperCase().trim()));
    }//GEN-LAST:event_jtfTimKiemKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ChuyenManHinhView(this, new JPanelQuanLiNhanVien()).change();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        if (demMatKhau == 0) {
            jpassword.setEchoChar((char) 0);
            demMatKhau = 1;
        } else {
            jpassword.setEchoChar('*');
            demMatKhau = 0;
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jtfCMNDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCMNDKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            jtfCMND.setText(jtfCMND.getText().replaceAll(" ", ""));
        }
    }//GEN-LAST:event_jtfCMNDKeyReleased

    private void jtfTaiKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTaiKhoanKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            jtfTaiKhoan.setText(jtfTaiKhoan.getText().replaceAll(" ", ""));
        }
    }//GEN-LAST:event_jtfTaiKhoanKeyReleased

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:

        if (!btnThem.isEnabled()) {// them
            if (kiemTraThongTinNhap()) {
                String cmnd = jtfCMND.getText().trim();
                String hoTen = jtfHoTen.getText().trim();
                String sdt = jtfSDT.getText().trim();
                String email = jtfEmail.getText().trim();
                String tk = jtfTaiKhoan.getText().trim();
                String mk = jpassword.getText().trim();
                LopKetNoi.update("insert into nguoidung values(?,?,?,?,?)", cmnd, sdt, hoTen, email, tk);
                LopKetNoi.update("insert into taikhoan values(?,?,?,?)", tk, mk, "NV", cmnd);
                tbmNhanVien.addRow(new Object[]{cmnd, hoTen, sdt, email, tk, mk});
                btnThem.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                return;
            }
        } else if (!btnSua.isEnabled()) {// sua
            if (kiemTraTruongRong()) {
                String cmnd = jtfCMND.getText().trim();
                String hoTen = jtfHoTen.getText().trim();
                String sdt = jtfSDT.getText().trim();
                String email = jtfEmail.getText().trim();
                String tk = jtfTaiKhoan.getText().trim();
                String mk = jpassword.getText().trim();
                LopKetNoi.update("update nguoidung set ten = ?, sdt=?, email=? where cmnd = ?", hoTen, sdt, email, cmnd);
                LopKetNoi.update("update taikhoan set matkhau = ? where tentaikhoan = ?", mk, tk);
                jtbNhanVien.setValueAt(hoTen, hangDangChon, 1);
                jtbNhanVien.setValueAt(sdt, hangDangChon, 2);
                jtbNhanVien.setValueAt(email, hangDangChon, 3);
                jtbNhanVien.setValueAt(mk, hangDangChon, 5);
                btnSua.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                hangDangChon = -1;
            } else {
                return;
            }
        }
        tatCacTruong();
        setRongCacTruong();
        jtbNhanVien.clearSelection();
    }//GEN-LAST:event_btnXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTable jtbNhanVien;
    private javax.swing.JTextField jtfCMND;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfSDT;
    private javax.swing.JTextField jtfTaiKhoan;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
