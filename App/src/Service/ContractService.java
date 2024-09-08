package Service;
import  Enum.ContractStatus;

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
        System.out.println("startDate(YYYY-MM-DD) : ");

        String startDate1 = scanner.nextLine();
        LocalDate startDate  = LocalDate.parse(startDate1);
        System.out.println("endDate(YYYY-MM-DD) : ");
        String endDate1 = scanner.nextLine();
        LocalDate endDate  = LocalDate.parse(endDate1);
        System.out.println("special Rate : ");
        float specialRate = Float.parseFloat(scanner.next());
        System.out.println("terms Of Agreement : ");
        String termsOfAgreement = scanner.nextLine();
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

    public void addContract(Contract contract) throws SQLException {
        repository.addContract(contract);
        System.out.println("Contract added");
    }

    public void displayAllContracts() throws SQLException {
        System.out.println("All Contracts : ");
        repository.displayAllContracts();
    }

    public void updateContract(Contract oldContract,Contract newContract) throws SQLException {
        repository.updateContract(oldContract, newContract);

    }
    public void deleteContract(Contract contract) throws SQLException {
        repository.deleteContract(contract);
    }

    public Contract getContractById(int id) throws SQLException {
        return repository.getContractById(id);
    }



}
