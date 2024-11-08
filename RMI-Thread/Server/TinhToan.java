
import java.rmi.RemoteException;

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
    public int[] cong(int[] a, int[] b, int vtbd, int vtkt) throws RemoteException {
        System.out.println("Cong2MT: ");
        int[] c=new int[vtkt-vtbd+1];//Tạo 2 ma trậnma trận c để chứa kết quả sau khi cộng
        int j=0;
        for(int i=vtbd;i<=vtkt;i++){//Công
         c[j]=a[i]+b[i]; j=j+1; 
        }
        System.out.println("\nMa tran ket qua: ");
        for(int t=0;t<c.length ;t++){
        System.out.print("\nMANGKQ: " + c[t]+ " ");
        System.out.println();
        }
        return c;
    }
    public int[][] NhanMT (int[][] a, int[][] b, int vtbda, int vtkta, int vtbdb, int vtktb) throws RemoteException{
         System.out.println("Nhan 2 ma tran: ");
         if (vtkta != vtbdb) {
            System.out.println("Hai ma trận không thể nhân với nhau!");
            return null;
        }
         int[][] c = new int[vtbda][vtbdb];
    // Tính toán ma trận kết quả
    for (int i = 0; i < vtbda; i++) {
        for (int j = 0; j < vtbdb; j++) {
            for (int k = 0; k < vtkta; k++) {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    for(int i = 0; i < vtbda; i++){
            for(int j = 0 ; j < vtktb; j++){
                System.out.print("\nhang["+i+"]"+ "cot["+j+"]= " + c[i][j] + " ");
            }
        }
    return c;
    }
}
