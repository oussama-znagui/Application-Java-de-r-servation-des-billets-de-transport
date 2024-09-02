package Repository;

import Config.Dbconnexion;
import Repository.Interface.PartnerRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerRepository implements PartnerRepositoryInterface {


    public static void  getAllPartners() throws SQLException {

        Connection con = Dbconnexion.getConnection();
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            // SQL command data stored in String datatype
            String sql = "select * from Partners";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();




            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("id\t\tname\t\temail");

            // Condition check
            while (rs.next()) {

                int id = rs.getInt("id");
                String companyname = rs.getString("companyname");
                String contactcommercial = rs.getString("contactcommercial");
                System.out.println(id + "\t\t" + companyname
                        + "\t\t" + contactcommercial);
            }
        }

        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
    }
}
