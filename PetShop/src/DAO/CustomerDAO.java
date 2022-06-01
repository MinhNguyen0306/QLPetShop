package DAO;

import Model.CustomerModel;
import View.CustomerFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomerDAO {
    public List<CustomerModel> getCustomers(){
        List<CustomerModel> customers = new ArrayList<CustomerModel>();
        Connection con = ConnectSQL.getConnect();
        String sql = "select cID,cName,cPhone, N'xã ' + tenXa + ' - ' + N'huyện ' + tenHuyen + ' - ' + N'tỉnh ' + tenTinh as diachi\n" +
"from customer,xa,huyen,tinh \n" +
"where customer.cXa = xa.cXa and xa.cHuyen = huyen.cHuyen and tinh.cTinh = huyen.cTinh";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                CustomerModel customer = new CustomerModel();
                customer.setcID(rs.getString("cID"));
                customer.setcName(rs.getString("cName"));
                customer.setcPhone(rs.getString("cPhone"));
                customer.setDiachi(rs.getString("diachi"));
                customers.add(customer);
            }
        } catch(Exception e){
            e.printStackTrace();
        }      
        return customers;
    }
    
    public void addCustomer(CustomerModel customer){
        Connection con = ConnectSQL.getConnect();
        String sql = "insert into customer(cName,cPhone,cXa) values(?,?,?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getcName());
            pst.setString(2, customer.getcPhone());
            pst.setString(3, customer.getDiachi());
            
            int rs = pst.executeUpdate();
            CustomerFrame c = new CustomerFrame();
            if(rs == 1){
                JOptionPane.showMessageDialog(c, "Added Succecfully!");
            } else{
                JOptionPane.showMessageDialog(c, "Added Falled!");
            }
            System.out.print(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editCustomer(CustomerModel customer){
        Connection con = ConnectSQL.getConnect();
        String sql = "update customer set cName=?, cPhone=?, cXa=? where cID=?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getcName());
            pst.setString(2, customer.getcPhone());
            pst.setString(3, customer.getDiachi());
            pst.setString(4, customer.getcID());
            
            int rs = pst.executeUpdate();
            CustomerFrame c = new CustomerFrame();
            if(rs == 1){
                JOptionPane.showMessageDialog(c, "Update Succecfully!");
            } else{
                JOptionPane.showMessageDialog(c, "Update Falled!");
            }
            System.out.print(rs);
        }catch(Exception e){
        }
    }
    
    public void deleteCustomer(CustomerModel customer){
        Connection con = ConnectSQL.getConnect();
        String sql = "delete from customer where cID = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getcID());
            
            int rs = pst.executeUpdate();
            CustomerFrame c = new CustomerFrame();
            if(rs == 1){
                JOptionPane.showMessageDialog(c, "Delete Succecfully!");
            } else{
                JOptionPane.showMessageDialog(c, "Delete Falled!");
            }
            System.out.print(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<CustomerModel> searchByName(String name){
        Connection con = ConnectSQL.getConnect();
        List<CustomerModel> customers = new ArrayList<CustomerModel>();
        String query = "select cID,cName,cPhone, N'xã ' + tenXa + ' - ' + N'huyện ' + tenHuyen + ' - ' + N'tỉnh ' + tenTinh as diachi\n" +
"from customer,xa,huyen,tinh \n" +
"where customer.cXa = xa.cXa and xa.cHuyen = huyen.cHuyen and tinh.cTinh = huyen.cTinh and cName like ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                CustomerModel customer = new CustomerModel();
                customer.setcID(rs.getString("cID"));
                customer.setcName(rs.getString("cName"));
                customer.setcPhone(rs.getString("cPhone"));
                customer.setDiachi(rs.getString("diachi"));
                customers.add(customer);
            }
        } catch (Exception e) {
        }
        return customers;
    }
}
