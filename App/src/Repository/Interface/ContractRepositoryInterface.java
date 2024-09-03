package Repository.Interface;

import Model.Contract;

import java.sql.SQLException;

public interface ContractRepositoryInterface {
    public boolean addContract(Contract contract) throws SQLException;
}
