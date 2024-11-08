
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class myServer {
    public static void main(String [] args){
        try {
            TinhToan tt = new TinhToan();
            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://192.168.2.13/TinhToan", tt);
            System.out.print("Dang cho Client yeu cau: ");
        } catch (Exception tt) {
            System.out.print(tt.getMessage());
        }
    }
}
