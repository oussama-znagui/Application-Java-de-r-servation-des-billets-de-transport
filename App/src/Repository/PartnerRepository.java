package Repository;

import Config.Dbconnexion;
import Model.Contract;
import Model.Partner;
import Repository.Interface.PartnerRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enum.Transport;
import Enum.PartnerStatus;
import Enum.ContractStatus;



public class PartnerRepository implements PartnerRepositoryInterface {



    public static Partner toPartner(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        String companyname = rs.getString("companyname");
        String contactcommercial = rs.getString("contactcommercial");
        Transport transportType = Transport.valueOf(rs.getString("transporttype"));
        String geographicalArea = rs.getString("geographicalArea");
        String conditionsSpeciales = rs.getString("conditionsSpeciales");
        String creationDate = rs.getString("creationDate");
        PartnerStatus status = PartnerStatus.valueOf(rs.getString("status"));

        Partner partner = new Partner(id,companyname,contactcommercial,geographicalArea,conditionsSpeciales,transportType,status,creationDate);
        return partner;

    }

    public Partner getPartnerById(int id) throws SQLException{
        Connection con = Dbconnexion.getConnection();
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            String sql = "select * from Partners where id=?";
            p = con.prepareStatement(sql);
           p.setInt(1, id);
            rs = p.executeQuery();
            System.out.println(rs.next());
            System.out.println(rs.getString("companyname"));
            Partner partner = toPartner(rs);
            return partner;



        }catch (SQLException e) {
            System.out.println(e);
            return null;

        }



    }







    public static List<Partner>  getAllPartners() throws SQLException {

        Connection con = Dbconnexion.getConnection();
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            String sql = "select * from Partners";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();


            List<Partner> partners = new ArrayList<Partner>();

            while (rs.next()) {
                Partner partner = toPartner(rs);
                partners.add(partner);
            }
            return partners;
        }catch (SQLException e) {
            System.out.println(e);

        }

        return List.of();
    }



    public  void displayAllPartners() throws SQLException {

        List<Partner> partners = getAllPartners();
        int count = partners.size();
        System.out.println(count);
        partners.forEach((partner) -> {
            System.out.println(partner.toString());
        });

    }


    public void addPartner(Partner partner) throws SQLException {
        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "insert into Partners (companyname,contactcommercial,transportType,geographicalarea,conditionsSpeciales,status,creationDate) Values('"+ partner.getCompanyName() +"','"+ partner.getContactCommercial()+"','"+ partner.getTransportType() +"','"+ partner.getGeographicalArea()+"','"+ partner.getConditionsSpeciales() +"','"+ partner.getStatus() +"','"+ partner.getCreationDate() +"')";
            ps = con.prepareStatement(sql);
            ps.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }


    }



    public boolean deletePartner(Partner partner) throws SQLException {

        PreparedStatement p=null;
        Connection con= Dbconnexion.getConnection();
        try{
            String sql="delete from partners where id=" + partner.getId();
            p =con.prepareStatement(sql);
            p.execute();
            return true;
        }catch(SQLException  e){
            System.out.println(e);
            return false;

        }
    }

    public boolean updatePartner(Partner partner,Partner newPartner) throws SQLException {
        PreparedStatement p=null;
        Connection con= Dbconnexion.getConnection();
        int partnerID = partner.getId();
        String companyName = newPartner.getCompanyName();
        System.out.println(newPartner.getContactCommercial());
        String contactCommercial = newPartner.getContactCommercial();
        String geographicalArea = newPartner.getGeographicalArea();
        String conditionsSpeciales = newPartner.getConditionsSpeciales();
        Transport transportType = newPartner.getTransportType();
        PartnerStatus status = newPartner.getStatus();
        String creationDate = newPartner.getCreationDate();

        try{
            String sql="update partners set companyname='"+ companyName  + "',contactCommercial='"+ contactCommercial +"',geographicalArea='"+ geographicalArea +"',conditionsSpeciales='"+ conditionsSpeciales +"',transportType='"+ transportType +"',status='"+ status +"',creationDate='"+ creationDate +"' where id = " + partnerID ;
            p =con.prepareStatement(sql);
            p.execute();
            return true;
        }catch(SQLException  e){
            System.out.println(e);
            return false;

        }

    }

    public List<Contract> getAllPartnerContracts(Partner partner) throws SQLException {
        Connection con = Dbconnexion.getConnection();
        PreparedStatement p = null;
        ResultSet rs = null;
        List<Contract> contractsList = new ArrayList<>();
        try {
            String sql = "select * from contracts where partnerid = ?";
            p = con.prepareStatement(sql);
            p.setInt(1, partner.getId());
            rs = p.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDate startDate = rs.getDate("startdate").toLocalDate();
                LocalDate endDate = rs.getDate("enddate").toLocalDate();
                float specialRate = rs.getFloat("specialrate");
                String termsOfAgreement = rs.getString("termsofagreement");
                boolean renewable = rs.getBoolean("renewable");
                ContractStatus status = ContractStatus.valueOf(rs.getString("status"));

                Contract contract = new Contract(id,startDate,endDate,specialRate,termsOfAgreement,renewable,status,partner);
                contractsList.add(contract);

            }

        }catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return contractsList;
    }
    }





