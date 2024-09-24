package Service.Interface;

import Model.Contract;

import java.sql.SQLException;

public interface ContractServiceInterface {
    public void addContract(Contract contract) throws SQLException;
    public void displayAllContracts() throws SQLException;
    public void updateContract(Contract oldContract,Contract newContract) throws SQLException;
    public void deleteContract(Contract contract) throws SQLException;
    public Contract getContractById(int id) throws SQLException;
}
