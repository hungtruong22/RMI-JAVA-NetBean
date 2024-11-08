
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class CoSo {
    public static Connection cn;
        public static void MoKetNoi() {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-RQV86U4:1433;databaseName=RMI;user=sa;password=truongminhhung");
                System.out.println("Da ket noi CSDL ");
            }
            catch (Exception t1) {
                System.out.print(t1.getMessage());
            }
        }
        public static ResultSet LayBang(String tb) {
            try {
                Statement cmd = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
                return cmd.executeQuery("select * from " + tb);
            }
            catch (Exception t2) {
                System.out.print(t2.getMessage());
                return null;
            }
        }
}
