package Model;

import Enum.Discount;
import Enum.OfferStatus;

import java.time.LocalDate;

public class Offer {
    private int id;
    private String offerName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Discount discountType;
    private float discountValue;
    private String conditions;
    private OfferStatus status;
    private Contract contract;

    public Offer() {

    }

    public Offer(int id, String offerName, String description, LocalDate startDate, LocalDate endDate, Discount discountType, float discountValue,String conditions,OfferStatus status, Contract contract) {
        this.id = id;
        this.offerName = offerName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.status = status;
        this.conditions = conditions;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getOfferName() {
        return offerName;
    }
    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Discount getDiscountType() {
        return discountType;
    }
    public void setDiscountType(Discount discountType) {
        this.discountType = discountType;
    }

    public float getDiscountValue() {
        return discountValue;
    }
    public void setDiscountValue(float discountValue) {
        this.discountValue = discountValue;
    }

    public Contract getContract() {
        return contract;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public OfferStatus getStatus() {
        return status;
    }
    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public String getConditions() {
        return conditions;
    }
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }


    public String toString(){
        return  (this.id + "\t\t" + this.offerName + "\t\t" + this.description + "\t\t" + this.startDate + "\t\t" + this.endDate + "\t\t" + this.discountType + "\t\t" + this.discountValue + "\t\t" + this.conditions + "\t\t" + this.status + "\t\t -> ContractID : " + this.contract.getId() + "\t\t -> Partner : " + this.contract.getPartner() + "\t\t -> OfferID : " + this.getContract().getPartner().getCompanyName());
    }



}
