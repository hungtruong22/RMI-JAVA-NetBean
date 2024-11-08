
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class SinhVien implements Serializable{
    public String MaSv;
    public String HoTen;
    public Double DTB;

    public SinhVien() {
    }

    public SinhVien(String MaSv, String HoTen, Double DTB) {
        this.MaSv = MaSv;
        this.HoTen = HoTen;
        this.DTB = DTB;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String MaSv) {
        this.MaSv = MaSv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Double getDTB() {
        return DTB;
    }

    public void setDTB(Double DTB) {
        this.DTB = DTB;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "MaSv=" + MaSv + ", HoTen=" + HoTen + ", DTB=" + DTB + '}';
    }
    
    
}
