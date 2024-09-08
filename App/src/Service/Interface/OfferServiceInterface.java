package Service.Interface;

import Model.Offer;

import java.sql.SQLException;

public interface OfferServiceInterface {
    public void addOffer(Offer offer) throws SQLException;
    public void displayAllOffers() throws SQLException;
    public void updateOffer(Offer offer) throws SQLException;
    public void deleteOffer(Offer offer) throws SQLException;
    public Offer getOfferById(int id) throws SQLException;
}
