package UI;

import Model.Partner;
import Service.PartnerService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import Enum.PartnerStatus;
import Enum.Transport;

public class PartnerUI {

    public static PartnerService partnerService = new PartnerService();
    public static Scanner scanner = new Scanner(System.in);



    public static void partnersMenu() throws SQLException {
        System.out.println("Welcome to the partners menu");
        System.out.println("---------------------");
        System.out.println("1. List des parteners");
        System.out.println("2. Ajouter un partener");
        System.out.println("3. Modifier un partener");
        System.out.println("4. Supprimer un partener");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Liste des parteners");
                partnerService.displayAllPartners();
                break;
            case 2:
                System.out.println("Ajouter un partener");
                Partner partner = getData();
                partnerService.addPartner(partner);
                break;
            case 3:
                System.out.println("Modifier un partener");
                System.out.println("-------------------------");
                partnerService.displayAllPartners();
                System.out.println("PatnerID  : ");
                int patnerID = scanner.nextInt();
                scanner.nextLine();
                Partner oldPartner = partnerService.getPartnerById(patnerID);
                Partner newPartner = getData();
                partnerService.updatePartner(oldPartner,newPartner);
                break;




            case 4:
                System.out.println("Supprimer un partener");
                System.out.println("-------------------------");
                partnerService.displayAllPartners();
                System.out.println("PatnerID  : ");
                int patnerIDD = scanner.nextInt();
                scanner.nextLine();
                Partner oldPartnerForDelete = partnerService.getPartnerById(patnerIDD);
                partnerService.deletePartner(oldPartnerForDelete);

        }
    }


    public static Partner getData(){

        System.out.println("company Name : ");
        String companyName = scanner.nextLine();
        System.out.println("contact Commercial : ");
        String contactCommercial = scanner.nextLine();
        System.out.println("transport Type(BUS,TRAIN,AIRPLANE) : ");
        Transport transport = Transport.valueOf(scanner.nextLine());
        System.out.println("geographicalArea : ");
        String geographicalArea = scanner.nextLine();
        System.out.println("conditions Speciales : ");
        String conditionsSpeciales = scanner.nextLine();
        System.out.println("status (" + Arrays.toString(PartnerStatus.values()) +  ") : ");
        PartnerStatus status = PartnerStatus.valueOf(scanner.nextLine());
        LocalDate localDate = LocalDate.now();
        String creationDate = localDate.toString();

        Partner partner = new Partner(0,companyName,contactCommercial,geographicalArea,conditionsSpeciales,transport,status,creationDate);
        return partner;
    };



}

