
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class TinhToan extends UnicastRemoteObject implements ITinhToan{

    public TinhToan() throws RemoteException {
    }

    @Override
    public ArrayList GetSv() throws RemoteException {
        try {
            ArrayList ds = new ArrayList();//Tạo 1 ArrayList để chứa các sinh viên
            CoSo.MoKetNoi();//Mở kết nối đến CSDL
            ResultSet rs = CoSo.LayBang("SinhVien");//Lấy về toàn bộ bảng SinhVien
            while (rs.next())//Duyệt ResultSet để lưu sv vào ArrayList
            {
                SinhVien sv = new SinhVien(rs.getString("MaSv"), rs.getString("HoTen"),
                        Double.parseDouble(rs.getString("DTB")));
                ds.add(sv);
            }
            CoSo.cn.close();
            return ds;
        } catch (Exception tt) {
            System.out.print("so bi loi" + tt);
            return null;
        }
    }

    @Override
    public ArrayList TimSv(String hoten) throws RemoteException {
        try {
            ArrayList ds = new ArrayList();
            CoSo.MoKetNoi();
            ResultSet rs = CoSo.LayBang("SinhVien");
            while (rs.next()) {
                if (rs.getString("hoten").indexOf(hoten) >= 0)//nếu thỏa mãn điều kiện
                {
                    SinhVien sv = new SinhVien(rs.getString("MaSv"), rs.getString("HoTen"),
                            rs.getDouble("DTB"));
                    ds.add(sv);
                }
            }
            CoSo.cn.close();
            return ds;
        } catch (Exception tt) {
            System.out.print(tt);
            return null;
        }
    }
    
    public static void main(String [] arg) throws RemoteException{
        TinhToan t = new TinhToan();
        System.out.println(t.TimSv("Truong Minh Hung"));
    }
}
