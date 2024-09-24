package Repository;

import Config.Dbconnexion;
import Model.Contract;
import Model.Offer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enum.Discount;
import Enum.OfferStatus;

public class OfferRepository {
    public ContractRepository contractRepository = new ContractRepository();


    public Offer toOffer(ResultSet rs) throws SQLException {
        Offer offer = new Offer();
        offer.setId(rs.getInt("id"));
        offer.setOfferName(rs.getString("offername"));
        offer.setDescription(rs.getString("description"));
        offer.setStartDate(rs.getDate("startdate").toLocalDate());
        offer.setEndDate(rs.getDate("enddate").toLocalDate());
        offer.setDiscountValue(rs.getFloat("discountvalue"));
        offer.setDiscountType(Discount.valueOf(rs.getString("discounttype")));
        offer.setConditions(rs.getString("conditions"));
        offer.setStatus(OfferStatus.valueOf(rs.getString("status")));
        Contract contract = contractRepository.getContractById(rs.getInt("contractid"));
        offer.setContract(contract);
        return offer;
    }

    public void addOffer(Offer offer) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        String offerName = offer.getOfferName();
        String description = offer.getDescription();
        LocalDate startDate = offer.getStartDate();
        LocalDate endDate = offer.getEndDate();
        Discount discountType = offer.getDiscountType();
        float discountValue = offer.getDiscountValue();
        String conditions = offer.getConditions();
        OfferStatus status = offer.getStatus();
        int ContractId = offer.getContract().getId();

        try {
            String sql = "insert into offers (offerName,description,startDate,endDate,discountType,discountValue,conditions,status,contractid) values(?,?,?,?,?::Discount,?,?,?::OfferStatus,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, offerName);
            ps.setString(2, description);
            ps.setDate(3,Date.valueOf(startDate)  );
            ps.setDate(4,Date.valueOf(endDate)  );
            ps.setString(5, discountType.name());
            ps.setFloat(6,discountValue);
            ps.setString(7, conditions);
            ps.setString(8, status.name());
            ps.setInt(9, ContractId);

            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateOffer(Offer offer,Offer newOffer) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        String offerName = newOffer.getOfferName();
        String description = newOffer.getDescription();
        LocalDate startDate = newOffer.getStartDate();
        LocalDate endDate = newOffer.getEndDate();
        Discount discountType = newOffer.getDiscountType();
        float discountValue = newOffer.getDiscountValue();
        String conditions = newOffer.getConditions();
        OfferStatus status = newOffer.getStatus();
        int ContractId = newOffer.getContract().getId();
        int offerId = offer.getId();

        try {
            String sql = "update offers set offername = ?, description = ?, startDate = ?, endDate = ?, discountType = ?::Discount, discountValue = ?, conditions = ?, status = ?::OfferStatus, contractid = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, offerName);
            ps.setString(2, description);
            ps.setDate(3, Date.valueOf(startDate)  );
            ps.setDate(4, Date.valueOf(endDate)  );
            ps.setString(5, discountType.name());
            ps.setFloat(6,discountValue);
            ps.setString(7, conditions);
            ps.setString(8, status.name());

            ps.setInt(9, newOffer.getContract().getId());
            ps.setInt(10, offerId);
            ps.executeUpdate();
            System.out.println("offer updated ");
        }catch (SQLException e) {
            System.out.println(e);

        }
    }


    public void deleteOffer(Offer offer) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "delete from offers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, offer.getId());
            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }
    }



    public List<Offer> getAllOffers() throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        List<Offer> offers = new ArrayList<Offer>();

        try {
            String sql = "select * from offers";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Offer offer = toOffer(rs);
                offers.add(offer);
            }
            return offers;
        }catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }


    public Offer getOfferById(int id) throws SQLException {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;

        try{
            String sql = "select * from offers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Offer offer = toOffer(rs);
                return offer;
            }
            else return null;

        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }







}
