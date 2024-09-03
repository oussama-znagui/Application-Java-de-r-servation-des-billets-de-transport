package Repository;

import Config.Dbconnexion;
import Model.Partner;
import Repository.Interface.PartnerRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Enum.Transport;
import Enum.PartnerStatus;


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

            if(rs.next()){
                Partner partner = toPartner(rs);
                return partner;
            }
            else {
                return null;
            }



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



    public static void displayAllPartners() throws SQLException {

        List<Partner> partners = getAllPartners();
        int count = partners.size();
        System.out.println(count);
        partners.forEach((partner) -> {
            System.out.println(partner.toString());
        });

    }


    public static void addPartner(Partner partner) throws SQLException {
        Connection con = Dbconnexion.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "insert into Partners (companyname,contactcommercial,transportType,geographicalarea,conditionsSpeciales,status,creationDate) Values('westCompany','340534063','BUS','MENA','a remlir','ACTIVE','02/09/2024')";
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
            String sql="delete from partners where id=1";
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
            String sql="update partners set companyname='"+ companyName  + "',contactCommercial='"+ contactCommercial +"',geographicalArea='"+ geographicalArea +"',conditionsSpeciales='"+ conditionsSpeciales +"',transportType='"+ transportType +"',status='"+ transportType +"',creationDate='"+ creationDate +"' where id = 5" ;
            p =con.prepareStatement(sql);
            p.execute();
            return true;
        }catch(SQLException  e){
            System.out.println(e);
            return false;

        }

    }
    }





