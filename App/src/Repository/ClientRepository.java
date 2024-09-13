package Repository;

import Config.Dbconnexion;
import Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
            String sql = "insert into Clients values(?,?,?)";
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

    public Client getClientByMail(String mail){

        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from Clients where email = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Client client = new Client(name, email, phone);
                return client;

            }else return null;

        } catch (SQLException e) {
            return  null;
        }
    }


    public boolean updateClient(Client oldClient, Client newClient){
        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "update Clients set username = ?, email = ?, phone = ? where email = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, newClient.getUserName());
            ps.setString(2, newClient.getEmail());
            ps.setString(3, newClient.getPhone());
            ps.setString(4, oldClient.getEmail());
            ps.executeUpdate();
            return true;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }




}
