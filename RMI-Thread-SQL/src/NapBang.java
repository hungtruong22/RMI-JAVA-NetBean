
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NapBang {
     public static DefaultTableModel NapDuLieuVaoBang(ArrayList ds,int socot){
            try{
                int SoCot=3;//masv, hoten va Dtb
                DefaultTableModel m= new DefaultTableModel(0,SoCot);
                Object[] t= new Object[socot];
                for(int i=0;i<ds.size() ;i++){
                    SinhVien sv=(SinhVien)ds.get(i);
                    t[0]=sv.MaSv ;
                    t[1]=sv.HoTen ;
                    t[2]=String.valueOf(sv.DTB);
                    m.addRow(t);
                }
                return m;
            }catch(Exception tt){
                System.out.print("Loi roi"+tt) ;return null;
            } 
        }
}
