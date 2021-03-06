package DAO;

import Model.EmployeeModel;
import View.EditEmployeeFrame;
import View.HomeFrame;
import View.LoginFrame;
import View.SignUpFrame;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    Connection con = null;
    
    public void signin(String name, String pass, LoginFrame c){
        con = ConnectSQL.getConnect();
        String sql = "select * from employee where eName = ? and ePass = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
         //   LoginFrame login = new LoginFrame();
            if(rs.next()){
                JOptionPane.showMessageDialog(c, "Đăng nhập thành công!");
                c.dispose();
                new HomeFrame().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(c, "Tài khoản hoặc mật khẩu không đúng!"); 
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<EmployeeModel> getEmployee(){
        List<EmployeeModel> emps = new ArrayList<EmployeeModel>();
        con = ConnectSQL.getConnect();
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
    
    public void addEmployee(String name, String pass){
        con = ConnectSQL.getConnect();
        String query = "insert into employee(eName,ePass) values(?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, pass);
            int rs = pst.executeUpdate();
            SignUpFrame s = new SignUpFrame();
            if(rs == 1){
                JOptionPane.showMessageDialog(s, "SignUp Succesfully!");
            }else{
                JOptionPane.showMessageDialog(s, "SignUp Failled!");
            }
        } catch (Exception e) {
        }
    }
    
    public void editEmployee(String phone, String gender, String pass, int id){
        con = ConnectSQL.getConnect();
        String query = "update employee set ePhone=?, eGender=?, ePass=? where eID=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, phone);
            pst.setString(2, gender);
            pst.setString(3, pass);
            pst.setInt(4, id);
            int rs = pst.executeUpdate();
            EditEmployeeFrame e = new EditEmployeeFrame();
            if(rs == 1){
                JOptionPane.showMessageDialog(e, "Exchange Info Succesfully!");
            }else{
                JOptionPane.showMessageDialog(e, "Exchange Info Failed!");
            }
        } catch (Exception e) {
        } 
    }
}
