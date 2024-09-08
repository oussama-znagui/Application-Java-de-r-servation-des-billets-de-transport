package Service;

import Model.Offer;
import Repository.Interface.OfferRepositoryInterface;
import Repository.OfferRepository;

import java.sql.SQLException;
import java.util.List;

public class OfferService implements OfferRepositoryInterface {
    public static OfferRepository offerRepository = new OfferRepository();


    public void addOffer(Offer offer) throws SQLException {
        System.out.println("-------> " + offer.getStatus());
        offerRepository.addOffer(offer);
    }

    public void displayAllOffers() throws SQLException {
        List<Offer> offers = offerRepository.getAllOffers();
        for (Offer offer : offers) {
            System.out.println(offer);
        }
    }

    public void deleteOffer(Offer offer) throws SQLException {
        offerRepository.deleteOffer(offer);
    }

    public void updateOffer(Offer offer,Offer newOffer) throws SQLException {
        offerRepository.updateOffer(offer, newOffer);
    }

    public Offer getOfferById(int id) throws SQLException {
        return offerRepository.getOfferById(id);
    }
}
