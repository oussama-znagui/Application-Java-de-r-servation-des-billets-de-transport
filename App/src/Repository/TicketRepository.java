package Repository;

import Config.Dbconnexion;
import Model.Contract;
import Model.Partner;
import Model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import Enum.Transport;
import Enum.TicketStatus;
import Repository.Interface.TicketRepositoryInterface;


public class TicketRepository implements TicketRepositoryInterface {
    public static PartnerRepository partnerRepository = new PartnerRepository();
    public static ContractRepository contractRepository = new ContractRepository();

    public Ticket toTicket(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getInt("id"));
        ticket.setTransportType(Transport.valueOf(rs.getString("transporttype")));
        ticket.setPurchasePrice(rs.getFloat("purchaseprice"));
        ticket.setSalePrice(rs.getFloat("saleprice"));
        ticket.setSaleDate(rs.getDate("saleDate").toLocalDate());
        ticket.setStatus(TicketStatus.valueOf(rs.getString("ts")));


        int contractID = rs.getInt("contractID");

       Contract contract = contractRepository.getContractById(contractID);

      ticket.setContract(contract);
      return ticket;
    }





    public List<Ticket> getAllTickets() throws SQLException{
        List<Ticket> tickets = new ArrayList<Ticket>();
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "select tickets.status as ts,* from tickets  inner join contracts  on tickets.contractid = contracts.id inner join partners on contracts.partnerid = partners.id";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Ticket ticket = toTicket(rs);
                tickets.add(ticket);

            }
            return tickets;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }


    public void displayAllTickets() throws SQLException{
        List<Ticket> tickets = getAllTickets();
        int count = tickets.size();
        System.out.println(count);
        tickets.forEach(ticket -> {
            System.out.println(ticket);
        });
    }




    public void addTicket(Ticket ticket){
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        try{
            String query = "INSERT INTO tickets (transporttype,purchasePrice,salePrice,saleDate,status,contractID) VALUES (?::Transport,?,?,?,?::TicketStatus,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1,ticket.getTransportType().name());
            ps.setDouble(2,ticket.getPurchasePrice());
            ps.setDouble(3,ticket.getSalePrice());
            ps.setDate(4,java.sql.Date.valueOf(ticket.getSaleDate()));
            ps.setString(5,ticket.getStatus().name());
            ps.setInt(6,ticket.getContract().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Ticket getTicket(int id) throws SQLException{
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "select tickets.status as ts,* from tickets  inner join contracts  on tickets.contractid = contracts.id inner join partners on contracts.partnerid = partners.id and Tickets.id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                Ticket ticket = toTicket(rs);
                return ticket;
            }else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void updateTicket(Ticket ticket,Ticket newTicket) throws SQLException{
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;

        try{
            String sql ="update tickets set transporttype = ?,purchaseprice = ?,saleprice = ?,saleDate = ?,status = ? where id = ? \n";
            ps = conn.prepareStatement(sql);
            ps.setString(1,newTicket.getTransportType().name());
            ps.setDouble(2,newTicket.getPurchasePrice());
            ps.setDouble(3,newTicket.getSalePrice());
            ps.setDate(4,java.sql.Date.valueOf(newTicket.getSaleDate()));
            ps.setString(5,newTicket.getStatus().name());
            ps.setInt(6,ticket.getId());

        }catch (SQLException e) {
            System.out.println(e);

        }

    }

    public void deleteTicket(Ticket ticket) throws SQLException{
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;

        try {
            String query = "delete from tickets where id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,ticket.getId());
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
