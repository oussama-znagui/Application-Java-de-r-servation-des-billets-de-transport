package Repository;

import Config.Dbconnexion;
import Model.Contract;
import Model.Offer;

import java.sql.*;
import java.time.LocalDate;

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

    public void addOffer(Offer offer) {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        String offerName = offer.getOfferName();
        String description = offer.getDescription();
        LocalDate startDate = offer.getStartDate();
        LocalDate endDate = offer.getEndDate();
        Discount discountType = offer.getDiscountType();
        String conditions = offer.getConditions();
        OfferStatus status = offer.getStatus();
        int ContractId = offer.getContract().getId();

        try {
            String sql = "insert into offer (offerName,description,startDate,endDate,discountType,discountValue,conditions,status) values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, offerName);
            ps.setString(2, description);
            ps.setDate(3,Date.valueOf(startDate)  );
            ps.setDate(4,Date.valueOf(endDate)  );
            ps.setString(5, discountType.name());
            ps.setString(6, conditions);
            ps.setString(7, status.name());
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateOffer(Offer offer,Offer newOffer) {
        Connection conn = Dbconnexion.getConnection();
        PreparedStatement ps = null;
        String offerName = newOffer.getOfferName();
        String description = newOffer.getDescription();
        LocalDate startDate = newOffer.getStartDate();
        LocalDate endDate = newOffer.getEndDate();
        Discount discountType = newOffer.getDiscountType();
        String conditions = newOffer.getConditions();
        OfferStatus status = newOffer.getStatus();
        int ContractId = newOffer.getContract().getId();
        int offerId = offer.getId();

        try {
            String sql = "update offers set offername = ?, description = ?, startDate = ?, endDate = ?, discountType = ?, discountValue = ?, conditions = ?, status = ?, contractid = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, offerName);
            ps.setString(2, description);
            ps.setDate(3, Date.valueOf(startDate)  );
            ps.setDate(4, Date.valueOf(endDate)  );
            ps.setString(5, discountType.name());
            ps.setString(6, conditions);
            ps.setString(7, status.name());
            ps.setInt(8, offerId);
            ps.setInt(9, offer.getContract().getId());
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e);

        }
    }





}
