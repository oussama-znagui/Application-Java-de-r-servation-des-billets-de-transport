package Model;
import Enum.Transport;
import Enum.TicketStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private int id;
    private Transport transportType;
    private float purchasePrice;
    private float salePrice;
    private LocalDate saleDate ;
    private  TicketStatus status;
    private Contract contract;
    private LocalDate tripDate;
    private LocalTime trioHour;
    private Trip trip;


   public Ticket(){

    }

    public Ticket(int id, Transport transportType, float purchasePrice, float salePrice, LocalDate saleDate, TicketStatus status, Contract contract,LocalDate tripDate, LocalTime trioHour, Trip trip) {
       this.id = id;
       this.transportType = transportType;
       this.purchasePrice = purchasePrice;
       this.salePrice = salePrice;
       this.saleDate = saleDate;
       this.status = status;
       this.contract = contract;
       this.tripDate = tripDate;
       this.trioHour = trioHour;
       this.trip = trip;
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

    public LocalDate getSaleDate() {
       return saleDate;
    }
    public void setSaleDate(LocalDate saleDate) {
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

    public LocalDate getTripDate() {
       return tripDate;
    }
    public void setTripDate(LocalDate tripDate) {
       this.tripDate = tripDate;
    }
    public LocalTime getTrioHour() {
       return trioHour;
    }
    public void setTrioHour(LocalTime trioHour) {
       this.trioHour = trioHour;
    }
    public Trip getTrip() {
       return trip;
    }
    public void setTrip(Trip trip) {
       this.trip = trip;
    }


    public String toString(){
       return "Ticket N° : " + this.id + " infos ->\t" + this.transportType + "\t" + this.purchasePrice + "\t" + this.salePrice + "\t" + this.saleDate + "\t" + this.status + "\t -> Contract : " + this.contract.toString();
    }



}


