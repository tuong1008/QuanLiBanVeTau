/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.datve;

import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuong
 */
public class JPanelNgoiCung80 extends NewJPanel {

    /**
     * Creates new form JDialogNgoiCung80
     */
    public JPanelNgoiCung80(String maTau, String maToa, String thoiGianDi,String thoiGianDen, DefaultTableModel model,JRadioButton jRadio1Chieu, String  chieuDi,ArrayList<Integer> DSGheDaDat, int donGia) {
        super(maTau,maToa,thoiGianDi, thoiGianDen,model,jRadio1Chieu, chieuDi,DSGheDaDat,donGia);
        initComponents();
        jTextField1.setText(thoiGianDi);
        jTextField2.setText(thoiGianDen);
        listButton=new ArrayList<JToggleButton>();
        listButton.add(jToggleButton1);
        listButton.add(jToggleButton2);
        listButton.add(jToggleButton3);
        listButton.add(jToggleButton4);
        listButton.add(jToggleButton5);
        listButton.add(jToggleButton6);
        listButton.add(jToggleButton7);
        listButton.add(jToggleButton8);
        listButton.add(jToggleButton9);
        listButton.add(jToggleButton10);
        listButton.add(jToggleButton11);
        listButton.add(jToggleButton12);
        listButton.add(jToggleButton13);
        listButton.add(jToggleButton14);
        listButton.add(jToggleButton15);
        listButton.add(jToggleButton16);
        listButton.add(jToggleButton17);
        listButton.add(jToggleButton18);
        listButton.add(jToggleButton19);
        listButton.add(jToggleButton20);
        listButton.add(jToggleButton21);
        listButton.add(jToggleButton22);
        listButton.add(jToggleButton23);
        listButton.add(jToggleButton24);
        listButton.add(jToggleButton25);
        listButton.add(jToggleButton26);
        listButton.add(jToggleButton27);
        listButton.add(jToggleButton28);
        listButton.add(jToggleButton29);
        listButton.add(jToggleButton30);
        listButton.add(jToggleButton31);
        listButton.add(jToggleButton32);
        listButton.add(jToggleButton33);
        listButton.add(jToggleButton34);
        listButton.add(jToggleButton35);
        listButton.add(jToggleButton36);
        listButton.add(jToggleButton37);
        listButton.add(jToggleButton38);
        listButton.add(jToggleButton39);
        listButton.add(jToggleButton40);
        listButton.add(jToggleButton41);
        listButton.add(jToggleButton42);
        listButton.add(jToggleButton43);
        listButton.add(jToggleButton44);
        listButton.add(jToggleButton45);
        listButton.add(jToggleButton46);
        listButton.add(jToggleButton47);
        listButton.add(jToggleButton48);
        listButton.add(jToggleButton49);
        listButton.add(jToggleButton50);
        listButton.add(jToggleButton51);
        listButton.add(jToggleButton52);
        listButton.add(jToggleButton53);
        listButton.add(jToggleButton54);
        listButton.add(jToggleButton55);
        listButton.add(jToggleButton56);
        listButton.add(jToggleButton57);
        listButton.add(jToggleButton58);
        listButton.add(jToggleButton59);
        listButton.add(jToggleButton60);
        listButton.add(jToggleButton61);
        listButton.add(jToggleButton62);
        listButton.add(jToggleButton63);
        listButton.add(jToggleButton64);
        listButton.add(jToggleButton65);
        listButton.add(jToggleButton66);
        listButton.add(jToggleButton67);
        listButton.add(jToggleButton68);
        listButton.add(jToggleButton69);
        listButton.add(jToggleButton70);
        listButton.add(jToggleButton71);
        listButton.add(jToggleButton72);
        listButton.add(jToggleButton73);
        listButton.add(jToggleButton74);
        listButton.add(jToggleButton75);
        listButton.add(jToggleButton76);
        listButton.add(jToggleButton77);
        listButton.add(jToggleButton78);
        listButton.add(jToggleButton79);
        listButton.add(jToggleButton80);
        
        for (JToggleButton i:listButton)
        {
            i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtoniActionPerformed(i);
            }
        });
        }
        if (DSGheDaDat.size()!=0) disableJToggleButton();
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton24 = new javax.swing.JToggleButton();
        jToggleButton25 = new javax.swing.JToggleButton();
        jToggleButton29 = new javax.swing.JToggleButton();
        jToggleButton30 = new javax.swing.JToggleButton();
        jToggleButton31 = new javax.swing.JToggleButton();
        jToggleButton32 = new javax.swing.JToggleButton();
        jToggleButton33 = new javax.swing.JToggleButton();
        jToggleButton34 = new javax.swing.JToggleButton();
        jToggleButton35 = new javax.swing.JToggleButton();
        jToggleButton36 = new javax.swing.JToggleButton();
        jToggleButton37 = new javax.swing.JToggleButton();
        jToggleButton38 = new javax.swing.JToggleButton();
        jToggleButton39 = new javax.swing.JToggleButton();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton23 = new javax.swing.JToggleButton();
        jToggleButton26 = new javax.swing.JToggleButton();
        jToggleButton48 = new javax.swing.JToggleButton();
        jToggleButton49 = new javax.swing.JToggleButton();
        jToggleButton50 = new javax.swing.JToggleButton();
        jToggleButton47 = new javax.swing.JToggleButton();
        jToggleButton42 = new javax.swing.JToggleButton();
        jToggleButton53 = new javax.swing.JToggleButton();
        jToggleButton54 = new javax.swing.JToggleButton();
        jToggleButton55 = new javax.swing.JToggleButton();
        jToggleButton56 = new javax.swing.JToggleButton();
        jToggleButton57 = new javax.swing.JToggleButton();
        jToggleButton58 = new javax.swing.JToggleButton();
        jToggleButton59 = new javax.swing.JToggleButton();
        jToggleButton60 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jToggleButton22 = new javax.swing.JToggleButton();
        jToggleButton27 = new javax.swing.JToggleButton();
        jToggleButton68 = new javax.swing.JToggleButton();
        jToggleButton66 = new javax.swing.JToggleButton();
        jToggleButton70 = new javax.swing.JToggleButton();
        jToggleButton46 = new javax.swing.JToggleButton();
        jToggleButton43 = new javax.swing.JToggleButton();
        jToggleButton51 = new javax.swing.JToggleButton();
        jToggleButton71 = new javax.swing.JToggleButton();
        jToggleButton74 = new javax.swing.JToggleButton();
        jToggleButton62 = new javax.swing.JToggleButton();
        jToggleButton67 = new javax.swing.JToggleButton();
        jToggleButton72 = new javax.swing.JToggleButton();
        jToggleButton75 = new javax.swing.JToggleButton();
        jToggleButton78 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton20 = new javax.swing.JToggleButton();
        jToggleButton21 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jToggleButton63 = new javax.swing.JToggleButton();
        jToggleButton64 = new javax.swing.JToggleButton();
        jToggleButton65 = new javax.swing.JToggleButton();
        jToggleButton45 = new javax.swing.JToggleButton();
        jToggleButton44 = new javax.swing.JToggleButton();
        jToggleButton52 = new javax.swing.JToggleButton();
        jToggleButton73 = new javax.swing.JToggleButton();
        jToggleButton79 = new javax.swing.JToggleButton();
        jToggleButton61 = new javax.swing.JToggleButton();
        jToggleButton80 = new javax.swing.JToggleButton();
        jToggleButton69 = new javax.swing.JToggleButton();
        jToggleButton76 = new javax.swing.JToggleButton();
        jToggleButton77 = new javax.swing.JToggleButton();
        jToggleButton28 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton8.setText("8");
        jToggleButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jToggleButton1.setText("1");
        jToggleButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jToggleButton9.setText("9");
        jToggleButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 30, 30));

        jToggleButton16.setText("16");
        jToggleButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 30, 30));

        jToggleButton17.setText("17");
        jToggleButton17.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 30, 30));

        jToggleButton24.setText("24");
        jToggleButton24.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        jToggleButton25.setText("25");
        jToggleButton25.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 30, 30));

        jToggleButton29.setText("29");
        jToggleButton29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 30, 30));

        jToggleButton30.setText("30");
        jToggleButton30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 30, 30));

        jToggleButton31.setText("31");
        jToggleButton31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 30, 30));

        jToggleButton32.setText("32");
        jToggleButton32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 30, 30));

        jToggleButton33.setText("33");
        jToggleButton33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 30, 30));

        jToggleButton34.setText("34");
        jToggleButton34.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 30, 30));

        jToggleButton35.setText("35");
        jToggleButton35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 30, 30));

        jToggleButton36.setText("36");
        jToggleButton36.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 30, 30));

        jToggleButton37.setText("37");
        jToggleButton37.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 30, 30));

        jToggleButton38.setText("38");
        jToggleButton38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 30, 30));

        jToggleButton39.setText("39");
        jToggleButton39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 30, 30));

        jToggleButton40.setText("40");
        jToggleButton40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 30, 30));

        jToggleButton7.setText("7");
        jToggleButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 30, 30));

        jToggleButton2.setText("2");
        jToggleButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 30, 30));

        jToggleButton10.setText("10");
        jToggleButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 30, 30));

        jToggleButton15.setText("15");
        jToggleButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 30, 30));

        jToggleButton18.setText("18");
        jToggleButton18.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 30, 30));

        jToggleButton23.setText("23");
        jToggleButton23.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 30, 30));

        jToggleButton26.setText("26");
        jToggleButton26.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 30, 30));

        jToggleButton48.setText("48");
        jToggleButton48.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 30, 30));

        jToggleButton49.setText("49");
        jToggleButton49.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 30, 30));

        jToggleButton50.setText("50");
        jToggleButton50.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 30, 30));

        jToggleButton47.setText("47");
        jToggleButton47.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 30, 30));

        jToggleButton42.setText("42");
        jToggleButton42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 30, 30));

        jToggleButton53.setText("53");
        jToggleButton53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 30, 30));

        jToggleButton54.setText("54");
        jToggleButton54.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 30, 30));

        jToggleButton55.setText("55");
        jToggleButton55.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 30, 30));

        jToggleButton56.setText("56");
        jToggleButton56.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 30, 30));

        jToggleButton57.setText("57");
        jToggleButton57.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        jToggleButton58.setText("58");
        jToggleButton58.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 30, 30));

        jToggleButton59.setText("59");
        jToggleButton59.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 30, 30));

        jToggleButton60.setText("60");
        jToggleButton60.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 30, 30));

        jToggleButton6.setText("6");
        jToggleButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 30, 30));

        jToggleButton3.setText("3");
        jToggleButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 30, 30));

        jToggleButton11.setText("11");
        jToggleButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 30, 30));

        jToggleButton14.setText("14");
        jToggleButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 30, 30));

        jToggleButton19.setText("19");
        jToggleButton19.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 30, 30));

        jToggleButton22.setText("22");
        jToggleButton22.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 30, 30));

        jToggleButton27.setText("27");
        jToggleButton27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 30, 30));

        jToggleButton68.setText("68");
        jToggleButton68.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 30, 30));

        jToggleButton66.setText("66");
        jToggleButton66.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 30, 30));

        jToggleButton70.setText("70");
        jToggleButton70.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 30, 30));

        jToggleButton46.setText("46");
        jToggleButton46.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 30, 30));

        jToggleButton43.setText("43");
        jToggleButton43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 30, 30));

        jToggleButton51.setText("51");
        jToggleButton51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 30, 30));

        jToggleButton71.setText("71");
        jToggleButton71.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 30, 30));

        jToggleButton74.setText("74");
        jToggleButton74.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton74, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 30, 30));

        jToggleButton62.setText("62");
        jToggleButton62.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 30, 30));

        jToggleButton67.setText("67");
        jToggleButton67.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 30, 30));

        jToggleButton72.setText("72");
        jToggleButton72.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 30, 30));

        jToggleButton75.setText("75");
        jToggleButton75.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 30, 30));

        jToggleButton78.setText("78");
        jToggleButton78.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton78, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 30, 30));

        jToggleButton5.setText("5");
        jToggleButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 30, 30));

        jToggleButton4.setText("4");
        jToggleButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 30, 30));

        jToggleButton12.setText("12");
        jToggleButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 30, 30));

        jToggleButton13.setText("13");
        jToggleButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 30, 30));

        jToggleButton20.setText("20");
        jToggleButton20.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 30, 30));

        jToggleButton21.setText("21");
        jToggleButton21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 30, 30));

        jToggleButton41.setText("41");
        jToggleButton41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 30, 30));

        jToggleButton63.setText("63");
        jToggleButton63.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 30, 30));

        jToggleButton64.setText("64");
        jToggleButton64.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 30, 30));

        jToggleButton65.setText("65");
        jToggleButton65.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 30, 30));

        jToggleButton45.setText("45");
        jToggleButton45.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 30, 30));

        jToggleButton44.setText("44");
        jToggleButton44.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 30, 30));

        jToggleButton52.setText("52");
        jToggleButton52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 30, 30));

        jToggleButton73.setText("73");
        jToggleButton73.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton73, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 30, 30));

        jToggleButton79.setText("79");
        jToggleButton79.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 30, 30));

        jToggleButton61.setText("61");
        jToggleButton61.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 30, 30));

        jToggleButton80.setText("80");
        jToggleButton80.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton80, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 30, 30));

        jToggleButton69.setText("69");
        jToggleButton69.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 30, 30));

        jToggleButton76.setText("76");
        jToggleButton76.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton76, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 30, 30));

        jToggleButton77.setText("77");
        jToggleButton77.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 30, 30));

        jToggleButton28.setText("28");
        jToggleButton28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add(jToggleButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 30, 30));

        jLabel1.setText("Đi lúc:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel2.setText("Đến lúc:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jTextField1.setEnabled(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 190, -1));

        jTextField2.setEnabled(false);
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 190, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton21;
    private javax.swing.JToggleButton jToggleButton22;
    private javax.swing.JToggleButton jToggleButton23;
    private javax.swing.JToggleButton jToggleButton24;
    private javax.swing.JToggleButton jToggleButton25;
    private javax.swing.JToggleButton jToggleButton26;
    private javax.swing.JToggleButton jToggleButton27;
    private javax.swing.JToggleButton jToggleButton28;
    private javax.swing.JToggleButton jToggleButton29;
    public javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton30;
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.JToggleButton jToggleButton36;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JToggleButton jToggleButton42;
    private javax.swing.JToggleButton jToggleButton43;
    private javax.swing.JToggleButton jToggleButton44;
    private javax.swing.JToggleButton jToggleButton45;
    private javax.swing.JToggleButton jToggleButton46;
    private javax.swing.JToggleButton jToggleButton47;
    private javax.swing.JToggleButton jToggleButton48;
    private javax.swing.JToggleButton jToggleButton49;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton50;
    private javax.swing.JToggleButton jToggleButton51;
    private javax.swing.JToggleButton jToggleButton52;
    private javax.swing.JToggleButton jToggleButton53;
    private javax.swing.JToggleButton jToggleButton54;
    private javax.swing.JToggleButton jToggleButton55;
    private javax.swing.JToggleButton jToggleButton56;
    private javax.swing.JToggleButton jToggleButton57;
    private javax.swing.JToggleButton jToggleButton58;
    private javax.swing.JToggleButton jToggleButton59;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton60;
    private javax.swing.JToggleButton jToggleButton61;
    private javax.swing.JToggleButton jToggleButton62;
    private javax.swing.JToggleButton jToggleButton63;
    private javax.swing.JToggleButton jToggleButton64;
    private javax.swing.JToggleButton jToggleButton65;
    private javax.swing.JToggleButton jToggleButton66;
    private javax.swing.JToggleButton jToggleButton67;
    private javax.swing.JToggleButton jToggleButton68;
    private javax.swing.JToggleButton jToggleButton69;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton70;
    private javax.swing.JToggleButton jToggleButton71;
    private javax.swing.JToggleButton jToggleButton72;
    private javax.swing.JToggleButton jToggleButton73;
    private javax.swing.JToggleButton jToggleButton74;
    private javax.swing.JToggleButton jToggleButton75;
    private javax.swing.JToggleButton jToggleButton76;
    private javax.swing.JToggleButton jToggleButton77;
    private javax.swing.JToggleButton jToggleButton78;
    private javax.swing.JToggleButton jToggleButton79;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton80;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables
}
