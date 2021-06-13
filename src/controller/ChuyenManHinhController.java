/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import module.TaiKhoan;
import view.JPanelCaiDatTaiKhoan;

import view.JPanelDatVe;
import view.JPanelQuanLiLoTrinh;
import view.JPanelQuanLiNhanVien;
import view.JPanelQuanLiToaTau;
import view.JPanelQuanLiTuyen;
import view.JPanelThongKe;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ChuyenManHinhController {

    private JPanel view; // khi bam vao label minh se hien thi panel len cai jpn view nay
    private view.MainFrame mainFr;
    List<DanhMucBean> list = null;
    String khachHayQuanTri;
    TaiKhoan taiKhoan; //luu tai khoan dang nhap luc dau

    

    public ChuyenManHinhController(JPanel view) {
        this.view = view;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) { // set vua vao se vao danh muc bean dau tien la dat ve
        jpnItem.setBackground(new Color(0, 0, 0));
        jlbItem.setForeground(new Color(51, 204, 255));
        view.removeAll();
        view.setLayout(new BorderLayout());
        view.add(new JPanelDatVe(taiKhoan));
        view.validate();
        view.repaint();
    }
    public void setMainFrame(view.MainFrame mainFr)
    {
        this.mainFr=mainFr;
    }
    public void setEvents(List<DanhMucBean> list) { // bat su kien click vao menu
        this.list = list;
        for (DanhMucBean i : list) {
            i.getJpn().addMouseListener(new LabelEvent(i.getKind(), i.getJpn(), i.getJlb()));

        }
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            switch (kind) {
                case "DatVe":
                    node = new JPanelDatVe(taiKhoan);
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();
                    break;
                case "QuanLiLoTrinh":
                    node = new JPanelQuanLiLoTrinh();
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();
                    break;
                case "QuanLiTau":
                    node = new JPanelQuanLiToaTau();
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();
                    break;
                case "QuanLiTuyen":
                    node = new JPanelQuanLiTuyen();
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();       
                    break;
                case "ThongKe":
                    node = new JPanelThongKe();
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();
                    break;
                case "CaiDatTaiKhoan":
                    node = new JPanelCaiDatTaiKhoan(taiKhoan);
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();
                    break;
                case "QuanLiNhanVien":
                    node = new JPanelQuanLiNhanVien();
                    view.removeAll();
                    view.setLayout(new BorderLayout());
                    view.add(node);
                    view.validate();
                    view.repaint();
                    setChangeBackground();
                    break;
                case "DangXuat":
                    int input = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn đăng xuất không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        mainFr.getLoginFrame().setVisible(true);
                        mainFr.dispose();
                    }
                    break;
            }
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {

        }

        private void setChangeBackground() {
            for (DanhMucBean iBean : list) {
                if (kind.equalsIgnoreCase(iBean.getKind())) {
                    iBean.getJpn().setBackground(new Color(0, 0, 0));
                    iBean.getJlb().setForeground(new Color(51, 204, 255));
                } else {
                    iBean.getJpn().setBackground(new Color(0, 0, 0));
                    iBean.getJlb().setForeground(new Color(255, 255, 255));
                }
            }
        }

    }
}
