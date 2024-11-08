
import java.rmi.RemoteException;
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
public class TinhToan implements ITinhToan{

    @Override
    public int[] CongMT(int[] a, int[] b, int len) throws RemoteException {
        System.out.println("Tong 2 mang: ");
        int[] c = new int[len];
        for(int i = 0 ; i < len; i++){ // Cộng 2 ma trận a và b
            c[i] = a[i] + b[i];
        }
        for(int j = 0; j < len ; j++){ // Hien thi ma tran c
            System.out.println(c[j]+"");
        }
        return c;
    }
    
     public int[][] NhanMT (int[][] a, int[][] b, int hanga, int cota, int hangb, int cotb) throws RemoteException{
         System.out.println("Nhan 2 ma tran: ");
         if (cota != hangb) {
            System.out.println("Hai ma trận không thể nhân với nhau!");
            return null;
        }
         int[][] c = new int[hanga][hangb];
    // Tính toán ma trận kết quả
    for (int i = 0; i < hanga; i++) {
        for (int j = 0; j < hangb; j++) {
            for (int k = 0; k < cota; k++) {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    for(int i = 0; i < hanga; i++){
            for(int j = 0 ; j < cotb; j++){
                System.out.print("\nhang["+i+"]"+ "cot["+j+"]= " + c[i][j] + " ");
            }
        }
    return c;
    }
}
