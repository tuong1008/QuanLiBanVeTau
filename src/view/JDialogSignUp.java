/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import connectSQL.LopKetNoi;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import module.CheckInPut;
import module.LoaiTaiKhoan;
import module.TaiKhoan;
import module.NguoiDung;
/**
 *
 * @author Tuong
 */
public class JDialogSignUp extends javax.swing.JDialog {

    LopKetNoi ketNoiCSDL;
    TaiKhoan taiKhoan;
    /**
     * Creates new form JDialogSignUp
     */
    public JDialogSignUp() {
        super((Frame)null,true);
        initComponents();
        taiKhoan=null;
        setLocationRelativeTo(this);
        ketNoiCSDL=new LopKetNoi();
    }
    public JDialogSignUp(TaiKhoan taiKhoan)
    {
        super((Frame)null,true);
        initComponents();
        this.taiKhoan=this.taiKhoan;
        setLocationRelativeTo(this);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfHoTen = new javax.swing.JTextField();
        jtfCMND = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfSDT = new javax.swing.JTextField();
        jtfTenTaiKhoan = new javax.swing.JTextField();
        jtfMatKhau = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("????NG K??");

        jLabel2.setText("H??? v?? T??n");

        jLabel3.setText("CMND");

        jLabel4.setText("Email");

        jLabel5.setText("S??? ??i???n tho???i");

        jLabel6.setText("T??n t??i kho???n");

        jLabel7.setText("M???t kh???u");

        jButton1.setText("X??c nh???n ????ng k??");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(jtfEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfCMND, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfHoTen, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfTenTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jButton1)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtfCMND.getText().equals("")
                ||jtfSDT.getText().equals("")
                ||jtfHoTen.getText().equals("")
                ||jtfEmail.getText().equals("")
                ||jtfTenTaiKhoan.getText().equals("")
                ||jtfMatKhau.getText().equals("")
                ||jtfTenTaiKhoan.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Kh??ng ???????c ????? tr???ng b???t k?? th??ng tin n??o");
        }
        else if (!CheckInPut.checkCMND(jtfCMND.getText()))
        {
            JOptionPane.showMessageDialog(rootPane, "CMND ph???i l?? d??y s??? g???m 9 s??? ho???c 12 s???");
        }
        else if (!CheckInPut.checkSDT(jtfSDT.getText()))
        {
            JOptionPane.showMessageDialog(rootPane, "S??? ??i???n tho???i l?? d??y s??? g???m 10 ho???c 11 s??? v?? b???t ?????u b???ng 0");
        }
        else if (!CheckInPut.checkTenVietNam(jtfHoTen.getText()))
        {
            JOptionPane.showMessageDialog(rootPane, "T??n kh??ng ???????c bao g???m s???, k?? t??? ?????c bi???t v?? kh??ng v?????t qu?? 50 k?? t???");
        }
        else if (!CheckInPut.checkEmail(jtfEmail.getText()))
        {
            JOptionPane.showMessageDialog(rootPane, "Email kh??ng ????ng ?????nh d???ng v?? kh??ng v?????t qu?? 50 k?? t???");
        }
        else if (!CheckInPut.checkTenTaiKhoan(jtfTenTaiKhoan.getText()))
        {
            JOptionPane.showMessageDialog(rootPane, "T??n t??i kho???n ph???i d??i h??n 5 v?? nh??? h??n 50 k?? t???");
        }
        else
        {
            NguoiDung newUser= new NguoiDung();
        TaiKhoan newAccount= new TaiKhoan();
        newUser.setCMND(jtfCMND.getText());
        newUser.setSDT(jtfSDT.getText());
        newUser.setTen(CheckInPut.chuanHoaTen(jtfHoTen.getText()));
        newUser.setEmail(jtfEmail.getText());
        newUser.setTenTaiKhoan(jtfTenTaiKhoan.getText());
        
        newAccount.setTenTaiKhoan(jtfTenTaiKhoan.getText());
        newAccount.setMatKhau(jtfMatKhau.getText());
        newAccount.setCMND(jtfCMND.getText());
        if (taiKhoan==null)
        {
            newAccount.setMaLoaiTaiKhoan("KH");
        }
        else
        {
            newAccount.setMaLoaiTaiKhoan("QT");
        }
        
        String ketQua="";
        if (ketNoiCSDL.addNguoiDungForTaiKhoan(ketNoiCSDL,newUser))
        {
            ketQua=ketQua+"Th??m Ng?????i d??ng ";
            if (ketNoiCSDL.addTaiKhoan(newAccount))
            {
                ketQua=ketQua+"v?? th??m T??i kho???n th??nh c??ng!";
                JOptionPane.showMessageDialog(rootPane, ketQua);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Th??m T??i kho???n th???t b???i! V?? t??n t??i kho???n b??? tr??ng");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Th??m Ng?????i d??ng th???t b???i! V?? b??? tr??ng CMND");
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtfCMND;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfMatKhau;
    private javax.swing.JTextField jtfSDT;
    private javax.swing.JTextField jtfTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
