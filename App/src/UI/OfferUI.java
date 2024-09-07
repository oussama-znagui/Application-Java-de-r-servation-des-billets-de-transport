package UI;

import Model.Contract;
import Model.Offer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Enum.Discount;
import Enum.OfferStatus;
import Repository.ContractRepository;
import Service.ContractService;
import Service.OfferService;


public class OfferUI {
    public static ContractRepository contractRepository =  new ContractRepository();
    public static OfferService offerService = new OfferService();
    public static Scanner scanner = new Scanner(System.in);

    public static void offresMenu() throws SQLException {
        System.out.println("Welcome to the offres menu");
        System.out.println("---------------------");
        System.out.println("1. List des offres");
        System.out.println("2. Ajouter une offre");
        System.out.println("3. Modifier une offre");
        System.out.println("4. Supprimer une offre");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1:
                System.out.println("-----------------");
                break;
            case 2:
                System.out.println("Ajouter une offre");
                System.out.println("----------------");
                Offer offer = getData();
                offerService.addOffer(offer);
                break;



        }


    }

    public static Offer getData() throws SQLException {
        System.out.println("offer Name : ");
        String offerName = scanner.nextLine();
        System.out.println("offer Description : ");
        String description = scanner.nextLine();
        System.out.println("startDate : ");
        String startDate1 = scanner.nextLine();
        System.out.println("endDate : ");
        String endDate1 = scanner.nextLine();
        System.out.println("discount type"+ Arrays.toString(Discount.values()) +" :  ");
        Discount discount = Discount.valueOf(scanner.nextLine());
        System.out.println("discount value : ");
        float discountValue = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Conditions : ");
        String conditions = scanner.nextLine();
        System.out.println("offerStatus"+ Arrays.toString(OfferStatus.values()) +" : ");
        OfferStatus offerStatus = OfferStatus.valueOf(scanner.nextLine());
        contractRepository.displayAllContracts();
        System.out.println("Contract ID");
        int contractID = scanner.nextInt();
        scanner.nextLine();
        Contract contract = contractRepository.getContractById(contractID);

        LocalDate startdate = LocalDate.parse(startDate1);
        LocalDate enddate = LocalDate.parse(endDate1);
        Offer offer = new Offer(0,offerName,description,startdate,enddate,discount,discountValue,conditions,offerStatus,contract);
        return offer;
    }

}
