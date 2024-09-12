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



    public static void pricipaleMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to EcoMove");
        System.out.println("---------------------");
        while (true) {
            System.out.println("1. Espace de gestion (Admin)");
            System.out.println("2. Espace Client et reservation");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    menu();
                    break;
                case 2:



            }
        }
    }


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
                  PartnerUI.partnersMenu();
                  break;
              case 2:
                  ContractUI.contratsMenu();
                  break;
              case 3:
                  TicketUI.ticketsMenu();
                  break;
              case 4:
                  OfferUI.offresMenu();
                  break;
              default:
                  System.out.println("Invalid option");
                  pricipaleMenu();
                  break;
          }
      }
    }


    public static void clientMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Gestion des parteners");
        System.out.println("2. Gestion des contrats");
        System.out.println("3. Gestion des tickets");
        System.out.println("4. Gestion des offres");
        System.out.println("\nVotre choix svp! : ");


    }








}
