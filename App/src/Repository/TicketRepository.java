package Repository;

import Config.Dbconnexion;
import Model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class TicketRepository {

//    public Ticket toTicket(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id");
//
//
//    }

//    public List<Ticket> getAllTickets{
//        List<Ticket> tickets = new ArrayList<Ticket>();
//        Connection conn = Dbconnexion.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            String query = "SELECT * FROM ticket";
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                Ticket ticket = new Ticket();
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//
//
//
//    }

    public void addTicket(Ticket ticket){
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        try{
            String query = "INSERT INTO tickets (transporttype,purchasePrice,salePrice,saleDate,status) VALUES (?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1,ticket.getStatus().name());
            ps.setDouble(2,ticket.getPurchasePrice());
            ps.setDouble(3,ticket.getSalePrice());
            ps.setDate(4,java.sql.Date.valueOf(ticket.getSaleDate()));
            ps.setObject(5,ticket.getStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
