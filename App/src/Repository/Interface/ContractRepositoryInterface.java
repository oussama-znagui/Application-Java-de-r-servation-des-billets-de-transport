package Repository.Interface;

import Model.Contract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ContractRepositoryInterface {
    public boolean addContract(Contract contract) throws SQLException;
    public static Contract toContract(ResultSet rs) throws SQLException{
        return null;
    };
    public Contract getContractById(int id) throws SQLException;
    public List<Contract> getAllContracts() throws SQLException;
    public void displayAllContracts() throws SQLException;
    public void updateContract(Contract contract,Contract newContract) throws SQLException;
    public void deleteContract(Contract contract) throws SQLException;


}
