
import java.rmi.Naming;
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
            //Quang ba doi tuong tt de may khach co the goi phuong thuc trong tt
            UnicastRemoteObject.exportObject(tt);
            //Dang ky 1 dia chi de may khach truy cap vao doi tuong tt
            Naming.bind("rmi://localhost/TinhToan",tt);
            System.out.print("Da cho may khach goi den:\n");
        } catch (Exception e) {
            System.out.print(e);    
        }
    }
}
