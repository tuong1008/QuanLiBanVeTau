/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.datve;

import com.microsoft.sqlserver.jdbc.SQLServerStatementColumnEncryptionSetting;
import connectSQL.LopKetNoi;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import module.TaiKhoan;
import module.TauChayTuyen;
import module.Toa;
import module.TuyenDiQuaTram;



/**
 *
 * @author Tuong
 */
public class JDialogTaoCapVeKhuHoi extends javax.swing.JDialog {

    /**
     * Creates new form JDialogTaoCapVeKhuHoi
     */
    TaiKhoan taiKhoan;
    DefaultTableModel model1;
    DefaultTableModel model2;
    DefaultTableModel model3;
    LopKetNoi ketNoiCSDL;
    ArrayList<TuyenDiQuaTram[]> DSTuyen;
    ArrayList<TuyenDiQuaTram[]> DSTuyen_ChieuVe;
    ArrayList<TauChayTuyen> DSTauPhuHop;
    ArrayList<TauChayTuyen> DSTauPhuHop_ChieuVe;
    ArrayList<Toa> DSTatCaToa;
    ArrayList<Toa> DSTatCaToa_ChieuVe;
    JComboBox<String> cbbLoaiVe;
    boolean doClear;
    int ID_TCT;
    public JDialogTaoCapVeKhuHoi()
    {
        super((Frame) null,true);
        initComponents();
        model1=(DefaultTableModel) jTable1.getModel();
        model2=(DefaultTableModel) jTable2.getModel();
        model3=(DefaultTableModel) jTableNguoiDung.getModel();
//        model1.addRow(new Object[] {"1","","","",""});
//        model1.addRow(new Object[] {"2","","","",""});
//        model1.addRow(new Object[] {"3","","","",""});
//        model1.addRow(new Object[] {"4","","","",""});
//        model1.addRow(new Object[] {"5","","","",""});
//        model2.addRow(new Object[] {"1","","","",""});
//        model2.addRow(new Object[] {"","","","",""});
    
    }
    public JDialogTaoCapVeKhuHoi(TaiKhoan taiKhoan,Vector<Vector> dataTable,ArrayList<TuyenDiQuaTram[]> DSTuyen,ArrayList<TuyenDiQuaTram[]> DSTuyen_ChieuVe,ArrayList<TauChayTuyen> DSTauPhuHop, ArrayList<TauChayTuyen> DSTauPhuHop_ChieuVe, ArrayList<Toa> DSTatCaToa, ArrayList<Toa> DSTatCaToa_ChieuVe, boolean modal,boolean doClear) {
        super((Frame) null, modal);
        this.taiKhoan=taiKhoan;
        initComponents();
        setLocationRelativeTo(this);
        model1=(DefaultTableModel) jTable1.getModel();
        model2=(DefaultTableModel) jTable2.getModel();
        model3=(DefaultTableModel) jTableNguoiDung.getModel();
        ketNoiCSDL=new LopKetNoi();
        this.DSTuyen=DSTuyen;
        this.DSTuyen_ChieuVe=DSTuyen_ChieuVe;
        this.DSTauPhuHop=DSTauPhuHop;
        this.DSTauPhuHop_ChieuVe=DSTauPhuHop_ChieuVe;
        this.DSTatCaToa=DSTatCaToa;
        this.DSTatCaToa_ChieuVe=DSTatCaToa_ChieuVe;
        this.doClear=doClear;
        TableColumn cotLoaiVe = jTableNguoiDung.getColumnModel().getColumn(3);
        cbbLoaiVe = loadLoaiVeVaoCBB(ketNoiCSDL);
        cbbLoaiVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hangDangChon=jTableNguoiDung.getSelectedRow();
                dieuChinhGia(hangDangChon);
            }
        });
        cotLoaiVe.setCellEditor(new DefaultCellEditor(cbbLoaiVe));
        int demChieuDi=0;
        int demChieuVe=0;
        for (int i=0;i<dataTable.size();i++)
        {
            if (dataTable.elementAt(i).elementAt(0).equals("Chiều đi"))
            {
                demChieuDi++;
                dataTable.elementAt(i).setElementAt(demChieuDi, 0);
                model1.addRow(dataTable.elementAt(i));
                model3.addRow(new Object[] {i+1,"","",""});
            }
            else
            {
                demChieuVe++;
                dataTable.elementAt(i).setElementAt(demChieuVe, 0);
                model2.addRow(dataTable.elementAt(i));
            }
        }
        //thêm những dòng trống
        if (demChieuDi>demChieuVe)
        {
            for (int i=demChieuVe+1;i<=demChieuDi;i++)
            {
                model2.addRow(new Object[] {i,"","","","","","",""});
            }
        }
        else
        {
            if (demChieuDi<demChieuVe)
            {
                for (int i=demChieuDi+1;i<=demChieuVe;i++)
            {
                model1.addRow(new Object[] {i,"","","","","","",""});
                model3.addRow(new Object[] {i,"","",""});
            }
            }
        }
        jTable1.moveColumn(jTable1.getColumnCount()-1, 5);//move cột Giảm Giá sang cột thứ 5
        jTable2.moveColumn(jTable2.getColumnCount()-1, 5);
        for (int i=0;i<jTable1.getRowCount();i++)
        {
            dieuChinhGia(i);
        }
        
    } 

    public boolean isDoClear() {
        return doClear;
    }
    
    private void dieuChinhGia(int hangDangChon)
    {
                NumberFormat myFormat = NumberFormat.getInstance();
                myFormat.setGroupingUsed(true);                

                float heSoLoaiVe;
                if (cbbLoaiVe.getSelectedIndex()!=-1)
                {
                    String tenLoaiVe=jTableNguoiDung.getValueAt(hangDangChon, 3).toString();
                    heSoLoaiVe=getHeSoLoaiVe(ketNoiCSDL, tenLoaiVe);
                }
                else
                {
                    heSoLoaiVe=1;
                }
                //trường hợp vé 1 chiều là chiều về
                if (jTable1.getValueAt(hangDangChon, 1).equals(""))
                {
                    String strGiaGoc=jTable2.getValueAt(hangDangChon, 4).toString();
                    strGiaGoc=strGiaGoc.replace(",","");
                    strGiaGoc=strGiaGoc.trim();
                    int giaGoc_ChieuVe=Integer.valueOf(strGiaGoc);
                    Object giaSauKhiGiam=myFormat.format(Math.round(giaGoc_ChieuVe*heSoLoaiVe));
                    jTable2.setValueAt(giaSauKhiGiam, hangDangChon, 5);
                }
                else
                {
                    //ngược lại là chiều đi có mà k có chiều về
                    if (jTable2.getValueAt(hangDangChon, 1).equals(""))
                    {
                        String strGiaGoc=jTable1.getValueAt(hangDangChon, 4).toString();
                        strGiaGoc=strGiaGoc.replace(",","");
                        strGiaGoc=strGiaGoc.trim();
                        int giaGoc=Integer.valueOf(strGiaGoc);
                        Object giaSauKhiGiam=myFormat.format(Math.round(giaGoc*heSoLoaiVe));
                        jTable1.setValueAt(giaSauKhiGiam, hangDangChon, 5);
                    }
                    //ngược lại là vé khứ hồi
                    else
                    {
                        String strGiaGoc=jTable1.getValueAt(hangDangChon, 4).toString();
                        strGiaGoc=strGiaGoc.replace(",","");
                        strGiaGoc=strGiaGoc.trim();
                        int giaGoc=Integer.valueOf(strGiaGoc);
                        Object giaSauKhiGiam=myFormat.format(Math.round(giaGoc*heSoLoaiVe));
                        jTable1.setValueAt(giaSauKhiGiam, hangDangChon, 5);
                        
                        float heSoKhuHoi=getHeSoLoaiVe(ketNoiCSDL, "KHỨ HỒI");
                        strGiaGoc=jTable2.getValueAt(hangDangChon, 4).toString();
                        strGiaGoc=strGiaGoc.replace(",","");
                        strGiaGoc=strGiaGoc.trim();
                        int giaGoc_ChieuVe=Integer.valueOf(strGiaGoc);
                        Object giaSauKhiGiam_ChieuVe=myFormat.format(Math.round(giaGoc_ChieuVe*heSoLoaiVe*heSoKhuHoi));
                        jTable2.setValueAt(giaSauKhiGiam_ChieuVe, hangDangChon, 5);
                    }
                    
                }
    }
    private JComboBox<String> loadLoaiVeVaoCBB(LopKetNoi ketNoiCSDL)
    {
        JComboBox<String> cbbLoaiVe=new JComboBox<String>();
        try {
            ResultSet rs=ketNoiCSDL.select("select TenLoaiVe from LoaiVe where TenLoaiVe!=N'KHỨ HỒI'");
            while (rs.next())
            {
                cbbLoaiVe.addItem(rs.getString(1));
            }
            cbbLoaiVe.setSelectedIndex(-1);
        } catch (Exception e) {
            System.out.println("Load CBBLoaiVe bị lỗi");
        }
        return cbbLoaiVe;
    }
    private float getHeSoLoaiVe(LopKetNoi ketNoiCSDL,String tenLoaiVe)
    {
        try {
            ResultSet rs=ketNoiCSDL.select("select HeSo from LoaiVe where TenLoaiVe=?",tenLoaiVe);
            while (rs.next())
            {
                return rs.getFloat(1);
            }
            cbbLoaiVe.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println("Load HeSo loại vé bị lỗi");
        }
        return 0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableNguoiDung = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonUp_ChieuDi = new javax.swing.JButton();
        jButtonDown_ChieuDi = new javax.swing.JButton();
        jButtonUp_ChieuVe = new javax.swing.JButton();
        jButtonDown_ChieuVe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonXacNhan = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel1.setText("Sắp xếp Tuyến Khứ Hồi");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 4));

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 10));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(24, 4));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 24));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Tàu", "Mã Toa", "Ghế Số", "Giá Gốc", "Thời Gian Đi", "Thời Gian Đến", "Giá Sau Khi Giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setDragEnabled(true);
        jTable1.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(163);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(163);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(163);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(163);
        }

        jScrollPane3.setMinimumSize(new java.awt.Dimension(24, 4));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 420));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Tàu", "Mã Toa", "Ghế Số", "Giá Gốc", "Thời Gian Đi", "Thời Gian Đến", "Giá Sau Khi Giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(163);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(163);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(163);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(163);
        }

        jScrollPane4.setMinimumSize(new java.awt.Dimension(24, 4));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(300, 420));

        jTableNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "CMND/Ngày Sinh/Số định danh", "Họ Tên", "Loại Vé"
            }
        ));
        jTableNguoiDung.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableNguoiDung.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jTableNguoiDung);
        if (jTableNguoiDung.getColumnModel().getColumnCount() > 0) {
            jTableNguoiDung.getColumnModel().getColumn(0).setResizable(false);
            jTableNguoiDung.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableNguoiDung.getColumnModel().getColumn(1).setResizable(false);
            jTableNguoiDung.getColumnModel().getColumn(1).setPreferredWidth(210);
            jTableNguoiDung.getColumnModel().getColumn(2).setResizable(false);
            jTableNguoiDung.getColumnModel().getColumn(2).setPreferredWidth(190);
            jTableNguoiDung.getColumnModel().getColumn(3).setResizable(false);
            jTableNguoiDung.getColumnModel().getColumn(3).setPreferredWidth(130);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Thông tin người ngồi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane2.setViewportView(jPanel1);

        jLabel2.setText("Tạo cặp vé khứ hồi");

        jButtonUp_ChieuDi.setText("Up");
        jButtonUp_ChieuDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUp_ChieuDiActionPerformed(evt);
            }
        });

        jButtonDown_ChieuDi.setText("Down");
        jButtonDown_ChieuDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDown_ChieuDiActionPerformed(evt);
            }
        });

        jButtonUp_ChieuVe.setText("Up");
        jButtonUp_ChieuVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUp_ChieuVeActionPerformed(evt);
            }
        });

        jButtonDown_ChieuVe.setText("Down");
        jButtonDown_ChieuVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDown_ChieuVeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Chiều đi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Chiều về");

        jButtonXacNhan.setText("Xác Nhận");
        jButtonXacNhan.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXacNhanActionPerformed(evt);
            }
        });

        jButton6.setText("Huỷ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUp_ChieuDi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDown_ChieuDi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUp_ChieuVe, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDown_ChieuVe)
                .addGap(185, 185, 185))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(516, 516, 516))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(559, 559, 559))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jButtonUp_ChieuVe)
                    .addComponent(jButtonDown_ChieuVe)
                    .addComponent(jButtonUp_ChieuDi)
                    .addComponent(jButtonDown_ChieuDi))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUp_ChieuDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUp_ChieuDiActionPerformed
        // TODO add your handling code here:
        moveRowBy_ChieuDi(-1);
        
    }//GEN-LAST:event_jButtonUp_ChieuDiActionPerformed

    private void jButtonDown_ChieuDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDown_ChieuDiActionPerformed
        // TODO add your handling code here:
        moveRowBy_ChieuDi(1);
    }//GEN-LAST:event_jButtonDown_ChieuDiActionPerformed

    private void jButtonUp_ChieuVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUp_ChieuVeActionPerformed
        // TODO add your handling code here:
        moveRowBy_ChieuVe(-1);
    }//GEN-LAST:event_jButtonUp_ChieuVeActionPerformed

    private void jButtonDown_ChieuVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDown_ChieuVeActionPerformed
        // TODO add your handling code here:
        moveRowBy_ChieuVe(1);
    }//GEN-LAST:event_jButtonDown_ChieuVeActionPerformed
    private boolean kiemTraCMNDVaTen(DefaultTableModel model)
    {
        for (int i=0;i<model.getRowCount();i++)
        {
            String CMND=model.getValueAt(i, 1).toString();
            String hoTen=model.getValueAt(i, 2).toString();
            if (CMND.length()==0 || hoTen.length()==0)
            {
                return false;
            }
        }
        return true;
    }
    private void jButtonXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXacNhanActionPerformed
        // TODO add your handling code here:
        jTableNguoiDung.editCellAt(0, 0);//để bỏ chọn ô đang chọn, table mới save được ô mới nhập
        if (kiemTraCMNDVaTen(model3))
        {
            for (int i=0;i<jTable1.getRowCount();i++)
        {
            String soDinhDanh=model3.getValueAt(i, 1).toString();
            String hoTenNguoiNgoi=model3.getValueAt(i, 2).toString();
            String tenLoaiVe=model3.getValueAt(i, 3).toString();
            if (jTable1.getValueAt(i, 1).equals(""))
            {
                //Lấy dữ liệu cần thiết từ bảng Chiều về để Đặt vé
            String tempMaTau_ChieuVe=jTable2.getValueAt(i,1).toString();//Table---|maTau,maToa,i.getText(),thoiGianDi,thoiGianDen|
            String tempMaToa_ChieuVe=jTable2.getValueAt(i, 2).toString();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            int tempChoNgoiSo_ChieuVe=Integer.valueOf(jTable2.getValueAt(i, 3).toString());
            String strGiaDaGiam=jTable2.getValueAt(i, 5).toString();
            strGiaDaGiam=strGiaDaGiam.replace(",", "");
            int giaDaGiam=Integer.valueOf(strGiaDaGiam);
            Date tempThoiGianDi_ChieuVe=null;
            try {
                tempThoiGianDi_ChieuVe=formatter.parse(jTable2.getValueAt(i, 6).toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Timestamp timeStampThoiGianDi_ChieuVe=new Timestamp(tempThoiGianDi_ChieuVe.getTime());
                Date tempThoiGianDen_ChieuVe=null;
                try {
                    tempThoiGianDen_ChieuVe=formatter.parse(jTable2.getValueAt(i, 7).toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Timestamp timeStampThoiGianDen_ChieuVe=new Timestamp(tempThoiGianDen_ChieuVe.getTime());
                //get Tuyến theo Mã Tàu
                TauChayTuyen tempTauChayTuyen_ChieuVe=null;
                for (TauChayTuyen j:DSTauPhuHop_ChieuVe)
                {
                    if ((j.getMaTau().equals(tempMaTau_ChieuVe))&&(j.getThoiGianDenTramDi().compareTo(timeStampThoiGianDi_ChieuVe)==0))
                    {
                        tempTauChayTuyen_ChieuVe=j;
                        break;
                    }
                }
                //get Trạm đi, Trạm đến theo Mã Tuyến
                TuyenDiQuaTram[] tempTuyenDiQuaTram_ChieuVe=null;
                for (TuyenDiQuaTram[] j:DSTuyen_ChieuVe)
                {
                    if ((j[0].getMaTuyen().equals(tempTauChayTuyen_ChieuVe.getMaTuyen()))&&(j[0].getThoiGianHieuChinh().compareTo(tempTauChayTuyen_ChieuVe.getThoiGianHieuChinhTuyen())==0))
                    {
                        tempTuyenDiQuaTram_ChieuVe=j;
                        break;
                    }
                }
                Toa tempToa_ChieuVe=null;
                for (Toa j:DSTatCaToa_ChieuVe)
                {
                    if (j.getMaToa().equals(tempMaToa_ChieuVe))
                    {
                        tempToa_ChieuVe=j;
                        break;
                    }
                }
                
                //Tạo vé 1 chiều bằng bảng model2
                try {
                    ResultSet rs=ketNoiCSDL.select("select ID_TCT from TauChayTuyen where MaTau=? and ThoiGianHieuChinhTau=?\n" +
                    "and MaTuyen=? and ThoiGianHieuChinh=? and ThoiGianKhoiHanh=?"
                            ,tempMaTau_ChieuVe
                            ,tempTauChayTuyen_ChieuVe.getThoiGianHieuChinhTau()
                            ,tempTuyenDiQuaTram_ChieuVe[0].getMaTuyen()
                            ,tempTuyenDiQuaTram_ChieuVe[0].getThoiGianHieuChinh()
                            ,tempTauChayTuyen_ChieuVe.getThoiGianKhoiHanh());
                    if (rs.next())
                    {
                        ID_TCT=rs.getInt(1);
                    }
                } catch (Exception e) {
                    System.out.println("get ID_TCT thất bại");
                }
                int tempMaChuyen_ChieuVe=ketNoiCSDL.addChuyenDi(tempTuyenDiQuaTram_ChieuVe[0].getTenTram(), tempTuyenDiQuaTram_ChieuVe[1].getTenTram(),ID_TCT,tempToa_ChieuVe.getMaToa());
                int tempMaVe_ChieuVe=ketNoiCSDL.addVe(soDinhDanh, tempChoNgoiSo_ChieuVe, timeStampThoiGianDi_ChieuVe, timeStampThoiGianDen_ChieuVe, giaDaGiam,false,tempMaChuyen_ChieuVe,tenLoaiVe,taiKhoan.getTenTaiKhoan(),hoTenNguoiNgoi);
            }
            else
            {
                //Lấy dữ liệu cần thiết từ bảng Chiều đi để Đặt vé
                String tempMaTau=jTable1.getValueAt(i,1).toString();//Table---|maTau,maToa,i.getText(),thoiGianDi,thoiGianDen|
                String tempMaToa=jTable1.getValueAt(i, 2).toString();
                int tempChoNgoiSo=Integer.valueOf(jTable1.getValueAt(i, 3).toString());
                String strGiaDaGiam=jTable1.getValueAt(i, 5).toString();
                strGiaDaGiam=strGiaDaGiam.replace(",", "");
                int giaDaGiam=Integer.valueOf(strGiaDaGiam);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date tempThoiGianDi=null;
                try {
                    tempThoiGianDi=formatter.parse(jTable1.getValueAt(i, 6).toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Timestamp timeStampThoiGianDi=new Timestamp(tempThoiGianDi.getTime());
                Date tempThoiGianDen=null;
                try {
                    tempThoiGianDen=formatter.parse(jTable1.getValueAt(i, 7).toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Timestamp timeStampThoiGianDen=new Timestamp(tempThoiGianDen.getTime());
                //get Tuyến theo Mã Tàu
                TauChayTuyen tempTauChayTuyen=null;
                for (TauChayTuyen j:DSTauPhuHop)
                {
                    if ((j.getMaTau().equals(tempMaTau))&&(j.getThoiGianDenTramDi().compareTo(timeStampThoiGianDi)==0))
                    {
                        tempTauChayTuyen=j;
                        break;
                    }
                }
                //get Trạm đi, Trạm đến theo Mã Tuyến
                TuyenDiQuaTram[] tempTuyenDiQuaTram=null;
                for (TuyenDiQuaTram[] j:DSTuyen)
                {
                    if ((j[0].getMaTuyen().equals(tempTauChayTuyen.getMaTuyen())&&(j[0].getThoiGianHieuChinh().compareTo(tempTauChayTuyen.getThoiGianHieuChinhTuyen())==0)))
                    {
                        tempTuyenDiQuaTram=j;
                        break;
                    }
                }
                Toa tempToa=null;
                for (Toa j:DSTatCaToa)
                {
                    if (j.getMaToa().equals(tempMaToa))
                    {
                        tempToa=j;
                        break;
                    }
                }
                //Tạo vé chiều đi bằng bảng model1
                try {
                    ResultSet rs=ketNoiCSDL.select("select ID_TCT from TauChayTuyen where MaTau=? and ThoiGianHieuChinhTau=?\n" +
                    "and MaTuyen=? and ThoiGianHieuChinh=? and ThoiGianKhoiHanh=?"
                            ,tempMaTau
                            ,tempTauChayTuyen.getThoiGianHieuChinhTau()
                            ,tempTuyenDiQuaTram[0].getMaTuyen()
                            ,tempTuyenDiQuaTram[0].getThoiGianHieuChinh()
                            ,tempTauChayTuyen.getThoiGianKhoiHanh());
                    if (rs.next())
                    {
                        ID_TCT=rs.getInt(1);
                    }
                } catch (Exception e) {
                    System.out.println("get ID_TCT thất bại");
                }
                int tempMaChuyen=ketNoiCSDL.addChuyenDi(tempTuyenDiQuaTram[0].getTenTram(),tempTuyenDiQuaTram[1].getTenTram(),ID_TCT,tempToa.getMaToa());
                if (!jTable2.getValueAt(i, 1).equals(""))
                {
                    int tempMaVe=ketNoiCSDL.addVe(soDinhDanh, tempChoNgoiSo, timeStampThoiGianDi, timeStampThoiGianDen, giaDaGiam, true,tempMaChuyen,tenLoaiVe,taiKhoan.getTenTaiKhoan(),hoTenNguoiNgoi);
                    //Lấy dữ liệu cần thiết từ bảng Chiều về để Đặt vé
                    String tempMaTau_ChieuVe=jTable2.getValueAt(i,1).toString();//Table---|maTau,maToa,i.getText(),thoiGianDi,thoiGianDen|
                    String tempMaToa_ChieuVe=jTable2.getValueAt(i, 2).toString();
                    int tempChoNgoiSo_ChieuVe=Integer.valueOf(jTable2.getValueAt(i, 3).toString());
                    strGiaDaGiam=jTable2.getValueAt(i, 5).toString();
                    strGiaDaGiam=strGiaDaGiam.replace(",", "");
                    giaDaGiam=Integer.valueOf(strGiaDaGiam);
                    Date tempThoiGianDi_ChieuVe=null;
                    try {
                        tempThoiGianDi_ChieuVe=formatter.parse(jTable2.getValueAt(i, 6).toString());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    Timestamp timeStampThoiGianDi_ChieuVe=new Timestamp(tempThoiGianDi_ChieuVe.getTime());
                    Date tempThoiGianDen_ChieuVe=null;
                    try {
                        tempThoiGianDen_ChieuVe=formatter.parse(jTable2.getValueAt(i, 7).toString());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    Timestamp timeStampThoiGianDen_ChieuVe=new Timestamp(tempThoiGianDen_ChieuVe.getTime());
                    //get Tuyến theo Mã Tàu
                    TauChayTuyen tempTauChayTuyen_ChieuVe=null;
                    for (TauChayTuyen j:DSTauPhuHop_ChieuVe)
                    {
                        if ((j.getMaTau().equals(tempMaTau_ChieuVe))&&(j.getThoiGianDenTramDi().compareTo(timeStampThoiGianDi_ChieuVe)==0))
                        {
                            tempTauChayTuyen_ChieuVe=j;
                            break;
                        }
                    }
                    //get Trạm đi, Trạm đến theo Mã Tuyến
                    TuyenDiQuaTram[] tempTuyenDiQuaTram_ChieuVe=null;
                    for (TuyenDiQuaTram[] j:DSTuyen_ChieuVe)
                    {
                        if ((j[0].getMaTuyen().equals(tempTauChayTuyen_ChieuVe.getMaTuyen())&&(j[0].getThoiGianHieuChinh().compareTo(tempTauChayTuyen_ChieuVe.getThoiGianHieuChinhTuyen())==0)))
                        {
                            tempTuyenDiQuaTram_ChieuVe=j;
                            break;
                        }
                    }
                    Toa tempToa_ChieuVe=null;
                    for (Toa j:DSTatCaToa_ChieuVe)
                    {
                        if (j.getMaToa().equals(tempMaToa_ChieuVe))
                        {
                            tempToa_ChieuVe=j;
                            break;
                        }
                    }
                    //Tạo vé chiều về bằng bảng model2
                    try {
                    ResultSet rs=ketNoiCSDL.select("select ID_TCT from TauChayTuyen where MaTau=? and ThoiGianHieuChinhTau=?\n" +
                    "and MaTuyen=? and ThoiGianHieuChinh=? and ThoiGianKhoiHanh=?"
                            ,tempMaTau_ChieuVe
                            ,tempTauChayTuyen_ChieuVe.getThoiGianHieuChinhTau()
                            ,tempTuyenDiQuaTram_ChieuVe[0].getMaTuyen()
                            ,tempTuyenDiQuaTram_ChieuVe[0].getThoiGianHieuChinh()
                            ,tempTauChayTuyen_ChieuVe.getThoiGianKhoiHanh());
                    if (rs.next())
                    {
                        ID_TCT=rs.getInt(1);
                    }
                } catch (Exception e) {
                    System.out.println("get ID_TCT thất bại");
                }
                    int tempMaChuyen_ChieuVe=ketNoiCSDL.addChuyenDi(tempTuyenDiQuaTram_ChieuVe[0].getTenTram(), tempTuyenDiQuaTram_ChieuVe[1].getTenTram(),ID_TCT,tempToa_ChieuVe.getMaToa());
                    ketNoiCSDL.addVeKhuHoi(tempMaVe, timeStampThoiGianDi_ChieuVe, timeStampThoiGianDen_ChieuVe, tempChoNgoiSo_ChieuVe, tempMaVe, timeStampThoiGianDi, tempMaChuyen_ChieuVe, giaDaGiam);
                }
                else//nếu có chiều đi mà không chiều về
                {
                    int tempMaVe=ketNoiCSDL.addVe(soDinhDanh, tempChoNgoiSo, timeStampThoiGianDi, timeStampThoiGianDen, giaDaGiam, false,tempMaChuyen,tenLoaiVe,taiKhoan.getTenTaiKhoan(),hoTenNguoiNgoi);
                }
            }
        }
            JOptionPane.showMessageDialog(rootPane, "Thêm vé thành công!");
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Phải nhập CMND và Tên");
        }
    }//GEN-LAST:event_jButtonXacNhanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        doClear=false;
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
    private void moveRowBy_ChieuDi(int by)
{
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int[] rows = jTable1.getSelectedRows();
    int destination = rows[0] + by;
    int rowCount = model.getRowCount();

    if (destination < 0 || destination >= rowCount)
    {
        return;
    }

    model.moveRow(rows[0], rows[rows.length - 1], destination);
    //trả STT lại, không move STT
    int tempSTTDi=Integer.valueOf(model.getValueAt(rows[0], 0).toString());
    int tempSTTDich=Integer.valueOf(model.getValueAt(destination, 0).toString());
    model.setValueAt(tempSTTDich, rows[0], 0);
    model.setValueAt(tempSTTDi, destination, 0);
    int hangDangChon=jTable1.getSelectedRow();
    dieuChinhGia(hangDangChon);
    dieuChinhGia(hangDangChon+by);
    jTable1.setRowSelectionInterval(rows[0] + by, rows[rows.length - 1] + by);
}
    private void moveRowBy_ChieuVe(int by)
{
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    int[] rows = jTable2.getSelectedRows();
    int destination = rows[0] + by;
    int rowCount = model.getRowCount();

    if (destination < 0 || destination >= rowCount)
    {
        return;
    }

    model.moveRow(rows[0], rows[rows.length - 1], destination);
    //trả STT lại, không move STT
    int tempSTTDi=Integer.valueOf(model.getValueAt(rows[0], 0).toString());
    int tempSTTDich=Integer.valueOf(model.getValueAt(destination, 0).toString());
    model.setValueAt(tempSTTDich, rows[0], 0);
    model.setValueAt(tempSTTDi, destination, 0);
    int hangDangChon=jTable2.getSelectedRow();
    dieuChinhGia(hangDangChon);
    dieuChinhGia(hangDangChon+by);
    jTable2.setRowSelectionInterval(rows[0] + by, rows[rows.length - 1] + by);
}
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
            java.util.logging.Logger.getLogger(JDialogTaoCapVeKhuHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogTaoCapVeKhuHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogTaoCapVeKhuHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogTaoCapVeKhuHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogTaoCapVeKhuHoi dialog = new JDialogTaoCapVeKhuHoi();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonDown_ChieuDi;
    private javax.swing.JButton jButtonDown_ChieuVe;
    private javax.swing.JButton jButtonUp_ChieuDi;
    private javax.swing.JButton jButtonUp_ChieuVe;
    private javax.swing.JButton jButtonXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableNguoiDung;
    // End of variables declaration//GEN-END:variables
}
