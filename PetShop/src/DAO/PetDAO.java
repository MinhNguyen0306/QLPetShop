package DAO;

import Model.PetModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                pet.setpID(rs.getString("pName"));
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
}

