package Repository;

import Config.Dbconnexion;
import Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClientRepository {



    public List<Client> clientList(){
        List<Client> list = new ArrayList<Client>();
        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "select * from Client";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Client client = new Client(name, email, phone);
                list.add(client);
            }
            return list;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public boolean addClient(Client client){
        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into Client values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getUserName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPhone());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getClientByMail(String mail){

        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from Client where email = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else return false;

        } catch (SQLException e) {
            return  false;
        }
    }




}
