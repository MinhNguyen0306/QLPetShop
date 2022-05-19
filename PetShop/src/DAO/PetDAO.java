package DAO;

import Model.PetModel;
import View.PetFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PetDAO {
    public List<PetModel> getPets(){
        List<PetModel> pets = new ArrayList<PetModel>();
        Connection con = ConnectSQL.getConnect();
        String sql = "select * from pet";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                PetModel pet = new PetModel();
                pet.setpID(rs.getInt("pID"));
                pet.setpName(rs.getString("pName"));
                pet.setpCategory(rs.getString("pCategory"));
                pet.setpQuantity(rs.getInt("pQuantity"));
                pet.setpPrice(rs.getFloat("pPrice"));
                pets.add(pet);
            }
        } catch(Exception e){
            e.printStackTrace();
        }      
        return pets;
    }
    
    public void addPet(PetModel pet){
        Connection con = ConnectSQL.getConnect();
        String sql = "insert into pet(pName,pCategory,pQuantity,pPrice) values(?,?,?,?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pet.getpName());
            pst.setString(2, pet.getpCategory());
            pst.setInt(3, pet.getpQuantity());
            pst.setFloat(4, pet.getpPrice());
            
            int rs = pst.executeUpdate();
            PetFrame p = new PetFrame();
            JOptionPane.showMessageDialog(p, "Added Succecfully!");
            System.out.print(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editPet(PetModel pet){
        Connection con = ConnectSQL.getConnect();
        String sql = "update pet set pName=?, pCategory=?, pQuantity=?, pPrice=? where pID=?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pet.getpName());
            pst.setString(2, pet.getpCategory());
            pst.setInt(3, pet.getpQuantity());
            pst.setFloat(4, pet.getpPrice());
            pst.setInt(5, pet.getpID());
            
            int rs = pst.executeUpdate();
            PetFrame c = new PetFrame();
            JOptionPane.showMessageDialog(c, "Update Succecfully!");
            System.out.print(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteCustomer(PetModel pet){
        Connection con = ConnectSQL.getConnect();
        String sql = "delete from pet where pID = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, pet.getpID());
            
            int rs = pst.executeUpdate();
            PetFrame p = new PetFrame();
            JOptionPane.showMessageDialog(p, "Delete Succecfully!");
            System.out.print(rs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

