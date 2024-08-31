package Model;

import Enum.Discount;
import Enum.OfferStatus;

public class Offer {
    private int id;
    private String offerName;
    private String description;
    private String startDate;
    private String endDate;
    private Discount discountType;
    private float discountValue;
    private String conditions;
    private OfferStatus status;
    private Contract contract;

    public Offer() {

    }

    public Offer(int id, String offerName, String description, String startDate, String endDate, Discount discountType, float discountValue, Contract contract) {
        this.id = id;
        this.offerName = offerName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.contract = contract;
    }
}
