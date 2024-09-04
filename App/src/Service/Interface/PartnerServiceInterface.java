package Service.Interface;

import Model.Partner;

import java.sql.SQLException;

public interface PartnerServiceInterface {
    public Partner getData();
    public void addPartner() throws SQLException;
    public void displayAllPartners() throws SQLException;
    public void updatePartner() throws SQLException;
    public void deletePartner() throws SQLException;
}
