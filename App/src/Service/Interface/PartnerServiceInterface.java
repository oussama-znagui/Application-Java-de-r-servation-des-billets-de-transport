package Service.Interface;

import Model.Partner;

import java.sql.SQLException;

public interface PartnerServiceInterface {
    public Partner getData();
    public void addPartner(Partner partner) throws SQLException;
    public void displayAllPartners() throws SQLException;
    public void updatePartner(Partner oldPartner,Partner newPartner) throws SQLException;
    public void deletePartner(Partner partner) throws SQLException;
}
