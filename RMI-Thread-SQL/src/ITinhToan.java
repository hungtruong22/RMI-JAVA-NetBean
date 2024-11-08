
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
    public ArrayList GetSv() throws RemoteException;
    public ArrayList TimSv(String hoten) throws RemoteException;
}
