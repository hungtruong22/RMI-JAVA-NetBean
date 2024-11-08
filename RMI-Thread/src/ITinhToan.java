
import java.rmi.Remote;
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
public interface ITinhToan extends Remote{
//    public SinhVien GetSv(SinhVien sv) throws RemoteException;
public int[] cong(int[] a, int[] b, int vtbd, int vtkt) throws RemoteException;
public int[][] NhanMT (int[][] a, int[][] b, int vtbda, int vtkta, int vtbdb, int vtktb) throws RemoteException;
}
