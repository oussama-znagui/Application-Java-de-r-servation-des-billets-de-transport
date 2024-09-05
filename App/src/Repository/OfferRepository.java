package Repository;

import Model.Contract;
import Model.Offer;

import java.sql.ResultSet;
import java.sql.SQLException;
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


}
