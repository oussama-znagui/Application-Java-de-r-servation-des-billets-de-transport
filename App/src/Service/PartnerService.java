package Service;
import Model.Partner;
import Repository.PartnerRepository;
import Enum.Transport;
import Enum.PartnerStatus;
import Service.Interface.PartnerServiceInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartnerService implements PartnerServiceInterface {
   public Scanner scanner = new Scanner(System.in);
   public PartnerRepository repository = new PartnerRepository();



   public Partner getData(){

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

    public void addPartner(Partner partner) throws SQLException {
        repository.addPartner(partner);


    }

    public void displayAllPartners() throws SQLException {
        repository.displayAllPartners();
    }

    public void updatePartner(Partner oldPartner,Partner newPartner) throws SQLException {
        repository.updatePartner(oldPartner,newPartner);
    }

    public void deletePartner(Partner partner) throws SQLException {
        repository.deletePartner(partner);
    }

    public Partner getPartnerById(int id) throws SQLException {
        return repository.getPartnerById(id);
    }




}
