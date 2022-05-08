package DAO;

import Model.CustomerModel;
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
            JOptionPane.showMessageDialog(c, "Added Succecfully!");
            System.out.print(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
