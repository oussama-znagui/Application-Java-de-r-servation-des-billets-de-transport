package Model;
import Enum.ContratStatus;

import java.util.Collection;

public class Contract {
    private int id;
    private String startDate;
    private String endDate;
    private float specialRate;
    private String termsOfAgreement;
    private Boolean renewable;
    private ContratStatus status;
   private Partner partner;

    public Contract(int id, String startDate, String endDate, float specialRate, String termsOfAgreement, Boolean renewable, ContratStatus status, Partner partner) {
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


    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
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

    public ContratStatus getStatus() {
        return status;
    }
     public void setStatus(ContratStatus status) {
        this.status = status;
     }
     public Partner getPartner() {
        return partner;
     }
     public void setPartner(Partner partner) {
        this.partner = partner;
     }



}
