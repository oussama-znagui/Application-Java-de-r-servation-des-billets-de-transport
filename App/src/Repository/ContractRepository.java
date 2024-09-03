package Repository;

import Config.Dbconnexion;
import Model.Contract;
import Model.Partner;
import Repository.Interface.ContractRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractRepository implements ContractRepositoryInterface {

    public boolean addContract(Contract contract) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        try{
            String sql = "insert into contracts (startdate,enddate,specialrate,termsofagreement,renewable,status,partnerid) values(?,?,?,?,?,?::ContractStatus,?)";
            ps = conn.prepareStatement(sql);
            ps.setDate(1,java.sql.Date.valueOf(contract.getStartDate()));
            ps.setDate(2,java.sql.Date.valueOf(contract.getEndDate()));
            ps.setFloat(3,contract.getSpecialRate());
            ps.setString(4,contract.getTermsOfAgreement());
            ps.setBoolean(5,contract.getRenewable());
            ps.setString(6,contract.getStatus().name());
            ps.setInt(7,contract.getPartner().getId());
            ps.executeQuery();
            return true;



        }catch(SQLException  e){
            System.out.println(e);
            return false;

        }
    }
}
