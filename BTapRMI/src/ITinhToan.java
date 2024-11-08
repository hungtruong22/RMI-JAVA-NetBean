
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
    public int[] CongMT (int[] a, int[] b, int len) throws RemoteException;
    public int[][] NhanMT (int[][] a, int[][] b, int hanga, int cota, int hangb, int cotb) throws RemoteException;
}
