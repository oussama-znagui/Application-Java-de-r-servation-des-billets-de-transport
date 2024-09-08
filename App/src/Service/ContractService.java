package Service;

import Model.Contract;
import Repository.ContractRepository;
import Repository.PartnerRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ContractService {
    public Scanner scanner = new Scanner(System.in);
    public ContractRepository repository = new ContractRepository();
    public PartnerRepository partnerRepository = new PartnerRepository();




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
