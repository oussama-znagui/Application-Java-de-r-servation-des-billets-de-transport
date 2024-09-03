package Repository.Interface;

import Model.Partner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PartnerRepositoryInterface {
    public static List<Partner> getAllPartners(){
        return List.of();
    };

    public static Partner toPartner(ResultSet rs) throws SQLException
    {

        return null;
    }
    public Partner getPartnerById(int id) throws SQLException;
    public static void add(Partner partner) throws SQLException{};
    public boolean deletePartner(Partner partner) throws SQLException;
    public boolean updatePartner(Partner partner,Partner newPartner) throws SQLException;

}
