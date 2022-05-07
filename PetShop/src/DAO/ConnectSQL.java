package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectSQL {
    public static Connection getConnect() {
        String url = "jdbc:jtds:sqlserver://ADMIN:1433/PETSHOP;instance=SQLEXPRESS";
        String user = "minh2001";
        String password = "minh15987456321";
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}



