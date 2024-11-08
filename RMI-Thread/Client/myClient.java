
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
    public static Thread[] td = new Thread[2] ;//Tạo 2 tuyến đoạn
    public static int somay = 2;//Số Server tham gia tính toán
    public static int len = 6;//Chieu dai cua 2 mang a va b
    public static int[] a = new int[len];//Tạo ra mảng a
    public static int[] b = new int[len];//Tạo ra mảng b
    public static int[][] mta = new int[len][len];
    public static int[][] mtb = new int[len][len];
     //Xây dựng hàm xuất trong lớp Client để xuất ra giá trị của ma trận nào đó
    public static void xuat(int[] a){
        for(int i=0;i<a.length ;i++)
        System.out.print("\nMT: " + a[i] + " ");
        System.out.println();
    }
    public static void xuatmtran(int[][] c){
        for(int i = 0; i < c.length; i++){
            for(int j = 0 ; j < c.length; j++){
                System.out.print("\nhang["+i+"]"+ "cot["+j+"]= " + c[i][j] + " ");
            }
        }
    }
    public static class Xuly extends Thread{//Tao ra 1 lop con de xu ly dong thoi
        int i;
        public Xuly(int i) {
            this.i = i;//i là tuyến đoạn I cần tính
        }
        public void run() {//Tự động chạy khi tuyến đoạn bắt đầu
            try {//dò tìm Server ip[i]]
                ITinhToan tt= (ITinhToan)Naming.lookup("rmi://localhost/TinhToan");
//                System.out.println("Server:" + ip[i] + " dang tinh toan: ");
                  System.out.println("\nDang tinh toan");
                if (i == 0) {//Nếu tuyến đoạn I làm làm việc
                xuat(tt.cong(a, b, 0,len/2-1));//Xuất ma trận kết quả: ½ ma trận đầu
                xuatmtran(tt.NhanMT(mta, mtb, 0, len/2-1, len/2-1, 0));
//                System.out.println("Server:" + ip[i] + " da tinh toan ");
                  System.out.println("\nDa tinh toan tuyen 1");
                td[0].stop() ;//Kết thúc tuyến đoạn 0
                }
                else//Tuyến đoạn 1 đang làm việc
                {
                xuat(tt.cong(a, b, len/2, len-1));// Xuất ma trận kết quả: ½ ma trận cuối
                xuatmtran(tt.NhanMT(mta, mtb, len/2, len-1, len-1, len/2));
//                System.out.println("Server:" + ip[i] + " da tinh toan ");
                  System.out.println("\nDa tinh toan tuyen 2");
                td[1].stop(); //Kết thúc tuyến đoạn 1
                }
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }//Kết thúc run()
    }//Kết thúc lớp xử lý
   
    //Hàm main của lớp Client
    public static void main(String[] st){
        try{
            Random r=new Random();//Lấy ngẫu nhiên 2 ma trận a và b
            for(int i=0;i<len;i++)
            {
                a[i]=r.nextInt(100);
                b[i]=r.nextInt(100);
            }
            
            System.out.println("\nMANG a: ");
            xuat(a);
            System.out.println("\nMANG b: ");
            xuat(b);
            for(int i = 0 ; i < len; i++){
                for(int j = 0; j < len; j++){
                    mta[i][j] = r.nextInt(10);
                    mtb[i][j] = r.nextInt(10);
                }
            }
            System.out.println("\nMTRAN a: ");
            xuatmtran(mta);
            System.out.println("\nMTRAN b: ");
            xuatmtran(mtb);
            for(int i=0;i<somay;i++)//Kich hoat dong thoi 2 tuyen doan
            {
            td[i]= new Xuly(i) ;            
            td[i].start();//Kích hoạt tuyến đoạn i
            }
        }catch(Exception e){ 
            e.printStackTrace();}
        }
}
//18 20 23 68 72