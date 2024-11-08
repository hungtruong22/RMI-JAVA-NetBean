
import java.rmi.Naming;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class myClient {
    public static void xuat(int[] a, int len){
        for(int i=0;i<len;i++)
        System.out.print("TONG :" + a[i]+" ") ;
        System.out.println();
    }
    
    public static void xuatmtran(int[][] c, int len){
        for(int i = 0; i < len; i++){
            for(int j = 0 ; j < len; j++){
                System.out.print("\nhang["+i+"]"+ "cot["+j+"]= " + c[i][j] + " ");
            }
        }
    }
    public static void main(String [] args){
        try {
            ITinhToan tt= (ITinhToan)Naming.lookup("rmi://localhost/TinhToan");
            Random r = new Random();
            int len = 3;
            int[] a = new int[len];
            int[] b = new int[len];
            for(int i=0;i<len;i++){//Tạo 2 mảng nhẫu nhiên
                a[i]=r.nextInt(100);
                b[i]=r.nextInt(100);
            }
            
            int[][] mta = new int[len][len];
            int[][] mtb = new int[len][len];
            
            for(int i = 0 ; i < len; i++){
                for(int j = 0; j < len; j++){
                    mta[i][j] = r.nextInt(10);
                    mtb[i][j] = r.nextInt(10);
                }
            }
            System.out.println("\nMang a: ");
            xuat(a,len);//Xuất mảng a
            System.out.println("\nMang b: ");
            xuat(b,len);//Xuất mảng b
            int[] c=tt.CongMT(a,b,len);
            System.out.println("\nMang c: ");
            xuat(c, len);// Xuat mang sau khi cong
            
            int[][] mtc = tt.NhanMT(mta, mtb, len, len, len, len);
            System.out.println("\nMTA: ");
            xuatmtran(mta, len);
            System.out.println("\nMTA: ");
            xuatmtran(mtb, len);
            System.out.println("\nMTKQ: ");
            xuatmtran(mtc, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
