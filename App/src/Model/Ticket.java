package Model;
import Enum.Transport;
import Enum.TicketStatus;

public class Ticket {
    private int id;
    private Transport transportType;
    private float purchasePrice;
    private float salePrice;
    private String saleDate ;
    private  TicketStatus status;
    private Contract contract;


   public Ticket(){

    }

    public Ticket(int id, Transport transportType, float purchasePrice, float salePrice, String saleDate, TicketStatus status, Contract contract) {
       this.id = id;
       this.transportType = transportType;
       this.purchasePrice = purchasePrice;
       this.salePrice = salePrice;
       this.saleDate = saleDate;
       this.status = status;
       this.contract = contract;
    }

    public int getId() {
       return id;
    }
    public void setId(int id) {
       this.id = id;
    }

    public Transport getTransportType() {
       return transportType;
    }
    public void setTransportType(Transport transportType) {
       this.transportType = transportType;
    }


    public float getPurchasePrice() {
       return purchasePrice;
    }
    public void setPurchasePrice(float purchasePrice) {
       this.purchasePrice = purchasePrice;
    }

    public float getSalePrice() {
       return salePrice;
    }
    public void setSalePrice(float salePrice) {
       this.salePrice = salePrice;
    }

    public String getSaleDate() {
       return saleDate;
    }
    public void setSaleDate(String saleDate) {
       this.saleDate = saleDate;
    }

    public TicketStatus getStatus() {
       return status;
    }
    public void setStatus(TicketStatus status) {
       this.status = status;
    }

    public Contract getContract() {
       return contract;
    }
    public void setContract(Contract contract) {
       this.contract = contract;
    }



}


