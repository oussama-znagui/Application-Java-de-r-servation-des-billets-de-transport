package Repository.Interface;

import Model.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TicketRepositoryInterface {
    public Ticket toTicket(ResultSet rs) throws SQLException;
    public List<Ticket> getAllTickets() throws SQLException;
    public void displayAllTickets() throws SQLException;
    public void addTicket(Ticket ticket);
    public Ticket getTicket(int id) throws SQLException;
    public void updateTicket(Ticket ticket,Ticket newTicket) throws SQLException;
    public void deleteTicket(Ticket ticket) throws SQLException;

}
