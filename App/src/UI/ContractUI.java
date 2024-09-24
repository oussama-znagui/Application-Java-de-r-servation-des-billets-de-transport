package UI;

import Model.Contract;
import Model.Partner;
import Service.ContractService;
import Service.PartnerService;
import Service.TicketService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Enum.ContractStatus;

public class ContractUI {
    public static PartnerService partnerService = new PartnerService();
    public static ContractService contractService = new ContractService();
    public static TicketService ticketService = new TicketService();
    public static Scanner scanner = new Scanner(System.in);


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
                Contract contract = getData();
                contractService.addContract(contract);
                contratsMenu();
                break;
            case 3:
                System.out.println("Modifier un contrat");
                System.out.println("--------------------------");
                contractService.displayAllContracts();
                int ContractID = scanner.nextInt();
                scanner.nextLine();
                Contract oldContract = contractService.getContractById(ContractID);
                Contract newContract = getData();
                contractService.updateContract(oldContract,newContract);
                contratsMenu();
                break;
            case 4:
                System.out.println("Suprimer un contrat");
                System.out.println("--------------------------");
                contractService.displayAllContracts();
                int D_ContractID = scanner.nextInt();
                scanner.nextLine();
                Contract contractfordelete = contractService.getContractById(D_ContractID);

                contractService.deleteContract(contractfordelete);
                contratsMenu();
                break;

        }

    }



    public static Contract getData() throws SQLException {
        System.out.println("startDate(YYYY-MM-DD) : ");

        String startDate1 = scanner.nextLine();
        LocalDate startDate  = LocalDate.parse(startDate1);
        System.out.println("endDate(YYYY-MM-DD) : ");
        String endDate1 = scanner.nextLine();
        LocalDate endDate  = LocalDate.parse(endDate1);
        System.out.println("special Rate : ");
        float specialRate = Float.parseFloat(scanner.next());
        scanner.nextLine();
        System.out.println("terms Of Agreement : ");
        String termsOfAgreement = scanner.nextLine();
        System.out.println("renewable(True/False) : ");
        Boolean renewable = scanner.nextBoolean();
        System.out.println("status" + Arrays.toString(ContractStatus.values()) + " : ");
        ContractStatus status = ContractStatus.valueOf(scanner.next());
        partnerService.displayAllPartners();

        System.out.println("PartnerID : ");
        int partnerID = scanner.nextInt();
        scanner.nextLine();
        Partner partner = partnerService.getPartnerById(partnerID);
        Contract contract = new Contract(0,startDate,endDate,specialRate,termsOfAgreement,renewable,status,partner);
        return contract;

    }

}
