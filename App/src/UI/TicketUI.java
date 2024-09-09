package UI;

import Model.Contract;
import Model.Ticket;
import Service.ContractService;
import Service.TicketService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Enum.TicketStatus;
import Enum.Transport;


public class TicketUI {

    public static TicketService ticketService = new TicketService();
    public static Scanner scanner = new Scanner(System.in);
    public static ContractService contractService = new ContractService();

    public static void ticketsMenu() throws SQLException {
        System.out.println("Welcome to the tickets menu");
        System.out.println("---------------------");
        System.out.println("1. List des tickets");
        System.out.println("2. Ajouter un ticket");
        System.out.println("3. Modifier un ticket");
        System.out.println("4. Supprimer un ticket");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println("all tickets");
                ticketService.displayAllTickets();
                break;
            case 2:
                System.out.println("Ajouter un ticket");
                Ticket ticket = getData();
                ticketService.addTicket(ticket);
                break;
            case 3:
                System.out.println("Modifier un ticket");
                System.out.println("---------------------");
                ticketService.displayAllTickets();
                System.out.println("Ticket ID : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                Ticket newTicket = getData();
                Ticket oldTicket = ticketService.getTicketById(id);
                ticketService.updateTicket(oldTicket, newTicket);

                break;




        }
    }



    public static Ticket getData() throws SQLException {
        System.out.println("transport Type"+ Arrays.toString(Transport.values()) + " : ");
        Transport transportType = Transport.valueOf(scanner.next());
        System.out.println("purchase Price : ");
        float purchasePrice = scanner.nextFloat();
        System.out.println("sale Price : ");
        float salePrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("sale Date : ");
        String saleDate1 = scanner.nextLine();
        LocalDate saleDate  = LocalDate.parse(saleDate1);
        System.out.println("ticket Status"+ Arrays.toString(TicketStatus.values()) + " : ");
        TicketStatus ticketStatus = TicketStatus.valueOf(scanner.nextLine());
        contractService.displayAllContracts();
        System.out.println("ContractID : ");
        int ContractID = scanner.nextInt();
        scanner.nextLine();
        Contract contract = contractService.getContractById(ContractID);
        Ticket ticket = new Ticket(0,transportType,purchasePrice,salePrice,saleDate,ticketStatus,contract);
        return ticket;

    }
}
