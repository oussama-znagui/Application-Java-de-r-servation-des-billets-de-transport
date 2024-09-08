package Repository;

import Config.Dbconnexion;
import Model.Contract;
import Model.Partner;
import Repository.Interface.ContractRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Enum.ContractStatus;
import Enum.PartnerStatus;
import Enum.Transport;


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


    public static Contract toContract(ResultSet rs) throws SQLException {
        Contract contract = new Contract();
        contract.setId(rs.getInt("id"));
        contract.setStartDate(rs.getDate("startdate").toLocalDate());
        contract.setEndDate(rs.getDate("enddate").toLocalDate());
        contract.setSpecialRate(rs.getFloat("specialrate"));
        contract.setTermsOfAgreement(rs.getString("termsofagreement"));
        contract.setRenewable(rs.getBoolean("renewable"));
        contract.setStatus(ContractStatus.valueOf(rs.getString("status")));
        Partner partner = new Partner();
        partner.setId(rs.getInt("partnerid"));
        partner.setCompanyName(rs.getString("companyname"));
        partner.setContactCommercial(rs.getString("contactcommercial"));
        partner.setConditionsSpeciales(rs.getString("conditionsspeciales"));
        partner.setGeographicalArea(rs.getString("geographicalarea"));
        partner.setCreationDate(rs.getString("creationdate"));
        partner.setStatus(PartnerStatus.valueOf(rs.getString("pstatus")));

        contract.setPartner(partner);
        return contract;
    }

    public Contract getContractById(int id) throws SQLException {
            Connection conn = Dbconnexion.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Contract contract  = null;
            try {
                String sql = "SELECT partners.status as pstatus,* FROM contracts  join partners on contracts.partnerid = partners.id and contracts.id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                rs = ps.executeQuery();
                if(rs.next()){
                    System.out.println("bien");

                    contract = toContract(rs);
                }


            }catch(SQLException  e){
                System.out.println(e);
                System.out.println("alooo");

            }
            return contract;

    }



    public List<Contract> getAllContracts() throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Contract> contracts = new ArrayList<Contract>();
        try{
            String sql = "SELECT partners.status as pstatus,* FROM contracts  join partners on contracts.partnerid = partners.id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Contract contract = toContract(rs);
                System.out.println("allo");
                contracts.add(contract);

            }
        }catch(SQLException  e){
            System.out.println(e);
            return null;
        }
        return contracts;

    }


    public void displayAllContracts() throws SQLException {
        List<Contract> contracts = getAllContracts();
        int count = contracts.size();
        System.out.println(count);
        contracts.forEach((contract) -> {
            System.out.println(contract.toString());
        });
    }

    public void updateContract(Contract contract,Contract newContract) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        int id = contract.getId();
        String startdate = newContract.getStartDate().toString();

        String endDate = newContract.getEndDate().toString();
        float specialRate = newContract.getSpecialRate();
        String termsOfAgreement = newContract.getTermsOfAgreement();
        boolean renewable = newContract.getRenewable();
        ContractStatus status = newContract.getStatus();
        try{
            System.out.println("try exec");
            String sql="update contracts set startdate='"+ startdate  + "',enddate='"+ endDate +"',specialrate='"+ specialRate +"',termsOfAgreement='"+ termsOfAgreement +"',renewable='"+ renewable + "',status='" + status + "' where id = " + id;
            ps =conn.prepareStatement(sql);
            ps.executeUpdate();

        }catch(SQLException  e){
            System.out.println(e);


        }
    }


    public void deleteContract(Contract contract) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        int id = contract.getId();
        try{
            String sql = "delete from contracts where id = " + id;
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (SQLException  e){
            System.out.println(e);
        }
    }
}
