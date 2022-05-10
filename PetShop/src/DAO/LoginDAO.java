package DAO;

import Model.CustomerModel;
import Model.EmployeeModel;
import View.HomeFrame;
import View.LoginFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;

public class LoginDAO {
    public void signin(EmployeeModel employee){
        Connection con = ConnectSQL.getConnect();
        String sql = "select * employee where cName = ? and cPass = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, employee.geteName());
            pst.setString(2, employee.getePass());
            ResultSet rs = pst.executeQuery();
            LoginFrame login = new LoginFrame();
            if(rs.next()){
                HomeFrame home = new HomeFrame();
                home.setVisible(true);
                JOptionPane.showMessageDialog(login, "Login Succecfully!");
            }else{
                JOptionPane.showMessageDialog(login, "Login Failed");             
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
