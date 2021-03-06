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
import module.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LopKetNoi {

    private static Connection connection;

    public LopKetNoi() {

        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau5";
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

    public ResultSet selectLike(String sql, String... args) {
        ResultSet rs=null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setNString(i + 1, args[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
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
    @SuppressWarnings("unchecked")
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

    public TaiKhoan dangNhap(String TKCanTim, String MKCanTim) {   //L???y th??ng tin t??i kho???n s???n d??ng ????? check xem t??i kho???n c?? trong CSDL kh??ng?
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
            //N???u SDT v?? Email c??ng r???ng
            boolean trangThai=false;
            trangThai=ketNoiCSDL.update("insert into NguoiDung(CMND,Ten,SDT,Email,TenTaiKhoan) values(?,?,?,?,?)",nguoiDung.getCMND(),nguoiDung.getTen(), nguoiDung.getSDT(),nguoiDung.getEmail(),nguoiDung.getTenTaiKhoan());
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
            System.out.println("Xo?? Tuy???n ??i qua tr???m th??nh c??ng");
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
        String url = "jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;databaseName=QuanLiVeTau5";
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
            e.printStackTrace();
            return false; // kh??a b??? tr??ng khi th??m , c??n s???a v?? x??a th?? ch???c l?? kh??ng l???i ????u
            
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
        String sql = "select * from Tram order by TenTram asc";
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
    public ArrayList<TuyenDiQuaTram[]> getTuyenPhuHop(String tenTramDi, String tenTramDen) {     //H??m l???y danh s??ch m?? tuy???n ph?? h???p v???i y??u c???u tr???m ??i v?? tr???m ?????n
        ArrayList<TuyenDiQuaTram[]> listTuyen = new ArrayList<TuyenDiQuaTram[]>();
String sql = 
"select table1.MaTuyen, table1.TenTram as TenTramDi, table1.STT as STTDi, table1.ThoiGianHieuChinh,\n" +
"table2.TenTram as TenTramDen, table2.STT as STTDen from TuyenDiQuaTram as table1\n" +
"join TuyenDiQuaTram as table2\n" +
"on  table1.MaTuyen=table2.MaTuyen and table1.TenTram=? and table2.TenTram=? and table1.STT<table2.STT\n" +
"and table1.ThoiGianHieuChinh=table2.ThoiGianHieuChinh;";
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
                    s[0].setThoiGianHieuChinh(rs.getTimestamp("ThoiGianHieuChinh"));
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
    public ArrayList<TauChayTuyen> getTauTheoMaTuyen(String maTuyen,String ngayDi, java.sql.Timestamp thoiGianHieuChinhTuyen) {     //H??m l???y danh s??ch t??u theo m?? tuy???n
        ArrayList<TauChayTuyen> listTau = new ArrayList<TauChayTuyen>();
        String sql = "select * from TauChayTuyen where MaTuyen=? and ThoiGianDen > ? and ThoiGianHieuChinh=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTuyen);
            ps.setString(2, ngayDi);
            ps.setTimestamp(3, thoiGianHieuChinhTuyen);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    TauChayTuyen s=new TauChayTuyen();
                    s.setMaTau(rs.getString("MaTau"));
                    s.setThoiGianHieuChinhTau(rs.getTimestamp("ThoiGianHieuChinhTau"));
                    s.setMaTuyen(maTuyen);
                    s.setThoiGianHieuChinhTuyen(rs.getTimestamp("ThoiGianHieuChinh"));
                    s.setThoiGianKhoiHanh(rs.getTimestamp("ThoiGianKhoiHanh"));
                    s.setThoiGianDen(rs.getTimestamp("ThoiGianDen"));
                    listTau.add(s);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return listTau;
    }
    public TauChayTuyen getTauPhuHop(TuyenDiQuaTram[] s,String maTau, Timestamp thoiGianTauXuatPhat, String ngayCanTim, Timestamp thoiGianHieuChinhTau) {     //H??m l???y danh s??ch t??u theo m?? tuy???n
        TauChayTuyen thongTinTauPhuHop=null;
        String sql = "select * from [dbo].[tinhTauTuyenThoiGianTheoYeuCau](?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s[0].getMaTuyen());
            ps.setInt(2, s[0].getSTT());//STT c???a Tr???m ??i
            ps.setInt(3, s[1].getSTT());//STT c???a Tr???m ?????n
            ps.setString(4, maTau);
            ps.setTimestamp(5, thoiGianTauXuatPhat);
            ps.setTimestamp(6, s[0].getThoiGianHieuChinh());
            ps.setString(7, ngayCanTim);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    thongTinTauPhuHop = new TauChayTuyen();
                    thongTinTauPhuHop.setMaTau(rs.getString("MaTau"));
                    thongTinTauPhuHop.setMaTuyen(rs.getString("MaTuyen"));
                    thongTinTauPhuHop.setThoiGianHieuChinhTuyen(rs.getTimestamp("ThoiGianHieuChinhTuyen"));
                    thongTinTauPhuHop.setThoiGianDenTramDi(rs.getTimestamp("ThoiGianTauXuatPhat"));//Th???i gian t??u ??i t??? tr???m m?? kh??ch ch???n
                    thongTinTauPhuHop.setThoiGianDen(rs.getTimestamp("ThoiGianTauDenDich"));//Th???i gian t??u ?????n ????ch m?? kh??ch ch???n
                    thongTinTauPhuHop.setThoiGianKhoiHanh(thoiGianTauXuatPhat);//Th???i t??u ??i t??? tr???m ?????u ti??n
                    thongTinTauPhuHop.setThoiGianHieuChinhTau(thoiGianHieuChinhTau);
                } else {
                    break;
                }
            }

        } catch (Exception e) {
        }
        return thongTinTauPhuHop;
    }
    public int getCurrentIndexByAutoIncrement(String tenBang) {//H??m l???y m?? chuy???n ???????c ????nh t??? ?????ng m?? v???a th??m v??o
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
    
    public ArrayList<Toa> getToaTheoMaTau(String maTau, java.sql.Timestamp thoiGianHieuChinhTau) {     //H??m l???y danh s??ch Toa theo m?? T??u
        ArrayList<Toa> listToa = new ArrayList<Toa>();
        String sql = 
"select * from Toa as table1\n" +
"join ToaThuocTau as table2\n" +
"on table1.MaToa=table2.MaToa and table2.MaTau=? and table2.ThoiGianHieuChinhTau = ? " +
"join LoaiToa as table3\n" +
"on table1.MaLoaiToa=table3.MaLoaiToa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTau);
            ps.setTimestamp(2, thoiGianHieuChinhTau);
            ResultSet rs = ps.executeQuery();
            while (true) {
                if (rs.next()) {
                    Toa s=new Toa();
                    s.setMaToa(rs.getString("MaToa"));
                    s.setMaLoaiToa(rs.getString("MaLoaiToa"));
                    s.setTenLoaiToa(rs.getString("TenLoaiToa"));
                    s.setSoChoNgoi(rs.getInt("SoChoNgoi"));
                    s.setGiaChoNgoi(rs.getInt("GiaChoNgoi"));
                    s.setThoiGianHieuChinhTau(rs.getTimestamp("ThoiGianHieuChinhTau"));
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
    public ArrayList<Integer> getChoNgoiDaDat(String maTau,Timestamp thoiGianKhoiHanh, String maToa, Timestamp thoiGianHieuChinh, Timestamp thoiGianHieuChinhTau, String maTuyen) {     //H??m l???y danh s??ch Ch??? ng???i ???? ?????t trong toa
        ArrayList<Integer> listChoNgoiDaDat = new ArrayList<Integer>();
        String sql = "select ChoNgoi from Ve where MaChuyen \n" +
"in (select MaChuyen from ChuyenDi where MaToa=? and ID_TCT in \n" +
"(select ID_TCT from TauChayTuyen where MaTau=? and ThoiGianHieuChinhTau=?\n" +
"and MaTuyen=? and ThoiGianHieuChinh=? and ThoiGianKhoiHanh=?))";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maToa);
            ps.setString(2, maTau);
            ps.setTimestamp(3, thoiGianHieuChinhTau);
            ps.setString(4, maTuyen);
            ps.setTimestamp(5, thoiGianHieuChinh);
            ps.setTimestamp(6, thoiGianKhoiHanh);
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
        sql = "select ChoNgoi_ChieuVe from Ve_KhuHoi where MaChuyen_ChieuVe in (select MaChuyen from ChuyenDi where MaToa=? and ID_TCT in \n" +
        "(select ID_TCT from TauChayTuyen where MaTau=? and ThoiGianHieuChinhTau=?\n" +
        "and MaTuyen=? and ThoiGianHieuChinh=? and ThoiGianKhoiHanh=?))";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maToa);
            ps.setString(2, maTau);
            ps.setTimestamp(3, thoiGianHieuChinhTau);
            ps.setString(4, maTuyen);
            ps.setTimestamp(5, thoiGianHieuChinh);
            ps.setTimestamp(6, thoiGianKhoiHanh);
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
                String sql2 = "DBCC CHECKIDENT (Ve, RESEED, 0)";//reset l???i m?? v??
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
    public int addChuyenDi(String tenTramDi,String tenTramDen,int ID_TCT, String maToa) {
        int maChuyenLamKhoaNgoai=-1;
        //T??m th??? Chuy???n ??i ???? t???n t???i ch??a
        String sql1 = "select MaChuyen from ChuyenDi where TenTramDi=? and TenTramDen=? and MaToa=? \n" +
            "and ID_TCT=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setNString(1, tenTramDi);
            ps.setNString(2, tenTramDen);
            ps.setString(3, maToa);
            ps.setInt(4, ID_TCT);
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
        //n???u ch??a th?? th??m chuy???n m???i
        if (maChuyenLamKhoaNgoai==-1)
        {
            String sql2 = "insert into ChuyenDi(TenTramDi,TenTramDen, ID_TCT, MaToa) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql2);
            ps.setNString(1, tenTramDi);
            ps.setNString(2, tenTramDen);
            ps.setInt(3, ID_TCT);
            ps.setString(4, maToa);
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
        //n???u Chuy???n ??i ???? t???n t???i th?? l???y M?? chuy???n c??
        //ng?????c l???i th?? t???o Chuy???n ??i m???i v?? M?? chuy???n m???i
        return maChuyenLamKhoaNgoai;
    }    
}
