package Model;
import Enum.ContractStatus;

import java.time.LocalDate;

public class Contract {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private float specialRate;
    private String termsOfAgreement;
    private Boolean renewable;
    private ContractStatus status;
   private Partner partner;

    public Contract(int id, LocalDate startDate, LocalDate endDate, float specialRate, String termsOfAgreement, Boolean renewable, ContractStatus status, Partner partner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.specialRate = specialRate;
        this.termsOfAgreement = termsOfAgreement;
        this.renewable = renewable;
        this.status = status;
        this.partner = partner;
    }

    public Contract(){

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public float getSpecialRate() {
        return specialRate;
    }
    public void setSpecialRate(float specialRate) {
        this.specialRate = specialRate;
    }

    public String getTermsOfAgreement() {
        return termsOfAgreement;
    }
    public void setTermsOfAgreement(String termsOfAgreement) {
        this.termsOfAgreement = termsOfAgreement;
    }

    public Boolean getRenewable() {
        return renewable;
    }

    public void setRenewable(Boolean renewable) {
        this.renewable = renewable;
    }

    public ContractStatus getStatus() {
        return status;
    }
     public void setStatus(ContractStatus status) {
        this.status = status;
     }
     public Partner getPartner() {
        return partner;
     }
     public void setPartner(Partner partner) {
        this.partner = partner;
     }

    public String toString(){
        return  (this.id + "\t\t" + this.startDate + "\t\t" + this.endDate + "\t\t" + this.specialRate + "\t\t" + this.termsOfAgreement + "\t\t" + this.renewable + "\t\t" + this.status + "\t\t -> partner : " + this.partner.getCompanyName());
    }



}
