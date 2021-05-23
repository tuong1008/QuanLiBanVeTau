/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectSQL;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import module.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LopKetNoi {

    private static Connection connection;

    public LopKetNoi() {

        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau2";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopKetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public ResultSet selectQuery(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<LoaiTaiKhoan> getDSLoaiTK() {
        ArrayList<LoaiTaiKhoan> listLoaiTK = new ArrayList<LoaiTaiKhoan>();
        String sql = "select * from LoaiTaiKhoan";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    LoaiTaiKhoan s = new LoaiTaiKhoan();
                    s.setMaLoaiTaiKhoan(rs.getString("MaLoaiTaiKhoan"));
                    s.setTenLoaiTaiKhoan(rs.getString("TenLoaiTaiKhoan"));
                    listLoaiTK.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listLoaiTK;
    }

    public TaiKhoan getTTTK(String TKCanTim) {
        String sql = "select * from TaiKhoan where TenTaiKhoan=?";
        TaiKhoan tk = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, TKCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    tk = new TaiKhoan();
                    tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                    tk.setMatKhau(rs.getString("MatKhau"));
                    tk.setMaLoaiTaiKhoan(rs.getString("MaLoaiTaiKhoan"));
                    tk.setCMND(rs.getString("CMND"));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
    public DefaultListModel getJListTramTrongTuyen(String maTuyen,String thoiGianHieuChinh) {
        String sql = 
        "select * from TuyenDiQuaTram where MaTuyen=? and ThoiGianHieuChinh=? order by STT asc";
        DefaultListModel listTram = new DefaultListModel();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTuyen);
            ps.setString(2, thoiGianHieuChinh);
           ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    listTram.addElement(rs.getString("TenTram"));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTram;
    }
    public DefaultListModel getJListTramChuaThem(String maTuyen, String thoiGianHieuChinh ) {
        String sql = 
        "select TenTram from Tram where TenTram not in \n" +
        "(select TenTram from TuyenDiQuaTram where MaTuyen=? and ThoiGianHieuChinh=?)";
        DefaultListModel listTram = new DefaultListModel();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTuyen);
            ps.setString(2, thoiGianHieuChinh);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    listTram.addElement(rs.getString("TenTram"));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTram;
    }

    public TaiKhoan dangNhap(String TKCanTim, String MKCanTim) {   //Lấy thông tin tài khoản sẵn dùng để check xem tài khoản có trong CSDL không?
        String sql = "select * from TaiKhoan where TenTaiKhoan=? and MatKhau=?";
        TaiKhoan tk = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, TKCanTim);
            ps.setString(2, MKCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    tk = new TaiKhoan();
                    tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                    tk.setMatKhau(rs.getString("MatKhau"));
                    tk.setMaLoaiTaiKhoan(rs.getString("MaLoaiTaiKhoan"));
                    tk.setCMND(rs.getString("CMND"));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    
    public boolean addNguoiDungForTaiKhoan(LopKetNoi ketNoiCSDL,NguoiDung nguoiDung) {
            //Nếu SDT và Email cùng rỗng
            boolean trangThai=false;
            if (nguoiDung.getEmail().equals("") && nguoiDung.getSDT().equals(""))
            {
                trangThai=ketNoiCSDL.update("insert into NguoiDung(CMND,Ten) values(?,?)",nguoiDung.getCMND(),nguoiDung.getTen());
            }
            else
            {
                //Nếu Chỉ có SĐT rỗng
                if (nguoiDung.getSDT().equals("")&&(!nguoiDung.getEmail().equals("")))
                {
                    trangThai=ketNoiCSDL.update("insert into NguoiDung(CMND,Ten,Email) values(?,?,?)",nguoiDung.getCMND(),nguoiDung.getTen(), nguoiDung.getEmail());
                }
                else
                {
                    //Nếu chỉ có email rỗng
                    if (nguoiDung.getEmail().equals("")&&(!nguoiDung.getSDT().equals("")))
                    {
                        trangThai=ketNoiCSDL.update("insert into NguoiDung(CMND,Ten,SDT) values(?,?,?)",nguoiDung.getCMND(),nguoiDung.getTen(), nguoiDung.getSDT());
                    }
                    else
                    {
                        trangThai=ketNoiCSDL.update("insert into NguoiDung(CMND,Ten,SDT,Email) values(?,?,?,?)",nguoiDung.getCMND(),nguoiDung.getTen(), nguoiDung.getSDT(),nguoiDung.getEmail());
                    }
                }
                
            }
            return trangThai;
    }
    public boolean addTuyenDiQuaTram(TuyenDiQuaTram s,Timestamp tsThoiGianHieuChinh) {
        String sql = "insert into TuyenDiQuaTram(MaTuyen,TenTram,ThoiGianHieuChinh,STT) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getMaTuyen());
            ps.setNString(2, s.getTenTram());
            ps.setTimestamp(3, tsThoiGianHieuChinh);
            ps.setInt(4, s.getSTT());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteTuyenDiQuaTram(Tuyen s) {
        String sql = "DELETE FROM TuyenDiQuaTram WHERE MaTuyen=? and ThoiGianHieuChinh=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getMaTuyen());
            ps.setTimestamp(2, s.getThoiGianHieuChinh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Xoá Tuyến đi qua trạm thành công");
            e.printStackTrace();
        }
        return false;
    }

    public NguoiDung getThongTinNguoiDung(String CMND) {
        String sql = "select * from NguoiDung where CMND=?";
        NguoiDung nguoiDung = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, CMND);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    nguoiDung = new NguoiDung();
                    nguoiDung.setCMND(rs.getString("CMND"));
                    nguoiDung.setSDT(rs.getString("SDT"));
                    nguoiDung.setTen(rs.getString("Ten"));
                    nguoiDung.setEmail(rs.getString("Email"));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nguoiDung;
    }

    public boolean addTaiKhoan(TaiKhoan s) {
        String sql = "insert into TaiKhoan(TenTaiKhoan,MatKhau,CMND,MaLoaiTaiKhoan) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getTenTaiKhoan());
            ps.setString(2, s.getMatKhau());
            ps.setString(3, s.getCMND());
            ps.setString(4,s.getMaLoaiTaiKhoan());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void ketNoi() {
        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau2";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopKetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet select(String sql, Object... args) {
        //ketNoi();
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }

    public static boolean update(String sql, Object... args) {
        //ketNoi();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("xoa khong thanh cong");
            return false; // khóa bị trùng khi thêm , còn sửa và xóa thì chắc là không lỗi đâu
        }
        return true;
    }

    public boolean updateMatKhau(TaiKhoan s) //y nghia: update mat khau cua tai khoan nay!
    {
        String sql = "update TaiKhoan set MatKhau=? where TenTaiKhoan=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getMatKhau());
            ps.setString(2, s.getTenTaiKhoan());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNguoiDung(NguoiDung s) {
        String sql = "update NguoiDung set SDT=?, Ten=?, Email=? where CMND=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getSDT());
            ps.setString(2, s.getTen());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getCMND());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Tram> getDSTram() {
        ArrayList<Tram> listTram = new ArrayList<Tram>();
        String sql = "select * from Tram";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    Tram s = new Tram();
                    s.setTenTram(rs.getString("TenTram"));
                    s.setDiaChi(rs.getString("DiaChi"));
                    listTram.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTram;
    }
    public ArrayList<TuyenDiQuaTram[]> getTuyenPhuHop(String tenTramDi, String tenTramDen) {     //Hàm lấy danh sách mã tuyến phù hợp với yêu cầu trạm đi và trạm đến
        ArrayList<TuyenDiQuaTram[]> listTuyen = new ArrayList<TuyenDiQuaTram[]>();
String sql = 
"select table1.MaTuyen, table1.TenTram as TenTramDi, table1.STT as STTDi, table1.ThoiGianThemTram as ThoiGianThemTramDi,\n" +
" table2.TenTram as TenTramDen, table2.STT as STTDen, table2.ThoiGianThemTram as ThoiGianThemTramDen from TuyenDiQuaTram as table1\n" +
"join TuyenDiQuaTram as table2\n" +
"on  table1.MaTuyen=table2.MaTuyen and table1.TenTram=? and table2.TenTram=? and table1.STT<table2.STT and \n" +
"table1.ThoiGianThemTram=(select MAX(table3.ThoiGianThemTram) from TuyenDiQuaTram as table3\n" +
"where table3.MaTuyen=table1.MaTuyen and TenTram=table1.TenTram)and\n" +
"table2.ThoiGianThemTram=(select MAX(table3.ThoiGianThemTram) from TuyenDiQuaTram as table3\n" +
"where table3.MaTuyen=table2.MaTuyen and table3.TenTram=table2.TenTram);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, tenTramDi);
            ps.setNString(2, tenTramDen);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    TuyenDiQuaTram s[]=new TuyenDiQuaTram[2];
                    s[0]=new TuyenDiQuaTram();
                    s[0].setMaTuyen(rs.getString("MaTuyen"));
                    s[0].setTenTram(rs.getString("TenTramDi"));
                    s[0].setSTT(rs.getInt("STTDi"));
                    //s[0].setThoiGianThemTram(rs.getTimestamp("ThoiGianThemTramDi"));
                    s[1]=new TuyenDiQuaTram();
                    s[1].setSTT(rs.getInt("STTDen"));
                    //s[1].setThoiGianThemTram(rs.getTimestamp("ThoiGianThemTramDen"));
                    s[1].setTenTram(rs.getString("TenTramDen"));
                    listTuyen.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listTuyen;
    }
    public ArrayList<TauChayTuyen> getTauTheoMaTuyen(String maTuyen,String ngayDi) {     //Hàm lấy danh sách tàu theo mã tuyến
        ArrayList<TauChayTuyen> listTau = new ArrayList<TauChayTuyen>();
        String sql = "select * from TauChayTuyen where MaTuyen=? and ThoiGianDen > ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTuyen);
            ps.setString(2, ngayDi);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    TauChayTuyen s=new TauChayTuyen();
                    s.setMaTau(rs.getString("MaTau"));
                    s.setThoiGianKhoiHanh(rs.getTimestamp("ThoiGianKhoiHanh"));
                    s.setMaTuyen(maTuyen);
                    listTau.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listTau;
    }
    public TauChayTuyen getTauPhuHop(TuyenDiQuaTram[] s,String maTau, Timestamp thoiGianTauXuatPhat, String ngayCanTim) {     //Hàm lấy danh sách tàu theo mã tuyến
        TauChayTuyen thongTinTauPhuHop=null;
        String sql = "select * from [dbo].[tinhTauTuyenThoiGianTheoYeuCau](?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s[0].getMaTuyen());
            ps.setInt(2, s[0].getSTT());//STT của Trạm Đi
            ps.setInt(3, s[1].getSTT());//STT của Trạm Đến
            ps.setString(4, maTau);
            ps.setTimestamp(5, thoiGianTauXuatPhat);
            ps.setString(6, ngayCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    thongTinTauPhuHop = new TauChayTuyen();
                    thongTinTauPhuHop.setMaTau(rs.getString("MaTau"));
                    thongTinTauPhuHop.setMaTuyen(rs.getString("MaTuyen"));
                    thongTinTauPhuHop.setThoiGianDenTramDi(rs.getTimestamp("ThoiGianTauXuatPhat"));//Thời gian tàu đi từ trạm mà khách chọn
                    thongTinTauPhuHop.setThoiGianDen(rs.getTimestamp("ThoiGianTauDenDich"));//Thời gian tàu đến đích mà khách chọn
                    thongTinTauPhuHop.setThoiGianKhoiHanh(thoiGianTauXuatPhat);//Thời tàu đi từ trạm đầu tiên
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return thongTinTauPhuHop;
    }
    public int getCurrentIndexByAutoIncrement(String tenBang) {//Hàm lấy mã chuyến được đánh tự động mà vừa thêm vào
        int currentIndex=0;
        String sql = "SELECT IDENT_CURRENT(?) as MaChuyenVuaThem";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenBang);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    currentIndex=rs.getInt("MaChuyenVuaThem");
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return currentIndex;
    }
    
    public ArrayList<Toa> getToaTheoMaTau(String maTau) {     //Hàm lấy danh sách Toa theo mã Tàu
        ArrayList<Toa> listToa = new ArrayList<Toa>();
        String sql = 
"select * from Toa as table1\n" +
"join ToaThuocTau as table2\n" +
"on table1.MaToa=table2.MaToa and table2.MaTau=? and table2.ThoiGian = (select MAX(ThoiGian) from ToaThuocTau where MaToa=table1.MaToa and MaTau=table2.MaTau)\n" +
"join LoaiToa as table3\n" +
"on table1.MaLoaiToa=table3.MaLoaiToa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTau);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    Toa s=new Toa();
                    s.setMaToa(rs.getString("MaToa"));
                    s.setMaLoaiToa(rs.getString("MaLoaiToa"));
                    s.setSoChoNgoi(rs.getInt("SoChoNgoi"));
                    s.setGiaChoNgoi(rs.getInt("GiaChoNgoi"));
                    s.setThoiGianThemToa(rs.getTimestamp("ThoiGian"));
                    listToa.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listToa;
    }
    public ArrayList<Integer> getChoNgoiDaDat(String maTau,Timestamp thoiGianKhoiHanh, String maToa, Timestamp thoiGianThemToa) {     //Hàm lấy danh sách Chỗ ngồi đã đặt trong toa
        ArrayList<Integer> listChoNgoiDaDat = new ArrayList<Integer>();
        String sql = "select ChoNgoi from Ve where MaChuyen in (select MaChuyen from ChuyenDi where MaTau=? and ThoiGianKhoiHanh=? and MaToa=? and ThoiGianThemToa=?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTau);
            ps.setTimestamp(2, thoiGianKhoiHanh);
            ps.setString(3, maToa);
            ps.setTimestamp(4, thoiGianThemToa);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    listChoNgoiDaDat.add(rs.getInt("ChoNgoi"));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        sql = "select ChoNgoi_ChieuVe from Ve_KhuHoi where MaChuyen_ChieuVe in (select MaChuyen from ChuyenDi where MaTau=? and ThoiGianKhoiHanh=? and MaToa=? and ThoiGianThemToa=?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTau);
            ps.setTimestamp(2, thoiGianKhoiHanh);
            ps.setString(3, maToa);
            ps.setTimestamp(4, thoiGianThemToa);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    listChoNgoiDaDat.add(rs.getInt("ChoNgoi_ChieuVe"));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChoNgoiDaDat;
    }
    public int addVe(String soDinhDanh,int choNgoi,Timestamp thoiGianLenTau, Timestamp thoiGianDen,float gia, boolean khuHoi,int maChuyen,String tenLoaiVe,String tenTaiKhoan, String hoTenNguoiNgoi) {
        String sql = "insert into Ve(SoDinhDanh, ChoNgoi, ThoiGianLenTau, ThoiGianDen, Gia, KhuHoi,MaChuyen,TenLoaiVe, tenTaiKhoan, hoTenNguoiNgoi) values(?,?,?,?,?,?,?,?,?,?)";
        int maVeVuaThem=-1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, soDinhDanh);
            ps.setInt(2, choNgoi);
            ps.setTimestamp(3, thoiGianLenTau);
            ps.setTimestamp(4, thoiGianDen);
            ps.setFloat(5, gia);
            ps.setBoolean(6, khuHoi);
            ps.setInt(7, maChuyen);
            ps.setString(8, tenLoaiVe);
            ps.setString(9, tenTaiKhoan);
            ps.setString(10, hoTenNguoiNgoi);
            ps.executeUpdate();
            String sql3 = "SELECT IDENT_CURRENT('Ve') as MaVeVuaThem";
            try {
                PreparedStatement ps3 = connection.prepareStatement(sql3);            
                ResultSet rs = ps3.executeQuery();
                while (true) {
                    if (rs.next()) {
                        maVeVuaThem=rs.getInt("MaVeVuaThem");
                    } else {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            if (e.getMessage().equals("Arithmetic overflow error converting IDENTITY to data type int."))
            {
                String sql2 = "DBCC CHECKIDENT (Ve, RESEED, 0)";//reset lại mã vé
                try {
                    PreparedStatement ps2 = connection.prepareStatement(sql2);
                    ps2.executeUpdate();
                    maVeVuaThem=addVe(soDinhDanh,choNgoi,thoiGianLenTau, thoiGianDen,gia, khuHoi,maChuyen,tenLoaiVe,tenTaiKhoan,hoTenNguoiNgoi);
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return maVeVuaThem;
    }
    public boolean addVeKhuHoi(int maVeKhuHoi,Timestamp thoiGianLenTauChieuVe, Timestamp thoiGianDenChieuVe,int choNgoi,int maVe_ChieuDi,Timestamp thoiGianLenTau_ChieuDi,int maChuyen,float gia) {
        String sql = "insert into Ve_KhuHoi(MaVeKhuHoi, ThoiGianLenTau_ChieuVe, ThoiGianDen_ChieuVe, ChoNgoi_ChieuVe,  MaVe_ChieuDi,ThoiGianLenTau_ChieuDi,MaChuyen_ChieuVe,Gia) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maVeKhuHoi);
            ps.setTimestamp(2, thoiGianLenTauChieuVe);
            ps.setTimestamp(3, thoiGianDenChieuVe);
            ps.setInt(4, choNgoi);
            ps.setInt(5, maVe_ChieuDi);
            ps.setTimestamp(6, thoiGianLenTau_ChieuDi);
            ps.setInt(7, maChuyen);
            ps.setFloat(8, gia);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int addChuyenDi(String maTuyen,String tenTramDi,Timestamp thoiGianThemTramDi,String tenTramDen, Timestamp thoiGianThemTramDen,String maTau, Timestamp thoiGianKhoiHanh, String maToa, Timestamp thoiGianThemToa) {
        int maChuyenLamKhoaNgoai=-1;
        //Tìm thử Chuyến đi đã tồn tại chưa
        String sql1 = "select MaChuyen from ChuyenDi where MaTuyen=? and TenTramDi=? and ThoiGianThemTramDi=? and TenTramDen=? and ThoiGianThemTramDen=? and MaTau=? and ThoiGianKhoiHanh=? and MaToa=? and ThoiGianThemToa=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setString(1, maTuyen);
            ps.setNString(2, tenTramDi);
            ps.setTimestamp(3, thoiGianThemTramDi);
            ps.setNString(4, tenTramDen);
            ps.setTimestamp(5, thoiGianThemTramDen);
            ps.setString(6, maTau);
            ps.setTimestamp(7, thoiGianKhoiHanh);
            ps.setString(8, maToa);
            ps.setTimestamp(9, thoiGianThemToa);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {                    
                    maChuyenLamKhoaNgoai=rs.getInt("MaChuyen");
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //nếu chưa thì thêm chuyến mới
        if (maChuyenLamKhoaNgoai==-1)
        {
            String sql2 = "insert into ChuyenDi(MaTuyen, tenTramDi, ThoiGianThemTramDi, tenTramDen, ThoiGianThemTramDen, MaTau, ThoiGianKhoiHanh, MaToa, ThoiGianThemToa) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql2);
            ps.setString(1, maTuyen);
            ps.setNString(2, tenTramDi);
            ps.setTimestamp(3, thoiGianThemTramDi);
            ps.setNString(4, tenTramDen);
            ps.setTimestamp(5, thoiGianThemTramDen);
            ps.setString(6, maTau);
            ps.setTimestamp(7, thoiGianKhoiHanh);
            ps.setString(8, maToa);
            ps.setTimestamp(9, thoiGianThemToa);
            ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql3 = "SELECT IDENT_CURRENT('ChuyenDi') as MaChuyenVuaThem";
        try {
            PreparedStatement ps = connection.prepareStatement(sql3);            
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    maChuyenLamKhoaNgoai=rs.getInt("MaChuyenVuaThem");
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        }
        //nếu Chuyến đi đã tồn tại thì lấy Mã chuyến cũ
        //ngược lại thì tạo Chuyến đi mới và Mã chuyến mới
        return maChuyenLamKhoaNgoai;
    }    
}
