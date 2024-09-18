package Service;

import Model.Contract;
import Model.Partner;
import Model.Ticket;
import Repository.ContractRepository;
import Repository.PartnerRepository;
import Repository.TicketRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Enum .TicketStatus;
import Enum .Transport;
import Service.Interface.TicketServiceInterface;


public class TicketService implements TicketServiceInterface {
    public Scanner scanner = new Scanner(System.in);
    public TicketRepository ticketRepository = new TicketRepository();
    public ContractRepository contractRepository = new ContractRepository();
    public PartnerRepository partnerRepository = new PartnerRepository();



    public void addTicket(Ticket ticket) throws SQLException {


        ticketRepository.addTicket(ticket);

    }

    public void displayAllTickets() throws SQLException {
        ticketRepository.displayAllTickets();
    }

        public void updateTicket(Ticket oldTicket,Ticket newTicket) throws SQLException {
        ticketRepository.updateTicket(oldTicket,newTicket);
    }

    public Ticket getTicketById(int ticketID) throws SQLException {
        return ticketRepository.getTicket(ticketID);
    }
}
