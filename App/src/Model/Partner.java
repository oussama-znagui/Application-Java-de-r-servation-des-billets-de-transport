package Model;
import Enum.Transport;
import Enum.PartnerStatus;

public class Partner {
    private int id;
    private String companyName;
    private String contactCommercial;
    private Transport transportType;
    private PartnerStatus status;
    private String creationDate;


    public Partner(int id, String companyName, String contactCommercial, Transport transportType, PartnerStatus status, String creationDate) {
        this.id = id;
        this.companyName = companyName;
        this.contactCommercial = contactCommercial;
        this.transportType = transportType;
        this.status = status;
        this.creationDate = creationDate;

    }

    public Partner() {

    }

    //Getters
    public int getId() {
        return this.id;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    public String getContactCommercial() {
        return this.contactCommercial;
    }
    public Transport getTransportType() {
        return this.transportType;
    }
    public PartnerStatus getStatus() {
        return this.status;
    }
    public String getCreationDate() {
        return this.creationDate;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setContactCommercial(String contactCommercial) {
        this.contactCommercial = contactCommercial;
    }
    public void setTransportType(Transport transportType) {
        this.transportType = transportType;
    }
    public void setStatus(PartnerStatus status) {
        this.status = status;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }



}
