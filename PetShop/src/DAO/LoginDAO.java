package DAO;

import Model.EmployeeModel;
import View.HomeFrame;
import View.LoginFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    public void signin(String name, String pass){
        Connection con = ConnectSQL.getConnect();
        String sql = "select * from employee where eName = ? and ePass = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            LoginFrame login = new LoginFrame();
            if(rs.next()){
                JOptionPane.showMessageDialog(login, "Đăng nhập thành công!");
                new LoginFrame().dispose();
                new HomeFrame().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(login, "Tài khoản hoặc mật khẩu không đúng!"); 
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<EmployeeModel> getEmployee(){
        List<EmployeeModel> emps = new ArrayList<EmployeeModel>();
        Connection con = ConnectSQL.getConnect();
        String sql = "select * from employee";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                EmployeeModel emp = new EmployeeModel();
                emp.seteID(rs.getInt("eID"));
                emp.seteName(rs.getString("eName"));
                emp.setePhone(rs.getString("ePhone"));
                emp.seteGender(rs.getString("eGender"));
                emp.setePass(rs.getString("ePass"));
                emps.add(emp);
            }
        } catch(Exception e){
        }      
        return emps;
    }
}
