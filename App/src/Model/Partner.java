package Model;
import Enum.Transport;
import Enum.PartnerStatus;

public class Partner {
    private int id;
    private String companyName;
    private String contactCommercial;
    private String geographicalArea;
    private String conditionsSpeciales;
    private Transport transportType;
    private PartnerStatus status;
    private String creationDate;


    public Partner(int id, String companyName, String contactCommercial,String geographicalArea,String conditionsSpeciales, Transport transportType, PartnerStatus status, String creationDate) {
        this.id = id;
        this.companyName = companyName;
        this.contactCommercial = contactCommercial;
        this.geographicalArea = geographicalArea;
        this.conditionsSpeciales = conditionsSpeciales;
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
    public String getGeographicalArea() {
        return this.geographicalArea;
    }
    public String getConditionsSpeciales() {
        return this.conditionsSpeciales;
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
    public void setGeographicalArea(String geographicalArea) {
        this.geographicalArea = geographicalArea;
    }
    public void setConditionsSpeciales(String conditionsSpeciales) {
        this.conditionsSpeciales = conditionsSpeciales;
    }

    public String toString(){
        return  (this.id + "\t\t" + this.companyName + "\t\t" + this.contactCommercial + "\t\t" + this.geographicalArea + "\t\t" + this.conditionsSpeciales + "\t\t" + this.transportType + "\t\t" + this.status + "\t\t" + this.creationDate);
    }



}
