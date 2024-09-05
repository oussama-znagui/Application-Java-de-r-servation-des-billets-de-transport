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


public class TicketService {
    public Scanner scanner = new Scanner(System.in);
    public TicketRepository ticketRepository = new TicketRepository();
    public ContractRepository contractRepository = new ContractRepository();
    public PartnerRepository partnerRepository = new PartnerRepository();

    public Ticket getData() throws SQLException {
        System.out.println("transport Type"+ Arrays.toString(Transport.values()) + " : ");
        Transport transportType = Transport.valueOf(scanner.next());
        System.out.println("purchase Price : ");
        float purchasePrice = scanner.nextFloat();
        System.out.println("sale Price : ");
        float salePrice = scanner.nextFloat();
        System.out.println("purchase Date : ");
        String saleDate1 = scanner.next();
        LocalDate saleDate  = LocalDate.parse(saleDate1);
        System.out.println("ticket Status"+ Arrays.toString(Transport.values()) + " : ");
        TicketStatus ticketStatus = TicketStatus.valueOf(scanner.next());
        contractRepository.displayAllContracts();
        System.out.println("ContractID : ");
        int ContractID = scanner.nextInt();
        Contract contract = contractRepository.getContractById(ContractID);
        Ticket ticket = new Ticket(0,transportType,purchasePrice,salePrice,saleDate,ticketStatus,contract);
        return ticket;

    }

    public void addTicket() throws SQLException {
        System.out.println("Add Ticket : ");
        Ticket ticket = getData();
        ticketRepository.addTicket(ticket);
        System.out.println("Ticket Added");
    }

    public void displayAllTickets() throws SQLException {
        ticketRepository.displayAllTickets();
    }
}
