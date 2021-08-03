/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

/**
 *
 * @author Tuong
 */
public class CheckInPut {
    public static boolean checkCMND(String cmnd)
    {
        if (cmnd.matches("\\d{9}")
                || cmnd.matches("\\d{12}")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkSDT(String sdt)
    {
        if (sdt.matches("^0[0-9]{9}")
                || sdt.matches("^0[0-9]{10}")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkTenVietNam(String ten)
    {
        return ten.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ\\s]{1,50}");
    }
    public static boolean checkTenTuyen(String tenTuyen)
    {
        return tenTuyen.matches("[-aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ\\s]{1,50}");
    }
    public static boolean checkEmail(String email)
    {
        if (!(email.matches("^[a-zA-Z0-9_]{5,32}@[a-zA-Z0-9]{2,10}(\\.[a-z0-9]{2,10}){1,5}$"))) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkTenTaiKhoan(String tenTaiKhoan)
    {
        if (!(tenTaiKhoan.matches("^[a-zA-Z0-9_]{5,50}$"))) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkCacLoaiMa(String ma)
    {
        return ma.matches("^[\\w-]{1,}");
    }
    public static String chuanHoaTen(String ten)
    {
        ten=ten.toLowerCase();
        String[] tungTuTrongTen=ten.split("[\\s]+");
        ten="";
        for (int i=0;i<tungTuTrongTen.length;i++)
        {
            String phanChuThuong=tungTuTrongTen[i].substring(1);
            tungTuTrongTen[i]=tungTuTrongTen[i].substring(0,1).toUpperCase();//chữ cái đầu in hoa
            if (i==tungTuTrongTen.length-1)
            {
                ten=ten+tungTuTrongTen[i]+phanChuThuong;
            }
            else
            {
                ten=ten+tungTuTrongTen[i]+phanChuThuong+" ";
            }
        }
        return ten;
    }
}
