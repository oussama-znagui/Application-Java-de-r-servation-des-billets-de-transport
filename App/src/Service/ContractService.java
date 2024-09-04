package Service;
import  Enum.ContractStatus

import Model.Contract;
import Model.Partner;
import Repository.ContractRepository;
import Repository.PartnerRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ContractService {
    public Scanner scanner = new Scanner(System.in);
    public ContractRepository repository = new ContractRepository();
    public PartnerRepository partnerRepository = new PartnerRepository();


    public Contract getData() throws SQLException {
        System.out.println("startDate : ");
        LocalDate startDate = LocalDate.parse(scanner.next());
        System.out.println("endDate : ");
        LocalDate endDate = LocalDate.parse(scanner.next());
        System.out.println("special Rate : ");
        float specialRate = Float.parseFloat(scanner.next());
        System.out.println("terms Of Agreement : ");
        String termsOfAgreement = scanner.next();
        System.out.println("renewable(True/False) : ");
        Boolean renewable = scanner.nextBoolean();
        System.out.println("status" + Arrays.toString(ContractStatus.values()) + " : ");
        ContractStatus status = ContractStatus.valueOf(scanner.next());
        partnerRepository.displayAllPartners();

        System.out.println("PartnerID : ");
        int partnerID = scanner.nextInt();

        Partner partner = partnerRepository.getPartnerById(partnerID);
        Contract contract = new Contract(0,startDate,endDate,specialRate,termsOfAgreement,renewable,status,partner);
        return contract;

    }



}
