package Service.Interface;

import Model.Ticket;

import java.sql.SQLException;

public interface TicketServiceInterface {
    public void addTicket(Ticket ticket) throws SQLException;
    public void displayAllTickets() throws SQLException;
    public void updateTicket(Ticket oldTicket,Ticket newTicket) throws SQLException;
    public Ticket getTicketById(int ticketID) throws SQLException;
}
