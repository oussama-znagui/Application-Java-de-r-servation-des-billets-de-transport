package UI;

import Service.ContractService;
import Service.PartnerService;
import Service.TicketService;

import java.sql.SQLException;
import java.util.Scanner;

public class mainMenu  {
    public static PartnerService partnerService = new PartnerService();
    public static ContractService contractService = new ContractService();
    public static TicketService ticketService = new TicketService();


    public static void menu() throws SQLException {
        System.out.println("Welcome to the main menu");
        System.out.println("---------------------");


      while (true){
          System.out.println("1. Gestion des parteners");
          System.out.println("2. Gestion des contrats");
          System.out.println("3. Gestion des tickets");
          System.out.println("4. Gestion des offres");
          System.out.println("\nVotre choix svp! : ");

          Scanner scanner = new Scanner(System.in);
          int option = scanner.nextInt();

          switch(option){
              case 1:
                  partnersMenu();
                  break;
              case 2:
                  contratsMenu();
                  break;
              case 3:
                  ticketsMenu();
                  break;
              case 4:
                  offresMenu();
                  break;
              default:
                  System.out.println("Invalid option");


          }
      }


    }

    public static void partnersMenu() throws SQLException {
        System.out.println("Welcome to the partners menu");
        System.out.println("---------------------");
        System.out.println("1. List des parteners");
        System.out.println("2. Ajouter un partener");
        System.out.println("3. Modifier un partener");
        System.out.println("4. Supprimer un partener");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch(option){
            case 1:
                System.out.println("Liste des parteners");
                partnerService.displayAllPartners();
                break;
            case 2:
                System.out.println("Ajouter un partener");
                partnerService.addPartner();
                break;
            case 3:
                System.out.println("Modifier un partener");
                partnerService.updatePartner();
            case 4:
                System.out.println("Supprimer un partener");
                partnerService.deletePartner();





        }



    }

    public static void contratsMenu() throws SQLException {
        System.out.println("Welcome to the contrats menu");
        System.out.println("---------------------");
        System.out.println("1. List des contrats");
        System.out.println("2. Ajouter un contrat");
        System.out.println("3. Modifier un contrat");
        System.out.println("4. Supprimer un contrat");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch(option){
            case 1:
                System.out.println("Liste des contrats");
                contractService.displayAllContracts();
                contratsMenu();
                break;
            case 2:
                System.out.println("Ajouter un contrat");
                contractService.addContract();
                contratsMenu();
                break;
            case 3:
                System.out.println("Modifier un contrat");
                contractService.updateContract();
                contratsMenu();
                break;
            case 4:
                System.out.println("Suprimer un contrat");
                contractService.deleteContract();
                contratsMenu();
                break;

        }
    }

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
            case 2:
                System.out.println("Ajouter un ticket");
                ticketService.addTicket();

        }
    }

    public static void offresMenu(){
        System.out.println("Welcome to the offres menu");
        System.out.println("---------------------");
        System.out.println("1. List des offres");
        System.out.println("1. Ajouter un offre");
        System.out.println("2. Modifier un offre");
        System.out.println("3. Supprimer un offre");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
    }
}
