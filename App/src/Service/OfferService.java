package Service;

import Model.Offer;
import Repository.OfferRepository;

import java.sql.SQLException;

public class OfferService {
    public static OfferRepository offerRepository = new OfferRepository();


    public void addOffer(Offer offer) throws SQLException {
        System.out.println("-------> " + offer.getStatus());
        offerRepository.addOffer(offer);
    }

    public
}
